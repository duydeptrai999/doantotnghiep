<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<html>
<head>
    <title>Danh sách sản phẩm</title>
</head>
<body>
<h1>Danh sách sản phẩm</h1>

<a href="${pageContext.request.contextPath}/products/new">Thêm sản phẩm mới</a>

<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Tên</th>
        <th>Mô tả</th>
        <th>Mã</th>
        <th>Danh mục</th>
        <th>Thương hiệu</th>
        <th>Chất liệu</th>
        <th>Trạng thái</th>
        <th>Hành động</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="product" items="${products.content}">
        <tr>
            <td>${product.id}</td>
            <td><a href="${product.id}">${product.name}</a></td>
            <td>${product.description}</td>
            <td>${product.code}</td>
            <td>${product.category.name}</td>
            <td>${product.brand.name}</td>
            <td>${product.material.name}</td>
            <td>${product.status == 1 ? "Hoạt động" : "Không hoạt động"}</td>
            <td>
                <a href="edit/${product.id}">Sửa</a> |
                <c:choose>
                    <c:when test="${product.status == 1}">
                        <a href="delete/${product.id}" onclick="return confirm('Xác nhận xóa?')">Xóa</a>
                    </c:when>
                    <c:otherwise>
                        <a href="activate/${product.id}">Kích hoạt</a>
                    </c:otherwise>
                </c:choose>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<!-- Phân trang -->
<div>
    <c:if test="${products.totalPages > 1}">
        <c:forEach var="i" begin="0" end="${products.totalPages - 1}">
            <a href="?page=${i}">${i + 1}</a>
        </c:forEach>
    </c:if>
</div>
</body>
</html>
