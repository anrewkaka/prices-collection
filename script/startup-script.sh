#!/bin/bash
if [ ! -d "~/market-client" ]; then
  git clone https://github.com/anrewkaka/market-client.git -b 'develop' ~/market-client
fi

if [ ! -d "~/market-client-autoconfig" ]; then
  git clone https://github.com/anrewkaka/market-client-autoconfig.git -b 'develop' ~/market-client-autoconfig
fi

if [ ! -d "~/prices-collector" ]; then
  git clone https://github.com/anrewkaka/prices-collector.git -b 'prices-collection-implement' ~/prices-collector
fi

# publish market-client library
cd ~/market-client
git reset --hard
git clean -f
git checkout develop
git pull
chmod +x gradlew
./gradlew clean publishToMavenLocal

# publish market-client library
cd ~/market-client-autoconfig
git reset --hard
git clean -f
git checkout develop
git pull
chmod +x gradlew
./gradlew clean publishToMavenLocal

# build application
cd ~/prices-collector
git reset --hard
git clean -f
git checkout prices-collection-implement
git pull
chmod +x gradlew
./gradlew clean build

export COMPOSE_FILE=./docker/docker-compose.yml
docker-compose down
docker-compose up -d
