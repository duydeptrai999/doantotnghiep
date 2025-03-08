<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>${product.name} - Chi tiết sản phẩm</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container">
            <a class="navbar-brand" href="/product/list">Shop</a>
            <div class="collapse navbar-collapse">
                <ul class="navbar-nav me-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="/cart">Giỏ hàng</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <div class="container mt-4">
        <c:if test="${not empty successMessage}">
            <div class="alert alert-success alert-dismissible fade show" role="alert">
                ${successMessage}
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
        </c:if>

        <c:if test="${not empty errorMessage}">
            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                ${errorMessage}
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
        </c:if>

        <div class="row">
            <div class="col-md-6">
                <!-- Carousel cho hình ảnh sản phẩm -->
                <div id="productCarousel" class="carousel slide" data-bs-ride="carousel">
                    <div class="carousel-inner">
                        <c:forEach items="${product.getAllImages()}" var="imageUrl" varStatus="status">
                            <div class="carousel-item ${status.first ? 'active' : ''}">
                                <img src="${imageUrl}" class="d-block w-100" alt="${product.name}">
                            </div>
                        </c:forEach>
                    </div>
                    <button class="carousel-control-prev" type="button" data-bs-target="#productCarousel" data-bs-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="visually-hidden">Previous</span>
                    </button>
                    <button class="carousel-control-next" type="button" data-bs-target="#productCarousel" data-bs-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="visually-hidden">Next</span>
                    </button>
                </div>
            </div>

            <div class="col-md-6">
                <h1>${product.name}</h1>
                <p class="h3 text-danger">
                    <fmt:formatNumber value="${product.price}" type="currency" currencySymbol="₫"/>
                </p>
                
                <form id="addToCartForm" action="/cart/add" method="POST" class="mt-4">
                    <input type="hidden" name="productId" value="${product.id}"/>
                    
                    <!-- Chọn màu sắc -->
                    <div class="mb-3">
                        <label class="form-label">Màu sắc:</label>
                        <div class="btn-group" role="group">
                            <c:forEach items="${product.colors}" var="color">
                                <input type="radio" class="btn-check" name="colorId" id="color${color.id}" value="${color.id}" required>
                                <label class="btn btn-outline-secondary" for="color${color.id}">${color.name}</label>
                            </c:forEach>
                        </div>
                    </div>

                    <!-- Chọn kích thước -->
                    <div class="mb-3">
                        <label class="form-label">Kích thước:</label>
                        <div class="btn-group" role="group">
                            <c:forEach items="${product.sizes}" var="size">
                                <input type="radio" class="btn-check" name="sizeId" id="size${size.id}" value="${size.id}" required>
                                <label class="btn btn-outline-secondary" for="size${size.id}">${size.name}</label>
                            </c:forEach>
                        </div>
                    </div>

                    <!-- Số lượng -->
                    <div class="mb-3">
                        <label class="form-label">Số lượng:</label>
                        <input type="number" class="form-control" name="quantity" value="1" min="1" required style="width: 100px;">
                    </div>

                    <button type="submit" class="btn btn-primary">Thêm vào giỏ hàng</button>
                </form>

                <!-- Mô tả sản phẩm -->
                <div class="mt-4">
                    <h3>Mô tả sản phẩm</h3>
                    <p>${product.description}</p>
                </div>
            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
        $(document).ready(function() {
            // Kiểm tra số lượng tồn kho khi chọn màu và size
            $('input[name="colorId"], input[name="sizeId"]').change(function() {
                const colorId = $('input[name="colorId"]:checked').val();
                const sizeId = $('input[name="sizeId"]:checked').val();
                const productId = '${product.id}';
                
                if (colorId && sizeId) {
                    $.get(`/api/product-details/${productId}/${colorId}/${sizeId}`, function(data) {
                        if (data) {
                            $('input[name="quantity"]').attr('max', data.quantity);
                        }
                    });
                }
            });

            // Xử lý form thêm vào giỏ hàng
            $('#addToCartForm').submit(function(e) {
                const colorId = $('input[name="colorId"]:checked').val();
                const sizeId = $('input[name="sizeId"]:checked').val();
                
                if (!colorId || !sizeId) {
                    e.preventDefault();
                    alert('Vui lòng chọn màu sắc và kích thước');
                }
            });
        });
    </script>
</body>
</html>
