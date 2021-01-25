
/**
 * ajax 发送 Get 请求
 * @param url 路径
 * @param data json格式的参数
 * @param fun 回调方法名称
 */
function ajaxGet(url,data,fun){
    $.ajax({
        type : 'get',
        dataType : 'json',
        url : url,
        data : data,
        success : function(data) {
            return ajaxCallBack(fun, data);
        },
        error : function(XMLHttpRequest, textStatus, errorThrown) {
            console.error(textStatus);
            console.error(XMLHttpRequest.status);
            console.error(XMLHttpRequest.readyState);
            // return false;
        },
        complete : function(XMLHttpRequest, textStatus) {
            // 通过XMLHttpRequest取得响应头，sessionstatus
			console.log("comp")
            var sessionstatus = XMLHttpRequest.getResponseHeader("sessionstatus");
            if (sessionstatus == "TIMEOUT") {
                var win = window;
                while (win != win.top){
                    win = win.top;
                }
                win.location.href= XMLHttpRequest.getResponseHeader("path");
            }
        }
    });
}

/**
 * 异步方式执行ajax请求
 * @param url
 * @param data
 * @param funName
 * @returns
 */
function ajaxPost(url,data,funName){
	$.ajax({
		type:'post',
		dataType:'json',
		url:url,
		data:data,
		success:function(data){
			return ajaxCallBack(funName,data) ;
		},
		 error:function(XMLHttpRequest, textStatus, errorThrown){
        	console.error(textStatus);
        	console.error(XMLHttpRequest.status);
        	console.error(XMLHttpRequest.readyState);
        	return false ;
	    },
        complete : function(XMLHttpRequest, textStatus) {
            // 通过XMLHttpRequest取得响应头，sessionstatus
            var sessionstatus = XMLHttpRequest.getResponseHeader("sessionstatus");
            if (sessionstatus == "TIMEOUT") {
                var win = window;
                while (win != win.top){
                    win = win.top;
                }
                win.location.href= XMLHttpRequest.getResponseHeader("path");
            }
        }
	});
}

/**
 * 同步方式执行ajax请求
 * @param url
 * @param data
 * @param funName
 * @returns
 */
function ajaxFunSync(url,data,funName){
	$.ajax({
		type:'post',
		dataType:'json',
		url:url,
		cache:false,  
	    async:false,
		data:data,
		success:function(data){
			ajaxCallBack(funName,data) ;
		},
		 error:function(XMLHttpRequest, textStatus, errorThrown){
        	console.error(textStatus);
        	console.error(XMLHttpRequest.status);
        	console.error(XMLHttpRequest.readyState);
	    }
	});
}

/**
 * 执行ajax回调函数
 * @param funName
 * @param data
 * @returns
 */
function ajaxCallBack(funName,data){
    funName(data) ;
}


$.ajaxSetup( {
    //设置ajax请求结束后的执行动作
    complete :
        function(XMLHttpRequest, textStatus) {
            // 通过XMLHttpRequest取得响应头，sessionstatus
            var sessionstatus = XMLHttpRequest.getResponseHeader("sessionstatus");
            if (sessionstatus == "TIMEOUT") {
                var win = window;
                while (win != win.top){
                    win = win.top;
                }
                win.location.href= XMLHttpRequest.getResponseHeader("CONTEXTPATH");
            }
        }
});