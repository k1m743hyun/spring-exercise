DROP DATABASE IF EXISTS user_db;
CREATE DATABASE user_db;
USE user_db;
DROP TABLE IF EXISTS tbl_user;
CREATE TABLE tbl_user (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100),
    phone_number VARCHAR(100)
);