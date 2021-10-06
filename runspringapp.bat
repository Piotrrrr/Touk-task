ECHO OFF
cd %~dp0
call mvnw clean package
start cmd /k java -jar .\target\touk-0.0.1-SNAPSHOT.jar
ECHO "Resume after the app startup in another window"
PAUSE
curl -i -X GET "http://localhost:8080/film?after=2021-10-10%%2001:00:00&before=2021-10-10%%2021:37:00"
PAUSE
curl -i -X GET "http://localhost:8080/seat?screeningId=253"
PAUSE
curl -i -X POST "http://localhost:8080/reservation?name='Adam'&surname='Kowalski'&seats=420,421&tickets=2,3"
PAUSE

