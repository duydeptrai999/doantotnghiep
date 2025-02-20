<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<html>
<head>
    <title>Chi tiết Sản phẩm</title>
</head>
<body>
<h1>Chi tiết Sản phẩm</h1>

<p><strong>ID:</strong> ${productDetail.id}</p>
<p><strong>Tên:</strong> ${productDetail.name}</p>
<p><strong>Mô tả:</strong> ${productDetail.description}</p>
<p><strong>Trạng thái:</strong> ${productDetail.status == 1 ? "Hoạt động" : "Không hoạt động"}</p>

<a href="${pageContext.request.contextPath}/product-details">Quay lại danh sách</a>
<a href="${pageContext.request.contextPath}/product-details/edit/${productDetail.id}">Sửa</a>

</body>
</html>
