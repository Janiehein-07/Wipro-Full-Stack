<%@ page import="com.example.entity.Student" %>

<!DOCTYPE html>

<html>

<head>
    <title>Search Result</title>
</head>

<body>

<h1>Search Result</h1>

<%

Student student =
    (Student) request.getAttribute("student");

if(student != null) {

%>

<p>
    <b>Register Number:</b>
    <%=student.getRegno()%>
</p>

<p>
    <b>Name:</b>
    <%=student.getName()%>
</p>

<p>
    <b>CGPA:</b>
    <%=student.getCgpa()%>
</p>

<%
} else {
%>

<p>Student not found.</p>

<%
}
%>

<br>

<a href="<%=request.getContextPath()%>/students">
    Home
</a>

<br><br>

<a href="<%=request.getContextPath()%>/students/list">
    View All Students
</a>

</body>

</html>