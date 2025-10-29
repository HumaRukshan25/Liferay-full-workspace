<%@ include file="/init.jsp" %>

<div class="citizen-dashboard">
    <h1>Citizen Dashboard</h1>

    <style>
    /* Scoped CSS only for this JSP */
    .citizen-dashboard {
        font-family: Arial, sans-serif;
        color: #333;
        margin: 20px;
    }

    /* Heading */
    .citizen-dashboard h1 {
        color: #2c3e50;
        margin-bottom: 15px;
    }

    /* Dashboard list container */
    .citizen-dashboard ul {
        list-style: none;
        padding: 20px;
        margin: 0;
        max-width: 600px;
        background-color: #fff;
        border-radius: 10px;
        box-shadow: 0 4px 8px rgba(0,0,0,0.1);
    }

    /* List items */
    .citizen-dashboard ul li {
        margin-bottom: 15px;
    }

    /* Links styling */
    .citizen-dashboard ul li a {
        text-decoration: none;
        color: #fff;
        background-color: #007bff;
        padding: 10px 15px;
        border-radius: 5px;
        display: inline-block;
        transition: background-color 0.3s ease;
        font-weight: bold;
    }

    .citizen-dashboard ul li a:hover {
        background-color: #0056b3;
    }

    /* Logout button emphasis */
    .citizen-dashboard ul li:last-child a,
    .citizen-dashboard ul li:last-child aui\\:button {
        background-color: #e74c3c;
        color: #fff;
        border: none;
        cursor: pointer;
    }

    .citizen-dashboard ul li:last-child a:hover,
    .citizen-dashboard ul li:last-child aui\\:button:hover {
        background-color: #c0392b;
    }

    /* Responsive adjustments */
    @media (max-width: 768px) {
        .citizen-dashboard ul {
            padding: 15px;
            max-width: 100%;
        }

        .citizen-dashboard ul li a {
            display: block;
            width: 100%;
            text-align: center;
        }
    }
    </style>

    <ul>
        <li>
            <portlet:renderURL var="fileFIRURL">
                <portlet:param name="mvcRenderCommandName" value="/citizen/fileFIR" />
            </portlet:renderURL>
            <a href="${fileFIRURL}">File New FIR</a>
        </li>

        <li>
            <portlet:renderURL var="trackFIRURL">
                <portlet:param name="mvcRenderCommandName" value="/citizen/trackFIR" />
            </portlet:renderURL>
            <a href="${trackFIRURL}">Track FIR Status</a>
        </li>

        <li>
           <aui:button type="button" value="Logout" onClick="location.href='/c/portal/logout';" />
        </li>
    </ul>
</div>
