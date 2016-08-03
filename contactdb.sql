/*
SQLyog Ultimate v8.55 
MySQL - 5.7.9 : Database - contactdb
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`contactdb` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `contactdb`;

/*Table structure for table `admintbl` */

DROP TABLE IF EXISTS `admintbl`;

CREATE TABLE `admintbl` (
  `adminId` int(100) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `dateCreated` date DEFAULT NULL,
  `roleId` int(100) DEFAULT NULL,
  `adminDeleted` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`adminId`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

/*Data for the table `admintbl` */

insert  into `admintbl`(`adminId`,`name`,`email`,`password`,`dateCreated`,`roleId`,`adminDeleted`) values (1,'super','lakhoinayatali@yahoo.com','super','0000-00-00',1,0),(4,'lakho','lakho.110@gmail.com','lakho','0000-00-00',4,1),(5,'inayat','lakhoinayatali@yahoo.com','inayat','0000-00-00',1,0),(6,'Nisar','avesiwaseemarif@hotmail.com','torcia','2016-05-23',1,0),(7,'dildar','dildar','dildar','2016-05-24',2,1),(8,'test1','test1','test','2016-07-17',1,0),(9,'test1','test1','test','2016-07-17',1,0),(10,'test2','test2','test2','2016-07-17',2,0),(11,'test3','test3','test3','2016-07-17',3,0),(12,'test4','test4','test4','2016-07-17',4,0),(13,'test5','test5','test5','2016-07-17',3,0),(14,'test6','test6','test6','2016-07-17',2,0),(15,'test7','test7','test7','2016-07-17',2,0);

/*Table structure for table `classtbl` */

DROP TABLE IF EXISTS `classtbl`;

CREATE TABLE `classtbl` (
  `classId` int(100) NOT NULL AUTO_INCREMENT,
  `className` varchar(50) NOT NULL,
  `classDesc` varchar(100) DEFAULT NULL,
  `classType` varchar(50) DEFAULT NULL,
  `dateCreated` date DEFAULT NULL,
  `classDeleted` tinyint(1) DEFAULT NULL,
  `groupId` int(100) DEFAULT NULL,
  PRIMARY KEY (`classId`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

/*Data for the table `classtbl` */

insert  into `classtbl`(`classId`,`className`,`classDesc`,`classType`,`dateCreated`,`classDeleted`,`groupId`) values (1,'9th','class 9','Coaching','0000-00-00',0,2),(2,'LMCAT','LMCAT','Entry Test','0000-00-00',0,5),(3,'13th','13 class','Coaching','2016-05-24',1,NULL),(4,'LMCAT2','LMCAT2','Entry Test','2016-05-24',1,NULL),(5,'LMCAT22','LMCAT22','Coaching','2016-05-24',1,NULL),(6,'10th','10th','Coaching','0000-00-00',0,1),(7,'NUMCAT','NUMCAT','Entry Test','0000-00-00',0,3),(8,'LMCAT222','LMCAT222','Entry Test','2016-05-25',1,NULL),(9,'LMCAT3','LMCAT3','Entry Test','2016-05-25',0,4),(10,'MCAT','MCAT','Entry Test','2016-05-25',0,3),(11,'super','super',NULL,'2016-07-28',1,0);

/*Table structure for table `contact` */

DROP TABLE IF EXISTS `contact`;

CREATE TABLE `contact` (
  `contact_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `address` varchar(45) NOT NULL,
  `telephone` varchar(45) NOT NULL,
  PRIMARY KEY (`contact_id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

/*Data for the table `contact` */

insert  into `contact`(`contact_id`,`name`,`email`,`address`,`telephone`) values (25,'inayat','lakhoinayatali@yahoo.com','karachi','03122142148');

/*Table structure for table `feestbl` */

DROP TABLE IF EXISTS `feestbl`;

CREATE TABLE `feestbl` (
  `feesId` int(11) NOT NULL AUTO_INCREMENT,
  `studentId` int(100) DEFAULT NULL,
  `FeesMonth` varchar(100) DEFAULT NULL,
  `addmissionFee` int(100) DEFAULT NULL,
  `tuitionFee` int(100) DEFAULT NULL,
  `acCharges` int(100) DEFAULT NULL,
  `feeReceived` int(100) DEFAULT NULL,
  `balanceDueDate` date DEFAULT NULL,
  `FeesYear` int(11) DEFAULT NULL,
  `FeesCreated` date DEFAULT NULL,
  `sessionFee` int(100) DEFAULT NULL,
  PRIMARY KEY (`feesId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

/*Data for the table `feestbl` */

insert  into `feestbl`(`feesId`,`studentId`,`FeesMonth`,`addmissionFee`,`tuitionFee`,`acCharges`,`feeReceived`,`balanceDueDate`,`FeesYear`,`FeesCreated`,`sessionFee`) values (1,5,'',0,0,0,33333,'2016-05-31',NULL,'2016-05-24',33600),(2,6,'JAN',2000,7500,0,8000,'2016-05-31',NULL,'2016-05-24',0),(3,7,'',0,0,0,32035,'2016-05-31',NULL,'2016-05-25',33600),(4,8,'',0,0,0,32035,'2016-05-31',NULL,'2016-05-25',33600),(5,9,'',0,0,0,32035,'2016-05-31',NULL,'2016-05-26',33600),(6,4,'APR',NULL,3000,NULL,NULL,'0000-00-00',NULL,'0000-00-00',NULL),(7,4,'MAY',NULL,3000,NULL,NULL,'0000-00-00',NULL,'0000-00-00',NULL);

/*Table structure for table `grouptbl` */

DROP TABLE IF EXISTS `grouptbl`;

CREATE TABLE `grouptbl` (
  `groupId` int(50) NOT NULL AUTO_INCREMENT,
  `groupName` varchar(50) DEFAULT NULL,
  `groupDescription` varchar(100) DEFAULT NULL,
  `groupCreated` date DEFAULT NULL,
  PRIMARY KEY (`groupId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/*Data for the table `grouptbl` */

insert  into `grouptbl`(`groupId`,`groupName`,`groupDescription`,`groupCreated`) values (1,'Medical','Medical','0000-00-00'),(2,'Computer','Computer','0000-00-00'),(3,'Bio','Bio','0000-00-00'),(4,'Eng','Eng','0000-00-00'),(5,'Other','Other','0000-00-00');

/*Table structure for table `sectiontbl` */

DROP TABLE IF EXISTS `sectiontbl`;

CREATE TABLE `sectiontbl` (
  `sectionId` int(100) NOT NULL AUTO_INCREMENT,
  `sectionName` varchar(50) DEFAULT NULL,
  `sectionDesc` varchar(100) DEFAULT NULL,
  `classId` int(100) DEFAULT NULL,
  `sectionStartDate` date DEFAULT NULL,
  `dateCreated` date DEFAULT NULL,
  `acChargres` int(100) DEFAULT NULL,
  `registrationFee` int(100) DEFAULT NULL,
  `monthlyFee` int(100) DEFAULT NULL,
  `sectionFee` int(100) DEFAULT NULL,
  `sectionDeleted` tinyint(1) DEFAULT NULL,
  `totalSeats` int(100) DEFAULT NULL,
  PRIMARY KEY (`sectionId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

/*Data for the table `sectiontbl` */

insert  into `sectiontbl`(`sectionId`,`sectionName`,`sectionDesc`,`classId`,`sectionStartDate`,`dateCreated`,`acChargres`,`registrationFee`,`monthlyFee`,`sectionFee`,`sectionDeleted`,`totalSeats`) values (1,'1st June2016','',1,'2016-05-23','2016-05-23',0,2000,7500,0,0,50),(2,'1st May 2016','1st May 2016',2,'2016-05-16','2016-05-23',0,0,0,33600,0,NULL),(3,'Section B','23 May 2016',2,'2016-05-25','2016-05-24',0,0,0,33600,1,NULL),(4,'5th June 2016','5th June 2016',7,'2016-06-05','0000-00-00',0,0,0,36000,0,50),(5,'2nd May 2016','2nd May 2016',2,'2016-05-02','2016-05-24',0,0,0,33600,0,50),(6,'11 May 2016','11 May 2016',10,'2016-05-11','2016-05-25',0,0,0,33600,0,30);

/*Table structure for table `shifttbl` */

DROP TABLE IF EXISTS `shifttbl`;

CREATE TABLE `shifttbl` (
  `shiftId` int(100) NOT NULL AUTO_INCREMENT,
  `shiftName` varchar(200) DEFAULT NULL,
  `shiftDesc` varchar(200) DEFAULT NULL,
  `dateCreated` date DEFAULT NULL,
  `shiftDeleted` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`shiftId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `shifttbl` */

insert  into `shifttbl`(`shiftId`,`shiftName`,`shiftDesc`,`dateCreated`,`shiftDeleted`) values (1,'Evening 2pm-6pm','Evening 2pm-6pm','0000-00-00',0),(2,'Morning 7am-12pm','Morning 7am-12pm','0000-00-00',0),(3,'Evening(7pm-12am)','Evening(7pm-12am)','0000-00-00',1),(4,'free ki shift','free ki shift','2016-05-24',1);

/*Table structure for table `studenteduinfotbl` */

DROP TABLE IF EXISTS `studenteduinfotbl`;

CREATE TABLE `studenteduinfotbl` (
  `stEduinfoId` int(100) NOT NULL AUTO_INCREMENT,
  `studentId` int(100) DEFAULT NULL,
  `instituteName` varchar(100) DEFAULT NULL,
  `classId` int(100) DEFAULT NULL,
  `passyear` varchar(10) DEFAULT NULL,
  `eduBorad` varchar(50) DEFAULT NULL,
  `eduRollNo` varchar(50) DEFAULT NULL,
  `totalMarks` varchar(50) DEFAULT NULL,
  `obtainedmarks` varchar(50) DEFAULT NULL,
  `studentEduInfoDate` date DEFAULT NULL,
  PRIMARY KEY (`stEduinfoId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `studenteduinfotbl` */

insert  into `studenteduinfotbl`(`stEduinfoId`,`studentId`,`instituteName`,`classId`,`passyear`,`eduBorad`,`eduRollNo`,`totalMarks`,`obtainedmarks`,`studentEduInfoDate`) values (1,4,'Sindh',1,'2011','sindh university','142','1100','835','0000-00-00'),(2,4,'Sindh',0,'2011','sindh university','142','1100','835','0000-00-00');

/*Table structure for table `studentotherinfotbl` */

DROP TABLE IF EXISTS `studentotherinfotbl`;

CREATE TABLE `studentotherinfotbl` (
  `studentInfoId` int(100) NOT NULL AUTO_INCREMENT,
  `studentId` int(100) DEFAULT NULL,
  `fatherName` varchar(100) DEFAULT NULL,
  `nationality` varchar(50) DEFAULT NULL,
  `perminentAddress` varchar(200) DEFAULT NULL,
  `tempAddress` varchar(200) DEFAULT NULL,
  `phoneNo` varchar(50) DEFAULT NULL,
  `mobileNo` varchar(50) DEFAULT NULL,
  `studentEmail` varchar(100) DEFAULT NULL,
  `boarderDayScholar` varchar(15) DEFAULT NULL,
  `guardian` varchar(50) DEFAULT NULL,
  `guardianRelation` varchar(50) DEFAULT NULL,
  `guardianName` varchar(100) DEFAULT NULL,
  `guardianCNIC` varchar(50) DEFAULT NULL,
  `guardianContact` varchar(50) DEFAULT NULL,
  `guardianCell` varchar(50) DEFAULT NULL,
  `guardianEmail` varchar(50) DEFAULT NULL,
  `studentDob` date DEFAULT NULL,
  `studentOtherInfoCreated` date DEFAULT NULL,
  PRIMARY KEY (`studentInfoId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `studentotherinfotbl` */

insert  into `studentotherinfotbl`(`studentInfoId`,`studentId`,`fatherName`,`nationality`,`perminentAddress`,`tempAddress`,`phoneNo`,`mobileNo`,`studentEmail`,`boarderDayScholar`,`guardian`,`guardianRelation`,`guardianName`,`guardianCNIC`,`guardianContact`,`guardianCell`,`guardianEmail`,`studentDob`,`studentOtherInfoCreated`) values (1,4,'himath ali','Pakistani','Gambat','karachi','022222','03333','lakho','Boarder','Parent','Father','Himath Ali','455454454545','0222222','0333333','lakho','0000-00-00','0000-00-00'),(2,4,'himath ali','Pakistani','Gambat','karachi','022222','03333','lakho.110@gmail.com','Boarder','Parent','Father','Himath Ali','455454454545','0222222','0333333','lakho','0000-00-00','0000-00-00'),(3,4,'Mohammad Sachal','Pakistani','Gambat','karachi','022222','03333','lakho','Boarder','Parent','Father','','','','','','2016-07-13','0000-00-00');

/*Table structure for table `studentprogresstbl` */

DROP TABLE IF EXISTS `studentprogresstbl`;

CREATE TABLE `studentprogresstbl` (
  `progressRptId` int(100) NOT NULL AUTO_INCREMENT,
  `studentId` int(100) DEFAULT NULL,
  `subjectId` int(100) DEFAULT NULL,
  `totalMarks` varchar(100) DEFAULT NULL,
  `obtainedMarks` varchar(100) DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `testName` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`progressRptId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/*Data for the table `studentprogresstbl` */

insert  into `studentprogresstbl`(`progressRptId`,`studentId`,`subjectId`,`totalMarks`,`obtainedMarks`,`status`,`testName`) values (1,9,2,'100','80',0,'Test1'),(2,4,5,'100','75',NULL,'Test 1'),(3,0,7,'100','74',NULL,'Test 1'),(4,0,7,'100','74',NULL,'Test 1'),(5,4,8,'100','75',NULL,'Test 1');

/*Table structure for table `studenttbl` */

DROP TABLE IF EXISTS `studenttbl`;

CREATE TABLE `studenttbl` (
  `studentId` int(100) NOT NULL AUTO_INCREMENT,
  `studentFirstName` varchar(50) NOT NULL,
  `studentLastName` varchar(50) DEFAULT NULL,
  `studentFatherName` varchar(50) DEFAULT NULL,
  `studentEmail` varchar(50) DEFAULT NULL,
  `studentAddress` varchar(150) DEFAULT NULL,
  `board` varchar(50) DEFAULT NULL,
  `imageName` varchar(100) DEFAULT NULL,
  `studentRollNo` int(100) DEFAULT '0',
  `classId` int(100) DEFAULT NULL,
  `shiftId` int(100) DEFAULT NULL,
  `sectionId` int(100) DEFAULT NULL,
  `dateCreated` date DEFAULT NULL,
  `studentRemarks` varchar(200) DEFAULT NULL,
  `studentDeleted` tinyint(1) DEFAULT NULL,
  `studentCreatedby` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`studentId`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

/*Data for the table `studenttbl` */

insert  into `studenttbl`(`studentId`,`studentFirstName`,`studentLastName`,`studentFatherName`,`studentEmail`,`studentAddress`,`board`,`imageName`,`studentRollNo`,`classId`,`shiftId`,`sectionId`,`dateCreated`,`studentRemarks`,`studentDeleted`,`studentCreatedby`) values (1,'gfgfffgf','','','',',medical','','E:\\apache-tomcat-8.0.30\\tmpFiles\\gfgfffgf.png',1,2,1,2,'2016-05-23','ok report',0,'inayat'),(2,'inayat ali','','','','','Federal','E:\\apache-tomcat-8.0.30\\tmpFiles\\inayat ali.png',1,6,2,1,'2016-05-23','ok report',0,'inayat'),(3,'dildar','','','',',medical','','E:\\apache-tomcat-8.0.30\\tmpFiles\\dildar.png',2,2,1,2,'2016-05-24','ok report',0,'inayat'),(4,'akhtair ali','','','','','Federal','E:\\apache-tomcat-8.0.30\\tmpFiles\\akhtair ali.png',2,1,2,1,'2016-05-24','ok report',0,'inayat'),(5,'inayat ali','','','',',medical','','E:\\apache-tomcat-8.0.30\\tmpFiles\\inayat ali.png',3,7,2,4,'2016-05-24','ok report',0,'inayat'),(6,'Minhaj','','','','','Federal','E:\\apache-tomcat-8.0.30\\tmpFiles\\Minhaj.png',3,6,1,1,'2016-05-24','ok report',0,'inayat'),(7,'inayat ali','','','',',3','','E:\\apache-tomcat-8.0.30\\tmpFiles\\inayat ali.png',1,10,2,6,'2016-05-25','ok report',0,'inayat'),(8,'inayat','','','',',3','','E:\\apache-tomcat-8.0.30\\tmpFiles\\inayat.png',2,10,0,6,'2016-05-25','ok report',0,'inayat'),(9,'inayat','','','',',3','','E:\\apache-tomcat-8.0.30\\tmpFiles\\inayat.png',3,10,1,6,'2016-05-26','1000 remaining',0,'inayat');

/*Table structure for table `subjectstbl` */

DROP TABLE IF EXISTS `subjectstbl`;

CREATE TABLE `subjectstbl` (
  `subjectId` int(100) NOT NULL AUTO_INCREMENT,
  `subjectName` varchar(100) DEFAULT NULL,
  `createdDate` date DEFAULT NULL,
  PRIMARY KEY (`subjectId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

/*Data for the table `subjectstbl` */

insert  into `subjectstbl`(`subjectId`,`subjectName`,`createdDate`) values (1,'Chemistry','0000-00-00'),(2,'Biology','0000-00-00'),(3,'Physics','0000-00-00'),(4,'Maths','0000-00-00'),(5,'English','0000-00-00'),(6,'Pak studies','0000-00-00'),(7,'Islamiyat','0000-00-00'),(8,'Urdu','0000-00-00');

/*Table structure for table `user_roles` */

DROP TABLE IF EXISTS `user_roles`;

CREATE TABLE `user_roles` (
  `user_role_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `role` varchar(45) NOT NULL,
  PRIMARY KEY (`user_role_id`),
  UNIQUE KEY `uni_username_role` (`role`,`username`),
  KEY `fk_username_idx` (`username`),
  CONSTRAINT `fk_username` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `user_roles` */

insert  into `user_roles`(`user_role_id`,`username`,`role`) values (3,'lakho','Deo_Role'),(1,'torcia','Information_Role'),(2,'mkyong','ROLE_ADMIN'),(4,'super','ROLE_ADMIN');

/*Table structure for table `userroletbl` */

DROP TABLE IF EXISTS `userroletbl`;

CREATE TABLE `userroletbl` (
  `roleId` int(50) NOT NULL AUTO_INCREMENT,
  `roleName` varchar(100) DEFAULT NULL,
  `roleDesc` varchar(100) DEFAULT NULL,
  `adminId` int(50) DEFAULT NULL,
  `roleCreated` date DEFAULT NULL,
  PRIMARY KEY (`roleId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `userroletbl` */

insert  into `userroletbl`(`roleId`,`roleName`,`roleDesc`,`adminId`,`roleCreated`) values (1,'adminRole','adminRole',1,'0000-00-00'),(2,'informationRole','informationRole',2,'0000-00-00'),(3,'DEORole','DEORole',NULL,'0000-00-00'),(4,'Accountant Role','Accountant Role',3,'0000-00-00');

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `enabled` tinyint(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `users` */

insert  into `users`(`username`,`password`,`enabled`) values ('alex','123456',1),('lakho','lakho',1),('mkyong','123456',1),('super','super',1),('torcia','torcia',1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
