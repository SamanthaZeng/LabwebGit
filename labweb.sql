/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50643
 Source Host           : localhost:3306
 Source Schema         : labweb

 Target Server Type    : MySQL
 Target Server Version : 50643
 File Encoding         : 65001

 Date: 18/04/2019 16:19:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `bid` int(11) NOT NULL AUTO_INCREMENT,
  `bookname` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `classification` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `babstract` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `press` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `time` date NULL DEFAULT NULL,
  PRIMARY KEY (`bid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for company
-- ----------------------------
DROP TABLE IF EXISTS `company`;
CREATE TABLE `company`  (
  `coid` int(11) NOT NULL AUTO_INCREMENT,
  `coname` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `cotype` int(11) NULL DEFAULT NULL,
  `logourl` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`coid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for cooperator
-- ----------------------------
DROP TABLE IF EXISTS `cooperator`;
CREATE TABLE `cooperator`  (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `coid` int(11) NOT NULL,
  `id` int(11) NULL DEFAULT NULL,
  `title` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `cduty` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `cmail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`cid`) USING BTREE,
  INDEX `FK_cocom`(`coid`) USING BTREE,
  INDEX `FK_usercooperator2`(`id`) USING BTREE,
  CONSTRAINT `FK_cocom` FOREIGN KEY (`coid`) REFERENCES `company` (`coid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_usercooperator2` FOREIGN KEY (`id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `clsid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `abstract` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `teachingobject` int(11) NULL DEFAULT NULL,
  `course_type` int(11) NULL DEFAULT NULL,
  `classhour` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`clsid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news`  (
  `newsid` int(11) NOT NULL AUTO_INCREMENT,
  `newstitle` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `newsdescription` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`newsid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for paper
-- ----------------------------
DROP TABLE IF EXISTS `paper`;
CREATE TABLE `paper`  (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `ptitile` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `publictime` date NULL DEFAULT NULL,
  `papersource` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `keyword` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pabstract` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `paperurl` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `paperrank` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`pid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for paperproject
-- ----------------------------
DROP TABLE IF EXISTS `paperproject`;
CREATE TABLE `paperproject`  (
  `pid` int(11) NOT NULL,
  `proid` int(11) NOT NULL,
  `serialnumber` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`pid`, `proid`) USING BTREE,
  INDEX `FK_paperproject2`(`proid`) USING BTREE,
  CONSTRAINT `FK_paperproject` FOREIGN KEY (`pid`) REFERENCES `paper` (`pid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_paperproject2` FOREIGN KEY (`proid`) REFERENCES `project` (`proid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for papervideo
-- ----------------------------
DROP TABLE IF EXISTS `papervideo`;
CREATE TABLE `papervideo`  (
  `pid` int(11) NOT NULL,
  `vid` int(11) NOT NULL,
  PRIMARY KEY (`pid`, `vid`) USING BTREE,
  INDEX `FK_papervideo2`(`vid`) USING BTREE,
  CONSTRAINT `FK_papervideo` FOREIGN KEY (`pid`) REFERENCES `paper` (`pid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_papervideo2` FOREIGN KEY (`vid`) REFERENCES `video` (`vid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for project
-- ----------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project`  (
  `proid` int(11) NOT NULL AUTO_INCREMENT,
  `number` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `prorank` int(11) NULL DEFAULT NULL,
  `protype` int(11) NULL DEFAULT NULL,
  `funding` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `proname` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `proabstract` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `prosource` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`proid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for researcharea
-- ----------------------------
DROP TABLE IF EXISTS `researcharea`;
CREATE TABLE `researcharea`  (
  `rid` int(11) NOT NULL AUTO_INCREMENT,
  `rname` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `intro` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`rid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `sid` int(11) NOT NULL AUTO_INCREMENT,
  `id` int(11) NULL DEFAULT NULL,
  `srank` int(11) NULL DEFAULT NULL,
  `smail` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `wheretogo` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `entertime` date NULL DEFAULT NULL,
  `stueduexp` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`sid`) USING BTREE,
  INDEX `FK_userstudent2`(`id`) USING BTREE,
  CONSTRAINT `FK_userstudent2` FOREIGN KEY (`id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for t_class
-- ----------------------------
DROP TABLE IF EXISTS `t_class`;
CREATE TABLE `t_class`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `class_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for t_student
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student`  (
  `id` bigint(6) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pwd` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `stunum` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `imgUrl` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `classid` bigint(20) NULL DEFAULT NULL,
  `sex` bit(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `tid` int(11) NOT NULL AUTO_INCREMENT,
  `id` int(11) NULL DEFAULT NULL,
  `trank` int(11) NULL DEFAULT NULL,
  `service` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `teduexp` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tmail` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `workexp` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tduty` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`tid`) USING BTREE,
  INDEX `FK_userteacher2`(`id`) USING BTREE,
  CONSTRAINT `FK_userteacher2` FOREIGN KEY (`id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tid` int(11) NULL DEFAULT NULL,
  `cid` int(11) NULL DEFAULT NULL,
  `sid` int(11) NULL DEFAULT NULL,
  `username` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pwd` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` int(11) NULL DEFAULT NULL,
  `imgurl` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `isadmin` tinyint(1) NULL DEFAULT NULL,
  `usertype` int(11) NULL DEFAULT NULL,
  `birthday` date NULL DEFAULT NULL,
  `realname` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `engname` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_userstudent`(`sid`) USING BTREE,
  INDEX `FK_usercooperator`(`cid`) USING BTREE,
  INDEX `FK_userteacher`(`tid`) USING BTREE,
  CONSTRAINT `FK_usercooperator` FOREIGN KEY (`cid`) REFERENCES `cooperator` (`cid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_userteacher` FOREIGN KEY (`tid`) REFERENCES `teacher` (`tid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for userbook
-- ----------------------------
DROP TABLE IF EXISTS `userbook`;
CREATE TABLE `userbook`  (
  `id` int(11) NOT NULL,
  `bid` int(11) NOT NULL,
  `booknumber` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`, `bid`) USING BTREE,
  INDEX `FK_userbook2`(`bid`) USING BTREE,
  CONSTRAINT `FK_userbook` FOREIGN KEY (`id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_userbook2` FOREIGN KEY (`bid`) REFERENCES `book` (`bid`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for usercourse
-- ----------------------------
DROP TABLE IF EXISTS `usercourse`;
CREATE TABLE `usercourse`  (
  `id` int(11) NOT NULL,
  `clsid` int(11) NOT NULL,
  `teachertype` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`, `clsid`) USING BTREE,
  INDEX `FK_usercourse2`(`clsid`) USING BTREE,
  CONSTRAINT `FK_usercourse` FOREIGN KEY (`id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_usercourse2` FOREIGN KEY (`clsid`) REFERENCES `course` (`clsid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for usernews
-- ----------------------------
DROP TABLE IF EXISTS `usernews`;
CREATE TABLE `usernews`  (
  `id` int(11) NOT NULL,
  `newsid` int(11) NOT NULL,
  PRIMARY KEY (`id`, `newsid`) USING BTREE,
  INDEX `FK_usernews2`(`newsid`) USING BTREE,
  CONSTRAINT `FK_usernews` FOREIGN KEY (`id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_usernews2` FOREIGN KEY (`newsid`) REFERENCES `news` (`newsid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for userpaper
-- ----------------------------
DROP TABLE IF EXISTS `userpaper`;
CREATE TABLE `userpaper`  (
  `id` int(11) NOT NULL,
  `pid` int(11) NOT NULL,
  `papernumber` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `authornumber` int(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`, `pid`) USING BTREE,
  INDEX `FK_userpaper2`(`pid`) USING BTREE,
  CONSTRAINT `FK_userpaper` FOREIGN KEY (`id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_userpaper2` FOREIGN KEY (`pid`) REFERENCES `paper` (`pid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for userpro
-- ----------------------------
DROP TABLE IF EXISTS `userpro`;
CREATE TABLE `userpro`  (
  `id` int(11) NOT NULL,
  `proid` int(11) NOT NULL,
  `pronumber` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `isleader` tinyint(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`, `proid`) USING BTREE,
  INDEX `FK_userpro2`(`proid`) USING BTREE,
  CONSTRAINT `FK_userpro` FOREIGN KEY (`id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_userpro2` FOREIGN KEY (`proid`) REFERENCES `project` (`proid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for userresearch
-- ----------------------------
DROP TABLE IF EXISTS `userresearch`;
CREATE TABLE `userresearch`  (
  `id` int(11) NOT NULL,
  `rid` int(11) NOT NULL,
  PRIMARY KEY (`id`, `rid`) USING BTREE,
  INDEX `FK_userreseach2`(`rid`) USING BTREE,
  CONSTRAINT `FK_userreseach` FOREIGN KEY (`id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_userreseach2` FOREIGN KEY (`rid`) REFERENCES `researcharea` (`rid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for video
-- ----------------------------
DROP TABLE IF EXISTS `video`;
CREATE TABLE `video`  (
  `vid` int(11) NOT NULL AUTO_INCREMENT,
  `videourl` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `uploadid` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`vid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Triggers structure for table cooperator
-- ----------------------------
DROP TRIGGER IF EXISTS `coop_usertid`;
delimiter ;;
CREATE TRIGGER `coop_usertid` AFTER INSERT ON `cooperator` FOR EACH ROW begin
   update user set cid=new.cid where id=new.id;
end
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table student
-- ----------------------------
DROP TRIGGER IF EXISTS `update_userid`;
delimiter ;;
CREATE TRIGGER `update_userid` AFTER INSERT ON `student` FOR EACH ROW begin
   update user set sid=new.sid where id=new.id;
end
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table teacher
-- ----------------------------
DROP TRIGGER IF EXISTS `update_usertid`;
delimiter ;;
CREATE TRIGGER `update_usertid` AFTER INSERT ON `teacher` FOR EACH ROW begin
   update user set tid=new.tid where id=new.id;
end
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
