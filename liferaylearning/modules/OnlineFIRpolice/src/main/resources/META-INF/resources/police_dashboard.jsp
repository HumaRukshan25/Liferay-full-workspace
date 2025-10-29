<%@ include file="/init.jsp" %>

<div class="police-dashboard">
    <h1>Police Dashboard</h1>

    <ul>
        <li>
            <portlet:renderURL var="fileFIRURL">
                <portlet:param name="mvcRenderCommandName" value="/police/fileFIR" />
            </portlet:renderURL>
            <a href="${fileFIRURL}">File FIR on Behalf of Citizen</a>
        </li>

        <li>
            <portlet:renderURL var="viewAssignedFIRsURL">
                <portlet:param name="mvcRenderCommandName" value="/police/viewAssignedFIRs" />
            </portlet:renderURL>
            <a href="${viewAssignedFIRsURL}">View Assigned FIRs</a>
        </li>

        <li>
            <aui:button type="button" value="Logout" onClick="location.href='/c/portal/logout';" />
        </li>
    </ul>
</div>

<style>
/* ===== Scoped CSS for Police Dashboard ===== */
.police-dashboard {
    font-family: Arial, sans-serif;
    background-color: #f4f6f9;
    color: #333;
    margin: 20px;
    padding: 20px;
    border-radius: 10px;
}

/* Heading */
.police-dashboard h1 {
    color: #2c3e50;
    margin-bottom: 20px;
    text-align: center;
}

/* Container list */
.police-dashboard ul {
    list-style: none;
    padding: 20px;
    margin: 0 auto;
    max-width: 600px;
    background-color: #fff;
    border-radius: 10px;
    box-shadow: 0 4px 8px rgba(0,0,0,0.1);
}

/* Items */
.police-dashboard ul li {
    margin-bottom: 15px;
    text-align: center;
}

/* Links */
.police-dashboard ul li a {
    text-decoration: none;
    color: #fff;
    background-color: #007bff;
    padding: 10px 18px;
    border-radius: 5px;
    display: inline-block;
    transition: background-color 0.3s ease;
    font-weight: bold;
    width: 80%;
}

.police-dashboard ul li a:hover {
    background-color: #0056b3;
}

/* Logout button (scoped) */
.police-dashboard aui\\:button {
    background-color: #e74c3c !important;
    color: #fff !important;
    border: none !important;
    padding: 10px 20px !important;
    border-radius: 5px !important;
    cursor: pointer;
    font-size: 16px !important;
    transition: background-color 0.3s ease;
}

.police-dashboard aui\\:button:hover {
    background-color: #c0392b !important;
}

/* Responsive */
@media (max-width: 768px) {
    .police-dashboard ul {
        padding: 15px;
        max-width: 100%;
    }

    .police-dashboard ul li a {
        display: block;
        width: 100%;
    }
}
</style>
