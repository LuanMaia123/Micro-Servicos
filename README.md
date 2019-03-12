# Desafio/Problema:
Hoje, a Serasa Experian, como dito anteriormente, é o maior Bureau de crédito do Brasil.Aqui trabalhamos constantemente com grande volume e complexidade de dados. Sabendo disso,precisamos que você elabore uma solução que ofereça armazenamento, processamento e disponi-
bilização desses dados, sempre considerando que tudo deve estar conforme as boas práticas de segurança em TI. Afinal, nosso principal ativo são dados sensíveis dos consumidores brasileiros.

Vamos supor que existam três grandes bases de dados externas que organizam nossas informações. A primeira delas, que chamamos de Base A, é extremamente sensível e deve ser protegida com os maiores níveis de segurança, mas o acesso a esses dados não precisa ser tão performática. A segunda, é a Base B que também possui dados críticos, mas ao contrário da Base A, o acesso precisa ser um pouco mais rápido. Uma outra característica da Base B é que além de consultas ela é utilizada para extração de dados por meio de algoritmos de aprendizado de máquina. A última base, é a Base C, que não possui nenhum tipo de dado crítico, mas precisa de um acesso extremamente rápido.


# Arquitetura proposta:

Base A:

Escolhi o Postgresql, após várias pesquisas verifiquei que o mesmo possui vários niveis de segurança e já tive contato com ele nas experiências que tive até hoje.

- Segurança através das contas dos usuários, e autenticação via TOKEN JWT.
- Criptografia de dados.
- Controle de sql injection.

Base B:

Escolhi o Mysql, ele é mais performatico que o postgresql e também possui niveis de segurança, mantive o token e o controle de sql injection pois como ainda existem dados criticos, é necessário manter-los longe de qualquer ataque. Também já tive experiência com esse banco de dados por esses motivos escolhi ele.

- Segurança através das contas dos usuários, e autenticação via TOKEN JWT.
- Controle de sql injection.

Base C:

Por se tratar de alta velocidade de acesso aos dados e não necessitar de segurança. Não tenho conhecimento, porém nas pesquisas que fiz achei interessante a solução dado o problema aqui exposto.


Modelo:


<img src="https://github.com/LuanMaia123/desafio/blob/master/8721%20%5BConvertido%5D-01.jpg" alt="Modelo" style="max-width:100%;">



