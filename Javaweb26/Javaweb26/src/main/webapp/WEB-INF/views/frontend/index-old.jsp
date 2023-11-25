<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${title }</title>
    
     <jsp:include page="/WEB-INF/views/common/variables.jsp"></jsp:include>
      <jsp:include page="/WEB-INF/views/frontend/layout/css.jsp"></jsp:include>
      
</head>

<body>
    <div class="wrapper">
        <!-- Header -->
        <jsp:include page="/WEB-INF/views/frontend/layout/header.jsp"></jsp:include>
        <main class="main">
            <div class="main__products-hot">
                <div class="container">
                    <div class="main__products-title">
                        <p>Sản phẩm nổi bật</p>
                    </div>
                    <div class="main__products-content">
                        <div class="row">
                            <div class="col-12 col-lg-3 col-md-6">
                                <div class="product">
                                    <div class="thumb">
                                        <a href="${classpath}/frontend/sanpham.html" class="image">
                                            <img src="${classpath}/frontend/img/products/1.jpg" class="fit-img zoom-img">
                                        </a>
                                        <span class="badges">
                                            <span class="sale">-20%</span>
                                        </span>
                                    </div>
                                    <div class="content">
                                        <a href="${classpath}/frontend/sanpham.html" class="content-link">
                                            <h5 class="title">Chó mèo</h5>
                                        </a>
                                        <span class="price">
                                            <span class="old">20.000.000đ</span>
                                            <span class="new">15.000.000đ</span>
                                        </span>
                                        <span class="symbol">
                                            <a href="#"><i class='bx bx-heart'></i></a>
                                            <a href="#"><i class='bx bx-cart'></i></a>
                                        </span>
                                    </div>
                                </div>
                            </div>
                            <div class="col-12 col-lg-3 col-md-6">
                                <div class="product">
                                    <div class="thumb">
                                        <a href="${classpath}/frontend/sanpham.html" class="image">
                                            <img src="${classpath}/frontend/img/products/4.jpg" class="fit-img zoom-img">
                                        </a>
                                        <span class="badges">
                                            <span class="new">new</span>
                                        </span>
                                    </div>
                                    <div class="content">
                                        <a href="${classpath}/frontend/sanpham.html" class="content-link">
                                            <h5 class="title">Chó mèo</h5>
                                        </a>
                                        <span class="price">
                                            <!-- <span class="old">20.000.000đ</span> -->
                                            <span class="new">15.000.000đ</span>
                                        </span>
                                        <span class="symbol">
                                            <a href="#"><i class='bx bx-heart'></i></a>
                                            <a href="#"><i class='bx bx-cart'></i></a>
                                        </span>
                                    </div>
                                </div>
                            </div>
                            <div class="col-12 col-lg-3 col-md-6">
                                <div class="product">
                                    <div class="thumb">
                                        <a href="${classpath}/frontend/sanpham.html" class="image">
                                            <img src="${classpath}/frontend/img/products/2.jpeg" class="fit-img zoom-img">
                                        </a>
                                        <span class="badges">
                                            <!-- <span class="sale">-20%</span> -->
                                        </span>
                                    </div>
                                    <div class="content">
                                        <a href="${classpath}/frontend/sanpham.html" class="content-link">
                                            <h5 class="title">Chó mèo</h5>
                                        </a>
                                        <span class="price">
                                            <!-- <span class="old">20.000.000đ</span> -->
                                            <span class="new">15.000.000đ</span>
                                        </span>
                                        <span class="symbol">
                                            <a href="#"><i class='bx bx-heart'></i></a>
                                            <a href="#"><i class='bx bx-cart'></i></a>
                                        </span>
                                    </div>
                                </div>
                            </div>
                            <div class="col-12 col-lg-3 col-md-6">
                                <div class="product">
                                    <div class="thumb">
                                        <a href="${classpath}/frontend/sanpham.html" class="image">
                                            <img src="${classpath}/frontend/img/products/7.jpg" class="fit-img zoom-img">
                                        </a>
                                        <span class="badges">
                                            <span class="sale">-20%</span>
                                        </span>
                                    </div>
                                    <div class="content">
                                        <a href="${classpath}/frontend/sanpham.html" class="content-link">
                                            <h5 class="title">Chó mèo</h5>
                                        </a>
                                        <span class="price">
                                            <span class="old">20.000.000đ</span>
                                            <span class="new">15.000.000đ</span>
                                        </span>
                                        <span class="symbol">
                                            <a href="#"><i class='bx bx-heart'></i></a>
                                            <a href="#"><i class='bx bx-cart'></i></a>
                                        </span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- <div class="main__products-more">
                        <a href="#">Xem thêm</a>
                    </div> -->
                </div>
            </div>
            <!-- Sale -->
            <div class="main__products-sale">
                <div class="container">
                    <div class="row">
                        <div class="col-12 col-lg-6">
                            <a href="${classpath}/frontend/danhmuc.html" class="banner-sale">
                                <img src="${classpath}/frontend/img/oder-1.jpg" alt="">
                            </a>
                        </div>
                        <div class="col-12 col-lg-6 block none">
                            <a href="${classpath}/frontend/danhmuc.html" class="banner-sale">
                                <img src="${classpath}/frontend/img/oder-2.jpg" alt="">
                            </a>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Danh mục sản phẩm -->
            <div class="main__products">
                <div class="container">
                    <div class="main__products-title">
                        <p>Danh sách sản phẩm</p>
                    </div>
                    <div class="main__products-content">
                        <div class="row">
                            <div class="col-12 col-lg-3 col-md-6">
                                <div class="product">
                                    <div class="thumb">
                                        <a href="${classpath}/frontend/sanpham.html" class="image">
                                            <img src="${classpath}/frontend/img/products/1.jpg" class="fit-img zoom-img">
                                        </a>
                                        <span class="badges">
                                            <!-- <span class="sale">-20%</span> -->
                                            <span class="new">new</span>

                                        </span>
                                    </div>
                                    <div class="content">
                                        <a href="${classpath}/frontend/sanpham.html" class="content-link">
                                            <h5 class="title">Chó mèo</h5>
                                        </a>
                                        <span class="price">
                                            <!-- <span class="old">20.000.000đ</span> -->
                                            <span class="new">15.000.000đ</span>
                                        </span>
                                        <span class="symbol">
                                            <a href="#"><i class='bx bx-heart'></i></a>
                                            <a href="#"><i class='bx bx-cart'></i></a>
                                        </span>
                                    </div>
                                </div>
                            </div>
                            <div class="col-12 col-lg-3 col-md-6">
                                <div class="product">
                                    <div class="thumb">
                                        <a href="${classpath}/frontend/sanpham.html" class="image">
                                            <img src="${classpath}/frontend/img/products/1.jpeg" class="fit-img zoom-img">
                                        </a>
                                        <span class="badges">
                                            <span class="sale">-15%</span>
                                        </span>
                                    </div>
                                    <div class="content">
                                        <a href="${classpath}/frontend/sanpham.html" class="content-link">
                                            <h5 class="title">Chó mèo</h5>
                                        </a>
                                        <span class="price">
                                            <span class="old">20.000.000đ</span>
                                            <span class="new">15.000.000đ</span>
                                        </span>
                                        <span class="symbol">
                                            <a href="#"><i class='bx bx-heart'></i></a>
                                            <a href="#"><i class='bx bx-cart'></i></a>
                                        </span>
                                    </div>
                                </div>
                            </div>
                            <div class="col-12 col-lg-3 col-md-6">
                                <div class="product">
                                    <div class="thumb">
                                        <a href="${classpath}/frontend/sanpham.html" class="image">
                                            <img src="${classpath}/frontend/img/products/8.jpg" class="fit-img zoom-img">
                                        </a>
                                        <span class="badges">
                                            <span class="sale">-20%</span>
                                        </span>
                                    </div>
                                    <div class="content">
                                        <a href="${classpath}/frontend/sanpham.html" class="content-link">
                                            <h5 class="title">Chó mèo</h5>
                                        </a>
                                        <span class="price">
                                            <span class="old">20.000.000đ</span>
                                            <span class="new">15.000.000đ</span>
                                        </span>
                                        <span class="symbol">
                                            <a href="#"><i class='bx bx-heart'></i></a>
                                            <a href="#"><i class='bx bx-cart'></i></a>
                                        </span>
                                    </div>
                                </div>
                            </div>
                            <div class="col-12 col-lg-3 col-md-6">
                                <div class="product">
                                    <div class="thumb">
                                        <a href="${classpath}/frontend/sanpham.html" class="image">
                                            <img src="${classpath}/frontend/img/products/7.jpeg" class="fit-img zoom-img">
                                        </a>
                                        <span class="badges">
                                            <span class="sale">-20%</span>
                                        </span>
                                    </div>
                                    <div class="content">
                                        <a href="${classpath}/frontend/sanpham.html" class="content-link">
                                            <h5 class="title">Chó mèo</h5>
                                        </a>
                                        <span class="price">
                                            <span class="old">20.000.000đ</span>
                                            <span class="new">15.000.000đ</span>
                                        </span>
                                        <span class="symbol">
                                            <a href="#"><i class='bx bx-heart'></i></a>
                                            <a href="#"><i class='bx bx-cart'></i></a>
                                        </span>
                                    </div>
                                </div>
                            </div>
                            <div class="col-12 col-lg-3 col-md-6">
                                <div class="product">
                                    <div class="thumb">
                                        <a href="${classpath}/frontend/sanpham.html" class="image">
                                            <img src="${classpath}/frontend/img/products/5.jpg" class="fit-img zoom-img">
                                        </a>
                                        <span class="badges">
                                            <span class="sale">-20%</span>
                                        </span>
                                    </div>
                                    <div class="content">
                                        <a href="${classpath}/frontend/sanpham.html" class="content-link">
                                            <h5 class="title">Chó mèo</h5>
                                        </a>
                                        <span class="price">
                                            <span class="old">20.000.000đ</span>
                                            <span class="new">15.000.000đ</span>
                                        </span>
                                        <span class="symbol">
                                            <a href="#"><i class='bx bx-heart'></i></a>
                                            <a href="#"><i class='bx bx-cart'></i></a>
                                        </span>
                                    </div>
                                </div>
                            </div>
                            <div class="col-12 col-lg-3 col-md-6">
                                <div class="product">
                                    <div class="thumb">
                                        <a href="${classpath}/frontend/sanpham.html" class="image">
                                            <img src="${classpath}/frontend/img/products/6.jpeg" class="fit-img zoom-img">
                                        </a>
                                        <span class="badges">
                                            <span class="sale">-20%</span>
                                        </span>
                                    </div>
                                    <div class="content">
                                        <a href="${classpath}/frontend/sanpham.html" class="content-link">
                                            <h5 class="title">Chó mèo</h5>
                                        </a>
                                        <span class="price">
                                            <span class="old">20.000.000đ</span>
                                            <span class="new">15.000.000đ</span>
                                        </span>
                                        <span class="symbol">
                                            <a href="#"><i class='bx bx-heart'></i></a>
                                            <a href="#"><i class='bx bx-cart'></i></a>
                                        </span>
                                    </div>
                                </div>
                            </div>
                            <div class="col-12 col-lg-3 col-md-6">
                                <div class="product">
                                    <div class="thumb">
                                        <a href="${classpath}/frontend/sanpham.html" class="image">
                                            <img src="${classpath}/frontend/img/products/4.jpeg" class="fit-img zoom-img">
                                        </a>
                                        <span class="badges">
                                            <!-- <span class="sale">-20%</span> -->
                                            <span class="new">new</span>

                                        </span>
                                    </div>
                                    <div class="content">
                                        <a href="${classpath}/frontend/sanpham.html" class="content-link">
                                            <h5 class="title">Chó mèo</h5>
                                        </a>
                                        <span class="price">
                                            <!-- <span class="old">20.000.000đ</span> -->
                                            <span class="new">15.000.000đ</span>
                                        </span>
                                        <span class="symbol">
                                            <a href="#"><i class='bx bx-heart'></i></a>
                                            <a href="#"><i class='bx bx-cart'></i></a>
                                        </span>
                                    </div>
                                </div>
                            </div>
                            <div class="col-12 col-lg-3 col-md-6">
                                <div class="product">
                                    <div class="thumb">
                                        <a href="${classpath}/frontend/sanpham.html" class="image">
                                            <img src="${classpath}/frontend/img/products/1.jpg" class="fit-img zoom-img">
                                        </a>
                                        <span class="badges">
                                            <span class="sale">-20%</span>
                                        </span>
                                    </div>
                                    <div class="content">
                                        <a href="${classpath}/frontend/sanpham.html" class="content-link">
                                            <h5 class="title">Chó mèo</h5>
                                        </a>
                                        <span class="price">
                                            <span class="old">20.000.000đ</span>
                                            <span class="new">15.000.000đ</span>
                                        </span>
                                        <span class="symbol">
                                            <a href="#"><i class='bx bx-heart'></i></a>
                                            <a href="#"><i class='bx bx-cart'></i></a>
                                        </span>
                                    </div>
                                </div>
                            </div>
                            <div class="col-12 col-lg-3 col-md-6">
                                <div class="product">
                                    <div class="thumb">
                                        <a href="${classpath}/frontend/sanpham.html" class="image">
                                            <img src="${classpath}/frontend/img/products/1.jpg" class="fit-img zoom-img">
                                        </a>
                                        <span class="badges">
                                            <span class="sale">-20%</span>
                                        </span>
                                    </div>
                                    <div class="content">
                                        <a href="${classpath}/frontend/sanpham.html" class="content-link">
                                            <h5 class="title">Chó mèo</h5>
                                        </a>
                                        <span class="price">
                                            <span class="old">20.000.000đ</span>
                                            <span class="new">15.000.000đ</span>
                                        </span>
                                        <span class="symbol">
                                            <a href="#"><i class='bx bx-heart'></i></a>
                                            <a href="#"><i class='bx bx-cart'></i></a>
                                        </span>
                                    </div>
                                </div>
                            </div>
                            <div class="col-12 col-lg-3 col-md-6">
                                <div class="product">
                                    <div class="thumb">
                                        <a href="${classpath}/frontend/sanpham.html" class="image">
                                            <img src="${classpath}/frontend/img/products/4.jpg" class="fit-img zoom-img">
                                        </a>
                                        <span class="badges">
                                            <span class="new">new</span>
                                        </span>
                                    </div>
                                    <div class="content">
                                        <a href="${classpath}/frontend/sanpham.html" class="content-link">
                                            <h5 class="title">Chó mèo</h5>
                                        </a>
                                        <span class="price">
                                            <!-- <span class="old">20.000.000đ</span> -->
                                            <span class="new">15.000.000đ</span>
                                        </span>
                                        <span class="symbol">
                                            <a href="#"><i class='bx bx-heart'></i></a>
                                            <a href="#"><i class='bx bx-cart'></i></a>
                                        </span>
                                    </div>
                                </div>
                            </div>
                            <div class="col-12 col-lg-3 col-md-6">
                                <div class="product">
                                    <div class="thumb">
                                        <a href="${classpath}/frontend/sanpham.html" class="image">
                                            <img src="${classpath}/frontend/img/products/2.jpeg" class="fit-img zoom-img">
                                        </a>
                                        <span class="badges">
                                            <!-- <span class="sale">-20%</span> -->
                                        </span>
                                    </div>
                                    <div class="content">
                                        <a href="${classpath}/frontend/sanpham.html" class="content-link">
                                            <h5 class="title">Chó mèo</h5>
                                        </a>
                                        <span class="price">
                                            <!-- <span class="old">20.000.000đ</span> -->
                                            <span class="new">15.000.000đ</span>
                                        </span>
                                        <span class="symbol">
                                            <a href="#"><i class='bx bx-heart'></i></a>
                                            <a href="#"><i class='bx bx-cart'></i></a>
                                        </span>
                                    </div>
                                </div>
                            </div>
                            <div class="col-12 col-lg-3 col-md-6">
                                <div class="product">
                                    <div class="thumb">
                                        <a href="${classpath}/frontend/sanpham.html" class="image">
                                            <img src="${classpath}/frontend/img/products/7.jpg" class="fit-img zoom-img">
                                        </a>
                                        <span class="badges">
                                            <span class="sale">-20%</span>
                                        </span>
                                    </div>
                                    <div class="content">
                                        <a href="${classpath}/frontend/sanpham.html" class="content-link">
                                            <h5 class="title">Chó mèo</h5>
                                        </a>
                                        <span class="price">
                                            <span class="old">20.000.000đ</span>
                                            <span class="new">15.000.000đ</span>
                                        </span>
                                        <span class="symbol">
                                            <a href="#"><i class='bx bx-heart'></i></a>
                                            <a href="#"><i class='bx bx-cart'></i></a>
                                        </span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="main__products-more">
                        <a href="${classpath}/frontend/danhmuc.html">Xem thêm</a>
                    </div>
                </div>
            </div>
            <!-- Danh sách phụ kiện -->
            <div class="main__accessory">
                <div class="container">
                    <div class="main__products-title">
                        <p>Danh sách phụ kiện</p>
                    </div>
                    <div class="main__products-content">
                        <div class="row">
                            <div class="col-12 col-lg-3 col-md-6">
                                <div class="product">
                                    <div class="thumb">
                                        <a href="${classpath}/frontend/sanpham.html" class="image">
                                            <img src="${classpath}/frontend/img/products/phukien/1.jpg" class="fit-img zoom-img">
                                        </a>
                                        <!-- <span class="badges">
                                            <span class="sale">-20%</span>
                                        </span> -->
                                    </div>
                                    <div class="content">
                                        <a href="${classpath}/frontend/sanpham.html" class="content-link">
                                            <h5 class="title">Bát sứ hình trái cây</h5>
                                        </a>
                                        <span class="price">
                                            <!-- <span class="old">20.000.000đ</span> -->
                                            <span class="new">15.000đ</span>
                                        </span>
                                        <span class="symbol">
                                            <a href="#"><i class='bx bx-heart'></i></a>
                                            <a href="#"><i class='bx bx-cart'></i></a>
                                        </span>
                                    </div>
                                </div>
                            </div>
                            <div class="col-12 col-lg-3 col-md-6">
                                <div class="product">
                                    <div class="thumb">
                                        <a href="${classpath}/frontend/sanpham.html" class="image">
                                            <img src="${classpath}/frontend/img/products/phukien/4.jpg" class="fit-img zoom-img">
                                        </a>
                                        <span class="badges">
                                            <span class="new">new</span>
                                        </span>
                                    </div>
                                    <div class="content">
                                        <a href="${classpath}/frontend/sanpham.html" class="content-link">
                                            <h5 class="title">Ly gấu dễ thương</h5>
                                        </a>
                                        <span class="price">
                                            <!-- <span class="old">20.000.000đ</span> -->
                                            <span class="new">100.000đ</span>
                                        </span>
                                        <span class="symbol">
                                            <a href="#"><i class='bx bx-heart'></i></a>
                                            <a href="#"><i class='bx bx-cart'></i></a>
                                        </span>
                                    </div>
                                </div>
                            </div>
                            <div class="col-12 col-lg-3 col-md-6">
                                <div class="product">
                                    <div class="thumb">
                                        <a href="${classpath}/frontend/sanpham.html" class="image">
                                            <img src="${classpath}/frontend/img/products/phukien/1.jpg" class="fit-img zoom-img">
                                        </a>
                                        <span class="badges">
                                            <!-- <span class="sale">-20%</span> -->
                                        </span>
                                    </div>
                                    <div class="content">
                                        <a href="${classpath}/frontend/sanpham.html" class="content-link">
                                            <h5 class="title">Bát sứ hình trái cây</h5>
                                        </a>
                                        <span class="price">
                                            <!-- <span class="old">20.000.000đ</span> -->
                                            <span class="new">15.000đ</span>
                                        </span>
                                        <span class="symbol">
                                            <a href="#"><i class='bx bx-heart'></i></a>
                                            <a href="#"><i class='bx bx-cart'></i></a>
                                        </span>
                                    </div>
                                </div>
                            </div>
                            <div class="col-12 col-lg-3 col-md-6">
                                <div class="product">
                                    <div class="thumb">
                                        <a href="${classpath}/frontend/sanpham.html" class="image">
                                            <img src="${classpath}/frontend/img/products/phukien/1.jpg" class="fit-img zoom-img">
                                        </a>
                                        <span class="badges">
                                            <span class="sale">-20%</span>
                                        </span>
                                    </div>
                                    <div class="content">
                                        <a href="${classpath}/frontend/sanpham.html" class="content-link">
                                            <h5 class="title">Bát sứ hình trái cây</h5>
                                        </a>
                                        <span class="price">
                                            <!-- <span class="old">20.000.000đ</span> -->
                                            <span class="new">15.000đ</span>
                                        </span>
                                        <span class="symbol">
                                            <a href="#"><i class='bx bx-heart'></i></a>
                                            <a href="#"><i class='bx bx-cart'></i></a>
                                        </span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="main__products-more">
                        <a href="#">Xem thêm</a>
                    </div>
                </div>
            </div>
            <!-- Tin tức -->
            <div class="main__news">
                <div class="container">
                    <div class="row">
                        <div class="main__products-title">
                            <p>Blog</p>
                        </div>
                        <div class="col-12 col-lg-4 col-md-6">
                            <div class="product">
                                <div class="thumb">
                                    <a href="${classpath}/frontend/sanpham.html" class="image">
                                        <img src="${classpath}/frontend/img/products/1.jpeg" class="fit-img opacity-img">
                                    </a>
                                </div>
                                <div class="content">
                                    <div class="new__author">
                                        <p class="author">By <strong>Admin</strong> -
                                            18, Mar, 2023</p>
                                    </div>
                                    <a href="${classpath}/frontend/sanpham.html" class="content-link">
                                        <h5 class="title">Tips for taking care of dogs</h5>
                                    </a>
                                    <div class="new__desc">
                                        <p class="desc">Lorem ipsum dolor sit, amet consectetur adipisicing elit.
                                            Deserunt, distinctio! Obcaecati quis praesentium fugiat corrupti at quidem
                                            cum doloribus eos. Sunt amet velit ducimus odit atque saepe harum vitae
                                            soluta.</p>
                                    </div>
                                    <div class="new__more">
                                        <a href="#"><span>More</span></a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-12 col-lg-4 col-md-6">
                            <div class="product">
                                <div class="thumb">
                                    <a href="${classpath}/frontend/sanpham.html" class="image">
                                        <img src="${classpath}/frontend/img/products/2.jpg" class="fit-img opacity-img">
                                    </a>
                                </div>
                                <div class="content">
                                    <div class="new__author">
                                        <p class="author">By <strong>Admin</strong> -
                                            18, Mar, 2023</p>
                                    </div>
                                    <a href="${classpath}/frontend/sanpham.html" class="content-link">
                                        <h5 class="title">Tips for taking care of dogs</h5>
                                    </a>
                                    <div class="new__desc">
                                        <p class="desc">Lorem ipsum dolor sit, amet consectetur adipisicing elit.
                                            Deserunt, distinctio! Obcaecati quis praesentium fugiat corrupti at quidem
                                            cum doloribus eos. Sunt amet velit ducimus odit atque saepe harum vitae
                                            soluta.</p>
                                    </div>
                                    <div class="new__more">
                                        <a href="#"><span>More</span></a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-12 col-lg-4 col-md-6">
                            <div class="product">
                                <div class="thumb">
                                    <a href="${classpath}/frontend/sanpham.html" class="image">
                                        <img src="${classpath}/frontend/img/products/6.jpeg" class="fit-img opacity-img">
                                    </a>
                                </div>
                                <div class="content">
                                    <div class="new__author">
                                        <p class="author">By <strong>Admin</strong> -
                                            18, Mar, 2023</p>
                                    </div>
                                    <a href="${classpath}/frontend/sanpham.html" class="content-link">
                                        <h5 class="title">Tips for taking care of dogs</h5>
                                    </a>
                                    <div class="new__desc">
                                        <p class="desc">Lorem ipsum dolor sit, amet consectetur adipisicing elit.
                                            Deserunt, distinctio! Obcaecati quis praesentium fugiat corrupti at quidem
                                            cum doloribus eos. Sunt amet velit ducimus odit atque saepe harum vitae
                                            soluta.</p>
                                    </div>
                                    <div class="new__more">
                                        <a href="#"><span>More</span></a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- main bottom -->
            <div class="main__bottom">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-4 none block">
                            <div class="main__bottom-wrap">
                                <div class="wrap__icon"><i class='bx bxs-truck'></i></div>
                                <div class="wrap__content">
                                    <h4 class="title">FREE SHIPPING</h4>
                                    <p>Free shipping on all order</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-4 none block">
                            <div class="main__bottom-wrap">
                                <div class="wrap__icon"><i class='bx bx-headphone'></i></div>
                                <div class="wrap__content">
                                    <h4 class="title">ONLINE SUPPORT</h4>
                                    <p>Online live support 24/7</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-4 none block">
                            <div class="main__bottom-wrap">
                                <div class="wrap__icon"><i class='bx bx-bar-chart-alt'></i></div>
                                <div class="wrap__content">
                                    <h4 class="title">MONEY RETURN</h4>
                                    <p>Back guarantee under 5 days</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </main>
        <!-- Footer -->
        <jsp:include page="/WEB-INF/views/frontend/layout/footer.jsp"></jsp:include>
        <div class="scroll__top">
            <i class='bx bx-up-arrow-alt'></i>
        </div>

        <!-- mobile menu -->
        <div class="mobile__menu-wrapper">
            <div class="mobile__menu-body">
                <div class="mobile__btn-close">
                    <i class='bx bx-x'></i>
                </div>
                <div class="mobile__content">
                    <div class="mobile__search-box">
                        <form>
                            <input type="text" placeholder="Tìm kiếm..." class="mobile__search-input">
                            <button class="mobile__search-btn">
                                <i class='bx bx-search'></i>
                            </button>
                        </form>
                    </div>
                    <div class="mobile__navigation">
                        <ul class="mobile__nav">
                            <li class="mobile__children"><a href="${classpath}/frontend/index.html" class="mobile__link">Trang chủ</li>
                            <li class="mobile__children">
                                <a href="#" class="mobile__link">Thú cưng
                                    <i class='bx bx-chevron-down'></i>
                                </a>
                                <ul class="mobile__submenu">
                                    <li class="mobile__submenu-item"><a href="${classpath}/frontend/danhmuc.html"
                                            class="mobile__submenu-link">Chó
                                            Corgi</a></li>
                                    <li class="mobile__submenu-item"><a href="${classpath}/frontend/danhmuc.html"
                                            class="mobile__submenu-link">Chó
                                            Beagle</a></li>
                                    <li class="mobile__submenu-item"><a href="${classpath}/frontend/danhmuc.html"
                                            class="mobile__submenu-link">Chó Alaska
                                            Malamute</a></li>
                                    <li class="mobile__submenu-item"><a href="${classpath}/frontend/danhmuc.html"
                                            class="mobile__submenu-link">Chó Golden
                                            Retriever</a></li>
                                    <li class="mobile__submenu-item"><a href="${classpath}/frontend/danhmuc.html"
                                            class="mobile__submenu-link"> Chó Husky
                                            Siberian</a></li>
                                </ul>
                            </li>
                            <li class="mobile__children"><a href="#" class="mobile__link">Phụ kiện</a></li>
                            <li class="mobile__children">
                                <a href="#" class="mobile__link">Dịch vụ <i class='bx bx-chevron-down'></i></a>
                                <ul class="mobile__submenu">
                                    <li class="mobile__submenu-item"><a href="#" class="mobile__submenu-link">Spa</a>
                                    </li>
                                    <li class="mobile__submenu-item"><a href="#" class="mobile__submenu-link">Chăm sóc
                                            thú cưng</a></li>
                                </ul>
                            </li>
                            <li class="mobile__children"><a href="${classpath}/frontend/lienhe.html" class="mobile__link">Liên hệ </a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- js -->
    <jsp:include page="/WEB-INF/views/frontend/layout/js.jsp"></jsp:include>
</body>

</html>