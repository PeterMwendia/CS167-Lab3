#!/bin/bash

# Compile and package the Java code using Maven
mvn clean package

# Check if the Maven build was successful
if [ $? -eq 0 ]; then
    # Run the program with the test cases
    java -jar target/lab3-1.0-SNAPSHOT.jar 3 20 5
    java -jar target/lab3-1.0-SNAPSHOT.jar 3 20 "3v5"
    java -jar target/lab3-1.0-SNAPSHOT.jar 3 20 "3,5"
else
    echo "Maven build failed. Please fix any errors before running the program."
fi
