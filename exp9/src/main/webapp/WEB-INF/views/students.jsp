<%@ page import="java.util.List" %>
<%@ page import="com.example.entity.Student" %>

<!DOCTYPE html>

<html>

<head>
    <title>Student List</title>
</head>

<body>

<h1>Student List</h1>

<table border="1" cellpadding="10">

<tr>
    <th>Register Number</th>
    <th>Name</th>
    <th>CGPA</th>
    <th>Actions</th>
</tr>

<%
List<Student> students =
    (List<Student>) request.getAttribute("students");

for(Student student : students) {
%>

<tr>

<td>
    <%= student.getRegno() %>
</td>

<td>
    <%= student.getName() %>
</td>

<td>
    <%= student.getCgpa() %>
</td>

<td>

<a href="<%=request.getContextPath()%>/students/edit/<%=student.getRegno()%>">
    Edit
</a>

&nbsp;

<a href="<%=request.getContextPath()%>/students/delete/<%=student.getRegno()%>"
   onclick="return confirm('Delete this student?')">
    Delete
</a>

</td>

</tr>

<%
}
%>

</table>

<br>

<a href="<%=request.getContextPath()%>/students">
    Home
</a>

</body>

</html>