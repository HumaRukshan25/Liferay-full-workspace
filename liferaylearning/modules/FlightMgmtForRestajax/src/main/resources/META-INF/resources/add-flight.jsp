<%@ include file="/init.jsp" %>

<style>
.flight-form {
    max-width: 600px;
    margin: 0 auto;
    padding: 20px;
    border: 1px solid #ddd;
    border-radius: 5px;
    background-color: #f9f9f9;
}

.form-group {
    margin-bottom: 15px;
}

.form-group label {
    display: block;
    margin-bottom: 5px;
    font-weight: bold;
}

.form-group input {
    width: 100%;
    padding: 8px;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
}

.form-actions {
    margin-top: 20px;
    text-align: center;
}

.btn {
    padding: 10px 20px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    text-decoration: none;
    display: inline-block;
    margin: 0 5px;
}

.btn-primary {
    background-color: #4CAF50;
    color: white;
}

.btn-secondary {
    background-color: #6c757d;
    color: white;
}

.btn-danger {
    background-color: #dc3545;
    color: white;
}

.message {
    padding: 10px;
    margin: 10px 0;
    border-radius: 4px;
    text-align: center;
}

.message.success {
    background-color: #d4edda;
    color: #155724;
    border: 1px solid #c3e6cb;
}

.message.error {
    background-color: #f8d7da;
    color: #721c24;
    border: 1px solid #f5c6cb;
}

.loading {
    display: none;
    text-align: center;
    margin: 10px 0;
    color: #007bff;
}
</style>

<div class="flight-form">
    <h2 style="text-align: center; color: #333; margin-bottom: 20px;">Add New Flight</h2>
    
    <!-- Back to List Button -->
    <div style="margin-bottom: 20px;">
        <a href="<portlet:renderURL>
            <portlet:param name="mvcPath" value="/view.jsp" />
        </portlet:renderURL>" 
        class="btn btn-secondary">
            ← Back to Flight List
        </a>
    </div>
    
    <!-- Message Display -->
    <div id="messageContainer"></div>
    
    <!-- Loading Indicator -->
    <div id="loading" class="loading">
        <p><i class="icon-spinner icon-spin"></i> Adding flight, please wait...</p>
    </div>
    
    <!-- Add Flight Form -->
    <form id="addFlightForm">
        <div class="form-group">
            <label for="flightNumber">Flight Number *</label>
            <input type="text" id="flightNumber" name="flightNumber" required 
                   placeholder="Enter flight number (e.g., FL123)">
        </div>
        
        <div class="form-group">
            <label for="airline">Airline *</label>
            <input type="text" id="airline" name="airline" required 
                   placeholder="Enter airline name">
        </div>
        
        <div class="form-group">
            <label for="departureAirport">Departure Airport *</label>
            <input type="text" id="departureAirport" name="departureAirport" required 
                   placeholder="Enter departure airport code (e.g., JFK)">
        </div>
        
        <div class="form-group">
            <label for="arrivalAirport">Arrival Airport *</label>
            <input type="text" id="arrivalAirport" name="arrivalAirport" required 
                   placeholder="Enter arrival airport code (e.g., LAX)">
        </div>
        
        <div class="form-group">
            <label for="availableSeats">Available Seats *</label>
            <input type="number" id="availableSeats" name="availableSeats" required 
                   min="1" max="1000" placeholder="Enter available seats">
        </div>
        
        <div class="form-group">
            <label for="price">Price ($) *</label>
            <input type="number" id="price" name="price" required 
                   step="0.01" min="0" placeholder="Enter price">
        </div>
        
        <div class="form-actions">
            <button type="submit" class="btn btn-primary" id="saveFlightBtn">
                Save Flight
            </button>
            <button type="reset" class="btn btn-danger">
                Clear Form
            </button>
        </div>
    </form>
</div>

<script>
// Get CSRF token from Liferay
function getCSRFToken() {
    return Liferay.authToken;
}

$(document).ready(function(){
    // Form submission handler
    $('#addFlightForm').submit(function(e){
        e.preventDefault();
        saveFlight();
    });
    
    // Enter key support
    $('#addFlightForm input').keypress(function(e){
        if(e.which == 13) { // Enter key
            e.preventDefault();
            saveFlight();
        }
    });
});

function saveFlight() {
    // Get form values
    var flightData = {
        flightNumber: $('#flightNumber').val().trim(),
        airline: $('#airline').val().trim(),
        departureAirport: $('#departureAirport').val().trim(),
        arrivalAirport: $('#arrivalAirport').val().trim(),
        availableSeats: parseInt($('#availableSeats').val()),
        price: parseFloat($('#price').val())
    };
    
    // Validation
    if (!validateForm(flightData)) {
        return;
    }
    
    // Show loading
    $('#loading').show();
    $('#saveFlightBtn').prop('disabled', true).text('Saving...');
    clearMessage();
    
    // Get CSRF token
    var csrfToken = getCSRFToken();
    
    console.log("Sending flight data:", flightData);
    console.log("CSRF Token:", csrfToken);
    
    // Direct REST API call to Swagger endpoint with proper headers
    $.ajax({
        url: '/o/Flightheadlessapirest/v1.0/flights',
        type: 'POST',
        contentType: 'application/json',
        headers: {
            'X-CSRF-Token': csrfToken
        },
        data: JSON.stringify(flightData),
        success: function(response) {
            console.log("Success response:", response);
            showMessage('Flight added successfully!', 'success');
            $('#addFlightForm')[0].reset();
            
            // Optional: Redirect back to list after success
            setTimeout(function() {
                window.location.href = '<portlet:renderURL><portlet:param name="mvcPath" value="/view.jsp" /></portlet:renderURL>';
            }, 2000);
        },
        error: function(xhr, status, error) {
            console.error("Error details:", xhr);
            var errorMessage = 'Failed to add flight. ';
            
            if (xhr.responseJSON) {
                if (xhr.responseJSON.title) {
                    errorMessage += xhr.responseJSON.title;
                } else if (xhr.responseJSON.detail) {
                    errorMessage += xhr.responseJSON.detail;
                } else {
                    errorMessage += JSON.stringify(xhr.responseJSON);
                }
            } else if (xhr.status === 0) {
                errorMessage += 'Network error or CORS issue.';
            } else if (xhr.status === 401) {
                errorMessage += 'Unauthorized - Please check your permissions.';
            } else if (xhr.status === 403) {
                errorMessage += 'Forbidden - CSRF token may be missing or invalid.';
            } else {
                errorMessage += 'Status: ' + xhr.status + ' - ' + error;
            }
            
            showMessage(errorMessage, 'error');
        },
        complete: function() {
            $('#loading').hide();
            $('#saveFlightBtn').prop('disabled', false).text('Save Flight');
        }
    });
}

function validateForm(data) {
    // Clear previous messages
    clearMessage();
    
    // Check required fields
    if (!data.flightNumber || !data.airline || !data.departureAirport || 
        !data.arrivalAirport || !data.availableSeats || !data.price) {
        showMessage('Please fill in all required fields.', 'error');
        return false;
    }
    
    // Validate numbers
    if (data.availableSeats < 1 || isNaN(data.availableSeats)) {
        showMessage('Available seats must be a valid number greater than 0.', 'error');
        return false;
    }
    
    if (data.price < 0 || isNaN(data.price)) {
        showMessage('Price must be a valid number greater than or equal to 0.', 'error');
        return false;
    }
    
    // Validate flight number format (alphanumeric)
    if (!/^[A-Za-z0-9]+$/.test(data.flightNumber)) {
        showMessage('Flight number should contain only letters and numbers.', 'error');
        return false;
    }
    
    return true;
}

function showMessage(message, type) {
    var messageClass = type === 'success' ? 'success' : 'error';
    var messageHtml = '<div class="message ' + messageClass + '">' + message + '</div>';
    $('#messageContainer').html(messageHtml);
}

function clearMessage() {
    $('#messageContainer').empty();
}

// Auto-hide success messages after 5 seconds
$(document).on('DOMNodeInserted', '#messageContainer .message.success', function() {
    var $this = $(this);
    setTimeout(function() {
        $this.fadeOut(300, function() {
            $this.remove();
        });
    }, 5000);
});
</script>