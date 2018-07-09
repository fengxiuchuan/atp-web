/*
SQLyog v10.2 
MySQL - 5.7.17-log : Database - atp
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`atp` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `atp`;

/*Table structure for table `atp_coach` */

DROP TABLE IF EXISTS `atp_coach`;

CREATE TABLE `atp_coach` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `coach_no` varchar(30) DEFAULT NULL COMMENT '教练编号',
  `coach_name` varchar(50) DEFAULT NULL COMMENT '教练名称',
  `sex` tinyint(1) DEFAULT NULL COMMENT '性别（0：男；1：女）',
  `birth` date DEFAULT NULL COMMENT '出生日期',
  `age` smallint(3) DEFAULT NULL COMMENT '年龄',
  `gym_id` bigint(20) DEFAULT NULL COMMENT '所在健身场馆',
  `phone` varchar(50) DEFAULT NULL COMMENT '联系方式',
  `job_state` char(1) DEFAULT NULL COMMENT '是否在职(Y:是；N：否）',
  `user_account` varchar(50) DEFAULT NULL COMMENT '用户名',
  `user_passwd` varchar(200) DEFAULT NULL COMMENT '用户密码',
  `created_by` bigint(20) DEFAULT NULL COMMENT '创建人',
  `created_name` varchar(20) DEFAULT NULL COMMENT '创建人名称',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_updated_by` bigint(20) DEFAULT NULL COMMENT '更新人',
  `last_updated_name` varchar(20) DEFAULT NULL COMMENT '更新人名称',
  `last_updated_time` datetime DEFAULT NULL COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='教练表';

/*Data for the table `atp_coach` */

insert  into `atp_coach`(`id`,`coach_no`,`coach_name`,`sex`,`birth`,`age`,`gym_id`,`phone`,`job_state`,`user_account`,`user_passwd`,`created_by`,`created_name`,`created_time`,`last_updated_by`,`last_updated_name`,`last_updated_time`) values (1,'C002-02','小辉-修改',1,'2018-07-03',34,1,NULL,'Y','xiaohuidd','7654321',-1,'super_admin','2018-05-29 15:32:29',-1,'super_admin','2018-05-29 18:04:40'),(2,'C002','小辉',0,'2018-07-03',27,1,NULL,'N','xiaohui','123456',-1,'super_admin','2018-06-05 11:04:22',NULL,NULL,NULL);

/*Table structure for table `atp_coach_course` */

DROP TABLE IF EXISTS `atp_coach_course`;

CREATE TABLE `atp_coach_course` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `coach_no` varchar(30) DEFAULT NULL COMMENT '教练编号',
  `coach_id` bigint(20) DEFAULT NULL COMMENT '教练主键',
  `course_name` varchar(50) DEFAULT NULL COMMENT '课程名称',
  `course_id` bigint(20) DEFAULT NULL COMMENT '课程主键',
  `created_by` bigint(20) DEFAULT NULL COMMENT '创建人',
  `created_name` varchar(20) DEFAULT NULL COMMENT '创建人名称',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_updated_by` bigint(20) DEFAULT NULL COMMENT '更新人',
  `last_updated_name` varchar(20) DEFAULT NULL COMMENT '更新人名称',
  `last_updated_time` datetime DEFAULT NULL COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COMMENT='教练课程项目表';

/*Data for the table `atp_coach_course` */

insert  into `atp_coach_course`(`id`,`coach_no`,`coach_id`,`course_name`,`course_id`,`created_by`,`created_name`,`created_time`,`last_updated_by`,`last_updated_name`,`last_updated_time`) values (1,'',1,'1',0,-1,'超级管理员',NULL,NULL,NULL,NULL),(2,NULL,1,'2',0,-1,'超级管理员',NULL,NULL,NULL,NULL),(3,NULL,2,'3',0,-1,'超级管理员',NULL,NULL,NULL,NULL);

/*Table structure for table `atp_course` */

DROP TABLE IF EXISTS `atp_course`;

CREATE TABLE `atp_course` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `course_name` varchar(20) DEFAULT NULL COMMENT '课程名称',
  `course_no` varchar(30) DEFAULT NULL COMMENT '课程编码',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `created_by` bigint(20) DEFAULT NULL COMMENT '创建人',
  `created_name` varchar(20) DEFAULT NULL COMMENT '创建人名称',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_updated_by` bigint(20) DEFAULT NULL COMMENT '更新人',
  `last_updated_name` varchar(20) DEFAULT NULL COMMENT '更新人名称',
  `last_updated_time` datetime DEFAULT NULL COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COMMENT='课程表';

/*Data for the table `atp_course` */

insert  into `atp_course`(`id`,`course_name`,`course_no`,`remark`,`created_by`,`created_name`,`created_time`,`last_updated_by`,`last_updated_name`,`last_updated_time`) values (1,'课程测试','A001','这是修改',-1,'管理员','2018-05-29 12:27:24',-1,'super_admin','2018-05-29 12:28:59'),(2,'瑜伽','A002','这是修改',-1,'管理员',NULL,NULL,NULL,NULL),(3,'搏击','A003','这是修改',-1,'管理员',NULL,NULL,NULL,NULL),(4,'普拉提','A004','这是修改',-1,'管理员',NULL,NULL,NULL,NULL);

/*Table structure for table `atp_gym` */

DROP TABLE IF EXISTS `atp_gym`;

CREATE TABLE `atp_gym` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `gym_name` varchar(50) DEFAULT NULL COMMENT '场馆名称',
  `manager` varchar(30) DEFAULT NULL COMMENT '负责人名称',
  `phone` varchar(20) DEFAULT NULL COMMENT '联系方式',
  `address` varchar(150) DEFAULT NULL COMMENT '联系地址',
  `created_by` bigint(20) DEFAULT NULL COMMENT '创建人',
  `created_name` varchar(20) DEFAULT NULL COMMENT '创建人名称',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_updated_by` bigint(20) DEFAULT NULL COMMENT '更新人',
  `last_updated_name` varchar(20) DEFAULT NULL COMMENT '更新人名称',
  `last_updated_time` datetime DEFAULT NULL COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COMMENT='健身场馆';

/*Data for the table `atp_gym` */

insert  into `atp_gym`(`id`,`gym_name`,`manager`,`phone`,`address`,`created_by`,`created_name`,`created_time`,`last_updated_by`,`last_updated_name`,`last_updated_time`) values (1,'ATP三店-修改','小张','18104452323','',-1,'super_admin','2018-05-29 13:53:46',-1,'super_admin','2018-05-29 14:12:16'),(2,'聊城三店','小灰灰','22233','444',-1,'super_admin','2018-07-07 19:30:20',NULL,NULL,NULL),(3,'聊城A店','小白','3342','饿',-1,'super_admin','2018-07-07 19:32:58',NULL,NULL,NULL),(4,'小达达','4242','4242','42',-1,'super_admin','2018-07-07 19:57:20',NULL,NULL,NULL),(5,'小达达11','424222','42423','423',-1,'super_admin','2018-07-07 19:59:42',NULL,NULL,NULL),(6,'小达达113423','42422242','4242342','423',-1,'super_admin','2018-07-07 20:00:41',NULL,NULL,NULL);

/*Table structure for table `atp_gym_program` */

DROP TABLE IF EXISTS `atp_gym_program`;

CREATE TABLE `atp_gym_program` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gym_id` bigint(20) DEFAULT NULL COMMENT '场馆主键',
  `course_id` bigint(20) DEFAULT NULL COMMENT '课程主键',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COMMENT='场馆经营项目';

/*Data for the table `atp_gym_program` */

insert  into `atp_gym_program`(`id`,`gym_id`,`course_id`) values (1,4,2),(2,4,3),(3,5,2),(4,5,1),(5,6,1),(6,6,2);

/*Table structure for table `atp_mem_course` */

DROP TABLE IF EXISTS `atp_mem_course`;

CREATE TABLE `atp_mem_course` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `order_no` varchar(30) DEFAULT NULL COMMENT '订单编号',
  `card_no` varchar(30) DEFAULT NULL COMMENT '会员号码',
  `mem_id` bigint(20) DEFAULT NULL COMMENT '会员主键',
  `course_id` bigint(20) DEFAULT NULL COMMENT '课程主键',
  `course_name` varchar(30) DEFAULT NULL COMMENT '课程名称',
  `coach_id` bigint(20) DEFAULT NULL COMMENT '教练主键',
  `coach_no` varchar(50) DEFAULT NULL COMMENT '教练编码',
  `total_num` int(11) DEFAULT NULL COMMENT '总课时',
  `free_num` int(11) DEFAULT NULL COMMENT '剩余课时',
  `used_num` int(11) DEFAULT NULL COMMENT '消耗课时',
  `course_amount` decimal(10,6) DEFAULT NULL COMMENT '课程总金额',
  `created_by` bigint(20) DEFAULT NULL COMMENT '创建人',
  `created_name` varchar(20) DEFAULT NULL COMMENT '创建人名称',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_updated_by` bigint(20) DEFAULT NULL COMMENT '更新人',
  `last_updated_name` varchar(20) DEFAULT NULL COMMENT '更新人名称',
  `last_updated_time` datetime DEFAULT NULL COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='会员报名课程表';

/*Data for the table `atp_mem_course` */

/*Table structure for table `atp_mem_course_consume` */

DROP TABLE IF EXISTS `atp_mem_course_consume`;

CREATE TABLE `atp_mem_course_consume` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `mem_id` bigint(20) DEFAULT NULL COMMENT '会员主键',
  `mem_card_no` varchar(30) DEFAULT NULL COMMENT '会员编号',
  `course_id` bigint(20) DEFAULT NULL COMMENT '课程主键',
  `course_no` varchar(30) DEFAULT NULL COMMENT '课程编码',
  `course_name` varchar(30) DEFAULT NULL COMMENT '课程名称',
  `coach_id` bigint(20) DEFAULT NULL COMMENT '课程教练主键',
  `coach_no` varchar(30) DEFAULT NULL COMMENT '课程教练编码',
  `coach_name` varchar(30) DEFAULT NULL COMMENT '课程教练名称',
  `exec_coach_id` bigint(20) DEFAULT NULL COMMENT '执行教练主键',
  `exec_coach_no` varchar(30) DEFAULT NULL COMMENT '执行教练编码',
  `exec_coach_name` varchar(30) DEFAULT NULL COMMENT '执行教练名称',
  `course_num` tinyint(3) DEFAULT NULL COMMENT '消耗课时数',
  `consume_time` datetime DEFAULT NULL COMMENT '消耗时间',
  `integral` int(11) DEFAULT NULL COMMENT '积分',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `created_by` bigint(20) DEFAULT NULL COMMENT '创建人',
  `created_name` varchar(20) DEFAULT NULL COMMENT '创建人名称',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_updated_by` bigint(20) DEFAULT NULL COMMENT '更新人',
  `last_updated_name` varchar(20) DEFAULT NULL COMMENT '更新人名称',
  `last_updated_time` datetime DEFAULT NULL COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='会员课耗记录';

/*Data for the table `atp_mem_course_consume` */

/*Table structure for table `atp_member` */

DROP TABLE IF EXISTS `atp_member`;

CREATE TABLE `atp_member` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(50) DEFAULT NULL COMMENT '姓名',
  `sex` tinyint(1) DEFAULT NULL COMMENT '性别(0:男；1女)',
  `birth` date DEFAULT NULL COMMENT '出生日期',
  `age` tinyint(3) DEFAULT NULL COMMENT '年龄',
  `id_card` varchar(30) DEFAULT NULL COMMENT '身份证编码',
  `phone` varchar(20) DEFAULT NULL COMMENT '联系方式',
  `address` varchar(200) DEFAULT NULL COMMENT '联系地址',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `card_no` varchar(30) DEFAULT NULL COMMENT '会员编号',
  `card_state` varchar(10) DEFAULT NULL COMMENT '卡号状态(USED:正常，LOSE:挂失； EXPIRE:过期)',
  `card_pwd` varchar(200) DEFAULT NULL COMMENT '会员密码',
  `total_integral` int(8) DEFAULT NULL COMMENT '总积分',
  `total_buy` decimal(10,5) DEFAULT NULL COMMENT '总共消费',
  `total_consume` decimal(10,5) DEFAULT NULL COMMENT '累计消费',
  `created_by` bigint(20) DEFAULT NULL COMMENT '创建人',
  `created_name` varchar(20) DEFAULT NULL COMMENT '创建人名称',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_updated_by` bigint(20) DEFAULT NULL COMMENT '更新人',
  `last_updated_name` varchar(20) DEFAULT NULL COMMENT '更新人名称',
  `last_updated_time` datetime DEFAULT NULL COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=105 DEFAULT CHARSET=utf8mb4 COMMENT='会员信息表';

/*Data for the table `atp_member` */

insert  into `atp_member`(`id`,`name`,`sex`,`birth`,`age`,`id_card`,`phone`,`address`,`remark`,`card_no`,`card_state`,`card_pwd`,`total_integral`,`total_buy`,`total_consume`,`created_by`,`created_name`,`created_time`,`last_updated_by`,`last_updated_name`,`last_updated_time`) values (1,'小芬芬-修改',1,'1980-07-01',23,'3715992829928299','18928280635','测试-修改','这是测试用户-修改','A-222',NULL,'dljljl',NULL,NULL,NULL,-1,'1','2018-06-20 17:16:53',-1,'super_admin','2018-05-29 18:21:54'),(2,'小芬芬',1,'1980-07-01',23,'3715992829928299','1892828','测试','这是测试用户','A-1805001',NULL,'dddd',NULL,NULL,NULL,-1,'super_admin','2018-06-20 17:16:53',NULL,NULL,NULL),(3,'小芬芬',1,'1980-07-01',23,'3715992829928299','1892828','测试','这是测试用户','A-1805001',NULL,'dddd',NULL,NULL,NULL,-1,'super_admin','2018-06-20 17:18:31',NULL,NULL,NULL),(4,'小芬芬0',1,'1980-07-01',18,'3715992829928299','18928280','测试0','这是测试用户0','A-18050010',NULL,'dddd0',NULL,NULL,NULL,-1,'super_admin','2018-06-21 17:41:58',NULL,NULL,NULL),(5,'小芬芬1',1,'1980-07-01',33,'3715992829928299','18928281','测试1','这是测试用户1','A-18050011',NULL,'dddd1',NULL,NULL,NULL,-1,'super_admin','2018-06-21 17:41:58',NULL,NULL,NULL),(6,'小芬芬2',1,'1980-07-01',17,'3715992829928299','18928282','测试2','这是测试用户2','A-18050012',NULL,'dddd2',NULL,NULL,NULL,-1,'super_admin','2018-06-21 17:41:58',NULL,NULL,NULL),(7,'小芬芬3',1,'1980-07-01',37,'3715992829928299','18928283','测试3','这是测试用户3','A-18050013',NULL,'dddd3',NULL,NULL,NULL,-1,'super_admin','2018-06-21 17:41:58',NULL,NULL,NULL),(8,'小芬芬4',1,'1980-07-01',26,'3715992829928299','18928284','测试4','这是测试用户4','A-18050014',NULL,'dddd4',NULL,NULL,NULL,-1,'super_admin','2018-06-21 17:41:58',NULL,NULL,NULL),(9,'小芬芬5',1,'1980-07-01',32,'3715992829928299','18928285','测试5','这是测试用户5','A-18050015',NULL,'dddd5',NULL,NULL,NULL,-1,'super_admin','2018-06-21 17:41:58',NULL,NULL,NULL),(10,'小芬芬6',1,'1980-07-01',33,'3715992829928299','18928286','测试6','这是测试用户6','A-18050016',NULL,'dddd6',NULL,NULL,NULL,-1,'super_admin','2018-06-21 17:41:58',NULL,NULL,NULL),(11,'小芬芬7',1,'1980-07-01',3,'3715992829928299','18928287','测试7','这是测试用户7','A-18050017',NULL,'dddd7',NULL,NULL,NULL,-1,'super_admin','2018-06-21 17:41:58',NULL,NULL,NULL),(12,'小芬芬8',1,'1980-07-01',27,'3715992829928299','18928288','测试8','这是测试用户8','A-18050018',NULL,'dddd8',NULL,NULL,NULL,-1,'super_admin','2018-06-21 17:41:58',NULL,NULL,NULL),(13,'小芬芬9',1,'1980-07-01',1,'3715992829928299','18928289','测试9','这是测试用户9','A-18050019',NULL,'dddd9',NULL,NULL,NULL,-1,'super_admin','2018-06-21 17:41:58',NULL,NULL,NULL),(14,'小芬芬10',1,'1980-07-01',41,'3715992829928299','189282810','测试10','这是测试用户10','A-180500110',NULL,'dddd10',NULL,NULL,NULL,-1,'super_admin','2018-06-21 17:41:58',NULL,NULL,NULL),(15,'小芬芬11',1,'1980-07-01',12,'3715992829928299','189282811','测试11','这是测试用户11','A-180500111',NULL,'dddd11',NULL,NULL,NULL,-1,'super_admin','2018-06-21 17:41:58',NULL,NULL,NULL),(16,'小芬芬12',1,'1980-07-01',48,'3715992829928299','189282812','测试12','这是测试用户12','A-180500112',NULL,'dddd12',NULL,NULL,NULL,-1,'super_admin','2018-06-21 17:41:58',NULL,NULL,NULL),(17,'小芬芬13',1,'1980-07-01',33,'3715992829928299','189282813','测试13','这是测试用户13','A-180500113',NULL,'dddd13',NULL,NULL,NULL,-1,'super_admin','2018-06-21 17:41:58',NULL,NULL,NULL),(18,'小芬芬14',1,'1980-07-01',47,'3715992829928299','189282814','测试14','这是测试用户14','A-180500114',NULL,'dddd14',NULL,NULL,NULL,-1,'super_admin','2018-06-21 17:41:58',NULL,NULL,NULL),(19,'小芬芬15',1,'1980-07-01',38,'3715992829928299','189282815','测试15','这是测试用户15','A-180500115',NULL,'dddd15',NULL,NULL,NULL,-1,'super_admin','2018-06-21 17:41:58',NULL,NULL,NULL),(20,'小芬芬16',1,'1980-07-01',22,'3715992829928299','189282816','测试16','这是测试用户16','A-180500116',NULL,'dddd16',NULL,NULL,NULL,-1,'super_admin','2018-06-21 17:41:58',NULL,NULL,NULL),(21,'小芬芬17',1,'1980-07-01',48,'3715992829928299','189282817','测试17','这是测试用户17','A-180500117',NULL,'dddd17',NULL,NULL,NULL,-1,'super_admin','2018-06-21 17:41:58',NULL,NULL,NULL),(22,'小芬芬18',1,'1980-07-01',42,'3715992829928299','189282818','测试18','这是测试用户18','A-180500118',NULL,'dddd18',NULL,NULL,NULL,-1,'super_admin','2018-06-21 17:41:58',NULL,NULL,NULL),(23,'小芬芬19',1,'1980-07-01',25,'3715992829928299','189282819','测试19','这是测试用户19','A-180500119',NULL,'dddd19',NULL,NULL,NULL,-1,'super_admin','2018-06-21 17:41:58',NULL,NULL,NULL),(24,'小芬芬20',1,'1980-07-01',38,'3715992829928299','189282820','测试20','这是测试用户20','A-180500120',NULL,'dddd20',NULL,NULL,NULL,-1,'super_admin','2018-06-21 17:41:58',NULL,NULL,NULL),(25,'小芬芬21',1,'1980-07-01',11,'3715992829928299','189282821','测试21','这是测试用户21','A-180500121',NULL,'dddd21',NULL,NULL,NULL,-1,'super_admin','2018-06-21 17:41:58',NULL,NULL,NULL),(26,'小芬芬22',1,'1980-07-01',39,'3715992829928299','189282822','测试22','这是测试用户22','A-180500122',NULL,'dddd22',NULL,NULL,NULL,-1,'super_admin','2018-06-21 17:41:58',NULL,NULL,NULL),(27,'小芬芬23',1,'1980-07-01',10,'3715992829928299','189282823','测试23','这是测试用户23','A-180500123',NULL,'dddd23',NULL,NULL,NULL,-1,'super_admin','2018-06-21 17:41:58',NULL,NULL,NULL),(28,'小芬芬24',1,'1980-07-01',9,'3715992829928299','189282824','测试24','这是测试用户24','A-180500124',NULL,'dddd24',NULL,NULL,NULL,-1,'super_admin','2018-06-21 17:41:58',NULL,NULL,NULL),(29,'小芬芬25',1,'1980-07-01',1,'3715992829928299','189282825','测试25','这是测试用户25','A-180500125',NULL,'dddd25',NULL,NULL,NULL,-1,'super_admin','2018-06-21 17:41:58',NULL,NULL,NULL),(30,'小芬芬26',1,'1980-07-01',8,'3715992829928299','189282826','测试26','这是测试用户26','A-180500126',NULL,'dddd26',NULL,NULL,NULL,-1,'super_admin','2018-06-21 17:41:58',NULL,NULL,NULL),(31,'小芬芬27',1,'1980-07-01',30,'3715992829928299','189282827','测试27','这是测试用户27','A-180500127',NULL,'dddd27',NULL,NULL,NULL,-1,'super_admin','2018-06-21 17:41:58',NULL,NULL,NULL),(32,'小芬芬28',1,'1980-07-01',10,'3715992829928299','189282828','测试28','这是测试用户28','A-180500128',NULL,'dddd28',NULL,NULL,NULL,-1,'super_admin','2018-06-21 17:41:58',NULL,NULL,NULL),(33,'小芬芬29',1,'1980-07-01',18,'3715992829928299','189282829','测试29','这是测试用户29','A-180500129',NULL,'dddd29',NULL,NULL,NULL,-1,'super_admin','2018-06-21 17:41:58',NULL,NULL,NULL),(34,'小芬芬30',1,'1980-07-01',28,'3715992829928299','189282830','测试30','这是测试用户30','A-180500130',NULL,'dddd30',NULL,NULL,NULL,-1,'super_admin','2018-06-21 17:41:58',NULL,NULL,NULL),(35,'小芬芬31',1,'1980-07-01',15,'3715992829928299','189282831','测试31','这是测试用户31','A-180500131',NULL,'dddd31',NULL,NULL,NULL,-1,'super_admin','2018-06-21 17:41:58',NULL,NULL,NULL),(36,'小芬芬32',1,'1980-07-01',41,'3715992829928299','189282832','测试32','这是测试用户32','A-180500132',NULL,'dddd32',NULL,NULL,NULL,-1,'super_admin','2018-06-21 17:41:58',NULL,NULL,NULL),(37,'小芬芬33',1,'1980-07-01',29,'3715992829928299','189282833','测试33','这是测试用户33','A-180500133',NULL,'dddd33',NULL,NULL,NULL,-1,'super_admin','2018-06-21 17:41:58',NULL,NULL,NULL),(38,'小芬芬34',1,'1980-07-01',37,'3715992829928299','189282834','测试34','这是测试用户34','A-180500134',NULL,'dddd34',NULL,NULL,NULL,-1,'super_admin','2018-06-21 17:41:58',NULL,NULL,NULL),(39,'小芬芬35',1,'1980-07-01',9,'3715992829928299','189282835','测试35','这是测试用户35','A-180500135',NULL,'dddd35',NULL,NULL,NULL,-1,'super_admin','2018-06-21 17:41:58',NULL,NULL,NULL),(40,'小芬芬36',1,'1980-07-01',1,'3715992829928299','189282836','测试36','这是测试用户36','A-180500136',NULL,'dddd36',NULL,NULL,NULL,-1,'super_admin','2018-06-21 17:41:58',NULL,NULL,NULL),(41,'小芬芬37',1,'1980-07-01',34,'3715992829928299','189282837','测试37','这是测试用户37','A-180500137',NULL,'dddd37',NULL,NULL,NULL,-1,'super_admin','2018-06-21 17:41:58',NULL,NULL,NULL),(42,'小芬芬38',1,'1980-07-01',28,'3715992829928299','189282838','测试38','这是测试用户38','A-180500138',NULL,'dddd38',NULL,NULL,NULL,-1,'super_admin','2018-06-21 17:41:58',NULL,NULL,NULL),(43,'小芬芬39',1,'1980-07-01',41,'3715992829928299','189282839','测试39','这是测试用户39','A-180500139',NULL,'dddd39',NULL,NULL,NULL,-1,'super_admin','2018-06-21 17:41:58',NULL,NULL,NULL),(44,'小芬芬40',1,'1980-07-01',36,'3715992829928299','189282840','测试40','这是测试用户40','A-180500140',NULL,'dddd40',NULL,NULL,NULL,-1,'super_admin','2018-06-21 17:41:58',NULL,NULL,NULL),(45,'小芬芬41',1,'1980-07-01',12,'3715992829928299','189282841','测试41','这是测试用户41','A-180500141',NULL,'dddd41',NULL,NULL,NULL,-1,'super_admin','2018-06-21 17:41:58',NULL,NULL,NULL),(46,'小芬芬42',1,'1980-07-01',18,'3715992829928299','189282842','测试42','这是测试用户42','A-180500142',NULL,'dddd42',NULL,NULL,NULL,-1,'super_admin','2018-06-21 17:41:58',NULL,NULL,NULL),(47,'小芬芬43',1,'1980-07-01',28,'3715992829928299','189282843','测试43','这是测试用户43','A-180500143',NULL,'dddd43',NULL,NULL,NULL,-1,'super_admin','2018-06-21 17:41:58',NULL,NULL,NULL),(48,'小芬芬44',1,'1980-07-01',10,'3715992829928299','189282844','测试44','这是测试用户44','A-180500144',NULL,'dddd44',NULL,NULL,NULL,-1,'super_admin','2018-06-21 17:41:58',NULL,NULL,NULL),(49,'小芬芬45',1,'1980-07-01',25,'3715992829928299','189282845','测试45','这是测试用户45','A-180500145',NULL,'dddd45',NULL,NULL,NULL,-1,'super_admin','2018-06-21 17:41:58',NULL,NULL,NULL),(50,'小芬芬46',1,'1980-07-01',44,'3715992829928299','189282846','测试46','这是测试用户46','A-180500146',NULL,'dddd46',NULL,NULL,NULL,-1,'super_admin','2018-06-21 17:41:58',NULL,NULL,NULL),(51,'小芬芬47',1,'1980-07-01',39,'3715992829928299','189282847','测试47','这是测试用户47','A-180500147',NULL,'dddd47',NULL,NULL,NULL,-1,'super_admin','2018-06-21 17:41:58',NULL,NULL,NULL),(52,'小芬芬48',1,'1980-07-01',12,'3715992829928299','189282848','测试48','这是测试用户48','A-180500148',NULL,'dddd48',NULL,NULL,NULL,-1,'super_admin','2018-06-21 17:41:58',NULL,NULL,NULL),(53,'小芬芬49',1,'1980-07-01',32,'3715992829928299','189282849','测试49','这是测试用户49','A-180500149',NULL,'dddd49',NULL,NULL,NULL,-1,'super_admin','2018-06-21 17:41:58',NULL,NULL,NULL),(54,'小芬芬50',1,'1980-07-01',28,'3715992829928299','189282850','测试50','这是测试用户50','A-180500150',NULL,'dddd50',NULL,NULL,NULL,-1,'super_admin','2018-06-21 17:41:58',NULL,NULL,NULL),(55,'小芬芬51',1,'1980-07-01',26,'3715992829928299','189282851','测试51','这是测试用户51','A-180500151',NULL,'dddd51',NULL,NULL,NULL,-1,'super_admin','2018-06-21 17:41:58',NULL,NULL,NULL),(56,'小芬芬52',1,'1980-07-01',11,'3715992829928299','189282852','测试52','这是测试用户52','A-180500152',NULL,'dddd52',NULL,NULL,NULL,-1,'super_admin','2018-06-21 17:41:58',NULL,NULL,NULL),(57,'小芬芬53',1,'1980-07-01',18,'3715992829928299','189282853','测试53','这是测试用户53','A-180500153',NULL,'dddd53',NULL,NULL,NULL,-1,'super_admin','2018-06-21 17:41:58',NULL,NULL,NULL),(58,'小芬芬54',1,'1980-07-01',18,'3715992829928299','189282854','测试54','这是测试用户54','A-180500154',NULL,'dddd54',NULL,NULL,NULL,-1,'super_admin','2018-06-21 17:41:58',NULL,NULL,NULL),(59,'小芬芬55',1,'1980-07-01',10,'3715992829928299','189282855','测试55','这是测试用户55','A-180500155',NULL,'dddd55',NULL,NULL,NULL,-1,'super_admin','2018-06-21 17:41:58',NULL,NULL,NULL),(60,'小芬芬56',1,'1980-07-01',15,'3715992829928299','189282856','测试56','这是测试用户56','A-180500156',NULL,'dddd56',NULL,NULL,NULL,-1,'super_admin','2018-06-21 17:41:58',NULL,NULL,NULL),(61,'小芬芬57',1,'1980-07-01',10,'3715992829928299','189282857','测试57','这是测试用户57','A-180500157',NULL,'dddd57',NULL,NULL,NULL,-1,'super_admin','2018-06-21 17:41:58',NULL,NULL,NULL),(62,'小芬芬58',1,'1980-07-01',41,'3715992829928299','189282858','测试58','这是测试用户58','A-180500158',NULL,'dddd58',NULL,NULL,NULL,-1,'super_admin','2018-06-21 17:41:58',NULL,NULL,NULL),(63,'小芬芬59',1,'1980-07-01',8,'3715992829928299','189282859','测试59','这是测试用户59','A-180500159',NULL,'dddd59',NULL,NULL,NULL,-1,'super_admin','2018-06-21 17:41:58',NULL,NULL,NULL),(64,'小芬芬60',1,'1980-07-01',36,'3715992829928299','189282860','测试60','这是测试用户60','A-180500160',NULL,'dddd60',NULL,NULL,NULL,-1,'super_admin','2018-06-21 17:41:58',NULL,NULL,NULL),(65,'小芬芬61',1,'1980-07-01',25,'3715992829928299','189282861','测试61','这是测试用户61','A-180500161',NULL,'dddd61',NULL,NULL,NULL,-1,'super_admin','2018-06-21 17:41:58',NULL,NULL,NULL),(66,'小芬芬62',1,'1980-07-01',13,'3715992829928299','189282862','测试62','这是测试用户62','A-180500162',NULL,'dddd62',NULL,NULL,NULL,-1,'super_admin','2018-06-21 17:41:58',NULL,NULL,NULL),(67,'小芬芬63',1,'1980-07-01',49,'3715992829928299','189282863','测试63','这是测试用户63','A-180500163',NULL,'dddd63',NULL,NULL,NULL,-1,'super_admin','2018-06-21 17:41:58',NULL,NULL,NULL),(68,'小芬芬64',1,'1980-07-01',11,'3715992829928299','189282864','测试64','这是测试用户64','A-180500164',NULL,'dddd64',NULL,NULL,NULL,-1,'super_admin','2018-06-21 17:41:58',NULL,NULL,NULL),(69,'小芬芬65',1,'1980-07-01',22,'3715992829928299','189282865','测试65','这是测试用户65','A-180500165',NULL,'dddd65',NULL,NULL,NULL,-1,'super_admin','2018-06-21 17:41:58',NULL,NULL,NULL),(70,'小芬芬66',1,'1980-07-01',27,'3715992829928299','189282866','测试66','这是测试用户66','A-180500166',NULL,'dddd66',NULL,NULL,NULL,-1,'super_admin','2018-06-21 17:41:58',NULL,NULL,NULL),(71,'小芬芬67',1,'1980-07-01',47,'3715992829928299','189282867','测试67','这是测试用户67','A-180500167',NULL,'dddd67',NULL,NULL,NULL,-1,'super_admin','2018-06-21 17:41:58',NULL,NULL,NULL),(72,'小芬芬68',1,'1980-07-01',10,'3715992829928299','189282868','测试68','这是测试用户68','A-180500168',NULL,'dddd68',NULL,NULL,NULL,-1,'super_admin','2018-06-21 17:41:58',NULL,NULL,NULL),(73,'小芬芬69',1,'1980-07-01',22,'3715992829928299','189282869','测试69','这是测试用户69','A-180500169',NULL,'dddd69',NULL,NULL,NULL,-1,'super_admin','2018-06-21 17:41:58',NULL,NULL,NULL),(74,'小芬芬70',1,'1980-07-01',22,'3715992829928299','189282870','测试70','这是测试用户70','A-180500170',NULL,'dddd70',NULL,NULL,NULL,-1,'super_admin','2018-06-21 17:41:58',NULL,NULL,NULL),(75,'小芬芬71',1,'1980-07-01',42,'3715992829928299','189282871','测试71','这是测试用户71','A-180500171',NULL,'dddd71',NULL,NULL,NULL,-1,'super_admin','2018-06-21 17:41:58',NULL,NULL,NULL),(76,'小芬芬72',1,'1980-07-01',18,'3715992829928299','189282872','测试72','这是测试用户72','A-180500172',NULL,'dddd72',NULL,NULL,NULL,-1,'super_admin','2018-06-21 17:41:58',NULL,NULL,NULL),(77,'小芬芬73',1,'1980-07-01',16,'3715992829928299','189282873','测试73','这是测试用户73','A-180500173',NULL,'dddd73',NULL,NULL,NULL,-1,'super_admin','2018-06-21 17:41:58',NULL,NULL,NULL),(78,'小芬芬74',1,'1980-07-01',17,'3715992829928299','189282874','测试74','这是测试用户74','A-180500174',NULL,'dddd74',NULL,NULL,NULL,-1,'super_admin','2018-06-21 17:41:58',NULL,NULL,NULL),(79,'小芬芬75',1,'1980-07-01',6,'3715992829928299','189282875','测试75','这是测试用户75','A-180500175',NULL,'dddd75',NULL,NULL,NULL,-1,'super_admin','2018-06-21 17:41:58',NULL,NULL,NULL),(80,'小芬芬76',1,'1980-07-01',2,'3715992829928299','189282876','测试76','这是测试用户76','A-180500176',NULL,'dddd76',NULL,NULL,NULL,-1,'super_admin','2018-06-21 17:41:58',NULL,NULL,NULL),(81,'小芬芬77',1,'1980-07-01',44,'3715992829928299','189282877','测试77','这是测试用户77','A-180500177',NULL,'dddd77',NULL,NULL,NULL,-1,'super_admin','2018-06-21 17:41:58',NULL,NULL,NULL),(82,'小芬芬78',1,'1980-07-01',37,'3715992829928299','189282878','测试78','这是测试用户78','A-180500178',NULL,'dddd78',NULL,NULL,NULL,-1,'super_admin','2018-06-21 17:41:58',NULL,NULL,NULL),(83,'小芬芬79',1,'1980-07-01',5,'3715992829928299','189282879','测试79','这是测试用户79','A-180500179',NULL,'dddd79',NULL,NULL,NULL,-1,'super_admin','2018-06-21 17:41:58',NULL,NULL,NULL),(84,'小芬芬80',1,'1980-07-01',11,'3715992829928299','189282880','测试80','这是测试用户80','A-180500180',NULL,'dddd80',NULL,NULL,NULL,-1,'super_admin','2018-06-21 17:41:58',NULL,NULL,NULL),(85,'小芬芬81',1,'1980-07-01',27,'3715992829928299','189282881','测试81','这是测试用户81','A-180500181',NULL,'dddd81',NULL,NULL,NULL,-1,'super_admin','2018-06-21 17:41:58',NULL,NULL,NULL),(86,'小芬芬82',1,'1980-07-01',43,'3715992829928299','189282882','测试82','这是测试用户82','A-180500182',NULL,'dddd82',NULL,NULL,NULL,-1,'super_admin','2018-06-21 17:41:58',NULL,NULL,NULL),(87,'小芬芬83',1,'1980-07-01',17,'3715992829928299','189282883','测试83','这是测试用户83','A-180500183',NULL,'dddd83',NULL,NULL,NULL,-1,'super_admin','2018-06-21 17:41:58',NULL,NULL,NULL),(88,'小芬芬84',1,'1980-07-01',22,'3715992829928299','189282884','测试84','这是测试用户84','A-180500184',NULL,'dddd84',NULL,NULL,NULL,-1,'super_admin','2018-06-21 17:41:58',NULL,NULL,NULL),(89,'小芬芬85',1,'1980-07-01',47,'3715992829928299','189282885','测试85','这是测试用户85','A-180500185',NULL,'dddd85',NULL,NULL,NULL,-1,'super_admin','2018-06-21 17:41:58',NULL,NULL,NULL),(90,'小芬芬86',1,'1980-07-01',24,'3715992829928299','189282886','测试86','这是测试用户86','A-180500186',NULL,'dddd86',NULL,NULL,NULL,-1,'super_admin','2018-06-21 17:41:58',NULL,NULL,NULL),(91,'小芬芬87',1,'1980-07-01',23,'3715992829928299','189282887','测试87','这是测试用户87','A-180500187',NULL,'dddd87',NULL,NULL,NULL,-1,'super_admin','2018-06-21 17:41:58',NULL,NULL,NULL),(92,'小芬芬88',1,'1980-07-01',21,'3715992829928299','189282888','测试88','这是测试用户88','A-180500188',NULL,'dddd88',NULL,NULL,NULL,-1,'super_admin','2018-06-21 17:41:58',NULL,NULL,NULL),(93,'小芬芬89',1,'1980-07-01',35,'3715992829928299','189282889','测试89','这是测试用户89','A-180500189',NULL,'dddd89',NULL,NULL,NULL,-1,'super_admin','2018-06-21 17:41:58',NULL,NULL,NULL),(94,'小芬芬90',1,'1980-07-01',20,'3715992829928299','189282890','测试90','这是测试用户90','A-180500190',NULL,'dddd90',NULL,NULL,NULL,-1,'super_admin','2018-06-21 17:41:58',NULL,NULL,NULL),(95,'小芬芬91',1,'1980-07-01',22,'3715992829928299','189282891','测试91','这是测试用户91','A-180500191',NULL,'dddd91',NULL,NULL,NULL,-1,'super_admin','2018-06-21 17:41:58',NULL,NULL,NULL),(96,'小芬芬92',1,'1980-07-01',32,'3715992829928299','189282892','测试92','这是测试用户92','A-180500192',NULL,'dddd92',NULL,NULL,NULL,-1,'super_admin','2018-06-21 17:41:58',NULL,NULL,NULL),(97,'小芬芬93',1,'1980-07-01',47,'3715992829928299','189282893','测试93','这是测试用户93','A-180500193',NULL,'dddd93',NULL,NULL,NULL,-1,'super_admin','2018-06-21 17:41:58',NULL,NULL,NULL),(98,'小芬芬94',1,'1980-07-01',49,'3715992829928299','189282894','测试94','这是测试用户94','A-180500194',NULL,'dddd94',NULL,NULL,NULL,-1,'super_admin','2018-06-21 17:41:58',NULL,NULL,NULL),(99,'小芬芬95',1,'1980-07-01',8,'3715992829928299','189282895','测试95','这是测试用户95','A-180500195',NULL,'dddd95',NULL,NULL,NULL,-1,'super_admin','2018-06-21 17:41:58',NULL,NULL,NULL),(100,'小芬芬96',1,'1980-07-01',35,'3715992829928299','189282896','测试96','这是测试用户96','A-180500196',NULL,'dddd96',NULL,NULL,NULL,-1,'super_admin','2018-06-21 17:41:58',NULL,NULL,NULL),(101,'小芬芬97',1,'1980-07-01',28,'3715992829928299','189282897','测试97','这是测试用户97','A-180500197',NULL,'dddd97',NULL,NULL,NULL,-1,'super_admin','2018-06-21 17:41:58',NULL,NULL,NULL),(102,'小芬芬98',1,'1980-07-01',29,'3715992829928299','189282898','测试98','这是测试用户98','A-180500198',NULL,'dddd98',NULL,NULL,NULL,-1,'super_admin','2018-06-21 17:41:58',NULL,NULL,NULL),(103,'小芬芬99',1,'1980-07-01',12,'3715992829928299','189282899','测试99','这是测试用户99','A-180500199',NULL,'dddd99',NULL,NULL,NULL,-1,'super_admin','2018-06-21 17:41:58',NULL,NULL,NULL),(104,'小冯',0,'1980-07-01',24,'3715992829928299','189002823456','测试地址','测试备注','ID02002',NULL,'123456',NULL,NULL,NULL,-1,'super_admin','2018-06-26 18:33:12',NULL,NULL,NULL);

/*Table structure for table `city` */

DROP TABLE IF EXISTS `city`;

CREATE TABLE `city` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '城市编号',
  `province_id` int(10) unsigned NOT NULL COMMENT '省份编号',
  `city_name` varchar(25) DEFAULT NULL COMMENT '城市名称',
  `description` varchar(25) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

/*Data for the table `city` */

insert  into `city`(`id`,`province_id`,`city_name`,`description`) values (1,1,'温岭市','BYSocket 的家在温岭。'),(2,2,'深圳','深圳'),(3,3,'广州','广州'),(4,4,'从化','从化'),(5,5,'肇庆','肇庆'),(6,6,'济南','济南'),(7,7,'北京','北京'),(8,8,'杭州','杭州'),(9,9,'南京','南京'),(10,10,'杭州','杭州'),(11,11,'无锡','无锡'),(12,12,'昆山','昆山'),(13,13,'苏州','苏州'),(14,14,'上海','上海');

/*Table structure for table `lms_common_serial_no` */

DROP TABLE IF EXISTS `lms_common_serial_no`;

CREATE TABLE `lms_common_serial_no` (
  `serial_id` varchar(50) NOT NULL COMMENT '序列号名称',
  `serial_key` varchar(100) NOT NULL COMMENT '序列号关键字',
  `serial_value` bigint(20) NOT NULL COMMENT '序列号值',
  PRIMARY KEY (`serial_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='序列号记录表(lms_common_serial_no)';

/*Data for the table `lms_common_serial_no` */

insert  into `lms_common_serial_no`(`serial_id`,`serial_key`,`serial_value`) values ('riskDataCode','201807',1);

/*Table structure for table `test_order` */

DROP TABLE IF EXISTS `test_order`;

CREATE TABLE `test_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `phone` varchar(20) DEFAULT NULL,
  `buy_date` date DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `test_order` */

insert  into `test_order`(`id`,`phone`,`buy_date`,`name`) values (1,'13456672345','2018-06-21','DD'),(2,'13456672345','2018-06-21','DD'),(3,'13456672345','2018-06-28','DD'),(4,'13456672345','2018-06-30','DD'),(5,'12367471254','2018-06-26','小A'),(6,'18904457856','2018-06-27','小牛'),(7,'15167781234','2018-06-28','小B'),(8,'15167781234','2014-06-10','小B'),(9,'18904457856','2018-06-28','小牛');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
