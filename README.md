
# 🧾 Projeto Controle de Gastos

## 📘 Descrição  
O **Controle de Gastos** é uma API REST desenvolvida em **Java com Spring Boot**, com o objetivo de gerenciar contas e despesas pessoais de forma simples e organizada.  
O projeto foi construído com base em boas práticas de arquitetura **MVC (Model-View-Controller)**, utilizando **DTOs, Services e Repository Pattern**, garantindo clareza e manutenibilidade do código.

---

## 🎯 Objetivo do Projeto  
O objetivo principal é aplicar, na prática, os conceitos de **desenvolvimento backend com Spring Boot**, incluindo:  
- Estruturação em camadas (`controller`, `service`, `repository`, `model`, `dto`);  
- Implementação de endpoints REST (CRUD completo);  
- Tratamento de exceções com `@ExceptionHandler`;  
- Validação de dados com `@Valid`;  
- Boas práticas de versionamento e commits semânticos.

---

## 🧩 Tecnologias Utilizadas  
- **Java 17**  
- **Spring Boot 3.x**  
- **Spring Data JPA**  
- **H2 Database** (para ambiente de testes)  
- **Maven**  
- **Lombok**  
- **Postman** (para validação dos endpoints)

---

## 🗂️ Estrutura do Projeto
```
com.sam.controlegastos
 ┣ 📂 controller        → Controladores REST (Camada de entrada da API)
 ┣ 📂 dto               → Objetos de transferência de dados (entrada/saída)
 ┣ 📂 model             → Entidades principais (representam tabelas do banco)
 ┣ 📂 repository        → Interface de persistência (JPA Repositories)
 ┣ 📂 service           → Camada de regras de negócio
 ┗ 📜 Application.java  → Classe principal (Spring Boot)
```

---

## ⚙️ Endpoints Implementados

### **ContaController**
| Método | Endpoint           | Descrição                           | Status  |
|:-------|:------------------|:------------------------------------|:--------|
| **POST** | `/contas`         | Cadastra uma nova conta             | ✅ Ativo |
| **GET**  | `/contas/{id}`    | Busca uma conta pelo ID             | ✅ Ativo |
| **GET**  | `/contas`         | Lista todas as contas cadastradas   | ✅ Ativo |
| **DELETE** | `/contas/{id}`  | Exclui uma conta existente          | ⚙️ Em desenvolvimento |
| **PUT**  | `/contas/{id}`    | Atualiza dados de uma conta         | ⏳ Próximo passo |
| **GET**  | `/contas/resumo`  | Exibe um resumo mensal de gastos    | ⚙️ Em andamento |

---

## 📋 Checkpoints de Desenvolvimento

- ✅ Implementação do `ContaService` com métodos principais (`listarContas`, `excluirConta`, `resumoMensal`).  
- ✅ Criação dos DTOs (`ContaCreateDTO` e `ContaResponseDTO`).  
- ✅ Configuração do `ContaController` com injeção via construtor (`@RestController`, `@RequestMapping("/contas")`).  
- ✅ Testes de endpoints via **Postman**.  
- ✅ Versionamento no GitHub com commits semânticos.  
- ⚙️ Implementação em andamento: `DELETE` e `PUT`.  
- ⏳ Próximos passos: tratamento de exceções globais e documentação Swagger.

---

## 🚀 Como Executar o Projeto Localmente

1. **Clonar o repositório:**
   ```bash
   git clone https://github.com/seu-usuario/controle.gastos.git
   cd controle.gastos
   ```

2. **Compilar o projeto com Maven:**
   ```bash
   mvn clean install
   ```

3. **Executar o projeto:**
   ```bash
   mvn spring-boot:run
   ```

4. **Acessar a API:**
   ```
   http://localhost:8080/contas
   ```

---

## 🧠 Boas Práticas Adotadas
- Validação de dados com `@Valid` e `@NotNull`.  
- Separação de responsabilidades entre camadas.  
- Uso de `ResponseEntity` para padronizar as respostas HTTP.  
- Estrutura clara e nomeação semântica de classes e pacotes.  
- Commits organizados e descritivos, seguindo padrão semântico.

---

## 💡 Próximos Passos
- Implementar o endpoint **PUT /contas/{id}**.  
- Finalizar o endpoint **DELETE /contas/{id}** com retorno DTO.  
- Adicionar tratamento global de exceções (`@ControllerAdvice`).  
- Criar documentação automática com **Springdoc / Swagger**.  

---

## 🧑‍💻 Autor
**Samuel Victor**  
Desenvolvedor em formação, focado em se tornar **Full Stack Júnior**, com ênfase em **Java e Spring Boot**.  
> *Projeto desenvolvido com acompanhamento técnico, priorizando o entendimento teórico e prático de cada camada.*
