<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="http://localhost:8089/SpringMyBaties/js/jquery.min.js"></script>
</head>
<body>
	好麻烦啊
	
	<script>
		$(function(){
			setInterval("validLogin()",1000);
		})
		function validLogin(){
			$.ajax({
                type: "POST",
                url: "valiLlogin.json",
                timeout: 1800000,  //30分钟的超时时间
                async: false,
                success: function(opResult){
                    if('0000'==opResult.respCode){
                    	
                    } else {
                        alert(opResult.respMsg);
                        window.location.href = "/SpringMyBaties/login.jsp";
                    }
                },
                error:function () {
                	alert('操作失败');
                }
            });
		}
	</script>
</body>
</html>