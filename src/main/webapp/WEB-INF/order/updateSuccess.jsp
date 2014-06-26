<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ page import="com.baldurtech.Member"%>
<%
    Member member = (Member) request.getAttribute("member");
%>
<html>
    <head>
        <title>更新会员</title>
        <meta http-equiv="refresh" content="2;URL=order?action=List">
    </head>
    <body>
        <h1>更新<%=member.getId()%>号会员成功</h1>
    </body>
</html>
