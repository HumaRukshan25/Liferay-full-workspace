<%@ include file="/init.jsp" %>

<style>
.edit-flight-form {
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

.btn-warning {
    background-color: #ff9800;
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

.flight-info {
    background-color: #e7f3ff;
    padding: 15px;
    border-radius: 5px;
    margin-bottom: 20px;
    border-left: 4px solid #2196F3;
}
</style>

<div class="edit-flight-form">
    <h2 style="text-align: center; color: #333; margin-bottom: 20px;">Edit Flight</h2>
    
    <!-- Back to List Button -->
    <div style="margin-bottom: 20px;">
        <a href="<portlet:renderURL>
            <portlet:param name="mvcPath" value="/view.jsp" />
        </portlet:renderURL>" 
        class="btn btn-secondary">
            ← Back to Flight List
        </a>
    </div>
    
    <!-- Flight Info Display -->
    <div id="flightInfo" class="flight-info">
        <p><strong>Loading flight information...</strong></p>
    </div>
    
    <!-- Message Display -->
    <div id="messageContainer"></div>
    
    <!-- Loading Indicator -->
    <div id="loading" class="loading">
        <p><i class="icon-spinner icon-spin"></i> Processing, please wait...</p>
    </div>
    
    <!-- Edit Flight Form -->
    <form id="editFlightForm">
        <input type="hidden" id="flightId" name="flightId">
        
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
            <button type="submit" class="btn btn-warning" id="updateFlightBtn">
                Update Flight
            </button>
            <button type="reset" class="btn btn-danger">
                Reset Form
            </button>
        </div>
    </form>
</div>

<script>
// Get URL parameter
function getUrlParameter(name) {
    name = name.replace(/[\[]/, '\\[').replace(/[\]]/, '\\]');
    var regex = new RegExp('[\\?&]' + name + '=([^&#]*)');
    var results = regex.exec(location.search);
    return results === null ? '' : decodeURIComponent(results[1].replace(/\+/g, ' '));
}

// Get CSRF token from Liferay
function getCSRFToken() {
    return Liferay.authToken;
}

$(document).ready(function(){
    var flightId = getUrlParameter('flightId');
    
    if (flightId) {
        loadFlightData(flightId);
    } else {
        showMessage('No flight ID provided.', 'error');
        $('#editFlightForm').hide();
    }
    
    // Form submission handler
    $('#editFlightForm').submit(function(e){
        e.preventDefault();
        updateFlight();
    });
});

function loadFlightData(flightId) {
    $('#loading').show();
    $('#flightId').val(flightId);
    
    // Load flight data from REST API
    $.ajax({
        url: '/o/Flightheadlessapirest/v1.0/flights/' + flightId,
        type: 'GET',
        headers: {
            'X-CSRF-Token': getCSRFToken()
        },
        success: function(flight) {
            console.log("Flight data loaded:", flight);
            
            // Update flight info display
            $('#flightInfo').html(
                '<h4>Editing Flight: ' + (flight.flightNumber || 'N/A') + '</h4>' +
                '<p><strong>Airline:</strong> ' + (flight.airline || 'N/A') + '</p>' +
                '<p><strong>Route:</strong> ' + (flight.departureAirport || 'N/A') + ' → ' + (flight.arrivalAirport || 'N/A') + '</p>' +
                '<p><strong>Current Seats:</strong> ' + (flight.availableSeats || 0) + '</p>' +
                '<p><strong>Current Price:</strong> $' + (flight.price || 0) + '</p>'
            );
            
            // Populate form with flight data
            $('#flightNumber').val(flight.flightNumber || '');
            $('#airline').val(flight.airline || '');
            $('#departureAirport').val(flight.departureAirport || '');
            $('#arrivalAirport').val(flight.arrivalAirport || '');
            $('#availableSeats').val(flight.availableSeats || '');
            $('#price').val(flight.price || '');
            
            $('#editFlightForm').show();
        },
        error: function(xhr, status, error) {
            console.error("Error loading flight data:", xhr);
            var errorMsg = 'Failed to load flight data. ';
            
            if (xhr.status === 404) {
                errorMsg += 'Flight not found (404).';
            } else if (xhr.status === 403) {
                errorMsg += 'Permission denied (403).';
            } else {
                errorMsg += 'Please try again.';
            }
            
            showMessage(errorMsg, 'error');
            $('#editFlightForm').hide();
        },
        complete: function() {
            $('#loading').hide();
        }
    });
}

function updateFlight() {
    var flightId = $('#flightId').val();
    var flightData = {
        flightNumber: $('#flightNumber').val().trim(),
        airline: $('#airline').val().trim(),
        departureAirport: $('#departureAirport').val().trim(),
        arrivalAirport: $('#arrivalAirport').val().trim(),
        availableSeats: parseInt($('#availableSeats').val()),
        price: parseFloat($('#price').val()),
        flightId: parseInt(flightId)
    };
    
    // Validation
    if (!validateForm(flightData)) {
        return;
    }
    
    $('#loading').show();
    $('#updateFlightBtn').prop('disabled', true).text('Updating...');
    clearMessage();
    
    // Direct REST API call for update
    $.ajax({
        url: '/o/Flightheadlessapirest/v1.0/flights/' + flightId,
        type: 'PUT',
        contentType: 'application/json',
        headers: {
            'X-CSRF-Token': getCSRFToken()
        },
        data: JSON.stringify(flightData),
        success: function(response) {
            console.log("Update successful, response:", response);
            showMessage('Flight updated successfully!', 'success');
            
            // Redirect back to list after success
            setTimeout(function() {
                window.location.href = '<portlet:renderURL><portlet:param name="mvcPath" value="/view.jsp" /></portlet:renderURL>';
            }, 2000);
        },
        error: function(xhr, status, error) {
            console.error("Error updating flight:", xhr);
            var errorMessage = 'Failed to update flight. ';
            
            if (xhr.responseJSON) {
                if (xhr.responseJSON.title) {
                    errorMessage += xhr.responseJSON.title;
                } else if (xhr.responseJSON.detail) {
                    errorMessage += xhr.responseJSON.detail;
                } else {
                    errorMessage += JSON.stringify(xhr.responseJSON);
                }
            } else if (xhr.status === 404) {
                errorMessage += 'Flight not found.';
            } else if (xhr.status === 403) {
                errorMessage += 'Permission denied.';
            } else if (xhr.status === 401) {
                errorMessage += 'Unauthorized.';
            } else {
                errorMessage += 'Status: ' + xhr.status + ' - ' + error;
            }
            
            showMessage(errorMessage, 'error');
        },
        complete: function() {
            $('#loading').hide();
            $('#updateFlightBtn').prop('disabled', false).text('Update Flight');
        }
    });
}

function validateForm(data) {
    clearMessage();
    
    if (!data.flightNumber || !data.airline || !data.departureAirport || 
        !data.arrivalAirport || !data.availableSeats || !data.price) {
        showMessage('Please fill in all required fields.', 'error');
        return false;
    }
    
    if (data.availableSeats < 1 || isNaN(data.availableSeats)) {
        showMessage('Available seats must be a valid number greater than 0.', 'error');
        return false;
    }
    
    if (data.price < 0 || isNaN(data.price)) {
        showMessage('Price must be a valid number greater than or equal to 0.', 'error');
        return false;
    }
    
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
</script>