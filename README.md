# Coderockr Challenge

## Resolução do desafio backend da empresa Coderockr usando Java com SpringBoot.
O [desafio resolvido](https://github.com/engnandogabriel/challneg-codereockr-backend) foi um sistema de armazenamento e gerenciamento de investimentos, 
no qual qual poderemos criar, visualizar com seu valor inicial e saldo esperado e retirar o investimento


## Desenvolvimento
* O sistema foi desenvolvido usando clean architecture e clean code
* Uso de DDD e SOLID;
* Utilização de alguns desing patterns;
* banco de dados PostgreSQL e o framework SpringBoot para criação de API's;

## Instalação

rode os seguintes comandos no terminal
```
git clone git@github.com:engnandogabriel/challneg-codereockr-backend.git
docker compose up
```

#### Rota para criação de uma Owner
POST /owner

```json
{
  "name":"Joh Doe",
  "email":"john.doe@gmail.com"
}
```

#### Rota para criação de um investimento   
POST /investment

expemplo:
```json
{
    "owner_id":"912130d6-9234-4507-bb5c-eb5900de4109",
    "create_date":"2023-01-0",
    "investment":1000
 
    }
```
#### Rota para listar um ivestemento
GET /investment/{id}/view

expemplo:
```
json
 {
    "status": "OK",
    "message": "Success",
    "body": {
        "investment_id": "0b1f0dc0-eca2-444c-95a1-8b19265b4ef6",
        "owner_id": "912130d6-9234-4507-bb5c-eb5900de4109",
        "create_date": "2023-01-01",
        "investment": 1000.0,
        "amount": 1052.34,
        "status": "in_investment"
    }

```
#### Rota para retirar um ivestemento
GET /investment/{id}/withdrawal

expemplo:
```
json
 {
    "status": "OK",
    "message": "Success",
    "body": {
        "investment_id": "0b1f0dc0-eca2-444c-95a1-8b19265b4ef6",
        "owner_id": "912130d6-9234-4507-bb5c-eb5900de4109",
        "create_date": "2023-01-01",
        "investment": 1000.0,
        "amount": 1052.34,
        "status": "withdrawn"
    }

```

#### Rota para listar os investimentos de um usuário
GET /investiment/{owner_id}/page
```json
  {
  "status": "OK",
  "message": "Success",
  "body": {
    "totalElements": 1,
    "totalPages": 1,
    "size": 5,
    "content": [
      {
        "investment_id": "0b1f0dc0-eca2-444c-95a1-8b19265b4ef6",
        "owner_id": "912130d6-9234-4507-bb5c-eb5900de4109",
        "create_date": "2023-01-01",
        "investment": 1000.0,
        "amount": 1052.34,
        "status": "withdrawn"
      }
    ]
  }
```
