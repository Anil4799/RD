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
-- Table structure for table `student_educational_info`
--

DROP TABLE IF EXISTS `student_educational_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `student_educational_info` (
  `Email_Id` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `College_Name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '',
  `College_Loc` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '',
  `Graduation` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '',
  `Graduation_Stream` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '',
  `Passed_Out_Year` int(10) unsigned DEFAULT '0',
  `Graduation_Marks` int(10) unsigned DEFAULT '0',
  `Inter_Marks` int(10) unsigned DEFAULT '0',
  `Ssc_Marks` int(10) unsigned DEFAULT '0',
  KEY `Email_Id` (`Email_Id`),
  KEY `College_Name` (`College_Name`),
  CONSTRAINT `student_educational_info_ibfk_1` FOREIGN KEY (`Email_Id`) REFERENCES `student_personal_info` (`Email_Id`),
  CONSTRAINT `student_educational_info_ibfk_2` FOREIGN KEY (`College_Name`) REFERENCES `student_college_info` (`College_Name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_educational_info`
--

LOCK TABLES `student_educational_info` WRITE;
/*!40000 ALTER TABLE `student_educational_info` DISABLE KEYS */;
INSERT INTO `student_educational_info` VALUES ('qqq@ss.com','','','','',0,0,0,0),('sdmm@dd.com','','','','',0,0,0,0);
/*!40000 ALTER TABLE `student_educational_info` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-05-16 18:40:14
