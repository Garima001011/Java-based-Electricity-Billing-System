CREATE DATABASE electricity;
USE electricity;

CREATE TABLE users (
  id INT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(50),
  password VARCHAR(50)
);

INSERT INTO users (username, password) VALUES ('admin', 'admin123');

CREATE TABLE bills (
  id INT AUTO_INCREMENT PRIMARY KEY,
  meter_no VARCHAR(20),
  customer_name VARCHAR(100),
  month VARCHAR(20),
  units INT,
  amount DOUBLE
);