<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
    <title>Thêm kích cỡ mới</title>
    <style>
        .error {
            color: red;
        }
        .form-group {
            margin-bottom: 15px;
        }
        label {
            display: block;
            margin-bottom: 5px;
        }
    </style>
</head>
<body>
<h2>Thêm kích cỡ mới</h2>

<form:form action="${pageContext.request.contextPath}/size/add" method="post" modelAttribute="size">
    <div class="form-group">
        <label for="name">Tên kích cỡ:</label>
        <form:input path="name" id="name" class="form-control" />
        <form:errors path="name" cssClass="error" />
    </div>

    <div class="form-group">
        <label for="description">Mô tả:</label>
        <form:textarea path="description" id="description" class="form-control" rows="3" />
    </div>

    <div class="form-group">
        <label for="status">Trạng thái:</label>
        <form:select path="status" id="status" class="form-control">
            <c:forEach items="${statusList}" var="statusOption">
                <form:option value="${statusOption.id}">${statusOption.name}</form:option>
            </c:forEach>
        </form:select>
    </div>

    <div class="form-group">
        <button type="submit">Lưu</button>
        <a href="${pageContext.request.contextPath}/size/list">Hủy</a>
    </div>
</form:form>
</body>
</html>