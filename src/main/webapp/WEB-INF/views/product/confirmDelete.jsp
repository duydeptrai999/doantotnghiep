<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<html>
<head>
    <title>Xác nhận xóa</title>
</head>
<body>
<h1>Xóa sản phẩm</h1>
<p>Bạn có chắc chắn muốn xóa sản phẩm <strong>${product.name}</strong> không?</p>

<a href="/products/delete/${product.id}">Xác nhận</a> |
<a href="/products">Hủy</a>
</body>
</html>
