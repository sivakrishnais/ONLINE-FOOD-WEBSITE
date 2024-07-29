-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: online_food_delivery_app
-- ------------------------------------------------------
-- Server version	8.0.33

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `ordertable`
--

DROP TABLE IF EXISTS `ordertable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ordertable` (
  `OrderId` int NOT NULL AUTO_INCREMENT,
  `UserId` int DEFAULT NULL,
  `RestaurantId` int DEFAULT NULL,
  `OrderDate` datetime DEFAULT CURRENT_TIMESTAMP,
  `TotalAmount` decimal(10,2) NOT NULL,
  `Status` enum('pending','Delivered','Cancelled') NOT NULL,
  `PaymentMethod` enum('UPI','COD','debit card','credit card') DEFAULT NULL,
  PRIMARY KEY (`OrderId`),
  KEY `UserId` (`UserId`),
  KEY `RestaurantId` (`RestaurantId`),
  CONSTRAINT `ordertable_ibfk_1` FOREIGN KEY (`UserId`) REFERENCES `user` (`UserId`),
  CONSTRAINT `ordertable_ibfk_2` FOREIGN KEY (`RestaurantId`) REFERENCES `restaurant` (`RestaurantId`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordertable`
--

LOCK TABLES `ordertable` WRITE;
/*!40000 ALTER TABLE `ordertable` DISABLE KEYS */;
INSERT INTO `ordertable` VALUES (18,1,1,'2024-07-17 23:46:06',935.00,'pending','UPI'),(19,7,2,'2024-07-18 00:05:01',940.00,'pending','UPI'),(20,1,1,'2024-07-18 00:14:53',720.00,'pending','UPI'),(21,7,3,'2024-07-18 00:34:30',970.00,'pending','UPI'),(22,1,4,'2024-07-18 23:46:00',675.00,'pending','UPI'),(23,1,2,'2024-07-18 23:57:25',870.00,'pending','UPI'),(24,1,1,'2024-07-19 00:02:40',400.00,'pending','UPI'),(25,1,4,'2024-07-19 00:12:59',650.00,'pending','UPI'),(26,1,1,'2024-07-19 13:21:53',350.00,'pending','COD'),(27,22,3,'2024-07-19 13:24:42',1195.00,'pending','UPI'),(28,1,1,'2024-07-20 12:54:32',535.00,'pending','UPI'),(29,1,1,'2024-07-20 14:48:46',535.00,'pending','UPI'),(30,23,1,'2024-07-27 23:12:12',550.00,'pending','debit card');
/*!40000 ALTER TABLE `ordertable` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-07-30  2:56:01
