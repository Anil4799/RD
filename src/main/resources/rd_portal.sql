
DROP TABLE IF EXISTS `batch_info`;
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

INSERT INTO `batch_info` VALUES (1,'RD-Q2-2015-B1',2015,'Q2','2015-05-14','2019-12-31','Not Started'),(1,'RD-Q1-2019-B1',2019,'Q1','2019-01-01','2019-12-31','Not Started'),(1,'RD-Q2-2019-B1',2019,'Q2','2019-05-01','2019-12-31','Not Started'),(1,'RD-Q3-2019-B1',2019,'Q3','2019-09-13','2019-11-13','Not Started');

DROP TABLE IF EXISTS `assigned_location`;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `assigned_location` (
  `Assigned_Location` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

