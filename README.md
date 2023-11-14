# Projeto de Avaliação Técnica UBOTS

## 📌 Introdução

Este é um projeto de avaliação técnica para UBOTS, desenvolvido utilizando Spring Boot, Spring Data JPA, Spring Batch e o banco de dados PostgreSQL.

## ✅ Objetivo

O objetivo deste sistema é otimizar o atendimento ao cliente em uma fintech, distribuindo eficientemente as solicitações para as equipes certas e gerenciando a carga de trabalho dos atendentes.
## 📋 Pré-requisitos

- **Java:** Versão 17.
- **Maven:** Para construção e gerenciamento de dependências.
- **PostgreSQL:** Necessário para armazenamento de dados.


## 🔧 Tecnologias utilizadas

- **[Spring Boot](https://spring.io/projects/spring-boot) (Versão 3.1.5):** Framework utilizado para construir a aplicação.
- **[Spring Web](https://spring.io/projects/spring-boot) (Versão 3.1.5, herdada do Spring Boot):** Componente do Spring Boot para desenvolvimento de aplicações web e criação de endpoints RESTful.
- **[Spring Batch](https://spring.io/projects/spring-boot) (Versão 3.1.5, herdada do Spring Boot):** Utilizado na implementação de jobs.
- **[Spring Data JPA](https://spring.io/projects/spring-data-jpa) (Versão 3.1.5, herdada do Spring Boot):** Facilita a integração com o banco de dados e operações CRUD.
- **[PostgreSQL](https://www.postgresql.org/) (Driver Versão 42.6.0):** Sistema de gerenciamento de banco de dados relacional.
- **[Lombok](https://projectlombok.org/) (Versão 1.18.30):** Biblioteca que ajuda a reduzir o código boilerplate em Java, fornecendo anotações úteis.

## 🚀 Como rodar a aplicação

1. **Configuração do Banco de Dados:** Certifique-se de ter o PostgreSQL em execução. Configure as credenciais do banco de dados e a URL no arquivo `application.yml`.

   ```properties
    spring:
      datasource:
        url: jdbc:postgresql://db:5432/ubots  (Database configurado na imagem docker)
        username: ubots_user (User configurado na imagem docker)
        password: 123456 (Pass configurado na imagem docker)
   ```

2. **Construindo o Projeto:**

   Navegue até o diretório do projeto via terminal/cmd e execute:
   ```bash
   mvn clean install -DskipTests
   ```

3. **Executando a Aplicação:**

   Com o projeto construído, execute:
   ```bash
   mvn spring-boot:run
   ```

   Ou, você pode rodar a aplicação diretamente pelo seu IDE, executando a classe principal com o método `public static void main`.

4. Após isso, a aplicação estará rodando em `http://localhost:8080`.

## 🧪 Testando a Aplicação

Para executar os testes:
```bash
mvn test
```

---

# Deploy da aplicação Spring Boot e PostgreSQL no Docker

Este guia orienta sobre como dockerizar a aplicação Spring Boot com um banco de dados PostgreSQL e a execução automaticas das tabelas descritas no teste.

## Pré-requisitos

Antes de iniciar, certifique-se de que você possui instalado no seu sistema:

- Docker
- Docker Compose
- Maven ou Gradle (dependendo da configuração do seu projeto Spring Boot)

## Início Rápido

Para colocar tudo para funcionar rapidamente, clone este repositório e navegue até o diretório que contém o arquivo `docker-compose.yml`. Depois execute:

```bash
docker-compose up --build -d



