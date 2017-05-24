/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : product

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2017-05-24 18:47:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `cate`
-- ----------------------------
DROP TABLE IF EXISTS `cate`;
CREATE TABLE `cate` (
  `cateId` int(11) NOT NULL AUTO_INCREMENT,
  `catename` varchar(255) DEFAULT NULL,
  `parentId` int(11) NOT NULL,
  PRIMARY KEY (`cateId`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cate
-- ----------------------------
INSERT INTO `cate` VALUES ('1', 'entity', '-1');
INSERT INTO `cate` VALUES ('2', 'virtual', '-1');
INSERT INTO `cate` VALUES ('3', 'Electronic', '1');
INSERT INTO `cate` VALUES ('4', 'Book', '1');
INSERT INTO `cate` VALUES ('5', 'Computer', '3');
INSERT INTO `cate` VALUES ('6', 'TV', '3');
INSERT INTO `cate` VALUES ('7', 'Laptop', '5');
INSERT INTO `cate` VALUES ('8', 'MacBook', '7');
INSERT INTO `cate` VALUES ('9', 'Lenovo', '7');

-- ----------------------------
-- Table structure for `product`
-- ----------------------------
DROP TABLE IF EXISTS `products`;
CREATE TABLE `products` (
  `productId` int(11) NOT NULL,
  `productname` varchar(255) DEFAULT NULL,
  `productprice` int(11) DEFAULT NULL,
  `cateId` int(11) DEFAULT NULL,
  PRIMARY KEY (`productId`),
  KEY `cateId` (`cateId`),
  CONSTRAINT `cateId` FOREIGN KEY (`cateId`) REFERENCES `cate` (`cateId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of products
-- ----------------------------
INSERT INTO `products` VALUES ('1', 'Apple MacBook Air', '10000', '7');
INSERT INTO `products` VALUES ('2', 'Millet TV', '3000', '6');
