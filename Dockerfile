FROM tomcat:8.5-jre8-slim

EXPOSE 8080
COPY target/NachrichtenGenerator-1.0.0-SNAPSHOT.war $CATALINA_HOME/webapps/nagen.war

ENTRYPOINT ["catalina.sh", "run"]

