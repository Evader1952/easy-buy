<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: liujian
  Date: 2021/1/19
  Time: 9:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--Begin Header Begin-->
<html>
<head>
    <link type="text/css" rel="stylesheet" href="/css/style.css"/>
    <script type="text/javascript" src="/js/jquery-1.11.1.min_044d0927.js"></script>
    <script type="text/javascript" src="/js/jquery.bxslider_e88acd1b.js"></script>

    <script type="text/javascript" src="/js/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="/js/menu.js"></script>

    <script type="text/javascript" src="/js/select.js"></script>

    <script type="text/javascript" src="/js/lrscroll.js"></script>

    <script type="text/javascript" src="/js/iban.js"></script>
    <script type="text/javascript" src="/js/fban.js"></script>
    <script type="text/javascript" src="/js/f_ban.js"></script>
    <script type="text/javascript" src="/js/mban.js"></script>
    <script type="text/javascript" src="/js/bban.js"></script>
    <script type="text/javascript" src="/js/hban.js"></script>
    <script type="text/javascript" src="/js/tban.js"></script>
    <script type="text/javascript" src="/js/lrscroll_1.js"></script>
    <script type="text/javascript" src="/ajax/ajaxUtil.js"></script>
    <script type="text/javascript" src="/ajax/cars.js"></script>
</head>
<body>

<div class="soubg">
    <div class="sou">
        <!--Begin 所在收货地区 Begin-->
        <span class="s_city_b">
        	<span class="fl">送货至：</span>
            <span class="s_city">
            	<span>四川</span>
                <div class="s_city_bg">
                	<div class="s_city_t"></div>
                    <div class="s_city_c">
                    	<h2>请选择所在的收货地区</h2>
                        <table border="0" class="c_tab" style="width:235px; margin-top:10px;" cellspacing="0" cellpadding="0">
                          <tr>
                            <th>A</th>
                            <td class="c_h"><span>安徽</span><span>澳门</span></td>
                          </tr>
                          <tr>
                            <th>B</th>
                            <td class="c_h"><span>北京</span></td>
                          </tr>
                          <tr>
                            <th>C</th>
                            <td class="c_h"><span>重庆</span></td>
                          </tr>
                          <tr>
                            <th>F</th>
                            <td class="c_h"><span>福建</span></td>
                          </tr>
                          <tr>
                            <th>G</th>
                            <td class="c_h"><span>广东</span><span>广西</span><span>贵州</span><span>甘肃</span></td>
                          </tr>
                          <tr>
                            <th>H</th>
                            <td class="c_h"><span>河北</span><span>河南</span><span>黑龙江</span><span>海南</span><span>湖北</span><span>湖南</span></td>
                          </tr>
                          <tr>
                            <th>J</th>
                            <td class="c_h"><span>江苏</span><span>吉林</span><span>江西</span></td>
                          </tr>
                          <tr>
                            <th>L</th>
                            <td class="c_h"><span>辽宁</span></td>
                          </tr>
                          <tr>
                            <th>N</th>
                            <td class="c_h"><span>内蒙古</span><span>宁夏</span></td>
                          </tr>
                          <tr>
                            <th>Q</th>
                            <td class="c_h"><span>青海</span></td>
                          </tr>
                          <tr>
                            <th>S</th>
                            <td class="c_h"><span>上海</span><span>山东</span><span>山西</span><span class="c_check">四川</span><span>陕西</span></td>
                          </tr>
                          <tr>
                            <th>T</th>
                            <td class="c_h"><span>台湾</span><span>天津</span></td>
                          </tr>
                          <tr>
                            <th>X</th>
                            <td class="c_h"><span>西藏</span><span>香港</span><span>新疆</span></td>
                          </tr>
                          <tr>
                            <th>Y</th>
                            <td class="c_h"><span>云南</span></td>
                          </tr>
                          <tr>
                            <th>Z</th>
                            <td class="c_h"><span>浙江</span></td>
                          </tr>
                        </table>
                    </div>
                </div>
            </span>
        </span>
        <!--End 所在收货地区 End-->
        <span class="fr">
        	<span class="fl">
                <c:if test="${sessionScope.user==null}">
                    你好，请<a href="login.jsp">登录</a>&nbsp; <a href="reg.jsp" style="color:#ff4e00;">免费注册</a>&nbsp;
                </c:if>
                <c:if test="${sessionScope.user != null}">欢迎您，${sessionScope.user.userName}</c:if>
                    |&nbsp;<a href="/jump/goMemberOrder">我的订单</a>&nbsp;|
            </span>

            <span class="ss">
            	<div class="ss_list">
                	<a href="#">后台管理</a>
                    <div class="ss_list_bg">
                    	<div class="s_city_t"></div>
                        <div class="ss_list_c">
                        	<ul>
                            	<li><a href="/jump/goMemberAddress">收货地址</a></li>
                                <li><a href="/jump/Member">用户信息</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="ss_list">
                	<a href="#">客户服务</a>
                    <div class="ss_list_bg">
                    	<div class="s_city_t"></div>
                        <div class="ss_list_c">
                        	<ul>
                            	<li><a href="#">客户服务</a></li>
                                <li><a href="#">客户服务</a></li>
                                <li><a href="#">客户服务</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="ss_list">
                	<a href="#">网站导航</a>
                    <div class="ss_list_bg">
                    	<div class="s_city_t"></div>
                        <div class="ss_list_c">
                        	<ul>
                            	<li><a href="#">网站导航</a></li>
                                <li><a href="#">网站导航</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </span>
            <span class="fl">|&nbsp;关注我们：</span>
            <span class="s_sh"><a href="#" class="sh1">新浪</a><a href="#" class="sh2">微信</a></span>
            <span class="fr">|&nbsp;<a href="#">手机版&nbsp;<img src="images/s_tel.png" align="absmiddle" /></a></span>
        </span>
    </div>
</div>
<div class="m_top_bg">
    <div class="top">
        <div class="m_logo"><a href="Index.html"><img src="images/logo1.png" /></a></div>
        <div class="m_search">
            <form>
                <input type="text" value="" class="m_ipt" />
                <input type="submit" value="搜索" class="m_btn" />
            </form>
            <span class="fl"><a href="#">咖啡</a><a href="#">iphone 6S</a><a href="#">新鲜美食</a><a href="#">蛋糕</a><a href="#">日用品</a><a href="#">连衣裙</a></span>
        </div>
        <div class="i_car">
            <div class="car_t">购物车 [ <span>3</span> ]</div>
            <div class="car_bg">
                <c:if test="${user == null}">
                    <!--Begin 购物车未登录 Begin-->
                    <div class="un_login">还未登录！<a href="login.jsp" style="color:#ff4e00;">马上登录</a> 查看购物车！</div>
                    <!--End 购物车未登录 End-->
                </c:if>
                <!--Begin 购物车已登录 Begin-->
                <c:if test="${user != null}">
                    <ul class="cars">
                        <c:forEach items="${sessionScope.shopcart}" var="item">
                            <li>
                                <div class="img"><a href="#"><img src="images/${item.fileName}" width="58" height="58" /></a></div>
                                <div class="name"><a href="#">${item.name}</a></div>
                                <div class="price"><font color="#ff4e00">￥${item.price}</font> X${item.count}</div>
                            </li>
                        </c:forEach>
                    </ul>
                    <div class="price_sum">共计&nbsp; <font color="#ff4e00">￥</font><span class="total">${sessionScope.total}</span></div>
                    <div class="price_a"><a href="/jump/goCartList">去购物车结算</a></div>
                </c:if>
                <!--End 购物车已登录 End-->
            </div>
        </div>
    </div>
</div>
</body>
</html>
<!--End Header End-->