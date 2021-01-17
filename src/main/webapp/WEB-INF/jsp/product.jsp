<%--
  Created by IntelliJ IDEA.
  User: zheng
  Date: 2021/1/6
  Time: 13:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<base href="<%=basePath%>">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link type="text/css" rel="stylesheet" href="css/style.css" />
    <script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="js/menu.js"></script>

    <script type="text/javascript" src="js/lrscroll_1.js"></script>


    <script type="text/javascript" src="js/n_nav.js"></script>

    <link rel="stylesheet" type="text/css" href="css/ShopShow.css" />
    <link rel="stylesheet" type="text/css" href="css/MagicZoom.css" />
    <script type="text/javascript" src="js/MagicZoom.js"></script>

    <script type="text/javascript" src="js/num.js">
        var jq = jQuery.noConflict();
    </script>

    <script type="text/javascript" src="js/p_tab.js"></script>

    <script type="text/javascript" src="js/shade.js"></script>
    <title>${product.name}</title>
</head>
<body>
    <%--引入头部--%>
    <%@include file="common/head.jsp"%>

    <%--显示商品信息--%>
    <div class="i_bg">
        <div class="postion">
            <span class="fl"> ${product.name}</span>
        </div>
        <div class="content">

            <div id="tsShopContainer">
                <div id="tsImgS"><a href="images/${product.filename}" title="Images" class="MagicZoom" id="MagicZoom"><img src="images/${product.filename}" width="390" height="390" /></a></div>
                <div id="tsPicContainer">
                    <div id="tsImgSArrL" onclick="tsScrollArrLeft()"></div>
                    <div id="tsImgSCon">
                        <ul>
                            <li onclick="showPic(0)" rel="MagicZoom" class="tsSelectImg"><img src="images/${product.filename}" tsImgS="images/${product.filename}" width="79" height="79" /></li>
                            <li onclick="showPic(1)" rel="MagicZoom"><img src="images/${product.filename}" tsImgS="images/${product.filename}" width="79" height="79" /></li>
                            <li onclick="showPic(2)" rel="MagicZoom"><img src="images/${product.filename}" tsImgS="images/${product.filename}" width="79" height="79" /></li>
                            <li onclick="showPic(3)" rel="MagicZoom"><img src="images/${product.filename}" tsImgS="images/${product.filename}" width="79" height="79" /></li>
                            <li onclick="showPic(4)" rel="MagicZoom"><img src="images/${product.filename}" tsImgS="images/${product.filename}" width="79" height="79" /></li>
                            <li onclick="showPic(5)" rel="MagicZoom"><img src="images/${product.filename}" tsImgS="images/${product.filename}" width="79" height="79" /></li>
                            <li onclick="showPic(6)" rel="MagicZoom"><img src="images/${product.filename}" tsImgS="images/${product.filename}" width="79" height="79" /></li>
                            <li onclick="showPic(7)" rel="MagicZoom"><img src="images/${product.filename}" tsImgS="images/${product.filename}" width="79" height="79" /></li>
                        </ul>
                    </div>
                    <div id="tsImgSArrR" onclick="tsScrollArrRight()"></div>
                </div>
                <img class="MagicZoomLoading" width="16" height="16" src="images/loading.gif" alt="Loading..." />
            </div>

            <div class="pro_des">
                <div class="des_name">
                    <p>${product.name}</p>
                    ${product.description}
                </div>
                <div class="des_price">
                    本店价格：<b>￥${product.price}</b><br />
                    库存：<span>${product.stock}R</span>
                </div>


                <div class="des_join">
                    <div class="j_nums">
                        <input type="text" value="1" name="" class="n_ipt" />
                        <input type="button" value="" onclick="addUpdate(jq(this));" class="n_btn_1" />
                        <input type="button" value="" onclick="jianUpdate(jq(this));" class="n_btn_2" />
                    </div>
                    <span class="fl"><a onclick="addCart(${product.id})"><img src="images/j_car.png" /></a></span>
                </div>
            </div>

            <div class="s_brand">
                <div class="s_brand_img"><img src="images/sbrand.jpg" width="188" height="132" /></div>
                <div class="s_brand_c"><a href="#">进入品牌专区</a></div>
            </div>
        </div>
        <!--Begin 弹出层-收藏成功 Begin-->
        <div id="fade" class="black_overlay"></div>
        <div id="MyDiv" class="white_content">
            <div class="white_d">
                <div class="notice_t">
                    <span class="fr" style="margin-top:10px; cursor:pointer;" onclick="CloseDiv('MyDiv','fade')"><img src="images/close.gif" /></span>
                </div>
                <div class="notice_c">

                    <table border="0" align="center" style="margin-top:1px;" cellspacing="0" cellpadding="0">
                        <tr valign="top">
                            <td width="40"><img src="images/suc.png" /></td>
                            <td>
                                <span style="color:#3e3e3e; font-size:18px; font-weight:bold;">您已成功收藏该商品</span><br />
                                <a href="#">查看我的关注 >></a>
                            </td>
                        </tr>
                        <tr height="50" valign="bottom">
                            <td>&nbsp;</td>
                            <td><a href="#" class="b_sure">确定</a></td>
                        </tr>
                    </table>

                </div>
            </div>
        </div>
        <!--End 弹出层-收藏成功 End-->


        <!--Begin 弹出层-加入购物车 Begin-->
        <div id="fade1" class="black_overlay"></div>
        <div id="MyDiv1" class="white_content">
            <div class="white_d">
                <div class="notice_t">
                    <span class="fr" style="margin-top:10px; cursor:pointer;" onclick="CloseDiv_1('MyDiv1','fade1')"><img src="images/close.gif" /></span>
                </div>
                <div class="notice_c">

                    <table border="0" align="center" style="margin-top:2px;" cellspacing="0" cellpadding="0">
                        <tr valign="top">
                            <td width="40"><img src="images/suc.png" /></td>
                            <td>
                                <span style="color:#3e3e3e; font-size:18px; font-weight:bold;">宝贝已成功添加到购物车</span><br />
                                购物车共有1种宝贝（3件） &nbsp; &nbsp; 合计：1120元
                            </td>
                        </tr>
                        <tr height="50" valign="bottom">
                            <td>&nbsp;</td>
                            <td><a href="#" class="b_sure">去购物车结算</a><a href="#" class="b_buy">继续购物</a></td>
                        </tr>
                    </table>

                </div>
            </div>
        </div>
        <!--End 弹出层-加入购物车 End-->

        <!--Begin Footer Begin -->
        <div class="b_btm_bg bg_color">
            <div class="b_btm">
                <table border="0" style="width:210px; height:62px; float:left; margin-left:75px; margin-top:30px;" cellspacing="0" cellpadding="0">
                    <tr>
                        <td width="72"><img src="images/b1.png" width="62" height="62" /></td>
                        <td><h2>正品保障</h2>正品行货  放心购买</td>
                    </tr>
                </table>
                <table border="0" style="width:210px; height:62px; float:left; margin-left:75px; margin-top:30px;" cellspacing="0" cellpadding="0">
                    <tr>
                        <td width="72"><img src="images/b2.png" width="62" height="62" /></td>
                        <td><h2>满38包邮</h2>满38包邮 免运费</td>
                    </tr>
                </table>
                <table border="0" style="width:210px; height:62px; float:left; margin-left:75px; margin-top:30px;" cellspacing="0" cellpadding="0">
                    <tr>
                        <td width="72"><img src="images/b3.png" width="62" height="62" /></td>
                        <td><h2>天天低价</h2>天天低价 畅选无忧</td>
                    </tr>
                </table>
                <table border="0" style="width:210px; height:62px; float:left; margin-left:75px; margin-top:30px;" cellspacing="0" cellpadding="0">
                    <tr>
                        <td width="72"><img src="images/b4.png" width="62" height="62" /></td>
                        <td><h2>准时送达</h2>收货时间由你做主</td>
                    </tr>
                </table>
            </div>
        </div>
        <div class="b_nav">
            <dl>
                <dt><a href="#">新手上路</a></dt>
                <dd><a href="#">售后流程</a></dd>
                <dd><a href="#">购物流程</a></dd>
                <dd><a href="#">订购方式</a></dd>
                <dd><a href="#">隐私声明</a></dd>
                <dd><a href="#">推荐分享说明</a></dd>
            </dl>
            <dl>
                <dt><a href="#">配送与支付</a></dt>
                <dd><a href="#">货到付款区域</a></dd>
                <dd><a href="#">配送支付查询</a></dd>
                <dd><a href="#">支付方式说明</a></dd>
            </dl>
            <dl>
                <dt><a href="#">会员中心</a></dt>
                <dd><a href="#">资金管理</a></dd>
                <dd><a href="#">我的收藏</a></dd>
                <dd><a href="#">我的订单</a></dd>
            </dl>
            <dl>
                <dt><a href="#">服务保证</a></dt>
                <dd><a href="#">退换货原则</a></dd>
                <dd><a href="#">售后服务保证</a></dd>
                <dd><a href="#">产品质量保证</a></dd>
            </dl>
            <dl>
                <dt><a href="#">联系我们</a></dt>
                <dd><a href="#">网站故障报告</a></dd>
                <dd><a href="#">购物咨询</a></dd>
                <dd><a href="#">投诉与建议</a></dd>
            </dl>
            <div class="b_tel_bg">
                <a href="#" class="b_sh1">新浪微博</a>
                <a href="#" class="b_sh2">腾讯微博</a>
                <p>
                    服务热线：<br />
                    <span>400-123-4567</span>
                </p>
            </div>
            <div class="b_er">
                <div class="b_er_c"><img src="images/er.gif" width="118" height="118" /></div>
                <img src="images/ss.png" />
            </div>
        </div>
        <div class="btmbg">
            <div class="btm">
                备案/许可证编号：蜀ICP备12009302号-1-www.dingguagua.com   Copyright © 2015-2018 尤洪商城网 All Rights Reserved. 复制必究 , Technical Support: Dgg Group <br />
                <img src="images/b_1.gif" width="98" height="33" /><img src="images/b_2.gif" width="98" height="33" /><img src="images/b_3.gif" width="98" height="33" /><img src="images/b_4.gif" width="98" height="33" /><img src="images/b_5.gif" width="98" height="33" /><img src="images/b_6.gif" width="98" height="33" />
            </div>
        </div>
        <!--End Footer End -->
    </div>
    <script src="js/ShopShow.js"></script>

    <script>
        jq(function () {
            jq(".leftNav").hide();
        })
        function addCart(pid) {
            jq.ajax({
                url:"/cart/addCart",
                data:{"pid":pid},
                type:"get",
                dataType:"json",
                success:function (result) {
                    alert("加入购物车成功!");
                    //清空购物车列表
                    jq(".cars").empty();
                    //动态构建购物车
                    var obj = result;
                    var count = 0;
                    jq.each(obj,function (index,item) {
                        count += item.count;
                        var li ="<li>\n" +
                            "                    <div class=\"img\"><a href=\"#\"><img src=\"images/"+item.fileName+"\" width=\"58\" height=\"58\" /></a></div>\n" +
                            "                    <div class=\"name\"><a href=\"#\">"+item.name+"</a></div>\n" +
                            "                    <div class=\"price\"><font color=\"#ff4e00\">￥"+item.price+"</font> X"+item.count+"</div>\n" +
                            "                </li>";
                        jq(".cars").append(li);
                        jq(".total").html(item.total);
                    })
                    jq(".car_t>span").html(count);
                }
            })
        }
    </script>
</body>
</html>
