SELECT *
FROM Student
SELECT Sno
FROM SC ;
SELECT Sno
FROM SC 
WHERE Grade < 60;
SELECT Sname , Ssex
FROM Student
WHERE  Sdept IN ('CS','IS','MA');
SELECT Sname , Sno,Ssex
FROM Student
WHERE Sname LIKE 'Αυ%'
SELECT CNO , Ccredit 
FROM Course
WHERE  Cname in ('DB_Design');
SELECT Sno,Grade 
FROM SC
WHERE  Cno = '3'
ORDER BY GRADE DESC;
SELECT MAX(Grade) 
FROM SC
WHERE  Cno = '1';
SELECT COUNT(Sno),Cno
FROM SC
GROUP BY Cno;
SELECT Student.*,SC.*
FROM Student,SC
WHERE Student.Sno=SC.Sno;
SELECT Student.Sno,Sname,Cname,Grade
FROM Student,SC,Course
WHERE Student.Sno=SC.sno AND SC.Cno=Course.Cno;
SELECT FIRST.Cno,SECOND.Cpno
FROM Course FIRST,Course SECOND
WHERE FIRST.Cpno=SECOND.Cno;
