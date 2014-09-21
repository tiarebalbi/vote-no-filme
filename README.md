vote-no-filme
=======================

[![Build Status](https://travis-ci.org/tiarebalbi/vote-no-filme.svg?branch=master)](https://travis-ci.org/tiarebalbi/vote-no-filme)
[![Coverage Status](https://img.shields.io/coveralls/tiarebalbi/vote-no-filme.svg)](https://coveralls.io/r/tiarebalbi/vote-no-filme)
[![Framework](http://img.shields.io/badge/Created%20with-Spring%20Framework-green.svg)](http://img.shields.io/badge/Created%20with-Spring%20Framework-green.svg)


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



