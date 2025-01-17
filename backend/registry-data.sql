USE `employees_registry`;
-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: localhost    Database: employees_registry
-- ------------------------------------------------------
-- Server version	5.7.30-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Dumping data for table `company`
--

LOCK TABLES `company` WRITE;
/*!40000 ALTER TABLE `company` DISABLE KEYS */;
INSERT INTO `company` VALUES (1,'Future-Tech S.A.',666000.00);
/*!40000 ALTER TABLE `company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES (1,'IT','TECHNOLOGY',1),(2,'Pre-Sales','FINANCE',1),(3,'HR','MANAGEMENT',1),(4,'Supply','FOLLOW_UP',1);
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'KIFISIAS 1, 158 49','Kwstas','2004-04-12 11:04:03.713850','Pappas','2018-05-18 15:46:12.658956','$10$sGaGgslPJUVlA5YhyA06wu./SIBP.7ROKdfmyiNd6/8S06QbBNYaa','6900000000','Senior Developer','Kwstas123',1),(2,'SMYRNIS 189, 145 49','Panagiotis','2000-01-01 00:00:00.000000','Kotsolis',NULL,'$10$sGaGgslPJUVlA5YhyA06wu./SIBP.7ROKdfmyiNd6/8S06QbBNYaa$10$sGaGgslPJUVlA5YhyA06wu./SIBP.7ROKdfmyiNd6/8S06QbBNYaa','6900000000','Junior Developer','Panagiotis123',1),(3,'MESOGIWN 5, 131 88','Aleksandros','2018-05-18 12:46:12.658956','Polikarpos','2020-05-28 09:16:43.897568','$10$sGaGgslPJUVlA5YhyA06wu./SIBP.7ROKdfmyiNd6/8S06QbBNYaa','6900000000','Junior Developer','Aleksandros123',1),(4,'HPEIROU 24, 175 49','Manwlis','2010-10-05 14:00:02.563256','Manolopoulos',NULL,'$10$sGaGgslPJUVlA5YhyA06wu./SIBP.7ROKdfmyiNd6/8S06QbBNYaa','6900000000','Solution Architect','Manwlis123',2),(5,'FILOLAOU 67, 116 22','Stelios','2020-05-28 09:16:43.897568','Karadimas',NULL,'$10$sGaGgslPJUVlA5YhyA06wu./SIBP.7ROKdfmyiNd6/8S06QbBNYaa','6900000000','Enterprise Architect','Stelios123',2),(22,'HPEIROU 24, 175 49','someone','2020-09-26 21:04:27.255000','someoneL',NULL,'$2a$10$sGaGgslPJUVlA5YhyA06wu./SIBP.7ROKdfmyiNd6/8S06QbBNYaa','6900000000','Solution Architect','tester',1),(23,'FILOLAOU 67, 116 22','Aleksandra','2020-05-28 09:16:43.897568','Papadopoulou',NULL,'$10$sGaGgslPJUVlA5YhyA06wu./SIBP.7ROKdfmyiNd6/8S06QbBNYaa','6900000000','Recruiter','aldra80',3),(24,'KIFISIAS 1, 158 49','Antonia','2010-10-05 14:00:02.563256','Dourou',NULL,'$10$sGaGgslPJUVlA5YhyA06wu./SIBP.7ROKdfmyiNd6/8S06QbBNYaa','6900000000','Supply-Chain Manager','doura',4);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-09-27  1:44:49
