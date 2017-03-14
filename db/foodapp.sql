/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 50711
 Source Host           : localhost
 Source Database       : foodapp

 Target Server Type    : MySQL
 Target Server Version : 50711
 File Encoding         : utf-8

 Date: 03/14/2017 17:39:57 PM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `DATABASECHANGELOG`
-- ----------------------------
DROP TABLE IF EXISTS `DATABASECHANGELOG`;
CREATE TABLE `DATABASECHANGELOG` (
  `ID`            VARCHAR(255) NOT NULL,
  `AUTHOR`        VARCHAR(255) NOT NULL,
  `FILENAME`      VARCHAR(255) NOT NULL,
  `DATEEXECUTED`  DATETIME     NOT NULL,
  `ORDEREXECUTED` INT(11)      NOT NULL,
  `EXECTYPE`      VARCHAR(10)  NOT NULL,
  `MD5SUM`        VARCHAR(35)  DEFAULT NULL,
  `DESCRIPTION`   VARCHAR(255) DEFAULT NULL,
  `COMMENTS`      VARCHAR(255) DEFAULT NULL,
  `TAG`           VARCHAR(255) DEFAULT NULL,
  `LIQUIBASE`     VARCHAR(20)  DEFAULT NULL,
  `CONTEXTS`      VARCHAR(255) DEFAULT NULL,
  `LABELS`        VARCHAR(255) DEFAULT NULL,
  `DEPLOYMENT_ID` VARCHAR(10)  DEFAULT NULL
)
  ENGINE = InnoDB
  DEFAULT CHARSET = latin1;

-- ----------------------------
--  Records of `DATABASECHANGELOG`
-- ----------------------------
BEGIN;
INSERT INTO `DATABASECHANGELOG` VALUES
  ('1', 'root', 'data/changelog/db.changelog-0.1.0.xml', '2017-03-10 15:43:02', '1', 'EXECUTED',
        '7:4fb25664170773452fff344f888fa059',
        'createTable tableName=user; createTable tableName=order_status; createTable tableName=food_category; createTable tableName=food; createTable tableName=order; createTable tableName=history; createTable tableName=order_info',
        '', NULL, '3.5.3', NULL, NULL, '9153382754'),
  ('2', 'root', 'data/changelog/db.changelog-0.1.0.xml', '2017-03-10 15:43:02', '2', 'EXECUTED',
        '7:39ed41d9d4998767968d897c48c34a65',
        'insert tableName=user; insert tableName=user; insert tableName=food_category; insert tableName=food_category; insert tableName=food_category; insert tableName=food_category; insert tableName=food; insert tableName=food; insert tableName=food; inse...',
        '', NULL, '3.5.3', NULL, NULL, '9153382754');
COMMIT;

-- ----------------------------
--  Table structure for `DATABASECHANGELOGLOCK`
-- ----------------------------
DROP TABLE IF EXISTS `DATABASECHANGELOGLOCK`;
CREATE TABLE `DATABASECHANGELOGLOCK` (
  `ID`          INT(11) NOT NULL,
  `LOCKED`      BIT(1)  NOT NULL,
  `LOCKGRANTED` DATETIME     DEFAULT NULL,
  `LOCKEDBY`    VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = latin1;

-- ----------------------------
--  Records of `DATABASECHANGELOGLOCK`
-- ----------------------------
BEGIN;
INSERT INTO `DATABASECHANGELOGLOCK` VALUES ('1', b'0', NULL, NULL);
COMMIT;

-- ----------------------------
--  Table structure for `food`
-- ----------------------------
DROP TABLE IF EXISTS `food`;
CREATE TABLE `food` (
  `id`          BIGINT(20) NOT NULL AUTO_INCREMENT,
  `category_id` BIGINT(20) NOT NULL,
  `title`       VARCHAR(45)         DEFAULT NULL,
  `description` VARCHAR(500)        DEFAULT NULL,
  `calories`    VARCHAR(45)         DEFAULT NULL,
  `ingredients` VARCHAR(200)        DEFAULT NULL,
  `weight`      VARCHAR(45)         DEFAULT NULL,
  `price`       VARCHAR(45)         DEFAULT NULL,
  `image_link`  VARCHAR(100)        DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_food_2_food_category` (`category_id`),
  CONSTRAINT `fk_food_2_food_category` FOREIGN KEY (`category_id`) REFERENCES `food_category` (`id`)
    ON DELETE CASCADE
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 13
  DEFAULT CHARSET = latin1;

-- ----------------------------
--  Records of `food`
-- ----------------------------
BEGIN;
INSERT INTO `food` VALUES ('1', '1', 'Cream of Chicken with Wild Rice',
                           'Pulled chicken, wild rice and fresh mushrooms in creamy deliciousness. Offered with an optional topping of green onions.',
                           '450', 'Pulled chicken, wild rice and fresh mushrooms', '300', '65',
                           'https://image.ibb.co/jLrNfa/Cream_of_Chicken_with_Wild_Rice1.jpg'),
  ('2', '1', 'Housemade Lentil Soup', 'Made from scratch daily with slow-cooked lentils, vegetables and herbs, topped with a spoonful of our spiced crema.', '400', 'lentils, vegetables and herbs', '350', '56', 'https://image.ibb.co/fO32fa/Housemade_Lentil_Soup1.jpg'),
  ('3', '1', 'Tuscan Vegetable', 'VEGAN. A delicious array of zucchini, eggplant, spinach, tomatoes, green beans and yukon potatoes in a vegetable broth with garlic and fresh basil. Offered with an optional topping of basil.', '500', 'array of zucchini, eggplant, spinach, tomatoes, green beans and yukon potatoes', '400', '68', 'https://image.ibb.co/kxADka/Tuscan_Vegetable.jpg'),
  ('4', '2', 'Alfredo', 'Your choice of spaghetti, fettuccine or penne, served with crispy bacon, ham and brown mushrooms in a rich, cream-based sauce.', '450', 'spaghetti, fettuccine , brown mushrooms etc', '300', '55', 'https://image.ibb.co/iNz8La/Alfredo1.jpg'),
  ('5', '2', 'Chicken Capricciosa', 'Your choice of spaghetti, fettuccine or penne, served with oven-roasted chicken, assorted peppers and brown mushrooms in a cream-based sauce.', '500', 'spaghetti, fettuccine or penne, chicken, assorted peppers and brown mushrooms in a cream-based sauce.', '400', '51', 'https://image.ibb.co/fBPxDv/Chicken_Capricciosa1.jpg'),
  ('6', '2', 'Spaghetti and Meatballs', 'Spaghetti and meatballs in a tomato-based sauce with basil, oregano and garlic.', '400', 'Spaghetti and meatballs in a tomato-based sauce with basil, oregano and garlic.', '350', '67', 'https://image.ibb.co/cNVhfa/Spaghetti_and_Meatballs1.jpg'),
  ('7', '3', 'Sweet sandwich', 'Incredibly delicious sweet sandwich', '300', 'bread, honey, blueberries, banana', '150', '20', 'https://image.ibb.co/byOPtv/Sweet_sandwich1.jpg'),
  ('8', '3', 'Vanilla cheesecake', 'Creamy vanilla cheesecake on a graham cracker crust topped with your choice of blueberries in syrup or drizzled with chocolate or caramel sauce.', '500', 'cheesecake blueberries, caramel sauce', '120', '35', 'https://image.ibb.co/dE7v0a/cheesecake1.jpg'),
  ('9', '3', 'PANNA COTTAS', 'Mini panna cotta with a raspberries', '200', 'panna cotta, raspberries', '90', '35', 'https://image.ibb.co/gJq4tv/panna_cota1.jpg'),
  ('10', '4', 'Margarita cocktail', 'The origin of the Margarita recipe is fiercely debated, but we think it\'s got Mexico written all over it. With tequila, triple sec and fresh lime it\'s tart, zingy and satisfying.', '150', 'Cazadores Tequila, triple sec liqueur, lime juice,lime wedge,Salt', '80', '30', 'https://image.ibb.co/cXWYmF/margarita_cocktail1.jpg'),
  ('11', '4', 'cocoa with marshmallows', 'cocoa with marshmallows', '200', 'cocoa, marshmallow', '150', '18', 'https://image.ibb.co/hOMcDv/cocoa_with_marshmall.jpg'),
  ('12', '4', 'Bloody Mary',
   'This vodka cocktail has endless variations. You can add chilli, Worcestershire sauce, Tabasco, herbs... even bacon. It\'s up to you!',
   '200',
   'Grey Goose vodka, organic tomato juice,fresh lemon juice ,Worcestershire sauce,Tabasco ,Pinch of black pepper',
   '120', '40', 'https://image.ibb.co/eiftmF/Bloody_Mary1.jpg');
COMMIT;

-- ----------------------------
--  Table structure for `food_category`
-- ----------------------------
DROP TABLE IF EXISTS `food_category`;
CREATE TABLE `food_category` (
  `id`       BIGINT(20)   NOT NULL AUTO_INCREMENT,
  `name`     VARCHAR(45)  NOT NULL,
  `link`     VARCHAR(200) NOT NULL,
  `link_big` VARCHAR(200)          DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 5
  DEFAULT CHARSET = latin1;

-- ----------------------------
--  Records of `food_category`
-- ----------------------------
BEGIN;
INSERT INTO `food_category`
VALUES ('1', 'Soups', 'https://image.ibb.co/ccBCdv/soup.png', 'https://image.ibb.co/e22v0a/Soups1.jpg'),
  ('2', 'Pasta', 'https://image.ibb.co/bx4nBF/pasta.png', 'https://image.ibb.co/g3AR6F/pasta1.jpg'),
  ('3', 'Desserts', 'https://image.ibb.co/kowdJv/cake.png', 'https://image.ibb.co/eCz8La/Desserts1.jpg'),
  ('4', 'Drinks', 'https://image.ibb.co/f2fika/drink.png', 'https://image.ibb.co/hOMcDv/cocoa_with_marshmall.jpg');
COMMIT;

-- ----------------------------
--  Table structure for `history`
-- ----------------------------
DROP TABLE IF EXISTS `history`;
CREATE TABLE `history` (
  `id`              BIGINT(20) NOT NULL AUTO_INCREMENT,
  `order_user_id`   BIGINT(20) NOT NULL,
  `order_status_id` BIGINT(20) NOT NULL,
  `order_id`        BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_history_2_user_id` (`order_user_id`),
  KEY `fk_history_2_order_id` (`order_id`) USING BTREE,
  KEY `fk_history_2_order_status_id` (`order_status_id`),
  CONSTRAINT `fk_history_2_order_id` FOREIGN KEY (`order_id`) REFERENCES `order` (`id`)
    ON DELETE CASCADE,
  CONSTRAINT `fk_history_2_order_status_id` FOREIGN KEY (`order_status_id`) REFERENCES `order_status` (`id`)
    ON DELETE CASCADE,
  CONSTRAINT `fk_history_2_user_id` FOREIGN KEY (`order_user_id`) REFERENCES `user` (`id`)
    ON DELETE CASCADE
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 2
  DEFAULT CHARSET = latin1;

-- ----------------------------
--  Records of `history`
-- ----------------------------
BEGIN;
INSERT INTO `history` VALUES ('1', '1', '1', '2');
COMMIT;

-- ----------------------------
--  Table structure for `order`
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id`            BIGINT(20) NOT NULL AUTO_INCREMENT,
  `user_id`       BIGINT(20)          DEFAULT NULL,
  `status_id`     BIGINT(20)          DEFAULT NULL,
  `order_info_id` BIGINT(20)          DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `order_info_id` (`order_info_id`),
  CONSTRAINT `fk_order_2_order_info` FOREIGN KEY (`order_info_id`) REFERENCES `order_info` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 4
  DEFAULT CHARSET = latin1;

-- ----------------------------
--  Records of `order`
-- ----------------------------
BEGIN;
INSERT INTO `order` VALUES ('2', '1', '1', '2'), ('3', '1', '1', '3');
COMMIT;

-- ----------------------------
--  Table structure for `order_food`
-- ----------------------------
DROP TABLE IF EXISTS `order_food`;
CREATE TABLE `order_food` (
  `id`       BIGINT(20) NOT NULL AUTO_INCREMENT,
  `order_id` BIGINT(20) NOT NULL,
  `food_id`  BIGINT(20) NOT NULL,
  `quantity` BIGINT(20)          DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `food_id` (`food_id`),
  KEY `order_id` (`order_id`),
  CONSTRAINT `fk_order_food_2_food_id` FOREIGN KEY (`food_id`) REFERENCES `food` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_order_food_2_order_id` FOREIGN KEY (`order_id`) REFERENCES `order` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 3
  DEFAULT CHARSET = latin1;

-- ----------------------------
--  Records of `order_food`
-- ----------------------------
BEGIN;
INSERT INTO `order_food` VALUES ('1', '2', '2', '1'), ('2', '3', '2', '1');
COMMIT;

-- ----------------------------
--  Table structure for `order_info`
-- ----------------------------
DROP TABLE IF EXISTS `order_info`;
CREATE TABLE `order_info` (
  `id`      BIGINT(20) NOT NULL AUTO_INCREMENT,
  `address` VARCHAR(200)        DEFAULT NULL,
  `phone`   VARCHAR(200)        DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 4
  DEFAULT CHARSET = latin1;

-- ----------------------------
--  Records of `order_info`
-- ----------------------------
BEGIN;
INSERT INTO `order_info` VALUES ('2', NULL, NULL), ('3', 'My address', '+34820984320');
COMMIT;

-- ----------------------------
--  Table structure for `order_status`
-- ----------------------------
DROP TABLE IF EXISTS `order_status`;
CREATE TABLE `order_status` (
  `id`   BIGINT(20)  NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 3
  DEFAULT CHARSET = latin1;

-- ----------------------------
--  Records of `order_status`
-- ----------------------------
BEGIN;
INSERT INTO `order_status` VALUES ('1', 'Done'), ('2', 'In progress');
COMMIT;

-- ----------------------------
--  Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id`        BIGINT(20)  NOT NULL AUTO_INCREMENT,
  `device_id` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 4
  DEFAULT CHARSET = latin1;

-- ----------------------------
--  Records of `user`
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES ('1', '1dtsrt34645ghnd'), ('2', 'test_device_id_0001'), ('3', '925ffd2b84953c13');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
