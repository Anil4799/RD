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
-- Table structure for table `batch_info`
--

DROP TABLE IF EXISTS `batch_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `batch_info` (
  `Batch_Num` int(11) NOT NULL,
  `Batch_Id` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Year_Num` int(11) NOT NULL,
  `Quarter_Num` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Start_Date` date DEFAULT NULL,
  `End_Date` date DEFAULT NULL,
  `Status` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`Year_Num`,`Quarter_Num`,`Batch_Num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `batch_info`
--

LOCK TABLES `batch_info` WRITE;
/*!40000 ALTER TABLE `batch_info` DISABLE KEYS */;
INSERT INTO `batch_info` VALUES (1,'RD-Q2-2015-B1',2015,'Q2','2015-05-14','2019-12-31','Not Started'),(1,'RD-Q1-2019-B1',2019,'Q1','2019-01-01','2019-12-31','Not Started'),(1,'RD-Q2-2019-B1',2019,'Q2','2019-05-01','2019-12-31','Not Started'),(1,'RD-Q3-2019-B1',2019,'Q3','2019-09-13','2019-11-13','Not Started');
/*!40000 ALTER TABLE `batch_info` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-05-14 11:35:55
=======================================

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

   
 END
=======================

CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_procedure`( IN Batch_Num INT, IN Batch_Id nvarchar(200), IN  Year_Num INT, IN Quarter_Num nvarchar(200),IN Start_Date DATE, IN End_Date DATE,IN Batch_Status nvarchar(200))
BEGIN

insert into batch_info values(Batch_Num,Batch_Id,Year_Num,Quarter_Num,Start_Date,End_Date,Batch_Status);
END
