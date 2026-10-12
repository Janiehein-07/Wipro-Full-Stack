<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Form</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f2f4f8;
            padding: 40px;
        }

        .container {
            width: 400px;
            margin: auto;
            background: white;
            padding: 25px;
            border-radius: 10px;
            box-shadow: 0 0 10px #ccc;
        }

        h2 {
            text-align: center;
        }

        label {
            display: block;
            margin-top: 15px;
        }

        input {
            width: 100%;
            box-sizing: border-box;
            padding: 10px;
            margin-top: 5px;
        }

        button {
            width: 100%;
            padding: 12px;
            margin-top: 20px;
            background: #007bff;
            color: white;
            border: none;
            cursor: pointer;
        }

        .error {
            color: red;
        }

        a {
            display: block;
            text-align: center;
            margin-top: 20px;
        }
    </style>
</head>

<body>

<div class="container">

    <h2>
        <c:choose>
            <c:when test="${editMode}">
                Edit Student
            </c:when>
            <c:otherwise>
                Add Student
            </c:otherwise>
        </c:choose>
    </h2>

    <c:if test="${not empty error}">
        <p class="error"><c:out value="${error}"/></p>
    </c:if>

    <form action="${pageContext.request.contextPath}${editMode ? '/students/update' : '/students/save'}"
          method="post">

        <label>Register Number:</label>

        <input type="number"
               name="regno"
               value="${student.regno}"
               min="1"
               required
               <c:if test="${editMode}">readonly</c:if>>

        <label>Student Name:</label>

        <input type="text"
               name="name"
               value="<c:out value='${student.name}'/>"
               maxlength="100"
               required>

        <label>CGPA:</label>

        <input type="number"
               name="cgpa"
               value="${student.cgpa}"
               min="0"
               max="10"
               step="0.01"
               required>

        <button type="submit">
            <c:choose>
                <c:when test="${editMode}">
                    Update Student
                </c:when>
                <c:otherwise>
                    Save Student
                </c:otherwise>
            </c:choose>
        </button>

    </form>

    <a href="${pageContext.request.contextPath}/students">
        Back to Student List
    </a>

</div>

</body>
</html>