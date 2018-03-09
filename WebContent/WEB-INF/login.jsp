<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<%@ include file="/includes/mdl.jsp" %>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Connexion | BlablaFlop</title>
    <link type="text/css" rel="stylesheet" href="styles.css" />
</head>
<body>
   	<c:import url="/WEB-INF/menu/menu.jsp" />
	<br>
	<c:import url="/WEB-INF/login/form.jsp" />
       <br />
       <c:if test="${ statusOK }">
       <c:import url="/WEB-INF/login/card.jsp" />
    </c:if>
</body>
</html>
