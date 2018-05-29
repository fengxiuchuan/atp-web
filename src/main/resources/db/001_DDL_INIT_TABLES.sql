/*
SQLyog v10.2 
MySQL - 5.7.17-log : Database - atp
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`atp` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `atp`;

/*Table structure for table `atp_coach` */


CREATE TABLE `atp_coach` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `coach_no` varchar(30) DEFAULT NULL COMMENT '教练编号',
  `coach_name` varchar(50) DEFAULT NULL COMMENT '教练名称',
  `sex` tinyint(1) DEFAULT NULL COMMENT '性别（0：男；1：女）',
  `age` smallint(3) DEFAULT NULL COMMENT '年龄',
  `gym_id` bigint(20) DEFAULT NULL COMMENT '所在健身场馆',
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='教练表';

/*Data for the table `atp_coach` */

/*Table structure for table `atp_coach_course` */


CREATE TABLE `atp_coach_course` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `coach_no` varchar(30) DEFAULT NULL COMMENT '教练编号',
  `coach_id` bigint(20) DEFAULT NULL COMMENT '教练主键',
  `course_id` bigint(20) DEFAULT NULL COMMENT '课程主键',
  `course_no` varchar(30) DEFAULT NULL COMMENT '课程编码',
  `created_by` bigint(20) DEFAULT NULL COMMENT '创建人',
  `created_name` varchar(20) DEFAULT NULL COMMENT '创建人名称',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_updated_by` bigint(20) DEFAULT NULL COMMENT '更新人',
  `last_updated_name` varchar(20) DEFAULT NULL COMMENT '更新人名称',
  `last_updated_time` datetime DEFAULT NULL COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='教练课程项目表';

/*Data for the table `atp_coach_course` */

/*Table structure for table `atp_course` */


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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='课程表';

/*Data for the table `atp_course` */

/*Table structure for table `atp_gym` */


CREATE TABLE `atp_gym` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `gym_name` varchar(50) DEFAULT NULL COMMENT '场馆名称',
  `manager` varchar(30) DEFAULT NULL COMMENT '负责人名称',
  `m_phone` varchar(20) DEFAULT NULL COMMENT '联系方式',
  `address` varchar(150) DEFAULT NULL COMMENT '联系地址',
  `created_by` bigint(20) DEFAULT NULL COMMENT '创建人',
  `created_name` varchar(20) DEFAULT NULL COMMENT '创建人名称',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_updated_by` bigint(20) DEFAULT NULL COMMENT '更新人',
  `last_updated_name` varchar(20) DEFAULT NULL COMMENT '更新人名称',
  `last_updated_time` datetime DEFAULT NULL COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='健身场馆';

/*Data for the table `atp_gym` */

/*Table structure for table `atp_gym_program` */


CREATE TABLE `atp_gym_program` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gym_id` bigint(20) DEFAULT NULL COMMENT '场馆主键',
  `course_id` bigint(20) DEFAULT NULL COMMENT '课程主键',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='场馆经营项目';

/*Data for the table `atp_gym_program` */

/*Table structure for table `atp_mem_course` */


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


CREATE TABLE `atp_member` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `m_name` varchar(50) DEFAULT NULL COMMENT '姓名',
  `sex` tinyint(1) DEFAULT NULL COMMENT '性别(0:男；1女)',
  `age` tinyint(3) DEFAULT NULL COMMENT '年龄',
  `phone` varchar(20) DEFAULT NULL COMMENT '联系方式',
  `address` varchar(200) DEFAULT NULL COMMENT '联系地址',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `card_no` varchar(30) DEFAULT NULL COMMENT '会员编号',
  `card_pwd` varchar(200) DEFAULT NULL COMMENT '会员密码',
  `created_by` bigint(20) DEFAULT NULL COMMENT '创建人',
  `created_name` varchar(20) DEFAULT NULL COMMENT '创建人名称',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_updated_by` bigint(20) DEFAULT NULL COMMENT '更新人',
  `last_updated_name` varchar(20) DEFAULT NULL COMMENT '更新人名称',
  `last_updated_time` datetime DEFAULT NULL COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='会员信息表';

/*Data for the table `atp_member` */

/*Table structure for table `city` */


CREATE TABLE `city` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '城市编号',
  `province_id` int(10) unsigned  NOT NULL COMMENT '省份编号',
  `city_name` varchar(25) DEFAULT NULL COMMENT '城市名称',
  `description` varchar(25) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

/*Data for the table `city` */

insert  into `city`(`id`,`province_id`,`city_name`,`description`) values (1,1,'温岭市','BYSocket 的家在温岭。'),(2,2,'深圳','深圳'),(3,3,'广州','广州'),(4,4,'从化','从化'),(5,5,'肇庆','肇庆'),(6,6,'济南','济南'),(7,7,'北京','北京'),(8,8,'杭州','杭州'),(9,9,'南京','南京'),(10,10,'杭州','杭州'),(11,11,'无锡','无锡'),(12,12,'昆山','昆山'),(13,13,'苏州','苏州'),(14,14,'上海','上海');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
