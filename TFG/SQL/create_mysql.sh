#! /bin/bash

DATABASE=$1
SCRIPT=$2
PASSWORD=federica
docker run \
	--detach \
	--name=$DATABASE \
	--env="MYSQL_ROOT_PASSWORD=$PASSWORD" \
	--publish 13306:3306 \
	--volume=$PWD/db-data/conf.d:/etc/mysql/conf.d \
	--volume=$PWD/db-data/mysql-data:/var/lib/mysql \
	mysql

sleep 30

docker exec -i $DATABASE mysql -u root -p$PASSWORD < $SCRIPT
