<%@ page import="com.example.entity.Student" %>

<%
Student student =
    (Student) request.getAttribute("student");
%>

<!DOCTYPE html>

<html>

<head>
    <title>Update Student</title>
</head>

<body>

<h1>Update Student</h1>

<form action="<%=request.getContextPath()%>/students/update"
      method="post">

    Register Number:

    <input type="number"
           name="regno"
           value="<%=student.getRegno()%>"
           readonly>

    <br><br>

    Name:

    <input type="text"
           name="name"
           value="<%=student.getName()%>"
           required>

    <br><br>

    CGPA:

    <input type="number"
           name="cgpa"
           value="<%=student.getCgpa()%>"
           step="0.01"
           min="0"
           max="10"
           required>

    <br><br>

    <input type="submit"
           value="Update Student">

</form>

<br>

<a href="<%=request.getContextPath()%>/students/list">
    Back
</a>

</body>

</html>