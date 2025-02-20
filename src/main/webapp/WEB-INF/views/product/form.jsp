<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<html>
<head>
    <title>${formTitle}</title>
</head>
<body>
<h1>${formTitle}</h1>

<form action="${formAction}" method="post">
    <input type="hidden" name="id" value="${product.id}" />

    <label for="name">Tên sản phẩm:</label>
    <input type="text" id="name" name="name" value="${product.name}" required />
    <br/>

    <label for="description">Mô tả:</label>
    <input type="text" id="description" name="description" value="${product.description}" />
    <br/>

    <label for="code">Mã sản phẩm:</label>
    <input type="text" id="code" name="code" value="${product.code}" required />
    <br/>

    <label for="category">Danh mục:</label>
    <select id="category" name="category.id">
        <c:forEach var="category" items="${categories}">
            <option value="${category.id}" ${category.id == product.category.id ? 'selected' : ''}>${category.name}</option>
        </c:forEach>
    </select>
    <br/>

    <label for="brand">Thương hiệu:</label>
    <select id="brand" name="brand.id">
        <c:forEach var="brand" items="${brands}">
            <option value="${brand.id}" ${brand.id == product.brand.id ? 'selected' : ''}>${brand.name}</option>
        </c:forEach>
    </select>
    <br/>

    <label for="material">Chất liệu:</label>
    <select id="material" name="material.id">
        <c:forEach var="material" items="${materials}">
            <option value="${material.id}" ${material.id == product.material.id ? 'selected' : ''}>${material.name}</option>
        </c:forEach>
    </select>
    <br/>

    <label for="status">Trạng thái:</label>
    <select id="status" name="status">
        <option value="1" ${product.status == 1 ? 'selected' : ''}>Hoạt động</option>
        <option value="0" ${product.status == 0 ? 'selected' : ''}>Không hoạt động</option>
    </select>
    <br/>

    <button type="submit">Lưu</button>
</form>

<a href="/products">Quay lại danh sách</a>
</body>
</html>
