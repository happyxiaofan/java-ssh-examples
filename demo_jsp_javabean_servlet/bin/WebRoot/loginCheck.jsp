<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<script type="text/javascript">
		function valid(){
			var usr = document.getElementById("username").value;
			var pwd = document.getElementById("password").value;
			if(usr == '' || pwd == ''){
				alert("请输入用户或密码");
			}else{
				document.form1.submit();
			}
		}
	</script>
