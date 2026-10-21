# Write your MySQL query statement below
SELECT e1.name FROM Employee e1 INNER JOIN Employee e2 WHERE e1.id = e2.managerId GROUP BY e1.id HAVING Count(e1.id) >= 5;