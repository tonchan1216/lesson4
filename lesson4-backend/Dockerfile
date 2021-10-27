FROM centos:centos7 AS builder
LABEL  maintainer "cleartone1216"

RUN yum install -y \
    java-11-openjdk \
    java-11-openjdk-devel \
    wget tar iproute git

RUN wget http://repos.fedorapeople.org/repos/dchen/apache-maven/epel-apache-maven.repo -O /etc/yum.repos.d/epel-apache-maven.repo && \
    sed -i s/\$releasever/6/g /etc/yum.repos.d/epel-apache-maven.repo && \
    yum install -y apache-maven && \
    update-alternatives --set java java-11-openjdk.x86_64
ENV JAVA_HOME /etc/alternatives/jre
RUN git clone https://github.com/tonchan1216/lesson4.git /usr/local/lesson4
RUN mvn install -f /usr/local/lesson4/lesson4-backend/pom.xml

FROM adoptopenjdk/openjdk11:latest
RUN cp /etc/localtime /etc/localtime.org && \
    ln -sf  /usr/share/zoneinfo/Asia/Tokyo /etc/localtime && \
    mkdir -p /opt/app/
COPY --from=builder /usr/local/lesson4/lesson4-backend/target/lesson4-backend-0.0.1-SNAPSHOT.jar /opt/app/

EXPOSE 8080

CMD java -jar -Dspring.profiles.active=production /opt/app/lesson4-backend-0.0.1-SNAPSHOT.jar