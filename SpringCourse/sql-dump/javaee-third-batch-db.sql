-- MySQL dump 10.13  Distrib 8.0.21, for macos10.15 (x86_64)
--
-- Host: localhost    Database: javaee_third_batch
-- ------------------------------------------------------
-- Server version	8.0.21

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
-- Table structure for table `actor`
--

DROP TABLE IF EXISTS `actor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `actor` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(100) DEFAULT NULL,
  `last_name` varchar(100) DEFAULT NULL,
  `street` varchar(100) DEFAULT NULL,
  `township` varchar(100) DEFAULT NULL,
  `city` varchar(100) DEFAULT NULL,
  `gender` int DEFAULT NULL,
  `create_at` datetime DEFAULT NULL,
  `update_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `actor`
--

LOCK TABLES `actor` WRITE;
/*!40000 ALTER TABLE `actor` DISABLE KEYS */;
INSERT INTO `actor` VALUES (1,'James','Bond',NULL,NULL,NULL,0,NULL,NULL),(3,NULL,NULL,NULL,NULL,NULL,NULL,'2021-07-18 18:41:03','2021-07-18 18:41:03'),(4,'James','Bond','SomeStreet','Yankin','Yangon',0,'2021-07-18 18:42:20','2021-07-18 18:42:20'),(5,'Actor','Four','SomeStreet','Yankin','Yangon',0,NULL,'2021-07-18 18:55:16');
/*!40000 ALTER TABLE `actor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movie`
--

DROP TABLE IF EXISTS `movie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movie` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL,
  `director` varchar(200) DEFAULT NULL,
  `year` int DEFAULT NULL,
  `genre` varchar(45) DEFAULT NULL,
  `create_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `update_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie`
--

LOCK TABLES `movie` WRITE;
/*!40000 ALTER TABLE `movie` DISABLE KEYS */;
INSERT INTO `movie` VALUES (1,'Titanic Test','JameCameron',2001,'Action','2021-07-17 19:48:46','2021-07-17 19:48:46'),(2,'Transformer','Hello1',2009,'Action','2021-06-29 20:42:50','2021-06-29 20:42:50'),(3,'Matrix','Jame Cameron',2001,'Horror','2021-06-29 20:47:39','2021-06-29 20:47:39'),(4,'Avatar','Jame Cameron',2001,'Drama','2021-06-29 20:55:53','2021-06-29 20:55:53'),(7,'Back to the future','Somehow 1',2012,'Horror','2021-07-04 19:15:43','2021-07-04 19:15:43'),(9,'NewMovie','NewDirector',2010,'Horror','2021-07-06 19:31:05','2021-07-06 19:31:05'),(10,'New Name','NewDirector',2010,'Horror','2021-07-06 19:46:24','2021-07-06 19:46:24'),(12,'Test Movie','Someone',1990,'Action','2021-07-17 19:16:37','2021-07-17 19:16:37'),(15,'Test Movie detail','Someone',1990,'Action','2021-07-18 19:33:49','2021-07-18 19:33:49'),(16,NULL,NULL,NULL,NULL,'2021-07-18 19:33:49','2021-07-18 19:33:49'),(17,NULL,NULL,NULL,NULL,'2021-07-18 19:41:08','2021-07-18 19:41:08'),(18,NULL,NULL,NULL,NULL,'2021-07-18 19:41:33','2021-07-18 19:41:33'),(19,NULL,NULL,NULL,NULL,'2021-07-18 19:46:36','2021-07-18 19:46:36'),(20,NULL,NULL,NULL,NULL,'2021-07-18 19:47:54','2021-07-18 19:47:54'),(21,'Test Movie detail','Someone',1990,'Action','2021-07-18 19:56:25','2021-07-18 19:56:25'),(22,NULL,NULL,NULL,NULL,'2021-07-18 19:56:25','2021-07-18 19:56:25'),(23,'Test Another Movie detail','Someone',1990,'Action','2021-07-18 19:58:51','2021-07-18 19:58:51'),(24,NULL,NULL,NULL,NULL,'2021-07-18 19:58:51','2021-07-18 19:58:51'),(26,'Test Movie detail 1','Someone',1990,'Action','2021-07-18 20:00:37','2021-07-18 20:00:37'),(27,NULL,NULL,NULL,NULL,'2021-07-18 20:00:37','2021-07-18 20:00:37'),(29,'Test Movie detail 3','Someone',1990,'Action','2021-07-18 20:03:07','2021-07-18 20:03:07'),(30,NULL,NULL,NULL,NULL,'2021-07-18 20:03:07','2021-07-18 20:03:07'),(33,'Test Movie detail 5','Someone',1990,'Action','2021-07-18 20:16:07','2021-07-18 20:16:07'),(34,'Test Movie detail 6','Someone',1990,'Action','2021-07-18 20:16:52','2021-07-18 20:16:52');
/*!40000 ALTER TABLE `movie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movie_detail`
--

DROP TABLE IF EXISTS `movie_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movie_detail` (
  `id` int NOT NULL AUTO_INCREMENT,
  `movie_id` int DEFAULT NULL,
  `description` varchar(2555) DEFAULT NULL,
  `create_at` datetime DEFAULT NULL,
  `update_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie_detail`
--

LOCK TABLES `movie_detail` WRITE;
/*!40000 ALTER TABLE `movie_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `movie_detail` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-07-18 20:32:24
