-- liquibase formatted sql
-- changeset author:root
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `food`
-- ----------------------------
DROP TABLE IF EXISTS `food`;
CREATE TABLE `food` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `category_id` bigint(20) NOT NULL,
  `title` varchar(45) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `calories` varchar(45) DEFAULT NULL,
  `ingredients` varchar(200) DEFAULT NULL,
  `weight` varchar(45) DEFAULT NULL,
  `price` varchar(45) DEFAULT NULL,
  `image_link` varchar(200) DEFAULT NULL,
  `rating` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_food_2_food_category` (`category_id`),
  CONSTRAINT `fk_food_2_food_category` FOREIGN KEY (`category_id`) REFERENCES `food_category` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

-- ----------------------------
--  Records of `food`
-- ----------------------------
BEGIN;
INSERT INTO `food` VALUES ('1', '1', 'Cream of Chicken with Wild Rice', 'Pulled chicken, wild rice and fresh mushrooms in creamy deliciousness. Offered with an optional topping of green onions.', '450', 'Pulled chicken, wild rice and fresh mushrooms', '300', '65.00', 'http://res.cloudinary.com/dsukrcavw/image/upload/v1490096451/Cream_of_Chicken_with_Wild_Rice1_g7db1a.jpg', '3'), ('2', '1', 'Housemade Lentil Soup', 'Made from scratch daily with slow-cooked lentils, vegetables and herbs, topped with a spoonful of our spiced crema.', '400', 'lentils, vegetables and herbs', '350', '56.00', 'http://res.cloudinary.com/dsukrcavw/image/upload/v1490096451/Housemade_Lentil_Soup1_ya7fes.jpg', '3'), ('3', '1', 'Tuscan Vegetable', 'VEGAN. A delicious array of zucchini, eggplant, spinach, tomatoes, green beans and yukon potatoes in a vegetable broth with garlic and fresh basil. Offered with an optional topping of basil.', '500', 'array of zucchini, eggplant, spinach, tomatoes, green beans and yukon potatoes', '400', '68.00', 'http://res.cloudinary.com/dsukrcavw/image/upload/v1490096452/Tuscan_Vegetable1_l1tewp.jpg', '2'), ('4', '2', 'Alfredo', 'Your choice of spaghetti, fettuccine or penne, served with crispy bacon, ham and brown mushrooms in a rich, cream-based sauce.', '450', 'spaghetti, fettuccine , brown mushrooms etc', '300', '55.00', 'http://res.cloudinary.com/dsukrcavw/image/upload/v1490096425/Alfredo1_k5bezt.jpg', '11'), ('5', '2', 'Chicken Capricciosa', 'Your choice of spaghetti, fettuccine or penne, served with oven-roasted chicken, assorted peppers and brown mushrooms in a cream-based sauce.', '500', 'spaghetti, fettuccine or penne, chicken, assorted peppers and brown mushrooms in a cream-based sauce.', '400', '51.00', 'http://res.cloudinary.com/dsukrcavw/image/upload/v1490096425/Chicken_Capricciosa1_fu3zer.jpg', '6'), ('6', '2', 'Spaghetti and Meatballs', 'Spaghetti and meatballs in a tomato-based sauce with basil, oregano and garlic.', '400', 'Spaghetti and meatballs in a tomato-based sauce with basil, oregano and garlic.', '350', '67.00', 'http://res.cloudinary.com/dsukrcavw/image/upload/v1490096425/Spaghetti_and_Meatballs1_bjkvlj.jpg', '2'), ('7', '3', 'Sweet sandwich', 'Incredibly delicious sweet sandwich', '300', 'bread, honey, blueberries, banana', '150', '20.00', 'http://res.cloudinary.com/dsukrcavw/image/upload/v1490096396/Sweet_sandwich1_f0l0dn.jpg', '3'), ('8', '3', 'Vanilla cheesecake', 'Creamy vanilla cheesecake on a graham cracker crust topped with your choice of blueberries in syrup or drizzled with chocolate or caramel sauce.', '500', 'cheesecake blueberries, caramel sauce', '120', '35.00', 'http://res.cloudinary.com/dsukrcavw/image/upload/v1490096396/cheesecake1_fbcovh.jpg', '3'), ('9', '3', 'PANNA COTTAS', 'Mini panna cotta with a raspberries', '200', 'panna cotta, raspberries', '90', '35.00', 'http://res.cloudinary.com/dsukrcavw/image/upload/v1490096396/panna_cota1_gadqql.jpg', '2'), ('10', '4', 'Margarita cocktail', 'The origin of the Margarita recipe is fiercely debated, but we think it\'s got Mexico written all over it. With tequila, triple sec and fresh lime it\'s tart, zingy and satisfying.', '150', 'Cazadores Tequila, triple sec liqueur, lime juice,lime wedge,Salt', '80', '30.00', 'http://res.cloudinary.com/dsukrcavw/image/upload/v1490096417/margarita_cocktail1_jvsw2e.jpg', '3'), ('11', '4', 'cocoa with marshmallows', 'cocoa with marshmallows', '200', 'cocoa, marshmallow', '150', '18.00', 'http://res.cloudinary.com/dsukrcavw/image/upload/v1490096417/cocoa_with_marshmall_hqvb44.jpg', '4'), ('12', '4', 'Bloody Mary', 'This vodka cocktail has endless variations. You can add chilli, Worcestershire sauce, Tabasco, herbs... even bacon. It\'s up to you!', '200', 'Grey Goose vodka, organic tomato juice,fresh lemon juice ,Worcestershire sauce,Tabasco ,Pinch of black pepper', '120', '40.00', 'http://res.cloudinary.com/dsukrcavw/image/upload/v1490096417/Bloody_Mary1_zi7air.jpg', '0');
COMMIT;

-- ----------------------------
--  Table structure for `food_category`
-- ----------------------------
DROP TABLE IF EXISTS `food_category`;
CREATE TABLE `food_category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `link` varchar(200) NOT NULL,
  `link_big` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- ----------------------------
--  Records of `food_category`
-- ----------------------------
BEGIN;
INSERT INTO `food_category` VALUES ('1', 'Soups', 'http://res.cloudinary.com/dsukrcavw/image/upload/v1490175540/soup_ky6cks.png', 'http://res.cloudinary.com/dsukrcavw/image/upload/v1490096451/Soups1_v2dhv5.jpg'), ('2', 'Pasta', 'http://res.cloudinary.com/dsukrcavw/image/upload/v1490175540/pasta_avxicf.png', 'http://res.cloudinary.com/dsukrcavw/image/upload/v1490096425/pasta1_quwspe.jpg'), ('3', 'Desserts', 'http://res.cloudinary.com/dsukrcavw/image/upload/v1490175540/cake_sfkk33.png', 'http://res.cloudinary.com/dsukrcavw/image/upload/v1490096396/Desserts1_vpljla.jpg'), ('4', 'Drinks', 'http://res.cloudinary.com/dsukrcavw/image/upload/v1490175540/drink_jugjy1.png', 'http://res.cloudinary.com/dsukrcavw/image/upload/v1490096418/drinks1_umm4ps.jpg');
COMMIT;

-- ----------------------------
--  Table structure for `history`
-- ----------------------------
DROP TABLE IF EXISTS `history`;
CREATE TABLE `history` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_user_id` bigint(20) NOT NULL,
  `order_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_history_2_user_id` (`order_user_id`),
  KEY `fk_history_2_order_id` (`order_id`) USING BTREE,
  CONSTRAINT `fk_history_2_order_id` FOREIGN KEY (`order_id`) REFERENCES `order` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_history_2_user_id` FOREIGN KEY (`order_user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;


-- ----------------------------
--  Table structure for `order`
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `status_id` bigint(20) DEFAULT NULL,
  `order_info_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `order_info_id` (`order_info_id`),
  KEY `status_id` (`status_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `fk_order_2_order_info_id` FOREIGN KEY (`order_info_id`) REFERENCES `order_info` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_order_2_status_id` FOREIGN KEY (`status_id`) REFERENCES `order_status` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_order_2_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=latin1;

-- ----------------------------
--  Table structure for `order_food`
-- ----------------------------
DROP TABLE IF EXISTS `order_food`;
CREATE TABLE `order_food` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_id` bigint(20) NOT NULL,
  `food_id` bigint(20) NOT NULL,
  `quantity` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `food_id` (`food_id`),
  KEY `order_id` (`order_id`),
  CONSTRAINT `fk_order_food_2_food_id` FOREIGN KEY (`food_id`) REFERENCES `food` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_order_food_2_order_id` FOREIGN KEY (`order_id`) REFERENCES `order` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=88 DEFAULT CHARSET=latin1;

-- ----------------------------
--  Table structure for `order_info`
-- ----------------------------
DROP TABLE IF EXISTS `order_info`;
CREATE TABLE `order_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(200) DEFAULT NULL,
  `phone` varchar(200) DEFAULT NULL,
  `name` varchar(200) DEFAULT NULL,
  `comment` varchar(200) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=latin1;

-- ----------------------------
--  Table structure for `order_status`
-- ----------------------------
DROP TABLE IF EXISTS `order_status`;
CREATE TABLE `order_status` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

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
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `device_id` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;


SET FOREIGN_KEY_CHECKS = 1;
