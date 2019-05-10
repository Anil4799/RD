-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: localhost    Database: rd_portal
-- ------------------------------------------------------
-- Server version	8.0.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `student__additional_info`
--

DROP TABLE IF EXISTS `student__additional_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `student__additional_info` (
  `email_id` varchar(45) NOT NULL DEFAULT '',
  `batch_id` varchar(45) NOT NULL DEFAULT '',
  `emp_type` varchar(45) NOT NULL DEFAULT '',
  `core_skill` varchar(45) NOT NULL DEFAULT '',
  `preferred_student_stream` varchar(45) NOT NULL DEFAULT '',
  `assigned_stream` varchar(45) NOT NULL DEFAULT '',
  `date_of_joining` date NOT NULL DEFAULT '0000-00-00',
  `mentor_name` varchar(45) NOT NULL DEFAULT '',
  `assigned_location` varchar(45) NOT NULL DEFAULT '',
  `relocation` varchar(45) NOT NULL DEFAULT '',
  `status` varchar(45) NOT NULL DEFAULT '',
  PRIMARY KEY (`email_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student__additional_info`
--

LOCK TABLES `student__additional_info` WRITE;
/*!40000 ALTER TABLE `student__additional_info` DISABLE KEYS */;
INSERT INTO `student__additional_info` VALUES ('a@b.c','lk76','temp','java','cse','cse','2015-11-03','ABC','HYD','pune','inactive'),('b@b.c','lk76','temp','java','cse','cse','2015-01-03','CBA','RNC','RNC','inactive');
/*!40000 ALTER TABLE `student__additional_info` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-05-10 11:46:30
