<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ page import="com.baldurtech.Member"%>
<%
    Member member = (Member) request.getAttribute("member");
%>
<html>
    <head>
        <title>更新会员</title>
    </head>
    <body>
        <h1>更新<%=member.getId()%>号会员成功</h1>
    </body>
</html>
