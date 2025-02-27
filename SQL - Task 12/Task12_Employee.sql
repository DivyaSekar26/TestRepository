USE training;

CREATE TABLE EMPLOYEE
 (EMPNO INT, ENAME VARCHAR(250),
 JOB VARCHAR(250), MGR INT, 
 HIREDATE DATE ,SAL FLOAT, 
 COMM FLOAT, DEPTNO INT);
 
 INSERT INTO EMPLOYEE VALUES (8369, 'SMITH','CLERK', 8902 ,'1990-12-18', 800.00, NULL, 20);
 
 INSERT INTO EMPLOYEE VALUES (8499, 'ANYA', 'SALESMAN', 8698, '1991-02-20', 1600.00, 300.00 ,30), (8521, 'SETH',
 'SALESMAN', 8698, '1991-02-22', 1250.00, 500.00 ,30) ,(8566, 'MAHADEVAN', 'MANAGER', 8839, '1991-04-02',2985.00
,NULL, 20), (8654, 'MOMIN','SALESMAN', 8698, '1991-09-28', 1250.00, 1400.00, 30), (8698, 'ΒΙΝΑ', 'MANAGER',8839,
'1991-05-01', 2850.00, NULL, 30), (8882, 'SHIVANSH','MANAGER', 8839, '1991-06-09',2450.00, NULL, 10), (8888, 'SCOTT',
'ANALYST', 8566, '1992-12-09', 3000.00, NULL, 20) , (8839, 'AMIR','PRESIDENT', NULL, '1991-11-18',5000.00, NULL,10),
(8844, 'KULDEEP','SALESMAN',8698,'1991-09-08', 1500.00, 0.00,30);

A. Write a query to display EName and Sal of employees whose salary are greater than or equal to 2200?

SELECT ENAME , SAL FROM EMPLOYEE WHERE SAL >= 2200;

B. Write a query to display details of employees who are not getting commission?

SELECT * FROM EMPLOYEE WHERE COMM IS NULL OR COMM = 0;

C. Write a query to display employee name and salary of those employees
 who don't have their salary in the range of 2500 to 4000?
 
 SELECT * FROM EMPLOYEE WHERE SAL >4000 OR SAL <2500;
 
 
D. Write a query to display the name, job title and salary of employees who don't have a manager?

SELECT ENAME , JOB FROM EMPLOYEE WHERE MGR IS NULL;

E. Write a query to display the name of an employee whose name contains "A" as third alphabet?

SELECT ENAME FROM EMPLOYEE WHERE ENAME LIKE '__A%'

F. Write a query to display the name of an employee whose name contains "T"" as the last alphabet?

SELECT ENAME FROM EMPLOYEE WHERE ENAME LIKE '%T';





 



 
 
 
 