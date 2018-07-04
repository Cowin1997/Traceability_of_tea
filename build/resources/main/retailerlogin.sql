/*
Navicat MySQL Data Transfer

Source Server         : factorylogin
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2018-07-04 12:43:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for retailerlogin
-- ----------------------------
DROP TABLE IF EXISTS `retailerlogin`;
CREATE TABLE `retailerlogin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(25) NOT NULL,
  `password` varchar(25) NOT NULL,
  `email` varchar(255) NOT NULL,
  `retailername` varchar(255) NOT NULL,
  `retaileraddr` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of retailerlogin
-- ----------------------------
INSERT INTO `retailerlogin` VALUES ('1', '123456', '123456', '3838438@163.com', '徐冰涛专卖店', '凤5C507');
INSERT INTO `retailerlogin` VALUES ('2', '123457', '123456', '3838438@163.com', '徐冰涛专卖店', '凤5C506');
INSERT INTO `retailerlogin` VALUES ('3', '666666', '123456', '6666666@163.com', '零售商###', '厦门市###');
INSERT INTO `retailerlogin` VALUES ('4', '444444', '123456', '44444@163.com', '41444', '444呃呃呃呃呃');
INSERT INTO `retailerlogin` VALUES ('5', '6666666', '123456', '123456789@163.com', '李四茶叶专卖点', '厦门市集美区石鼓路#323');
