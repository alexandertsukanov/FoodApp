####Steps to deploy:

####0)Go to dir /root/gda/gda-rest
cd ~/gda/gda-rest

####1)Stop tomcat
service tomcat stop

####2)Get latest changes from git
git pull origin master

####3)Build war file
./gradlew clean war

####4)Remove old web application dir from tomcat 
rm -f -rf /opt/tomcat/webapps/gda-rest

####5)Remove old war file from tomcat
rm -f /opt/tomcat/webapps/gda-rest.war

####6)Copy new war file to tomcat
cp build/libs/gda-rest-0.0.1.war /opt/tomcat/webapps/gda-rest.war

####7)Start tomcat
service tomcat start

####8)See logs
tailf /opt/tomcat/logs/catalina.out

####