-- MySQL dump 10.13  Distrib 5.7.26, for Linux (x86_64)
--
-- Host: localhost    Database: ShareMyOffer
-- ------------------------------------------------------
-- Server version	5.7.26-0ubuntu0.18.10.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Address`
--

DROP TABLE IF EXISTS `Address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Address` (
  `Id` int(6) NOT NULL,
  `HouseNumber` varchar(50) NOT NULL,
  `LandMark` varchar(50) DEFAULT NULL,
  `Street` varchar(50) NOT NULL,
  `City` varchar(50) NOT NULL,
  `State` varchar(50) NOT NULL,
  `Country` varchar(50) NOT NULL,
  `Pincode` int(6) NOT NULL,
  `Latitude` decimal(10,8) NOT NULL,
  `Longitude` decimal(11,8) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Address`
--

LOCK TABLES `Address` WRITE;
/*!40000 ALTER TABLE `Address` DISABLE KEYS */;
INSERT INTO `Address` VALUES (1,'12-1-449/2','Near Shivalayam','Lalapet','Secunderabad','Telangana','India',500017,12.34500000,32.56400000),(2,'12-1-449/2','Near Shivalayam','Lalapet','Secunderabad','Telangana','India',500017,12.34500000,32.56400000);
/*!40000 ALTER TABLE `Address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Offer`
--

DROP TABLE IF EXISTS `Offer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Offer` (
  `Id` int(6) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Description` varchar(100) NOT NULL,
  `Date` date NOT NULL,
  `AddressId` int(6) NOT NULL,
  `UserId` int(6) NOT NULL,
  `Status` varchar(10) NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `UserId` (`UserId`),
  KEY `AddressId` (`AddressId`),
  CONSTRAINT `Offer_ibfk_1` FOREIGN KEY (`UserId`) REFERENCES `User` (`Id`),
  CONSTRAINT `Offer_ibfk_2` FOREIGN KEY (`AddressId`) REFERENCES `Address` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Offer`
--

LOCK TABLES `Offer` WRITE;
/*!40000 ALTER TABLE `Offer` DISABLE KEYS */;
INSERT INTO `Offer` VALUES (1,'Sale','offer','2020-04-20',1,1,'Active');
/*!40000 ALTER TABLE `Offer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `User`
--

DROP TABLE IF EXISTS `User`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `User` (
  `Id` int(6) NOT NULL,
  `FirstName` varchar(50) NOT NULL,
  `LastName` varchar(50) NOT NULL,
  `DateOfBirth` date NOT NULL,
  `MobileNumber` varchar(10) DEFAULT NULL,
  `EmailId` varchar(60) DEFAULT NULL,
  `AddressId` int(6) DEFAULT NULL,
  `Rating` int(1) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `MobileNumber` (`MobileNumber`),
  UNIQUE KEY `EmailId` (`EmailId`),
  UNIQUE KEY `EmailId_2` (`EmailId`),
  UNIQUE KEY `AddressId` (`AddressId`),
  CONSTRAINT `User_ibfk_1` FOREIGN KEY (`AddressId`) REFERENCES `Address` (`Id`),
  CONSTRAINT `User_ibfk_2` FOREIGN KEY (`AddressId`) REFERENCES `Address` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `User`
--

LOCK TABLES `User` WRITE;
/*!40000 ALTER TABLE `User` DISABLE KEYS */;
INSERT INTO `User` VALUES (1,'Vangaru','Shanmukha','1999-06-22','7013450458','vangarushanmukha@gmail.com',1,3),(2,'Shashank','Balabadra','1999-06-22','7013450459','vangarushanmukha12@gmail.com',2,3);
/*!40000 ALTER TABLE `User` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `User_Offer`
--

DROP TABLE IF EXISTS `User_Offer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `User_Offer` (
  `UserId` int(6) NOT NULL,
  `OfferId` int(6) NOT NULL,
  `Status` varchar(10) NOT NULL,
  `Id` int(6) NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `UserId` (`UserId`),
  KEY `OfferId` (`OfferId`),
  CONSTRAINT `User_Offer_ibfk_1` FOREIGN KEY (`UserId`) REFERENCES `User` (`Id`),
  CONSTRAINT `User_Offer_ibfk_2` FOREIGN KEY (`OfferId`) REFERENCES `Offer` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `User_Offer`
--

LOCK TABLES `User_Offer` WRITE;
/*!40000 ALTER TABLE `User_Offer` DISABLE KEYS */;
INSERT INTO `User_Offer` VALUES (2,1,'Accepted',1);
/*!40000 ALTER TABLE `User_Offer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `login` (
  `username` varchar(10) NOT NULL,
  `password` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES ('7013450458','$2a$10$I9x4UDEMKRR9oMl5EStVIO1WYmpsHVWYscemqFYIh3KBL4/Jr1NIS');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login_roles`
--

DROP TABLE IF EXISTS `login_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `login_roles` (
  `username` varchar(10) NOT NULL,
  `role_id` int(2) NOT NULL,
  PRIMARY KEY (`username`,`role_id`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `login_roles_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `role` (`Id`),
  CONSTRAINT `login_roles_ibfk_3` FOREIGN KEY (`username`) REFERENCES `login` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login_roles`
--

LOCK TABLES `login_roles` WRITE;
/*!40000 ALTER TABLE `login_roles` DISABLE KEYS */;
INSERT INTO `login_roles` VALUES ('7013450458',1);
/*!40000 ALTER TABLE `login_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `Id` int(2) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ROLE_USER');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-04-20 10:16:52
