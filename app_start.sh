#!/bin/sh
./mvnw clean package spring-boot:run -Dspring-boot.run.arguments=--jasypt.encryptor.password=YelLuzbel
#JASYPT_ENCRYPTOR_PASSWORD=YelLuzbel java -jar ./target/spring-boot-redis-0.0.1.jar
#java -Djasypt.encryptor.password=YelLuzbel -jar ./target/spring-boot-redis-0.0.1.jar
