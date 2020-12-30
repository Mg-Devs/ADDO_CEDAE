-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: localhost    Database: cedae2
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
-- Table structure for table `cita`
--

DROP TABLE IF EXISTS `cita`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `cita` (
  `idcita` int(11) NOT NULL,
  `curppaciente` varchar(18) DEFAULT NULL,
  `curpmedaux` varchar(18) DEFAULT NULL,
  `curpmedtit` varchar(18) DEFAULT NULL,
  `idreceta` int(11) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `hora` time DEFAULT NULL,
  PRIMARY KEY (`idcita`),
  KEY `curppaciente` (`curppaciente`),
  KEY `curpmedaux` (`curpmedaux`),
  KEY `curpmedtit` (`curpmedtit`),
  KEY `idreceta` (`idreceta`),
  CONSTRAINT `cita_ibfk_1` FOREIGN KEY (`curppaciente`) REFERENCES `paciente` (`curp`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `cita_ibfk_2` FOREIGN KEY (`curpmedaux`) REFERENCES `medicoauxiliar` (`curp`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `cita_ibfk_3` FOREIGN KEY (`curpmedtit`) REFERENCES `medicotitular` (`curp`) ON DELETE CASCADE ON UPDATE CASCADE,
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
  `curp` varchar(18) NOT NULL,
  `correo` varchar(30) DEFAULT NULL,
  `area` varchar(15) DEFAULT NULL,
  `horaentrada` time DEFAULT NULL,
  `horasalida` time DEFAULT NULL,
  `horacomida` time DEFAULT NULL,
  `puesto` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`curp`),
  CONSTRAINT `empleado_ibfk_1` FOREIGN KEY (`curp`) REFERENCES `persona` (`curp`) ON DELETE CASCADE ON UPDATE CASCADE
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
-- Table structure for table `expediente`
--

DROP TABLE IF EXISTS `expediente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `expediente` (
  `idexpediente` int(11) NOT NULL,
  `curp` varchar(18) DEFAULT NULL,
  `alergias` varchar(100) DEFAULT NULL,
  `antecedentesheredofamiliares` varchar(100) DEFAULT NULL,
  `antecedentespersonales` varchar(100) DEFAULT NULL,
  `padecimientoactual` varchar(50) DEFAULT NULL,
  `peso` int(11) DEFAULT NULL,
  `estatura` int(11) DEFAULT NULL,
  `presionarterial` int(11) DEFAULT NULL,
  `frecuenciacardiaca` int(11) DEFAULT NULL,
  `frecuenciarespiratoria` int(11) DEFAULT NULL,
  `temperatura` int(11) DEFAULT NULL,
  `topografia` varchar(20) DEFAULT NULL,
  `morfologia` varchar(40) DEFAULT NULL,
  `pielyanexos` varchar(20) DEFAULT NULL,
  `tratamientoanterior` varchar(40) DEFAULT NULL,
  `diagnostico` varchar(30) DEFAULT NULL,
  `cie` varchar(5) DEFAULT NULL,
  `descripcion` varchar(100) DEFAULT NULL,
  `observaciones` varchar(50) DEFAULT NULL,
  `planseguimiento` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idexpediente`),
  KEY `curp` (`curp`),
  CONSTRAINT `expediente_ibfk_1` FOREIGN KEY (`curp`) REFERENCES `paciente` (`curp`) ON DELETE CASCADE ON UPDATE CASCADE
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
-- Table structure for table `expedientecitas`
--

DROP TABLE IF EXISTS `expedientecitas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `expedientecitas` (
  `idcita` int(11) NOT NULL,
  `idexpediente` int(11) NOT NULL,
  PRIMARY KEY (`idcita`,`idexpediente`),
  KEY `idexpediente` (`idexpediente`),
  CONSTRAINT `expedientecitas_ibfk_1` FOREIGN KEY (`idcita`) REFERENCES `cita` (`idcita`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `expedientecitas_ibfk_2` FOREIGN KEY (`idexpediente`) REFERENCES `expediente` (`idexpediente`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expedientecitas`
--

LOCK TABLES `expedientecitas` WRITE;
/*!40000 ALTER TABLE `expedientecitas` DISABLE KEYS */;
/*!40000 ALTER TABLE `expedientecitas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medicamento`
--

DROP TABLE IF EXISTS `medicamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `medicamento` (
  `sku` varchar(10) NOT NULL,
  `tamaño` varchar(10) DEFAULT NULL,
  `unidades` int(11) DEFAULT NULL,
  `fechaexp` date DEFAULT NULL,
  `precio` int(11) DEFAULT NULL,
  PRIMARY KEY (`sku`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicamento`
--

LOCK TABLES `medicamento` WRITE;
/*!40000 ALTER TABLE `medicamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `medicamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medicoauxiliar`
--

DROP TABLE IF EXISTS `medicoauxiliar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `medicoauxiliar` (
  `curp` varchar(18) NOT NULL,
  `cedula` int(11) DEFAULT NULL,
  `especialidad` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`curp`),
  CONSTRAINT `medicoauxiliar_ibfk_1` FOREIGN KEY (`curp`) REFERENCES `empleado` (`curp`) ON DELETE CASCADE ON UPDATE CASCADE
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
  `curp` varchar(18) NOT NULL,
  `cedula` int(11) DEFAULT NULL,
  `especialidad` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`curp`),
  CONSTRAINT `medicotitular_ibfk_1` FOREIGN KEY (`curp`) REFERENCES `empleado` (`curp`) ON DELETE CASCADE ON UPDATE CASCADE
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
  `curp` varchar(18) NOT NULL,
  `aseguradora` varchar(15) DEFAULT NULL,
  `idexpediente` int(11) NOT NULL,
  PRIMARY KEY (`curp`),
  CONSTRAINT `paciente_ibfk_1` FOREIGN KEY (`curp`) REFERENCES `persona` (`curp`) ON DELETE CASCADE ON UPDATE CASCADE
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
-- Table structure for table `pacientemedico`
--

DROP TABLE IF EXISTS `pacientemedico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `pacientemedico` (
  `curp` varchar(18) NOT NULL,
  `curpmedico` varchar(18) NOT NULL,
  PRIMARY KEY (`curp`,`curpmedico`),
  KEY `curpmedico` (`curpmedico`),
  CONSTRAINT `pacientemedico_ibfk_1` FOREIGN KEY (`curp`) REFERENCES `paciente` (`curp`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `pacientemedico_ibfk_2` FOREIGN KEY (`curpmedico`) REFERENCES `medicotitular` (`curp`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pacientemedico`
--

LOCK TABLES `pacientemedico` WRITE;
/*!40000 ALTER TABLE `pacientemedico` DISABLE KEYS */;
/*!40000 ALTER TABLE `pacientemedico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `persona` (
  `curp` varchar(18) NOT NULL,
  `correo` varchar(30) DEFAULT NULL,
  `contrasena` varchar(30) DEFAULT NULL,
  `nombre` varchar(30) DEFAULT NULL,
  `apellidos` varchar(30) DEFAULT NULL,
  `edad` int(11) DEFAULT NULL,
  `telefono` int(11) DEFAULT NULL,
  `fechaNacimiento` date DEFAULT NULL,
  `fechaRegistro` date DEFAULT NULL,
  `direccion` varchar(30) DEFAULT NULL,
  `colonia` varchar(15) DEFAULT NULL,
  `entidadfederativa` varchar(20) DEFAULT NULL,
  `codigopostal` int(11) DEFAULT NULL,
  PRIMARY KEY (`curp`)
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
-- Table structure for table `receta`
--

DROP TABLE IF EXISTS `receta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `receta` (
  `idreceta` int(11) NOT NULL,
  `direccionsucursal` varchar(50) DEFAULT NULL,
  `fechaemision` date DEFAULT NULL,
  `diagnostico` varchar(30) DEFAULT NULL,
  `cie` varchar(5) DEFAULT NULL,
  `descripcion` varchar(100) DEFAULT NULL,
  `observaciones` varchar(50) DEFAULT NULL,
  `planseguimiento` varchar(50) DEFAULT NULL,
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

--
-- Table structure for table `recetamedicamento`
--

DROP TABLE IF EXISTS `recetamedicamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `recetamedicamento` (
  `idreceta` int(11) NOT NULL,
  `sku` varchar(10) NOT NULL,
  `indicaciones` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`idreceta`,`sku`),
  KEY `sku` (`sku`),
  CONSTRAINT `recetamedicamento_ibfk_1` FOREIGN KEY (`idreceta`) REFERENCES `receta` (`idreceta`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `recetamedicamento_ibfk_2` FOREIGN KEY (`sku`) REFERENCES `medicamento` (`sku`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recetamedicamento`
--

LOCK TABLES `recetamedicamento` WRITE;
/*!40000 ALTER TABLE `recetamedicamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `recetamedicamento` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-29 21:03:46
