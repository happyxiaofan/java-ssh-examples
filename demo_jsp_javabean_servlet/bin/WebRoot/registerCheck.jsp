<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<script type="text/javascript">
		function valid(){
			var usr = document.getElementById("username").value;
			var pwd1 = document.getElementById("password1").value;
			var pwd2 = document.getElementById("password2").value;
			var email = document.getElementById("email").value;
			if(usr == '' || pwd1 == '' || pwd2 == '' || pwd1 != pwd2 || email == ''){
				alert("请重新输入");
			}else{
				document.form1.submit();
			}
		}
	</script>