CREATE DATABASE IF NOT EXISTS Spring_Web_Ban_Hang;
USE Spring_Web_Ban_Hang;

DROP TABLE IF EXISTS `Product`;
CREATE TABLE `Product` (
	ProductID 		INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    ProductName		VARCHAR(50) NOT NULL UNIQUE,
    TypeProduct		VARCHAR(50) NOT NULL,
    Price			INT
)