# Healthcare EMR Platform
Spring Boot 3 / Java 17 / MySQL REST API: patients, doctors, appointments, medical records (EMR).

Run: `docker compose up --build` then open http://localhost:8080/api/patients
Local without Docker: `mvn spring-boot:run` (uses in-memory H2).
Health: /actuator/health  Metrics (Prometheus): /actuator/prometheus (add micrometer-registry-prometheus to pom)

Example: curl -X POST localhost:8080/api/patients -H 'Content-Type: application/json' -d '{"name":"Ravi","gender":"M"}'
