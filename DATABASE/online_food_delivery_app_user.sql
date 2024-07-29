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
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `UserId` int NOT NULL AUTO_INCREMENT,
  `UserName` varchar(255) NOT NULL,
  `Password` varchar(255) NOT NULL,
  `Email` varchar(255) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `CreatedDate` datetime DEFAULT CURRENT_TIMESTAMP,
  `LastLoginDate` datetime DEFAULT NULL,
  PRIMARY KEY (`UserId`),
  UNIQUE KEY `Email_UNIQUE` (`Email`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'sivakrishna','123456','siva@gmail.com','banglore','Customer','2024-06-09 22:47:00',NULL),(5,'sivakesava','123456','kesva@gmail.com','vijayawada','Customer','2024-06-09 22:49:19',NULL),(6,'maillikarjuna','4567','malli@gmail.com','mahanadu','Customer','2024-07-12 02:09:25',NULL),(7,'srinu','123456','srinu@gmail.com',NULL,'Customer','2024-07-12 20:08:57',NULL),(8,'krishna','Sivakrishna@@14','krishna@gmail.com',NULL,'Customer','2024-07-12 20:20:27',NULL),(9,'ragu','123456','ragu@gmail.com',NULL,'Customer','2024-07-12 20:23:57',NULL),(10,'kalayan','456766','kalayan@gmail.com','mahanadu','Customer','2024-07-12 20:29:32',NULL),(11,'bellamkonda','123456','bellamkonda@gmail.com',NULL,'Customer','2024-07-12 20:30:46',NULL),(12,'sathish','123456','sathish@gmail.com',NULL,'Customer','2024-07-14 12:26:12',NULL),(13,'kesava','123456','kesava@gmail.com',NULL,'Customer','2024-07-14 16:08:50',NULL),(14,'chandrika','123456','chandrika@gmail.com',NULL,'Customer','2024-07-16 21:35:37',NULL),(15,'sivakrishna','123456','sivakrishna@gmail.com',NULL,'Customer','2024-07-19 00:57:32',NULL),(16,'sai','123456','sai@gmail.com',NULL,'Customer','2024-07-19 01:06:34',NULL),(17,'harika','123456','harika@gmail.com',NULL,'Customer','2024-07-19 01:07:58',NULL),(18,'zeasus','123456','zeasus@gmail.com',NULL,'Customer','2024-07-19 01:12:47',NULL),(19,'suresh','123456','suresh@gmail.com',NULL,'Customer','2024-07-19 01:29:28',NULL),(20,'kumar','123456','kumar@gmail.com',NULL,'Customer','2024-07-19 01:30:22',NULL),(21,'raju','123456','raju@gmail.com',NULL,'Customer','2024-07-19 01:31:36',NULL),(22,'nikhil','123456','nikhil@gmail.com',NULL,'Customer','2024-07-19 13:23:26',NULL),(23,'dheeraj','123456','dheeraj@gmail.com',NULL,'Customer','2024-07-27 23:10:40',NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-07-30  2:56:00
