# Escola REST API

Projeto desenvolvido em **Spring Boot** para gerenciar alunos, disciplinas e notas.
O serviço implementa operações CRUD e autenticação básica para o professor.

---

## Funcionalidades

* Cadastro de alunos
* Cadastro de disciplinas
* Alocação de alunos em disciplinas
* Atribuição de notas
* Listagem de alunos e disciplinas
* Listagem de alunos aprovados e reprovados (nota >=7 é aprovação)
* Testes unitários com cobertura > 80%
* Autenticação do professor (Basic Auth)

---

## Tecnologias utilizadas

* **Java 17**
* **Spring Boot 3**
* **PostgreSQL**
* **Docker + Docker Compose**
* **JUnit 5** para testes unitários
* **Lombok** para simplificação de código
* **Maven** como gerenciador de dependências

---

## Estrutura do projeto

```
school-rest/
├── src/
│   ├── main/
│   │   ├── java/edu/project/school/
│   │   │   ├── controller/
│   │   │   ├── entity/
│   │   │   ├── service/
│   │   │   ├── repository/
│   │   │   └── dto/
│   │   └── resources/
│   │       └── application.yml
│   └── test/
│       └── java/edu/project/school/
│           ├── controller/
│           └── service/
├── docker-compose.yml
└── pom.xml
```

---

## Rodando a aplicação

1️⃣ Subir os containers com Docker:

```bash
docker-compose up --build
```

Isso cria containers para:

* **PostgreSQL** (nome: `meu-postgres`, banco: `meubanco`)
* **Spring Boot Application** (nome: `school-app`, porta 8080)

2️⃣ Testar endpoints via **Postman** ou navegador:

### Exemplos:

**Cadastrar aluno**

```http
POST http://localhost:8080/alunos
Authorization: Basic (eduardo:123456)
Content-Type: application/json

{
  "nome": "João Silva",
  "cpf": "123.456.789-00",
  "email": "joao@email.com",
  "telefone": "21999999999",
  "endereco": "Rua A, 123"
}
```

**Listar alunos**

```http
GET http://localhost:8080/alunos
Authorization: Basic (eduardo:123456)
```

**Cadastrar disciplina**

```http
POST http://localhost:8080/disciplinas
Authorization: Basic (eduardo:123456)
Content-Type: application/json

{
  "nome": "Matemática",
  "codigo": "MAT101"
}
```

**Atribuir nota**

```http
POST http://localhost:8080/notas
Authorization: Basic (eduardo:123456)
Content-Type: application/json

{
  "valor": 8.5,
  "aluno": {"id": 1},
  "disciplina": {"id": 1}
}
```

**Listar aprovados em disciplina**

```http
GET http://localhost:8080/notas/aprovados/1
Authorization: Basic (eduardo:123456)
```

**Listar reprovados em disciplina**

```http
GET http://localhost:8080/notas/reprovados/1
Authorization: Basic (eduardo:123456)
```

---

## Testes unitários

Executar todos os testes:

```bash
mvn test
```

* Cobertura > 80%
* Inclui testes de **Controllers** e **Services**
* Usa **H2** como banco em memória para simular operações

---

## Autenticação

* Implementada via **Basic Auth** para o professor
* Usuário: `eduardo`
* Senha: `123456`

> Pode ser estendida para **JWT** futuramente.

---

## Banco de dados

* **PostgreSQL**
* Configuração no `application.yml`:

```yaml
spring:
  datasource:
    url: jdbc:postgresql://postgres:5432/meubanco
    username: eduardo
    password: 123456
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
```

---

## Deploy

* Rodar via **Docker Compose** (como mostrado acima)
* Garantia de ambiente consistente para desenvolvimento e teste

---

## Observações

* Código organizado em **Controllers, Services, Repositories, Entities e DTOs**
* Utilização de **DTOs** evita loops na serialização JSON
* Testes garantem confiabilidade da aplicação
* Docker facilita configuração e execução do PostgreSQL e da aplicação

---

## Autor

**Eduardo De Sá Abrahão** <br/>
Curso: Engenharia de Software
