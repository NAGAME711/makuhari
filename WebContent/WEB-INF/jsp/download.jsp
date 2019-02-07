<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Echo Application</title>
</head>
<body>
  <p>
    Hello <c:out value="${userlist[0].realName}" />
<form:form action="${pageContext.request.contextPath}/download">
		<input type="submit" value='<spring:message code="kk_login_btn" />' />
		</form:form>    
  </p>
</body>
</html>
