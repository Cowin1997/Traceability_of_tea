/*
Navicat MySQL Data Transfer

Source Server         : factorylogin
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2018-07-04 12:42:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for factorylogin
-- ----------------------------
DROP TABLE IF EXISTS `factorylogin`;
CREATE TABLE `factorylogin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(25) NOT NULL,
  `password` varchar(25) NOT NULL,
  `email` varchar(50) NOT NULL,
  `facname` varchar(50) NOT NULL,
  `facaddr` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of factorylogin
-- ----------------------------
INSERT INTO `factorylogin` VALUES ('1', '123456', '123456', '1134956893@qq.com', 'HuaQiaoUniversity', 'JiMeiRoad#668');
INSERT INTO `factorylogin` VALUES ('2', '888888', '888888', '1134956893@qq.com', '华侨大学凤凰苑507', '集美大道668号');
INSERT INTO `factorylogin` VALUES ('3', '19970821', '888888', '123456789@163.com', '华侨大学凤凰苑506', '集美大道668号');
INSERT INTO `factorylogin` VALUES ('4', '666666', '123456', '123456789@163.com', '泉州茶叶公司', '泉州市####');
