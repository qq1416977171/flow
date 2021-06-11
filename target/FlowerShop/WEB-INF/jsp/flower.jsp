<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="com.qiang.model.User" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    <title>林语花园</title>
    <script>
        function saveCart() {
            <%
            User existUser = (User) request.getSession().getAttribute("existUser");
            if(existUser==null){
            %>
            alert("请先登录系统");
            <% } %>
            document.getElementById("cartForm").submit();
        }
    </script>

</head>
<body class="cms-index-index cms-home-page">

<%--头部--%>
<%@ include file="/WEB-INF/jsp/header.jsp" %>

<!-- 面包导航 -->
<div class="breadcrumbs">
    <div class="container">
        <div class="row">
            <div class="col-xs-12">
                <ul>
                    <li class="home"> <a href="${ pageContext.request.contextPath }/" title="Go to Home Page">首页</a> <span>/</span> </li>
                    <li> <strong>鲜花详情</strong> </li>
                </ul>
            </div>
        </div>
    </div>
</div>
<!-- Breadcrumbs End -->

<!-- 鲜花详情 -->
<section class="main-container col1-layout">
    <div class="main">
        <div class="container">
            <div class="row">
                <div class="col-main">
                    <div class="product-view">
                        <div class="product-essential">
                            <form action="${ pageContext.request.contextPath }/cartController/addCart.action" method="post" id="cartForm">
                                <input type="hidden" name="pid" value="${flower.pid }"/>
                                <div class="product-img-box col-lg-5 col-sm-6 col-xs-12">
                                    <div class="new-label new-top-left"> New </div>
                                    <div class="product-image">
                                        <div class="product-full"> <img id="product-zoom" src="${ pageContext.request.contextPath }/${flower.image}" data-zoom-image="${ pageContext.request.contextPath }/${flower.image}" alt="product-image"> </div>
                                    </div>
                                    <!-- end: more-images -->
                                </div>
                                <div class="product-shop col-lg-7 col-sm-6 col-xs-12">
                                    <div class="product-next-prev"> <a class="product-next" href="#"><span></span></a> <a class="product-prev" href="#"><span></span></a> </div>
                                    <div class="product-name">
                                        <h1>${flower.pname}</h1>
                                    </div>
                                    <div class="rating"> <i class="fa fa-star"></i> <i class="fa fa-star"></i> <i class="fa fa-star"></i> <i class="fa fa-star"></i> <i class="fa fa-star-o"></i>
                                        <p class="rating-links"> <a href="#">4 Review(s)</a> <span class="separator">|</span> <a href="#"><i class="fa fa-pencil"></i> write a review</a> </p>
                                    </div>
                                    <div class="price-block">
                                        <div class="price-box">
                                            <p class="special-price"> <span class="price-label">Special Price</span> <span id="product-price-48" class="price"> ￥：${flower.shopPrice} </span> </p>
                                            <p class="old-price"> <span class="price-label">Regular Price:</span> <span class="price"> ￥${flower.marketPrice} </span> </p>
                                        </div>
                                    </div>
                                    <div class="info-orther">
                                        <p>商品编号: ${flower.pid }</p>
                                        <p>库存: <span class="in-stock">有货</span></p>
                                        <p>产品: New</p>
                                    </div>
                                    <div class="short-description">
                                        <h2>Quick Overview</h2>
                                        <p>${flower.pdesc }</p>
                                    </div>

                                    <div class="form-option">
                                        <p class="form-option-title">Available Options:</p>
                                        <div class="add-to-box">
                                            <div class="add-to-cart">
                                                <div class="pull-left">
                                                    <div class="custom pull-left">
                                                        <label>Qty :</label>
                                                        <button onClick="var result = document.getElementById('qty'); var qty = result.value; if( !isNaN( qty ) &amp;&amp; qty &gt; 0 ) result.value--;return false;" class="reduced items-count" type="button"><i class="fa fa-minus">&nbsp;</i></button>
                                                        <input type="text" class="input-text qty" title="Qty" value="1" maxlength="12" id="qty" name="count">
                                                        <button onClick="var result = document.getElementById('qty'); var qty = result.value; if( !isNaN( qty )) result.value++;return false;" class="increase items-count" type="button"><i class="fa fa-plus">&nbsp;</i></button>
                                                    </div>
                                                </div>
                                                <button onClick="saveCart()" class="button btn-cart" title="Add to Cart" type="button">Add to Cart</button>
                                            </div>
                                            <div class="email-addto-box">
                                                <ul class="add-to-links">
                                                    <li> <a class="link-wishlist" href="#"><span>Add to Wishlist</span></a></li>
                                                    <li><span class="separator">|</span> <a class="link-compare" href="#"><span>Add to Compare</span></a></li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-share">
                                        <div class="sendtofriend-print"> <a href="javascript:print();"><i class="fa fa-print"></i> Print</a> <a href="#"><i class="fa fa-envelope-o fa-fw"></i> Send to a friend</a> </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="product-collateral col-lg-12 col-sm-12 col-xs-12">
                    <div class="add_info">
                        <ul id="product-detail-tab" class="nav nav-tabs product-tabs">
                            <li class="active"> <a href="#product_tabs_description" data-toggle="tab"> Product Description </a> </li>
                            <li> <a href="#product_tabs_custom" data-toggle="tab">Custom Tab</a> </li>
                            <li> <a href="#product_tabs_custom1" data-toggle="tab">Custom Tab1</a> </li>
                        </ul>
                        <div id="productTabContent" class="tab-content">
                            <div class="tab-pane fade in active" id="product_tabs_description">
                                <div class="std">
                                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam fringilla augue
                                        nec est tristique auctor. Donec non est at libero vulputate rutrum. Morb
                                        felis vehicula felis, a dapibus enim lorem nec augue.</p>
                                    <p> Nunc facilisis sagittis ullamcorper. Proin lectus ipsum, gravida et mattis vulput
                                        nunc mattis lobortis.</p>
                                </div>
                            </div>

                            <div class="tab-pane fade" id="product_tabs_custom">
                                <div class="product-tabs-content-inner clearfix">
                                    <p><strong>Lorem Ipsum</strong><span>&nbsp;is
                      simply dummy text of the printing and typesetting industry. Lorem Ipsum
                      has been the industry's standard dummy text ever since the 1500s, when
                      publishing software like Aldus PageMaker including versions of Lorem
                      Ipsum.</span></p>
                                </div>
                            </div>
                            <div class="tab-pane fade" id="product_tabs_custom1">
                                <div class="product-tabs-content-inner clearfix">
                                    <p> <strong> Comfortable </strong><span>&nbsp;preshrunk shirts. Highest Quality Printing.  6.1 oz. 100% preshrunk heavyweight cotton Shoulder-to-shoulder taping Double-needle sleeves and bottom hem

                      Lorem Ipsumis
                      simply dummy text of the printing and typesetting industry. Lorem Ipsum
                      has been the industry's standard dummy text ever since the 1500s, when
                      an unknown printer took a galley of type and scrambled it to make a type
                      publishing software like Aldus PageMaker including versions of Lorem
                      Ipsum.</span></p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Main Container End -->

<!-- 推荐 -->
<div class="container">
    <div class="related-section">
        <div class="slider-items-products">
            <div class="related-block">
                <div class="jtv-block-inner">
                    <div class="block-title">
                        <h2>推荐新品</h2>
                    </div>
                </div>
                <div id="related-products-slider" class="product-flexslider hidden-buttons">
                    <div class="slider-items slider-width-col4 products-grid block-content">
                        <c:forEach items="${hList }" var="h">
                        <div class="item">
                            <div class="item-inner">
                                <div class="item-img">
                                    <div class="item-img-info"> <a class="product-image" title="Product Title Here" href="${ pageContext.request.contextPath }/flower/findByPid?pid=${h.pid}"> <img alt="Product Title Here" src="${pageContext.request.contextPath}/${h.image}"> </a>
                                        <div class="jtv-box-hover">
                                            <ul class="add-to-links">
                                                <li><a class="link-quickview" href="${ pageContext.request.contextPath }/flower/findByPid?pid=${h.pid}"><i class="icon-magnifier-add icons"></i><span class="hidden">Quick View</span></a></li>
                                                <li><a class="link-wishlist" href="${ pageContext.request.contextPath }/flower/findByPid?pid=${h.pid}"><i class="icon-heart icons"></i><span class="hidden">Wishlist</span></a></li>
                                                <li><a class="link-compare" href="${ pageContext.request.contextPath }/flower/findByPid?pid=${h.pid}"><i class="icon-shuffle icons"></i><span class="hidden">Compare</span></a></li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                                <div class="item-info">
                                    <div class="info-inner">
                                        <div class="item-title"> <a title="Product Title Here" href="single_product.html"> ${h.pname}</a> </div>
                                        <div class="item-content">
                                            <div class="rating"> <i class="fa fa-star-o"></i> <i class="fa fa-star-o"></i> <i class="fa fa-star-o"></i> <i class="fa fa-star-o"></i> <i class="fa fa-star-o"></i> </div>
                                            <div class="item-price">
                                                <div class="price-box"> <span class="regular-price"> <span class="price">￥${h.shopPrice}</span> </span> </div>
                                            </div>
                                            <div class="action">
                                                <button class="button btn-cart" type="button" title="" data-original-title="Add to Cart"><span>Add to Cart</span> </button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Related Products Slider End -->


<!-- 轮播 Logo -->
<%--<div class="brand-logo">--%>
<%--    <div class="container">--%>
<%--        <div class="slider-items-products">--%>
<%--            <div id="brand-logo-slider" class="product-flexslider hidden-buttons">--%>
<%--                <div class="slider-items slider-width-col6">--%>

<%--                    <!-- Item -->--%>
<%--                    <div class="item"> <a href="#"><img src="${pageContext.request.contextPath}/user/images/brand1.png" alt="brand logo"> </a> </div>--%>
<%--                    <!-- End Item -->--%>

<%--                    <!-- Item -->--%>
<%--                    <div class="item"> <a href="#"><img src="${pageContext.request.contextPath}/user/images/brand2.png" alt="brand logo"> </a> </div>--%>
<%--                    <!-- End Item -->--%>

<%--                    <!-- Item -->--%>
<%--                    <div class="item"> <a href="#"><img src="${pageContext.request.contextPath}/user/images/brand3.png" alt="Image"> </a> </div>--%>
<%--                    <!-- End Item -->--%>

<%--                    <!-- Item -->--%>
<%--                    <div class="item"> <a href="#"><img src="${pageContext.request.contextPath}/user/images/brand4.png" alt="brand logo"> </a> </div>--%>
<%--                    <!-- End Item -->--%>

<%--                    <!-- Item -->--%>
<%--                    <div class="item"> <a href="#"><img src="${pageContext.request.contextPath}/user/images/brand5.png" alt="brand logo"> </a> </div>--%>
<%--                    <!-- End Item -->--%>

<%--                    <!-- Item -->--%>
<%--                    <div class="item"> <a href="#"><img src="${pageContext.request.contextPath}/user/images/brand6.png" alt="brand logo"> </a> </div>--%>
<%--                    <!-- End Item -->--%>

<%--                    <!-- Item -->--%>
<%--                    <div class="item"> <a href="#"><img src="${pageContext.request.contextPath}/user/images/brand7.png" alt="brand logo"> </a> </div>--%>
<%--                    <!-- End Item -->--%>

<%--                    <!-- Item -->--%>
<%--                    <div class="item"> <a href="#"><img src="${pageContext.request.contextPath}/user/images/brand8.png" alt="brand logo"> </a> </div>--%>
<%--                    <!-- End Item -->--%>

<%--                    <!-- Item -->--%>
<%--                    <div class="item"> <a href="#"><img src="${pageContext.request.contextPath}/user/images/brand9.png" alt="brand logo"> </a> </div>--%>
<%--                    <!-- End Item -->--%>

<%--                    <!-- Item -->--%>
<%--                    <div class="item"> <a href="#"><img src="${pageContext.request.contextPath}/user/images/brand10.png" alt="brand logo"> </a> </div>--%>
<%--                    <!-- End Item -->--%>

<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>
<%--结束Logo--%>

<!-- 产品特点 -->
<div class="our-features-box">
    <div class="container">
        <div class="row">
            <div class="col-md-3 col-xs-12 col-sm-6">
                <div class="feature-box first"> <i class="icon-plane icons"></i>
                    <div class="content">
                        <h6>快速当天交货</h6>
                    </div>
                </div>
            </div>
            <div class="col-md-3 col-xs-12 col-sm-6">
                <div class="feature-box"> <i class="icon-earphones-alt icons"></i>
                    <div class="content">
                        <h6>为客户提供 24/7 全天候支持</h6>
                    </div>
                </div>
            </div>
            <div class="col-md-3 col-xs-12 col-sm-6">
                <div class="feature-box"> <i class="icon-like icons"></i>
                    <div class="content">
                        <h6>100%满意保证</h6>
                    </div>
                </div>
            </div>
            <div class="col-md-3 col-xs-12 col-sm-6">
                <div class="feature-box last"> <i class="icon-tag icons"></i>
                    <div class="content">
                        <h6>每日优惠折扣</h6>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%--结束--%>
<%@ include file="/WEB-INF/jsp/footer.jsp" %>
</body>
</html>