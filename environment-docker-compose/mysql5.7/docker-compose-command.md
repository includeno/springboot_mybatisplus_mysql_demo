# dockercompose command for mysql5.7

## pull
```
docker pull mysql:5.7.33
```

## run
```
docker-compose -f docker-compose-mysql.yml up -d
```

## inspect
```
docker-compose -f docker-compose-mysql.yml logs mysql
docker-compose -f docker-compose-mysql.yml logs mysql > /root/mysql.log

docker exec -it some-mysql bash
```

## stop & remove container
```
docker-compose -f docker-compose-mysql.yml stop
docker-compose -f docker-compose-mysql.yml down
```

## remove image
```
docker image rm mysql:5.7.33
```