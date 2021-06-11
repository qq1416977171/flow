<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>林语花店</title>

</head>
<body class="cms-index-index cms-home-page">

<%--头部--%>
<%@ include file="/WEB-INF/jsp/header.jsp" %>


<!-- 轮播图  -->
<div id="slider">
    <div class="tp-banner-container">
        <div class="tp-banner">
            <ul>
                <li id="slide1" data-transition="3dcurtain-vertical" data-slotamount="7" data-masterspeed="500"
                    data-thumb="${pageContext.request.contextPath}/user/images/slider/slide1.jpg"
                    data-title="Second Slide">
                    <!-- MAIN IMAGE -->
                    <img src="${pageContext.request.contextPath}/user/images/dummy.png" alt="laptopmockup_sliderdy"
                         data-lazyload="${pageContext.request.contextPath}/user/images/slider/slide1.jpg"
                         data-bgposition="right bottom" data-kenburns="on" data-duration="12000"
                         data-ease="Power0.easeInOut" data-bgfit="115" data-bgfitend="100"
                         data-bgpositionend="center top">
                    <!-- LAYERS -->

                    <!-- LAYER NR. 1 -->
                    <div class="tp-caption text1 skewfromrightshort fadeout"
                         data-x="380"
                         data-y="150"
                         data-speed="800"
                         data-start="1000"
                         data-easing="Power3.easeInOut"
                         data-splitin="words"
                         data-splitout="none"
                         data-elementdelay="0.1"
                         data-endelementdelay="0.1"
                         data-endspeed="300"
                         style="z-index: 3; white-space: nowrap;">Flowers
                    </div>

                    <!-- LAYER NR. 2 -->
                    <div class="tp-caption text2 skewfromrightshort fadeout"
                         data-x="380"
                         data-y="250"
                         data-speed="500"
                         data-start="1500"
                         data-easing="Power3.easeInOut"
                         data-splitin="chars"
                         data-splitout="none"
                         data-elementdelay="0.1"
                         data-endelementdelay="0.1"
                         data-endspeed="300"
                         style="z-index: 4; white-space: nowrap;">A Wide Range of Flowers<br>
                        For Everyones Need
                    </div>

                    <!-- LAYER NR. 3 -->
                    <div class="tp-caption text3 skewfromrightshort fadeout hidden-xs"
                         data-x="380"
                         data-y="360"
                         data-speed="1000"
                         data-start="4200"
                         data-easing="Power3.easeInOut"
                         data-splitin="none"
                         data-splitout="none"
                         data-elementdelay="0.1"
                         data-endelementdelay="0.1"
                         data-endspeed="300"
                         style="z-index: 5; white-space: nowrap;"><a href="#">Order Today</a></div>
                </li>
                <!-- SLIDE  -->
                <li id="slide2" data-transition="3dcurtain-vertical" data-slotamount="7" data-masterspeed="500"
                    data-thumb="${pageContext.request.contextPath}/user/images/slider/slide2.jpg"
                    data-title="First Slide">
                    <!-- MAIN IMAGE -->
                    <img src="${pageContext.request.contextPath}/user/images/dummy.png" alt="laptopmockup_sliderdy"
                         data-lazyload="${pageContext.request.contextPath}/user/images/slider/slide2.jpg"
                         data-bgposition="right top" data-kenburns="on" data-duration="12000"
                         data-ease="Power0.easeInOut" data-bgfit="115" data-bgfitend="100"
                         data-bgpositionend="center bottom">
                    <!-- LAYERS -->

                    <!-- LAYER NR. 1 -->
                    <div class="tp-caption text5 skewfromrightshort fadeout"
                         data-x="1080"
                         data-y="150"
                         data-speed="800"
                         data-start="1000"
                         data-easing="Power3.easeInOut"
                         data-splitin="words"
                         data-splitout="none"
                         data-elementdelay="0.1"
                         data-endelementdelay="0.1"
                         data-endspeed="300"
                         style="z-index: 3; white-space: nowrap;">A Perfect
                    </div>

                    <!-- LAYER NR. 2 -->
                    <div class="tp-caption text4 skewfromleftshort fadeout"
                         data-x="1110"
                         data-y="230"
                         data-speed="500"
                         data-start="1500"
                         data-easing="Power3.easeInOut"
                         data-splitin="chars"
                         data-splitout="none"
                         data-elementdelay="0.1"
                         data-endelementdelay="0.1"
                         data-endspeed="300"
                         style="z-index: 4; white-space: nowrap;">Bouquet
                    </div>

                    <!-- LAYER NR. 3 -->
                    <div class="tp-caption text2 skewfromrightshort fadeout"
                         data-x="1050"
                         data-y="350"
                         data-speed="1000"
                         data-start="4200"
                         data-easing="Power3.easeInOut"
                         data-splitin="none"
                         data-splitout="none"
                         data-elementdelay="0.1"
                         data-endelementdelay="0.1"
                         data-endspeed="300"
                         style="z-index: 5; white-space: nowrap;">The Best Choice on the Template
                    </div>
                </li>

                <!-- SLIDE  -->
                <li id="slide3" data-transition="3dcurtain-vertical" data-slotamount="7" data-masterspeed="500"
                    data-thumb="${pageContext.request.contextPath}/user/images/slider/slide3.jpg"
                    data-title="Third Slide">
                    <!-- MAIN IMAGE -->
                    <img src="${pageContext.request.contextPath}/user/images/dummy.png" alt="laptopmockup_sliderdy"
                         data-lazyload="${pageContext.request.contextPath}/user/images/slider/slide3.jpg"
                         data-bgposition="right top" data-kenburns="on" data-duration="12000"
                         data-ease="Power0.easeInOut" data-bgfit="115" data-bgfitend="100"
                         data-bgpositionend="left center">
                    <!-- LAYERS -->

                    <!-- LAYER NR. 1 -->
                    <div class="tp-caption text7 skewfromrightshort fadeout"
                         data-x="650"
                         data-y="150"
                         data-speed="800"
                         data-start="1000"
                         data-easing="Power3.easeInOut"
                         data-splitin="words"
                         data-splitout="none"
                         data-elementdelay="0.1"
                         data-endelementdelay="0.1"
                         data-endspeed="300"
                         style="z-index: 3; white-space: nowrap;">Special for your
                    </div>

                    <!-- LAYER NR. 2 -->
                    <div class="tp-caption text5 skewfromleftshort fadeout"
                         data-x="610"
                         data-y="280"
                         data-speed="500"
                         data-start="1500"
                         data-easing="Power3.easeInOut"
                         data-splitin="chars"
                         data-splitout="none"
                         data-elementdelay="0.1"
                         data-endelementdelay="0.1"
                         data-endspeed="300"
                         style="z-index: 4; white-space: nowrap;">Valentine's Day
                    </div>

                    <!-- LAYER NR. 3 -->
                    <div class="tp-caption text6 skewfromrightshort fadeout"
                         data-x="740"
                         data-y="390"
                         data-speed="1000"
                         data-start="3500"
                         data-easing="Power3.easeInOut"
                         data-splitin="none"
                         data-splitout="none"
                         data-elementdelay="0.1"
                         data-endelementdelay="0.1"
                         data-endspeed="300"
                         style="z-index: 5; white-space: nowrap;">Love is to give. Love is to Remember.
                    </div>
                </li>
            </ul>
            <!--          <div class="tp-bannertimer"></div>
    --> </div>
    </div>
</div>
<!-- END REVOLUTION SLIDER -->

<!-- 轮播图下三个介绍 -->
<div class="jtv-bottom-banner-section">
    <div class="container">
        <div class="row">
            <div class="col-sm-4">
                <c:forEach items="${cList }" var="c">
                <div class="jtv-img-box"><a href="${ pageContext.request.contextPath }/flower/findFlowerByCid.action?cid=${c.cid}&page=1"> <img
                        src="${pageContext.request.contextPath}/user/images/jtv-banner1.jpg" alt="bottom banner">
                    <div class="jtv-banner-info"><span>Special Offer 2o18</span>
                        <h3>Birthday Flowers</h3>
                    </div>
                </a></div>
                </c:forEach>
            </div>
            <div class="col-sm-4">
                <c:forEach items="${cList }" var="c">
                <div class="jtv-img-box"><a href="${ pageContext.request.contextPath }/flower/findFlowerByCid.action?cid=${c.cid}&page=1"> <img
                        src="${pageContext.request.contextPath}/user/images/jtv-banner2.jpg" alt="bottom banner">
                    <div class="jtv-banner-info"><span>Get up to 25% off</span>
                        <h3>Wedding Flowers</h3>
                    </div>
                </a></div>
                </c:forEach>
            </div>
            <div class="col-sm-4">
                <div class="jtv-img-box"><a href="#"> <img
                        src="${pageContext.request.contextPath}/user/images/jtv-banner3.jpg" alt="bottom banner">
                    <div class="jtv-banner-info"><span>Valentine`s Day</span>
                        <h3>Exclusive Bouquets</h3>
                    </div>
                </a></div>
            </div>
        </div>
    </div>
</div>
<!-- end介绍 -->

<%--推荐鲜花--%>
<%--<div class="content-page">--%>
<%--<div class="container">--%>
<%--<!-- Product Tabs-->--%>
<%--<div class="category-product">--%>
<%--<div class="navbar nav-menu">--%>
<%--<div class="navbar-collapse">--%>
<%--<div class="jtv-title">--%>
<%--<h2>鲜花推荐</h2>--%>
<%--</div>--%>
<%--</div>--%>
<%--<!-- /.navbar-collapse -->--%>
<%--</div>--%>
<%--<div class="tab-container">--%>
<%--<!-- tab product -->--%>
<%--<div class="tab-panel active" id="tab-1">--%>
<%--<div class="category-products">--%>
<%--<ul class="products-grid">--%>
<%--<c:forEach items="${hList }" var="h">--%>
<%--<li class="item col-lg-3 col-md-3 col-sm-4 col-xs-6">--%>
<%--<div class="item-inner">--%>
<%--<div class="item-img">--%>
<%--<div class="item-img-info"> <a class="product-image" title="Product Title Here" href="${ pageContext.request.contextPath }/flower/findByPid?pid=${h.pid}"> <img alt="Product Title Here" src="${pageContext.request.contextPath}/${h.image}"> </a>--%>
<%--<div class="jtv-box-hover">--%>
<%--<ul class="add-to-links">--%>
<%--<li><a class="link-quickview" href="${ pageContext.request.contextPath }/flower/findByPid?pid=${h.pid}"><i class="icon-magnifier-add icons"></i><span class="hidden">Quick View</span></a></li>--%>
<%--<li><a class="link-wishlist" href="${ pageContext.request.contextPath }/flower/findByPid?pid=${h.pid}"><i class="icon-heart icons"></i><span class="hidden">Wishlist</span></a></li>--%>
<%--<li><a class="link-compare" href="${ pageContext.request.contextPath }/flower/findByPid?pid=${h.pid}"><i class="icon-shuffle icons"></i><span class="hidden">Compare</span></a></li>--%>
<%--</ul>--%>
<%--</div>--%>
<%--</div>--%>
<%--</div>--%>
<%--<div class="item-info">--%>
<%--<div class="info-inner">--%>
<%--<div class="item-title"> <a title="Product Title Here" href="single_product.html"> ${h.pname} </a> </div>--%>
<%--<div class="item-content">--%>
<%--<div class="rating"> <i class="fa fa-star-o"></i> <i class="fa fa-star-o"></i> <i class="fa fa-star-o"></i> <i class="fa fa-star-o"></i> <i class="fa fa-star-o"></i> </div>--%>
<%--<div class="item-price">--%>
<%--<div class="price-box"> <span class="regular-price"> <span class="price">￥${h.shopPrice}</span> </span> </div>--%>
<%--</div>--%>
<%--<div class="action">--%>
<%--<button class="button btn-cart" type="button" title="" data-original-title="Add to Cart"><span>Add to Cart</span> </button>--%>
<%--</div>--%>
<%--</div>--%>
<%--</div>--%>
<%--</div>--%>
<%--</div>--%>
<%--</li>--%>
<%--</c:forEach>--%>
<%--</ul>--%>
<%--</div>--%>
<%--</div>--%>
<%--</div>--%>
<%--</div>--%>
<%--</div>--%>
<%--</div>--%>
<%--推荐结束--%>


<section class="jtv-bestsell-section">
    <div class="container">
        <div class="slider-items-products">
            <div class="bestsell-block">
                <div class="jtv-block-inner">
                    <div class="block-title">
                        <h2>鲜花推荐</h2>
                    </div>
                </div>
                <div id="bestsell-slider" class="product-flexslider hidden-buttons">
                    <div class="slider-items slider-width-col4 products-grid block-content">
                        <c:forEach items="${hList }" var="h">
                            <div class="item">
                                <div class="item-inner">
                                    <div class="item-img">
                                        <div class="item-img-info"><a class="product-image" title="Product Title Here"
                                                                      href="${ pageContext.request.contextPath }/flower/findByPid?pid=${h.pid}">
                                            <img alt="Product Title Here"
                                                 src="${pageContext.request.contextPath}/${h.image}"> </a>
                                            <div class="jtv-box-hover">
                                                <ul class="add-to-links">
                                                    <li><a class="link-quickview"
                                                           href="${ pageContext.request.contextPath }/flower/findByPid?pid=${h.pid}"><i
                                                            class="icon-magnifier-add icons"></i><span class="hidden">Quick View</span></a>
                                                    </li>
                                                    <li><a class="link-wishlist"
                                                           href="${ pageContext.request.contextPath }/flower/findByPid?pid=${h.pid}"><i
                                                            class="icon-heart icons"></i><span
                                                            class="hidden">Wishlist</span></a></li>
                                                    <li><a class="link-compare"
                                                           href="${ pageContext.request.contextPath }/flower/findByPid?pid=${h.pid}"><i
                                                            class="icon-shuffle icons"></i><span
                                                            class="hidden">Compare</span></a></li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="item-info">
                                        <div class="info-inner">
                                            <div class="item-title"><a title="Product Title Here"
                                                                       href="${ pageContext.request.contextPath }/flower/findByPid?pid=${h.pid}"> ${h.pname} </a>
                                            </div>
                                            <div class="item-content">
                                                <div class="rating"><i class="fa fa-star-o"></i> <i
                                                        class="fa fa-star-o"></i> <i class="fa fa-star-o"></i> <i
                                                        class="fa fa-star-o"></i> <i class="fa fa-star-o"></i></div>
                                                <div class="item-price">
                                                    <div class="price-box"><span class="regular-price"> <span
                                                            class="price">￥${h.shopPrice}</span> </span></div>
                                                </div>
                                                <div class="action">
                                                    <a class="button btn-cart" type="button" title=""
                                                            data-original-title="Add to Cart"
                                                            href="${ pageContext.request.contextPath }/flower/findByPid?pid=${h.pid}">
                                                        <span>Add to Cart</span></a>
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
</section>
<!-- End Bestsell Slider -->


<!-- 热点产品 -->
<section class="special-products">
    <div class="container">
        <div class="slider-items-products">
            <div class="jtv-special-block">
                <div class="jtv-block-inner">
                    <div class="block-title">
                        <h2>最新产品</h2>
                    </div>
                    <div class="jtv-decs-text">
                        花香人更美，芬芳醉人意；玫瑰来传递，情谊不可比；娇艳赛花瓣，迷倒众子君；我心亦在此，望你来青睐。
                        Ut enim ad minim veniam. Duis aute irure dolor in reprehenderit
                        in voluptate velit esse cillum.
                    </div>
                    <c:forEach items="${cList }" var="c">
                    <a href="${ pageContext.request.contextPath }/flower/findFlowerByCid.action?cid=${c.cid}&page=1" class="jtv-more-bnt">More Products</a>
                    </c:forEach>
                    <div class="jtv-box-timer">
                        <div class="countbox_1 timer-grid"></div>
                    </div>
                </div>
                <div id="special-slider" class="product-flexslider hidden-buttons">
                    <div class="slider-items slider-width-col4 products-grid block-content">
                        <c:forEach items="${nList }" var="n">
                            <div class="item">
                                <div class="item-inner">
                                    <div class="item-img">
                                        <div class="item-img-info"><a class="product-image" title="Product Title Here"
                                                                      href="${ pageContext.request.contextPath }/flower/findByPid?pid=${n.pid}">
                                            <img alt="Product Title Here"
                                                 src="${pageContext.request.contextPath}/${n.image}"></a>
                                            <div class="jtv-box-hover">
                                                <ul class="add-to-links">
                                                    <li><a class="link-quickview"
                                                           href="${ pageContext.request.contextPath }/flower/findByPid?pid=${n.pid}"><i
                                                            class="icon-magnifier-add icons"></i><span class="hidden">Quick View</span></a>
                                                    </li>
                                                    <li><a class="link-wishlist"
                                                           href="${ pageContext.request.contextPath }/flower/findByPid?pid=${n.pid}"><i
                                                            class="icon-heart icons"></i><span
                                                            class="hidden">Wishlist</span></a></li>
                                                    <li><a class="link-compare"
                                                           href="${ pageContext.request.contextPath }/flower/findByPid?pid=${n.pid}"><i
                                                            class="icon-shuffle icons"></i><span
                                                            class="hidden">Compare</span></a></li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="item-info">
                                        <div class="info-inner">
                                            <div class="item-title"><a title="Product Title Here"
                                                                       href="single_product.html"> ${n.pname }</a></div>
                                            <div class="item-content">
                                                <div class="rating"><i class="fa fa-star-o"></i> <i
                                                        class="fa fa-star-o"></i> <i class="fa fa-star-o"></i> <i
                                                        class="fa fa-star-o"></i> <i class="fa fa-star-o"></i></div>
                                                <div class="item-price">
                                                    <div class="price-box"><span class="regular-price"> <span
                                                            class="price">￥${n.shopPrice }</span> </span></div>
                                                </div>
                                                <div class="action">
                                                    <a class="button btn-cart" type="button" title=""
                                                            data-original-title="Add to Cart" href="${ pageContext.request.contextPath }/flower/findByPid?pid=${n.pid}"><span>Add to Cart</span>
                                                    </a>
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
</section>
<%--热点结束--%>

<!-- 轮播 Logo -->
<%--<div class="brand-logo">--%>
<%--    <div class="container">--%>
<%--        <div class="slider-items-products">--%>
<%--            <div id="brand-logo-slider" class="product-flexslider hidden-buttons">--%>
<%--                <div class="slider-items slider-width-col6">--%>

<%--                    <!-- Item -->--%>
<%--                    <div class="item"><a href="#"><img src="${pageContext.request.contextPath}/user/images/brand1.png"--%>
<%--                                                       alt="brand logo"> </a></div>--%>
<%--                    <!-- End Item -->--%>

<%--                    <!-- Item -->--%>
<%--                    <div class="item"><a href="#"><img src="${pageContext.request.contextPath}/user/images/brand2.png"--%>
<%--                                                       alt="brand logo"> </a></div>--%>
<%--                    <!-- End Item -->--%>

<%--                    <!-- Item -->--%>
<%--                    <div class="item"><a href="#"><img src="${pageContext.request.contextPath}/user/images/brand3.png"--%>
<%--                                                       alt="Image"> </a></div>--%>
<%--                    <!-- End Item -->--%>

<%--                    <!-- Item -->--%>
<%--                    <div class="item"><a href="#"><img src="${pageContext.request.contextPath}/user/images/brand4.png"--%>
<%--                                                       alt="brand logo"> </a></div>--%>
<%--                    <!-- End Item -->--%>

<%--                    <!-- Item -->--%>
<%--                    <div class="item"><a href="#"><img src="${pageContext.request.contextPath}/user/images/brand5.png"--%>
<%--                                                       alt="brand logo"> </a></div>--%>
<%--                    <!-- End Item -->--%>

<%--                    <!-- Item -->--%>
<%--                    <div class="item"><a href="#"><img src="${pageContext.request.contextPath}/user/images/brand6.png"--%>
<%--                                                       alt="brand logo"> </a></div>--%>
<%--                    <!-- End Item -->--%>

<%--                    <!-- Item -->--%>
<%--                    <div class="item"><a href="#"><img src="${pageContext.request.contextPath}/user/images/brand7.png"--%>
<%--                                                       alt="brand logo"> </a></div>--%>
<%--                    <!-- End Item -->--%>

<%--                    <!-- Item -->--%>
<%--                    <div class="item"><a href="#"><img src="${pageContext.request.contextPath}/user/images/brand8.png"--%>
<%--                                                       alt="brand logo"> </a></div>--%>
<%--                    <!-- End Item -->--%>

<%--                    <!-- Item -->--%>
<%--                    <div class="item"><a href="#"><img src="${pageContext.request.contextPath}/user/images/brand9.png"--%>
<%--                                                       alt="brand logo"> </a></div>--%>
<%--                    <!-- End Item -->--%>

<%--                    <!-- Item -->--%>
<%--                    <div class="item"><a href="#"><img src="${pageContext.request.contextPath}/user/images/brand10.png"--%>
<%--                                                       alt="brand logo"> </a></div>--%>
<%--                    <!-- End Item -->--%>

<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>
<%--结束Logo--%>

<%--九宫格--%>
<div class="jtv-top-banner">
    <div class="container">
        <div class="imgbox"><img src="${pageContext.request.contextPath}/user/images/banner1.jpg" alt=""></div>
        <div class="jtv-cont-box">
            <h3>Flower <br>
                Collection</h3>
            <div class="jtv-line-bg"></div>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod.</p>
        </div>
        <div class="imgbox"><img src="${pageContext.request.contextPath}/user/images/banner2.jpg" alt=""></div>
        <div class="jtv-cont-box2">
            <h3>Peony <br>
                Collection</h3>
            <div class="jtv-line-bg"></div>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod.</p>
        </div>
        <div class="imgbox"><img src="${pageContext.request.contextPath}/user/images/banner3.jpg" alt=""></div>
        <div class="jtv-cont-box3">
            <h3>25% Off<br>
                New Flower</h3>
            <div class="jtv-line-bg"></div>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod.</p>
        </div>
    </div>
</div>
<%--结束九宫格--%>

<!-- 产品特点 -->
<div class="our-features-box">
    <div class="container">
        <div class="row">
            <div class="col-md-3 col-xs-12 col-sm-6">
                <div class="feature-box first"><i class="icon-plane icons"></i>
                    <div class="content">
                        <h6>快速当天交货</h6>
                    </div>
                </div>
            </div>
            <div class="col-md-3 col-xs-12 col-sm-6">
                <div class="feature-box"><i class="icon-earphones-alt icons"></i>
                    <div class="content">
                        <h6>为客户提供 24/7 全天候支持</h6>
                    </div>
                </div>
            </div>
            <div class="col-md-3 col-xs-12 col-sm-6">
                <div class="feature-box"><i class="icon-like icons"></i>
                    <div class="content">
                        <h6>100%满意保证</h6>
                    </div>
                </div>
            </div>
            <div class="col-md-3 col-xs-12 col-sm-6">
                <div class="feature-box last"><i class="icon-tag icons"></i>
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

<script type="text/javascript">
    function find() {
        document.getElementsByTagName("form")[0].submit();
    }
</script>
</body>
</html>