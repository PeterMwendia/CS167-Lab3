# CS167-Lab3

## Java Divisibility Filter

This lab explores function composition in Java using functional programming concepts. It demonstrates how to create and combine functions to filter and print numbers in a given range based on divisibility by specified criteria.

## Table of Contents

- [Introduction](#introduction)
- [Setup](#setup)
- [Usage](#usage)
- [Function Composition](#function-composition)
- [GitHub Actions Workflow](#github-actions-workflow)

## Introduction

In this lab, we will work with Java functions and explore various methods to filter and print numbers in a given range. We will create functions for divisibility by specific criteria, combine functions using function composition, and handle different conditions based on user input.

## Setup

1. Clone the repository to your local machine:

```bash
   git clone https://github.com/PeterMwendia/CS167-Lab3.git
   cd CS167-Lab3
   ```

2. Ensure you have Java 11 installed on your system.

## Build

3. Build the project using Maven:

```bash
    mvn clean package
   ```

## Usage

To run the program, you can use the following command:

```bash
   java -jar target/lab3-1.0-SNAPSHOT.jar <from> <to> <base>
   ```
- `<from>`: Starting range
- `<to>`: Ending range
- `<base>`: Criteria for divisibility (e.g., a single number, a combination using ',' for 'or' or 'v'

## Function Composition

This program demonstrates function composition to filter and print numbers based on divisibility by specific criteria. It provides two types of filters: 'and' and 'or', depending on the input separator (',' or 'v').

## Function Definitions

- `combineWithAnd`: Combines filters using 'and'.
- `combineWithOr`: Combines filters using 'or'.

## Example Usage

To filter numbers divisible by 5:

```bash
java -jar target/lab3-1.0-SNAPSHOT.jar 3 20 5
```

To filter numbers divisible by either 3 or 5:

```bash
java -jar target/lab3-1.0-SNAPSHOT.jar 3 20 "3v5"
```

To filter numbers divisible by both 3 and 5:
```bash
  java -jar target/lab3-1.0-SNAPSHOT.jar 3 20 "3,5"
```