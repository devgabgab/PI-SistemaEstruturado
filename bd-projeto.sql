CREATE DATABASE  IF NOT EXISTS `goldenbenefitspi` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `goldenbenefitspi`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: goldenbenefitspi
-- ------------------------------------------------------
-- Server version	8.0.36

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
-- Table structure for table `beneficio`
--

DROP TABLE IF EXISTS `beneficio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `beneficio` (
  `nome_beneficio` varchar(30) NOT NULL,
  `tipo` varchar(30) NOT NULL,
  PRIMARY KEY (`nome_beneficio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `beneficio`
--

LOCK TABLES `beneficio` WRITE;
/*!40000 ALTER TABLE `beneficio` DISABLE KEYS */;
INSERT INTO `beneficio` VALUES ('Gympass','Saúde'),('Plano Dentário','Saúde'),('Vale Cultura','Lazer'),('vale transporte','locomoção');
/*!40000 ALTER TABLE `beneficio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empresa`
--

DROP TABLE IF EXISTS `empresa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empresa` (
  `nome_empresa_id` varchar(50) NOT NULL,
  `ramo_atividade` varchar(20) NOT NULL,
  `senha` varchar(20) NOT NULL,
  PRIMARY KEY (`nome_empresa_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empresa`
--

LOCK TABLES `empresa` WRITE;
/*!40000 ALTER TABLE `empresa` DISABLE KEYS */;
INSERT INTO `empresa` VALUES ('Apple','Tecnologia','12345'),('bradesco','financeiro','12345'),('GoldenBenefits','Gestão','12345'),('Hotel.com','Turístico','123'),('itau','financeiro','12345'),('PizzaTime','Alimenticio','123'),('Universidade ABC','educação','123');
/*!40000 ALTER TABLE `empresa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `funcionario` (
  `nome_funcionario_id` varchar(50) NOT NULL,
  `senha` varchar(20) NOT NULL,
  `fk_nome_empresa` varchar(50) DEFAULT NULL,
  `departamento` varchar(20) NOT NULL,
  `cargo` varchar(20) NOT NULL,
  PRIMARY KEY (`nome_funcionario_id`),
  KEY `fk_nome_empresa` (`fk_nome_empresa`),
  CONSTRAINT `funcionario_ibfk_1` FOREIGN KEY (`fk_nome_empresa`) REFERENCES `empresa` (`nome_empresa_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario`
--

LOCK TABLES `funcionario` WRITE;
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
INSERT INTO `funcionario` VALUES ('Gabriel','123','Goldenbenefits','Gestão','Administrador'),('Nicolas','123','pizzatime','administrativo','esp em beneficios');
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcionario_beneficio`
--

DROP TABLE IF EXISTS `funcionario_beneficio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `funcionario_beneficio` (
  `fk_nome_funcionario` varchar(50) NOT NULL,
  `fk_nome_beneficio` varchar(50) NOT NULL,
  `fk_nome_empresa` varchar(50) NOT NULL,
  `valor` decimal(10,2) NOT NULL,
  KEY `fk_nome_funcionario` (`fk_nome_funcionario`),
  KEY `fk_nome_beneficio` (`fk_nome_beneficio`),
  KEY `fk_nome_empresa` (`fk_nome_empresa`),
  CONSTRAINT `funcionario_beneficio_ibfk_1` FOREIGN KEY (`fk_nome_funcionario`) REFERENCES `funcionario` (`nome_funcionario_id`),
  CONSTRAINT `funcionario_beneficio_ibfk_2` FOREIGN KEY (`fk_nome_beneficio`) REFERENCES `beneficio` (`nome_beneficio`),
  CONSTRAINT `funcionario_beneficio_ibfk_3` FOREIGN KEY (`fk_nome_empresa`) REFERENCES `empresa` (`nome_empresa_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario_beneficio`
--

LOCK TABLES `funcionario_beneficio` WRITE;
/*!40000 ALTER TABLE `funcionario_beneficio` DISABLE KEYS */;
/*!40000 ALTER TABLE `funcionario_beneficio` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-03 17:15:41
