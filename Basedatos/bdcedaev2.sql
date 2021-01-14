CREATE DATABASE  IF NOT EXISTS `cedae2` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `cedae2`;
-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: cedae2
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `cita`
--

DROP TABLE IF EXISTS `cita`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cita` (
  `idcita` int NOT NULL,
  `curppaciente` varchar(18) DEFAULT NULL,
  `curpmedaux` varchar(18) DEFAULT NULL,
  `curpmedtit` varchar(18) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `hora` time DEFAULT NULL,
  `sucursal` varchar(10) DEFAULT NULL,
  `duracion` time DEFAULT NULL,
  PRIMARY KEY (`idcita`),
  KEY `curppaciente` (`curppaciente`),
  KEY `curpmedaux` (`curpmedaux`),
  KEY `curpmedtit` (`curpmedtit`),
  CONSTRAINT `cita_ibfk_1` FOREIGN KEY (`curppaciente`) REFERENCES `paciente` (`curp`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `cita_ibfk_2` FOREIGN KEY (`curpmedaux`) REFERENCES `medico` (`curp`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `cita_ibfk_3` FOREIGN KEY (`curpmedtit`) REFERENCES `medico` (`curp`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cita`
--

LOCK TABLES `cita` WRITE;
/*!40000 ALTER TABLE `cita` DISABLE KEYS */;
INSERT INTO `cita` VALUES (1,'PAGM930918HMCLRH01','CAVJ890922HMCLLS05','CAAA980920HMCSRG06','2020-12-21','11:00:00','Satelite','01:00:00'),(2,'PAGM930918HMCLRH01','CAVJ890922HMCLLS05','CAAA980920HMCSRG06','2020-12-26','12:30:00','Satelite','00:30:00'),(3,'PAGM930918HMCLRH01','CAVJ890922HMCLLS05','CAAA980920HMCSRG06','2021-01-09','13:00:00','Satelite','00:30:00'),(4,'PEMD941124HMCDLM07','CABF941114MMCMLR00','CABF941114MMCMLR00','2020-12-22','13:00:00','Satelite','01:00:00'),(5,'PEMD941124HMCDLM07','CABF941114MMCMLR00','CABF941114MMCMLR00','2020-12-27','14:00:00','Satelite','00:30:00'),(6,'PEMD941124HMCDLM07','CABF941114MMCMLR00','CABF941114MMCMLR00','2021-01-09','14:30:00','Satelite','00:30:00'),(7,'ROCJ810826HMCMRS03','FECJ851211HMCRRR01','CAMC920518MMCNST00','2020-12-21','11:30:00','La Roma','01:00:00'),(8,'ROCJ810826HMCMRS03','FECJ851211HMCRRR01','CAMC920518MMCNST00','2020-12-21','12:30:00','La Roma','00:30:00'),(9,'ROCJ810826HMCMRS03','FECJ851211HMCRRR01','CAMC920518MMCNST00','2021-01-09','15:00:00','La Roma','00:30:00'),(10,'SIMS831111HMCIRM01','GAPA891219HMCLRN01','CATJ971002MMCZDS01','2021-01-14','15:00:00','La Roma','01:00:00'),(12,'VICS980920MMCINS09','GAPA891219HMCLRN01','CATJ971002MMCZDS01','2021-01-13','17:00:00','La Roma','01:00:00'),(13,'TMP1610480204','FECJ851211HMCRRR01','CAMC920518MMCNST00','2021-01-13','10:00:00','La Roma','01:00:00'),(14,'GOAM990502HMCNMR02','GAPA891219HMCLRN01','CATJ971002MMCZDS01','2021-01-13','10:00:00','La Roma','01:00:00');
/*!40000 ALTER TABLE `cita` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleado`
--

DROP TABLE IF EXISTS `empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empleado` (
  `curp` varchar(18) NOT NULL,
  `area` varchar(15) DEFAULT NULL,
  `horaentrada` time DEFAULT NULL,
  `horasalida` time DEFAULT NULL,
  `horacomida` time DEFAULT NULL,
  `puesto` varchar(30) DEFAULT NULL,
  `sucursal` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`curp`),
  CONSTRAINT `empleado_ibfk_1` FOREIGN KEY (`curp`) REFERENCES `persona` (`curp`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleado`
--

LOCK TABLES `empleado` WRITE;
/*!40000 ALTER TABLE `empleado` DISABLE KEYS */;
INSERT INTO `empleado` VALUES ('AIAD990228HMCRSV01','FARMACIA','10:00:00','18:00:00','14:00:00','ENCARGADO','Satelite'),('AUMT940806MMCNLR03','FARMACIA','12:00:00','20:00:00','16:00:00','ENCARGADO','La Roma'),('BEVJ971012HMCNRN00','RECEPCION','10:00:00','18:00:00','14:00:00','RECEPCIONISTA','Satelite'),('BOPA940213MMCRZL00','RECEPCION','12:00:00','20:00:00','16:00:00','RECEPCIONISTA','La Roma'),('CAAA980920HMCSRG06','MEDICA','10:00:00','18:00:00','14:00:00','DOCTOR TITULAR','Satelite'),('CABF941114MMCMLR00','MEDICA','12:00:00','20:00:00','16:00:00','DOCTOR TITULAR','Satelite'),('CAMC920518MMCNST00','MEDICA','10:00:00','18:00:00','14:00:00','DOCTOR TITULAR','La Roma'),('CATJ971002MMCZDS01','MEDICA','12:00:00','20:00:00','16:00:00','DOCTOR TITULAR','La Roma'),('CAVJ890922HMCLLS05','MEDICA','10:00:00','18:00:00','14:00:00','DOCTOR AUXILIAR','Satelite'),('COVA810120MMCRLN08','MEDICA','12:00:00','20:00:00','16:00:00','DOCTOR AUXILIAR','Satelite'),('FECJ851211HMCRRR01','MEDICA','10:00:00','18:00:00','14:00:00','DOCTOR AUXILIAR','La Roma'),('GAPA891219HMCLRN01','MEDICA','12:00:00','20:00:00','16:00:00','DOCTOR AUXILIAR','La Roma'),('MEBM910121MMCRRR00','ADMINISTRACION','10:00:00','20:00:00','16:00:00','ADMIN SISTEMAS','Satelite'),('PAGJ990522MMCLRL03','ADMINISTRACION','10:00:00','20:00:00','16:00:00','ADMIN SISTEMAS','La Roma');
/*!40000 ALTER TABLE `empleado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `expediente`
--

DROP TABLE IF EXISTS `expediente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `expediente` (
  `idexpediente` int NOT NULL,
  `curp` varchar(18) DEFAULT NULL,
  `fechacreacion` date DEFAULT NULL,
  `fechamodif` date DEFAULT NULL,
  `alergias` varchar(100) DEFAULT NULL,
  `antecedentesheredofamiliares` varchar(100) DEFAULT NULL,
  `antecedentespersonales` varchar(100) DEFAULT NULL,
  `padecimientoactual` varchar(100) DEFAULT NULL,
  `peso` int DEFAULT NULL,
  `estatura` int DEFAULT NULL,
  `presionarterial` varchar(7) DEFAULT NULL,
  `frecuenciacardiaca` int DEFAULT NULL,
  `frecuenciarespiratoria` int DEFAULT NULL,
  `temperatura` decimal(3,1) DEFAULT NULL,
  `topografia` varchar(100) DEFAULT NULL,
  `morfologia` varchar(100) DEFAULT NULL,
  `pielyanexos` varchar(20) DEFAULT NULL,
  `tratamientoanterior` varchar(40) DEFAULT NULL,
  `diagnostico` varchar(100) DEFAULT NULL,
  `cie` varchar(10) DEFAULT NULL,
  `descripcion` varchar(100) DEFAULT NULL,
  `observaciones` varchar(100) DEFAULT NULL,
  `planseguimiento` varchar(100) DEFAULT NULL,
  `genero` int DEFAULT NULL,
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
INSERT INTO `expediente` VALUES (1,'SIMS831111HMCIRM01','2020-12-21','2020-12-26','PENICILINA','NEGADAS','RINOPLASTIA QX TUMOR DE FEMUR DERECHO','REFIERE A QUE SU ESPALDA LE SALEN MUCHOS GRANITOS, ES MUY ANSIOSA Y LE QUEDARON MANCHAS',56,165,'120/80',66,12,36.5,'D DISEINADA A CARA Y TRONCO POSTERIOR','CONSTITUIDA POR 2-3 PAPULAS ERIMTEMATOSAS, MANCHAS HIEPRIGMENTADAS, COSTRAS SANGUINEAS','ALOPECIA DIFUSA','PASTA DE DIENTES','ACNE INFLAMATORIO MODERADO EXCORDIADO',NULL,NULL,'Lorem ipsum dolor sit amet, consectetur adipiscing elit.','Lorem ipsum dolor sit amet, consectetur adipiscing elit.',0),(2,'VICS980920MMCINS09','2020-12-22','2020-12-27','NEGADAS','NEGADAS','Lorem ipsum dolor sit amet, consectetur adipiscing elit.','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque nec',58,170,'121/70',65,13,36.5,'Lorem ipsum dolor sit amet','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque nec','Lorem ipsum','Lorem ipsum','Lorem ipsum dolor sit amet, consectetur adipiscing elit.','15782','Lorem ipsum dolor sit amet, consectetur adipiscing elit.','Lorem ipsum dolor sit amet, consectetur adipiscing elit.','Lorem ipsum dolor sit amet, consectetur adipiscing elit.',1),(3,'ROCJ810826HMCMRS03','2020-12-21','2020-12-21','NEGADAS','NEGADAS','Lorem ipsum dolor sit amet, consectetur adipiscing elit.','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque nec',56,152,'120/80',63,12,36.7,'Lorem ipsum dolor sit amet','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque nec','Lorem ipsum','Lorem ipsum','Lorem ipsum dolor sit amet, consectetur adipiscing elit.','85726','Lorem ipsum dolor sit amet, consectetur adipiscing elit.','Lorem ipsum dolor sit amet, consectetur adipiscing elit.','Lorem ipsum dolor sit amet, consectetur adipiscing elit.',0),(4,'GOAM990502HMCNMR02','2021-01-12','2021-01-12','Negadas','Negadas','Negadas','Hipersensibilidad cutanea',67,175,'120/80',110,16,36.5,'-','-','-','-','Abrasión Cutanea','87626','Abrasion cutanea debido a caida','Presenta una abracion cutanea en la parte del antebrazo izquierdo asi como manchas','Mantener la zona humectada',1);
/*!40000 ALTER TABLE `expediente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `expedientecitas`
--

DROP TABLE IF EXISTS `expedientecitas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `expedientecitas` (
  `idcita` int NOT NULL,
  `idexpediente` int NOT NULL,
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
INSERT INTO `expedientecitas` VALUES (1,1),(2,1),(4,2),(5,2),(7,3),(8,3);
/*!40000 ALTER TABLE `expedientecitas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medicamento`
--

DROP TABLE IF EXISTS `medicamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medicamento` (
  `sku` varchar(15) NOT NULL,
  `tamano` varchar(15) DEFAULT NULL,
  `precio` int DEFAULT NULL,
  `nombre` varchar(75) DEFAULT NULL,
  `sucursal` varchar(10) DEFAULT NULL,
  `lote` json DEFAULT NULL,
  PRIMARY KEY (`sku`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicamento`
--

LOCK TABLES `medicamento` WRITE;
/*!40000 ALTER TABLE `medicamento` DISABLE KEYS */;
INSERT INTO `medicamento` VALUES ('00-22-44-154','20ml',103,'Apivita Express Beauty Sheet Mask Algarroba','Satelite','{\"lotes\": [{\"fcad\": \"2028-12-13\", \"nlote\": \"1\", \"unidades\": 30}, {\"fcad\": \"2030-05-15\", \"nlote\": \"2\", \"unidades\": 40}]}'),('148797.3','20gr',50,'Bifonazol 10 mg/g','La Roma','{\"lotes\": [{\"fcad\": \"2021-04-08\", \"nlote\": \"1\", \"unidades\": 20}, {\"fcad\": \"2024-12-20\", \"nlote\": \"2\", \"unidades\": 22}]}'),('154754.5','400ml',320,'Gel Moussant Limpiador Purificante','Satelite','{\"lotes\": [{\"fcad\": \"2023-04-25\", \"nlote\": \"1\", \"unidades\": 61}, {\"fcad\": \"2030-08-27\", \"nlote\": \"2\", \"unidades\": 70}]}'),('154888.7','50ml',433,'Isdin Nutradeica Gel-Crema Facial Piel Seborreica','Satelite','{\"lotes\": [{\"fcad\": \"2021-03-29\", \"nlote\": \"1\", \"unidades\": 22}, {\"fcad\": \"2025-03-15\", \"nlote\": \"2\", \"unidades\": 25}]}'),('166650.5','500ml',86,'Bioderma Sebium Gel Espumoso Limpiador Purificante','Satelite','{\"lotes\": [{\"fcad\": \"2024-01-18\", \"nlote\": \"1\", \"unidades\": 15}, {\"fcad\": \"2026-03-02\", \"nlote\": \"2\", \"unidades\": 27}]}'),('167065.6','30ml',375,'Neostrata Skin Active Matrix Serum Antioxidante','La Roma','{\"lotes\": [{\"fcad\": \"2023-06-25\", \"nlote\": \"1\", \"unidades\": 40}, {\"fcad\": \"2029-08-14\", \"nlote\": \"2\", \"unidades\": 50}]}'),('171350.6','6ml',237,'Endocare C Peel Gel 5 sobres','La Roma','{\"lotes\": [{\"fcad\": \"2022-04-10\", \"nlote\": \"1\", \"unidades\": 59}, {\"fcad\": \"2029-09-13\", \"nlote\": \"2\", \"unidades\": 60}]}'),('176331.0','30ml',106,'Plante System Fluido Desfatigante Facial Précieuse Edelweiss','La Roma','{\"lotes\": [{\"fcad\": \"2021-12-12\", \"nlote\": \"1\", \"unidades\": 21}, {\"fcad\": \"2025-10-14\", \"nlote\": \"2\", \"unidades\": 30}]}'),('176389.1','75gr',725,'Sensilis Skin Delight Peeling Negro Revitalizante','La Roma','{\"lotes\": [{\"fcad\": \"2023-06-09\", \"nlote\": \"1\", \"unidades\": 64}, {\"fcad\": \"2028-11-15\", \"nlote\": \"2\", \"unidades\": 70}]}'),('178899.3','30ml',162,'Bioderma Sébium Sensitive Cuidado Calmante Antiimperfecciones','Satelite','{\"lotes\": [{\"fcad\": \"2025-12-02\", \"nlote\": \"1\", \"unidades\": 33}, {\"fcad\": \"2026-10-17\", \"nlote\": \"2\", \"unidades\": 30}]}'),('184310.4','50ml',372,'Isdin Fotoprotector Pediatrics Fusion Fluid Mineral Baby SPF50+','Satelite','{\"lotes\": [{\"fcad\": \"2024-01-18\", \"nlote\": \"1\", \"unidades\": 61}, {\"fcad\": \"2030-05-17\", \"nlote\": \"2\", \"unidades\": 70}]}'),('186752.1','35gr',50,'Pomada de la Campana','La Roma','{\"lotes\": [{\"fcad\": \"2023-01-14\", \"nlote\": \"1\", \"unidades\": 15}, {\"fcad\": \"2024-06-15\", \"nlote\": \"2\", \"unidades\": 20}]}'),('187652.2','473ml',313,'CeraVe Gel Limpiador Espumoso','La Roma','{\"lotes\": [{\"fcad\": \"2022-12-18\", \"nlote\": \"1\", \"unidades\": 43}, {\"fcad\": \"2025-12-21\", \"nlote\": \"2\", \"unidades\": 27}]}'),('193613.4','40ml',342,'Martiderm Proteos Screen SPF50+','Satelite','{\"lotes\": [{\"fcad\": \"2023-03-03\", \"nlote\": \"1\", \"unidades\": 22}, {\"fcad\": \"2025-09-10\", \"nlote\": \"2\", \"unidades\": 25}]}'),('197615.4','50ml',205,'Bella Aurora Bio10 Solar Protector','Satelite','{\"lotes\": [{\"fcad\": \"2025-09-15\", \"nlote\": \"1\", \"unidades\": 23}, {\"fcad\": \"2028-11-14\", \"nlote\": \"2\", \"unidades\": 25}]}'),('200070.4','40ml',170,'Isdin Acniben Skin Rx Gel Crema Hidratante','Satelite','{\"lotes\": [{\"fcad\": \"2022-07-25\", \"nlote\": \"1\", \"unidades\": 25}, {\"fcad\": \"2026-08-30\", \"nlote\": \"2\", \"unidades\": 30}]}'),('213017.3','100ml',198,'Neostrata Gel Forte Salicílico','La Roma','{\"lotes\": [{\"fcad\": \"2022-11-27\", \"nlote\": \"1\", \"unidades\": 66}, {\"fcad\": \"2028-12-22\", \"nlote\": \"2\", \"unidades\": 70}]}'),('247379.9','30 Ampollas',217,'Martiderm Proteos Hydra Plus','La Roma','{\"lotes\": [{\"fcad\": \"2022-09-26\", \"nlote\": \"1\", \"unidades\": 35}, {\"fcad\": \"2025-10-15\", \"nlote\": \"2\", \"unidades\": 30}]}'),('317171.7','200ml',470,'La Roche-Posay Solución Micelar','La Roma','{\"lotes\": [{\"fcad\": \"2028-10-16\", \"nlote\": \"1\", \"unidades\": 36}, {\"fcad\": \"2029-12-15\", \"nlote\": \"2\", \"unidades\": 40}]}'),('586545FDT','2x28 Cápsulas',632,'Repavar Monoderma C10 Revitalizante Duplo','La Roma','{\"lotes\": [{\"fcad\": \"2022-09-26\", \"nlote\": \"1\", \"unidades\": 41}, {\"fcad\": \"2025-16-07\", \"nlote\": \"2\", \"unidades\": 30}]}'),('661250.7','25ml',120,'Cristalmina 10 mg/ml Spray','Satelite','{\"lotes\": [{\"fcad\": \"2022-06-23\", \"nlote\": \"1\", \"unidades\": 33}, {\"fcad\": \"2024-03-08\", \"nlote\": \"2\", \"unidades\": 20}]}'),('710449.0','5ml',650,'Locetar 50mg/ml Barniz Uñas Medicamentoso','Satelite','{\"lotes\": [{\"fcad\": \"2024-01-18\", \"nlote\": \"1\", \"unidades\": 15}, {\"fcad\": \"2027-06-24\", \"nlote\": \"2\", \"unidades\": 27}]}'),('FD5502340','20x2ml',137,'Endocare Tensage Ampollas','Satelite','{\"lotes\": [{\"fcad\": \"2025-08-06\", \"nlote\": \"1\", \"unidades\": 59}, {\"fcad\": \"2026-04-28\", \"nlote\": \"2\", \"unidades\": 30}]}'),('FD55203','50ml',900,'Eucerin Pack Hyaluron-Filler Crema Día PNM','Satelite','{\"lotes\": [{\"fcad\": \"2028-12-19\", \"nlote\": \"1\", \"unidades\": 15}, {\"fcad\": \"2030-06-25\", \"nlote\": \"2\", \"unidades\": 20}]}'),('L0037','40ml',327,'Lierac Sunissime Fluido Protector Revitalizante Rostro SPF50+','Satelite','{\"lotes\": [{\"fcad\": \"2021-10-14\", \"nlote\": \"1\", \"unidades\": 55}, {\"fcad\": \"2022-07-05\", \"nlote\": \"2\", \"unidades\": 27}]}'),('P171315','30 Ampollas',345,'Endocare Pack Radiance C Oil','La Roma','{\"lotes\": [{\"fcad\": \"2021-09-03\", \"nlote\": \"1\", \"unidades\": 30}, {\"fcad\": \"2022-04-03\", \"nlote\": \"2\", \"unidades\": 22}]}'),('P190828','50ml',385,'Biretix Pack Tri-Active','La Roma','{\"lotes\": [{\"fcad\": \"2022-03-17\", \"nlote\": \"1\", \"unidades\": 19}, {\"fcad\": \"2025-11-14\", \"nlote\": \"2\", \"unidades\": 24}]}');
/*!40000 ALTER TABLE `medicamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medico`
--

DROP TABLE IF EXISTS `medico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medico` (
  `curp` varchar(18) NOT NULL,
  `cedula` int DEFAULT NULL,
  `especialidad` varchar(20) DEFAULT NULL,
  `tipomed` bit(1) DEFAULT NULL,
  PRIMARY KEY (`curp`),
  CONSTRAINT `medico_ibfk_1` FOREIGN KEY (`curp`) REFERENCES `empleado` (`curp`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medico`
--

LOCK TABLES `medico` WRITE;
/*!40000 ALTER TABLE `medico` DISABLE KEYS */;
INSERT INTO `medico` VALUES ('CAAA980920HMCSRG06',18186984,'Cirugía General',_binary ''),('CABF941114MMCMLR00',29430465,'DERMATOLOGIA',_binary ''),('CAMC920518MMCNST00',66610086,'HEMATOLOGIA',_binary ''),('CATJ971002MMCZDS01',69414940,'NEFROLOGIA',_binary ''),('CAVJ890922HMCLLS05',18186984,'NEUROLOGIA',_binary '\0'),('COVA810120MMCRLN08',29430465,'ORTOPEDIA',_binary '\0'),('FECJ851211HMCRRR01',66610086,'RADIOLOGIA',_binary '\0'),('GAPA891219HMCLRN01',69414940,'HEMATOLOGIA',_binary '\0');
/*!40000 ALTER TABLE `medico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paciente`
--

DROP TABLE IF EXISTS `paciente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `paciente` (
  `curp` varchar(18) NOT NULL,
  `aseguradora` varchar(25) DEFAULT NULL,
  `idexpediente` int DEFAULT NULL,
  `estado` int DEFAULT NULL,
  PRIMARY KEY (`curp`),
  CONSTRAINT `paciente_ibfk_1` FOREIGN KEY (`curp`) REFERENCES `persona` (`curp`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paciente`
--

LOCK TABLES `paciente` WRITE;
/*!40000 ALTER TABLE `paciente` DISABLE KEYS */;
INSERT INTO `paciente` VALUES ('GOAM990502HMCNMR02','Ninguna',4,0),('PAGM930918HMCLRH01','ALLIANZ SEGUROS',1,1),('PEMD941124HMCDLM07','AXA SEGUROS',2,1),('ROCJ810826HMCMRS03','SEGUROS BANORTE',3,1),('SIMS831111HMCIRM01','SEGUROS INBURSA',1,0),('TMP1610480204',NULL,NULL,0),('VICS980920MMCINS09','SEGUROS BANORTE',2,0);
/*!40000 ALTER TABLE `paciente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pacientemedico`
--

DROP TABLE IF EXISTS `pacientemedico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pacientemedico` (
  `curp` varchar(18) NOT NULL,
  `curpmedico` varchar(18) NOT NULL,
  PRIMARY KEY (`curp`,`curpmedico`),
  KEY `curpmedico` (`curpmedico`),
  CONSTRAINT `pacientemedico_ibfk_1` FOREIGN KEY (`curp`) REFERENCES `paciente` (`curp`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `pacientemedico_ibfk_2` FOREIGN KEY (`curpmedico`) REFERENCES `medico` (`curp`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pacientemedico`
--

LOCK TABLES `pacientemedico` WRITE;
/*!40000 ALTER TABLE `pacientemedico` DISABLE KEYS */;
INSERT INTO `pacientemedico` VALUES ('PAGM930918HMCLRH01','CAAA980920HMCSRG06'),('PEMD941124HMCDLM07','CABF941114MMCMLR00'),('ROCJ810826HMCMRS03','CAMC920518MMCNST00'),('GOAM990502HMCNMR02','CATJ971002MMCZDS01'),('SIMS831111HMCIRM01','CATJ971002MMCZDS01'),('VICS980920MMCINS09','CATJ971002MMCZDS01'),('PAGM930918HMCLRH01','CAVJ890922HMCLLS05'),('PEMD941124HMCDLM07','COVA810120MMCRLN08'),('ROCJ810826HMCMRS03','FECJ851211HMCRRR01'),('SIMS831111HMCIRM01','GAPA891219HMCLRN01'),('VICS980920MMCINS09','GAPA891219HMCLRN01');
/*!40000 ALTER TABLE `pacientemedico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `persona` (
  `curp` varchar(18) NOT NULL,
  `correo` varchar(30) DEFAULT NULL,
  `contrasena` varchar(30) DEFAULT NULL,
  `nombre` varchar(30) DEFAULT NULL,
  `apellidos` varchar(30) DEFAULT NULL,
  `edad` int DEFAULT NULL,
  `telefono` varchar(10) DEFAULT NULL,
  `fechaNacimiento` date DEFAULT NULL,
  `fechaRegistro` date DEFAULT NULL,
  `direccion` varchar(80) DEFAULT NULL,
  `colonia` varchar(30) DEFAULT NULL,
  `entidadfederativa` varchar(20) DEFAULT NULL,
  `codigopostal` int DEFAULT NULL,
  `tipo` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`curp`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` VALUES ('AIAD990228HMCRSV01','nova64@hotmail.com','rPTuCWwNAzBU','DAVID','ARIAS ASENJO',26,'5563755889','1999-02-28','2019-10-03','PASEO DE LA REFORMA 1, TABACALERA','CUAUHTEMOC','CIUDAD DE MEXICO',6030,'empleado'),('AUMT940806MMCNLR03','myah45@hotmail.com','zSnPkUWTGhAw','TERESA','ANGUITA MALLO',26,'5567753033','1994-08-06','2019-05-24','CARR FED MEXICO-PUEBLA KM 19.5','LOS REYES ACAQUILPAN','ESTADO DE MEXICO',56400,'empleado'),('BEVJ971012HMCNRN00','barney_bogisich@gmail.com','rAeKHKvRjzKN','JUAN LUIS','BENITEZ VARA',23,'5582748783','1997-10-12','2019-04-29','PLAN DE IGUALA 2, SANTA MARIA TICOMAN','GUSTAVO A MADERO','CIUDAD DE MEXICO',7330,'empleado'),('BOPA940213MMCRZL00','sheila_fadel18@hotmail.com','eVRBZppnceuA','FRANCISCA','CAMPILLO BELDA',26,'5533763618','1994-02-13','2019-04-15','LUTARCO E CALLES 1503 N5, ZACAHUITZCO','BENITO JUAREZ','CIUDAD DE MEXICO',3550,'empleado'),('CAAA980920HMCSRG06','leopold9@gmail.com','bUeXFwkatAEe','AGUSTIN','CASTILLEJO ARCO',22,'5504623819','1998-09-20','2019-09-03','EGIPTO 206','CLAVERIA','CIUDAD DE MEXICO',2080,'empleado'),('CABF941114MMCMLR00','trystan_schroeder76@yahoo.com','jGCCCcHZdFTM','FRANCISCA','CAMPILLO BELDA',26,'5597520942','1994-11-14','2019-02-07','CALZADA SAN MATEO 29, SAN JUAN BOSCO','ATIZAPAN DE ZARAGOZA','ESTADO DE MEXICO',52940,'empleado'),('CAMC920518MMCNST00','samir.krajcik77@hotmail.com','HrUtCpjwtnWk','CATALINA','CANTERO MAESO',28,'5515457103','1992-05-18','2019-12-01','COLTONGO NO. 100, TRABAJADORES DEL HIERRO','AZCAPOTZALCO','CIUDAD DE MEXICO',2650,'empleado'),('CATJ971002MMCZDS01','kaden_larkin80@yahoo.com','BaSbnvcGSDTN','JOSEFA','CAZORLA TUDELA',23,'5562674931','1997-10-02','2019-11-18','MANUEL MA. CONTRERAS NO. 73 S/N','SAN RAFAEL','CIUDAD DE MEXICO',6470,'empleado'),('CAVJ890922HMCLLS05','jailyn60@yahoo.com','eFmmHHpUxZKf','JOSE','CALVET VELARDE',31,'5564458857','1989-09-22','2019-08-14','AV LA PALMA NO. 10 S/N','CUAUTITLAN','ESTADO DE MEXICO',54900,'empleado'),('COVA810120MMCRLN08','jessica.jacobson@hotmail.com','GsjKDKWZevaR','ANA ISABEL','CORREDOR VALLS',39,'5591035691','1981-01-20','2019-08-17','16 DE SEPTIEMBRE 70, ALCE BLANCO','NAUCALPAN','ESTADO DE MEXICO',53370,'empleado'),('FECJ851211HMCRRR01','adolf.ohara63@hotmail.com','jRARnuRfQCkJ','JORGE','FERNANDEZ CARBO',35,'5572115665','1985-12-11','2019-09-24','MARGARITA MAZA DE JUAREZ 149, NUEVA IND VALLEJO','GUSTAVO A MADERO','CIUDAD DE MEXICO',7700,'empleado'),('GAPA891219HMCLRN01','taurean.hackett@gmail.com','BxRmHQkmfqmH','ANGEL','GALLEGOS PARIENTE',31,'5539494459','1989-12-19','2019-07-26','BOSQUE DE DURAZNOS 39, BOSQUES DE LAS LOMAS','MIGUEL HIDALGO','CIUDAD DE MEXICO',11700,'empleado'),('GOAM990502HMCNMR02','mariololi3@hotmail.com','jejejejeje','Alfredo','Gomez',21,'5519141403','1999-05-02','2021-01-12','Zacatecas Lt. 14 Mza. 272 ','Col. Luis Echeverria','Estado de México',54753,'paciente'),('MEBM910121MMCRRR00','orville12@yahoo.com','NnbptPgebuTJ','MARIA NIEVES','MERCADER BORRELL',29,'5544008605','1991-01-12','2019-11-26','AGUSTIN DELGADO 275, TRANSITO','CUAUHTEMOC','CIUDAD DE MEXICO',60020,'empleado'),('PAGJ990522MMCLRL03','godfrey35@hotmail.com','XcDcvRsnZDHU','JULIA','PLATA GORDON',21,'5595634812','1999-05-22','2019-02-06','EJE CENTRAL LAZARO CARDENAS NO. 9 Int. INT. 39, CENTRO DE LA CIUDAD DE MEXICO','CUAUHTEMOC','CIUDAD DE MEXICO',6300,'empleado'),('PAGM930918HMCLRH01','salvador78@yahoo.com','NpNhhFkCuTwh','MOHAMED','PLATERO GRANELL',27,'5513272092','1993-09-18','2019-08-22','MAGNOLIAS NO. 537, VILLA DE LAS FLORES','COACALCO DE BERRIZOBAL','ESTADO DE MEXICO',55710,'paciente'),('PEMD941124HMCDLM07','cletus_kuhic@hotmail.com','rngJTgVkPHeQ','DOMINGO','PEDREIRA MOLINS',26,'5532780874','1994-11-24','2019-11-18','Henry Ford Esq. Roberto Fulton','TLALNEPANTLA','ESTADO DE MEXICO',2650,'paciente'),('ROCJ810826HMCMRS03','earnest7@yahoo.com','KzUkdBjTUzgd','JOSE ANTONIO','ROMERA CORDOVA',39,'5515291882','1981-08-26','2019-06-28','ZACATECAS 206 602, ROMA','NEZAHUALCOYOTL','ESTADO DE MEXICO',6200,'paciente'),('SIMS831111HMCIRM01','kyle_runte56@yahoo.com','ECVbCgnwwHwc','SAMUEL','SILVESTRE MURCIA',37,'5568940817','1983-11-11','2019-02-07','RODOLFO USIGLI NO. 1402, SECTOR POPULAR','IZTAPALAPA','ESTADO DE MEXICO',9060,'paciente'),('TMP1610480204','mariololi2@hotmail.com',NULL,'Mario','Gonzalez',NULL,'5519141402',NULL,NULL,NULL,NULL,NULL,NULL,'paciente'),('VICS980920MMCINS09','scotty_labadie91@yahoo.com','eUsgGYuPtnTn','SUSANA','VILLA CANDELA',22,'5534355899','1998-09-20','2019-08-23','ANGEL DE LA INDEPENDENCIA NO. 98, METROPOLINATA 2A SECC','NEZAHUALCOYOTL','ESTADO DE MEXICO',57740,'paciente');
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `receta`
--

DROP TABLE IF EXISTS `receta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `receta` (
  `idreceta` int NOT NULL,
  `direccionsucursal` varchar(100) DEFAULT NULL,
  `diagnostico` varchar(100) DEFAULT NULL,
  `cie` varchar(5) DEFAULT NULL,
  `descripcion` varchar(100) DEFAULT NULL,
  `observaciones` varchar(100) DEFAULT NULL,
  `planseguimiento` varchar(100) DEFAULT NULL,
  `productos` json DEFAULT NULL,
  PRIMARY KEY (`idreceta`),
  CONSTRAINT `receta_ibfk_1` FOREIGN KEY (`idreceta`) REFERENCES `cita` (`idcita`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `receta`
--

LOCK TABLES `receta` WRITE;
/*!40000 ALTER TABLE `receta` DISABLE KEYS */;
INSERT INTO `receta` VALUES (1,'Circuito Cirujanos N.11 Depto. 201,Cd. Satelite, Naucalpan Edo. de Mexico, C.P53100','Lorem ipsum dolor sit amet, consectetur adipiscing elit','58746','Lorem ipsum dolor sit amet, consectetur adipiscing elit.','Lorem ipsum dolor sit amet, consectetur adipiscing elit.','Lorem ipsum dolor sit amet, consectetur adipiscing elit.',NULL),(2,'Circuito Cirujanos N.11 Depto. 201,Cd. Satelite, Naucalpan Edo. de Mexico, C.P53100','ACNE INFLAMATORIO MODERADO EXCORDIADO',NULL,NULL,'Lorem ipsum dolor sit amet, consectetur adipiscing elit.','Lorem ipsum dolor sit amet, consectetur adipiscing elit.',NULL),(4,'Circuito Cirujanos N.11 Depto. 201,Cd. Satelite, Naucalpan Edo. de Mexico, C.P53100','Lorem ipsum dolor sit amet, consectetur adipiscing elit','89645','Lorem ipsum dolor sit amet, consectetur adipiscing elit.','Lorem ipsum dolor sit amet, consectetur adipiscing elit.','Lorem ipsum dolor sit amet, consectetur adipiscing elit.',NULL),(5,'Circuito Cirujanos N.11 Depto. 201,Cd. Satelite, Naucalpan Edo. de Mexico, C.P53100','Lorem ipsum dolor sit amet, consectetur adipiscing elit','15782','Lorem ipsum dolor sit amet, consectetur adipiscing elit.','Lorem ipsum dolor sit amet, consectetur adipiscing elit.','Lorem ipsum dolor sit amet, consectetur adipiscing elit.',NULL),(7,'Circuito Cirujanos N.11 Depto. 201,Cd. Satelite, Naucalpan Edo. de Mexico, C.P53100','Lorem ipsum dolor sit amet, consectetur adipiscing elit','67825','Lorem ipsum dolor sit amet, consectetur adipiscing elit.','Lorem ipsum dolor sit amet, consectetur adipiscing elit.','Lorem ipsum dolor sit amet, consectetur adipiscing elit.',NULL),(8,'Circuito Cirujanos N.11 Depto. 201,Cd. Satelite, Naucalpan Edo. de Mexico, C.P53100','Lorem ipsum dolor sit amet, consectetur adipiscing elit','85726','Lorem ipsum dolor sit amet, consectetur adipiscing elit.','Lorem ipsum dolor sit amet, consectetur adipiscing elit.','Lorem ipsum dolor sit amet, consectetur adipiscing elit.',NULL);
/*!40000 ALTER TABLE `receta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recetamedicamento`
--

DROP TABLE IF EXISTS `recetamedicamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recetamedicamento` (
  `idreceta` int NOT NULL,
  `sku` varchar(15) NOT NULL,
  `indicaciones` varchar(75) DEFAULT NULL,
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
INSERT INTO `recetamedicamento` VALUES (1,'166650.5','Lorem ipsum dolor sit amet, consectetur adipiscing elit.'),(1,'187652.2','Lorem ipsum dolor sit amet, consectetur adipiscing elit.'),(1,'317171.7','Lorem ipsum dolor sit amet, consectetur adipiscing elit.'),(1,'P171315','Lorem ipsum dolor sit amet, consectetur adipiscing elit.'),(2,'317171.7','Lorem ipsum dolor sit amet, consectetur adipiscing elit.'),(2,'L0037','Lorem ipsum dolor sit amet, consectetur adipiscing elit.'),(4,'176331.0','Lorem ipsum dolor sit amet, consectetur adipiscing elit.'),(4,'176389.1','Lorem ipsum dolor sit amet, consectetur adipiscing elit.'),(4,'710449.0','Lorem ipsum dolor sit amet, consectetur adipiscing elit.'),(5,'FD5502340','Lorem ipsum dolor sit amet, consectetur adipiscing elit.'),(7,'00-22-44-154','Lorem ipsum dolor sit amet, consectetur adipiscing elit.'),(7,'171350.6','Lorem ipsum dolor sit amet, consectetur adipiscing elit.'),(8,'167065.6','Lorem ipsum dolor sit amet, consectetur adipiscing elit.'),(8,'178899.3','Lorem ipsum dolor sit amet, consectetur adipiscing elit.'),(8,'197615.4','Lorem ipsum dolor sit amet, consectetur adipiscing elit.'),(8,'200070.4','Lorem ipsum dolor sit amet, consectetur adipiscing elit.'),(8,'P171315','Lorem ipsum dolor sit amet, consectetur adipiscing elit.');
/*!40000 ALTER TABLE `recetamedicamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'cedae2'
--

--
-- Dumping routines for database 'cedae2'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-01-13 19:41:30
