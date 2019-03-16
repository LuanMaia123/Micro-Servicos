# Desafio/Problema:
Aqui trabalhamos constantemente com grande volume e complexidade de dados. Sabendo disso,precisamos que você elabore uma solução que ofereça armazenamento, processamento e disponibilização desses dados, sempre considerando que tudo deve estar conforme as boas práticas de segurança em TI. Afinal, nosso principal ativo são dados sensíveis dos consumidores brasileiros.

Vamos supor que existam três grandes bases de dados externas que organizam nossas informações. A primeira delas, que chamamos de Base A, é extremamente sensível e deve ser protegida com os maiores níveis de segurança, mas o acesso a esses dados não precisa ser tão performática. A segunda, é a Base B que também possui dados críticos, mas ao contrário da Base A, o acesso precisa ser um pouco mais rápido. Uma outra característica da Base B é que além de consultas ela é utilizada para extração de dados por meio de algoritmos de aprendizado de máquina. A última base, é a Base C, que não possui nenhum tipo de dado crítico, mas precisa de um acesso extremamente rápido.

# Desenvolvimento

### Minha idéia inicial:

<img src="https://github.com/LuanMaia123/desafio/blob/master/8721%20%5BConvertido%5D-01.jpg" alt="Modelo" style="max-width:100%;">

Quando comecei a desenvolver a solução eu estava planejando jogar as imagens dos 3 micro-serviços e dos DBs em um docker-compose(Cheguei a fazer uma parte) porém no meio do processo o docker aparentemente não funciona muito bem no windows, e comecei a ter diversos problemas, desde porta ja está sendo usada ( Apesar de ter removido as imagens e os containers) e também problemas para fazer pull de imagens, como nunca tinha usado essa tecnologia antes, só sabia da existência e beneficios foi um bom estudo porém, não queria disperdiçar mais tempo com algo que estava parecendo mais problema de compatibilidade com SO do que falta de conhecimento.

### Nova Abordagem:

<img src="https://github.com/LuanMaia123/desafio/blob/master/NOVO-01.jpg" alt="Modelo2" style="max-width:100%;">

Decidi iniciar com outra abordagem, após algumas pesquisas verifiquei a possibilidade de ultilizar o Eureka:

Eureka é uma solução de Service Discovery open source desenvolvida pela Netflix e é composta pelos módulos Eureka Server e Eureka Client.   

O Eureka Server consiste em uma aplicação que atua como Service Registry permitindo que outras aplicações registrem suas instâncias, com isso,  ele controla os endereços registrados mantendo-os atualizados e sinalizando quando um serviço não está disponível.

O Eureka Client é um componente Java que facilita a interação com Eureka Server.

Dentre as vantagens de se utilizar o Eureka estão: 

É otimizado para trabalhar em AWS clouds com diferentes regiões;
O Eureka Client possui um serviço básico de load-balancing que utiliza a estratégia round-robin e pode ser utilizado quando não se deseja expor o serviço para o usuário final.
Clients não escritos em Java podem se comunicar com o Eureka Server através de uma API REST.

Para a implementação:
- SpringBoot
- Maven
- Oauth JWT
- Spring Security
- Eureka server e Cliente
- Postgresql
- Mysql
- MongoDb
- Intellij
- Rest
- H2

### 1-Service discovery Eureka discovery-server
Configuração básica para criação do Eureka server.

Com isso resolvi criar mais alguns micro-serviços:

### 2-Micro-serviço de autenticação  authorization
Aplicação simples, com dois usuários pré-criados, um com ROLE USER e outro com ADMIN. Para esta ultilizei o banco de dados H2.

Este micro-serviço vai está na porta 8080.

username=user password=12345 Role USER
username=admin password=12345 Role ADMIN

```bash
curl -X POST -u my-trusted-client:secret "http://localhost:8080/oauth/token?grant_type=password&username=user&password=12345"
```
Com o token gerado será possivel acessar os endpoints dos outros micro-serviços, Base A e B.

### 3-Micro-serviço base A
Base A:

Escolhi o Postgresql, após várias pesquisas verifiquei que o mesmo possui vários niveis de segurança e já tive contato com ele nas experiências que tive até hoje.

- Segurança através das contas dos usuários, e autenticação via TOKEN JWT com ROLES.
- Criptografia de dados. (não aplicado no desafio)
- Controle de sql injection. (pesquisar as melhores formas de fazer esta ação)

- EndPoints: acessar com o Bearer token gerado no Authorization.
- http://localhost:8081/person/all
- http://localhost:8081/person/{id}
- http://localhost:8081/debt/all
- http://localhost:8081/debt/{id}

### 4-Micro-serviço base B

Base B:

Escolhi o Mysql, ele é mais performatico que o postgresql e também possui niveis de segurança, mantive o token como controle de acesso. Também já tive experiência com esse banco de dados por esses motivos escolhi ele.

- Segurança através das contas dos usuários, e autenticação via TOKEN JWT com ROLES.

Poderia ser criado outro micro-serviço para realizar o calculo do score, deixe por meio de um endpoint que retorna um valor randomico.

- EndPoints: acessar com o Bearer token gerado no Authorization.
- http://localhost:8082/person/all
- http://localhost:8082/person/{id}
- http://localhost:8082/asset/all
- http://localhost:8082/asset/{id}
### 5-Micro-serviço base C

Base C:

MongoDB Por se tratar de alta velocidade de acesso aos dados e não necessitar de segurança. Não tenho conhecimento, porém nas pesquisas que fiz achei interessante a solução dado o problema aqui exposto.


Desta forma as aplicações ficam independentes, para uma melhor disponibilização, manutenção sem que eles se afetem.

Claro que essas são aplicações simples objetivando apenas mostrar uma forma de solução para o exposto.

# Escalabilidade

Para escalabilidade com mais pesquisa e estudo, conseguindo ter acesso as ferramentas, eu optaria pelo AWS, como o uso de Lambda, EC2, ElasticSearch etc. Aplicando da melhor forma para os 3 tipos de bases.



# Execução:

Deve-se Executar incialmente o servidor Eureka.
Seguindo pelo micro-serviço Authorization
E as outras Bases.

Com o maven install pode ser montado o JAR:
mvn install

Com o comando pode rodar a aplicação em uma porta diferente tendo assim varias 
instancias da aplicação no Eureka Server:

java -Dserver.port={PORTA NÃO USADA} -jar {NOME DO JAR DA APLICAÇÃO}

Por dentro da IDE: 
Rodar um clean e install 



