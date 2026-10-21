# Write your MySQL query statement below
SELECT P.product_name, s.year, s.price FROM Sales s INNER JOIN Product P on s.product_id = P.product_id;