/*
SQLyog Enterprise v12.08 (64 bit)
MySQL - 5.6.45 : Database - medi-sys
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`medi-sys` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `medi-sys`;

/*Table structure for table `agency` */

DROP TABLE IF EXISTS `agency`;

CREATE TABLE `agency` (
  `ano` varchar(50) NOT NULL,
  `aname` varchar(20) NOT NULL,
  `asex` varchar(10) NOT NULL,
  `aphone` varchar(50) NOT NULL,
  `aremark` text NOT NULL,
  `created` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`ano`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `agency` */

insert  into `agency`(`ano`,`aname`,`asex`,`aphone`,`aremark`,`created`) values ('1','陈宇','男','123456789','Boos','2019-12-07 16:59:33'),('2','王庆刚','男','123456','员工','2019-12-07 18:04:27'),('3','admin','男','123456789','员工','2019-12-07 21:04:53');

/*Table structure for table `client` */

DROP TABLE IF EXISTS `client`;

CREATE TABLE `client` (
  `cno` varchar(50) NOT NULL,
  `cname` varchar(50) NOT NULL,
  `csex` varchar(10) NOT NULL,
  `cage` varchar(10) NOT NULL,
  `caddress` text NOT NULL,
  `cphone` varchar(50) NOT NULL,
  `csymptom` text NOT NULL,
  `ano` varchar(50) NOT NULL,
  `cdate` datetime DEFAULT CURRENT_TIMESTAMP,
  `cremark` varchar(50) NOT NULL,
  PRIMARY KEY (`cno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `client` */

insert  into `client`(`cno`,`cname`,`csex`,`cage`,`caddress`,`cphone`,`csymptom`,`ano`,`cdate`,`cremark`) values ('1','chenyu','男','22','德州学院','13456','无','1','2019-12-07 11:59:21','无'),('10','莉亚','女','20','德州学院','1538794645','感冒','1','2019-12-08 10:40:21','无'),('11','陈小风','男','20','德州学院','1538794645','感冒','1','2019-12-08 10:40:56','无'),('2','张三','男','11','德州学院','13456','头晕','1','2019-12-07 14:43:54','无'),('3','李四','男','12','德州学院','123456','头晕','1','2019-12-07 14:44:59','无'),('4','王五','男','16','德州学院','123456','肚子痛','1','2019-12-08 10:34:00','西药'),('5','赵六','男','16','德州学院','123456789','肚子痛','1','2019-12-08 10:34:20','西药'),('6','冯七','女','22','德州','123456789','头晕','2','2019-12-08 10:34:50','中药'),('7','陈诚','男','12','德州','123456','头疼','2','2019-12-08 10:38:27','无'),('8','张成','男','20','德州','123456','头疼','2','2019-12-08 10:38:45','无'),('9','李文','男','20','德州','123456','中暑','2','2019-12-08 10:39:14','无');

/*Table structure for table `medicine` */

DROP TABLE IF EXISTS `medicine`;

CREATE TABLE `medicine` (
  `mno` varchar(50) NOT NULL,
  `mname` varchar(50) NOT NULL,
  `mmode` varchar(10) NOT NULL,
  `mefficacy` text NOT NULL,
  `created` datetime DEFAULT CURRENT_TIMESTAMP,
  `cno` varchar(50) NOT NULL,
  PRIMARY KEY (`mno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `medicine` */

insert  into `medicine`(`mno`,`mname`,`mmode`,`mefficacy`,`created`,`cno`) values ('1','999感冒灵','内服','治风热感冒','2019-12-07 21:26:33','2'),('2','999感冒灵','内服','治风热感冒','2019-12-07 21:28:40','暂无');

/*Table structure for table `tb_permission` */

DROP TABLE IF EXISTS `tb_permission`;

CREATE TABLE `tb_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父权限',
  `name` varchar(64) NOT NULL COMMENT '权限名称',
  `enname` varchar(64) NOT NULL COMMENT '权限英文名称',
  `url` varchar(255) NOT NULL COMMENT '授权路径',
  `description` varchar(200) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  UNIQUE KEY `enname` (`enname`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8 COMMENT='权限表';

/*Data for the table `tb_permission` */

insert  into `tb_permission`(`id`,`parent_id`,`name`,`enname`,`url`,`description`) values (53,0,'添加顾客','InsertClient','',NULL),(54,0,'删除顾客','DeleteClient','',NULL),(55,0,'修改顾客','UpdateClient','',NULL),(56,0,'查看顾客','SelectClient','',NULL),(57,0,'添加经办人','InsertAgency','',NULL),(58,0,'删除经办人','DeleteAgency','',NULL),(59,0,'修改经办人','UpdateAgency','',NULL),(60,0,'查看经办人','SelectAgency','',NULL),(61,0,'添加药品','InsertMedicine','',NULL),(62,0,'删除药品','DeleteMedicine','',NULL),(63,0,'修改药品','UpdateMedicine','',NULL),(64,0,'查看药品','SelectMedicine','',NULL);

/*Table structure for table `tb_role` */

DROP TABLE IF EXISTS `tb_role`;

CREATE TABLE `tb_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父角色',
  `name` varchar(64) NOT NULL COMMENT '角色名称',
  `enname` varchar(64) NOT NULL COMMENT '角色英文名称',
  `description` varchar(200) DEFAULT NULL COMMENT '备注',
  `created` datetime NOT NULL,
  `updated` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `enname` (`enname`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8 COMMENT='角色表';

/*Data for the table `tb_role` */

insert  into `tb_role`(`id`,`parent_id`,`name`,`enname`,`description`,`created`,`updated`) values (39,0,'超级管理员','root','有一切权限','0000-00-00 00:00:00','0000-00-00 00:00:00');

/*Table structure for table `tb_role_permission` */

DROP TABLE IF EXISTS `tb_role_permission`;

CREATE TABLE `tb_role_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) NOT NULL COMMENT '角色 ID',
  `permission_id` bigint(20) NOT NULL COMMENT '权限 ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8 COMMENT='角色权限表';

/*Data for the table `tb_role_permission` */

insert  into `tb_role_permission`(`id`,`role_id`,`permission_id`) values (53,39,53),(54,39,54),(55,39,55),(56,39,56),(57,39,57),(58,39,58),(59,39,59),(60,39,60),(61,39,61),(62,39,62),(63,39,63),(64,39,64);

/*Table structure for table `tb_user` */

DROP TABLE IF EXISTS `tb_user`;

CREATE TABLE `tb_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(64) NOT NULL COMMENT '密码，加密存储',
  `phone` varchar(20) DEFAULT NULL COMMENT '注册手机号',
  `email` varchar(50) DEFAULT NULL COMMENT '注册邮箱',
  `created` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`) USING BTREE,
  UNIQUE KEY `username_2` (`username`),
  UNIQUE KEY `phone` (`phone`) USING BTREE,
  UNIQUE KEY `email` (`email`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8 COMMENT='用户表';

/*Data for the table `tb_user` */

insert  into `tb_user`(`id`,`username`,`password`,`phone`,`email`,`created`,`updated`) values (58,'admin','MTIzNDU2','18382705172','1394777162@qq.com','2019-12-05 21:29:50','2019-12-05 21:29:50');

/*Table structure for table `tb_user_role` */

DROP TABLE IF EXISTS `tb_user_role`;

CREATE TABLE `tb_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL COMMENT '用户 ID',
  `role_id` bigint(20) NOT NULL COMMENT '角色 ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8 COMMENT='用户角色表';

/*Data for the table `tb_user_role` */

insert  into `tb_user_role`(`id`,`user_id`,`role_id`) values (43,58,39);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
