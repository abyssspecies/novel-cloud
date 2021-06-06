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

ARG ARTHAS_VERSION="3.5.0"
ARG MIRROR=true

ENV MAVEN_HOST=https://repo1.maven.org/maven2 \
    ALPINE_HOST=dl-cdn.alpinelinux.org \
    MIRROR_MAVEN_HOST=https://maven.aliyun.com/repository/public \
    MIRROR_ALPINE_HOST=mirrors.aliyun.com

RUN if $MIRROR; then MAVEN_HOST=${MIRROR_MAVEN_HOST} ;ALPINE_HOST=${MIRROR_ALPINE_HOST} ; sed -i "s/dl-cdn.alpinelinux.org/${ALPINE_HOST}/g" /etc/apk/repositories ; fi \
  && apk update -qq \
  && apk upgrade \
  && apk add --no-cache tini busybox-extras fontconfig ttf-dejavu curl bash bind-tools ca-certificates tzdata \
  && ln -snf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime \
  && echo "Asia/Shanghai" > /etc/timezone \
  && apk del tzdata \
  && wget -qO /tmp/arthas.zip "${MAVEN_HOST}/com/taobao/arthas/arthas-packaging/${ARTHAS_VERSION}/arthas-packaging-${ARTHAS_VERSION}-bin.zip" \
  && mkdir -p /opt/arthas \
  && unzip /tmp/arthas.zip -d /opt/arthas \
  && rm /tmp/arthas.zip
RUN addgroup -S novel && adduser -S novel -G novel
USER novel:novel
VOLUME /tmp
EXPOSE 8000
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
ENV JAVA_OPTS -noverify -XX:TieredStopAtLevel=1 -XX:+UnlockExperimentalVMOptions -XX:MaxRAMPercentage=90.0 -Dspring.jmx.enabled=false
ENV JAVA_TOOL_OPTIONS -Dfile.encoding=UTF8 -Duser.language=zh -Duser.region=zh_CN -Duser.country=zh_CN -Duser.timezone=Asia/Shanghai -Djava.security.egd=file:/dev/./urandom
ENTRYPOINT ["/sbin/tini", "--", "sh", "-c", "exec java $JAVA_OPTS org.springframework.boot.loader.JarLauncher"]
