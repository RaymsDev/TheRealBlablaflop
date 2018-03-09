<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
    	<%@ include file="/includes/mdl.jsp" %>
        <title>BlablaFlop</title>
        <link type="text/css" rel="stylesheet" href="styles.css" />
    </head>
    <body>
        <c:import url="menu/menu.jsp" />
        <c:choose>
            <c:when test="${ empty sessionScope.users }">
            	<div class="expand center">
            		<h4 class="erreur">Aucun utilisateur enregistré</h4>
            	</div>
            </c:when>
            <c:otherwise>
            <table>
                <tr>
                    <th>Email</th>
                    <th>Nom</th>
                </tr>
                <c:forEach items="${ sessionScope.users }" var="mapUsers" varStatus="boucle">
                <tr class="${boucle.index % 2 == 0 ? 'pair' : 'impair'}">
                    <td>${ mapUsers.email }</td>
                    <td>${ mapUsers.name }</td>
                </tr>
                </c:forEach>
            </table>
            </c:otherwise>
        </c:choose>
    </body>
</html>
