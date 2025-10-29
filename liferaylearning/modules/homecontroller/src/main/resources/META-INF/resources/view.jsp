<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.ats.courses.model.Courses"%>
<%@page import="java.util.List"%>
<%@ include file="./init.jsp"%>
<liferay-theme:defineObjects />
<portlet:defineObjects />

<%
    List<Courses> coursesList = (List<Courses>) renderRequest.getAttribute("coursesList");
    String selectedCourseType = (String) renderRequest.getAttribute("selectedCourseType");
    
    
    
   // all courses was not coming here if i use this String selectedCourseType = ParamUtil.getString(request, "coursesType", "All");
    String searchKeyword = ParamUtil.getString(request, "searchKeyword", "");
%>

<!-- Create the action URL for adding courses -->
<portlet:actionURL name="addCourses" var="addCoursesURL" />


<!-- Header Section (keep your existing header code) -->

<div class="dashboard-header">
    <button class="btn btn-primary add-course-btn" id="addCourseBtn">Add Course</button>
</div>



<portlet:actionURL name="ChooseCourseType" var="ChooseCourseTypeURL" />

<portlet:actionURL name="deleteCourse" var="deleteCourseURL" />




<!-- Include SweetAlert CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/sweetalert2@11/dist/sweetalert2.min.css">



<!-- Add these required Bootstrap JS files at the top of your JSP -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

<!-- Header Section -->


<div class="jumbotron jumbotron-fluid position-relative overlay-bottom"
    style="margin-bottom: 90px; background-color: #4b7bec;">
    <div class="container text-center my-5 py-5">
        <h1 class="text-white mt-4 mb-4">Learn From Home</h1>
        <h1 class="text-white display-1 mb-5">Education Courses</h1>
        <div class="mx-auto mb-5" style="width: 100%; max-width: 600px;">
            <portlet:actionURL var="searchActionURL" name="searchCourses" />
            <form action="${searchActionURL}" method="post" class="input-group">
                <div class="input-group-prepend">
                    <button
                        class="btn btn-outline-light bg-white text-body px-4 dropdown-toggle"
                        type="button" id="courseTypeDropdown" data-toggle="dropdown" 
                        aria-haspopup="true" aria-expanded="false">
                        <%= Validator.isNotNull(selectedCourseType) ? 
                            selectedCourseType.substring(0,1).toUpperCase() + selectedCourseType.substring(1) : 
                            "All Courses" %>
                            
                           
                    </button>
                                        
                    
                   <div class="dropdown-menu" aria-labelledby="courseTypeDropdown">
                       <portlet:renderURL var="allCoursesURL" />
						<a class="dropdown-item" href="<%= allCoursesURL %>">All
							Courses</a>

							
                        <portlet:renderURL var="basicCoursesURL">
                            <portlet:param name="coursesType" value="Basic" />
                            <portlet:param name="searchKeyword" value="${searchKeyword}" />
                        </portlet:renderURL>
                        <a class="dropdown-item" href="<%= basicCoursesURL %>">Basic Courses</a>

                        <portlet:renderURL var="intermediateCoursesURL">
                            <portlet:param name="coursesType" value="Intermediate" />
                            <portlet:param name="searchKeyword" value="${searchKeyword}" />
                        </portlet:renderURL>
                        <a class="dropdown-item" href="<%= intermediateCoursesURL %>">Intermediate Courses</a>

                        <portlet:renderURL var="advancedCoursesURL">
                            <portlet:param name="coursesType" value="Advanced" />
                            <portlet:param name="searchKeyword" value="${searchKeyword}" />
                        </portlet:renderURL>
                        <a class="dropdown-item" href="<%= advancedCoursesURL %>">Advanced Courses</a>
                    </div>
                   
                    
                    
                </div>
                <input type="text" name="<portlet:namespace />searchKeyword"
                    class="form-control border-light" style="padding: 30px 25px;"
                    placeholder="Search courses..."
                    value="<%= searchKeyword %>">
                <div class="input-group-append">
                    <button class="btn btn-secondary px-4 px-lg-5" type="submit">Search</button>
                </div>
            </form>
        </div>
    </div>
</div>



<!-- Add Course Modal -->
<div class="modal fade" id="addCourseModal" tabindex="-1" role="dialog"
    aria-labelledby="addCourseModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="addCourseModalLabel">Add New Course</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <liferay-ui:success key="course-added-success" message="Course added successfully!" />
                <liferay-ui:error key="course-added-error" message="Error adding course!" />
                
                <aui:form action="<%= addCoursesURL %>" method="post" enctype="multipart/form-data" name="addCourseForm">
                    <aui:input name="Courses_name" label="Course Name" required="true" />
                    <aui:input name="Courses_des" label="Course Description" type="textarea" />
                    <aui:select name="Courses_type" label="Course Type">
                        <aui:option value="Basic">Basic</aui:option>
                        <aui:option value="Intermediate">Intermediate</aui:option>
                        <aui:option value="Advanced">Advanced</aui:option>
                    </aui:select>
                    <aui:input name="Courses_rating" label="Course Rating" type="text" />
                    <aui:input name="Courses_img" label="Course Image" type="file" required="true" />
                </aui:form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary" 
                    onclick="submitForm('<portlet:namespace />addCourseForm')">Save Course</button>
            </div>
        </div>
    </div>
</div>

<!-- Your existing courses display section -->

<script>
    function submitForm(formId) {
        var form = document.getElementById(formId);
        var validator = Liferay.Form.get(formId).formValidator;
        
        validator.validate();
        
        if (!validator.hasErrors()) {
            form.submit();
        }
    }
    
    $(document).ready(function() {
        $('#addCourseBtn').click(function() {
            $('#addCourseModal').modal('show');
        });
    });
</script>





<!-- Courses Display Section -->
<div class="container">
	<div class="row">
		<% if (Validator.isNotNull(coursesList)) { 
            for (Courses course : coursesList) { %>
		<div class="col-md-4 mb-4 course-card">
			<div class="card h-100" style="cursor: pointer;"
				onclick="showCourseDetails(
                    '<%= course.getCourses_name() %>', 
                    '<%= course.getCourses_des().replace("'", "\\'") %>', 
                    '<%= course.getCourses_type() %>', 
                    '<%= course.getCourses_img() %>')">
				<img src="data:image/jpeg;base64,<%= course.getCourses_img() %>"
					class="card-img-top" alt="<%= course.getCourses_name() %>"
					style="height: 200px; object-fit: cover;">
				<div class="card-body">
					<h5 class="card-title"><%= course.getCourses_name() %></h5>
					<p class="card-text text-muted"><%= course.getCourses_des().length() > 100 ? 
                            course.getCourses_des().substring(0, 100) + "..." : course.getCourses_des() %></p>
					<span class="badge badge-primary"> <%= course.getCourses_type().substring(0,1).toUpperCase() + course.getCourses_type().substring(1) %>
					</span>
				</div>
			</div>
		</div>
		<% } 
        } else { %>
		<div class="col-12">
			<div class="alert alert-info text-center">
				No courses found
				<%= Validator.isNotNull(selectedCourseType) ? 
                        "for " + selectedCourseType + " category" : "" %>.
			</div>
		</div>
		<% } %>
	</div>
</div>





<!-- JavaScript Libraries -->
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>


<style>
h2.portlet-title-text.portlet-title-editable {
	display: none !important;
}

.portlet-content {
	padding: 0px !important;
}

.course-details-popup {
	max-width: 800px;
}

.swal2-popup .swal2-title {
	font-size: 1.8rem;
	margin-bottom: 1.5rem;
}

.swal2-popup .swal2-html-container {
	margin: 0;
}

.course-card {
	transition: all 0.3s ease;
	margin-bottom: 20px;
}

.course-card:hover {
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
	transform: translateY(-5px);
}

.course-img {
	height: 150px;
	object-fit: cover;
}

.add-course-btn {
	margin-bottom: 20px;
}

.dashboard-header {
	display: flex;
	justify-content: space-between;
	align-items: center;
	margin-bottom: 20px;
}

h2.portlet-title-text.portlet-title {
	display: none !important;
}

button#addCourseBtn {
	margin-left: 77%;
	background-color: black;
}

.jumbotron {
    background: linear-gradient(rgba(40, 120, 235, 0.9),
        rgba(40, 120, 235, 0.9)), url(<%= themeDisplay.getPathThemeImages() %>/header.jpg), no-repeat center
        center !important;
    background-size: cover;
}
</style>

<aui:script>
    AUI().ready(function () {
        // Use jQuery to bind the button to the modal
        $('#addCourseBtn').click(function () {
            $('#addCourseModal').modal('show');
        });
    });
</aui:script>