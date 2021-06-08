# NOVEL-CLOUD

this project forked from original [novel-cloud](http://www.baidu.com), but transform project management tools from maven 
to gradle, other minor changes include using eureka as service discovery etc.

## How to install

### deploy using docker

you should run mysql container firstly if using docker deploy all this microservice container, then run other service 
container linked it with mysql container

mysql

```shell
sudo docker run --name=mysql --restart=unless-stopped --network=novel-cloud -d -p 3306:3306 -e "MYSQL_ROOT_PASSWORD=hi@Aby55" mysql:8
```

novel-register

```shell
sudo docker run --name=novel-register --restart=unless-stopped --network=novel-cloud -d -p 8000:8000 abyssspecies.tech.io/novel/novel-register:latest 
```

novel-user

```shell
sudo docker run --name=novel-user --restart=unless-stopped --network=novel-cloud --link mysql:mysql \
  --link novel-register:eureka --privileged=true -d -p 8300:8300 -p 8301:8301 \
  -e "EUREKA_DEFAULT_ZONE=http://eureka:8000/eureka" \
  -e "SPRING_DATASOURCE_URL=jdbc:mysql://mysql:3306/novel_cloud?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2B8&autoReconnect=true&failOverReadOnly=false&maxReconnects=10&allowPublicKeyRetrieval=true" \
  -e "SPRING_DATASOURCE_PASSWORD=hi@Aby55" abyssspecies.tech.io/novel/novel-user:latest
```

### deploy using docker-compose

use docker-compose orchestrate tools to automatically build and run all service container

### deploy using k8s

