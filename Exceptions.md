# Solution

### org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'sqlSessionFactory' defined in class path resource [com/baomidou/mybatisplus/autoconfigure/MybatisPlusAutoConfiguration.class]: Bean instantiation via factory method failed; nested exception is org.springframework.beans.BeanInstantiationException: Failed to instantiate [org.apache.ibatis.session.SqlSessionFactory]: Factory method 'sqlSessionFactory' threw exception; nested exception is com.baomidou.mybatisplus.core.exceptions.MybatisPlusException: Error: GlobalConfigUtils setMetaData Fail !  Cause:java.sql.SQLException: Access denied for user 'root'@'localhost' (using password: YES)

Reason: Can't connect to data source
``` 
spring.datasource.url=jdbc:mysql://127.0.0.1:3306/demo?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```

### Could not autowire. No beans of 'UserService' type found. 

