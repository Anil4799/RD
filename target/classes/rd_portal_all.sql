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
  `Batch_Id` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `Year_Num` int(11) DEFAULT NULL,
  `Quarter_Num` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `Start_Date` date DEFAULT NULL,
  `End_Date` date DEFAULT NULL,
  `Status` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`Serial_Num`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `batch_info`
--

LOCK TABLES `batch_info` WRITE;
/*!40000 ALTER TABLE `batch_info` DISABLE KEYS */;
INSERT INTO `batch_info` VALUES (1,1,'RD-Q1-2019-B1',2019,'Q1','2019-03-20','2019-05-30','inactive'),(2,2,'RD-Q1-2019-B2',2019,'Q1','2019-03-28','2019-05-30','not started'),(3,1,'RD-Q2-2019-B1',2019,'Q2','2019-05-20','2019-05-30','active'),(4,2,'RD-Q2-2019-B2',2019,'Q2','2019-05-17','2019-05-17','not started'),(5,1,'RD-Q1-2020-B1',2020,'abc','2019-07-07','2019-06-06','string'),(6,1,'RD-Q1-2020-B1',2020,'abc','2019-07-07','2019-06-06','string'),(7,1,'RD-Q1-2020-B1',2020,'abc','2019-07-07','2019-06-06','string'),(8,1,'RD-Q1-2020-B1',2020,'abc','2019-07-07','2019-06-06','string'),(9,1,'RD-Q1-2020-B1',2020,'abc','2019-07-07','2019-06-06','string'),(10,1,'RD-Q1-2020-B1',2020,'abc','2019-07-07','2019-06-06','string'),(11,3,'RD-Q2-2019-B3',2019,'Q2','2019-05-18','2019-05-07','not started'),(12,4,'RD-Q2-2019-B4',2019,'Q2','2019-05-23','2019-05-09','not started'),(13,5,'RD-Q2-2019-B5',2019,'Q2','2019-05-24','2019-05-16','not started'),(14,6,'RD-Q2-2019-B6',2019,'Q2','2019-05-15','2019-05-06','Not Started'),(15,1,'RD-Q1-2020-B1',2020,'abc','2019-07-07','2019-06-06','string');
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
  `Employee_Status` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_status`
--

LOCK TABLES `employee_status` WRITE;
/*!40000 ALTER TABLE `employee_status` DISABLE KEYS */;
INSERT INTO `employee_status` VALUES ('active'),('terminated'),('resigned as FTE'),('resigned as intern');
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
  `Mentor_Name` varchar(400) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `Email_Id` varchar(400) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Mentorship_Start_Date` date DEFAULT NULL,
  `Mentorship_End_Date` date DEFAULT NULL,
  `Max_No_Mentees` int(11) DEFAULT NULL,
  `Technology_Stream` varchar(400) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `Status` varchar(400) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`Email_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mentor_info`
--

LOCK TABLES `mentor_info` WRITE;
/*!40000 ALTER TABLE `mentor_info` DISABLE KEYS */;
INSERT INTO `mentor_info` VALUES ('dsa','ad@ss.mm','2019-05-17','2019-05-28',1,'Big-Data','ACTIVE'),('karthik','kkarthik46@gmail.com','2019-05-08','2019-05-31',5,'Java','ACTIVE'),('Ravi','Ravi@epam.com','2019-05-05','2019-07-05',20,'c++','inactive'),('requestara','requestara','2019-05-05','2019-05-20',5,'requestara','requestara'),('requestParams','requestParams','2019-05-05','2019-05-20',5,'requestParams','requestParams'),('Timma','sss@ee.com','2019-05-17','2019-05-29',1,'Big-Data','INACTIVE'),('Sumit','Sumit@epam.com','2019-05-05','2019-07-05',20,'c++','inactive'),('swati','swati@epam.com','2019-05-05','2019-07-05',20,'java','active'),('vijay','vijay@epam.com','2019-05-05','2019-07-05',20,'c++','active'),('vinay','vinay@epam.com','2019-05-05','2019-07-05',20,'c++','active'),('aaaaa','wer@asnbb.com','2019-05-06','2019-05-01',8,'Big-Data','ONHOLD'),('chaitu','z1ddl@yahoo.com','2018-12-30','2018-12-30',5,'cse','Active');
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
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menuactionitems`
--

LOCK TABLES `menuactionitems` WRITE;
/*!40000 ALTER TABLE `menuactionitems` DISABLE KEYS */;
INSERT INTO `menuactionitems` VALUES (1,1,1,'view'),(2,1,1,'edit'),(3,1,1,'deactivate'),(4,1,2,'view'),(5,1,2,'activate'),(6,1,3,'view'),(7,1,3,'edit'),(8,1,3,'start progress'),(9,1,4,'view'),(10,1,4,'edit'),(11,1,4,'mark complete'),(12,1,5,'view'),(13,2,1,'view'),(14,2,1,'provide feedback'),(15,2,2,'view');
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
INSERT INTO `status` VALUES (1,'active'),(2,'inactive'),(3,'not started'),(4,'in progress'),(5,'completed');
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
INSERT INTO `student__additional_info` VALUES (1,'qqq@ss.com','RD-Q1-2019-B1','FTE','Python','Java','.Net','2019-05-24','Ravi@epam.com','Hyderbad','yes','Active'),(2,'sdmm@dd.com','RD-Q1-2019-B1','FTE','Python','Java','','2019-05-17','','Hyderbad','yes','Active'),(3,'rfgh12345@gmail.com','RD-Q1-2019-B1','FTE','Java','Java','Java','2019-04-30','','Hyderabad','Yes','Active'),(4,'vijay456@gmail.com','RD-Q1-2019-B1','FTE','JAVA','PHP','.Net','2019-05-12','','Hyderabad','Yes','Active'),(5,'rfgh12345@gmail.com','RD-Q1-2019-B1','FTE','Java','Java','Java','2019-04-30','','Hyderabad','Yes','Active'),(6,'vijay456@gmail.com','RD-Q1-2019-B1','FTE','JAVA','PHP','.Net','2019-05-12','','Hyderabad','Yes','Active'),(7,'rfgh12345@gmail.com','RD-Q1-2019-B1','FTE','Java','Java','Java','2019-04-30','','Hyderabad','Yes','Active'),(8,'www@ss.com','RD-Q1-2019-B1','FTE','Python','','','2019-05-17','','Hyderbad','yes','Active'),(9,'www2@ss.com','RD-Q1-2019-B1','FTE','Python','Java','Java','2019-05-23','Ravi@epam.com','Hyderbad','yes','Active'),(10,'2343.234@asd.hyrhyghjhgj','RD-Q2-2019-B5','FTE','Python','','','2019-05-17','','Hyderbad','yes','Active'),(11,'yya@mm.cc','RD-Q1-2019-B1','FTE','Java','','','2019-05-16','','Hyderbad','yes','Resigned as Intern'),(12,'ssds@sdf.cvb','RD-Q1-2019-B1','FTE','Python','','','2019-05-17','','Hyderbad','yes','Terminated'),(13,'abc@def.com','RD-Q2-2019-B4','FTE','Java','Java','.Net','2019-05-21','kkarthik46@gmail.com','Pune','yes','Resigned as FTE'),(14,'asd@eeehh..gh','RD-Q2-2019-B2','FTE','Python','','','2019-05-16','','Hyderbad','yes','Resigned as FTE'),(15,'yya@mm.cc','RD-Q1-2019-B1','FTE','Python','','','2019-05-15','','Hyderbad','yes','Resigned as FTE');
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
INSERT INTO `student_educational_info` VALUES ('qqq@ss.com','','','','',0,0,0,0),('sdmm@dd.com','','','','',0,0,0,0),('rfgh12345@gmail.com','Chitkara','Chandigarh','BE','CSE',2013,100,100,100),('vijay456@gmail.com','BVRIT','chan','BE','CSE',2011,200,250,300),('rfgh12345@gmail.com','Chitkara','Chandigarh','BE','CSE',2013,100,100,100),('vijay456@gmail.com','BVRIT','chan','BE','CSE',2011,200,250,300),('rfgh12345@gmail.com','Chitkara','Chandigarh','BE','CSE',2013,100,100,100),('www@ss.com','BVRIT','dsfdsf','','ece',0,0,0,0),('www2@ss.com','','','','',0,0,0,0),('2343.234@asd.hyrhyghjhgj','BVRIT','ghjhgj','','',0,0,0,0),('yya@mm.cc','','','','',0,0,0,0),('ssds@sdf.cvb','','','','',0,0,0,0),('abc@def.com','','','','',0,0,0,0),('asd@eeehh..gh','','','','',0,0,0,0),('yya@mm.cc','','','','',0,0,0,0);
/*!40000 ALTER TABLE `student_educational_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_personal_info`
--

DROP TABLE IF EXISTS `student_personal_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `student_personal_info` (
  `First_Name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `Last_Name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `Date_Of_Birth` date NOT NULL DEFAULT '0000-00-00',
  `Email_Id` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `Gender` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `Contact` bigint(20) unsigned DEFAULT '0',
  `Location` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  PRIMARY KEY (`Email_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_personal_info`
--

LOCK TABLES `student_personal_info` WRITE;
/*!40000 ALTER TABLE `student_personal_info` DISABLE KEYS */;
INSERT INTO `student_personal_info` VALUES ('rttttt','ssss','2019-05-06','2343.234@asd.hyrhyghjhgj','male',234234,'fdsfdg'),('abcdde','xyzzzz','2021-05-15','abc@def.com','male',76576586,'fgjghjg'),('Timma','reddy','2019-05-17','asd@eeehh..gh','male',0,'dgffdg'),('Test','aaa','2019-05-16','qqq@ss.com','male',123213,'ertert'),('Vanshita','Baweja','2009-05-05','rfgh12345@gmail.com','female',98765,'Chandigarh'),('Skr','rrr','2019-05-23','sdmm@dd.com','male',0,'bnbnb'),('zzzz','zzzzz','2019-05-23','ssds@sdf.cvb','male',0,'erttr'),('vijay','kumar','2019-05-20','vijay456@gmail.com','male',894173127,'chna'),('ww','ww','2019-05-14','www2@ss.com','male',0,'ddd'),('Ram','RRRR','2019-05-24','www@ss.com','male',0,'wwww'),('nnn','nnn','2019-05-16','yya@mm.cc','male',0,'ddd');
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
CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_procedure`( IN Batch_Num INT, IN Batch_Id nvarchar(200), IN  Year_Num INT, IN Quarter_Num nvarchar(200),IN Start_Date DATE, IN End_Date DATE,IN Status nvarchar(200))
BEGIN

insert into batch_info(Batch_Num,Batch_Id,Year_Num,Quarter_Num,Start_Date,End_Date,Status) values(Batch_Num,Batch_Id,Year_Num,Quarter_Num,Start_Date,End_Date,Status);
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
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `mentor`()
BEGIN
SELECT * FROM Mentor_Info ORDER BY email_id DESC LIMIT 10;
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
select student_personal_info.first_name,student_personal_info.last_name ,student__additional_info.batch_id ,student__additional_info.core_skill,student__additional_info.status from student_personal_info, student__additional_info ,mentor_info where student__additional_info.mentor_name = email ORDER BY batch_id DESC LIMIT 10;
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
select student_personal_info.first_name,student_personal_info.last_name ,student__additional_info.batch_id ,student__additional_info.core_skill,student__additional_info.mentor_name ,student__additional_info.status from student_personal_info, student__additional_info where student_personal_info.email_id = student__additional_info.email_id ORDER BY student__additional_info.SerialNo DESC LIMIT 10;
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

-- Dump completed on 2019-05-17 18:11:42
