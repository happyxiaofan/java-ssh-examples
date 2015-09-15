
<% 
	session.removeAttribute("username");
	response.sendRedirect("login.jsp");
%>