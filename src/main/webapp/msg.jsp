<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div id="divcontent">
<table width="850px" border="0" cellspacing="0">
  <tr>
    <td style="padding:30px; text-align:center"><table width="60%" border="0" cellspacing="0" style="margin-top:70px">
      <tr>
        <td style="padding-top:30px"><font style="font-weight:bold; color:#FF0000">
	        ${msg }
        </font>
        <br />
            <br />
          <a href="${ pageContext.request.contextPath }/">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;
         <!--<a href="${ pageContext.request.contextPath }/user/toRegist.action">注册</a>  --> 
          <a href="${ pageContext.request.contextPath }/user/toLogin">登录</a>
         </td>
      </tr>
    </table>
    <h1>&nbsp;</h1></td>
    </tr>
</table>
</div>
</body>
</html>