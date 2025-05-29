# ERP Logística 🚛📦

Um projeto de ERP para logística, desenvolvido com Spring Boot e seguindo boas práticas de desenvolvimento.

## 🚀 Tecnologias
- **Java 17** + **Spring Boot**
- **Maven** para build e dependências
- **Thymeleaf** para templates
- **JPA/Hibernate** para persistência
- **Swagger/OpenAPI** para documentação da API
- **JUnit** para testes

## 📦 Funcionalidades
✅ Cadastro e gerenciamento de:
- Motoristas
- Veículos
- Produtos
- Pedidos

✅ Integração com Swagger UI para documentação.

✅ Testes automatizados com JUnit.

## 📚 Como rodar o projeto localmente

```bash
# Clone o repositório
git clone https://github.com/JorgeAlmeidaDev/erp-logistica.git

# Navegue até a pasta
cd erp-logistica

# Compile e rode
./mvnw spring-boot:run
Acesse:

Aplicação: http://localhost:8080/

Swagger UI: http://localhost:8080/swagger-ui.html

🤝 Contribuindo
Quer ajudar? Confira as diretrizes no arquivo CONTRIBUTING.md.

📫 Contato

LinkedIn

E-mail

yaml
Copiar
Editar

---

### 🤝 **CONTRIBUTING.md**

```markdown
# Contribuindo para o ERP Logística

🎉 Obrigado por querer colaborar com este projeto!

## Como contribuir

1. **Fork** o projeto.
2. Crie uma branch:
   ```bash
   git checkout -b feature/minha-feature
Faça suas alterações.

Commit e push:

bash
Copiar
Editar
git commit -m "feat: nova feature"
git push origin feature/minha-feature
Abra um Pull Request e aguarde a revisão.

💡 Sugestões de melhorias são sempre bem-vindas!

yaml
Copiar
Editar

---

### ⚙️ **CI/CD: GitHub Actions**

Aqui vai um workflow simples em `.github/workflows/ci.yml` que roda testes automáticos sempre que houver um push/pull request para `main`:

```yaml
name: CI

on:
  push:
    branches: [ "main" ]
  pull_request:
    branches: [ "main" ]

jobs:
  build:
    runs-on: ubuntu-latest

    steps:
      - name: Checkout código
        uses: actions/checkout@v3

      - name: Configurar JDK
        uses: actions/setup-java@v3
        with:
          distribution: 'temurin'
          java-version: '17'

      - name: Build com Maven
        run: ./mvnw clean install

      - name: Rodar testes
        run: ./mvnw test
