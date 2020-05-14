SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `customer`
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `cust_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `cust_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`cust_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- ----------------------------
--  Records of `customer`
-- ----------------------------
BEGIN;
INSERT INTO `customer` VALUES ('1', 'West');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;