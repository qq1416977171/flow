<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>头部</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link href="${pageContext.request.contextPath}/user/css/bootstrap.min.css?" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/user/css/animate.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/user/css/font-awesome.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/user/css/simple-line-icons.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/user/css/owl.carousel.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/user/css/owl.transitions.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/user/css/flexslider.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/user/css/cloud-zoom.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/user/css/revolution-slider.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/user/css/jquery-ui.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/user/css/jquery.fancybox.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/user/css/quick_view_popup.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/user/css/blogmate.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/user/css/jtv-mobile-menu.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/user/css/style.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/user/css/responsive.css" rel="stylesheet">
</head>
<body>

<!-- Header -->
<header>
    <div class="header-container">
        <div class="header-top">
            <div class="container">
                <div class="row">
                    <!-- Header Language -->
                    <div class="col-xs-12 col-sm-6">
                        <div class="welcome-msg hidden-xs">Welcome to Petunia! </div>

                    </div>
                    <div class="col-xs-6 hidden-xs">
                        <!-- Header Top Links -->
                        <div class="jtv-top-links">
                            <div class="links">
                                <ul>
                                    <c:if test="${existUser.username == null }">

                                        <li> <a title="登录" href="${ pageContext.request.contextPath }/user/toLogin"><span class="hidden-xs">登录</span></a> </li>

                                        <li> <a title="注册" href="${ pageContext.request.contextPath }/user/toRegist"><span class="hidden-xs">注册</span></a> </li>
                                    </c:if>

                                    <c:if test="${existUser.username != null }">

                                        <li><span class="hidden-xs">欢迎您<font color="red"> ${existUser.username}</font></span></li>

                                        <li ><a href="${ pageContext.request.contextPath }/user/quit"><span class="hidden-xs">退出</span></a></li>

                                        <li><a href="${ pageContext.request.contextPath }/user/ToEditPassword.action"><span class="hidden-xs">修改密码</span></a></li>

                                        <li><a href="${ pageContext.request.contextPath }/cartController/myCart.action"><span class="hidden-xs">购物车</span></a>

                                        <li><a href="${ pageContext.request.contextPath }/orderController/findByUid.action?page=1"><span class="hidden-xs">我的订单</span></a></li>
                                    </c:if>
                                </ul>
                            </div>
                        </div>
                        <!-- End Header Top Links -->
                    </div>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
                    <div class="jtv-top-cart-box">
                    </div>
                </div>
                <div class="col-lg-6 col-md-4 col-sm-4 col-xs-12 jtv-logo-box">
                    <!-- Header Logo -->
                    <div class="logo"> <a title="logo" href="${pageContext.request.contextPath}/"><img alt="eCommerce" src="${pageContext.request.contextPath}/user/images/logo.png"> </a></div>
                    <!-- End Header Logo -->
                </div>
                <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12 hidden-xs">
                    <div class="search-box">
                        <form action="${ pageContext.request.contextPath }/findFlowerByCsName.action?page=1" method="POST" id="search_mini_form" name="Categories">
                            <input type="text" placeholder="搜索你想找的鲜花" maxlength="70" name="csname" id="search" value="${csname}">
                            <button type="button" class="search-btn-bg" onclick="find()"><span class="glyphicon glyphicon-search"></span>&nbsp;</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</header>
<!-- end header -->

<!-- Navigation -->
<nav>
    <div class="container">
        <div class="mm-toggle-wrap">
            <div class="mm-toggle"><i class="fa fa-align-justify"></i><span class="mm-label">Menu</span> </div>
        </div>
        <div class="nav-inner">
            <!-- BEGIN NAV -->
            <ul id="nav" class="hidden-xs">

                <li class="drop-menu"><a href="${pageContext.request.contextPath}/" class="level-top active"><span>首页</span></a></li>
                <c:forEach items="${cList }" var="c">
                    <li class="drop-menu"><a href=" ${ pageContext.request.contextPath }/flower/findFlowerByCid.action?cid=${c.cid}&page=1"><span>${c.cname }</span></a></li>
                </c:forEach>
                <li class="drop-menu"><a href="${ pageContext.request.contextPath }/help"><span>林语帮助</span></a></li>
                <li class="mega-menu"> <a class="level-top" href="${pageContext.request.contextPath}/"><span>爱 & 浪漫</span></a>
                </li>
                <li class="mega-menu"> <a class="level-top" href="${pageContext.request.contextPath}/"><span>林语推荐</span></a>
                    <div class="jtv-menu-block-wrapper">
                        <div class="jtv-menu-block-wrapper2">
                            <div class="nav-block jtv-nav-block-center">
                                <ul class="level0">
                                    <li class="parent item"> <a href="${pageContext.request.contextPath}/"><span>Flower types</span></a>
                                        <ul class="level1">
                                            <li> <a href="${pageContext.request.contextPath}/"><span>Elegant </span></a> </li>
                                            <li> <a href="${pageContext.request.contextPath}/"><span>sassy &amp; chic</span></a> </li>
                                            <li> <a href="${pageContext.request.contextPath}/"><span>Women's Satchel</span></a> </li>
                                            <li> <a href="${pageContext.request.contextPath}/"><span>Shoulder Bag</span></a> </li>
                                        </ul>
                                    </li>
                                    <li class="parent item"> <a href="${pageContext.request.contextPath}/"><span>Kinds of flowers</span></a>
                                        <ul class="level1">
                                            <li> <a href="${pageContext.request.contextPath}/"><span>fashion Backpack</span></a> </li>
                                            <li> <a href="${pageContext.request.contextPath}/"><span>Rose Gold Saffiano</span></a> </li>
                                            <li> <a href="${pageContext.request.contextPath}/"><span>Black Velvet</span></a> </li>
                                            <li> <a href="${pageContext.request.contextPath}/"><span>Leather Handbags</span></a> </li>
                                        </ul>
                                    </li>
                                    <li class="parent item"> <a href="${pageContext.request.contextPath}/"><span>Annual plants</span></a>
                                        <ul class="level1">
                                            <li> <a href="${pageContext.request.contextPath}/"><span>Sling Bag</span></a> </li>
                                            <li> <a href="${pageContext.request.contextPath}/"><span>Diaper Bags</span></a> </li>
                                            <li> <a href="${pageContext.request.contextPath}/"><span>Laptop Backpack</span></a> </li>
                                            <li> <a href="${pageContext.request.contextPath}/"><span>Benetton Black </span></a> </li>
                                        </ul>
                                    </li>
                                    <li class="parent item"> <a href="${pageContext.request.contextPath}/"><span>Modern roses</span></a>
                                        <ul class="level1">
                                            <li> <a href="${pageContext.request.contextPath}/"><span>Graphite Croco</span></a> </li>
                                            <li> <a href="${pageContext.request.contextPath}/"><span>Swiss Military Red</span></a> </li>
                                            <li> <a href="${pageContext.request.contextPath}/"><span>Hidesign</span></a> </li>
                                            <li> <a href="${pageContext.request.contextPath}/"><span>Benetton</span></a> </li>
                                        </ul>
                                    </li>
                                    <li class="parent item"> <a href="${pageContext.request.contextPath}/"><span>Asiatic Lily</span></a>
                                        <ul class="level1">
                                            <li> <a href="${pageContext.request.contextPath}/"><span>Travel Blue</span></a> </li>
                                            <li> <a href="${pageContext.request.contextPath}/"><span>Charles & Keith</span></a> </li>
                                            <li> <a href="${pageContext.request.contextPath}/"><span>Clutches</span></a> </li>
                                            <li> <a href="${pageContext.request.contextPath}/"><span>wristlets</span></a> </li>
                                        </ul>
                                    </li>
                                    <li class="parent item"> <a href="${pageContext.request.contextPath}/"><span>Corporate</span></a>
                                        <ul class="level1">
                                            <li> <a href="${pageContext.request.contextPath}/"><span>Annual plants</span></a> </li>
                                            <li> <a href="${pageContext.request.contextPath}/"><span>Orchids</span></a> </li>
                                            <li> <a href="${pageContext.request.contextPath}/"><span>NeoStrata</span></a> </li>
                                            <li> <a href="${pageContext.request.contextPath}/"><span>GoodSkin Labs</span></a> </li>
                                        </ul>
                                    </li>
                                </ul>
                            </div>
                            <div class="jtv-nav-banner">
                                <div class="jtv-banner-box">
                                    <div class="jtv-nav-banner-img"> <a href="#"><img src="${pageContext.request.contextPath}/user/images/menu-img2.jpg" alt="Handbag"> </a> </div>
                                </div>
                                <div class="jtv-banner-box">
                                    <div class="jtv-nav-banner-img"> <a href="#"><img src="${pageContext.request.contextPath}/user/images/menu-img3.jpg" alt="Handbag"> </a> </div>
                                </div>
                                <div class="jtv-banner-box jtv-banner-box_last">
                                    <div class="jtv-nav-banner-img"> <a href="#"><img src="${pageContext.request.contextPath}/user/images/menu-img4.jpg" alt="Handbag"> </a> </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </li>
                <li class="mega-menu"> <a class="level-top" href="${pageContext.request.contextPath}/"><span>林语杂志</span></a>
                    <div class="jtv-menu-block-wrapper">
                        <div class="jtv-menu-block-wrapper2">
                            <div class="nav-block jtv-nav-block-center jtv-menu-box-left">
                                <ul class="level0">
                                    <li class="parent item"> <a href="${pageContext.request.contextPath}/"><span>Green roses</span></a>
                                        <ul class="level1">
                                            <li> <a href="${pageContext.request.contextPath}/"><span>Sed in dui</span></a> </li>
                                            <li> <a href="${pageContext.request.contextPath}/"><span>Proin lobortis</span></a> </li>
                                            <li> <a href="${pageContext.request.contextPath}/"><span>Ut vitae neque</span></a> </li>
                                            <li> <a href="${pageContext.request.contextPath}/"><span>Ac egestas neque</span></a> </li>
                                        </ul>
                                    </li>
                                    <li class="parent item"> <a href="${pageContext.request.contextPath}/"><span>Herbarium</span></a>
                                        <ul class="level1">
                                            <li> <a href="${pageContext.request.contextPath}/"><span>Vivamus molesite</span></a> </li>
                                            <li> <a href="${pageContext.request.contextPath}/"><span>Fusce condimentum</span></a> </li>
                                            <li> <a href="${pageContext.request.contextPath}/"><span>Nulla dapibus</span></a> </li>
                                            <li> <a href="${pageContext.request.contextPath}/"><span>Litora torquent</span></a> </li>
                                        </ul>
                                    </li>
                                    <li class="parent item"> <a href="${pageContext.request.contextPath}/"><span>Tulips</span></a>
                                        <ul class="level1">
                                            <li> <a href="${pageContext.request.contextPath}/"><span>Dui ac pretium</span></a> </li>
                                            <li> <a href="${pageContext.request.contextPath}/"><span>Phasellus tempus</span></a> </li>
                                            <li> <a href="${pageContext.request.contextPath}/"><span>Incididunt ut</span></a> </li>
                                            <li> <a href="${pageContext.request.contextPath}/"><span>Elit sed do</span></a> </li>
                                        </ul>
                                    </li>
                                    <li class="parent item"> <a href="${pageContext.request.contextPath}/"><span>Annual plants</span></a>
                                        <ul class="level1">
                                            <li> <a href="${pageContext.request.contextPath}/"><span>Proin viverra</span></a> </li>
                                            <li> <a href="${pageContext.request.contextPath}/"><span>Curabitur rhoncus</span></a> </li>
                                            <li> <a href="${pageContext.request.contextPath}/"><span>Lacus volutpat</span></a> </li>
                                            <li> <a href="${pageContext.request.contextPath}/"><span>Conse ctetur</span></a> </li>
                                        </ul>
                                    </li>
                                </ul>
                            </div>
                            <div class="nav-block nav-block-right std jtv-menu-box-right"><img src="${pageContext.request.contextPath}/user/images/menu-img5.jpg" alt="menu img"> </div>
                        </div>
                    </div>
                </li>
                <li class="nav-custom-link mega-menu"> <a href="#" class="level-top"> <span>关于我们</span> </a>
                    <div class="jtv-menu-block-wrapper custom-menu">
                        <div class="header-nav-dropdown-wrapper">
                            <div class="jtv-custom-box"> <i class="fa fa-laptop"></i>
                                <h4 class="heading">100% Responsive Design</h4>
                                <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium.</p>
                            </div>
                            <div class="jtv-custom-box"> <i class="fa fa-book"></i>
                                <h4 class="heading">Easy Document</h4>
                                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis dignissim erat ut laoreet pharetra.</p>
                            </div>
                            <div class="jtv-custom-box"> <i class="fa fa-fort-awesome"></i>
                                <h4 class="heading">Awesome Icon Fonts</h4>
                                <p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
                            </div>
                            <div class="jtv-custom-box"> <i class="fa fa-home"></i>
                                <h4 class="heading">2 Layout Home Pages</h4>
                                <p>Duis aute irure dolor in reprehenderit in voluptate velit. Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
                            </div>
                        </div>
                    </div>
                </li>
            </ul>
        </div>
    </div>
</nav>
<!-- end nav -->

</body>
</html>
