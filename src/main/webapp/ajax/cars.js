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
            var obj = result.shopcart;
            var count = 0;
            jq.each(obj,function (index,item) {
                count += item.count;
                var li ="<li>\n" +
                    "                    <div class=\"img\"><a href=\"#\"><img src=\"images/"+item.fileName+"\" width=\"58\" height=\"58\" /></a></div>\n" +
                    "                    <div class=\"name\"><a href=\"#\">"+item.name+"</a></div>\n" +
                    "                    <div class=\"price\"><font color=\"#ff4e00\">￥"+item.price+"</font> X"+item.count+"</div>\n" +
                    "                </li>";
                jq(".cars").append(li);
            })
            jq(".total").html(result.total);
            jq(".car_t>span").html(count);
        }
    })
}