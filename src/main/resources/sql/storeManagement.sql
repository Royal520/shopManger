/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80033 (8.0.33-0ubuntu0.22.04.2)
 Source Host           : localhost:3306
 Source Schema         : storeManagement

 Target Server Type    : MySQL
 Target Server Version : 80033 (8.0.33-0ubuntu0.22.04.2)
 File Encoding         : 65001

 Date: 28/06/2023 15:31:49
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ledger
-- ----------------------------
DROP TABLE IF EXISTS `ledger`;
CREATE TABLE `ledger` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `product_id` int NOT NULL,
  `sku_id` int NOT NULL,
  `store_id` int NOT NULL,
  `num` int NOT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of ledger
-- ----------------------------
BEGIN;
INSERT INTO `ledger` (`id`, `product_id`, `sku_id`, `store_id`, `num`, `create_time`) VALUES (1, 2, 1, 1, 2, NULL);
INSERT INTO `ledger` (`id`, `product_id`, `sku_id`, `store_id`, `num`, `create_time`) VALUES (6, 2, 1, 1, -1, NULL);
COMMIT;

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `id` int NOT NULL AUTO_INCREMENT,
  `text` text,
  `create_time` datetime DEFAULT NULL,
  `status` int DEFAULT NULL,
  `to_id` int DEFAULT NULL,
  `read_time` datetime DEFAULT NULL,
  `ledger_id` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1350754306 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of message
-- ----------------------------
BEGIN;
INSERT INTO `message` (`id`, `text`, `create_time`, `status`, `to_id`, `read_time`, `ledger_id`) VALUES (1350754305, NULL, '2023-06-28 07:07:59', 0, 1, NULL, 6);
COMMIT;

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL COMMENT '标题',
  `minimum_price` decimal(10,2) DEFAULT NULL,
  `maximum_price` decimal(10,2) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `sort` int DEFAULT NULL,
  `intro` text,
  `status` int DEFAULT NULL COMMENT '状态 -1=>下架,1=>上架,2=>预售,0=>未上架',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of product
-- ----------------------------
BEGIN;
INSERT INTO `product` (`id`, `name`, `minimum_price`, `maximum_price`, `create_time`, `update_time`, `sort`, `intro`, `status`) VALUES (2, 'iphone11', 29.00, 51.00, '2023-06-27 22:51:01', '2023-06-27 22:51:01', 89, 'ut', 0);
INSERT INTO `product` (`id`, `name`, `minimum_price`, `maximum_price`, `create_time`, `update_time`, `sort`, `intro`, `status`) VALUES (3, '清于群记当往', 75.00, 94.00, '2023-06-27 22:51:04', '2023-06-27 22:51:04', 27, 'laborum in consectetur do', 0);
INSERT INTO `product` (`id`, `name`, `minimum_price`, `maximum_price`, `create_time`, `update_time`, `sort`, `intro`, `status`) VALUES (4, '制方亲实美', 11.00, 52.00, '2023-06-27 22:51:06', '2023-06-27 22:51:06', 21, 'cupidatat sit', 0);
INSERT INTO `product` (`id`, `name`, `minimum_price`, `maximum_price`, `create_time`, `update_time`, `sort`, `intro`, `status`) VALUES (5, '制方亲实美', 11.00, 52.00, '2023-06-27 22:51:08', '2023-06-27 22:51:08', 21, 'cupidatat sit', 0);
INSERT INTO `product` (`id`, `name`, `minimum_price`, `maximum_price`, `create_time`, `update_time`, `sort`, `intro`, `status`) VALUES (6, '制方亲实美', 11.00, 52.00, '2023-06-27 22:51:11', '2023-06-27 22:51:11', 21, 'cupidatat sit', 0);
INSERT INTO `product` (`id`, `name`, `minimum_price`, `maximum_price`, `create_time`, `update_time`, `sort`, `intro`, `status`) VALUES (7, '建究法须天', 8.00, 34.00, '2007-07-20 06:28:23', NULL, 29, 'mollit', 0);
INSERT INTO `product` (`id`, `name`, `minimum_price`, `maximum_price`, `create_time`, `update_time`, `sort`, `intro`, `status`) VALUES (8, '建究法须天', 8.00, 34.00, '2007-07-20 06:28:23', NULL, 29, 'mollit', 0);
INSERT INTO `product` (`id`, `name`, `minimum_price`, `maximum_price`, `create_time`, `update_time`, `sort`, `intro`, `status`) VALUES (9, '子代先铁有', 55.00, 37.00, '2023-06-27 22:51:14', '2023-06-27 22:51:14', 11, 'qui dolore', 0);
INSERT INTO `product` (`id`, `name`, `minimum_price`, `maximum_price`, `create_time`, `update_time`, `sort`, `intro`, `status`) VALUES (10, '发八华马段', 10.00, 9.00, '2023-06-27 22:51:16', '2023-06-27 22:51:16', 63, 'qui culpa dolor minim', 0);
INSERT INTO `product` (`id`, `name`, `minimum_price`, `maximum_price`, `create_time`, `update_time`, `sort`, `intro`, `status`) VALUES (11, '火织天', 59.00, 40.00, '2023-06-27 22:51:19', '2023-06-27 22:51:19', 60, 'ipsum commodo cupidatat dolore', 0);
COMMIT;

-- ----------------------------
-- Table structure for product_sku
-- ----------------------------
DROP TABLE IF EXISTS `product_sku`;
CREATE TABLE `product_sku` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `product_id` int NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `img` varchar(255) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `status` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of product_sku
-- ----------------------------
BEGIN;
INSERT INTO `product_sku` (`id`, `product_id`, `name`, `img`, `price`, `status`) VALUES (1, 2, '白色', 'http://dummyimage.com/400x400', 5500.00, 0);
INSERT INTO `product_sku` (`id`, `product_id`, `name`, `img`, `price`, `status`) VALUES (2, 2, '粉色', 'http://dummyimage.com/400x400', 6000.00, 0);
INSERT INTO `product_sku` (`id`, `product_id`, `name`, `img`, `price`, `status`) VALUES (3, 3, 'M', NULL, 50.00, 0);
COMMIT;

-- ----------------------------
-- Table structure for stock
-- ----------------------------
DROP TABLE IF EXISTS `stock`;
CREATE TABLE `stock` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `product_id` int NOT NULL COMMENT '商品id',
  `sku_id` int NOT NULL COMMENT '规格id',
  `store_id` int NOT NULL COMMENT '仓库id',
  `stock_num` int DEFAULT NULL COMMENT '库存',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=528666626 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of stock
-- ----------------------------
BEGIN;
INSERT INTO `stock` (`id`, `product_id`, `sku_id`, `store_id`, `stock_num`) VALUES (1, 2, 1, 1, 10);
INSERT INTO `stock` (`id`, `product_id`, `sku_id`, `store_id`, `stock_num`) VALUES (2, 2, 2, 2, 10);
COMMIT;

-- ----------------------------
-- Table structure for store
-- ----------------------------
DROP TABLE IF EXISTS `store`;
CREATE TABLE `store` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of store
-- ----------------------------
BEGIN;
INSERT INTO `store` (`id`, `name`, `address`) VALUES (1, '武汉', '湖北大学');
INSERT INTO `store` (`id`, `name`, `address`) VALUES (2, '咸宁', '鄂南高中');
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `status` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
