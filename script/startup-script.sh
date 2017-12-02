#!/bin/bash

cd ../

git reset --hard
git clean -f
git checkout prices-collection-implement
git pull

./gradlew clean build

export COMPOSE_FILE=./docker-compose.yml
docker-compose down
docker-compose up -d
