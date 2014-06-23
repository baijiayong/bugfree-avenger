<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ page import="com.baldurtech.Member"%>
<%
    Member member = (Member) request.getAttribute("member");
%>
<html>
    <head>
        <title>删除会员成功</title>
        <meta http-equiv="refresh" content="2;URL=order?action=List">
    </head>
    <body>
        <h1>成功删除<%=member.getId()%>号会员</h1> 
        请耐心等待，2秒后自动跳转到会员列表。如若不能自动跳转请点击<a href="order?action=List">会员列表</a>
    </body>
</html>