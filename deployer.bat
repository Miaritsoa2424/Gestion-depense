@echo off
:: Définition des variables
set APP_NAME=ETU003087
set SRC_DIR=src\main\java
set WEB_DIR=src\main\webapp
set BUILD_DIR=build
set LIB_DIR=lib
set TOMCAT_WEBAPPS=D:\ITU\s4\web-dynamique\apache-tomcat-10.1.28\webapps
set SERVLET_API_JAR=%LIB_DIR%\servlet-api.jar
set MYSQL_CONNECTOR_JAR=%LIB_DIR%\mysql-connector-j-9.1.0.jar


:: Nettoyage et création du répertoire temporaire
if exist %BUILD_DIR% rmdir /s /q %BUILD_DIR%
mkdir %BUILD_DIR%\WEB-INF\classes

:: Compilation des fichiers Java avec le JAR des Servlets
for /r %SRC_DIR% %%f in (*.java) do echo %%f >> sources.txt
javac -cp "%SERVLET_API_JAR%;%MYSQL_CONNECTOR_JAR%" -d %BUILD_DIR%\WEB-INF\classes @sources.txt


del sources.txt

:: Copier les fichiers web (web.xml, JSP, etc.)
xcopy /E /I %WEB_DIR%\* %BUILD_DIR%\

:: Générer le fichier .war dans le dossier build
cd %BUILD_DIR%
jar -cvf %APP_NAME%.war *
cd ..

:: Déployer l'application sur le serveur Tomcat
copy %BUILD_DIR%\%APP_NAME%.war %TOMCAT_WEBAPPS%
