# dockercompose command for mysql8

https://hub.docker.com/_/mysql

## pull
```
docker pull mysql:8.0.27
```

## run
```
docker run --name mysql-container -p 3306:3306 \
-e MYSQL_ROOT_PASSWORD=123456 \
-e MYSQL_DATABASE=demo \
-e MYSQL_USER=test \
-e MYSQL_PASS=123456 \
-d mysql:8.0.27
```

## run (host mode Linux only)
```
docker run --name mysql-container --net=host \
-e MYSQL_ROOT_PASSWORD=123456 \
-e MYSQL_DATABASE=demo \
-e MYSQL_USER=test \
-e MYSQL_PASS=123456 \
-d mysql:8.0.27
```

## inspect
```
docker logs mysql-container

docker logs mysql-container > /root/mysql.log

docker exec -it mysql-container bash
```

## stop & remove container
```
docker stop mysql-container
docker rm mysql-container
```

## remove image
```
docker image rm mysql:8.0.27
```