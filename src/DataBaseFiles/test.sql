/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50554
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 50554
 File Encoding         : 65001

 Date: 13/11/2020 17:12:48
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for autoe_activitynodeforpro
-- ----------------------------
DROP TABLE IF EXISTS `autoe_activitynodeforpro`;
CREATE TABLE `autoe_activitynodeforpro`  (
  `activitynodeforproid` int(32) NOT NULL AUTO_INCREMENT,
  `discription` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `activitynodeid` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `procedureid` int(32) NOT NULL,
  PRIMARY KEY (`activitynodeforproid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for autoetl_activitynode
-- ----------------------------
DROP TABLE IF EXISTS `autoetl_activitynode`;
CREATE TABLE `autoetl_activitynode`  (
  `activitynodeid` int(11) NOT NULL AUTO_INCREMENT,
  `intorder` int(11) NOT NULL,
  `activitynodename` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `activitynodetype` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `discription` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `intordergroup` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `repeattype` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sqlcondition` varchar(4000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `startconditiontype` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `datasourceid` int(32) NULL DEFAULT NULL,
  `procedureid` int(32) NULL DEFAULT NULL,
  `workflowid` int(32) NOT NULL,
  PRIMARY KEY (`activitynodeid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of autoetl_activitynode
-- ----------------------------
INSERT INTO `autoetl_activitynode` VALUES (2, 1, 'table', '1', NULL, '1', '1', NULL, '1', 1, NULL, 2);
INSERT INTO `autoetl_activitynode` VALUES (3, 2, 'pro', '1', NULL, '1', '1', NULL, '2', 1, 1, 2);

-- ----------------------------
-- Table structure for autoetl_activitynodefieldv
-- ----------------------------
DROP TABLE IF EXISTS `autoetl_activitynodefieldv`;
CREATE TABLE `autoetl_activitynodefieldv`  (
  `activitynodefieldvid` int(11) NOT NULL AUTO_INCREMENT,
  `strvalue` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `activitynodeforctid` int(11) NOT NULL,
  `relationfieldid` int(11) NULL DEFAULT NULL,
  `fieldid` int(11) NOT NULL,
  PRIMARY KEY (`activitynodefieldvid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for autoetl_activitynodeforct
-- ----------------------------
DROP TABLE IF EXISTS `autoetl_activitynodeforct`;
CREATE TABLE `autoetl_activitynodeforct`  (
  `activitynodeforctid` int(11) NOT NULL AUTO_INCREMENT,
  `cacheline` int(11) NOT NULL,
  `discription` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `activitynodeid` int(11) NOT NULL,
  `tableid` int(11) NOT NULL,
  `targettableid` int(11) NOT NULL,
  PRIMARY KEY (`activitynodeforctid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for autoetl_activitynodeforsql
-- ----------------------------
DROP TABLE IF EXISTS `autoetl_activitynodeforsql`;
CREATE TABLE `autoetl_activitynodeforsql`  (
  `activitynodeforsqlid` int(11) NOT NULL,
  `cacheLine` int(11) NOT NULL,
  `datasourcesql` varchar(4000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `discription` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `activitynodeid` int(11) NOT NULL,
  `datasourceid` int(11) NOT NULL,
  `targettableid` int(11) NOT NULL,
  PRIMARY KEY (`activitynodeforsqlid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for autoetl_activitynodelog
-- ----------------------------
DROP TABLE IF EXISTS `autoetl_activitynodelog`;
CREATE TABLE `autoetl_activitynodelog`  (
  `activitynodelogid` int(11) NOT NULL AUTO_INCREMENT,
  `intorder` int(11) NULL DEFAULT NULL,
  `activitynodeexcutetype` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `discription` varchar(4000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `strlines` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `param` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `resulttype` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `activitynodeid` int(11) NOT NULL,
  `etlworkflowlogid` int(11) NOT NULL,
  PRIMARY KEY (`activitynodelogid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for autoetl_activitynodeparam
-- ----------------------------
DROP TABLE IF EXISTS `autoetl_activitynodeparam`;
CREATE TABLE `autoetl_activitynodeparam`  (
  `activitynodeparamid` int(11) NOT NULL AUTO_INCREMENT,
  `paramidlist` varbinary(255) NULL DEFAULT NULL,
  `activitynodeid` int(11) NOT NULL,
  `paramid` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`activitynodeparamid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for autoetl_activitynodeprocp
-- ----------------------------
DROP TABLE IF EXISTS `autoetl_activitynodeprocp`;
CREATE TABLE `autoetl_activitynodeprocp`  (
  `activitynodeprocpid` int(11) NOT NULL AUTO_INCREMENT,
  `paramidlist` varbinary(255) NULL DEFAULT NULL,
  `activitynodeid` int(11) NOT NULL,
  `paramid` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`activitynodeprocpid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for autoetl_activitynoderelationf
-- ----------------------------
DROP TABLE IF EXISTS `autoetl_activitynoderelationf`;
CREATE TABLE `autoetl_activitynoderelationf`  (
  `activitynoderelationfid` int(11) NOT NULL AUTO_INCREMENT,
  `intorder` int(11) NOT NULL,
  `conditionjointype` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `conditiontype` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `strvalue` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `activitynodeforctid` int(11) NOT NULL,
  `relationfieldid` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`activitynoderelationfid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for autoetl_datasource
-- ----------------------------
DROP TABLE IF EXISTS `autoetl_datasource`;
CREATE TABLE `autoetl_datasource`  (
  `datasourceid` int(11) NOT NULL AUTO_INCREMENT,
  `sessionfactory` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `databasetype` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `discription` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `driver` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `dburl` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `dbuser` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `dbpassword` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`datasourceid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of autoetl_datasource
-- ----------------------------
INSERT INTO `autoetl_datasource` VALUES (1, 'test', 'mysql', '', 'com.mysql.jdbc.Driver', 'jdbc:mysql://localhost:3306/test', 'root', 'root');
INSERT INTO `autoetl_datasource` VALUES (2, 'SAFE', 'sqlserver', NULL, 'com.microsoft.sqlserver.jdbc.SQLServerDriver', 'jdbc:sqlserver://localhost:1433;DatabaseName=DataCenter', 'sa', 'transino');

-- ----------------------------
-- Table structure for autoetl_param
-- ----------------------------
DROP TABLE IF EXISTS `autoetl_param`;
CREATE TABLE `autoetl_param`  (
  `paramid` int(11) NOT NULL AUTO_INCREMENT,
  `discription` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `fieldtype` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `paramname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`paramid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for autoetl_procedure
-- ----------------------------
DROP TABLE IF EXISTS `autoetl_procedure`;
CREATE TABLE `autoetl_procedure`  (
  `procedureid` int(11) NOT NULL AUTO_INCREMENT,
  `discription` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `procedurename` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `proceduretype` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `datasourceid` int(11) NOT NULL,
  PRIMARY KEY (`procedureid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for autoetl_workflow
-- ----------------------------
DROP TABLE IF EXISTS `autoetl_workflow`;
CREATE TABLE `autoetl_workflow`  (
  `autoworkflowid` int(32) NOT NULL AUTO_INCREMENT,
  `endtime` int(11) NULL DEFAULT NULL,
  `errorwaittime` int(11) NULL DEFAULT NULL,
  `procesewaittime` int(11) NULL DEFAULT NULL,
  `starttime` int(11) NULL DEFAULT NULL,
  `strdiscription` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `streffectivetype` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `strparamvaluetype` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `strworkflowname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`autoworkflowid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of autoetl_workflow
-- ----------------------------
INSERT INTO `autoetl_workflow` VALUES (1, 24, 15, 30, 0, NULL, '2', '1', '工作流1');
INSERT INTO `autoetl_workflow` VALUES (2, 24, 15, 30, 0, NULL, '2', '1', '工作流2');
INSERT INTO `autoetl_workflow` VALUES (3, 24, 15, 30, 0, NULL, '2', '1', '工作流3');
INSERT INTO `autoetl_workflow` VALUES (6, 24, 15, 30, 0, NULL, '2', '1', '工作流6');

-- ----------------------------
-- Table structure for autoetl_workflowlog
-- ----------------------------
DROP TABLE IF EXISTS `autoetl_workflowlog`;
CREATE TABLE `autoetl_workflowlog`  (
  `workflowlogid` int(11) NOT NULL AUTO_INCREMENT,
  `dtdate` datetime NULL DEFAULT NULL,
  `content` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `discription` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `operationtype` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `param` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `resulttype` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `workflowid` int(11) NOT NULL,
  PRIMARY KEY (`workflowlogid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for autoetl_workflowparammv
-- ----------------------------
DROP TABLE IF EXISTS `autoetl_workflowparammv`;
CREATE TABLE `autoetl_workflowparammv`  (
  `workflowparammvid` int(11) NOT NULL AUTO_INCREMENT,
  `intgroup` int(11) NOT NULL,
  `discription` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `strvalue` varchar(4000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `paramid` int(11) NOT NULL,
  `workflowid` int(11) NOT NULL,
  PRIMARY KEY (`workflowparammvid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for autoetl_workflowpsdv
-- ----------------------------
DROP TABLE IF EXISTS `autoetl_workflowpsdv`;
CREATE TABLE `autoetl_workflowpsdv`  (
  `workflowpsdvid` int(11) NOT NULL,
  `discription` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `strvalue` int(11) NOT NULL,
  `paramID` int(11) NOT NULL,
  `workflowid` int(11) NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for autoetl_workflowsqlparam
-- ----------------------------
DROP TABLE IF EXISTS `autoetl_workflowsqlparam`;
CREATE TABLE `autoetl_workflowsqlparam`  (
  `sqlparamid` int(11) NOT NULL AUTO_INCREMENT,
  `datasourcesql` varchar(4000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `datasourceid` int(11) NOT NULL,
  `workflowid` int(11) NOT NULL,
  PRIMARY KEY (`sqlparamid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `author` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `piblish` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pages` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `price` decimal(10, 2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES (1, '解忧杂货铺', '东野圭吾', '电子出版社', '286', 27.50);
INSERT INTO `book` VALUES (2, '人间失格', '太宰治', '中信出版社', '300', 35.60);
INSERT INTO `book` VALUES (3, '摆渡人', '麦克富尔', '南海出版社', '225', 28.40);
INSERT INTO `book` VALUES (4, '白夜行', '东野圭吾', '作家出版社', '300', 26.00);
INSERT INTO `book` VALUES (7, 'Spring Boot', 'zhangsan', NULL, NULL, NULL);
INSERT INTO `book` VALUES (8, 'Spring Boot', 'zhangsan', NULL, NULL, NULL);
INSERT INTO `book` VALUES (9, 'Spring Boot', 'zhangsan', NULL, NULL, NULL);
INSERT INTO `book` VALUES (10, 'Spring Boot', 'zhangsan', NULL, NULL, NULL);
INSERT INTO `book` VALUES (11, 'Spring Boot', 'zhangsan', NULL, NULL, NULL);
INSERT INTO `book` VALUES (12, 'Spring Boot', 'zhangsan', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for image
-- ----------------------------
DROP TABLE IF EXISTS `image`;
CREATE TABLE `image`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `file_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content` longblob NULL,
  `group_01` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `group_02` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `group_03` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for reportmodel_field
-- ----------------------------
DROP TABLE IF EXISTS `reportmodel_field`;
CREATE TABLE `reportmodel_field`  (
  `fieldid` int(11) NOT NULL AUTO_INCREMENT,
  `iskey` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `isenable` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `nlength` int(11) NULL DEFAULT NULL,
  `nprecise` int(11) NULL DEFAULT NULL,
  `nseq` int(11) NOT NULL,
  `chinaname` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `constlist` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `dbconstlist` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `discription` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `emptytype` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `fieldname` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `fieldtype` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `logicemptytype` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `tableid` int(11) NOT NULL,
  PRIMARY KEY (`fieldid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for reportmodel_table
-- ----------------------------
DROP TABLE IF EXISTS `reportmodel_table`;
CREATE TABLE `reportmodel_table`  (
  `tableid` int(11) NOT NULL AUTO_INCREMENT,
  `addfields` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `autodto` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `checkinstance` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `chinaname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `discription` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tablename` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `datasourceid` int(11) NULL DEFAULT NULL,
  `suit` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`tableid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of reportmodel_table
-- ----------------------------
INSERT INTO `reportmodel_table` VALUES (2, '1', '1', '1', '1', '1', '1', 1, '1');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'test', '123');
INSERT INTO `user` VALUES (2, 'admin', 'admin');

-- ----------------------------
-- Procedure structure for test1
-- ----------------------------
DROP PROCEDURE IF EXISTS `test1`;
delimiter ;;
CREATE PROCEDURE `test1`(IN`dtDate` datetime)
BEGIN
	insert into `user` values('asd','dsaf',dtDate);
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for TESTp
-- ----------------------------
DROP PROCEDURE IF EXISTS `TESTp`;
delimiter ;;
CREATE PROCEDURE `TESTp`(`dtDate` datetime)
BEGIN   
    /* 定义变量 */  
    declare tmp0 VARCHAR(1000);  
    declare tmp1 VARCHAR(1000);  
    declare done int default -1;  -- 用于控制循环是否结束  
        
    /* 声明游标 */    
    declare myCursor cursor for select userName,`password` from user;    
        
    /* 当游标到达尾部时，mysql自动设置done=1 */       
    declare continue handler for not found set done=1;    
        
    /* 打开游标 */    
    open myCursor;    
        
    /* 循环开始 */    
    myLoop: LOOP    
        
        /* 移动游标并赋值 */    
        fetch myCursor into tmp0,tmp1;    
          
                -- 游标到达尾部,退出循环  
        if done = 1 then     
        leave myLoop;    
        end if;    
            
        /* do something */    
        -- 循环输出信息  
                select tmp0,tmp1 ;  
  
                -- 可以加入insert,update等语句  
        
    /* 循环结束 */    
    end loop myLoop;    
        
    /* 关闭游标 */    
    close myCursor;    
END
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
