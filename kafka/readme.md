This project uses Spring Boot.

Install the Kafka broker:
```shell
docker-compose -f setup/kafka.yml -p springkafka up -d
```

Build:
```shell
./gradlew build
```

Run:
```shell
java -jar build/libs/demo-0.0.1-SNAPSHOT.jar
```

Test:
```shell
curl -w "\n" -X POST http://localhost:8080/example
```

Clean:
```shell
./setup/clean.sh
```
