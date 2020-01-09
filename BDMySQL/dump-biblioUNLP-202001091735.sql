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
INSERT INTO `autor` VALUES (1,'\0','JRR Tolkien','Reino Unido'),(2,'\0','Stephen King','Estados Unidos'),(3,'\0','Jorge Luis Borges','Argentina'),(4,'\0','Santiago Posteguillo','España'),(5,'\0','Dan Brown','Estados Unidos'),(6,'\0','Felipe Pigna','Argentina');
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
INSERT INTO `editorial` VALUES (1,'\0','Minotauro','Argentina'),(2,'\0','Ediciones B','Argentina'),(3,'\0','La Flor','Argentina');
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
INSERT INTO `hibernate_sequence` VALUES (7);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `libro`
--

DROP TABLE IF EXISTS `libro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `libro` (
  `libro_id` int(11) NOT NULL,
  `copia` int(11) DEFAULT NULL,
  `eliminado` bit(1) NOT NULL,
  `estado` int(11) DEFAULT NULL,
  `genero` varchar(255) DEFAULT NULL,
  `isbn` varchar(255) NOT NULL,
  `resenia` varchar(255) DEFAULT NULL,
  `titulo` varchar(255) NOT NULL,
  `autor_autor_id` int(11) DEFAULT NULL,
  `editorial_editorial_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`libro_id`),
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
INSERT INTO `libro` VALUES (1,1,'\0',0,'Fantasía','9788373191723','Un Hobbit aventurero trata de destruir un anillo para salvar el mundo','El señor de los anillos: La comunidad del anillo',1,1),(2,1,'\0',0,'Fantasía','9780044406792','Un Hobbit aventurero trata de destruir un anillo para salvar el mundo - segunda parte','El señor de los anillos: Las dos torres',1,1),(3,1,'\0',0,'Fantasía','9780044406792','Un Hobbit aventurero trata de destruir un anillo para salvar el mundo - tercera parte','El señor de los anillos: El Retorno del Rey',1,1),(4,1,'\0',0,'Terror','9789851807822','Un ser asesino aterroriza el pueblo de Derry','IT',2,2),(5,1,'\0',0,'Terror','9789024531837','Un espiritu maligno acecha a un escritor deprimido','Un saco de huesos',2,2),(6,1,'\0',1,'Fantasía','9780606385220','Un maestro de escuela viaja en el tiempo para eviar el asesinato de Kennedy','22-11-63',2,2),(7,1,'\0',0,'Fantasía','9780743591676','Un preso condenado a muerte ayuda a las personas de manera inesperada','El pasillo de la muerte',2,2),(8,1,'\0',0,'Fantasía','9789584203212','Recopilación de los mejores cuentos de Borges','El Aleph',3,3),(9,1,'\0',2,'Novela Histórica','9788868368821','Vida de Plubio Cornelio Escipión, uno de los mejores generales romanos','Africanus - El hijo del Cónsul',4,2),(10,1,'\0',0,'Novela Histórica','9788466645485','Vida de Plubio Cornelio Escipión, segunda parte','Las Legiones malditas',4,2),(11,1,'\0',0,'Novela Histórica','9788498729696','Vida de Plubio Cornelio Escipión, tercera parte','Las traición de Roma',4,2),(12,2,'\0',0,'Fantasía','9788373191723','Un Hobbit aventurero trata de destruir un anillo para salvar el mundo','El señor de los anillos: La comunidad del anillo',1,1),(13,2,'\0',0,'Fantasía','9780044406792','Un Hobbit aventurero trata de destruir un anillo para salvar el mundo - segunda parte','El señor de los anillos: Las dos torres',1,1),(14,2,'\0',2,'Fantasía','9780044406792','Un Hobbit aventurero trata de destruir un anillo para salvar el mundo - tercera parte','El señor de los anillos: El Retorno del Rey',1,1),(15,2,'\0',0,'Terror','9789851807822','Un ser asesino aterroriza el pueblo de Derry','IT',2,2),(16,2,'\0',1,'Terror','9789024531837','Un espiritu maligno acecha a un escritor deprimido','Un saco de huesos',2,2),(17,2,'\0',0,'Fantasía','9780606385220','Un maestro de escuela viaja en el tiempo para eviar el asesinato de Kennedy','22-11-63',2,2),(18,2,'\0',0,'Fantasía','9780743591676','Un preso condenado a muerte ayuda a las personas de manera inesperada','El pasillo de la muerte',2,2),(19,2,'\0',0,'Fantasía','9789584203212','Recopilación de los mejores cuentos de Borges','El Aleph',3,3),(20,2,'\0',0,'Novela Histórica','9788868368821','Vida de Plubio Cornelio Escipión, uno de los mejores generales romanos','Africanus - El hijo del Cónsul',4,2),(21,2,'\0',0,'Novela Histórica','9788466645485','Vida de Plubio Cornelio Escipión, segunda parte','Las Legiones malditas',4,2),(22,2,'\0',1,'Novela Histórica','9788498729696','Vida de Plubio Cornelio Escipión, tercera parte','Las traición de Roma',4,2),(23,3,'\0',0,'Fantasía','9788373191723','Un Hobbit aventurero trata de destruir un anillo para salvar el mundo','El señor de los anillos: La comunidad del anillo',1,1),(24,3,'\0',0,'Fantasía','9780044406792','Un Hobbit aventurero trata de destruir un anillo para salvar el mundo - segunda parte','El señor de los anillos: Las dos torres',1,1),(25,3,'\0',0,'Fantasía','9780044406792','Un Hobbit aventurero trata de destruir un anillo para salvar el mundo - tercera parte','El señor de los anillos: El Retorno del Rey',1,1),(26,3,'\0',1,'Terror','9789851807822','Un ser asesino aterroriza el pueblo de Derry','IT',2,2),(27,3,'\0',0,'Terror','9789024531837','Un espiritu maligno acecha a un escritor deprimido','Un saco de huesos',2,2),(28,3,'\0',2,'Fantasía','9780606385220','Un maestro de escuela viaja en el tiempo para eviar el asesinato de Kennedy','22-11-63',2,2),(29,3,'\0',1,'Fantasía','9780743591676','Un preso condenado a muerte ayuda a las personas de manera inesperada','El pasillo de la muerte',2,2),(30,3,'\0',0,'Fantasía','9789584203212','Recopilación de los mejores cuentos de Borges','El Aleph',3,3),(31,3,'\0',2,'Novela Histórica','9788868368821','Vida de Plubio Cornelio Escipión, uno de los mejores generales romanos','Africanus - El hijo del Cónsul',4,2),(32,3,'\0',0,'Novela Histórica','9788466645485','Vida de Plubio Cornelio Escipión, segunda parte','Las Legiones malditas',4,2),(33,3,'\0',0,'Novela Histórica','9788498729696','Vida de Plubio Cornelio Escipión, tercera parte','Las traición de Roma',4,2),(34,1,'\0',0,'Novela','9780525565857','Un profesor de simbología debe demostrar su inocencia por un asesinato','El código Da Vinci',5,2),(35,2,'\0',0,'Novela','9780525565857','Un profesor de simbología debe demostrar su inocencia por un asesinato','El código Da Vinci',5,2),(36,1,'\0',0,'Novela','9780525563357','Un profesor de simbología debe impedir un atentado','Inferno',5,2),(37,1,'\0',0,'Historia','9789875809475','Primer entrega de la saga de historia argentina','Los mitos de la historia argentina I',6,2),(38,1,'\0',0,'Historia','9789875809235','Segunda entrega de la saga de historia argentina','Los mitos de la historia argentina II',6,2),(39,2,'\0',0,'Historia','9789875809235','Segunda entrega de la saga de historia argentina','Los mitos de la historia argentina II',6,2);
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
  `libro_libro_id` int(11) NOT NULL,
  `reserva_reserva_id` int(11) DEFAULT NULL,
  `socio_socio_id` int(11) NOT NULL,
  PRIMARY KEY (`prestamo_id`),
  KEY `FK8c89k3t5vjuqnjxhqltxyoc6` (`libro_libro_id`),
  KEY `FKegirffclvxbp5s14soosfwbj` (`reserva_reserva_id`),
  KEY `FK2msnfh32pr04f0sbpegeuon01` (`socio_socio_id`),
  CONSTRAINT `FK2msnfh32pr04f0sbpegeuon01` FOREIGN KEY (`socio_socio_id`) REFERENCES `socio` (`socio_id`),
  CONSTRAINT `FK8c89k3t5vjuqnjxhqltxyoc6` FOREIGN KEY (`libro_libro_id`) REFERENCES `libro` (`libro_id`),
  CONSTRAINT `FKegirffclvxbp5s14soosfwbj` FOREIGN KEY (`reserva_reserva_id`) REFERENCES `reserva` (`reserva_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prestamo`
--

LOCK TABLES `prestamo` WRITE;
/*!40000 ALTER TABLE `prestamo` DISABLE KEYS */;
INSERT INTO `prestamo` VALUES (1,0,'2020-01-14 10:31:20','2020-01-09 10:31:20',9,NULL,4),(2,0,'2020-01-19 10:31:20','2020-01-09 10:31:20',31,NULL,3),(3,0,'2020-01-19 10:31:20','2020-01-09 10:31:20',28,NULL,2),(4,0,'2020-01-19 10:31:20','2020-01-09 10:31:20',14,4,3);
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
  `fecha_caducidad` datetime NOT NULL,
  `fecha_generacion` datetime NOT NULL,
  `libro_libro_id` int(11) NOT NULL,
  `socio_socio_id` int(11) NOT NULL,
  PRIMARY KEY (`reserva_id`),
  KEY `FK9iffp59mysl1767r70m95oxv3` (`libro_libro_id`),
  KEY `FK6bu62ol7v0rnjrfjx3yyowcgr` (`socio_socio_id`),
  CONSTRAINT `FK6bu62ol7v0rnjrfjx3yyowcgr` FOREIGN KEY (`socio_socio_id`) REFERENCES `socio` (`socio_id`),
  CONSTRAINT `FK9iffp59mysl1767r70m95oxv3` FOREIGN KEY (`libro_libro_id`) REFERENCES `libro` (`libro_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reserva`
--

LOCK TABLES `reserva` WRITE;
/*!40000 ALTER TABLE `reserva` DISABLE KEYS */;
INSERT INTO `reserva` VALUES (1,NULL,'2020-01-18 10:31:20','2020-01-08 10:31:20',22,2),(2,0,'2020-01-14 10:31:20','2020-01-14 10:31:20',16,1),(3,0,'2020-01-19 10:31:20','2020-01-19 10:31:20',26,3),(4,0,'2020-01-19 10:31:20','2020-01-19 10:31:20',14,3),(5,0,'2020-01-19 10:31:20','2020-01-19 10:31:20',6,2);
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
INSERT INTO `sancion` VALUES (1,0,'2020-01-19 10:31:20','2020-01-14 10:31:20',2,5);
/*!40000 ALTER TABLE `sancion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seq_autor`
--

DROP TABLE IF EXISTS `seq_autor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `seq_autor` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seq_autor`
--

LOCK TABLES `seq_autor` WRITE;
/*!40000 ALTER TABLE `seq_autor` DISABLE KEYS */;
INSERT INTO `seq_autor` VALUES (101);
/*!40000 ALTER TABLE `seq_autor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seq_editorial`
--

DROP TABLE IF EXISTS `seq_editorial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `seq_editorial` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seq_editorial`
--

LOCK TABLES `seq_editorial` WRITE;
/*!40000 ALTER TABLE `seq_editorial` DISABLE KEYS */;
INSERT INTO `seq_editorial` VALUES (101);
/*!40000 ALTER TABLE `seq_editorial` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seq_libro`
--

DROP TABLE IF EXISTS `seq_libro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `seq_libro` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seq_libro`
--

LOCK TABLES `seq_libro` WRITE;
/*!40000 ALTER TABLE `seq_libro` DISABLE KEYS */;
INSERT INTO `seq_libro` VALUES (101);
/*!40000 ALTER TABLE `seq_libro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seq_prestamo`
--

DROP TABLE IF EXISTS `seq_prestamo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `seq_prestamo` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seq_prestamo`
--

LOCK TABLES `seq_prestamo` WRITE;
/*!40000 ALTER TABLE `seq_prestamo` DISABLE KEYS */;
INSERT INTO `seq_prestamo` VALUES (101);
/*!40000 ALTER TABLE `seq_prestamo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seq_reserva`
--

DROP TABLE IF EXISTS `seq_reserva`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `seq_reserva` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seq_reserva`
--

LOCK TABLES `seq_reserva` WRITE;
/*!40000 ALTER TABLE `seq_reserva` DISABLE KEYS */;
INSERT INTO `seq_reserva` VALUES (101);
/*!40000 ALTER TABLE `seq_reserva` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seq_sancion`
--

DROP TABLE IF EXISTS `seq_sancion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `seq_sancion` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seq_sancion`
--

LOCK TABLES `seq_sancion` WRITE;
/*!40000 ALTER TABLE `seq_sancion` DISABLE KEYS */;
INSERT INTO `seq_sancion` VALUES (101);
/*!40000 ALTER TABLE `seq_sancion` ENABLE KEYS */;
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
INSERT INTO `socio` VALUES (1,1,'José Perez'),(2,1,'María Gomez'),(3,1,'Paola Ponce'),(4,1,'Manuel Moreno'),(5,1,'Marcos Domine'),(6,1,'Maria Aliquo');
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

-- Dump completed on 2020-01-09 17:35:58
