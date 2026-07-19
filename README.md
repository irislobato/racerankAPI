# RaceRank - API (Spring Boot)

API REST responsável pelo gerenciamento dos dados do RaceRank. Ela processa as regras de negócio, validação de registros e comunicação com o banco de dados.

## Tecnologias
- Java 17
- Spring Boot 3.x
- Spring Data JPA (Hibernate)
- Banco de Dados: PostgreSQL

## Endpoints Principais
- `GET /voltas`: Lista todas as voltas registradas.
- `POST /voltas`: Registra uma nova volta no sistema.
- `GET /pistas`: Lista todas as pistas cadastradas.
- `GET /pilotos`: Lista todos os pilotos.

## Como rodar
1. Configure a conexão com o banco de dados no arquivo `application.properties` (ou `application.yml`).
2. Rode o comando `mvn spring-boot:run` ou execute a classe principal da aplicação.
3. A API estará disponível em: `http://localhost:8080`

## Configuração do Banco
1. Crie um banco de dados no MySQL com o nome `racerankAPI`.
2. No arquivo `src/main/resources/application.properties`, ajuste o usuário e senha:
   spring.datasource.username=seu_usuario
   spring.datasource.password=sua_senha

Esta API serve como motor de dados para a interface desenvolvida neste repositório: `https://github.com/irislobato/raceRankInterface`