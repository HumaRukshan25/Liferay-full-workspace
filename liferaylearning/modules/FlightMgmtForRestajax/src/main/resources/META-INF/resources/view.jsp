<%@ include file="/init.jsp" %>

<style>
.flight-table {
    width: 100%;
    border-collapse: collapse;
    margin-top: 20px;
}

.flight-table th, .flight-table td {
    border: 1px solid #ddd;
    padding: 12px;
    text-align: left;
}

.flight-table th {
    background-color: #f2f2f2;
    font-weight: bold;
}

.btn {
    padding: 8px 16px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    text-decoration: none;
    display: inline-block;
    margin: 2px;
}

.btn-primary {
    background-color: #4CAF50;
    color: white;
}

.btn-secondary {
    background-color: #008CBA;
    color: white;
}

.btn-danger {
    background-color: #f44336;
    color: white;
}

.btn-warning {
    background-color: #ff9800;
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

.actions-column {
    width: 200px;
    text-align: center;
}

.confirm-dialog {
    display: none;
    position: fixed;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    background: white;
    padding: 20px;
    border: 1px solid #ccc;
    border-radius: 5px;
    box-shadow: 0 2px 10px rgba(0,0,0,0.1);
    z-index: 1000;
}

.dialog-overlay {
    display: none;
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background: rgba(0,0,0,0.5);
    z-index: 999;
}
</style>

<p><b>Flight Management System</b></p>

<!-- Navigation Button to Add Flight Page -->
<div style="margin-bottom: 20px;">
    <a href="<portlet:renderURL>
        <portlet:param name="mvcPath" value="/add-flight.jsp" />
    </portlet:renderURL>" 
    class="btn btn-primary">
        Add New Flight
    </a>
    
    <button type="button" id="refreshBtn" class="btn btn-secondary">
        Refresh List
    </button>
</div>

<!-- Message Display -->
<div id="messageContainer"></div>

<!-- Loading Indicator -->
<div id="loading" class="loading">
    <p><i class="icon-spinner icon-spin"></i> Loading, please wait...</p>
</div>

<!-- Flight List -->
<div id="flightList">
    <h3>Flight List</h3>
    <div id="flightListContent"></div>
</div>

<!-- Confirmation Dialog -->
<div id="dialogOverlay" class="dialog-overlay"></div>
<div id="confirmDialog" class="confirm-dialog">
    <h4>Confirm Delete</h4>
    <p>Are you sure you want to delete flight <span id="flightToDelete"></span>?</p>
    <div style="text-align: right; margin-top: 20px;">
        <button id="confirmDeleteBtn" class="btn btn-danger">Delete</button>
        <button id="cancelDeleteBtn" class="btn btn-secondary">Cancel</button>
    </div>
</div>

<script>
var flightToDeleteId = null;
var flightToDeleteNumber = null;

$(document).ready(function(){
    loadFlights();
    
    $('#refreshBtn').click(function(){
        loadFlights();
    });
    
    $('#confirmDeleteBtn').click(function(){
        if (flightToDeleteId) {
            deleteFlight(flightToDeleteId);
        }
        hideConfirmDialog();
    });
    
    $('#cancelDeleteBtn').click(function(){
        hideConfirmDialog();
    });
});

function loadFlights() {
    $('#loading').show();
    $('#flightListContent').html('');
    
    $.ajax({
        url: '<portlet:resourceURL />',
        type: 'GET',
        dataType: 'json',
        success: function(data) {
            console.log("Full API response:", data);
            displayFlights(data);
        },
        error: function(err) {
            console.error("Error loading flights:", err);
            showMessage('Failed to load flights.', 'error');
        },
        complete: function() {
            $('#loading').hide();
        }
    });
}

function displayFlights(data) {
    let html = "";
    
    if (data && data.items && data.items.length > 0) {
        console.log("First flight object:", data.items[0]);
        
        html += "<table class='flight-table'>";
        html += "<thead>";
        html += "<tr>";
        html += "<th>Flight ID</th>";
        html += "<th>Flight Number</th>";
        html += "<th>Airline</th>";
        html += "<th>Route</th>";
        html += "<th>Seats</th>";
        html += "<th>Price</th>";
        html += "<th class='actions-column'>Actions</th>";
        html += "</tr>";
        html += "</thead>";
        html += "<tbody>";
        
        data.items.forEach(function(flight){
            const flightId = flight.flightId || flight.id;
            
            html += "<tr id='flight-" + flightId + "'>";
            html += "<td><small>" + flightId + "</small></td>";
            html += "<td><b>" + (flight.flightNumber || 'N/A') + "</b></td>";
            html += "<td>" + (flight.airline || 'N/A') + "</td>";
            html += "<td>" + (flight.departureAirport || 'N/A') + " → " + (flight.arrivalAirport || 'N/A') + "</td>";
            html += "<td>" + (flight.availableSeats || 0) + "</td>";
            html += "<td>$" + (flight.price || 0) + "</td>";
            html += "<td class='actions-column'>";
            
            if (flightId) {
                // Create edit URL using string concatenation to avoid quote issues
                var editUrl = '<portlet:renderURL><portlet:param name="mvcPath" value="/edit-flight.jsp" /></portlet:renderURL>';
                editUrl += '&flightId=' + flightId;
                
                html += '<a href="' + editUrl + '" class="btn btn-warning" title="Edit Flight">';
                html += 'Edit';
                html += '</a>';
                
                // Delete button
                html += '<button onclick="showDeleteConfirm(' + flightId + ', \'' + (flight.flightNumber || 'Unknown').replace(/'/g, "\\'") + '\')" class="btn btn-danger" title="Delete Flight">';
                html += 'Delete';
                html += '</button>';
            } else {
                html += '<button disabled class="btn btn-warning" title="No ID available">Edit</button>';
                html += '<button disabled class="btn btn-danger" title="No ID available">Delete</button>';
            }
            
            html += "</td>";
            html += "</tr>";
        });
        html += "</tbody>";
        html += "</table>";
    } else {
        html = "<p>No flights found.</p>";
    }
    $("#flightListContent").html(html);
}

function showDeleteConfirm(flightId, flightNumber) {
    flightToDeleteId = flightId;
    flightToDeleteNumber = flightNumber;
    $('#flightToDelete').text(flightNumber + " (ID: " + flightId + ")");
    $('#confirmDialog').show();
    $('#dialogOverlay').show();
}

function hideConfirmDialog() {
    flightToDeleteId = null;
    flightToDeleteNumber = null;
    $('#confirmDialog').hide();
    $('#dialogOverlay').hide();
}

function deleteFlight(flightId) {
    $('#loading').show();
    console.log("Deleting flight with ID:", flightId);
    
    $.ajax({
        url: '/o/Flightheadlessapirest/v1.0/flights/' + flightId,
        type: 'DELETE',
        headers: {
            'X-CSRF-Token': Liferay.authToken,
            'Content-Type': 'application/json'
        },
        success: function(response) {
            console.log("Delete successful, response:", response);
            showMessage('Flight deleted successfully!', 'success');
            $('#flight-' + flightId).fadeOut(300, function() {
                $(this).remove();
            });
        },
        error: function(xhr, status, error) {
            console.error("Error deleting flight:", xhr);
            var errorMsg = 'Failed to delete flight. ';
            
            if (xhr.status === 404) {
                errorMsg += 'Flight not found (404).';
            } else if (xhr.status === 403) {
                errorMsg += 'Permission denied (403).';
            } else if (xhr.status === 401) {
                errorMsg += 'Unauthorized (401).';
            } else if (xhr.responseJSON && xhr.responseJSON.title) {
                errorMsg += xhr.responseJSON.title;
            } else if (xhr.statusText) {
                errorMsg += 'Status: ' + xhr.status + ' - ' + xhr.statusText;
            } else {
                errorMsg += 'Please try again.';
            }
            
            showMessage(errorMsg, 'error');
        },
        complete: function() {
            $('#loading').hide();
        }
    });
}

function showMessage(message, type) {
    var messageClass = type === 'success' ? 'success' : 'error';
    var messageHtml = '<div class="message ' + messageClass + '">' + message + '</div>';
    $('#messageContainer').html(messageHtml);
    
    if (type === 'success') {
        setTimeout(function() {
            $('#messageContainer').empty();
        }, 3000);
    }
}
</script>