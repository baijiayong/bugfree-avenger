<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ page import="com.baldurtech.Member"%>
<%
    Member member = (Member) request.getAttribute("member");
%>
<html>
    <head>
        <title>删除会员成功</title>
    </head>
    <body>
        <h1>成功删除<%=member.getId()%>号会员</h1> 
    </body>
</html>