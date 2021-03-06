<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html class="no-js" ng-app>
<head>
	<meta http-equiv="content-type" content="text/html;charset=UTF-8" />
	<meta charset="utf-8" />
	<tiles:importAttribute name="title" />
	<tiles:importAttribute name="page" />
	<title>${page} - ${title}</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
	<link type="text/css" rel="stylesheet" media="screen" href="/vote-no-filme/resources/css/app.css" />
</head>
<body class="container-flex" ng-app="votacao">
	<header>
		<section class=title>Votação</section>
		<section class="message">
			Selecione entre os dois filmes qual você prefere!!!
		</section>
	</header>
	<div id="main">
		<aside id="bar-nav" ng-controller="UsersCtrl">
			<nav>
				<h1>Menu</h1>
				<a href="#"><i class="fa fa-rocket mrm"></i> Filmes</a>
				<a href="#/ranking"><i class="fa fa-line-chart mrm"></i> Ranking</a>
				<a href="#/sobre"><i class="fa fa-info mrm"></i> Sobre o Projeto</a>
                <a href="https://github.com/tiarebalbi/vote-no-filme" target="_blank"><i class="fa fa-github mrm"></i> Código Fonte</a>
			</nav>
            <div class="usuarios">
                <p>Total de Usuário(s) Conetado(s): {{users.length}}</p>
            </div>

        </aside>
		<section id="content" data-ng-view>
		</section>
	</div>
	<footer>
	</footer>
    <script data-main="/vote-no-filme/resources/js/require.config" src="/vote-no-filme/resources/vendor/requirejs/require.js"></script>
</body>
</html>