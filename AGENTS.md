# AGENTS.md

## Cursor Cloud specific instructions

### Product
Java 21 Spring Boot REST API (`card-demo`) modernizing the AWS CardDemo mainframe sample. There is no web UI — E2E testing is done via HTTP (curl, Postman, etc.).

### Required services

| Service | Port | Notes |
|---------|------|-------|
| MySQL 8 | 3306 | Required at runtime for `mvn spring-boot:run` |
| card-demo API | 8080 | Spring Boot dev server |

### Docker (MySQL)
- The Docker daemon is not managed by systemd in this VM. If `sudo docker` fails to connect, start it: `sudo dockerd > /tmp/dockerd.log 2>&1 &` and wait a few seconds.
- Use `sudo docker` for all Docker commands (the default user is not in the `docker` group).
- Start MySQL (idempotent — remove existing container first if needed):

```bash
sudo docker rm -f carddemo-mysql 2>/dev/null
sudo docker run -d --name carddemo-mysql \
  -e MYSQL_ROOT_PASSWORD=password \
  -e MYSQL_DATABASE=carddemo \
  -p 3306:3306 mysql:8
```

Wait until ready: `sudo docker exec carddemo-mysql mysqladmin ping -h localhost -uroot -ppassword --silent`

### Running the API
From the repo root (after MySQL is up):

```bash
mvn spring-boot:run
```

Verify: `curl http://localhost:8080/actuator/health` → `{"status":"UP"}`

Example flows: `GET /api/v1/navigation/menu`, `POST /api/v1/customer`, `POST /api/v1/account`.

### Build and test
See `pom.xml` for scripts. Common commands:

- **Compile check** (no dedicated linter): `mvn compile`
- **Unit tests** (no MySQL needed): `mvn test`
- **Package JAR**: `mvn package -DskipTests`
- **Run packaged JAR**: `java -jar target/card-demo-0.0.1-SNAPSHOT.jar`

### Environment variables
Defaults in `src/main/resources/application.yml`:

- `DB_URL` → `jdbc:mysql://localhost:3306/carddemo`
- `DB_USERNAME` → `root`
- `DB_PASSWORD` → `password`

### System dependencies
Java 21 is pre-installed. **Maven** must be installed (`sudo apt-get install -y maven`). Docker is optional but recommended for MySQL.
