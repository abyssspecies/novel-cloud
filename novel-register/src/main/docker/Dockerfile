FROM openjdk:8-jdk-alpine as builder
WORKDIR application
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
RUN java -Djarmode=layertools -jar app.jar extract

FROM openjdk:8-jdk-alpine
MAINTAINER abyssspecies <abyssspecies@gmail.com>
WORKDIR application
COPY --from=builder application/dependencies/ ./
COPY --from=builder application/spring-boot-loader/ ./
COPY --from=builder application/snapshot-dependencies/ ./
COPY --from=builder application/application/ ./
RUN apk update -qq && apk --no-cache add curl bash bind-tools ca-certificates && \
  apk add tzdata && \
  ln -snf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && \
  echo "Asia/Shanghai" > /etc/timezone
RUN addgroup -S novel && adduser -S novel -G novel
USER novel:novel
VOLUME /tmp
EXPOSE 8000
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
ENV JAVA_OPTS -noverify -XX:TieredStopAtLevel=1 -XX:+UnlockExperimentalVMOptions -XX:MaxRAMPercentage=90.0 -Dspring.jmx.enabled=false
ENV JAVA_TOOL_OPTIONS -Dfile.encoding=UTF8 -Duser.language=zh -Duser.region=zh_CN -Duser.country=zh_CN -Djava.security.egd=file:/dev/./urandom
ENTRYPOINT ["sh", "-c", "exec java $JAVA_OPTS org.springframework.boot.loader.JarLauncher"]
