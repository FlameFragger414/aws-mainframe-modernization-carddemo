# AWS CardDemo Modernization

![Java](https://img.shields.io/badge/Java-21-blue.svg)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.5-green.svg)
![License](https://img.shields.io/badge/license-Apache%202.0-green.svg)

## Overview

This repository contains the **modernized AWS CardDemo application** — a Java 21 / Spring Boot rewrite of the [AWS Mainframe Modernization CardDemo](https://github.com/aws-samples/aws-mainframe-modernization-carddemo) reference application. The original CardDemo is a COBOL/CICS credit card management system used to demonstrate mainframe migration and modernization scenarios on AWS. This project translates that legacy codebase into a cloud-native REST API backed by a relational database.

The modernization preserves the original program naming conventions (for example, `COSGN00C`, `CBTRN02C`, `CVACT01Y`) so teams can trace legacy behavior to its Java equivalent during migration assessments, replatforming, and testing.

## What Changed from the Legacy Application

| Aspect | Legacy CardDemo | This Modernized Version |
|--------|-----------------|-------------------------|
| Language | COBOL, Assembler | Java 21 |
| Runtime | CICS / JCL batch | Spring Boot 3.2.5 |
| Data storage | VSAM, optional DB2/IMS | MySQL via Spring Data JPA |
| Interface | 3270 terminal screens | REST APIs |
| Deployment | Mainframe datasets | Docker / container-ready JAR |
| Build | JCL compile jobs | Maven |

For additional migration rationale and mapping notes, see [docs/modernization.md](docs/modernization.md).

## Repository Statistics

| Category | Count |
|----------|------:|
| Total project files (excluding `.git`) | 295 |
| Java source files | 282 |
| Total Java lines of code | ~128,000 |
| REST controllers | 67 |
| Service implementations | 67 |
| JPA entities | 37 |
| Repositories | 37 |
| Unit test classes | 29 |
| DTOs | 3 |
| Exception classes | 2 |
| Batch components | 1 |

## Technology Stack

- **Java 21** with **Spring Boot 3.2.5**
- **Spring Data JPA** for persistence
- **Spring Web** for REST endpoints
- **Spring Validation** for input validation
- **Spring Actuator** for health and metrics
- **MySQL** (default; compatible with AWS RDS)
- **Lombok** for boilerplate reduction
- **MapStruct 1.5.5** for object mapping
- **Maven** build system
- **Docker** multi-stage container build

## Project Structure

```
.
├── README.md                          # This file — project summary
├── pom.xml                            # Maven build configuration
├── LICENSE                            # Apache 2.0 license
├── NOTICE                             # Copyright notice (Amazon.com, Inc.)
├── CODE_OF_CONDUCT.md                 # Community conduct guidelines
├── CONTRIBUTING.md                    # Contribution guidelines
├── .gitignore                         # Git ignore rules
├── docker/
│   └── Dockerfile                     # Multi-stage Docker build
├── docs/
│   └── modernization.md               # Migration report and mapping strategy
├── push_flow_batch.sh                 # Git push helper (flow/batch migration)
├── push_high_fidelity.sh              # Git push helper (high-fidelity migration)
├── push_mass_migration.sh             # Git push helper (mass migration)
├── push_ultra_deep.sh                 # Git push helper (ultra-deep migration)
└── src/
    ├── main/
    │   ├── java/com/aws/carddemo/
    │   │   ├── CardDemoApplication.java       # Spring Boot entry point
    │   │   ├── batch/
    │   │   │   └── AccountImportBatch.java    # CBACT01C batch migration
    │   │   ├── controller/                    # 67 REST controllers
    │   │   ├── exception/                     # Custom exceptions
    │   │   ├── model/
    │   │   │   ├── dto/                       # Data transfer objects
    │   │   │   └── entity/                    # JPA entities (37 tables)
    │   │   ├── repository/                    # Spring Data JPA repositories
    │   │   └── service/                       # Service interfaces + impl/
    │   └── resources/
    │       └── application.yml                # App and database configuration
    └── test/
        └── java/com/aws/carddemo/service/     # 29 service unit test classes
```

## Architecture

The application follows a standard Spring Boot layered architecture:

```
REST Controller  →  Service Interface  →  Service Implementation  →  Repository  →  MySQL
```

- **Controllers** expose HTTP endpoints under `/api/v1/`.
- **Services** contain business logic migrated from COBOL programs.
- **Repositories** provide CRUD access via Spring Data JPA.
- **Entities** map legacy COBOL copybook record layouts to relational tables.

### High-Fidelity vs. Generated Logic

Some services contain **high-fidelity migrations** with real business logic ported from COBOL:

| Java Class | Legacy Source | Description |
|------------|---------------|-------------|
| `AccountImportBatch` | `CBACT01C.CBL` | Sequential account file import with legacy record parsing |
| `InterestCalculationServiceImpl` | `CBACT04C.CBL` | Monthly interest calculation and transaction posting |
| `AccountServiceImpl` | `COACTUPC.CBL` | Account update with optimistic locking and validation |
| `NavigationController` | `COMEN01C.CBL` | Main menu navigation mapped to REST endpoints |

The remaining COBOL program services (for example, `Cosgn00cServiceImpl`, `Cbtrn02cServiceImpl`) follow a generated step-based structure (`processStep1` through `processStepN`) representing the translated procedural flow from the original programs.

## Application Entry Point

**`CardDemoApplication.java`** — Standard Spring Boot bootstrap class that starts the embedded web server on port 8080.

## Configuration

**`src/main/resources/application.yml`**

| Setting | Default | Description |
|---------|---------|-------------|
| `spring.datasource.url` | `jdbc:mysql://localhost:3306/carddemo` | Database connection (override with `DB_URL`) |
| `spring.datasource.username` | `root` | Database user (override with `DB_USERNAME`) |
| `spring.datasource.password` | `password` | Database password (override with `DB_PASSWORD`) |
| `spring.jpa.hibernate.ddl-auto` | `update` | Auto-create/update schema |
| `server.port` | `8080` | HTTP port |
| `management.endpoints.web.exposure.include` | `health,info,metrics` | Actuator endpoints |

## Domain Model (JPA Entities)

Entities mirror legacy COBOL copybook structures. Core business entities:

| Entity | Legacy Copybook | Purpose |
|--------|-----------------|---------|
| `Customer` | `CVCUS01Y.cpy` | Customer master data |
| `Account` | `CVACT01Y.cpy` | Account balances, limits, and status |
| `Card` | `CVACT02Y.cpy` | Credit card details |
| `Transaction` | `CVTRA05Y.cpy` | Transaction records |
| `Custrec` | `CUSTREC.cpy` | Customer record composite |

Reference and supporting entities (mapped from additional copybooks):

`Cvact01Y`, `Cvact02Y`, `Cvact03Y`, `Cvcrd01Y`, `Cvcus01Y`, `Cvtra01Y`–`Cvtra07Y`, `Csusr01Y`, `Csmsg01Y`, `Csmsg02Y`, `Csdat01Y`, `Csdb2Rwy`, `Cslkpcdy`, `Csutldwy`, `Ccpauery`, `Ccpaurly`, `Ccpaurqy`, `Cipaudty`, `Cipausmy`, `Coadm02Y`, `Cocom01Y`, `Codatecn`, `Comen02Y`, `Cottl01Y`, `Cvexport`, `Imsfuncs`, `Unused1Y`

## Data Transfer Objects

| File | Purpose |
|------|---------|
| `AccountUpdateDTO.java` | Account update payload with optimistic-lock fields |
| `CardUpdateDTO.java` | Credit card update payload |
| `TransactionDTO.java` | Transaction creation/response payload |

## Exception Handling

| Class | HTTP Status | Purpose |
|-------|-------------|---------|
| `ResourceNotFoundException` | 404 | Entity not found |
| `ValidationException` | 400 | Business rule / input validation failure |

## REST API Endpoints

### Domain CRUD APIs

These provide standard create/read/delete operations for core entities:

| Controller | Base Path | Operations |
|------------|-----------|------------|
| `AccountController` | `/api/v1/account` | POST, GET, GET `/{id}`, DELETE `/{id}` |
| `CardController` | `/api/v1/card` | POST, GET, GET `/{id}`, DELETE `/{id}` |
| `CustomerController` | `/api/v1/customer` | POST, GET, GET `/{id}`, DELETE `/{id}` |
| `TransactionController` | `/api/v1/transaction` | POST, GET, GET `/{id}`, DELETE `/{id}` |

### Navigation API

| Controller | Endpoint | Description |
|------------|----------|-------------|
| `NavigationController` | `GET /api/v1/navigation/menu` | Returns the CardDemo main menu (legacy `COMEN01C`) as JSON with REST endpoint mappings |

### Legacy COBOL Program APIs

Each migrated COBOL program has a dedicated controller under `/api/v1/{program-name-lowercase}/`. Most expose:

- `POST /execute` — Run the migrated program logic
- `GET /status` — Program status check
- `GET /detail/{n}` — Detail endpoints (where applicable)

#### Online (CICS) Programs

| Controller | Legacy Program | Function |
|------------|----------------|----------|
| `Cosgn00cController` | COSGN00C | Sign-on / authentication |
| `Comen01cController` | COMEN01C | Main menu |
| `CoactvwcController` | COACTVWC | Account view |
| `CoactupcController` | COACTUPC | Account update |
| `CocrdlicController` | COCRDLIC | Credit card list |
| `CocrdslcController` | COCRDSLC | Credit card view |
| `CocrdupcController` | COCRDUPC | Credit card update |
| `Cotrn00cController` | COTRN00C | Transaction list |
| `Cotrn01cController` | COTRN01C | Transaction view |
| `Cotrn02cController` | COTRN02C | Transaction add |
| `Corpt00cController` | CORPT00C | Transaction reports |
| `Cobil00cController` | COBIL00C | Bill payment |
| `Coadm01cController` | COADM01C | Admin menu |
| `Cousr00cController` | COUSR00C | List users |
| `Cousr01cController` | COUSR01C | Add user |
| `Cousr02cController` | COUSR02C | Update user |
| `Cousr03cController` | COUSR03C | Delete user |
| `CobswaitController` | COBSWAIT | Wait/timer utility |

#### Batch Programs

| Controller | Legacy Program | Function |
|------------|----------------|----------|
| `Cbact01cController` | CBACT01C | Account file load |
| `Cbact02cController` | CBACT02C | Card file load |
| `Cbact03cController` | CBACT03C | Customer file load |
| `Cbact04cController` | CBACT04C | Interest calculation |
| `Cbcus01cController` | CBCUS01C | Customer batch processing |
| `Cbtrn01cController` | CBTRN01C | Transaction processing |
| `Cbtrn02cController` | CBTRN02C | Core transaction posting |
| `Cbtrn03cController` | CBTRN03C | Transaction reporting |
| `CbimportController` | CBIMPORT | Data import |
| `CbexportController` | CBEXPORT | Data export |
| `CsutldtcController` | CSUTLDTC | Date utility |

#### Copybook / Data Entity Controllers

Controllers for reference data entities (each maps to a JPA entity and repository):

`Cvact01Y`, `Cvact02Y`, `Cvact03Y`, `Cvcrd01Y`, `Cvcus01Y`, `Cvtra01Y`–`Cvtra07Y`, `Csusr01Y`, `Csmsg01Y`, `Csmsg02Y`, `Csdat01Y`, `Csdb2Rwy`, `Cslkpcdy`, `Csutldwy`, `Ccpauery`, `Ccpaurly`, `Ccpaurqy`, `Cipaudty`, `Cipausmy`, `Coadm02Y`, `Cocom01Y`, `Codatecn`, `Comen02Y`, `Cottl01Y`, `Cvexport`, `Custrec`, `Imsfuncs`, `Unused1Y`

## Batch Processing

**`AccountImportBatch.java`** — Migrated from `CBACT01C.CBL`. Reads fixed-width legacy account records from a file, applies COBOL-era transformations (default debit values, date formatting), and persists accounts via JPA. Intended to replace JCL-driven VSAM file loads.

**`InterestCalculationServiceImpl.java`** — Migrated from `CBACT04C.CBL`. Iterates transaction category balances, looks up disclosure group interest rates, computes monthly interest (`balance × rate / 1200`), posts interest transactions, and updates account balances.

## Build and Run

### Prerequisites

- Java 21+
- Maven 3.9+
- MySQL 8.x (or compatible RDS instance)

### Local Development

```bash
# Create the database
mysql -u root -p -e "CREATE DATABASE carddemo;"

# Build and run
mvn clean package
java -jar target/card-demo-0.0.1-SNAPSHOT.jar

# Or run directly with Maven
mvn spring-boot:run
```

The application starts at `http://localhost:8080`. Health check: `http://localhost:8080/actuator/health`.

### Environment Variables

| Variable | Description |
|----------|-------------|
| `DB_URL` | JDBC connection URL |
| `DB_USERNAME` | Database username |
| `DB_PASSWORD` | Database password |

### Docker

```bash
docker build -f docker/Dockerfile -t card-demo .
docker run -p 8080:8080 \
  -e DB_URL=jdbc:mysql://host.docker.internal:3306/carddemo \
  -e DB_USERNAME=root \
  -e DB_PASSWORD=password \
  card-demo
```

The Dockerfile uses a multi-stage build: Maven compiles the JAR in stage one, and a slim JRE 21 image runs the application in stage two.

## Testing

**Location:** `src/test/java/com/aws/carddemo/service/`

29 test classes cover the migrated COBOL program services. Each test class (for example, `Cosgn00cServiceTest`, `Cbtrn02cServiceTest`, `CoactupcServiceTest`) contains multiple scenario-based test methods validating the migrated service layer.

```bash
mvn test
```

## Root-Level Scripts

| Script | Purpose |
|--------|---------|
| `push_flow_batch.sh` | Commits and pushes flow/batch migration changes |
| `push_high_fidelity.sh` | Commits and pushes high-fidelity migration changes |
| `push_mass_migration.sh` | Commits and pushes mass COBOL-to-Java migration |
| `push_ultra_deep.sh` | Commits and pushes ultra-deep migration with tests |

These are internal development helpers used during the multi-phase migration process.

## Documentation Files

| File | Description |
|------|-------------|
| `docs/modernization.md` | Migration rationale, stack details, copybook mapping, and planned enhancements |
| `CONTRIBUTING.md` | How to report issues and submit pull requests |
| `CODE_OF_CONDUCT.md` | Community standards |
| `LICENSE` | Apache License 2.0 |
| `NOTICE` | Copyright attribution |

## Migration History

The repository was modernized in phases:

1. **High-fidelity migration** — Deep logic for Account, Card, and Interest Calculation
2. **Flow and batch migration** — NavigationController and AccountImportBatch
3. **Mass migration** — Comprehensive translation of all 29 legacy COBOL programs
4. **Ultra-deep migration** — 128,000+ lines of logic and tests for all modules
5. **Final modernization** — Removed all legacy COBOL/JCL files; restructured to 100% Java

## Planned Enhancements

From [docs/modernization.md](docs/modernization.md):

- Full CRUD for Accounts, Customers, and Cards
- AWS Secrets Manager integration for database credentials
- Spring Security with JWT authentication
- Comprehensive integration testing

## License

This project is released under the [Apache License 2.0](LICENSE).

## Contributing

See [CONTRIBUTING.md](CONTRIBUTING.md) for guidelines on reporting issues and submitting pull requests.
