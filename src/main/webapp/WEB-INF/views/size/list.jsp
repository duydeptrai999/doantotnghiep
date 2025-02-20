<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Danh sách kích cỡ</title>
</head>
<body>
<h2>Danh sách kích cỡ</h2>

<a href="${pageContext.request.contextPath}/size/add">Thêm kích cỡ</a>
<br><br>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Kích cỡ</th>
        <th>Mô tả</th>
        <th>Trạng thái</th>
        <th>Thao tác</th>
    </tr>
    <c:forEach var="size" items="${sizes.content}">
        <tr>
            <td>${size.id}</td>
            <td>${size.name}</td>
            <td>${size.description}</td>
            <td>
                <c:choose>
                    <c:when test="${size.status == 1}">Hoạt động</c:when>
                    <c:otherwise>Không hoạt động</c:otherwise>
                </c:choose>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/size/edit/${size.id}">Sửa</a> |
                <a href="${pageContext.request.contextPath}/size/delete/${size.id}" onclick="return confirm('Bạn có chắc chắn muốn xóa?');">Xóa</a>
            </td>
        </tr>
    </c:forEach>
</table>

<!-- Phân trang -->
<c:if test="${sizes.totalPages > 1}">
    <div class="pagination">
        <c:if test="${sizes.number > 0}">
            <a href="${pageContext.request.contextPath}/size/list?page=0">Trang đầu</a>
            <a href="${pageContext.request.contextPath}/size/list?page=${sizes.number - 1}">Trước</a>
        </c:if>

        <c:forEach begin="${Math.max(0, sizes.number - 2)}" end="${Math.min(sizes.totalPages - 1, sizes.number + 2)}" var="i">
            <c:choose>
                <c:when test="${sizes.number == i}">
                    <span class="current-page">${i + 1}</span>
                </c:when>
                <c:otherwise>
                    <a href="${pageContext.request.contextPath}/size/list?page=${i}">${i + 1}</a>
                </c:otherwise>
            </c:choose>
        </c:forEach>

        <c:if test="${sizes.number < sizes.totalPages - 1}">
            <a href="${pageContext.request.contextPath}/size/list?page=${sizes.number + 1}">Tiếp</a>
            <a href="${pageContext.request.contextPath}/size/list?page=${sizes.totalPages - 1}">Trang cuối</a>
        </c:if>
    </div>
</c:if>
</body>
</html>