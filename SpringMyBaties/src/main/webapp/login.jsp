<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="js/jquery.min.js"></script>
</head>
<body>
	<form id="form1" action="login.json" method="post">
		用户名：<input type="text" name="userName" id="userName"><br/>
		密码：<input type="password" name="pwd" id="userPwd"><br/>
		<input type="button" id="sub" value="登录"><br/>
	</form>
<script>
	$(function(){
		$('#sub').click(function(){
			$.ajax({
                type: "POST",
                url: "valiLlogin.json",
                data: {
                	userName:$('#userName').val(),
                	pwd:$('#userPwd').val()
                },
                timeout: 1800000,  //30分钟的超时时间
                async: false,
                success: function(opResult){
                    if('0000'==opResult.respCode){
                        $('#form1').submit();
                    } else {
                    	 $('#form1').submit();
                        //alert(opResult.respMsg);
                    }
                },
                error:function () {
                	alert('操作失败');
                }
            });
		})
	})
</script>
</body>
</html>