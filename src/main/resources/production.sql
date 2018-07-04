/*
Navicat MySQL Data Transfer

Source Server         : factorylogin
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2018-07-04 12:42:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for production
-- ----------------------------
DROP TABLE IF EXISTS `production`;
CREATE TABLE `production` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `proid` varchar(255) NOT NULL,
  `auth` varchar(255) NOT NULL,
  `facname` varchar(255) NOT NULL,
  `facaddr` varchar(255) NOT NULL,
  `proname` varchar(255) NOT NULL,
  `status` varchar(5) NOT NULL,
  `date` varchar(25) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=115 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of production
-- ----------------------------
INSERT INTO `production` VALUES ('113', '123456', '201806181625104810', '张三', '厦门市云香茶厂', '福建省厦门市开元区莲前东路云香实业综合楼 ', '铁观音#233', '已出售', '2018-06-18');
INSERT INTO `production` VALUES ('114', '123456', '201806191657304038', '李四', '厦门市云香茶厂		', '福建省厦门市开元区莲前东路云香实业综合楼', '铁观音#123456', '未出售', '2018-06-19');
