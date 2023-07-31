FROM tomcat:8
# Take the war and copy to webapps of tomcat
COPY target/*.war C:/apache-tomcat-9.0.75-windows-x64/apache-tomcat-9.0.75/webapps/LabJenkinsDevops-0.0.1-SNAPSHOT.war
