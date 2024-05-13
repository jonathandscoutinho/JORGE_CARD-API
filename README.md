# API REST utilizando Spring Framework e Java

### O objetivo desta API é integrar a interface do projeto JorgeCard com o banco de dados MySQL, sendo ela responsável por trafegar todos os dados de requisições entre o cliente e servidor da aplicação.

## Stacks Utilizadas:
- Spring Initializr
- Eclipse IDE
- OpenJDK-17.0
- MySQL
- Insomnia/Postman
<hr>

## Construindo nossa API<br>

A API deve criar, atualizar, deletar e listar usuários, decks e cards. A API terá os seguintes endpoints:
- ### POST/localhost:8080/user
Body da requisição:
```
{
        "email": "joao@email.com",
        "password": "senhaJoao"
    }
```
Em que:

**email:** Chave primária do usuário.<br>
**password:** Senha do usuário.

Deve retornar com body em JSON com um dos códigos a seguir:

**201:** em caso de sucesso com o corpo da requisição.<br>
**400:** caso o JSON seja inválido.<br>
**500:** caso exista algum erro ou falha no código.<br>

- ### PUT/localhost:8080/user
```
{
        "email": "joao@email.com",
        "password": "senhaJoaoNova"
    }
```
Em que:

**email:** Chave primária do usuário.<br>
**password:** Senha do usuário.

Deve retornar com body em JSON com um dos códigos a seguir:

**201:** em caso de sucesso com a senha atualizada.<br>
Obs: O email é a primary key, por este motivo ele não pode ser alterado, somento a coluna password.

- ### DELETE/localhost:8080/email@example.com: remove o usuário.

Deve aceitar uma requisição com body vazio e retornar 204.

- ### GET/localhost:8080/user: retorna estatísticas básicas sobre os usuários criados.

```
[
	{
		"email": "astrogildo@email.com",
		"password": "senhaAstrogildo"
	},
	{
		"email": "Joao@email.com",
		"password": "senhaJoaoNova"
	}
]
```

A resposta deve conter os códigos a seguir:

**200:** caso a requisição tenha sucesso.
