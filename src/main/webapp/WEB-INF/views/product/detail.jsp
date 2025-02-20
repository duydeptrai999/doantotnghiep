<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<html>
<head>
    <title>Chi tiết sản phẩm</title>
</head>
<body>
<h1>Chi tiết sản phẩm</h1>

<p><strong>ID:</strong> ${product.id}</p>
<p><strong>Tên sản phẩm:</strong> ${product.name}</p>
<p><strong>Mô tả:</strong> ${product.description}</p>
<p><strong>Mã sản phẩm:</strong> ${product.code}</p>
<p><strong>Danh mục:</strong> ${product.category.name}</p>
<p><strong>Thương hiệu:</strong> ${product.brand.name}</p>
<p><strong>Chất liệu:</strong> ${product.material.name}</p>
<p><strong>Trạng thái:</strong> ${product.status == 1 ? "Hoạt động" : "Không hoạt động"}</p>

<a href="/products">Quay lại danh sách</a>
</body>
</html>
