#!/bin/bash
CLUSTER=kind-cluster
TAG=latest
mvn clean package -DskipTests
docker build -t workcale/microlearning-api:$TAG .
kind load docker-image workcale/microlearning-api:$TAG --name $CLUSTER