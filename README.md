# verissimobanco
## Como funciona? 
Temos 4 partes do funcionamento da aplicação: DAO, Controller, View e App.
### DAO
contém a classe de conexão ao bando de dados MySQL e as classes com CRUD de suas respectivas tabelas
### Controller
contém as classes que criam objetos DAO para executar regras de negócio e alterar o banco de dados
### View
contém as classes de interface gráfica da aplicação
### App
é onde o método main se encontra para copilar o programa.

## Configuração
Cada servidor sql tem uma senha própria, lembrar de alterar a senha no arquivo Conexão.java dentro do método construtor
Quando o banco de dados é criado ele insere automaticamente 4 agências de id 1-4 e 4 contas de id 1-4
