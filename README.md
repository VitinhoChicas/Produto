# 📚 *Projeto Biblioteca Java com Spring*

## 📌 Sobre o Projeto
Este projeto feito na linguagem Java com o framework Spring, contendo operações CRUD e validações essenciais. 

![Diagram de classe](Diagrama.JPG)

## 🚀 Funcionalidades

### 🔹 Métodos HTTP Implementados para todas classes
- *GET*
- *POST*
- *PUT*
- *DELETE*

### ✅ Validações Implementadas
- **Vendedor**: Impede a inserção de CPF e RG  repetidos
- **Deletar Vendedor**:O vendedor não pode ser deletado quando tem um produto vinculado nele
- **Estabelecimento**: Impede a inserção de CNPJ  repetidos
- **Deletar Estabelecimento**:O estabelecimento não pode ser deletado quando tem um produto vinculado nele
- **Produto**: Impede a inserção de descrições  repetidos
- **Campos nulos para todas as classes**: Bloqueia requisições com valores ausentes
- **Campos vazios para todas as classes**: Garante que os dados obrigatórios sejam preenchidos

### 🗄 Banco de Dados Suportados
- *H2* (banco em memória para testes)
- *PostgreSQL* (banco de produção)

### ⚠ Tratamento de Erros
- Retorno de mensagens amigáveis para o usuário
- Padronização de respostas HTTP para erros comuns

---
