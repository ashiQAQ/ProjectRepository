CREATE DATABASE  IF NOT EXISTS `vuedemo` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `vuedemo`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: vuedemo
-- ------------------------------------------------------
-- Server version	5.7.17-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `type` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'热销榜',-1),(2,'单人精彩套餐',2),(3,'冰爽饮品限时特惠',1),(4,'精选热菜',-1),(5,'爽口凉菜',-1),(6,'精选套餐',-1),(7,'果拼果汁',-1),(8,'小吃主食',-1),(9,'特色粥品',-1);
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `foods`
--

DROP TABLE IF EXISTS `foods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `foods` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '商品id 主键自增',
  `category_id` int(11) NOT NULL COMMENT '分类id',
  `name` varchar(20) NOT NULL COMMENT '商品名称',
  `price` double NOT NULL COMMENT '价格',
  `old_price` double NOT NULL COMMENT '折前价格',
  `description` varchar(100) NOT NULL COMMENT '商品描述',
  `sell_count` int(11) NOT NULL DEFAULT '0' COMMENT '商品描述',
  `rating` int(11) NOT NULL DEFAULT '100' COMMENT '评分',
  `info` varchar(100) NOT NULL COMMENT '详情',
  `icon` varchar(100) NOT NULL COMMENT 'icon_url',
  `image` varchar(100) NOT NULL COMMENT 'image_url',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb4 COMMENT='商品表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `foods`
--

LOCK TABLES `foods` WRITE;
/*!40000 ALTER TABLE `foods` DISABLE KEYS */;
INSERT INTO `foods` VALUES (1,1,'皮蛋瘦肉粥',10,15,'咸粥',229,100,'一碗皮蛋瘦肉粥，总是我到粥店时的不二之选。香浓软滑，饱腹暖心，皮蛋的Q弹与瘦肉的滑嫩伴着粥香溢于满口，让人喝这样的一碗粥也觉得心满意足','http://fuss10.elemecdn.com/c/cd/c12745ed8a5171e13b427dbc39401jpeg.jpeg?imageView2/1/w/114/h/114','http://fuss10.elemecdn.com/c/cd/c12745ed8a5171e13b427dbc39401jpeg.jpeg?imageView2/1/w/750/h/750'),(2,1,'扁豆焖面',14,0,' ',188,96,' ','http://fuss10.elemecdn.com/c/6b/29e3d29b0db63d36f7c500bca31d8jpeg.jpeg?imageView2/1/w/114/h/114','http://fuss10.elemecdn.com/c/6b/29e3d29b0db63d36f7c500bca31d8jpeg.jpeg?imageView2/1/w/750/h/750'),(3,1,'葱花饼',10,0,' ',124,85,' ','http://fuss10.elemecdn.com/f/28/a51e7b18751bcdf871648a23fd3b4jpeg.jpeg?imageView2/1/w/114/h/114','http://fuss10.elemecdn.com/f/28/a51e7b18751bcdf871648a23fd3b4jpeg.jpeg?imageView2/1/w/750/h/750'),(20,2,'红枣山药粥套餐',29,36,'红枣山药糙米粥,素材包,爽口莴笋丝,四川泡菜或八宝酱菜,配菜可备注',17,100,'','http://fuss10.elemecdn.com/6/72/cb844f0bb60c502c6d5c05e0bddf5jpeg.jpeg?imageView2/1/w/114/h/114','http://fuss10.elemecdn.com/6/72/cb844f0bb60c502c6d5c05e0bddf5jpeg.jpeg?imageView2/1/w/750/h/750'),(30,3,'VC无限橙果汁',8,10,' ',15,100,' ','http://fuss10.elemecdn.com/e/c6/f348e811772016ae24e968238bcbfjpeg.jpeg?imageView2/1/w/114/h/114','http://fuss10.elemecdn.com/e/c6/f348e811772016ae24e968238bcbfjpeg.jpeg?imageView2/1/w/750/h/750'),(40,4,'娃娃菜炖豆腐',17,0,' ',43,92,' ','http://fuss10.elemecdn.com/d/2d/b1eb45b305635d9dd04ddf157165fjpeg.jpeg?imageView2/1/w/114/h/114','http://fuss10.elemecdn.com/d/2d/b1eb45b305635d9dd04ddf157165fjpeg.jpeg?imageView2/1/w/750/h/750'),(50,5,'八宝酱菜',4,0,' ',84,100,' ','http://fuss10.elemecdn.com/9/b5/469d8854f9a3a03797933fd01398bjpeg.jpeg?imageView2/1/w/114/h/114','http://fuss10.elemecdn.com/9/b5/469d8854f9a3a03797933fd01398bjpeg.jpeg?imageView2/1/w/750/h/750');
/*!40000 ALTER TABLE `foods` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `infos`
--

DROP TABLE IF EXISTS `infos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `infos` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '图片id 主键自增',
  `seller_id` int(11) DEFAULT NULL COMMENT '商家id',
  `content` varchar(100) DEFAULT NULL COMMENT '信息内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COMMENT='商家相关信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `infos`
--

LOCK TABLES `infos` WRITE;
/*!40000 ALTER TABLE `infos` DISABLE KEYS */;
INSERT INTO `infos` VALUES (1,1,'该商家支持发票,请下单写好发票抬头'),(2,1,'品类:其他菜系,包子粥店'),(3,1,'北京市昌平区回龙观西大街龙观置业大厦底商B座102单元1340'),(4,1,'营业时间:10:00-20:30');
/*!40000 ALTER TABLE `infos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pictures`
--

DROP TABLE IF EXISTS `pictures`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pictures` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '图片id 主键自增',
  `seller_id` int(11) DEFAULT NULL COMMENT '商家id',
  `url` varchar(100) DEFAULT NULL COMMENT 'pic_url',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COMMENT='商家相关图片表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pictures`
--

LOCK TABLES `pictures` WRITE;
/*!40000 ALTER TABLE `pictures` DISABLE KEYS */;
INSERT INTO `pictures` VALUES (1,1,'http://fuss10.elemecdn.com/8/71/c5cf5715740998d5040dda6e66abfjpeg.jpeg?imageView2/1/w/180/h/180'),(2,1,'http://fuss10.elemecdn.com/b/6c/75bd250e5ba69868f3b1178afbda3jpeg.jpeg?imageView2/1/w/180/h/180'),(3,1,'http://fuss10.elemecdn.com/f/96/3d608c5811bc2d902fc9ab9a5baa7jpeg.jpeg?imageView2/1/w/180/h/180'),(4,1,'http://fuss10.elemecdn.com/6/ad/779f8620ff49f701cd4c58f6448b6jpeg.jpeg?imageView2/1/w/180/h/180');
/*!40000 ALTER TABLE `pictures` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ratings`
--

DROP TABLE IF EXISTS `ratings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ratings` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id 主键自增',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `rate_time` mediumtext,
  `delivery_time` int(11) DEFAULT NULL COMMENT '配送时间',
  `score` double DEFAULT NULL,
  `rate_type` int(11) DEFAULT NULL COMMENT '评价类型',
  `text` text NOT NULL COMMENT '评价内容',
  `seller_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COMMENT='评价表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ratings`
--

LOCK TABLES `ratings` WRITE;
/*!40000 ALTER TABLE `ratings` DISABLE KEYS */;
INSERT INTO `ratings` VALUES (1,1,'1469281964000',30,5,0,'不错,粥很好喝,我经常吃这一家,非常赞,以后也会常来吃,强烈推荐',1),(2,2,'1469271264000',NULL,4,0,'服务态度不错',1),(3,3,'1469261964000',NULL,3,1,' ',1),(4,4,'1469261864000',20,5,0,'良心店铺',1),(5,5,'1469251264000',10,4,0,' ',1),(6,6,'1469241964000',70,1,1,'送货速度蜗牛一样',1),(7,7,'1469231964000',30,5,0,'很喜欢的粥店',1),(8,8,'1469221264000',NULL,4,0,'量给的还可以',1),(9,9,'1469211964000',NULL,3,1,' ',1),(10,10,'1469201964000',NULL,4,0,'孩子喜欢吃这家',1),(11,11,'1469191264000',NULL,4,0,'粥挺好吃的',1),(12,12,'1469181964000',NULL,3,1,' ',1),(13,13,'1469171964000',NULL,5,0,'送货速度很快',1),(14,14,'1469161264000',15,4,0,' ',1),(15,15,'1469151964000',NULL,4,0,'下雨天给快递小哥点个赞',1),(16,16,'1469141964000',NULL,4,0,'好',1),(17,17,'1469131264000',NULL,5,0,'吃了还想再吃',1),(18,18,'1469121964000',NULL,3,1,'发票开的不对',1),(19,19,'1469111964000',NULL,5,0,'好吃',1),(20,20,'1469101264000',30,5,0,'还不错吧',1),(21,21,'1469091964000',40,2,1,' ',1),(22,22,'1469081964000',NULL,4,0,'很喜欢的粥',1),(23,23,'1469071264000',NULL,5,0,' ',1),(24,24,'1469061964000',NULL,6,0,' ',1);
/*!40000 ALTER TABLE `ratings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recommend`
--

DROP TABLE IF EXISTS `recommend`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recommend` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id 主键自增',
  `rating_id` int(11) DEFAULT NULL COMMENT '评分的id',
  `goods_id` text COMMENT 'id 推荐商品ids',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='推荐商品表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recommend`
--

LOCK TABLES `recommend` WRITE;
/*!40000 ALTER TABLE `recommend` DISABLE KEYS */;
/*!40000 ALTER TABLE `recommend` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seller`
--

DROP TABLE IF EXISTS `seller`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `seller` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '商家id 主键自增',
  `name` varchar(20) NOT NULL COMMENT '商家名称',
  `description` varchar(100) DEFAULT NULL COMMENT '商家描述',
  `avatar` varchar(200) DEFAULT NULL COMMENT '商家头像',
  `delivery_time` int(11) DEFAULT NULL COMMENT '配送长 x分钟(整)',
  `score` double DEFAULT '5' COMMENT '商家综合评分',
  `service_score` double DEFAULT '5' COMMENT '服务态度',
  `food_score` double DEFAULT '5' COMMENT '商品评分',
  `rank_rate` double DEFAULT '100' COMMENT '高于周边n%的评分',
  `min_price` double DEFAULT '4' COMMENT '起送金额',
  `delivery_price` double DEFAULT '4' COMMENT '配送费',
  `rating_count` int(11) DEFAULT '0' COMMENT '评价数',
  `sell_count` int(11) DEFAULT '0' COMMENT '月售订单数',
  `bulletin` varchar(200) DEFAULT NULL COMMENT '商家公告',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='商家表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seller`
--

LOCK TABLES `seller` WRITE;
/*!40000 ALTER TABLE `seller` DISABLE KEYS */;
INSERT INTO `seller` VALUES (1,'粥品香坊（回龙观）','蜂鸟专送','http://static.galileo.xiaojukeji.com/static/tms/seller_avatar_256px.jpg',38,4.2,4.1,4.3,69.2,20,4,24,90,'粥品香坊其烹饪粥料的秘方源于中国千年古法，在融和现代制作工艺，由世界烹饪大师屈浩先生领衔研发。坚守纯天然、0添加的良心品质深得消费者青睐，发展至今成为粥类的引领品牌。是2008年奥运会和2013年园博会指定餐饮服务商。');
/*!40000 ALTER TABLE `seller` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supports`
--

DROP TABLE IF EXISTS `supports`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `supports` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '活动id 主键自增',
  `seller_id` int(11) DEFAULT NULL COMMENT '商家id',
  `type` int(11) DEFAULT NULL COMMENT '类型',
  `description` varchar(100) DEFAULT NULL COMMENT '活动描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COMMENT='商家参与活动表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supports`
--

LOCK TABLES `supports` WRITE;
/*!40000 ALTER TABLE `supports` DISABLE KEYS */;
INSERT INTO `supports` VALUES (1,1,0,'在线支付满28减5'),(2,1,1,'VC无限橙果汁全场8折'),(3,1,2,'单人精彩套餐'),(4,1,3,'该商家支持发票,请下单写好发票抬头'),(5,1,4,'已加入“外卖保”计划,食品安全保障');
/*!40000 ALTER TABLE `supports` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id 主键自增',
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `avatar` varchar(200) NOT NULL COMMENT '用户头像',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'3******c','http://static.galileo.xiaojukeji.com/static/tms/default_header.png'),(2,'2******3','http://static.galileo.xiaojukeji.com/static/tms/default_header.png'),(3,'3******b','http://static.galileo.xiaojukeji.com/static/tms/default_header.png'),(4,'1******c','http://static.galileo.xiaojukeji.com/static/tms/default_header.png'),(5,'2******d','http://static.galileo.xiaojukeji.com/static/tms/default_header.png'),(6,'9******0','http://static.galileo.xiaojukeji.com/static/tms/default_header.png'),(7,'d******c','http://static.galileo.xiaojukeji.com/static/tms/default_header.png'),(8,'2******3','http://static.galileo.xiaojukeji.com/static/tms/default_header.png'),(9,'3******8','http://static.galileo.xiaojukeji.com/static/tms/default_header.png'),(10,'a******a','http://static.galileo.xiaojukeji.com/static/tms/default_header.png'),(11,'3******3','http://static.galileo.xiaojukeji.com/static/tms/default_header.png'),(12,'t******b','http://static.galileo.xiaojukeji.com/static/tms/default_header.png'),(13,'f******c','http://static.galileo.xiaojukeji.com/static/tms/default_header.png'),(14,'k******3','http://static.galileo.xiaojukeji.com/static/tms/default_header.png'),(15,'u******b','http://static.galileo.xiaojukeji.com/static/tms/default_header.png'),(16,'s******c','http://static.galileo.xiaojukeji.com/static/tms/default_header.png'),(17,'z******3','http://static.galileo.xiaojukeji.com/static/tms/default_header.png'),(18,'n******b','http://static.galileo.xiaojukeji.com/static/tms/default_header.png'),(19,'m******c','http://static.galileo.xiaojukeji.com/static/tms/default_header.png'),(20,'l******3','http://static.galileo.xiaojukeji.com/static/tms/default_header.png'),(21,'3******o','http://static.galileo.xiaojukeji.com/static/tms/default_header.png'),(22,'3******p','http://static.galileo.xiaojukeji.com/static/tms/default_header.png'),(23,'o******k','http://static.galileo.xiaojukeji.com/static/tms/default_header.png'),(24,'k******b','http://static.galileo.xiaojukeji.com/static/tms/default_header.png');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'vuedemo'
--

--
-- Dumping routines for database 'vuedemo'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-12-22  0:48:15
