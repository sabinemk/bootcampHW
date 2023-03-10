CREATE TABLE bankUsers (
    accountNo varchar (100) PRIMARY KEY NOT NULL,
    balance int NOT NULL,
    name varchar(100),
    gender varchar(100),
    username varchar(100),
    password varchar(100),
    newsLetter boolean
);

DROP TABLE bankUsers;