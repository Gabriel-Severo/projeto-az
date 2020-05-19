# Desafio AZ
Esse projeto foi proposto pela empresa AZ como processo seletivo para vaga de estágio
O desafio consistia em desenvolver uma aplicação para venda de automóveis, utilizando como backend Spring e frontend Vue Js.

## Tecnologias
1. [Backend](#backend)
2. [Frontend](#frontend)

## Requisitos
- Java 11
- Yarn >= 1.22.0
- Postgres >=12.3-1
- Node >= 12.16.1

## Banco de dados
Antes de iniciar com a instalação do backend e do frontend é preciso configurar o banco de dados.
No arquivo [application.properties](backend/src/main/resources/application.properties) configure o usuário a senha e o banco de dados dessa forma:
```sql
spring.datasource.url=jdbc:postgresql://localhost/BancoDeDados?createDatabaseIfNotExist=true&&serverTimezone=UTC
spring.datasource.username=Usuario
spring.datasource.password=Senha
spring.jpa.hibernate.ddl-auto=update
```

Por fim crie um banco de dados com o nome o mesmo nome que foi adicionado na configuração.

## Backend
### Instalação
Entre na pasta `backend` e execute o seguinte comando

Instalação no Linux:
```
./mvnw clean package
```
Instalação no Windows:
```
mvnw.cmd clean package
```

### Execução
Após a instalação será criada uma pasta `target`, entre na pasta e execute o comando
```
java -jar backend-0.0.1-SNAPSHOT.jar
```
Então a api estará executando no `localhost:8080`

## Frontend
### Instalação
Entre na pasta `frontend` e execute o seguinte comando
```
yarn
```

### Execução
Após a instalação execute o comando
```
yarn serve
```
Então vue estará executando no `localhost:8081` ou na próxima porta livre nessa sequência.

### Possivel problema
Ao iniciar a api pode ser apareça a seguinte mensagem.
```
***************************
APPLICATION FAILED TO START
***************************

Description:

Web server failed to start. Port 8080 was already in use.

Action:

Identify and stop the process that's listening on port 8080 or configure this application to listen on another port.
```
Se esse problema aparecer é provável que o vue tenha sido iniciado antes da api, pois como a api precisa executar na porta 8080 o vue estará ocupando essa porta porque, ele também executa nessa porta caso ela já não esteja ocupado, então é necessário que inicie a api antes de iniciar o vue.