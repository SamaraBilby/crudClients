## DESAFIO: CRUD de Clientes

Este projeto consiste na criação de um sistema para gerenciar clientes, permitindo realizar operações de **Criar (Create)**, **Ler (Read)**, **Atualizar (Update)** e **Excluir (Delete)** (CRUD). 
Ele foi desenvolvido com o objetivo de praticar conceitos de persistência de dados, API RESTful e uso de banco de dados relacional.

### Funcionalidades

- ✨ Adicionar novos clientes.
- 🔍 Buscar clientes cadastrados.
- ✏️ Atualizar informações de clientes existentes.
- 🗑️ Remover clientes.

## Modelo JSON para Inserção e Atualização

O modelo abaixo pode ser utilizado como referência para realizar requisições `POST` ou `PUT` na API:

```json
{
  "name": "Renato Carvalho",
  "cpf": "12398765421",
  "income": "5200.00",
  "birthDate": "1986-02-14",
  "children": 2
}
```

### Campos:

- **name**: Nome completo do cliente (string).
- **cpf**: CPF do cliente, sem pontos ou traços (string).
- **income**: Renda mensal do cliente (double).
- **birthDate**: Data de nascimento no formato `YYYY-MM-DD` (string).
- **children**: Quantidade de filhos (número inteiro).


### Requisitos

- ☕ **Java**: Versão 17 ou superior.
- ⚙️ **Spring Boot**: Para a construção da API.

### Como Executar

1. 📥 Clone este repositório.
2. ⚙️ Configure o banco de dados no arquivo `application.properties`.


4. Utilize um cliente REST, como o **Postman** ou **Insommia**, para testar as funcionalidades.
