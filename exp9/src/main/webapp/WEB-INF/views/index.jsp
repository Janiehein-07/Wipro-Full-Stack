<!DOCTYPE html>
<html>

<head>
    <title>Student Management</title>
</head>

<body>

<h1>Student Management System</h1>

<h2>Add Student</h2>

<form action="${pageContext.request.contextPath}/students/add"
      method="post">

    Register Number:
    <input type="number" name="regno" required>

    <br><br>

    Name:
    <input type="text" name="name" required>

    <br><br>

    CGPA:
    <input type="number"
           name="cgpa"
           step="0.01"
           min="0"
           max="10"
           required>

    <br><br>

    <input type="submit" value="Add Student">

</form>

<br>

<a href="${pageContext.request.contextPath}/students/list">
    View All Students
</a>

<br><br>

<h2>Search Student</h2>

<form action="${pageContext.request.contextPath}/students/search"
      method="get">

    Register Number:
    <input type="number" name="regno" required>

    <input type="submit" value="Search">

</form>

</body>

</html>