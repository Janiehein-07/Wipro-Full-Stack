<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student List</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f2f4f8;
            margin: 30px;
        }

        .container {
            max-width: 1000px;
            margin: auto;
            background: white;
            padding: 25px;
            border-radius: 10px;
            box-shadow: 0 0 10px #ccc;
        }

        h2 {
            text-align: center;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 12px;
            text-align: center;
        }

        th {
            background: #343a40;
            color: white;
        }

        tr:nth-child(even) {
            background: #f2f2f2;
        }

        .edit {
            background: #28a745;
            color: white;
            padding: 8px 12px;
            text-decoration: none;
            border-radius: 4px;
        }

        .delete {
            background: #dc3545;
            color: white;
            padding: 8px 12px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        .add {
            display: inline-block;
            margin-top: 20px;
            padding: 12px 18px;
            background: #007bff;
            color: white;
            text-decoration: none;
            border-radius: 5px;
        }

        .message {
            color: green;
        }

        .error {
            color: red;
        }

        .search {
            margin-top: 20px;
        }

        .search input {
            padding: 10px;
        }

        .search button {
            padding: 10px;
            cursor: pointer;
        }
    </style>
</head>

<body>

<div class="container">

    <h2>Student Management System</h2>

    <c:if test="${not empty message}">
        <p class="message"><c:out value="${message}"/></p>
    </c:if>

    <c:if test="${not empty error}">
        <p class="error"><c:out value="${error}"/></p>
    </c:if>

    <!-- Search -->
    <form class="search"
          action="${pageContext.request.contextPath}/students/search"
          method="get">

        <input type="text"
               name="name"
               placeholder="Search by student name"
               value="<c:out value='${searchName}'/>">

        <button type="submit">Search</button>

        <a href="${pageContext.request.contextPath}/students">
            Show All
        </a>

    </form>

    <!-- Student table -->
    <table>

        <thead>
            <tr>
                <th>Register Number</th>
                <th>Name</th>
                <th>CGPA</th>
                <th>Edit / Update</th>
                <th>Delete</th>
            </tr>
        </thead>

        <tbody>

            <c:forEach var="student" items="${students}">

                <tr>
                    <td><c:out value="${student.regno}"/></td>
                    <td><c:out value="${student.name}"/></td>
                    <td><c:out value="${student.cgpa}"/></td>

                    <td>
                        <a class="edit"
                           href="${pageContext.request.contextPath}/students/edit/${student.regno}">
                            Edit
                        </a>
                    </td>

                    <td>
                        <form action="${pageContext.request.contextPath}/students/delete"
                              method="post"
                              style="display:inline"
                              onsubmit="return confirm('Are you sure you want to delete this student?');">

                            <input type="hidden"
                                   name="regno"
                                   value="${student.regno}">

                            <button class="delete" type="submit">
                                Delete
                            </button>

                        </form>
                    </td>
                </tr>

            </c:forEach>

            <c:if test="${empty students}">
                <tr>
                    <td colspan="5">No students found.</td>
                </tr>
            </c:if>

        </tbody>

    </table>

    <a class="add"
       href="${pageContext.request.contextPath}/students/new">
        + Add New Student
    </a>

</div>

</body>
</html>