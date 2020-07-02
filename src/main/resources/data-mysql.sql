DROP TABLE IF EXISTS `person`;
CREATE TABLE `person` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(60) DEFAULT NULL,
  `last_name` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ;

BEGIN;
INSERT INTO `person` VALUES (1, 'Robert', 'Smith');
INSERT INTO `person` VALUES (2, '马', '江林');
INSERT INTO `person` VALUES (2, '乔治哥', NULL);
COMMIT;




DROP TABLE IF EXISTS `author`;
CREATE TABLE `author` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `age` int(11) NOT NULL,
  `genre` varchar(255) NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ;

BEGIN;
INSERT INTO `author` VALUES (1, 23, 'Anthology', 'Mark Janel');
INSERT INTO `author` VALUES (2, 43, 'Horror', 'Olivia Goy');
INSERT INTO `author` VALUES (3, 51, 'Anthology', 'Quartis Young');
INSERT INTO `author` VALUES (4, 34, 'History', 'Joana Nimar');
INSERT INTO `author` VALUES (5, 38, 'Anthology', 'Alicia Tom');
INSERT INTO `author` VALUES (6, 56, 'Anthology', 'Katy Loin');
COMMIT;


DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(60) NOT NULL,
  `isbn` varchar(60) NOT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `author_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ;

BEGIN;
INSERT INTO `book` VALUES (1, 'A History of Ancient Prague', '001-JN', NULL, 4);
INSERT INTO `book` VALUES (2, 'A Peoples History', '002-JN', NULL, 4);
INSERT INTO `book` VALUES (3, 'The Beatles Anthology', '001-MJ', NULL, 1);
INSERT INTO `book` VALUES (4, 'Carrie', '001-OG', NULL, 2);
COMMIT;