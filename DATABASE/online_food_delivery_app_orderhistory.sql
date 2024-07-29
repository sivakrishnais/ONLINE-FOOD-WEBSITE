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
-- Table structure for table `orderhistory`
--

DROP TABLE IF EXISTS `orderhistory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orderhistory` (
  `OrderHistoryId` int NOT NULL AUTO_INCREMENT,
  `UserId` int DEFAULT NULL,
  `OrderId` int DEFAULT NULL,
  `OrderDate` datetime DEFAULT CURRENT_TIMESTAMP,
  `TotalAmount` decimal(10,2) DEFAULT NULL,
  `Status` enum('Delivered','Cancelled','Returned') NOT NULL,
  `RestaurentImage` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`OrderHistoryId`),
  KEY `UserId` (`UserId`),
  KEY `OrderId` (`OrderId`),
  CONSTRAINT `orderhistory_ibfk_1` FOREIGN KEY (`UserId`) REFERENCES `user` (`UserId`),
  CONSTRAINT `orderhistory_ibfk_2` FOREIGN KEY (`OrderId`) REFERENCES `ordertable` (`OrderId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderhistory`
--

LOCK TABLES `orderhistory` WRITE;
/*!40000 ALTER TABLE `orderhistory` DISABLE KEYS */;
INSERT INTO `orderhistory` VALUES (1,1,23,'2024-07-18 23:57:25',870.00,'Delivered','https://img.freepik.com/free-photo/photorealistic-wedding-venue-with-intricate-decor-ornaments_23-2151481522.jpg'),(2,1,24,'2024-07-19 00:02:40',400.00,'Delivered','https://dynamic-media-cdn.tripadvisor.com/media/photo-o/0d/70/95/c4/tfl.jpg?w=600&h=-1&s=1'),(3,1,25,'2024-07-19 00:12:59',650.00,'Delivered','https://img.freepik.com/premium-photo/cozy-restaurant-with-people-waiter_175935-230.jpg?w=900'),(4,1,26,'2024-07-19 13:21:53',350.00,'Delivered','https://dynamic-media-cdn.tripadvisor.com/media/photo-o/0d/70/95/c4/tfl.jpg?w=600&h=-1&s=1'),(5,22,27,'2024-07-19 13:24:42',1195.00,'Delivered','https://img.freepik.com/free-photo/restaurant-hall-with-red-brick-walls-wooden-tables-pipes-ceiling_140725-8504.jpg?t=st=1721124096~exp=1721127696~hmac=ec8181e552273d4716565176673602163cf1e37e8ccc2094b1e94c81fc7c3817&w=740'),(6,1,28,'2024-07-20 12:54:32',535.00,'Delivered','https://dynamic-media-cdn.tripadvisor.com/media/photo-o/0d/70/95/c4/tfl.jpg?w=600&h=-1&s=1'),(7,1,29,'2024-07-20 14:48:46',535.00,'Delivered','https://dynamic-media-cdn.tripadvisor.com/media/photo-o/0d/70/95/c4/tfl.jpg?w=600&h=-1&s=1'),(8,23,30,'2024-07-27 23:12:12',550.00,'Delivered','https://dynamic-media-cdn.tripadvisor.com/media/photo-o/0d/70/95/c4/tfl.jpg?w=600&h=-1&s=1');
/*!40000 ALTER TABLE `orderhistory` ENABLE KEYS */;
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
