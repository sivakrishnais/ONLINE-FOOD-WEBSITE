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
-- Table structure for table `restaurant`
--

DROP TABLE IF EXISTS `restaurant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `restaurant` (
  `RestaurantId` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) NOT NULL,
  `CuisineType` varchar(255) DEFAULT NULL,
  `DeliveryTime` int DEFAULT NULL,
  `Address` longtext,
  `AdminUserId` int DEFAULT NULL,
  `Rating` decimal(3,2) DEFAULT NULL,
  `IsActive` tinyint(1) DEFAULT '1',
  `ImagePath` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`RestaurantId`),
  KEY `AdminUserId` (`AdminUserId`),
  CONSTRAINT `restaurant_ibfk_1` FOREIGN KEY (`AdminUserId`) REFERENCES `user` (`UserId`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `restaurant`
--

LOCK TABLES `restaurant` WRITE;
/*!40000 ALTER TABLE `restaurant` DISABLE KEYS */;
INSERT INTO `restaurant` VALUES (1,'Mahkhanki Darbar','Kebabs, Mughlai, Beverages, Desserts',25,'Ramachandra Rao Road',NULL,4.10,1,'https://dynamic-media-cdn.tripadvisor.com/media/photo-o/0d/70/95/c4/tfl.jpg?w=600&h=-1&s=1'),(2,'Samosa Singh','North Indian, Indian, Snacks, Beverages',30,'Governorpet',NULL,4.10,1,'https://img.freepik.com/free-photo/photorealistic-wedding-venue-with-intricate-decor-ornaments_23-2151481522.jpg'),(3,'Sweet Magic','South Indian, Indian, Biryani, Desserts, Sweets, Bakery',30,'Labbipet',NULL,4.10,1,'https://img.freepik.com/free-photo/restaurant-hall-with-red-brick-walls-wooden-tables-pipes-ceiling_140725-8504.jpg?t=st=1721124096~exp=1721127696~hmac=ec8181e552273d4716565176673602163cf1e37e8ccc2094b1e94c81fc7c3817&w=740'),(4,'Burger King','Burgers, American',30,'Balaji Nagar',NULL,4.10,1,'https://img.freepik.com/premium-photo/cozy-restaurant-with-people-waiter_175935-230.jpg?w=900'),(5,'Pizza Hut','Pizzas',30,'Labbipet',NULL,4.50,1,'https://img.freepik.com/free-photo/happy-waiter-holding-plates-with-food-looking-camera-while-serving-guests-restaurant_637285-1707.jpg?size=626&ext=jpg&ga=GA1.1.1725897515.1721124080&semt=sph'),(6,'Barbeque Nation','North Indian Borbeque',45,'Labbipet',NULL,4.30,1,'https://as1.ftcdn.net/v2/jpg/07/06/20/76/1000_F_706207663_7n0PtqO5NCzj9rkqOXPiR5VB4UhwPcEy.jpg'),(7,'Five Star chicken','Indian',25,'Governorpet',NULL,4.00,1,'https://as2.ftcdn.net/v2/jpg/02/83/40/05/1000_F_283400521_EBWKN3NMtZexYj7qHxQCf0ba999WZM8d.jpg'),(8,'Bengaluru Bhavan','South Indian,Birayani',35,'Auto Nagar And Bench Circle',NULL,4.20,1,'https://as1.ftcdn.net/v2/jpg/02/38/10/52/1000_F_238105207_2jrGVrP5mtzB0LFYJJoZIrI09xy7wHDp.jpg'),(9,'Sweet Magic Mithai Shop','South Indian',20,'Labbipet',NULL,4.10,1,'https://img.freepik.com/free-photo/classic-luxury-style-restaurant-with-tables-chairs_140725-9389.jpg?size=626&ext=jpg&ga=GA1.1.1725897515.1721124080&semt=sph'),(10,'KFC','Burger,Fast Food',30,'Auto Nagar',NULL,4.40,1,'https://img.freepik.com/free-photo/medium-shot-woman-working-luxury-restaurant_23-2150598369.jpg?size=626&ext=jpg&ga=GA1.1.1725897515.1721124080&semt=sph'),(11,'Sri Balaji Fast Food','Andhra,South Indian,Chinese',15,'Governorpet',NULL,3.90,1,'https://img.freepik.com/premium-photo/luxurious-restaurant-with-palm-trees-inside-with-large-glass-atrium-with-wooden-walls_295714-6229.jpg?size=626&ext=jpg&ga=GA1.1.1725897515.1721124080&semt=sph'),(12,'Good Morning Tea And Fast','Chinese',10,'Auto Nagar',NULL,4.00,1,'https://img.freepik.com/free-photo/waiter-works-restaurant-medical-mask-gloves-coronavirus-pandemic_155003-13957.jpg?t=st=1721128735~exp=1721132335~hmac=9ecac775a1c43d20b06fbf736cba23ff9eb455fa7aef1afb8ed92c3c5e046f79&w=900'),(13,'Country Made Grills','American',25,'Machavaram',NULL,4.30,1,'https://img.freepik.com/free-photo/close-up-smiley-friends-restaurant_23-2148965380.jpg?size=626&ext=jpg&ga=GA1.1.1725897515.1721124080&semt=sph'),(14,'New Welcome Fast','South Indian',20,'Seethapuram',NULL,3.80,1,'https://img.freepik.com/free-photo/young-adults-having-party-home_23-2149215869.jpg?w=900&t=st=1721128937~exp=1721129537~hmac=fd1cc26591d8ce58f037fdba1a064f8a5824ad216f893dfacf3a356aece519ab'),(15,'New Welcome Roti Gar','Chinese,Birayani,Tandoor',40,'Ramrapdu',NULL,3.70,1,'https://img.freepik.com/premium-photo/happy-family-celebrating-grandfather-birthday-with-cake-candles-home_52137-40866.jpg?w=900'),(16,'Platform 65 Vijaywada','North Indian',35,'Auto Nagar and Bench Circle',NULL,4.10,1,'https://as2.ftcdn.net/v2/jpg/06/35/74/25/1000_F_635742574_Xf7Be8itJSZZpJUhzjyG96Km5iExz6kw.jpg'),(17,'Bismilla Birayani & Fast Food','Birayani,North Indian',30,'Krishna Lanka',NULL,4.20,1,'https://media-assets.swiggy.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,w_660/hdyfxaofzbrcipl8neje'),(18,'Kailsh parbat','Punjab Snacks',25,'Bench Circle and Auto Nagar',NULL,4.00,1,'https://media-assets.swiggy.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,w_660/RX_THUMBNAIL/IMAGES/VENDOR/2024/3/29/8014ed0d-c1f6-4276-ab31-7e67eea569e2_863233.jpg'),(19,'Makers Of MilkShakes','Ice Cream',15,'Krishna Lanka',NULL,4.50,1,'https://media-assets.swiggy.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,w_660/pxttwepnfxbysd37iiyk');
/*!40000 ALTER TABLE `restaurant` ENABLE KEYS */;
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
