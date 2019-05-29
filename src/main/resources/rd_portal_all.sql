CREATE DATABASE  IF NOT EXISTS `rd_portal` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `rd_portal`;
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
-- Table structure for table `assigned_location`
--

DROP TABLE IF EXISTS `assigned_location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `assigned_location` (
  `Assigned_Location` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assigned_location`
--

LOCK TABLES `assigned_location` WRITE;
/*!40000 ALTER TABLE `assigned_location` DISABLE KEYS */;
INSERT INTO `assigned_location` VALUES ('Hyderbad'),('Pune'),('Bangalore');
/*!40000 ALTER TABLE `assigned_location` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `batch_info`
--

DROP TABLE IF EXISTS `batch_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `batch_info` (
  `Serial_Num` int(11) NOT NULL AUTO_INCREMENT,
  `Batch_Num` int(11) DEFAULT NULL,
  `Batch_Id` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Year_Num` int(11) DEFAULT NULL,
  `Quarter_Num` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `Start_Date` date DEFAULT NULL,
  `End_Date` date DEFAULT NULL,
  `Status` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `Comment` longtext,
  PRIMARY KEY (`Batch_Id`),
  UNIQUE KEY `Serial_Num_UNIQUE` (`Serial_Num`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `batch_info`
--

LOCK TABLES `batch_info` WRITE;
/*!40000 ALTER TABLE `batch_info` DISABLE KEYS */;
INSERT INTO `batch_info` VALUES (24,5,'RD-Q2-2019-B5',2019,'Q2','2019-05-07','2019-05-09','Completed','ccccctttteeee'),(20,6,'RD-Q2-2019-B6',2019,'Q2','2019-05-07','2019-05-09','Completed','rrrggggwww'),(21,7,'RD-Q2-2019-B7',2019,'Q2','2019-05-31','2019-06-21','Completed',NULL),(22,8,'RD-Q2-2019-B8',2019,'Q2','2019-06-01','2019-12-10','Completed','abcdefuuu'),(23,1,'RD-Q3-2019-B1',2019,'Q3','2019-09-02','2019-12-31','Completed','xxxxxggg');
/*!40000 ALTER TABLE `batch_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `core_skill`
--

DROP TABLE IF EXISTS `core_skill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `core_skill` (
  `Skill_Name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `core_skill`
--

LOCK TABLES `core_skill` WRITE;
/*!40000 ALTER TABLE `core_skill` DISABLE KEYS */;
INSERT INTO `core_skill` VALUES ('Python'),('Java'),('.Net'),('JavaScript'),('PHP');
/*!40000 ALTER TABLE `core_skill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_status`
--

DROP TABLE IF EXISTS `employee_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `employee_status` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Employee_Status` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_status`
--

LOCK TABLES `employee_status` WRITE;
/*!40000 ALTER TABLE `employee_status` DISABLE KEYS */;
INSERT INTO `employee_status` VALUES (1,'Active'),(2,'Terminated'),(3,'Resigned as FTE'),(4,'Resigned as Intern');
/*!40000 ALTER TABLE `employee_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_type`
--

DROP TABLE IF EXISTS `employee_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `employee_type` (
  `Employee_Type` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_type`
--

LOCK TABLES `employee_type` WRITE;
/*!40000 ALTER TABLE `employee_type` DISABLE KEYS */;
INSERT INTO `employee_type` VALUES ('FTE'),('Internship');
/*!40000 ALTER TABLE `employee_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `graduation_speciality`
--

DROP TABLE IF EXISTS `graduation_speciality`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `graduation_speciality` (
  `Graduation_Speciality` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `graduation_speciality`
--

LOCK TABLES `graduation_speciality` WRITE;
/*!40000 ALTER TABLE `graduation_speciality` DISABLE KEYS */;
INSERT INTO `graduation_speciality` VALUES ('ECE'),('CSE'),('IT');
/*!40000 ALTER TABLE `graduation_speciality` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mentor_info`
--

DROP TABLE IF EXISTS `mentor_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `mentor_info` (
  `SerialNo` int(11) NOT NULL AUTO_INCREMENT,
  `Mentor_Name` varchar(400) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `Email_Id` varchar(400) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Mentorship_Start_Date` date DEFAULT NULL,
  `Mentorship_End_Date` date DEFAULT NULL,
  `Max_No_Mentees` int(11) DEFAULT NULL,
  `Technology_Stream` varchar(400) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `Status` varchar(400) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`Email_Id`),
  UNIQUE KEY `SerialNo_UNIQUE` (`SerialNo`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mentor_info`
--

LOCK TABLES `mentor_info` WRITE;
/*!40000 ALTER TABLE `mentor_info` DISABLE KEYS */;
INSERT INTO `mentor_info` VALUES (15,' ',' ','0000-00-00','0000-00-00',NULL,NULL,NULL),(16,'Jagadeesh_Dandu','Jagadeesh_Dandu@epam.com','2019-05-09','2019-06-01',6,'SDET - Software Development Engineer in Testing','inactive'),(17,'Karthik','Karthik_Kota@gmail.com','2019-05-07','2019-05-30',7,'SDET - Software Development Engineer in Testing','active'),(20,'Karthik','Karthi_Kota@epam.com','2019-05-07','2019-05-31',7,'Java','active'),(14,'SSS','sss@sss.com','2019-05-07','2019-05-24',12,'Java','active'),(19,'Sudheer','Sudheer_Surya@epam.com','2019-05-07','2019-05-23',6,'.Net','onhold'),(12,'test','test_mentor1@epam.com','2019-05-06','2019-05-31',10,'Java','active');
/*!40000 ALTER TABLE `mentor_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu`
--

DROP TABLE IF EXISTS `menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `menu` (
  `menuid` int(11) NOT NULL,
  `menuname` varchar(45) NOT NULL,
  `menupagepath` varchar(100) NOT NULL,
  PRIMARY KEY (`menuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` VALUES (1,'STUDENT INFO','studentList'),(2,'MENTOR INFO','mentorList'),(3,'BATCH INFO','batchInfo'),(4,'REPORTS','reports'),(5,'STUDENT INFO','mentorstudentList'),(6,'FEEDBACK','jsp/timesheet.jsp'),(7,'TIMESHEET','jsp/timesheet.jsp');
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menuactionitems`
--

DROP TABLE IF EXISTS `menuactionitems`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `menuactionitems` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  `action` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menuactionitems`
--

LOCK TABLES `menuactionitems` WRITE;
/*!40000 ALTER TABLE `menuactionitems` DISABLE KEYS */;
INSERT INTO `menuactionitems` VALUES (1,1,1,'View'),(2,1,1,'Edit'),(3,1,1,'Deactivate'),(4,1,6,'View'),(5,1,6,'Activate'),(6,1,7,'View'),(7,1,7,'Activate'),(8,1,8,'View'),(9,1,8,'Activate'),(10,1,2,'View'),(11,1,2,'Activate'),(12,1,3,'View'),(13,1,3,'Edit'),(14,1,3,'Start Progress'),(15,1,4,'View'),(16,1,4,'Edit'),(17,1,4,'Mark Complete'),(18,1,5,'View'),(19,2,1,'View'),(20,2,1,'Provide Feedback'),(21,2,6,'View'),(22,2,7,'View'),(23,2,8,'View'),(24,1,9,'View'),(25,1,9,'Activate');
/*!40000 ALTER TABLE `menuactionitems` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `role` (
  `roleid` int(11) NOT NULL,
  `rolename` varchar(45) NOT NULL,
  PRIMARY KEY (`roleid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'admin'),(2,'mentor');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rolewithmenu`
--

DROP TABLE IF EXISTS `rolewithmenu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `rolewithmenu` (
  `roleid` int(11) NOT NULL,
  `menuid` int(11) NOT NULL,
  PRIMARY KEY (`roleid`,`menuid`),
  KEY `menumapping_idx` (`menuid`),
  CONSTRAINT `menumapping` FOREIGN KEY (`menuid`) REFERENCES `menu` (`menuid`),
  CONSTRAINT `rolemapping` FOREIGN KEY (`roleid`) REFERENCES `role` (`roleid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rolewithmenu`
--

LOCK TABLES `rolewithmenu` WRITE;
/*!40000 ALTER TABLE `rolewithmenu` DISABLE KEYS */;
INSERT INTO `rolewithmenu` VALUES (1,1),(1,2),(1,3),(1,4),(2,5),(2,6),(2,7);
/*!40000 ALTER TABLE `rolewithmenu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `status`
--

DROP TABLE IF EXISTS `status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `status` (
  `statusId` int(11) NOT NULL,
  `statusName` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`statusId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `status`
--

LOCK TABLES `status` WRITE;
/*!40000 ALTER TABLE `status` DISABLE KEYS */;
INSERT INTO `status` VALUES (1,'active'),(2,'inactive'),(3,'not started'),(4,'in progress'),(5,'completed'),(6,'terminated'),(7,'resigned as fte'),(8,'resigned as intern'),(9,'onhold');
/*!40000 ALTER TABLE `status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student__additional_info`
--

DROP TABLE IF EXISTS `student__additional_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `student__additional_info` (
  `SerialNo` int(11) NOT NULL AUTO_INCREMENT,
  `Email_Id` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `Batch_Id` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `Emp_Type` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `Core_Skill` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `Preferred_Student_Stream` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '',
  `Assigned_Stream` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '',
  `Date_Of_Joining` date NOT NULL DEFAULT '0000-00-00',
  `Mentor_Name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '',
  `Assigned_Location` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '',
  `Relocation` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `Status` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  PRIMARY KEY (`SerialNo`),
  KEY `Email_Id` (`Email_Id`),
  CONSTRAINT `student__additional_info_ibfk_1` FOREIGN KEY (`Email_Id`) REFERENCES `student_personal_info` (`Email_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student__additional_info`
--

LOCK TABLES `student__additional_info` WRITE;
/*!40000 ALTER TABLE `student__additional_info` DISABLE KEYS */;
INSERT INTO `student__additional_info` VALUES (8,'a@a.a','RD-Q2-2019-B6','FTE','Python','','','0012-05-11',' ','Hyderbad','Yes','Active'),(9,'bb@bb.com','RD-Q2-2019-B6','FTE','Python','Java','Big-Data','0012-07-11','test_mentor1@epam.com','Hyderbad','Yes','Active'),(10,'rr@rr.com','RD-Q2-2019-B6','FTE','Python','','','0012-07-11',' ','Hyderbad','Yes','Active'),(11,'WER','RD-Q2-2019-B6','FTE','Python','Java','.Net','0013-01-08','test_mentor1@epam.com','Hyderbad','No','Resigned as Intern'),(12,'vvv@vvv.vvv','RD-Q2-2019-B6','FTE','Python','.Net','','2019-05-29','sss@sss.com','Hyderbad','Yes','Terminated'),(13,'epam@epam','RD-Q2-2019-B7','Internship','Java','Java','.Net','2019-05-21','test_mentor1@epam.com','Hyderbad','Yes','Active'),(14,'ewrtqwe@gmail.com','RD-Q2-2019-B6','FTE','Java','Java','','2019-05-24','test_mentor1@epam.com','Hyderbad','Yes','Resigned as FTE'),(15,'revathi_anu@epam.com','RD-Q2-2019-B6','FTE','Java','','','2019-01-01',' ','Hyderbad','No','Active');
/*!40000 ALTER TABLE `student__additional_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_college_info`
--

DROP TABLE IF EXISTS `student_college_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `student_college_info` (
  `College_Name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `Location` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  PRIMARY KEY (`College_Name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_college_info`
--

LOCK TABLES `student_college_info` WRITE;
/*!40000 ALTER TABLE `student_college_info` DISABLE KEYS */;
INSERT INTO `student_college_info` VALUES ('',''),('BVRIT','Nizampet'),('Chitkara','Chandigarh'),('MLRIT','Gandimaisamma'),('VNRIT','Bachupally');
/*!40000 ALTER TABLE `student_college_info` ENABLE KEYS */;
UNLOCK TABLES;

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
  PRIMARY KEY (`Email_Id`),
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
INSERT INTO `student_educational_info` VALUES ('a@a.a','','','','',0,0,0,0),('bb@bb.com','BVRIT','HYD','2012','CSE',2015,75,75,78),('epam@epam','BVRIT','hyd','mtech','IT',2367,167,365,457),('ewrtqwe@gmail.com','Chitkara','','','',2011,0,444,665),('qqq@qqq.com','','','','',0,0,0,0),('revathi_anu@epam.com','','','','',0,0,0,0),('rr@rr.com','','','','',0,0,0,0),('vvv@vvv.vvv','','','','',0,0,0,0),('WER','','','','',0,0,0,0);
/*!40000 ALTER TABLE `student_educational_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_personal_info`
--

DROP TABLE IF EXISTS `student_personal_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `student_personal_info` (
  `SerialNo` int(11) NOT NULL AUTO_INCREMENT,
  `First_Name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `Last_Name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `Date_Of_Birth` date NOT NULL DEFAULT '0000-00-00',
  `Email_Id` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `Gender` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `Contact` bigint(20) unsigned DEFAULT '0',
  `Location` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  PRIMARY KEY (`Email_Id`),
  UNIQUE KEY `SerialNo_UNIQUE` (`SerialNo`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_personal_info`
--

LOCK TABLES `student_personal_info` WRITE;
/*!40000 ALTER TABLE `student_personal_info` DISABLE KEYS */;
INSERT INTO `student_personal_info` VALUES (44,'a','a','0010-12-10','a@a.a','Male',1,'a'),(45,'xx','ee','2011-03-02','bb@bb.com','Male',0,'hyderabad'),(50,'epam27','sc','2019-04-29','epam@epam','Male',123,'kc'),(51,'gsdkd','sds','2019-05-08','ewrtqwe@gmail.com','Male',9876543210,'Hyd'),(48,'qqq','qqq','2019-05-06','qqq@qqq.com','Male',0,'fff'),(52,'Revathi','Anumola','1988-03-12','revathi_anu@epam.com','Female',0,'Hyderabad'),(46,'rr','rr','0011-02-09','rr@rr.com','Male',0,'rrr'),(49,'vvvv','vvvv','2019-05-06','vvv@vvv.vvv','Male',0,'vvv'),(47,'QWER','WER','2011-01-11','WER','Male',1,'Hyd');
/*!40000 ALTER TABLE `student_personal_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `technical_stream`
--

DROP TABLE IF EXISTS `technical_stream`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `technical_stream` (
  `Stream_Name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `technical_stream`
--

LOCK TABLES `technical_stream` WRITE;
/*!40000 ALTER TABLE `technical_stream` DISABLE KEYS */;
INSERT INTO `technical_stream` VALUES ('Java'),('.Net'),('SDET - Software Development Engineer in Testing'),('Salesforce'),('Big-Data'),('DEP - [Digital Experience Practice]');
/*!40000 ALTER TABLE `technical_stream` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userinfo`
--

DROP TABLE IF EXISTS `userinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `userinfo` (
  `email` varchar(30) NOT NULL,
  `password` varchar(45) NOT NULL,
  `roleid` int(11) NOT NULL,
  PRIMARY KEY (`email`),
  KEY `rolename_idx` (`roleid`),
  CONSTRAINT `rolename` FOREIGN KEY (`roleid`) REFERENCES `role` (`roleid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userinfo`
--

LOCK TABLES `userinfo` WRITE;
/*!40000 ALTER TABLE `userinfo` DISABLE KEYS */;
INSERT INTO `userinfo` VALUES ('test_admin1@epam.com','testadmin',1),('test_admin2@epam.com','testadmin',1),('test_mentor1@epam.com','testmentor',2),('test_mentor2@epam.com','testmentor',2);
/*!40000 ALTER TABLE `userinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'rd_portal'
--
/*!50003 DROP PROCEDURE IF EXISTS `batch` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `batch`()
BEGIN
SELECT * FROM batch_info ORDER BY Serial_Num DESC LIMIT 5;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `batchListWithInDateRange` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `batchListWithInDateRange`(IN startDate DATE, IN endDate DATE)
BEGIN
	SELECT * FROM batch_info WHERE Start_Date>=startDate and End_Date<=endDate;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `batch_id_proc` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `batch_id_proc`(IN Start_Date DATE, OUT Batch_Id NVARCHAR(200))
BEGIN

  DECLARE quarter_proc NVARCHAR(200);
  DECLARE quarter_temp NVARCHAR(200);
  DECLARE bnum_temp INT;
    SET @month_proc= (SELECT MONTH(Start_Date));
    IF (@month_proc>=1 AND @month_proc<=3) THEN
     SET quarter_proc = 'Q1';
    ELSEIF (@month_proc>=4 AND @month_proc<=6) THEN
     SET quarter_proc = 'Q2';
    ELSEIF (@month_proc>=7 AND @month_proc<=9) THEN
     SET quarter_proc = 'Q3';
    ELSEIF (@month_proc>=10 AND @month_proc<=12) THEN
     SET quarter_proc = 'Q4';
    END IF;	
   SET @year_proc=(SELECT YEAR(Start_Date));

   SELECT count(*) INTO @temp FROM batch_info where Year_Num=@year_proc and Quarter_Num=quarter_proc;

   IF( @temp>=1) THEN
	SET bnum_temp=@temp+1;
   ELSE
      SET bnum_temp=1;				
   END IF;
 	
   SELECT CONCAT('RD-',quarter_proc,'-',@year_proc,'-B',bnum_temp) into Batch_Id;

   
 END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `completeStatus` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `completeStatus`(in batchid varchar(200),in commentText longtext)
BEGIN
	UPDATE batch_info SET Status = 'Completed', Comment = IFNULL (CONCAT( Comment , commentText ), commentText)
	WHERE Batch_Id = batchid;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_all_batchID` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_all_batchID`()
BEGIN
	SELECT distinct(Batch_Id) FROM rd_portal.batch_info;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_technology_stream` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_technology_stream`()
BEGIN
SELECT Distinct(Technology_Stream)as technology FROM Mentor_Info where Technology_Stream is not null order by technology;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insert_procedure` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_procedure`( IN Batch_Num INT, IN Batch_Id nvarchar(200), IN  Year_Num INT, IN Quarter_Num nvarchar(200),IN Start_Date DATE, IN End_Date DATE,IN Status nvarchar(200),IN codeToInsertOrUpdate INT)
BEGIN

IF (codeToInsertOrUpdate = -1) THEN 
insert into batch_info(Batch_Num,Batch_Id,Year_Num,Quarter_Num,Start_Date,End_Date,Status) values(Batch_Num,Batch_Id,Year_Num,Quarter_Num,Start_Date,End_Date,Status);

ELSE
  update batch_info set Start_Date=Start_Date ,  End_Date=End_Date , Batch_Id=Batch_id, Year_Num=Year_Num, Quarter_Num=Quarter_Num,  Batch_Num=Batch_num , Status=Status where Serial_Num=codeToInsertOrUpdate;
 
END IF;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `mentor` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `mentor`()
BEGIN
SELECT * FROM Mentor_Info where Mentor_Info.Email_id !='' ORDER BY SerialNo DESC LIMIT 10;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `mentorStudent` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `mentorStudent`(in email nvarchar(200))
BEGIN
select  student_personal_info.email_id,student_personal_info.first_name,student_personal_info.last_name ,student__additional_info.batch_id ,student__additional_info.core_skill,student__additional_info.status from student_personal_info, student__additional_info inner join mentor_info on student__additional_info.mentor_name=email where mentor_info.email_id=student__additional_info.mentor_Name and student__additional_info.email_id=student_personal_info.email_id  ORDER BY student_personal_info.serialNo DESC LIMIT 10;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `menuAction` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `menuAction`(in r int)
BEGIN
SELECT status.StatusName,menuactionitems.Status,menuactionitems.action FROM menuactionitems,status
WHERE Role=r and status.StatusId=menuactionitems.Status;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `search_admin_mentor` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `search_admin_mentor`(in mentorname nvarchar(200),in  technologystream nvarchar(200) )
BEGIN	
	SELECT * 
	FROM Mentor_Info 
	WHERE 
	Mentor_Name LIKE  IFNULL(CONCAT('%',mentorname , '%'),'')
	AND Technology_Stream LIKE  IFNULL(CONCAT('%',technologystream , '%'),'');
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `search_admin_student` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `search_admin_student`(in first_name nvarchar(200),in last_name nvarchar(200),in batch_id nvarchar(20))
BEGIN
select 
student_personal_info.email_id,
student_personal_info.first_name,
student_personal_info.last_name ,
student__additional_info.batch_id ,
student__additional_info.core_skill,
mentor_info.Mentor_Name,
student__additional_info.status 
from 
student_personal_info, 
student__additional_info,
mentor_info 
where student_personal_info.email_id = student__additional_info.email_id  
and mentor_info.email_id = student__additional_info.mentor_name 
and student_personal_info.first_name like IFNULL(CONCAT('%',first_name , '%'),'')
and student_personal_info.last_name  like IFNULL(CONCAT('%',last_name , '%'),'')
and student__additional_info.batch_id like IFNULL(CONCAT('%',batch_id,'%'),'')
ORDER BY 
student_personal_info.first_name;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `search_mentor_student` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `search_mentor_student`(in email nvarchar(200),in first_name nvarchar(200),in last_name nvarchar(200),in batch_id nvarchar(20))
BEGIN
select  
		student_personal_info.email_id,
		student_personal_info.first_name,
		student_personal_info.last_name ,
		student__additional_info.batch_id,
        student__additional_info.core_skill,
        student__additional_info.status 
        from student_personal_info, student__additional_info inner join mentor_info on student__additional_info.mentor_name=email 
        where mentor_info.email_id=student__additional_info.mentor_Name 
        and student__additional_info.email_id=student_personal_info.email_id
        and student_personal_info.first_name like IFNULL(CONCAT('%',first_name , '%'),'')
		and student_personal_info.last_name  like IFNULL(CONCAT('%',last_name , '%'),'')
		and student__additional_info.batch_id like IFNULL(CONCAT('%',batch_id,'%'),'')
		ORDER BY 
		student_personal_info.first_name;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `startProgressStatus` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `startProgressStatus`(in batchid varchar(200),in commentText longtext)
BEGIN
	UPDATE batch_info SET Status = 'In Progress', Comment = IFNULL (CONCAT( Comment , commentText ), commentText)
	WHERE Batch_Id = batchid;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `student` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `student`()
BEGIN
select 
student_personal_info.email_id,
student_personal_info.first_name,
student_personal_info.last_name ,
student__additional_info.batch_id ,
student__additional_info.core_skill,
mentor_info.Mentor_Name,
student__additional_info.status 

from student_personal_info, student__additional_info 
inner join mentor_info 
on student__additional_info.mentor_name=mentor_info.email_id 
where mentor_info.email_id=student__additional_info.mentor_Name 
and student__additional_info.email_id=student_personal_info.email_id  
ORDER BY student_personal_info.serialNo DESC LIMIT 10;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `viewStudent` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `viewStudent`(in email nvarchar(200))
BEGIN
select 
student_personal_info.first_name,student_personal_info.last_name, DATE_FORMAT(student_personal_info.Date_Of_Birth, '%m-%d-%Y') as Date_Of_Birth ,student_personal_info.Email_Id,student_personal_info.Gender,student_personal_info.Contact,student_personal_info.Location,
student_educational_info.College_Name,student_educational_info.College_Loc,student_educational_info.Graduation,student_educational_info.Graduation_Stream,student_educational_info.Passed_Out_Year,student_educational_info.Graduation_Marks,student_educational_info.Inter_Marks,student_educational_info.Ssc_Marks,
student__additional_info.Batch_Id,student__additional_info.Emp_Type,student__additional_info.Core_Skill,student__additional_info.Preferred_Student_Stream,student__additional_info.Assigned_Stream,DATE_FORMAT(student__additional_info.Date_Of_Joining, '%m-%d-%Y') as Date_Of_Joining,student__additional_info.Assigned_Location,student__additional_info.Relocation,student__additional_info.Status,
mentor_info.Mentor_Name

from 
student_personal_info
INNER JOIN
student__additional_info on student_personal_info.email_id = email
INNER JOIN
student_educational_info on student__additional_info.email_id = student_educational_info.email_id
INNER JOIN
mentor_info on mentor_info.email_id = student__additional_info.mentor_name
where student_personal_info.email_id = student__additional_info.email_id
and student_personal_info.email_id = student_educational_info.email_id   
;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-05-29 16:16:55
