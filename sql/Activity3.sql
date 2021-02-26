-- Show data from the salesman_id and city columns
SELECT salesman_id, city FROM salesman;

-- Show data of salesman from Paris
SELECT * FROM salesman WHERE city='Paris';

-- Show salesman_id and commission of Paul Adam
SELECT salesman_id, commission FROM salesman WHERE name='Paul Adam';