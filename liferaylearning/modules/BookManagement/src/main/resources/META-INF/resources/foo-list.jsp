<%@page import="java.util.List"%>
<%@page import="com.ats.books.model.Books"%>
<%@ include file="/init.jsp" %>
<!-- USED RESOURCE URL -->
<portlet:resourceURL id="getFoos" var="getFoosURL" />
<portlet:resourceURL id="addFoo" var="addFooURL" />
<portlet:resourceURL id="editFoo" var="editFooURL" />
<portlet:resourceURL id="deleteFoo" var="deleteFooURL" />

<h2>Foo Recordsss</h2>

<style>
  #fooTableBody td {
    color: black !important;
    font-weight: 500;
  }

  #fooTableBody tr {
    background-color: white !important;
  }

  table.table {
    color: black !important;
  }
</style>

<!--  Add Foo Button -->
<button class="btn btn-primary" onclick="openAddModal()">Add Foo</button><br/><br/>


<label for="sortColumn">Sort by:</label>
<select id="sortColumn" onchange="sortBySelectedColumn()" >
  <option value="">-- Select Column --</option>
  <option value="0">Foo ID</option>
  <option value="1">User Name</option>
  <option value="2">Group ID</option>
  <option value="3">Company ID</option>
  <option value="4">User ID</option>
  <option value="5">Create Date</option>
  <option value="6">Modified Date</option>
</select>

<!-- --------------------- -->




<!--  Foo Table -->
<table class="table table-bordered" id="fooTable">
   <!-- 
    <thead>
        <tr>
            <th>Foo ID</th>
            <th>User Name</th>
            <th>Group ID</th>
            <th>Company ID</th>
            <th>User ID</th>
            <th>Create Date</th>
          <th>Modified Date</th> 
            <th>Actions</th>
        </tr>
    </thead>
    -->
    
    <thead>
  <tr>
    <th onclick="sortTable(0)">Foo ID</th>
    <th onclick="sortTable(1)">User Name</th>
    <th onclick="sortTable(2)">Group ID</th>
    <th onclick="sortTable(3)">Company ID</th>
    <th onclick="sortTable(4)">User ID</th>
    <th onclick="sortTable(5)">Create Date</th>
    <th onclick="sortTable(6)">Modified Date</th>
    <th>Actions</th>
  </tr>
</thead>
    
   
     <tbody id="fooTableBody">
    <!-- Rows will be injected here -->
  </tbody>
  
</table>


<!-- Add Foo Modal -->
<div id="addModal" style="display:none; position:fixed; background:white; padding:20px; border:1px solid gray; top:10%; left:30%; z-index:999;">
    <h4>Add Foo</h4>
    <label>User Name:</label>
    <input type="text" id="addUserName" class="form-control" /><br/>
    <label>Group ID:</label>
    <input type="number" id="addGroupId" class="form-control" /><br/>
    <label>Company ID:</label>
    <input type="number" id="addCompanyId" class="form-control" /><br/>
    <label>User ID:</label>
    <input type="number" id="addUserId" class="form-control" /><br/>
    <button onclick="submitAdd()" class="btn btn-success">Add</button>
    <button onclick="closeAddModal()" class="btn btn-secondary">Cancel</button>
</div>

<!-- Edit Modal -->
<div id="editModal" style="display:none; position:fixed; background:white; padding:20px; border:1px solid gray; top:20%; left:30%; z-index:999;">
    <h4>Edit Foo</h4>
    <input type="hidden" id="editFooId" />
    <label>User Name:</label>
    <input type="text" id="editUserName" class="form-control" /><br/>
    <label>Group ID:</label>
    <input type="number" id="editGroupId" class="form-control" /><br/>
    <label>Company ID:</label>
    <input type="number" id="editCompanyId" class="form-control" /><br/>
    <label>User ID:</label>
    <input type="number" id="editUserId" class="form-control" /><br/>
    <button onclick="submitEdit()" class="btn btn-success">Save</button>
    <button onclick="closeEditModal()" class="btn btn-secondary">Cancel</button>
</div>


<!-- JavaScript Logic -->
<script>
    const getFoosURL = "<%= getFoosURL.toString() %>";
    const addFooURL = "<%= addFooURL.toString() %>";
    const editFooURL = "<%= editFooURL.toString() %>"
    const deleteFooURL = "<%= deleteFooURL.toString() %>";

  document.addEventListener("DOMContentLoaded", function () {
    loadFoos();
  });

    function loadFoos() {
        console.log("Calling getFoosURL:", getFoosURL);
        fetch(getFoosURL)
            .then(res => {
                console.log("Response status:", res.status);
                return res.json();
            })
            .then(data => {
                console.log("Received data.foos:", data.foos);

                const tbody = document.querySelector("#fooTableBody");
                tbody.innerHTML = ""; // ✅ Clear previous rows

                data.foos.forEach(foo => {
                    console.log("Appending Foo row:", foo);

                    const tr = document.createElement("tr");
                    tr.id = "row-" + foo.fooId;

                    const td1 = document.createElement("td");
                    td1.textContent = foo.fooId;

                    const td2 = document.createElement("td");
                    td2.textContent = foo.userName;

                    const td3 = document.createElement("td");
                    td3.textContent = foo.groupId;

                    const td4 = document.createElement("td");
                    td4.textContent = foo.companyId;

                    const td5 = document.createElement("td");
                    td5.textContent = foo.userId;

                    const td6 = document.createElement("td");
                    td6.textContent = foo.createDate;

                   const td7 = document.createElement("td");
                    td7.textContent = foo.modifiedDate;

                    const td8 = document.createElement("td");

                    const editBtn = document.createElement("button");
                    editBtn.className = "btn btn-warning btn-sm";
                    editBtn.textContent = "Edit";
                   
                    
                    editBtn.onclick = () => openEditModal(
                    	    foo.fooId, 
                    	    foo.userName, 
                    	    foo.groupId, 
                    	    foo.companyId, 
                    	    foo.userId
                    	);


                    const deleteBtn = document.createElement("button");
                    deleteBtn.className = "btn btn-danger btn-sm";
                    deleteBtn.textContent = "Delete";
                    deleteBtn.onclick = () => deleteFoo(foo.fooId);

                    td8.appendChild(editBtn);
                    td8.appendChild(deleteBtn);

                    tr.appendChild(td1);
                    tr.appendChild(td2);
                    tr.appendChild(td3);
                    tr.appendChild(td4);
                    tr.appendChild(td5);
                    tr.appendChild(td6);
                    tr.appendChild(td7);
                    tr.appendChild(td8);

                    tbody.appendChild(tr);
                });

            })
            .catch(error => {
                console.error("Error fetching foos:", error);
            });
    }
    

    //  Add Logic
    function openAddModal() {
        document.getElementById("addModal").style.display = "block";
    }
    function closeAddModal() {
        document.getElementById("addModal").style.display = "none";
    }
    function submitAdd() {
        const userName = document.getElementById("addUserName").value;
        const groupId = document.getElementById("addGroupId").value;
        const companyId = document.getElementById("addCompanyId").value;
        const userId = document.getElementById("addUserId").value;

        fetch(addFooURL, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({ userName, groupId, companyId, userId })
        }).then(response => {
            if (response.ok) {
                closeAddModal();
                loadFoos();
            } else {
                alert("Failed to add Foo");
            }
        });
    }

    //  Edit Logic
    
    
    function openEditModal(fooId, userName, groupId, companyId, userId) {
    document.getElementById("editFooId").value = fooId;
    document.getElementById("editUserName").value = userName;
    document.getElementById("editGroupId").value = groupId;
    document.getElementById("editCompanyId").value = companyId;
    document.getElementById("editUserId").value = userId;
    document.getElementById("editModal").style.display = "block";
}

   
    function closeEditModal() {
        document.getElementById("editModal").style.display = "none";
    }
   
    function submitEdit() {
        const fooId = document.getElementById("editFooId").value;
        const userName = document.getElementById("editUserName").value;
        const groupId = document.getElementById("editGroupId").value;
        const companyId = document.getElementById("editCompanyId").value;
        const userId = document.getElementById("editUserId").value;

        fetch(editFooURL, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({ fooId, userName, groupId, companyId, userId })
        }).then(response => {
            if (response.ok) {
                closeEditModal();
                loadFoos();
            } else {
                alert("Failed to update Foo");
            }
        });
    }


   // ✅ Delete Logic
   // function deleteFoo(fooId) {
     //   if (confirm("Are you sure you want to delete this Foo?")) {
       //     fetch(deleteFooURL + "&fooId=" + fooId, {
         //       method: "POST"
           // }).then(response => {
             //   if (response.ok) {
               //     document.getElementById("row-" + fooId).remove();
                //} else {
                  //  alert("Failed to delete Foo");
                //}
            //});
        //}
    //}
    function deleteFoo(fooId) {
    if (confirm("Are you sure you want to delete this Foo?")) {
        fetch(deleteFooURL, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({ fooId })  // ✅ send in body
        })
        .then(response => response.text())
        .then(text => {
            console.log("Server response:", text);
            if (text === "success") {
                document.getElementById("row-" + fooId)?.remove();
            } else {
                alert("❌ Failed to delete Foo: " + text);
            }
        })
        .catch(err => {
            console.error("❌ Error:", err);
        });
    }
}


    
   // document.addEventListener("DOMContentLoaded", function () {
        loadFoos();
     // });

   
   

       let sortDirections = {}; 

       function sortTable(columnIndex) {
           const table = document.getElementById("fooTable");
           const tbody = table.querySelector("tbody");
           const rows = Array.from(tbody.querySelectorAll("tr"));

         
           sortDirections[columnIndex] = !sortDirections[columnIndex]; // i have used for toogle
           const ascending = sortDirections[columnIndex];

           rows.sort((a, b) => {
               const cellA = a.children[columnIndex].innerText.trim();
               const cellB = b.children[columnIndex].innerText.trim();

            
               const valA = isNaN(cellA) ? cellA.toLowerCase() : parseFloat(cellA);
               const valB = isNaN(cellB) ? cellB.toLowerCase() : parseFloat(cellB);

               if (valA < valB) return ascending ? -1 : 1;
               if (valA > valB) return ascending ? 1 : -1;
               return 0;
           });

     
           rows.forEach(row => tbody.appendChild(row));
       }
       
     

       
       ///------------------->
 
 
  let currentSortDirection = {}; 
   function sortBySelectedColumn() {
       const dropdown = document.getElementById("sortColumn");
       const columnIndex = parseInt(dropdown.value);

       if (isNaN(columnIndex)) return;

       const table = document.getElementById("fooTable");
       const tbody = table.querySelector("tbody");
       const rows = Array.from(tbody.querySelectorAll("tr"));

       currentSortDirection[columnIndex] = !currentSortDirection[columnIndex];
       const ascending = currentSortDirection[columnIndex];

       rows.sort((rowA, rowB) => {
           const cellA = rowA.cells[columnIndex].innerText.trim();
           const cellB = rowB.cells[columnIndex].innerText.trim();

           const valA = isNaN(cellA) ? cellA.toLowerCase() : parseFloat(cellA);
           const valB = isNaN(cellB) ? cellB.toLowerCase() : parseFloat(cellB);

           if (valA < valB) return ascending ? -1 : 1;
           if (valA > valB) return ascending ? 1 : -1;
           return 0;
       });


       rows.forEach(row => tbody.appendChild(row));
   }
   
   
/*  */

   
  
</script>