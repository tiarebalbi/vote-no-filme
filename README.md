vote-no-filme
=======================

[![Build Status](https://travis-ci.org/tiarebalbi/vote-no-filme.svg?branch=master)](https://travis-ci.org/tiarebalbi/vote-no-filme)
[![Coverage Status](https://img.shields.io/coveralls/tiarebalbi/vote-no-filme.svg)](https://coveralls.io/r/tiarebalbi/vote-no-filme)
[ ![Codeship Status for tiarebalbi/vote-no-filme](https://codeship.io/projects/a1678840-2494-0132-1117-12e55c6fdf6c/status)](https://codeship.io/projects/36919)

--

Projeto demonstração do vote-no-filme.

Execução da aplicação: 

Para executar você pode usar os seguintes comandos: 

	mvn spring-boot:run
	
Ou caso você queira:

	mvn package
	
 - Feito o procedimento acima, você pode pegar o arquivo .war dentro da pasta target e publicar no seu container.

Executando os testes:

Você pode executar os testes de unidade utilizando o comando abaixo:

	mvn clean test -P dev

Você pode executar os testes de integração utilizando o comando abaixo:

	mvn clean verify -P integration-test



