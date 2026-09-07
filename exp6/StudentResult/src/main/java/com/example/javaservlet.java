package com.example;


import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ResultServlet")
public class javaservlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // 1. Retrieve form parameters
        String regNo = request.getParameter("regNo");
        String name = request.getParameter("name");
        String dept = request.getParameter("dept");

        int m1 = Integer.parseInt(request.getParameter("m1"));
        int m2 = Integer.parseInt(request.getParameter("m2"));
        int m3 = Integer.parseInt(request.getParameter("m3"));
        int m4 = Integer.parseInt(request.getParameter("m4"));
        int m5 = Integer.parseInt(request.getParameter("m5"));
        double attendance = Double.parseDouble(request.getParameter("attendance"));

        // 2. Calculations & Pass/Fail status
        int total = m1 + m2 + m3 + m4 + m5;
        double average = total / 5.0;

        boolean isPassed = (m1 >= 40 && m2 >= 40 && m3 >= 40 && m4 >= 40 && m5 >= 40);
        String resultStatus = isPassed ? "PASS" : "FAIL";

        // 3. Grade assignment
        String grade;
        if (!isPassed) {
            grade = "F";
        } else if (average >= 90) {
            grade = "O (Outstanding)";
        } else if (average >= 80) {
            grade = "A+";
        } else if (average >= 70) {
            grade = "A";
        } else if (average >= 60) {
            grade = "B+";
        } else if (average >= 50) {
            grade = "B";
        } else {
            grade = "C";
        }

        // 4. Eligibility check (Minimum 75% attendance)
        String eligibility = (attendance >= 75.0) ? "Eligible" : "Not Eligible (Low Attendance)";

        // 5. Display HTML Output
        out.println("<html><head><title>Student Result</title></head><body>");
        out.println("<h2>Examination Result Summary</h2>");
        out.println("<table border='1' cellpadding='8' cellspacing='0'>");
        out.println("<tr><th>Register Number</th><td>" + regNo + "</td></tr>");
        out.println("<tr><th>Student Name</th><td>" + name + "</td></tr>");
        out.println("<tr><th>Department</th><td>" + dept + "</td></tr>");
        out.println("<tr><th>Total Marks</th><td>" + total + " / 500</td></tr>");
        out.println("<tr><th>Average Marks</th><td>" + String.format("%.2f", average) + "</td></tr>");
        out.println("<tr><th>Result Status</th><td>" + resultStatus + "</td></tr>");
        out.println("<tr><th>Grade</th><td>" + grade + "</td></tr>");
        out.println("<tr><th>Attendance Percentage</th><td>" + attendance + "%</td></tr>");
        out.println("<tr><th>Exam Eligibility</th><td>" + eligibility + "</td></tr>");
        out.println("</table>");
        out.println("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        doGet(request, response);
    }
}