<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<spring:url value="/" var="path"></spring:url>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="content-type" content="text/html;charset=UTF-8" />
	<meta charset="utf-8" />
	<tiles:importAttribute name="title" />
	<tiles:importAttribute name="page" />
	<title>${page} - ${title}</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
	
</head>
<body>
	<tiles:insertAttribute name="conteudo" />
<%-- 	<script src="${path}resources/vendor/requirejs/require.js"></script> --%>
</body>
</html>