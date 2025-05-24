# 🚀 GitHub API Consumer

Uma API REST desenvolvida em **Spring Boot** que consome a API do GitHub para listar repositórios públicos de usuários autenticados.

## 📋 Sobre o Projeto

Este projeto demonstra como integrar aplicações Spring Boot com APIs externas utilizando as mais recentes tecnologias do ecossistema Spring, incluindo **WebClient** e **HTTP Interface** para comunicação reativa e declarativa com APIs REST.

## 🛠️ Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3.5.0**
- **Spring WebFlux** - Para programação reativa
- **HTTP Interface** - Para declaração de clientes HTTP
- **WebClient** - Cliente HTTP reativo
- **Maven** - Gerenciamento de dependências

## 🏗️ Arquitetura

O projeto segue uma arquitetura em camadas com separação de responsabilidades:

```
src/main/java/com/api/githubc/
├── client/                 # Clientes HTTP para APIs externas
│   ├── GithubClient.java  # Interface declarativa para GitHub API
│   └── GithubClientConfig.java # Configuração do WebClient
├── controller/            # Controllers REST
│   └── GithubController.java
├── dto/                   # Data Transfer Objects
│   └── RepositoryResponseDTO.java
└── GithubcApplication.java # Classe principal
```

## 🔧 Funcionalidades

- ✅ Autenticação via token do GitHub
- ✅ Listagem de repositórios públicos do usuário
- ✅ Integração reativa com WebClient
- ✅ Tratamento de headers customizados
- ✅ Configuração declarativa de clientes HTTP

## 📡 Endpoints

### `GET /v1/repos`

Lista todos os repositórios públicos do usuário autenticado.

**Headers:**
```
token: {seu_github_token}
```

**Resposta:**
```json
[
  {
    "id": "123456789",
    "htmlUrl": "https://github.com/usuario/repositorio",
    "private": false
  }
]
```

## 🚀 Como Executar

### Pré-requisitos

- Java 21+
- Maven 3.8+
- Token de acesso pessoal do GitHub

### Executando a aplicação

1. **Clone o repositório**
   ```bash
   git clone https://github.com/seu-usuario/github-api-consumer.git
   cd github-api-consumer
   ```

2. **Execute a aplicação**
   ```bash
   mvn spring-boot:run
   ```

3. **A API estará disponível em:**
   ```
   http://localhost:8080
   ```

## 🔑 Configuração do Token GitHub

Para usar a API, você precisa de um token de acesso pessoal do GitHub:

1. Acesse: **GitHub → Settings → Developer settings → Personal access tokens**
2. Gere um novo token com as permissões necessárias
3. Use o token no header `token` das requisições

## 🧪 Testando a API

### Com cURL:

```bash
curl -X GET "http://localhost:8080/v1/repos" \
     -H "token: ghp_seu_token_aqui"
```

### Com Postman:

1. **Method:** GET
2. **URL:** `http://localhost:8080/v1/repos`
3. **Headers:** `token: ghp_seu_token_aqui`

## 💡 Destaques Técnicos

### HTTP Interface (Novidade do Spring 6)

O projeto utiliza a nova feature **HTTP Interface** do Spring 6, que permite declarar clientes HTTP de forma similar ao Feign:

```java
public interface GithubClient {
    @GetExchange("/user/repos")
    List<RepositoryResponseDTO> getRepos(
        @RequestHeader("Authorization") String token,
        @RequestParam("visibility") String visibility
    );
}
```

### WebClient Reativo

Configuração moderna do WebClient para comunicação assíncrona:

```java
@Bean
public HttpServiceProxyFactory getHttpServiceProxyFactory() {
    WebClient webClient = WebClient.builder()
        .baseUrl("https://api.github.com")
        .build();
    
    return HttpServiceProxyFactory
        .builderFor(WebClientAdapter.create(webClient))
        .build();
}
```
