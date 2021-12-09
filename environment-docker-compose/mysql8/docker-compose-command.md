# dockercompose command for mysql8

## pull
```
docker pull mysql:8.0.27
```

## run
```
docker-compose -f docker-compose-mysql.yml up -d
```

## inspect
```
docker-compose -f docker-compose-mysql.yml logs mysql
docker-compose -f docker-compose-mysql.yml logs mysql > /root/mysql.log
```

## stop & remove container
```
docker-compose -f docker-compose-mysql.yml stop
docker-compose -f docker-compose-mysql.yml down
```

## remove image
```
docker image rm mysql:8.0.27
```