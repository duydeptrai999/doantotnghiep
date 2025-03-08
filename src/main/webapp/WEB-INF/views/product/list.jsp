<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Danh sách sản phẩm</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
    <style>
        .product-card {
            transition: transform 0.3s;
            height: 100%;
        }
        .product-card:hover {
            transform: translateY(-5px);
            box-shadow: 0 4px 15px rgba(0,0,0,0.1);
        }
        .product-image {
            height: 200px;
            object-fit: cover;
        }
        .card-title {
            font-size: 1rem;
            margin-bottom: 0.5rem;
            height: 2.4rem;
            overflow: hidden;
            display: -webkit-box;
            -webkit-line-clamp: 2;
            -webkit-box-orient: vertical;
        }
        .price {
            font-size: 1.1rem;
            font-weight: bold;
            color: #dc3545;
        }
    </style>
</head>
<body>
    <!-- Hiển thị thông báo -->
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

    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container">
            <a class="navbar-brand" href="/"><i class="bi bi-shop"></i> Shop Thể Thao</a>
            <div class="d-flex">
                <a href="/cart" class="btn btn-outline-primary me-2">
                    <i class="bi bi-cart"></i> Giỏ hàng 
                    <c:if test="${not empty cartCount}">
                        <span class="badge bg-danger">${cartCount}</span>
                    </c:if>
                </a>
                <form action="/auth/logout" method="post" class="d-flex">
                    <button type="submit" class="btn btn-outline-light">Đăng xuất</button>
                </form>
            </div>
        </div>
    </nav>

    <div class="container mt-4">
        <h2 class="mb-4">Danh sách sản phẩm</h2>
        
        <div class="row row-cols-1 row-cols-md-2 row-cols-lg-4 g-4">
            <c:forEach items="${products}" var="product">
                <div class="col">
                    <div class="card product-card">
                        <c:if test="${not empty product.productDetails}">
                            <c:set var="firstDetail" value="${product.productDetails[0]}" />
                            <c:if test="${not empty firstDetail.images}">
                                <img src="${firstDetail.images[0].source}" 
                                     class="card-img-top product-image" 
                                     alt="${product.name}"
                                     onerror="this.src='https://via.placeholder.com/300x200?text=No+Image'">
                            </c:if>
                            <c:if test="${empty firstDetail.images}">
                                <img src="https://via.placeholder.com/300x200?text=No+Image" 
                                     class="card-img-top product-image" 
                                     alt="No Image">
                            </c:if>
                        </c:if>
                        
                        <div class="card-body">
                            <h5 class="card-title">${product.name}</h5>
                            <p class="card-text">
                                <small class="text-muted">Mã: ${product.code}</small>
                            </p>
                            <c:if test="${not empty product.productDetails}">
                                <p class="price">
                                    <fmt:formatNumber value="${product.productDetails[0].price}" 
                                                    type="currency" 
                                                    currencySymbol="₫" 
                                                    maxFractionDigits="0"/>
                                </p>
                            </c:if>
                            <div class="d-grid gap-2">
                                <a href="/product/detail/${product.id}" class="btn btn-primary">
                                    Xem chi tiết
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>

        <!-- Phân trang -->
        <c:if test="${totalPages > 1}">
            <nav aria-label="Page navigation" class="mt-4">
                <ul class="pagination justify-content-center">
                    <li class="page-item ${currentPage == 0 ? 'disabled' : ''}">
                        <a class="page-link" href="?page=${currentPage - 1}">Trước</a>
                    </li>
                    <c:forEach begin="0" end="${totalPages - 1}" var="i">
                        <li class="page-item ${currentPage == i ? 'active' : ''}">
                            <a class="page-link" href="?page=${i}">${i + 1}</a>
                        </li>
                    </c:forEach>
                    <li class="page-item ${currentPage == totalPages - 1 ? 'disabled' : ''}">
                        <a class="page-link" href="?page=${currentPage + 1}">Sau</a>
                    </li>
                </ul>
            </nav>
        </c:if>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
