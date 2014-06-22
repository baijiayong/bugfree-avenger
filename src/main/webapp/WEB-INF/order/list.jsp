<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ page import="java.util.List, com.baldurtech.Member"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
List<Member> memberList = (List<Member>) request.getAttribute("memberList");
%>

<html>
    <head>
        <title>会员信息</title>
    </head>
    <body>
        <h1>会员列表</h1>
        <form action="order" method="POST">
            <table border="1">
                <tr>
                    <td>ID</td>
                    <td>UserName</td>
                    <td>Sex</td>
                    <td>Address</td>
                    <td>Telephone</td>
                </tr>
                <c:forEach var="member" items="${memberList}">
                <tr>
                    <td><a href="?action=Show&id=${member.id}">${member.id}</td>
                    <td>${member.username}</td>
                    <td>${member.sex}</td>
                    <td>${member.address}</td>
                    <td>${member.telephone}</td>
                </tr>
                </c:forEach>
            </table>
        </form>
    </body>
</html>
