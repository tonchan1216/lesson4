FROM adoptopenjdk/maven-openjdk11:latest AS builder
LABEL  maintainer "cleartone1216"

RUN apt-get update && apt-get install -y git
RUN git clone https://github.com/tonchan1216/lesson4.git /usr/local/lesson4
RUN mvn install -f /usr/local/lesson4/lesson4-bff/pom.xml

FROM adoptopenjdk/openjdk11:alpine-slim
RUN apk --update add tzdata && \
    cp /usr/share/zoneinfo/Asia/Tokyo /etc/localtime && \
    apk del tzdata && \
    rm -rf /var/cache/apk/* && \
    mkdir -p /opt/app/
COPY --from=builder /usr/local/lesson4/lesson4-bff/target/lesson4-bff-0.0.1-SNAPSHOT.jar /opt/app/

EXPOSE 8080

CMD java -jar -Dspring.profiles.active=production /opt/app/lesson4-bff-0.0.1-SNAPSHOT.jar