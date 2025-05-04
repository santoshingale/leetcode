# Write your MySQL query statement below

select Customers.name as 'Customers'
    from Customers
    where Customers.id not in 
    (
        select customerId from orders
    );

-- const query = `
-- SELECT name AS Customers
-- FROM Customers
-- LEFT JOIN Orders ON Customers.id = Orders.customerId
-- WHERE Orders.customerId IS NULL;
-- `;