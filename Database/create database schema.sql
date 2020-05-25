-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: checkit
-- ------------------------------------------------------
-- Server version	8.0.17

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
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `email` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES ('101010@student.pwr.wroc.pl','$2a$10$zBV.Z8D6XtHZx0gD0w8apuGtaePCW4mt4uLd8yiiTUK9Tppkhipj6'),('110110@student.pwr.wroc.pl','$2a$10$zBV.Z8D6XtHZx0gD0w8apuGtaePCW4mt4uLd8yiiTUK9Tppkhipj6'),('111111@student.pwr.wroc.pl','$2a$10$zBV.Z8D6XtHZx0gD0w8apuGtaePCW4mt4uLd8yiiTUK9Tppkhipj6'),('220220@student.pwr.wroc.pl','$2a$10$zBV.Z8D6XtHZx0gD0w8apuGtaePCW4mt4uLd8yiiTUK9Tppkhipj6'),('222222@student.pwr.wroc.pl','$2a$10$zBV.Z8D6XtHZx0gD0w8apuGtaePCW4mt4uLd8yiiTUK9Tppkhipj6'),('333333@student.pwr.wroc.pl','$2a$10$zBV.Z8D6XtHZx0gD0w8apuGtaePCW4mt4uLd8yiiTUK9Tppkhipj6'),('777777@student.pwr.wroc.pl','$2a$10$zBV.Z8D6XtHZx0gD0w8apuGtaePCW4mt4uLd8yiiTUK9Tppkhipj6'),('888888@student.pwr.wroc.pl','$2a$10$zBV.Z8D6XtHZx0gD0w8apuGtaePCW4mt4uLd8yiiTUK9Tppkhipj6'),('999999@student.pwr.wroc.pl','$2a$10$zBV.Z8D6XtHZx0gD0w8apuGtaePCW4mt4uLd8yiiTUK9Tppkhipj6'),('adam.ksieniewicz@pwr.wroc.pl','$2a$10$zBV.Z8D6XtHZx0gD0w8apuGtaePCW4mt4uLd8yiiTUK9Tppkhipj6'),('ivan.romanov@pwr.wroc.pl','$2a$10$zBV.Z8D6XtHZx0gD0w8apuGtaePCW4mt4uLd8yiiTUK9Tppkhipj6'),('karol.krawczyk@pwr.wroc.pl','$2a$10$zBV.Z8D6XtHZx0gD0w8apuGtaePCW4mt4uLd8yiiTUK9Tppkhipj6');
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course` (
  `id` bigint(20) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `lecturer_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKtkf1pbf7lcb4a21m1rt361atd` (`lecturer_id`),
  CONSTRAINT `FKtkf1pbf7lcb4a21m1rt361atd` FOREIGN KEY (`lecturer_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES (1,'E05-10b','Social Communication',4),(2,'E08-59a','Computer Project Management',5),(3,'E08-70a','Research Skills and Methodologies',4),(4,'E08-63a','Information System Modeling',6),(5,'E03-86f','Discrete Mathematics',6),(6,'E08-60a','Elect. media in Busi.',5);
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_student`
--

DROP TABLE IF EXISTS `course_student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course_student` (
  `student_courses_id` bigint(20) NOT NULL,
  `users_id` bigint(20) NOT NULL,
  KEY `FKoco5mtkpm6dqxyjklk045kk9m` (`users_id`),
  KEY `FK939obvuivd94w0lmxsejliwhu` (`student_courses_id`),
  CONSTRAINT `FK939obvuivd94w0lmxsejliwhu` FOREIGN KEY (`student_courses_id`) REFERENCES `course` (`id`),
  CONSTRAINT `FKoco5mtkpm6dqxyjklk045kk9m` FOREIGN KEY (`users_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_student`
--

LOCK TABLES `course_student` WRITE;
/*!40000 ALTER TABLE `course_student` DISABLE KEYS */;
INSERT INTO `course_student` VALUES (1,1),(1,2),(1,3),(1,4),(1,6),(1,7),(1,8),(1,9),(1,10),(2,2),(2,1),(2,3),(2,4),(2,5),(2,6),(2,8),(2,9),(2,10),(2,12),(3,1),(3,5),(3,6),(3,2),(3,8),(3,9),(3,10),(3,11),(3,12),(4,2),(2,1),(2,3),(2,4),(2,5),(2,6),(2,8),(2,9),(2,10),(2,11),(2,12),(5,2),(2,1),(2,3),(2,4),(2,5),(2,6),(2,8),(2,9),(2,10),(2,11),(6,2),(2,1),(2,3),(2,4),(2,5),(2,6),(2,8);
/*!40000 ALTER TABLE `course_student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (1),(1),(1);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lecture`
--

DROP TABLE IF EXISTS `lecture`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lecture` (
  `id` bigint(20) NOT NULL,
  `date` datetime DEFAULT NULL,
  `duration` int(11) DEFAULT NULL,
  `course_id` bigint(20) DEFAULT NULL,
  `lecture_hall_id` bigint(20) DEFAULT NULL,
  `lecturer_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKjoc9yetfohpygdvx5wv385vwb` (`course_id`),
  KEY `FKahhma6vc3gu6cqlbr0r0lc0n1` (`lecture_hall_id`),
  KEY `FKe58oymai1ph23uqhb9uwxlb07` (`lecturer_id`),
  CONSTRAINT `FKahhma6vc3gu6cqlbr0r0lc0n1` FOREIGN KEY (`lecture_hall_id`) REFERENCES `lecture_hall` (`id`),
  CONSTRAINT `FKe58oymai1ph23uqhb9uwxlb07` FOREIGN KEY (`lecturer_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKjoc9yetfohpygdvx5wv385vwb` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lecture`
--

LOCK TABLES `lecture` WRITE;
/*!40000 ALTER TABLE `lecture` DISABLE KEYS */;
INSERT INTO `lecture` VALUES (1,'2020-05-13 07:30:00',105,1,1,4),(2,'2020-05-20 07:30:00',105,1,1,4),(3,'2020-05-27 07:30:00',105,1,1,4),(4,'2020-06-03 07:30:00',105,1,1,4),(5,'2020-06-10 07:30:00',105,1,1,4),(6,'2020-06-17 07:30:00',105,1,1,4),(7,'2020-05-11 09:00:00',105,2,1,4),(8,'2020-05-18 09:00:00',105,2,1,4),(9,'2020-05-25 09:00:00',105,2,1,4),(10,'2020-06-01 09:00:00',105,2,1,4),(11,'2020-06-08 09:00:00',105,2,1,4),(12,'2020-06-15 09:00:00',105,2,1,4),(13,'2020-05-13 13:00:00',165,6,1,4),(14,'2020-05-20 13:00:00',165,6,1,4),(15,'2020-05-27 13:00:00',165,6,1,4),(16,'2020-06-03 13:00:00',165,6,1,4),(17,'2020-06-10 13:00:00',165,6,1,4),(18,'2020-06-17 13:00:00',165,6,1,4),(19,'2020-06-24 13:00:00',165,6,1,4),(20,'2020-07-01 13:00:00',165,6,1,4),(21,'2020-05-13 09:15:00',105,3,1,4),(22,'2020-05-20 09:15:00',105,3,1,4),(23,'2020-05-27 09:15:00',105,3,1,4),(24,'2020-06-03 09:15:00',105,3,1,4),(25,'2020-06-10 09:15:00',105,3,1,4),(26,'2020-06-17 09:15:00',105,3,1,4),(27,'2020-07-24 09:15:00',105,3,1,4),(28,'2020-05-13 13:00:00',105,4,1,4),(29,'2020-05-20 13:00:00',105,4,1,4),(30,'2020-05-27 13:00:00',105,4,1,4),(31,'2020-06-03 13:00:00',105,4,1,4),(32,'2020-06-10 13:00:00',105,4,1,4),(33,'2020-06-17 13:00:00',105,4,1,4),(34,'2020-06-24 13:00:00',105,4,1,4),(35,'2020-05-08 16:00:00',210,5,1,4),(36,'2020-05-15 16:00:00',210,5,1,4),(37,'2020-05-22 16:00:00',210,5,1,4),(38,'2020-05-29 16:00:00',210,5,1,4),(39,'2020-06-05 16:00:00',210,5,1,4),(40,'2020-06-12 16:00:00',210,5,1,4),(41,'2020-06-19 16:00:00',210,5,1,4);
/*!40000 ALTER TABLE `lecture` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lecture_hall`
--

DROP TABLE IF EXISTS `lecture_hall`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lecture_hall` (
  `id` bigint(20) NOT NULL,
  `building` varchar(255) DEFAULT NULL,
  `room_number` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lecture_hall`
--

LOCK TABLES `lecture_hall` WRITE;
/*!40000 ALTER TABLE `lecture_hall` DISABLE KEYS */;
INSERT INTO `lecture_hall` VALUES (1,'C4','s239'),(2,'C4','s235'),(3,'C16','L2.4'),(4,'C16','P2.1'),(5,'C16','P2.4'),(6,'C13','0.31'),(7,'C13','1.12'),(8,'C13','1.27');
/*!40000 ALTER TABLE `lecture_hall` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'STUDENT'),(2,'LECTURER');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_lecture`
--

DROP TABLE IF EXISTS `student_lecture`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_lecture` (
  `lecture_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  PRIMARY KEY (`lecture_id`,`user_id`),
  KEY `FKf2i696anamb6r2n3hg6co06up` (`user_id`),
  CONSTRAINT `FKf2i696anamb6r2n3hg6co06up` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKl0fgyx5u34qg1mrv7kpu2bl9f` FOREIGN KEY (`lecture_id`) REFERENCES `lecture` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_lecture`
--

LOCK TABLES `student_lecture` WRITE;
/*!40000 ALTER TABLE `student_lecture` DISABLE KEYS */;
INSERT INTO `student_lecture` VALUES (1,1),(13,1),(23,1),(29,1),(30,1),(35,1),(1,2),(3,2),(14,2),(15,2),(21,2),(22,2),(23,2),(29,2),(36,2),(37,2),(38,2),(1,3),(3,3),(14,3),(28,3),(37,3),(1,4),(2,7),(13,7),(21,7),(22,7),(28,7),(30,7),(36,7),(37,7),(2,8),(15,8),(21,8),(35,8),(36,8),(38,8),(2,9),(22,9),(1,10),(2,10);
/*!40000 ALTER TABLE `student_lecture` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `logged` bit(1) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKn5c2617n6vglumrdq2ekeufub` (`email`),
  CONSTRAINT `FKn5c2617n6vglumrdq2ekeufub` FOREIGN KEY (`email`) REFERENCES `account` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Kamil','Brzycki',_binary '\0','111111@student.pwr.wroc.pl'),(2,'Tomcio','Paluch',_binary '\0','222222@student.pwr.wroc.pl'),(3,'Mateusz','Marciniak',_binary '\0','333333@student.pwr.wroc.pl'),(4,'Karol','Krawczyk',_binary '\0','karol.krawczyk@pwr.wroc.pl'),(5,'Adam','Ksieniewicz',_binary '\0','adam.ksieniewicz@pwr.wroc.pl'),(6,'Ivan','Romanov',_binary '\0','ivan.romanov@pwr.wroc.pl'),(7,'Erwin','Brzycki',_binary '\0','777777@student.pwr.wroc.pl'),(8,'Kazimierz','Wielki',_binary '\0','888888@student.pwr.wroc.pl'),(9,'Jadwiga','Nowak',_binary '\0','999999@student.pwr.wroc.pl'),(10,'Adam','Norek',_binary '\0','101010@student.pwr.wroc.pl'),(11,'Mariusz','Kaszka',_binary '\0','110110@student.pwr.wroc.pl'),(12,'Karolina','Matejko',_binary '\0','220220@student.pwr.wroc.pl');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_role` (
  `role_id` int(11) DEFAULT NULL,
  `user_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`),
  KEY `FKa68196081fvovjhkek5m97n3y` (`role_id`),
  CONSTRAINT `FK859n2jvi8ivhui0rl0esws6o` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKa68196081fvovjhkek5m97n3y` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,1),(1,2),(1,3),(1,7),(1,8),(1,9),(1,10),(1,11),(1,12),(2,4),(2,5),(2,6);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-25 21:48:29
