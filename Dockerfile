# Dockerfile

FROM gradle:latest

WORKDIR /docker

COPY . /docker

RUN ./gradlew build 
