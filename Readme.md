# mybatis-plus 开箱即用

mybatis-plus官网  https://baomidou.com/

MySQL官网 https://www.mysql.com/

Docker MySQL官网 https://hub.docker.com/_/mysql

✅步骤1 使用docker或者docker-compose配置MySQL环境 参考environment-docker文件夹(docker运行MySQL指令)或者environment-docker-compose文件夹(docker-compose运行MySQL指令)

✅步骤2 git clone https://github.com/includeno/springboot_mybatisplus_mysql_demo.git

✅步骤3 运行程序或者生成dockerimage(参考dockerimage文件夹)

## 版本

SpringBoot 2.4.13

mybatis-plus-boot-starter 3.0.5

mybatis-plus-extension 3.1.0

mybatis-plus-generator 3.0.5

## mysql 环境配置 /environment-docker-compose/mysql5.7/docker-compose-command.md
拉取镜像
```
docker pull mysql:5.7.33

ARM Macbook
docker pull --platform linux/x86_64 mysql:5.7.33
```
切换至当前YML文件所在文件夹
```
cd environment-docker-compose/mysql5.7
```

运行MySQL
```
docker-compose -f docker-compose-mysql.yml up -d
```

## 项目结构

工具  brew install tree   命令tree -a

```
.
├── Exceptions.md
├── HELP.md
├── LICENSE
├── Readme.md
├── Dockerfile (镜像定义文件)
├── dockerimage（docker生成服务镜像的指令）
│   └── application-image-command.md
├── environment-docker （docker运行MySQL的指令）
│   ├── mysql5.7
│   │   └── docker-command.md
│   └── mysql8
│       └── docker-command.md
├── environment-docker-compose （docker-compose运行MySQL的指令）
│   ├── mysql5.7
│   │   ├── docker-compose-command.md
│   │   └── docker-compose-mysql.yml
│   └── mysql8
│       ├── docker-compose-command.md
│       └── docker-compose-mysql.yml
├── mvnw
├── mvnw.cmd
├── mybatisplusdemo.iml
├── pom.xml
├── sql
│   ├── demo.sql
│   └── init.sql
└── src
    ├── main
    │   ├── java
    │   │   └── com
    │   │       └── example
    │   │           └── demo
    │   │               ├── MainApplication.java
    │   │               ├── config
    │   │               ├── controller
    │   │               │   ├── MainController.java
    │   │               │   └── UserController.java
    │   │               ├── entity
    │   │               │   └── User.java
    │   │               ├── mapper
    │   │               │   └── UserMapper.java
    │   │               └── service
    │   │                   ├── UserService.java
    │   │                   └── UserServiceImpl.java
    │   └── resources
    │       ├── application.properties
    │       ├── mapperxml
    │       ├── static
    │       └── templates
    └── test
        └── java
            └── com
                └── example
                    └── demo
                        ├── DemoApplicationTests.java
                        ├── controller
                        │   └── MainControllerTest.java
                        └── mapper
                            └── UserMapperTest.java
```

## maven dependencies 依赖
```
        <!--mybatis plus-->
        <dependency>
            <groupId>com.baomidou</groupId>
            <artifactId>mybatis-plus-boot-starter</artifactId>
            <version>3.0.5</version>
        </dependency>
        <!-- mybatis plus 代码生成器依赖 -->
        <dependency>
            <groupId>com.baomidou</groupId>
            <artifactId>mybatis-plus-generator</artifactId>
            <version>3.0.5</version>
        </dependency>
        <dependency>
            <groupId>com.baomidou</groupId>
            <artifactId>mybatis-plus-extension</artifactId>
            <version>3.1.0</version>
        </dependency>
```
## mybatis-plus configuration main.java

@MapperScan
```
@MapperScan("com.example.demo.mapper")
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```

## mybatis-plus configuration application.properties

Reference:  https://baomidou.com/config/

### mybatis-plus.mapper-locations: 

path of xml files

Path:springboot_mybatisplus_mysql_demo/src/main/java/com/example/demo/mapper/UserMapper.xml
```
mybatis-plus.mapper-locations=classpath:classpath:com/example/demo/mapper/*.xml
```

Path:springboot_mybatisplus_mysql_demo/src/main/resources/mapperxml/UserMapper.xml
```
mybatis-plus.mapper-locations=classpath:mapperxml/*.xml
```

### mybatis-plus.type-aliases-package= com.xxxxx.entity

Path:springboot_mybatisplus_mysql_demo/src/main/java/com/example/demo/entity
```
mybatis-plus.type-aliases-package= com.example.demo.entity
```

### mybatis-plus.configuration.map-underscore-to-camel-case: 

convert DataBase Column Name _**A_COLUMN**_ to Java Entity Name _**aColumn**_
```
mybatis-plus.configuration.map-underscore-to-camel-case=true
```

### mybatis-plus.configuration.cache-enabled=false

### mybatis-plus.use-generated-keys=true


### mybatis-plus.global-config.db-config.id-type=uuid

全局默认主键类型

### mybatis-plus.global-config.db-config.field-strategy=not_empty

字段验证策略

### mybatis-plus.global-config.db-config.table-underline=true

表名是否使用驼峰转下划线命名,只对表名生效

### mybatis-plus.global-config.db-config.logic-not-delete-value=1

逻辑已删除值,(逻辑删除下有效)

### mybatis-plus.global-config.db-config.logic-delete-value=0

逻辑未删除值,(逻辑删除下有效)


# Reference 参考

MySQL自动导入数据库表
https://cloud.tencent.com/developer/article/1623549

mybatis-plus 官方示例
https://github.com/baomidou/mybatis-plus-samples