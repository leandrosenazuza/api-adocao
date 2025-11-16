# Sistema de Adoção - API Backend

API REST desenvolvida em Spring Boot para gerenciamento de adoção de animais.

## 📋 Índice

- [Pré-requisitos](#pré-requisitos)
- [Instalação e Configuração](#instalação-e-configuração)
- [Como Executar](#como-executar)
- [Estrutura do Projeto](#estrutura-do-projeto)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Endpoints da API](#endpoints-da-api)
- [Banco de Dados](#banco-de-dados)

---

## 🔧 Pré-requisitos

Antes de começar, certifique-se de ter instalado:

- **Java 17** ou superior
  - Verificar instalação: `java -version`
- **Maven 3.6+**
  - Verificar instalação: `mvn -version`
- **Docker** e **Docker Compose**
  - Verificar instalação: `docker --version` e `docker-compose --version`
- **IDE** (IntelliJ IDEA, Eclipse, VS Code, etc.)

---

## 📦 Instalação e Configuração

### 1. Clonar o Repositório

```bash
git clone <url-do-repositorio>
cd api-adocao
```

### 2. Verificar Estrutura do Projeto

Certifique-se de que a estrutura do projeto está correta:

```
api-adocao/
├── src/
│   └── main/
│       ├── java/
│       │   └── api_adocao/
│       └── resources/
│           ├── application.properties
│           └── database/
│               └── scripts.sql
├── docker-compose.yml
└── pom.xml
```

---

## 🚀 Como Executar

### Passo 1: Iniciar o PostgreSQL via Docker

Abra o terminal na raiz do projeto e execute:

```bash
docker-compose up -d
```

**O que acontece:**
- Baixa a imagem do PostgreSQL 16 (se necessário)
- Cria e inicia o container `postgres_adocao`
- Cria o volume para persistência dos dados
- PostgreSQL fica disponível na porta **5432**

**Verificar se o container está rodando:**
```bash
docker-compose ps
```

Você deve ver algo como:
```
NAME                STATUS          PORTS
postgres_adocao     Up X seconds    0.0.0.0:5432->5432/tcp
```

**Ver logs do PostgreSQL (opcional):**
```bash
docker-compose logs -f postgres
```

### Passo 2: Compilar o Projeto

No terminal, na raiz do projeto:

```bash
mvn clean install
```

Este comando irá:
- Limpar builds anteriores
- Baixar todas as dependências do Maven
- Compilar o projeto
- Executar os testes (se houver)

### Passo 3: Executar a Aplicação

#### Opção A: Via IDE (Recomendado)

1. Abra o projeto na sua IDE (IntelliJ IDEA, Eclipse, etc.)
2. Localize a classe `ApiAdocaoApplication.java` em:
   ```
   src/main/java/api_adocao/ApiAdocaoApplication.java
   ```
3. Clique com o botão direito na classe
4. Selecione **Run 'ApiAdocaoApplication'** ou **Debug 'ApiAdocaoApplication'**

#### Opção B: Via Maven

```bash
mvn spring-boot:run
```

#### Opção C: Via JAR

```bash
mvn clean package
java -jar target/api-adocao-0.0.1-SNAPSHOT.jar
```

### Passo 4: Verificar se a Aplicação Está Rodando

Após iniciar, você deve ver no console:

```
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/

 :: Spring Boot ::                (v3.3.3)

...
Started ApiAdocaoApplication in X.XXX seconds
```

A aplicação estará disponível em: **http://localhost:8080**

### Passo 5: Verificar a API (Opcional)

**Swagger UI:**
- Acesse: http://localhost:8080/swagger-ui.html
- Aqui você pode ver e testar todos os endpoints da API

**Health Check:**
```bash
curl http://localhost:8080/actuator/health
```

---

## 🗄️ Banco de Dados

### Credenciais do PostgreSQL

- **Host:** localhost
- **Porta:** 5432
- **Database:** adocao-db
- **Usuário:** admin
- **Senha:** admin
- **URL JDBC:** `jdbc:postgresql://localhost:5432/adocao-db`

### Acessar via PgAdmin (Opcional)

1. Inicie o PgAdmin (se não estiver rodando):
   ```bash
   docker-compose up -d pgadmin
   ```

2. Acesse: http://localhost:8002

3. Login:
   - **Email:** admin@admin.com
   - **Senha:** admin

4. Adicionar servidor:
   - Clique em "Add New Server"
   - Na aba **General:**
     - Name: `Adocao DB`
   - Na aba **Connection:**
     - Host: `postgres` (nome do serviço no docker-compose)
     - Port: `5432`
     - Database: `adocao-db`
     - Username: `admin`
     - Password: `admin`
   - Clique em "Save"

### Inicialização dos Dados

O projeto possui um `DataInitializer` que:
1. Verifica se já existem dados no banco
2. Se não existir, executa o script `scripts.sql`
3. Popula o banco com dados iniciais:
   - Espécies (Gato, Cachorro, Pássaro)
   - Portes (Pequeno, Médio, Grande)
   - Raças
   - Comportamentos
   - Cirurgias
   - Usuários padrão
   - Animais de exemplo
   - Estatísticas de municípios

### Comandos Úteis do Docker

```bash
# Parar o PostgreSQL
docker-compose stop postgres

# Iniciar o PostgreSQL novamente
docker-compose start postgres

# Parar e remover containers (mantém volumes)
docker-compose down

# Parar e remover containers e volumes (apaga dados!)
docker-compose down -v

# Ver logs em tempo real
docker-compose logs -f postgres

# Ver status dos containers
docker-compose ps
```

---

## 📁 Estrutura do Projeto

```
api-adocao/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── api_adocao/
│   │   │       ├── Config/          # Configurações (DataInitializer, etc.)
│   │   │       ├── Controller/     # Controllers REST
│   │   │       ├── Model/          # Entidades JPA e DTOs
│   │   │       ├── Repository/     # Repositórios JPA
│   │   │       ├── Service/        # Lógica de negócio
│   │   │       └── Util/           # Utilitários e Mappers
│   │   └── resources/
│   │       ├── application.properties
│   │       └── database/
│   │           └── scripts.sql     # Script de inicialização
│   └── test/                       # Testes
├── docker-compose.yml              # Configuração Docker
├── pom.xml                         # Dependências Maven
└── README.md
```

---

## 🛠️ Tecnologias Utilizadas

### Backend
- **Java 17**
- **Spring Boot 3.3.3**
- **Spring Data JPA**
- **Hibernate**
- **Maven**

### Banco de Dados
- **PostgreSQL 16**
- **Docker** (para containerização)

### Ferramentas
- **Swagger/OpenAPI** (Documentação da API)
- **Lombok** (Redução de boilerplate)
- **MapStruct** (Mapeamento de objetos)

---

## 📡 Endpoints da API

A API está documentada via Swagger. Após iniciar a aplicação, acesse:

**Swagger UI:** http://localhost:8080/swagger-ui.html

### Principais Endpoints:

- **Usuários:** `/usuario`
- **Animais:** `/animal`
- **Espécies:** `/especie`
- **Raças:** `/raca`
- **Comportamentos:** `/comportamento`
- **Cirurgias:** `/cirurgia`
- **Estatísticas:** `/estatisticas`
- **Solicitações:** `/solicitacao`
- **IoT:** `/iot`
- **Upload de Imagens:** `/image`

---

## 🐛 Solução de Problemas

### Erro: "Connection to localhost:5432 refused"

**Causa:** PostgreSQL não está rodando.

**Solução:**
```bash
docker-compose up -d postgres
```

### Erro: "Port 5432 is already in use"

**Causa:** Outra instância do PostgreSQL está usando a porta.

**Solução:**
- Pare o PostgreSQL existente, ou
- Altere a porta no `docker-compose.yml` e `application.properties`

### Erro: "Failed to execute SQL script"

**Causa:** Banco de dados não está pronto ou script tem erro.

**Solução:**
1. Verifique se o PostgreSQL está rodando: `docker-compose ps`
2. Verifique os logs: `docker-compose logs postgres`
3. Verifique se o banco foi criado corretamente

### Erro: "Cannot find main class"

**Causa:** Projeto não foi compilado.

**Solução:**
```bash
mvn clean install
```

---

## 📸 Imagens do Frontend

### Tela de Login
A tela de login permite acesso ao sistema com usuário e senha.

![Tela de Login](images/login.png)

**Características:**
- Interface limpa e intuitiva
- Validação de campos obrigatórios
- Background com imagem de animal
- Logo da aplicação "PATA AMADA"

---

### Listagem de Animais
Visualização em cards dos animais cadastrados no sistema.

![Listagem de Animais](images/animais-lista.png)

**Características:**
- Cards com foto, nome, idade e descrição
- Botões de editar e excluir para cada animal
- Botão "Novo animal" para cadastro
- Layout responsivo em grid

---

### Formulário de Cadastro de Animais
Formulário completo para cadastro de novos animais.

![Formulário de Cadastro](images/animais-cadastro.png)

**Campos disponíveis:**
- Nome, Idade, Raça, Sexo
- Comportamento e Cirurgia (opcional)
- Checkboxes: Castrado, Vermifugado, Vacinado
- Descrição do animal
- Upload de imagem ou URL

---

### Monitoramento IoT
Sistema de monitoramento em tempo real utilizando tecnologia IoT.

![Monitoramento IoT](images/monitoramento-iot.png)

**Funcionalidades:**
- Atualização automática a cada 5 segundos
- Monitoramento de temperatura e umidade
- Dados por setor (Setor A, B, C)
- Timestamp de última atualização

**Dados exibidos:**
- Temperatura em °C
- Umidade em %
- Localização do sensor

---

### Estatísticas
Dashboard com estatísticas gerais e por município.

![Estatísticas](images/estatisticas.png)

**Métricas exibidas:**
- Total de Adoções
- Total de Castrações
- Total de Recolhimentos
- Taxa Média de Abandono

**Tabela por Município:**
- Adoções Anuais
- Castrações Anuais
- Recolhimentos
- Taxa de Abandono (%)

---

## 👥 Desenvolvimento

### Adicionar Novas Dependências

Edite o arquivo `pom.xml` e adicione a dependência desejada. Exemplo:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
```

Depois execute:
```bash
mvn clean install
```

### Modificar Scripts SQL

Os scripts de inicialização estão em:
```
src/main/resources/database/scripts.sql
```

Após modificar, reinicie a aplicação. O `DataInitializer` verificará se há dados e executará o script se necessário.

