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
  `batch_num` int(11) NOT NULL,
  `batch_id` varchar(20) NOT NULL,
  `year_num` int(11) NOT NULL,
  `quarter_num` varchar(10) NOT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `status` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`year_num`,`quarter_num`,`batch_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `batch_info`
--

LOCK TABLES `batch_info` WRITE;
/*!40000 ALTER TABLE `batch_info` DISABLE KEYS */;
INSERT INTO `batch_info` VALUES (1,'RD-Q1-2019-B1',2019,'Q1','2019-01-01','2019-12-31','Completed'),(1,'RD-Q2-2019-B1',2019,'Q2','2019-05-10','2019-09-10','Completed'),(2,'RD-Q2-2019-B2',2019,'Q2','2019-05-10','2019-08-10','Completed'),(3,'RD-Q2-2019-B3',2019,'Q2','2019-05-10','2019-09-10','In Progress'),(1,'RD-Q3-2019-B1',2019,'Q3','2019-07-10','2019-06-10','In Progress'),(2,'RD-Q3-2019-B2',2019,'Q3','2019-09-11','2019-12-31','Not Started');
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

-- Dump completed on 2019-05-10 11:30:01

CREATE DEFINER=`root`@`localhost` PROCEDURE `batch_id_proc`(IN start_date DATE, OUT batch_id VARCHAR(255))
BEGIN

  DECLARE quarter_proc VARCHAR(255);
  DECLARE quarter_temp VARCHAR(255);
  DECLARE bnum_temp INT;
    SET @month_proc= (SELECT MONTH(start_date));
    IF (@month_proc>=1 AND @month_proc<=3) THEN
     SET quarter_proc = 'Q1';
    ELSEIF (@month_proc>=4 AND @month_proc<=6) THEN
     SET quarter_proc = 'Q2';
    ELSEIF (@month_proc>=7 AND @month_proc<=9) THEN
     SET quarter_proc = 'Q3';
    ELSEIF (@month_proc>=10 AND @month_proc<=12) THEN
     SET quarter_proc = 'Q4';
    END IF;	
   SET @year_proc=(SELECT YEAR(start_date));

   SELECT count(*) INTO @temp FROM batch_info where year_num=@year_proc and quarter_num=quarter_proc;

   IF( @temp>=1) THEN
	SET bnum_temp=@temp+1;
   ELSE
      SET bnum_temp=1;				
   END IF;
 	
   SELECT CONCAT('RD-',quarter_proc,'-',@year_proc,'-B',bnum_temp) into batch_id;
  
 END
 

 
CREATE DEFINER=`root`@`localhost` PROCEDURE `insert_procedure`( IN bnum INT, IN batch_id varchar(255), IN  year_num INT, IN quart_num varchar(255),IN start_date DATE, IN end_date DATE,IN batch_status varchar(255))
BEGIN

insert into batch_info values(bnum,batch_id,year_num,quart_num,start_date,end_date,batch_status);
END
