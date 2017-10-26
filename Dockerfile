FROM openjdk:8-alpine
COPY ./app /usr/src/myapp
WORKDIR /usr/src/myapp
RUN javac -d out -sourcepath src src/App.java
#CMD ["java", "-cp", "out", "App", "./data.txt"]