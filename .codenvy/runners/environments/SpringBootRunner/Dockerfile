FROM codenvy/jdk7
EXPOSE 8080
ENV CODENVY_APP_PORT_8080_HTTP 8080
ADD $app$ /home/user/$app$
WORKDIR /home/user/
RUN unzip $app$ >/dev/null
CMD java -jar PrimeFacesOnSpringBoot-1.0.war 2>&1 run