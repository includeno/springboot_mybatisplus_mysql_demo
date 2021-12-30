#build application image

root /Dockerfile

镜像定义文件 位置:/Dockerfile

## build
```
docker build . -t mybatisdemo:1.0
```

## run
```
docker run --name mybatisdemo-container -p 8080:8080 \
-e app_name=mybatisdemo \
-d includeno/springboot_mybatisplus_mysql_demo:single_table_withxml
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
docker image rm includeno/springboot_mybatisplus_mysql_demo_single_table_withxml:1.0
```