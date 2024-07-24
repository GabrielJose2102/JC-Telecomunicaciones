-- MariaDB dump 10.19  Distrib 10.4.24-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: sistema_jc_bd
-- ------------------------------------------------------
-- Server version	10.4.24-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `almacen`
--

DROP TABLE IF EXISTS `almacen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `almacen` (
  `codigo_almacen` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_almacen` varchar(45) NOT NULL,
  PRIMARY KEY (`codigo_almacen`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `almacen`
--

LOCK TABLES `almacen` WRITE;
/*!40000 ALTER TABLE `almacen` DISABLE KEYS */;
INSERT INTO `almacen` VALUES (1,'Verde'),(2,'Amarillo'),(3,'Rojo');
/*!40000 ALTER TABLE `almacen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clientejuridico`
--

DROP TABLE IF EXISTS `clientejuridico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clientejuridico` (
  `rif_empresa` varchar(150) NOT NULL,
  `nombre_empresa` varchar(145) NOT NULL,
  `tipo_cliente_id` int(11) NOT NULL,
  PRIMARY KEY (`rif_empresa`),
  KEY `fk_ClienteJuridico_TipoCliente1_idx` (`tipo_cliente_id`),
  CONSTRAINT `fk_ClienteJuridico_TipoCliente1` FOREIGN KEY (`tipo_cliente_id`) REFERENCES `tipocliente` (`id_tipo_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientejuridico`
--

LOCK TABLES `clientejuridico` WRITE;
/*!40000 ALTER TABLE `clientejuridico` DISABLE KEYS */;
INSERT INTO `clientejuridico` VALUES ('11','5',2),('J413158464','Local',2);
/*!40000 ALTER TABLE `clientejuridico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clientenatural`
--

DROP TABLE IF EXISTS `clientenatural`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clientenatural` (
  `ci_cliente` varchar(150) NOT NULL,
  `nombres_cliente` varchar(145) NOT NULL,
  `apellidos_cliente` varchar(145) NOT NULL,
  `tipo_cliente_id` int(11) NOT NULL,
  PRIMARY KEY (`ci_cliente`),
  KEY `fk_ClienteNatural_TipoCliente1_idx` (`tipo_cliente_id`),
  CONSTRAINT `fk_ClienteNatural_TipoCliente1` FOREIGN KEY (`tipo_cliente_id`) REFERENCES `tipocliente` (`id_tipo_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientenatural`
--

LOCK TABLES `clientenatural` WRITE;
/*!40000 ALTER TABLE `clientenatural` DISABLE KEYS */;
INSERT INTO `clientenatural` VALUES ('1','1','1',1),('2','2','2',1),('252525','pedro','perez',1),('25631456','Henry','Urtado',1),('256314587','Gustavo','Perez',1),('V31563214','Elvis','Torrez',1);
/*!40000 ALTER TABLE `clientenatural` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clientes` (
  `documento_cliente` varchar(150) NOT NULL,
  `direccion` varchar(145) NOT NULL,
  `telefono` varchar(45) NOT NULL,
  `correo` varchar(145) NOT NULL,
  `tipo_Cliente_id` int(11) NOT NULL,
  PRIMARY KEY (`documento_cliente`),
  KEY `fk_Clientes_TipoCliente1_idx` (`tipo_Cliente_id`),
  CONSTRAINT `fk_Clientes_TipoCliente1` FOREIGN KEY (`tipo_Cliente_id`) REFERENCES `tipocliente` (`id_tipo_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES ('1','1','1','1',1),('11','5','5','5',2),('2','2','2','2',1),('252525','iribarren','042451236985','pp_@gmail.com',1),('25631456','Lara','04245638899','CarlosAzustre@gmail.com',1),('256314587','Lara','042563158','dsaklsdlaj@gmail.com',1),('J413158464','Iribarren','1549984631','Local@gmail.com',2),('V31563214','Iribarren','04245913687','ElvisT@gmail.com',1);
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cuentausuario`
--

DROP TABLE IF EXISTS `cuentausuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cuentausuario` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_usuario` varchar(145) NOT NULL,
  `contraseña` varchar(45) NOT NULL,
  PRIMARY KEY (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cuentausuario`
--

LOCK TABLES `cuentausuario` WRITE;
/*!40000 ALTER TABLE `cuentausuario` DISABLE KEYS */;
INSERT INTO `cuentausuario` VALUES (1,'Gabriel2121','sistema1234'),(9,'usuario1','1234'),(10,'usuario2','1234'),(11,'usuario3','1234'),(12,'usuario4','1234'),(13,'Maria2323','1234'),(14,'Usuario1115','1234');
/*!40000 ALTER TABLE `cuentausuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalleventa`
--

DROP TABLE IF EXISTS `detalleventa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detalleventa` (
  `productos_codigo` int(11) NOT NULL,
  `ventas_codigo` int(11) NOT NULL,
  `unidades` int(11) NOT NULL,
  `importe` varchar(45) NOT NULL,
  PRIMARY KEY (`productos_codigo`,`ventas_codigo`),
  KEY `fk_Productos_has_Ventas_Ventas1_idx` (`ventas_codigo`),
  CONSTRAINT `fk_Productos_has_Ventas_Productos1` FOREIGN KEY (`productos_codigo`) REFERENCES `productos` (`id_producto`),
  CONSTRAINT `fk_Productos_has_Ventas_Ventas1` FOREIGN KEY (`ventas_codigo`) REFERENCES `ventas` (`id_ventas`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalleventa`
--

LOCK TABLES `detalleventa` WRITE;
/*!40000 ALTER TABLE `detalleventa` DISABLE KEYS */;
INSERT INTO `detalleventa` VALUES (8,8,5,'jhkhjkjkhjk');
/*!40000 ALTER TABLE `detalleventa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleados`
--

DROP TABLE IF EXISTS `empleados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `empleados` (
  `ci_empleado` varchar(45) NOT NULL,
  `nombres_empleado` varchar(145) NOT NULL,
  `apellidos_empleado` varchar(145) NOT NULL,
  `genero` varchar(45) NOT NULL,
  `direccion` varchar(145) NOT NULL,
  `telefono` varchar(45) NOT NULL,
  `correo` varchar(145) NOT NULL,
  PRIMARY KEY (`ci_empleado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleados`
--

LOCK TABLES `empleados` WRITE;
/*!40000 ALTER TABLE `empleados` DISABLE KEYS */;
INSERT INTO `empleados` VALUES ('1','1','1','1','1','1','1'),('19458637','Maria','perez','Femenino','Municipal','04125687496','Gmail'),('21566389','Yuliannys','Jimenez','Femenino','Prados de Occidentes','04246357819','Gmail'),('222222','jjjjjjjj','222222','Femenino','jjjjjjjjjj','222222','Gmail');
/*!40000 ALTER TABLE `empleados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `factura`
--

DROP TABLE IF EXISTS `factura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `factura` (
  `id_factura` int(11) NOT NULL AUTO_INCREMENT,
  `codigo_factura` varchar(45) NOT NULL,
  `subtotal` float NOT NULL,
  `total` float NOT NULL,
  `iva` float NOT NULL,
  `tipo_comprobante_id` int(11) NOT NULL,
  PRIMARY KEY (`id_factura`),
  KEY `fk_Factura_TipoComprobante1_idx` (`tipo_comprobante_id`),
  CONSTRAINT `fk_Factura_TipoComprobante1` FOREIGN KEY (`tipo_comprobante_id`) REFERENCES `tipocomprobante` (`codigo_tipo_comprobante`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `factura`
--

LOCK TABLES `factura` WRITE;
/*!40000 ALTER TABLE `factura` DISABLE KEYS */;
INSERT INTO `factura` VALUES (8,'11111111',1111110,11111100,1111110000,1);
/*!40000 ALTER TABLE `factura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productos`
--

DROP TABLE IF EXISTS `productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `productos` (
  `id_producto` int(11) NOT NULL AUTO_INCREMENT,
  `codigo_productos` varchar(45) NOT NULL,
  `nombre_producto` varchar(145) NOT NULL,
  `Descripcion` varchar(45) NOT NULL,
  `precio` float NOT NULL,
  `stock` int(45) NOT NULL,
  `Proveedor` varchar(150) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `fecha_registro` varchar(45) NOT NULL,
  `almacen` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id_producto`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos`
--

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` VALUES (8,'ppppppppppppp','ppppppppppppp','ppppppppppp',111111000,0,'ppppppppppp','ppppppppppppp',''),(14,'hg21','llaves','laves',25.5,50,'Ferreteria','25/03/2022',''),(15,'jl50','articulo','articulo',13.4,22,'Inversiones JJ','15/02/2023',''),(16,'UT14Ca28','UTP','Cable',36,50,'ppppppppppppp','14/2/2023','1000');
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedores`
--

DROP TABLE IF EXISTS `proveedores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `proveedores` (
  `documento_proveedor` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `direccion` varchar(145) NOT NULL,
  `telefono` varchar(45) NOT NULL,
  `correo` varchar(145) NOT NULL,
  `TipoProveedor_id_tipo_proveedor` int(11) NOT NULL,
  PRIMARY KEY (`documento_proveedor`),
  KEY `fk_Proveedores_TipoProveedor1_idx` (`TipoProveedor_id_tipo_proveedor`),
  CONSTRAINT `fk_Proveedores_TipoProveedor1` FOREIGN KEY (`TipoProveedor_id_tipo_proveedor`) REFERENCES `tipoproveedor` (`id_tipo_proveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedores`
--

LOCK TABLES `proveedores` WRITE;
/*!40000 ALTER TABLE `proveedores` DISABLE KEYS */;
INSERT INTO `proveedores` VALUES ('1','1','1','1',1),('10','4','4','4',2),('11','5','5','5',2),('4','4','4','4',1),('6','6','6','6',1),('7','1','1','1',2);
/*!40000 ALTER TABLE `proveedores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedorjuridico`
--

DROP TABLE IF EXISTS `proveedorjuridico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `proveedorjuridico` (
  `rif_proveedor` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `nombre_empresa` varchar(145) NOT NULL,
  `TipoProveedor_id_tipo_proveedor` int(11) NOT NULL,
  PRIMARY KEY (`rif_proveedor`),
  KEY `fk_ProveedorJuridico_TipoProveedor1_idx` (`TipoProveedor_id_tipo_proveedor`),
  CONSTRAINT `fk_ProveedorJuridico_TipoProveedor1` FOREIGN KEY (`TipoProveedor_id_tipo_proveedor`) REFERENCES `tipoproveedor` (`id_tipo_proveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedorjuridico`
--

LOCK TABLES `proveedorjuridico` WRITE;
/*!40000 ALTER TABLE `proveedorjuridico` DISABLE KEYS */;
INSERT INTO `proveedorjuridico` VALUES ('10','4',2),('11','5',2),('7','1',2);
/*!40000 ALTER TABLE `proveedorjuridico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedornatural`
--

DROP TABLE IF EXISTS `proveedornatural`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `proveedornatural` (
  `ci_proveedor` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `nombre_proveedor` varchar(145) NOT NULL,
  `apellidos_proveedor` varchar(145) NOT NULL,
  `TipoProveedor_id_tipo_proveedor` int(11) NOT NULL,
  PRIMARY KEY (`ci_proveedor`),
  KEY `fk_ProveedorNatural_TipoProveedor1_idx` (`TipoProveedor_id_tipo_proveedor`),
  CONSTRAINT `fk_ProveedorNatural_TipoProveedor1` FOREIGN KEY (`TipoProveedor_id_tipo_proveedor`) REFERENCES `tipoproveedor` (`id_tipo_proveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedornatural`
--

LOCK TABLES `proveedornatural` WRITE;
/*!40000 ALTER TABLE `proveedornatural` DISABLE KEYS */;
INSERT INTO `proveedornatural` VALUES ('4','4','4',1),('6','6','6',1);
/*!40000 ALTER TABLE `proveedornatural` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recibo`
--

DROP TABLE IF EXISTS `recibo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recibo` (
  `id_recibo` int(11) NOT NULL AUTO_INCREMENT,
  `codigo_recibo` varchar(45) NOT NULL,
  `total` float NOT NULL,
  `tipo_comprobante_id` int(11) NOT NULL,
  PRIMARY KEY (`id_recibo`),
  KEY `fk_Recibo_TipoComprobante1_idx` (`tipo_comprobante_id`),
  CONSTRAINT `fk_Recibo_TipoComprobante1` FOREIGN KEY (`tipo_comprobante_id`) REFERENCES `tipocomprobante` (`codigo_tipo_comprobante`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recibo`
--

LOCK TABLES `recibo` WRITE;
/*!40000 ALTER TABLE `recibo` DISABLE KEYS */;
INSERT INTO `recibo` VALUES (8,'453453',45353,2);
/*!40000 ALTER TABLE `recibo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipocliente`
--

DROP TABLE IF EXISTS `tipocliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipocliente` (
  `id_tipo_cliente` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_tipo_cliente` varchar(45) NOT NULL,
  PRIMARY KEY (`id_tipo_cliente`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipocliente`
--

LOCK TABLES `tipocliente` WRITE;
/*!40000 ALTER TABLE `tipocliente` DISABLE KEYS */;
INSERT INTO `tipocliente` VALUES (1,'Cliente Natural'),(2,'Cliente Juridico');
/*!40000 ALTER TABLE `tipocliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipocomprobante`
--

DROP TABLE IF EXISTS `tipocomprobante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipocomprobante` (
  `codigo_tipo_comprobante` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_comprobantecol` varchar(145) NOT NULL,
  PRIMARY KEY (`codigo_tipo_comprobante`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipocomprobante`
--

LOCK TABLES `tipocomprobante` WRITE;
/*!40000 ALTER TABLE `tipocomprobante` DISABLE KEYS */;
INSERT INTO `tipocomprobante` VALUES (1,'Factura'),(2,'Recibo');
/*!40000 ALTER TABLE `tipocomprobante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipoproveedor`
--

DROP TABLE IF EXISTS `tipoproveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipoproveedor` (
  `id_tipo_proveedor` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_tipo_proveedor` varchar(45) NOT NULL,
  PRIMARY KEY (`id_tipo_proveedor`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipoproveedor`
--

LOCK TABLES `tipoproveedor` WRITE;
/*!40000 ALTER TABLE `tipoproveedor` DISABLE KEYS */;
INSERT INTO `tipoproveedor` VALUES (1,'Proveedor Natural'),(2,'Proveedor Juridico');
/*!40000 ALTER TABLE `tipoproveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipoturno`
--

DROP TABLE IF EXISTS `tipoturno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipoturno` (
  `id_tipo_turno` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_turno` varchar(45) NOT NULL,
  PRIMARY KEY (`id_tipo_turno`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipoturno`
--

LOCK TABLES `tipoturno` WRITE;
/*!40000 ALTER TABLE `tipoturno` DISABLE KEYS */;
INSERT INTO `tipoturno` VALUES (1,'Turno Mañana'),(2,'Turno Tarde');
/*!40000 ALTER TABLE `tipoturno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ventas`
--

DROP TABLE IF EXISTS `ventas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ventas` (
  `id_ventas` int(11) NOT NULL AUTO_INCREMENT,
  `codigo_venta` varchar(45) NOT NULL,
  `fecha_emitida` varchar(45) NOT NULL,
  `hora_emitida` varchar(45) NOT NULL,
  `producto` varchar(75) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `clientes_id` varchar(150) NOT NULL,
  `empleados_id` varchar(150) NOT NULL,
  `tipo_comprobante_id` varchar(150) NOT NULL,
  `monto` int(75) NOT NULL,
  PRIMARY KEY (`id_ventas`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ventas`
--

LOCK TABLES `ventas` WRITE;
/*!40000 ALTER TABLE `ventas` DISABLE KEYS */;
INSERT INTO `ventas` VALUES (15,'2563','12/02/2023','4:25:06','UTP','252525','21566389','1',0),(16,'hg21','14 / 2 / 2023','16:26:1','llaves','253164878','','Comprobante Generado',200),(17,'hg21','14 / 2 / 2023','16:56:30','llaves','256314897','','Comprobante Generado',175),(18,'UT14Ca28','14 / 2 / 2023','17:41:29','UTP','25613485','','Comprobante Generado',36),(19,'UT14Ca28','14 / 2 / 2023','18:38:43','UTP','1','','Comprobante Generado',180),(21,'jl50','14 / 2 / 2023','18:46:36','articulo','V31563214','','Comprobante Generado',1250),(24,'UT14Ca28','14 / 2 / 2023','19:7:51','UTP','256314587','','Comprobante Generado',1000),(25,'UT14Ca28','14 / 2 / 2023','19:7:51','UTP','256314587','','Comprobante Generado',1000),(26,'jl50','14 / 2 / 2023','19:7:51','articulo','25631456','','Comprobante Generado',1000),(27,'UT14Ca28','14 / 2 / 2023','19:10:13','UTP','V31563214','','Comprobante Generado',1050),(28,'UT14Ca28','14 / 2 / 2023','19:11:10','UTP','256314587','','Comprobante Generado',450),(29,'UT14Ca28','14 / 2 / 2023','19:11:10','UTP','256314587','','Comprobante Generado',450),(30,'jl50','14 / 2 / 2023','19:39:43','articulo','V31563214','','Confirmado',500);
/*!40000 ALTER TABLE `ventas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-14 23:17:07
