#!/bin/sh
docker stop redis;docker rm redis;docker run --name redis -d -p 6379:6379 redis:3.2.1 redis-server --requirepass "MINHA_SENHA"