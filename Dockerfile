# =========================
# 1. Construcción
# =========================

FROM gradle:9-jdk25 AS builder

WORKDIR /app

COPY . .

RUN gradle build --no-daemon


# =========================
# 2. Ejecución
# =========================

FROM eclipse-temurin:25-jre

WORKDIR /app

COPY --from=builder /app/build/libs/*.war app.war

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.war"]
