# Sistema para Cabeleireiros

API REST em Java para controle de clientes, agendamentos, venda de produtos e matricula em cursos para profissionais.

Observacao: o enunciado menciona ASP.NET Web API, mas este projeto foi implementado em Java com Spring Boot porque o restante dos requisitos pede Java, JDBC e Jackson.

## Alunos(as)
Brian Cavalheiro - RGM 34274057
Giovanna Rosa - RGM 35874716
Guilherme Tavares - RGM 33428051
Gustavo Kresko - RGM 27126757

## Tecnologias

- Java 17
- Spring Boot
- Spring Web
- Spring JDBC
- H2 Database
- Jackson

## Regras de negocio aplicadas

- Agendamento so pode ser feito em data futura.
- O salao atende entre 08:00 e 19:00.
- Nao e permitido agendar o mesmo servico no mesmo horario quando ja existir outro atendimento ativo.
- Agendamentos para menos de 24 horas ficam com status `CONFIRMADO`; os demais ficam como `AGENDADO`.
- Agendamento no sabado recebe acrescimo de 10%.
- Cliente profissional recebe 15% de desconto no valor do servico.
- Venda de produtos reduz estoque.
- Cliente profissional recebe 10% de desconto na compra de produtos.
- Cursos so podem ser vendidos para clientes marcados como profissionais.
- Cursos de nivel iniciante recebem 5% de desconto promocional.

## Entidades principais

- `Cliente`
- `Agendamento`

Relacionamento: `Agendamento` possui `clienteId` e `servicoId`, relacionando cliente e servico no banco.

## Como executar

```bash
mvn spring-boot:run
```

API em `http://localhost:8080`

Console H2: `http://localhost:8080/h2-console`

Swagger UI: `http://localhost:8080/swagger-ui/index.html`

OpenAPI JSON: `http://localhost:8080/v3/api-docs`

- JDBC URL: `jdbc:h2:mem:cabeleireirodb`
- User: `sa`
- Password: vazio

## Endpoints

### Clientes

- `GET /clientes`
- `GET /clientes/{id}`
- `POST /clientes`
- `PUT /clientes/{id}`
- `DELETE /clientes/{id}`

Exemplo `POST /clientes`

```json
{
  "nome": "Patricia Alves",
  "telefone": "11977776666",
  "email": "patricia@email.com",
  "profissional": false
}
```

### Agendamentos

- `GET /agendamentos`
- `GET /agendamentos/{id}`
- `POST /agendamentos`
- `PUT /agendamentos/{id}`
- `DELETE /agendamentos/{id}`

Exemplo `POST /agendamentos`

```json
{
  "clienteId": 1,
  "servicoId": 2,
  "dataHora": "2026-04-27T15:00:00",
  "observacoes": "Aplicar mascara reconstrutora"
}
```

### Catalogo

- `GET /catalogo/produtos`
- `GET /catalogo/servicos`
- `GET /catalogo/cursos`

### Vendas de produtos

- `POST /vendas/produtos`

Exemplo:

```json
{
  "clienteId": 2,
  "produtoId": 1,
  "quantidade": 3
}
```

### Cursos

- `POST /cursos/matriculas`

Exemplo:

```json
{
  "clienteId": 2,
  "cursoId": 1
}
```

## Teste por codigo Java

Arquivo: `src/main/java/br/com/trabalho/cabeleireiro/client/ApiDemoClient.java`

Esse cliente usa `HttpURLConnection` e `ObjectMapper` do Jackson para:

- serializar objeto para JSON
- enviar requisicao HTTP
- desserializar a resposta JSON

## Banco de dados

O banco e iniciado automaticamente pelos arquivos:

- `src/main/resources/schema.sql`
- `src/main/resources/data.sql`