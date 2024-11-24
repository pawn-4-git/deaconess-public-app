docker-compose down --rmi all --volumes --remove-orphans
cd server/TaskManagement
gradle clean
gradle build
cd ../../
docker-compose up -d
docker-compose exec deaconess-api-app microdnf install findutils
docker-compose exec deaconess-api-app sh TaskManagement/gradlew build
docker-compose exec -d deaconess-api-app java -jar TaskManagement/build/libs/TaskManagement-0.0.1-SNAPSHOT.jar
##docker-compose exec deaconess-api-app java -jar TaskManagement/build/libs/TaskManagement-0.0.1-SNAPSHOT.jar
