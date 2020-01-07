-- MySQL dump 10.13  Distrib 5.5.62, for Win64 (AMD64)
--
-- Host: localhost    Database: biblioUNLP
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.19-MariaDB

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
-- Table structure for table `autor`
--

DROP TABLE IF EXISTS `autor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `autor` (
  `autor_id` int(11) NOT NULL,
  `eliminado` bit(1) NOT NULL,
  `nombre_ape` varchar(255) NOT NULL,
  `pais_de_nacimiento` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`autor_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `autor`
--

LOCK TABLES `autor` WRITE;
/*!40000 ALTER TABLE `autor` DISABLE KEYS */;
/*!40000 ALTER TABLE `autor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `editorial`
--

DROP TABLE IF EXISTS `editorial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `editorial` (
  `editorial_id` int(11) NOT NULL,
  `eliminado` bit(1) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `pais` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`editorial_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `editorial`
--

LOCK TABLES `editorial` WRITE;
/*!40000 ALTER TABLE `editorial` DISABLE KEYS */;
/*!40000 ALTER TABLE `editorial` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (241),(241),(241),(241),(241),(241),(241);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `libro`
--

DROP TABLE IF EXISTS `libro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `libro` (
  `id` int(11) NOT NULL,
  `copia` int(11) DEFAULT NULL,
  `eliminado` bit(1) NOT NULL,
  `estado` int(11) DEFAULT NULL,
  `genero` varchar(255) DEFAULT NULL,
  `isbn` varchar(255) NOT NULL,
  `resenia` varchar(255) DEFAULT NULL,
  `titulo` varchar(255) NOT NULL,
  `autor_autor_id` int(11) DEFAULT NULL,
  `editorial_editorial_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKboa3g5foytkt2v941scluoldp` (`autor_autor_id`),
  KEY `FKfhrc808l45s6mkbs6swm1rojx` (`editorial_editorial_id`),
  CONSTRAINT `FKboa3g5foytkt2v941scluoldp` FOREIGN KEY (`autor_autor_id`) REFERENCES `autor` (`autor_id`),
  CONSTRAINT `FKfhrc808l45s6mkbs6swm1rojx` FOREIGN KEY (`editorial_editorial_id`) REFERENCES `editorial` (`editorial_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `libro`
--

LOCK TABLES `libro` WRITE;
/*!40000 ALTER TABLE `libro` DISABLE KEYS */;
/*!40000 ALTER TABLE `libro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prestamo`
--

DROP TABLE IF EXISTS `prestamo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `prestamo` (
  `prestamo_id` int(11) NOT NULL,
  `estado` int(11) DEFAULT NULL,
  `fecha_fin` datetime NOT NULL,
  `fecha_inicio` datetime NOT NULL,
  `libro_id` int(11) DEFAULT NULL,
  `socio_socio_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`prestamo_id`),
  KEY `FKk7uwwn2ov4su2plcn1jh4dbi0` (`libro_id`),
  KEY `FK2msnfh32pr04f0sbpegeuon01` (`socio_socio_id`),
  CONSTRAINT `FK2msnfh32pr04f0sbpegeuon01` FOREIGN KEY (`socio_socio_id`) REFERENCES `socio` (`socio_id`),
  CONSTRAINT `FKk7uwwn2ov4su2plcn1jh4dbi0` FOREIGN KEY (`libro_id`) REFERENCES `libro` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prestamo`
--

LOCK TABLES `prestamo` WRITE;
/*!40000 ALTER TABLE `prestamo` DISABLE KEYS */;
/*!40000 ALTER TABLE `prestamo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reserva`
--

DROP TABLE IF EXISTS `reserva`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reserva` (
  `reserva_id` int(11) NOT NULL,
  `estado` int(11) DEFAULT NULL,
  `fecha_generacion` datetime NOT NULL,
  `libro_id` int(11) NOT NULL,
  `socio_socio_id` int(11) NOT NULL,
  PRIMARY KEY (`reserva_id`),
  KEY `FKrdf90l0yn62m5swr152un9rmj` (`libro_id`),
  KEY `FK6bu62ol7v0rnjrfjx3yyowcgr` (`socio_socio_id`),
  CONSTRAINT `FK6bu62ol7v0rnjrfjx3yyowcgr` FOREIGN KEY (`socio_socio_id`) REFERENCES `socio` (`socio_id`),
  CONSTRAINT `FKrdf90l0yn62m5swr152un9rmj` FOREIGN KEY (`libro_id`) REFERENCES `libro` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reserva`
--

LOCK TABLES `reserva` WRITE;
/*!40000 ALTER TABLE `reserva` DISABLE KEYS */;
/*!40000 ALTER TABLE `reserva` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sancion`
--

DROP TABLE IF EXISTS `sancion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sancion` (
  `sancion_id` int(11) NOT NULL,
  `estado` int(11) DEFAULT NULL,
  `fecha_fin` datetime NOT NULL,
  `fecha_inicio` datetime NOT NULL,
  `prestamo_prestamo_id` int(11) NOT NULL,
  `socio_socio_id` int(11) NOT NULL,
  PRIMARY KEY (`sancion_id`),
  KEY `FKnko990ec1da96c5s3k9h023l4` (`prestamo_prestamo_id`),
  KEY `FKrkuicy7xm73056jyudlo8pij0` (`socio_socio_id`),
  CONSTRAINT `FKnko990ec1da96c5s3k9h023l4` FOREIGN KEY (`prestamo_prestamo_id`) REFERENCES `prestamo` (`prestamo_id`),
  CONSTRAINT `FKrkuicy7xm73056jyudlo8pij0` FOREIGN KEY (`socio_socio_id`) REFERENCES `socio` (`socio_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sancion`
--

LOCK TABLES `sancion` WRITE;
/*!40000 ALTER TABLE `sancion` DISABLE KEYS */;
/*!40000 ALTER TABLE `sancion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `socio`
--

DROP TABLE IF EXISTS `socio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `socio` (
  `socio_id` int(11) NOT NULL,
  `estado` int(11) DEFAULT NULL,
  `nombre_ape` varchar(255) NOT NULL,
  PRIMARY KEY (`socio_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `socio`
--

LOCK TABLES `socio` WRITE;
/*!40000 ALTER TABLE `socio` DISABLE KEYS */;
/*!40000 ALTER TABLE `socio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'biblioUNLP'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-01-07 18:29:37
