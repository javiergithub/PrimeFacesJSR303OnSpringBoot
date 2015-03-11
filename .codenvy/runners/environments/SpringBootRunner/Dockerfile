FROM codenvy/jdk7
EXPOSE 8080
ENV CODENVY_APP_PORT_8080_HTTP 8080
ADD $app$ /home/user/$app$
WORKDIR /home/user/
RUN unzip $app$ >/dev/null
CMD java -jar application.jar 2>&1 run