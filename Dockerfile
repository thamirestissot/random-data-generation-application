FROM openjdk:8-jre-alpine
RUN mkdir /usr/local/tomcat &&\
wget http://www-us.apache.org/dist/tomcat/tomcat-9/v9.0.24/bin/apache-tomcat-9.0.24.tar.gz -O /tmp/tomcat.tar.gz &&\
cd /tmp && tar xvfz tomcat.tar.gz &&\
cp -Rv /tmp/apache-tomcat-9.0.24/* /usr/local/tomcat/
COPY build/libs/*.war usr/local/tomcat/webapps/random-data-generation-application-1.0.war
EXPOSE 8080
CMD usr/local/tomcat/bin/catalina.sh run