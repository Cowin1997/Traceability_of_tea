/*
Navicat MySQL Data Transfer

Source Server         : factorylogin
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2018-07-04 12:43:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for retailerprod
-- ----------------------------
DROP TABLE IF EXISTS `retailerprod`;
CREATE TABLE `retailerprod` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `proid` varchar(255) NOT NULL,
  `detailid` varchar(255) NOT NULL,
  `proname` varchar(255) NOT NULL,
  `proaddr` varchar(255) NOT NULL,
  `status` varchar(255) NOT NULL,
  `datein` date NOT NULL,
  `datesell` varchar(255) DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=106 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of retailerprod
-- ----------------------------
INSERT INTO `retailerprod` VALUES ('96', '123456', '201806181625104810', '201806181625106159', '铁观音#233', '福建省厦门市开元区莲前东路云香实业综合楼 ', '已出售', '2018-06-18', '2018-06-18');
INSERT INTO `retailerprod` VALUES ('97', '123456', '201806181625104810', '201806181625106838', '铁观音#233', '福建省厦门市开元区莲前东路云香实业综合楼 ', '已出售', '2018-06-18', '2018-06-18');
INSERT INTO `retailerprod` VALUES ('98', '123456', '201806181625104810', '201806181625105903', '铁观音#233', '福建省厦门市开元区莲前东路云香实业综合楼 ', '未出售', '2018-06-18', '0000-00-00');
INSERT INTO `retailerprod` VALUES ('99', '123456', '201806181625104810', '201806181625101703', '铁观音#233', '福建省厦门市开元区莲前东路云香实业综合楼 ', '未出售', '2018-06-18', '0000-00-00');
INSERT INTO `retailerprod` VALUES ('100', '123456', '201806181625104810', '201806181625107558', '铁观音#233', '福建省厦门市开元区莲前东路云香实业综合楼 ', '未出售', '2018-06-18', '0000-00-00');
INSERT INTO `retailerprod` VALUES ('101', '123456', '201806181625104810', '201806181625100197', '铁观音#233', '福建省厦门市开元区莲前东路云香实业综合楼 ', '未出售', '2018-06-18', '0000-00-00');
INSERT INTO `retailerprod` VALUES ('102', '123456', '201806181625104810', '201806181625109857', '铁观音#233', '福建省厦门市开元区莲前东路云香实业综合楼 ', '未出售', '2018-06-18', '0000-00-00');
INSERT INTO `retailerprod` VALUES ('103', '123456', '201806181625104810', '201806181625106398', '铁观音#233', '福建省厦门市开元区莲前东路云香实业综合楼 ', '未出售', '2018-06-18', '0000-00-00');
INSERT INTO `retailerprod` VALUES ('104', '123456', '201806181625104810', '201806181625104759', '铁观音#233', '福建省厦门市开元区莲前东路云香实业综合楼 ', '未出售', '2018-06-18', '0000-00-00');
INSERT INTO `retailerprod` VALUES ('105', '123456', '201806181625104810', '201806181625109188', '铁观音#233', '福建省厦门市开元区莲前东路云香实业综合楼 ', '未出售', '2018-06-18', '0000-00-00');
