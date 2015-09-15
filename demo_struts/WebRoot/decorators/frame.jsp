<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.rhwayfun.ssh.struts.util.Constants" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator"%>
<html>
	<head>
		<title>Demo - <decorator:title default="Welcome!" />
		</title>
		<decorator:head />
	</head>


	<body>
		<div align="center" height="900px">
			<%
				if(session.getAttribute(Constants.USERNAME_KEY) != null) {
			%>
			<table width="100%">
				<tr>
					<td>
						<img src="images/logo4.png">
					</td>
					<td>
						<img src="images/logo2.png" height="90">
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<hr>
					</td>
				</tr>
				<tr>
					<td>
						<table>
							<tr>
								<td>
									<a href="welcome.do">Main</a>
								</td>
							</tr>
							<tr>
								<td>
									<a href="menu1.do">Menu1</a>
								</td>
							</tr>
							<tr>
								<td>
									<a href="menu2.do">Menu2</a>
								</td>
							</tr>
							<tr>
								<td>
									<a href="menu3.do">Menu3</a>
								</td>
							</tr>
							<tr>
								<td>
									<a href="menu4.do">Menu4</a>
								</td>
							</tr>
							<tr>
								<td>
									<a href="menu5.do">Menu5</a>
								</td>
							</tr>
							<tr>
								<td>
									<a href="menu6.do">Menu6</a>
								</td>
							</tr>
							<tr>
								<td>
									<a href="menu7.do">Menu7</a>
								</td>
							</tr>
							<tr>
								<td>
									<a href="menu8.do">Menu8</a>
								</td>
							</tr>
						</table>
					</td>
					<td>
						<decorator:body />
					</td>
				</tr>
			</table>
			<%
				} else {
			%>
			<decorator:body />
			<%
				}
			%>
			
		</div>
		<div align="center" height="10%">
			2015copyright rhwayfun.com
		</div>
	</body>
</html>
