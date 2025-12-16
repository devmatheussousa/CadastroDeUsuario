# Cadastro de Usuários – API REST com Spring Boot

Este projeto é uma **API REST para cadastro de usuários**, desenvolvida com **Spring Boot**, com foco em boas práticas de Back-end, organização de camadas e uso de padrões comuns no ecossistema Java.

O objetivo principal é servir como **projeto de estudo e base inicial** para aplicações mais completas, abordando desde a configuração do projeto até a criação de endpoints REST.

---

## 🚀 Tecnologias Utilizadas

* **Java**
* **Spring Boot**
* **Spring Web**
* **Spring Data JPA**
* **Maven**
* **H2 / PostgreSQL / MySQL** (configurável)
* **Git & GitHub**

---

## 📌 Funcionalidades (inicial)

* Cadastro de usuários
* Listagem de usuários
* Busca de usuário por ID
* Atualização de dados do usuário
* Exclusão de usuário

*(Novas funcionalidades serão adicionadas conforme a evolução do projeto)*

---

## 🧱 Estrutura do Projeto

```bash
src/
 ├── main/
 │   ├── java/
 │   │   └── org.example
 │   │       ├── controller   # Camada de Controllers (REST)
 │   │       ├── service      # Regras de negócio
 │   │       ├── repository   # Acesso a dados
 │   │       └── model        # Entidades
 │   └── resources/
 │       ├── application.properties
 │       └── static/
 └── test/
```

---

## ▶️ Como Executar o Projeto

### Pré-requisitos

* Java 17+ (ou versão compatível com o projeto)
* Maven

### Passos

```bash
# Clonar o repositório
git clone https://github.com/seu-usuario/seu-repositorio.git

# Entrar no diretório do projeto
cd CadastroDeUsuario

# Executar o projeto
./mvnw spring-boot:run
```

A aplicação estará disponível em:

```
http://localhost:8080
```

---

## 🔗 Endpoints (exemplo)

```http
POST   /users
GET    /users
GET    /users/{id}
PUT    /users/{id}
DELETE /users/{id}
```

---

## 📚 Objetivo do Projeto

Este repositório faz parte do meu processo de aprendizado em **Spring Boot e desenvolvimento Back-end**, servindo como base para:

* Evoluir para autenticação e autorização (Spring Security)
* Implementar DTOs e validações
* Trabalhar com banco de dados real
* Aplicar boas práticas de arquitetura

---

## 👨‍💻 Autor

**Matheus Sousa**
Estudante e desenvolvedor Back-end focado em Java e Spring Boot.

---

## 📄 Licença

Este projeto é apenas para fins educacionais.
