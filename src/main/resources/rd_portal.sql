
DELIMITER $$
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
