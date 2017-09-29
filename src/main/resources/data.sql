use drivermanagementdb;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;

LOCK TABLES `country` WRITE;
/*!40000 ALTER TABLE `country` DISABLE KEYS */;
INSERT INTO `country` (idcountry, name) VALUES (1,'United States');
/*!40000 ALTER TABLE `country` ENABLE KEYS */;
UNLOCK TABLES;

LOCK TABLES `state` WRITE;
/*!40000 ALTER TABLE `state` DISABLE KEYS */;
INSERT INTO `state` (idstate, idcountry, name, abbreviation) VALUES (1,1,'Alabama','AL'),(2,1,'Alaska','AK'),(3,1,'Arizona','AZ'),(4,1,'Arkansas','AR'),(5,1,'California','CA'),(6,1,'Colorado','CO'),(7,1,'Connecticut','CT'),(8,1,'Delaware','DE'),(9,1,'Florida','FL'),(10,1,'Georgia','GA'),(11,1,'Hawaii','HI'),(12,1,'Idaho','ID'),(13,1,'Illinois','IL'),(14,1,'Indiana','IN'),(15,1,'Iowa','IA'),(16,1,'Kansas','KS'),(17,1,'Kentucky','KY'),(18,1,'Louisiana','LA'),(19,1,'Maine','ME'),(20,1,'Maryland','MD'),(21,1,'Massachusetts','MA'),(22,1,'Michigan','MI'),(23,1,'Minnesota','MN'),(24,1,'Mississippi','MS'),(25,1,'Missouri','MO'),(26,1,'Montana','MT'),(27,1,'Nebraska','NE'),(28,1,'Nevada','NV'),(29,1,'New Hampshire','NH'),(30,1,'New Jersey','NJ'),(31,1,'New Mexico','NM'),(32,1,'New York','NY'),(33,1,'North Carolina','NC'),(34,1,'North Dakota','ND'),(35,1,'Ohio','OH'),(36,1,'Oklahoma','OK'),(37,1,'Oregon','OR'),(38,1,'Pennsylvania','PA'),(39,1,'Rhode Island','RI'),(40,1,'South Carolina','SC'),(41,1,'South Dakota','SD'),(42,1,'Tennessee','TN'),(43,1,'Texas','TX'),(44,1,'Utah','UT'),(45,1,'Vermont','VT'),(46,1,'Virginia','VA'),(47,1,'Washington','WA'),(48,1,'West Virginia','WV'),(49,1,'Wisconsin','WI'),(50,1,'Wyoming','WY'),(51,1,'District of Columbia','DC'),(52,1,'American Samoa','AS'),(53,1,'Guam','GU'),(54,1,'Northern Mariana Islands','MP'),(55,1,'Puerto Rico','PR'),(56,1,'United States Minor Outlying Islands','UM'),(57,1,'Virgin Islands, U.S.','VI');
/*!40000 ALTER TABLE `state` ENABLE KEYS */;
UNLOCK TABLES;

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` (idstate, name) VALUES (9,'Miami'),(9,'Weston');
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;

LOCK TABLES `driver` WRITE;
/*!40000 ALTER TABLE `driver` DISABLE KEYS */;
INSERT INTO `driver` (idcity, fname, lname, username, password, email, last_location_lat, last_location_lon, address, phone, active) VALUES (2,'Jon','Snow','jonsnow','jonsnow','jusoto@gmail.com',26.089545,-80.367062,'2250 N Commerce Pkwy','7867734490',1);
/*!40000 ALTER TABLE `driver` ENABLE KEYS */;
UNLOCK TABLES;

LOCK TABLES `driver_state` WRITE;
/*!40000 ALTER TABLE `driver_state` DISABLE KEYS */;
INSERT INTO `driver_state` (name, description) VALUES ('Active',NULL),('Disabled',NULL),('Available',NULL),('Busy',NULL),('Not Available',NULL);
/*!40000 ALTER TABLE `driver_state` ENABLE KEYS */;
UNLOCK TABLES;

LOCK TABLES `car_making` WRITE;
/*!40000 ALTER TABLE `car_making` DISABLE KEYS */;
INSERT INTO `car_making` (name) VALUES ('Nissan');
/*!40000 ALTER TABLE `car_making` ENABLE KEYS */;
UNLOCK TABLES;

LOCK TABLES `car_model` WRITE;
/*!40000 ALTER TABLE `car_model` DISABLE KEYS */;
INSERT INTO `car_model` (idcar_making, name) VALUES (1, "Sentra SV");
/*!40000 ALTER TABLE `car_model` ENABLE KEYS */;
UNLOCK TABLES;

LOCK TABLES `car` WRITE;
/*!40000 ALTER TABLE `car` DISABLE KEYS */;
INSERT INTO `car` (idcar, idcar_model, iddriver, idstate, plate, year) VALUES (1, 1, 1, 9, 'HVCC26', '2017');
/*!40000 ALTER TABLE `car` ENABLE KEYS */;
UNLOCK TABLES;

LOCK TABLES `has_driver_state` WRITE;
/*!40000 ALTER TABLE `has_driver_state` DISABLE KEYS */;
INSERT INTO `has_driver_state` (iddriver, iddriver_state, idcar, creation_date) VALUES (1, 1, 1,'2017-09-01 15:00:00');
/*!40000 ALTER TABLE `has_driver_state` ENABLE KEYS */;
UNLOCK TABLES;

/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;