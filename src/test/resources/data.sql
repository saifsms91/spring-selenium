Drop TABLE if EXISTS users;
CREATE TABLE user AS SELECT * FROM CSVREAD('classpath:tables/user_visa.csv');