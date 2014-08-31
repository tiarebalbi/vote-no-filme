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
	<link type="text/css" rel="stylesheet" media="screen" href="${path}resources/css/app.css" />
</head>
<body class="container-flex">
	<header>
		<section class=title>Votação</section>
		<section class="message">
			Selecione entre os dois filmes qual você prefere!!!
		</section>
	</header>
	<div id="main">
		<aside id="bar-nav">
			<nav>
				<h1>Menu</h1>
				<a href="#home" class="active"><i class="fa fa-rocket mrm"></i> Filmes</a>
				<a href="#ranking"><i class="fa fa-line-chart mrm"></i> Ranking</a>
				<a href="#sobre"><i class="fa fa-info mrm"></i> Sobre o Projeto</a>
			</nav>
		</aside>
		<section id="content">
			<tiles:insertAttribute name="conteudo" />
		</section>
	</div>
	<footer>
	</footer>
	<script data-main="${path}resources/js/require.config" src="${path}resources/vendor/requirejs/require.js"></script>
</body>
</html>