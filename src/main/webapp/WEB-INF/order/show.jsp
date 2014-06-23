<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ page import="com.baldurtech.Member"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    Member member = (Member) request.getAttribute("member");
%>
<html>
    <head>
        <title>个人信息</title>
    </head>
    <body>
        <h1>个人信息</h1>
        <form action="order" method="POST">
            <table border="1">
                <tr>
                    <td>ID</td>
                    <td>Username</td>
                    <td>Sex</td>
                    <td>Address</td>
                    <td>Telephone</td>
                </tr>
                <tr>
                    <td><%=member.getId()%></td>
                    <td><%=member.getUsername()%></td>
                    <td><%=member.getSex()%></td>
                    <td><%=member.getAddress()%></td>
                    <td><%=member.getTelephone()%></td>
                </tr>
            </table>
            <input type="submit" value="Delete" name="action"/>
            <input type="submit" value="Update" name="action"/>
            <input type="hidden" value="<%=member.getId()%>" name="id"/>
        </form>
    </body>
</html>