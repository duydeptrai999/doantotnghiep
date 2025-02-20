<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<html>
<head>
    <title>${productDetail.id == null ? "Thêm Sản phẩm Chi tiết" : "Chỉnh sửa Sản phẩm Chi tiết"}</title>
</head>
<body>
<h1>${productDetail.id == null ? "Thêm Sản phẩm Chi tiết" : "Chỉnh sửa Sản phẩm Chi tiết"}</h1>

<form action="${pageContext.request.contextPath}/product-details/save" method="post">
    <input type="hidden" name="id" value="${productDetail.id}" />

    <label for="name">Tên:</label>
    <input type="text" id="name" name="name" value="${productDetail.name}" required /><br/>

    <label for="description">Mô tả:</label>
    <textarea id="description" name="description">${productDetail.description}</textarea><br/>

    <label for="status">Trạng thái:</label>
    <select id="status" name="status">
        <option value="1" ${productDetail.status == 1 ? "selected" : ""}>Hoạt động</option>
        <option value="0" ${productDetail.status == 0 ? "selected" : ""}>Không hoạt động</option>
    </select><br/>

    <button type="submit">Lưu</button>
</form>

<a href="${pageContext.request.contextPath}/product-details">Quay lại danh sách</a>

</body>
</html>
