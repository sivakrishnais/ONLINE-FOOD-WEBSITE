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
-- Table structure for table `menu`
--

DROP TABLE IF EXISTS `menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `menu` (
  `MenuId` int NOT NULL AUTO_INCREMENT,
  `RestaurantId` int DEFAULT NULL,
  `ItemName` varchar(255) NOT NULL,
  `Description` text,
  `Price` decimal(10,2) DEFAULT NULL,
  `IsAvaliable` tinyint(1) DEFAULT '1',
  `ImagePath` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`MenuId`),
  KEY `RestaurantId` (`RestaurantId`),
  CONSTRAINT `menu_ibfk_1` FOREIGN KEY (`RestaurantId`) REFERENCES `restaurant` (`RestaurantId`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` VALUES (1,1,'Pizza Hut','Delicious pizzas',200.00,1,'https://media-assets.swiggy.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,w_660/2b4f62d606d1b2bfba9ba9e5386fabb7'),(2,1,'Barbeque Nation','North Indian Barbecue',150.00,1,'https://media-assets.swiggy.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,w_660/bweqsg26xmnluflb5pgf'),(3,1,'Five Star chicken','Indian cuisine',200.00,1,'https://media-assets.swiggy.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,w_660/tbprikroummbyvmggzes'),(4,1,'Bengaluru Bhavan','South Indian, Biryani',185.00,1,'https://media-assets.swiggy.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,w_660/6bfb48bb2346de77aeded4f829465ac3'),(5,2,'Sweet Magic Mithai Shop','South Indian',190.00,1,'https://media-assets.swiggy.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,w_660/p2k9r9zkeqcjhohsgrfu'),(6,2,'KFC','Burger, Fast Food',250.00,1,'https://media-assets.swiggy.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,w_660/RX_THUMBNAIL/IMAGES/VENDOR/2024/4/17/1b92e544-fce7-45ac-941a-50092e3037a5_69570.JPG'),(7,2,'Sri Balaji Fast Food','Andhra, South Indian, Chinese',310.00,1,'https://media-assets.swiggy.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,w_660/lr4ryzp2d0hfrivahvqq'),(8,2,'Good Morning Tea And Fast','Chinese cuisine',120.00,1,'https://media-assets.swiggy.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,w_660/f1bc9ddf53de574cdc35ab2f717df234'),(9,3,'Country Made Grills','American cuisine',350.00,1,'https://media-assets.swiggy.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,w_660/6c3338149bc350b802470db3e45bc166'),(10,3,'New Welcome Fast','South Indian cuisine',450.00,1,'https://media-assets.swiggy.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,w_660/ca24677cec294c447db7ed3ddd40c124'),(11,3,'New Welcome Roti Gar','Chinese, Biryani, Tandoor',170.00,1,'https://media-assets.swiggy.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,w_660/f9f16f19c87e34f11d5fe83ed7621459'),(12,3,'Platform 65 Vijaywada','North Indian cuisine',225.00,1,'https://media-assets.swiggy.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,w_660/n2w7nrcbjdotueuniuan'),(13,4,'Bismilla Biryani & Fast Food','Biryani, North Indian cuisine',425.00,1,'https://media-assets.swiggy.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,w_660/hdyfxaofzbrcipl8neje'),(14,4,'Kailash Parbat','Punjabi Snacks',100.00,1,'https://media-assets.swiggy.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,w_660/RX_THUMBNAIL/IMAGES/VENDOR/2024/3/29/8014ed0d-c1f6-4276-ab31-7e67eea569e2_863233.jpg'),(15,4,'Makers Of MilkShakes','Ice cream',150.00,1,'https://media-assets.swiggy.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,w_660/pxttwepnfxbysd37iiyk'),(16,4,'Domman\'s Pizza','Italian, Pastas, Desserts',220.00,1,'https://media-assets.swiggy.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,w_660/d0450ce1a6ba19ea60cd724471ed54a8'),(17,5,'Hoskote 4 Am Biryani','Biryani, Chinese',150.00,1,'https://media-assets.swiggy.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,w_660/ulbrrcoke5fgzqnwwcjn'),(18,5,'Sliver Birayani','Biryani,South Indian',250.00,1,'https://media-assets.swiggy.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,w_660/rlyepihgnuxcs74qjitv'),(19,5,'UTK','South Indian',300.00,1,'https://media-assets.swiggy.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,w_660/166b86aeb0e1464718c31f3801072824'),(20,5,'Biue 21fox','Thindhuri',450.00,1,'https://media-assets.swiggy.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,w_660/67a049690883e2a8cc66975daa3e40fd'),(21,6,'Vasu Reddy Sweets','Sweet',500.00,1,'https://media-assets.swiggy.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,w_660/seyeja15srhcqybofzmw'),(22,6,'Ramu Hotel','Sea Food',430.00,1,'https://media-assets.swiggy.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,w_660/f0669511fb92b2e4fd0b005ed9cb24f3'),(23,6,'KFC','FastFood ',300.00,1,'https://media-assets.swiggy.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,w_660/RX_THUMBNAIL/IMAGES/VENDOR/2024/4/17/1b92e544-fce7-45ac-941a-50092e3037a5_69570.JPG'),(24,6,'Andhra Rice ','Briyani',250.00,1,'https://media-assets.swiggy.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,w_660/26c7f46004dbdbaf3e9e4d472f22a57b');
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;
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
