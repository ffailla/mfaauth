# mfaauth project
A collection of utilities to support generating MFA codes

# Usage

## Build All
run mvn clean install from root directory

## Build Uberjar
run lein uberjar from the ./mfaauth-app directory

## Run App

### Console
java -jar mfaauth-app-[VERSION]-standalone.jar [AUTHENTICATION_KEY]

### HTTP Service
java -jar mfaauth-app-[VERSION]-standalone.jar

### Web Application
run grunt serve from the ./mfaauth-web directory to view mfa web
