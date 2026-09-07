<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Product Entry Form</title>
</head>
<body>
    <h2>Product Inventory Entry Form</h2>
    <form action="server.jsp" method="post">
        <table border="0" cellpadding="5">
            <tr>
                <td><label for="productId">Product ID:</label></td>
                <td><input type="text" id="productId" name="productId" required></td>
            </tr>
            <tr>
                <td><label for="productName">Product Name:</label></td>
                <td><input type="text" id="productName" name="productName" required></td>
            </tr>
            <tr>
                <td><label for="unitPrice">Unit Price:</label></td>
                <td><input type="number" step="0.01" id="unitPrice" name="unitPrice" required></td>
            </tr>
            <tr>
                <td><label for="quantity">Quantity:</label></td>
                <td><input type="number" id="quantity" name="quantity" required></td>
            </tr>
            <tr>
                <td><label for="supplierName">Supplier Name:</label></td>
                <td><input type="text" id="supplierName" name="supplierName" required></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Submit">
                    <input type="reset" value="Reset">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>