# Week 9 - Tutorial 9 (01-10-2026)

| Folder | Description |
|---|---|
| q1_grade_calculator | Student Grade Calculator (Swing, MVC) |
| q2_service_estimator | Vehicle Service Cost Estimator (Swing, MVC) |
| q3_employee_portal | Employee Management Portal (Swing, MVC) |
| q4_book_jdbc | Library Book management (JDBC) |
| q5_product_jdbc | Product inventory (JDBC) |
| q6_course_jdbc | Course registration search (JDBC) |

## Run Swing programs (Q1-Q3)
    cd q1_grade_calculator && javac *.java && java Main

## Run JDBC programs (Q4-Q6)
1. Run `schema.sql` in MySQL.
2. Edit `USER` / `PASS` in the Java file.
3. Compile and run with the MySQL Connector/J jar on the classpath:

        javac BookManager.java
        java -cp .:mysql-connector-j-8.x.jar BookManager      # Windows: use ; instead of :

Login for Q3: `admin` / `admin123`.
