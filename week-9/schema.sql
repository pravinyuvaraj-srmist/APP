CREATE DATABASE IF NOT EXISTS tutorial9;
USE tutorial9;

CREATE TABLE IF NOT EXISTS Book (
    BookID INT PRIMARY KEY,
    Title VARCHAR(100) NOT NULL,
    Author VARCHAR(100) NOT NULL,
    Price DECIMAL(8,2) NOT NULL,
    Availability VARCHAR(3) NOT NULL DEFAULT 'Yes'   -- 'Yes' / 'No'
);

CREATE TABLE IF NOT EXISTS Product (
    ProductID INT PRIMARY KEY,
    ProductName VARCHAR(100) NOT NULL,
    Price DECIMAL(10,2) NOT NULL,
    Quantity INT NOT NULL
);

CREATE TABLE IF NOT EXISTS CourseRegistration (
    StudentID INT,
    StudentName VARCHAR(100),
    CourseCode VARCHAR(10),
    CourseName VARCHAR(100),
    Semester INT
);

INSERT INTO CourseRegistration VALUES
 (1,'Arun','CS101','Java Programming',3),
 (2,'Divya','CS101','Java Programming',3),
 (3,'Kiran','CS102','Database Systems',3);
