--drop table if exists `employee`;
CREATE TABLE users ( user_id   SERIAL PRIMARY KEY, first_name varchar(100) NOT NULL, 
last_name varchar(100) NOT NULL, 
member_since date NOT NULL, email varchar(100) DEFAULT NULL );