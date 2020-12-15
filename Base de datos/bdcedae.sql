-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: localhost    Database: cedae
-- ------------------------------------------------------
-- Server version	8.0.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8mb4 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `administradorsistemas`
--

DROP TABLE IF EXISTS `administradorsistemas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `administradorsistemas` (
  `idadmin` int(11) NOT NULL,
  `idempleado` int(11) DEFAULT NULL,
  PRIMARY KEY (`idadmin`),
  KEY `idempleado` (`idempleado`),
  CONSTRAINT `administradorsistemas_ibfk_1` FOREIGN KEY (`idempleado`) REFERENCES `empleado` (`idempleado`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administradorsistemas`
--

LOCK TABLES `administradorsistemas` WRITE;
/*!40000 ALTER TABLE `administradorsistemas` DISABLE KEYS */;
/*!40000 ALTER TABLE `administradorsistemas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `antecedentes`
--

DROP TABLE IF EXISTS `antecedentes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `antecedentes` (
  `idantecedentes` int(11) NOT NULL,
  `alergias` varchar(100) DEFAULT NULL,
  `antecedentesheredofamiliares` varchar(100) DEFAULT NULL,
  `antecedentespersonales` varchar(100) DEFAULT NULL,
  `padecimientoactual` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idantecedentes`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `antecedentes`
--

LOCK TABLES `antecedentes` WRITE;
/*!40000 ALTER TABLE `antecedentes` DISABLE KEYS */;
/*!40000 ALTER TABLE `antecedentes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cita`
--

DROP TABLE IF EXISTS `cita`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `cita` (
  `idcita` int(11) NOT NULL,
  `idpaciente` int(11) DEFAULT NULL,
  `idmedicoaux` int(11) DEFAULT NULL,
  `idmedicotitular` int(11) DEFAULT NULL,
  `idreceta` int(11) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `hora` time DEFAULT NULL,
  PRIMARY KEY (`idcita`),
  KEY `idpaciente` (`idpaciente`),
  KEY `idmedicoaux` (`idmedicoaux`),
  KEY `idmedicotitular` (`idmedicotitular`),
  KEY `idreceta` (`idreceta`),
  CONSTRAINT `cita_ibfk_1` FOREIGN KEY (`idpaciente`) REFERENCES `paciente` (`idPaciente`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `cita_ibfk_2` FOREIGN KEY (`idmedicoaux`) REFERENCES `medicoauxiliar` (`idmedicoaux`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `cita_ibfk_3` FOREIGN KEY (`idmedicotitular`) REFERENCES `medicotitular` (`idmedicotitular`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `cita_ibfk_4` FOREIGN KEY (`idreceta`) REFERENCES `receta` (`idreceta`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cita`
--

LOCK TABLES `cita` WRITE;
/*!40000 ALTER TABLE `cita` DISABLE KEYS */;
/*!40000 ALTER TABLE `cita` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleado`
--

DROP TABLE IF EXISTS `empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `empleado` (
  `idempleado` int(11) NOT NULL,
  `correo` varchar(30) DEFAULT NULL,
  `area` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`idempleado`),
  KEY `correo` (`correo`),
  CONSTRAINT `empleado_ibfk_1` FOREIGN KEY (`correo`) REFERENCES `persona` (`correo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleado`
--

LOCK TABLES `empleado` WRITE;
/*!40000 ALTER TABLE `empleado` DISABLE KEYS */;
/*!40000 ALTER TABLE `empleado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `encargadofarmacia`
--

DROP TABLE IF EXISTS `encargadofarmacia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `encargadofarmacia` (
  `idencargadofarmacia` int(11) NOT NULL,
  `idempleado` int(11) DEFAULT NULL,
  PRIMARY KEY (`idencargadofarmacia`),
  KEY `idempleado` (`idempleado`),
  CONSTRAINT `encargadofarmacia_ibfk_1` FOREIGN KEY (`idempleado`) REFERENCES `empleado` (`idempleado`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `encargadofarmacia`
--

LOCK TABLES `encargadofarmacia` WRITE;
/*!40000 ALTER TABLE `encargadofarmacia` DISABLE KEYS */;
/*!40000 ALTER TABLE `encargadofarmacia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `expediente`
--

DROP TABLE IF EXISTS `expediente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `expediente` (
  `idexpediente` int(11) NOT NULL,
  `idcita` int(11) DEFAULT NULL,
  `idpaciente` int(11) DEFAULT NULL,
  `peso` int(11) DEFAULT NULL,
  `estatura` int(11) DEFAULT NULL,
  `presionarterial` int(11) DEFAULT NULL,
  `frecuenciacardiaca` int(11) DEFAULT NULL,
  `frecuenciarespiratoria` int(11) DEFAULT NULL,
  `temperatura` int(11) DEFAULT NULL,
  `idantecedentes` int(11) DEFAULT NULL,
  PRIMARY KEY (`idexpediente`),
  KEY `idpaciente` (`idpaciente`),
  KEY `idcita` (`idcita`),
  KEY `idantecedentes` (`idantecedentes`),
  CONSTRAINT `expediente_ibfk_1` FOREIGN KEY (`idpaciente`) REFERENCES `paciente` (`idPaciente`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `expediente_ibfk_2` FOREIGN KEY (`idcita`) REFERENCES `cita` (`idcita`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `expediente_ibfk_3` FOREIGN KEY (`idantecedentes`) REFERENCES `antecedentes` (`idantecedentes`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expediente`
--

LOCK TABLES `expediente` WRITE;
/*!40000 ALTER TABLE `expediente` DISABLE KEYS */;
/*!40000 ALTER TABLE `expediente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medicoauxiliar`
--

DROP TABLE IF EXISTS `medicoauxiliar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `medicoauxiliar` (
  `idmedicoaux` int(11) NOT NULL,
  `cedula` int(11) DEFAULT NULL,
  `idempleado` int(11) DEFAULT NULL,
  PRIMARY KEY (`idmedicoaux`),
  KEY `idempleado` (`idempleado`),
  CONSTRAINT `medicoauxiliar_ibfk_1` FOREIGN KEY (`idempleado`) REFERENCES `empleado` (`idempleado`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicoauxiliar`
--

LOCK TABLES `medicoauxiliar` WRITE;
/*!40000 ALTER TABLE `medicoauxiliar` DISABLE KEYS */;
/*!40000 ALTER TABLE `medicoauxiliar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medicotitular`
--

DROP TABLE IF EXISTS `medicotitular`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `medicotitular` (
  `idmedicotitular` int(11) NOT NULL,
  `cedula` int(11) DEFAULT NULL,
  `idempleado` int(11) DEFAULT NULL,
  PRIMARY KEY (`idmedicotitular`),
  KEY `idempleado` (`idempleado`),
  CONSTRAINT `medicotitular_ibfk_1` FOREIGN KEY (`idempleado`) REFERENCES `empleado` (`idempleado`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicotitular`
--

LOCK TABLES `medicotitular` WRITE;
/*!40000 ALTER TABLE `medicotitular` DISABLE KEYS */;
/*!40000 ALTER TABLE `medicotitular` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paciente`
--

DROP TABLE IF EXISTS `paciente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `paciente` (
  `idPaciente` int(11) NOT NULL,
  `correo` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`idPaciente`),
  KEY `correo` (`correo`),
  CONSTRAINT `paciente_ibfk_1` FOREIGN KEY (`correo`) REFERENCES `persona` (`correo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paciente`
--

LOCK TABLES `paciente` WRITE;
/*!40000 ALTER TABLE `paciente` DISABLE KEYS */;
/*!40000 ALTER TABLE `paciente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `persona` (
  `correo` varchar(30) NOT NULL,
  `contrasena` varchar(30) DEFAULT NULL,
  `nombre` varchar(30) DEFAULT NULL,
  `apellidos` varchar(30) DEFAULT NULL,
  `edad` int(11) DEFAULT NULL,
  `telefono` int(11) DEFAULT NULL,
  `fechaNacimiento` date DEFAULT NULL,
  `fechaRegistro` date DEFAULT NULL,
  PRIMARY KEY (`correo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recepcionista`
--

DROP TABLE IF EXISTS `recepcionista`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `recepcionista` (
  `idrecepcionista` int(11) NOT NULL,
  `idempleado` int(11) DEFAULT NULL,
  PRIMARY KEY (`idrecepcionista`),
  KEY `idempleado` (`idempleado`),
  CONSTRAINT `recepcionista_ibfk_1` FOREIGN KEY (`idempleado`) REFERENCES `empleado` (`idempleado`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recepcionista`
--

LOCK TABLES `recepcionista` WRITE;
/*!40000 ALTER TABLE `recepcionista` DISABLE KEYS */;
/*!40000 ALTER TABLE `recepcionista` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `receta`
--

DROP TABLE IF EXISTS `receta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `receta` (
  `idreceta` int(11) NOT NULL,
  `direccionsucursal` varchar(50) DEFAULT NULL,
  `fechaemision` date DEFAULT NULL,
  `diagnostico` varchar(75) DEFAULT NULL,
  `prescripcion` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idreceta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `receta`
--

LOCK TABLES `receta` WRITE;
/*!40000 ALTER TABLE `receta` DISABLE KEYS */;
/*!40000 ALTER TABLE `receta` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-15 17:27:42
