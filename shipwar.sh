 cd ../../.
 mvn clean package

  echo "build done";

cp ./../target/studentServLet.war $TOMCAT_HOME/webapps/.