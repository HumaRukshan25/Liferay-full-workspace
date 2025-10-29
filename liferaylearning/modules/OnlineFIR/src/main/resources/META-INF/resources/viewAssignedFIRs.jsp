<%@ include file="/init.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<h2>FIRs Assigned to You (Officer-in-Chargee)</h2>

<!-- â Add this block here -->
<script>
    // Prevent the browser from going back to OTP or login when back is clicked
    window.history.replaceState(null, "", window.location.href);
</script>

<portlet:renderURL var="dashboardURL">
    <portlet:param name="mvcPath" value="/police_dashboard.jsp" />
</portlet:renderURL>

<button 
    style="background-color:#2196F3; color:white; padding:8px 15px; border:none; border-radius:5px; cursor:pointer; margin-bottom:10px;"
    onclick="location.href='${dashboardURL}'">
     Back to Dashboard
</button>
<!-- â End of added block -->

<style>
.scroll-container {
    max-height: 500px;
    overflow-y: auto;
    overflow-x: auto;
    border: 1px solid #ccc;
    margin-top: 15px;
    border-radius: 6px;
    width: 100%;
    display: block;
    white-space: nowrap;
}

/* Table styling */
table {
    display: inline-block;
    min-width: 1300px;
    border-collapse: collapse;
    font-family: Arial, sans-serif;
}
th, td {
    border: 1px solid #ddd;
    padding: 12px;
    text-align: left;
    vertical-align: top;
    white-space: normal;
}
th {
    background-color: #4CAF50;
    color: white;
    font-weight: bold;
}
tr:nth-child(even) { background-color: #f9f9f9; }
tr:hover { background-color: #f1f1f1; }

/* Action buttons */
.action-buttons {
    display: flex;
    flex-wrap: wrap;
    gap: 6px;
    justify-content: flex-start;
}

.action-buttons button {
    width: 110px !important;
    height: 36px !important;
    border: none;
    border-radius: 6px;
    cursor: pointer;
    color: white;
    font-size: 13px;
    text-align: center;
    line-height: 1.2;
    font-family: Arial, sans-serif;
    white-space: nowrap;
    overflow: hidden;
    text-overflow: ellipsis;
    transition: transform 0.1s ease-in-out, opacity 0.2s ease;
}
.action-buttons button:hover {
    opacity: 0.9;
    transform: scale(1.05);
}

button.accept { background-color: #4CAF50; }
button.reject { background-color: #f44336; }
button.close { background-color: #ff9800; }
button.resolve { background-color: #2196F3; }
button.progress { background-color: #9C27B0; }

/* Assign section */
.assign-section {
    display: flex;
    flex-direction: column;
    gap: 6px;
}
.assign-section select {
    padding: 5px;
    border-radius: 4px;
    border: 1px solid #ccc;
}
.assign-section button {
    align-self: flex-start;
}
</style>

<c:if test="${not empty matchedFIRs}">
    <div class="scroll-container">
        <table>
            <thead>
                <tr>
                    <th>FIR ID</th>
                    <th>Complainant</th>
                    <th>Incident Date</th>
                    <th>Details</th>
                    <th>Location</th>
                    <th>Status</th>
                    <th>Assigned Inspector</th>
                    <th>Assign Inspector</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="fir" items="${matchedFIRs}">
                    <tr>
                        <td>${fir.firId}</td>
                        <td>${fir.complainantName}</td>
                        <td><fmt:formatDate value="${fir.incidentDate}" pattern="dd-MM-yyyy HH:mm" /></td>
                        <td style="max-width:250px;">${fir.incidentDetails}</td>
                        <td>${fir.incidentLocation}</td>
                        <td>${fir.status}</td>

                        <!-- Show Assigned Inspector -->
                        <td>
                            <c:choose>
                                <c:when test="${not empty fir.assignedInspector}">
                                    ${fir.assignedInspector}
                                </c:when>
                                <c:otherwise>
                                    <span style="color:gray;">Not Assigned</span>
                                </c:otherwise>
                            </c:choose>
                        </td>

                        <td>
    <div class="assign-section">
        <portlet:actionURL name="/police/assignInspector" var="assignInspectorURL" />
        <aui:form action="${assignInspectorURL}" method="post">
            <aui:input type="hidden" name="firId" value="${fir.firId}" />

    
         
            <aui:select name="inspectorId" label="Select Inspector">
                <c:forEach var="inspector" items="${inspectors}">
                    <aui:option value="${inspector.userId}">
                        ${inspector.fullName}
                    </aui:option>
                </c:forEach>
            </aui:select>
        
            
         
            

            <aui:button type="submit" value="Assign" />
        </aui:form>
    </div>
</td>
                        

                        <!-- Action Buttons -->
                        <td>
                            <div class="action-buttons">
                                <portlet:actionURL name="/police/acceptFIR" var="acceptURL">
                                    <portlet:param name="firId" value="${fir.firId}" />
                                </portlet:actionURL>
                                <button class="accept" onclick="location.href='${acceptURL}'">Accept</button>

                                <portlet:actionURL name="/police/rejectFIR" var="rejectURL">
                                    <portlet:param name="firId" value="${fir.firId}" />
                                </portlet:actionURL>
                                <button class="reject" onclick="if(confirm('Reject this FIR?')) location.href='${rejectURL}'">Reject</button>

                                <portlet:actionURL name="/police/closeFIR" var="closeURL">
                                    <portlet:param name="firId" value="${fir.firId}" />
                                </portlet:actionURL>
                                <button class="close" onclick="if(confirm('Close this FIR?')) location.href='${closeURL}'">Close</button>

                                <portlet:actionURL name="/police/resolveFIR" var="resolveURL">
                                    <portlet:param name="firId" value="${fir.firId}" />
                                </portlet:actionURL>
                                <button class="resolve" onclick="location.href='${resolveURL}'">Resolve</button>

                                <portlet:actionURL name="/police/inProgressFIR" var="progressURL">
                                    <portlet:param name="firId" value="${fir.firId}" />
                                </portlet:actionURL>
                                <button class="progress" onclick="location.href='${progressURL}'">In Progress</button>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</c:if>

<c:if test="${empty matchedFIRs}">
    <p>No FIRs assigned to your station(s).</p>
</c:if>




<h5>for debugging</h5>

<!-- DEBUG SECTION - Add this -->
<div style="background: #fff3cd; border: 1px solid #ffeaa7; padding: 10px; margin: 10px 0; border-radius: 5px;">
    <h4 style="color: #856404; margin: 0 0 10px 0;">Debug Information:</h4>
    <p style="margin: 5px 0;"><strong>Inspectors List:</strong> 
        <c:choose>
            <c:when test="${empty inspectors}">EMPTY or NULL</c:when>
            <c:otherwise>${inspectors.size()} inspectors found</c:otherwise>
        </c:choose>
    </p>
    <p style="margin: 5px 0;"><strong>Matched FIRs:</strong> 
        <c:choose>
            <c:when test="${empty matchedFIRs}">EMPTY or NULL</c:when>
            <c:otherwise>${matchedFIRs.size()} FIRs found</c:otherwise>
        </c:choose>
    </p>
    <c:if test="${not empty inspectors}">
        <p style="margin: 5px 0;"><strong>Inspector Names:</strong></p>
        <ul style="margin: 5px 0; padding-left: 20px;">
            <c:forEach var="inspector" items="${inspectors}">
                <li>${inspector.fullName} (ID: ${inspector.userId})</li>
            </c:forEach>
        </ul>
    </c:if>
</div>
<!-- END DEBUG SECTION -->





