<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<title><spring:message code="KKGroup" /></title>

</head>
<body>
	<font color="red">${error }</font>
	<spring:message code="KKGroup" />
	<form:form modelAttribute="loginCommand"
		action="${pageContext.request.contextPath}/loginCheck.do">
		<spring:message code="kk_TX033" />
		<form:input path="name" placeholder="default namespace" />
		<form:errors path="name" cssStyle="color:red" />
		
		<br>
		<spring:message code="KK_TX034" />
		<form:password path="password" />
		<form:errors path="password" cssStyle="color:red" />
		<br>
		<input type="submit" value='<spring:message code="kk_login_btn" />' />
	</form:form>
</body>
</html>