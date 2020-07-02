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
