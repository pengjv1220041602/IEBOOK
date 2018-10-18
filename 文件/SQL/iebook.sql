/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50723
Source Host           : localhost:3306
Source Database       : iebook

Target Server Type    : MYSQL
Target Server Version : 50723
File Encoding         : 65001

Date: 2018-10-17 18:05:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for aa
-- ----------------------------
DROP TABLE IF EXISTS `aa`;
CREATE TABLE `aa` (
  `id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of aa
-- ----------------------------
INSERT INTO `aa` VALUES ('2');

-- ----------------------------
-- Table structure for tbook
-- ----------------------------
DROP TABLE IF EXISTS `tbook`;
CREATE TABLE `tbook` (
  `id` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '用户编号',
  `name` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '图书名称',
  `kindid` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `isbn` varchar(40) COLLATE utf8_bin DEFAULT NULL COMMENT '图书的ISBN码',
  `path` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT 'pdf图书路径',
  `picpath` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '展示图书的图片',
  `detail` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '图书的简述',
  `examine` int(1) NOT NULL COMMENT '审核状态',
  `examineuid` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '审核人id',
  `downcount` int(10) DEFAULT '0' COMMENT '下载量',
  `onlinecount` int(10) DEFAULT '0' COMMENT '在线预览量',
  `author` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '上传者',
  `updateuid` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `createdate` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `updatedate` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `flag` int(1) NOT NULL COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tbook
-- ----------------------------
INSERT INTO `tbook` VALUES ('1', '1', 'b27940e28b734a97875c8effd8864dc5', '1111', '1111', '111', '111', '1', '1', '1', '1', '1', null, '2018-10-17 16:26:04', '2018-10-17 16:26:04', '1');
INSERT INTO `tbook` VALUES ('2', '1', 'd6381b624f70402885664e652bcbc43e', '1111', '1111', '111', '111', '1', '1', '1', '1', '1', '2', '2018-10-17 16:26:04', '2018-10-17 16:26:04', '1');
INSERT INTO `tbook` VALUES ('23', '1', 'f10a0bcedf484834b9b2c971ecb8bf8e', '1111', '1111', '111', '111', '1', '1', '1', '1', '1', '2', '2018-10-17 16:26:04', '2018-10-17 16:26:04', '1');
INSERT INTO `tbook` VALUES ('234r', '1', 'b27940e28b734a97875c8effd8864dc5', '1111', '1111', '111', '111', '1', '1', '1', '1', '1', '1', '2018-10-17 16:26:06', '2018-10-17 16:26:06', '1');
INSERT INTO `tbook` VALUES ('3ed2', '3', 'd6381b624f70402885664e652bcbc43e', null, null, null, '555', '0', null, '0', '0', '444', '1111111111111111111', '2018-10-17 16:26:06', '2018-10-17 16:26:06', '1');
INSERT INTO `tbook` VALUES ('cdscd', '3', 'f10a0bcedf484834b9b2c971ecb8bf8e', null, null, null, '555', '1', null, '0', '0', '444', '1111111111111111111', '2018-10-17 16:26:06', '2018-10-17 16:26:06', '1');
INSERT INTO `tbook` VALUES ('d953aaa68cb44644abc97a84d005d213', '3', 'b27940e28b734a97875c8effd8864dc5', null, null, null, '555', '0', '1', '0', '0', '444', '2', '2018-10-17 15:41:44', '2018-10-17 15:41:44', '1');
INSERT INTO `tbook` VALUES ('dsdd', '1', 'd6381b624f70402885664e652bcbc43e', '1111', '1111', '111', '111', '1', '11', '1', '1', '1', '1', '2018-10-17 16:26:07', '2018-10-17 16:26:07', '1');
INSERT INTO `tbook` VALUES ('dwed', '1', 'f10a0bcedf484834b9b2c971ecb8bf8e', '1111', '1111', '111', '111', '1', '11', '1', '1', '1', '1', '2018-10-17 16:26:07', '2018-10-17 16:26:07', '1');
INSERT INTO `tbook` VALUES ('e23', '1', 'b27940e28b734a97875c8effd8864dc5', '1111', '1111', '111', '111', '1', '11', '1', '1', '1', null, '2018-10-17 16:26:10', '2018-10-17 16:26:10', '1');
INSERT INTO `tbook` VALUES ('ew', '1', 'd6381b624f70402885664e652bcbc43e', '1111', '1111', '111', '111', '1', '11', '1', '1', '1', null, '2018-10-17 16:26:10', '2018-10-17 16:26:10', '1');
INSERT INTO `tbook` VALUES ('fe', '3', 'f10a0bcedf484834b9b2c971ecb8bf8e', null, null, null, '555', '0', '1', '0', '0', '444', '1111111111111111111', '2018-10-17 16:26:10', '2018-10-17 16:26:10', '1');
INSERT INTO `tbook` VALUES ('sd', '1', 'b27940e28b734a97875c8effd8864dc5', '1111', '1111', '111', '111', '1', '11', '1', '1', '1', '1', '2018-10-17 16:26:12', '2018-10-17 16:26:12', '1');
INSERT INTO `tbook` VALUES ('wa', '1', 'd6381b624f70402885664e652bcbc43e', '1111', '1111', '111', '111', '1', '11', '1', '1', '1', null, '2018-10-17 16:26:12', '2018-10-17 16:26:12', '1');
INSERT INTO `tbook` VALUES ('wec', '3', 'f10a0bcedf484834b9b2c971ecb8bf8e', null, null, null, '555', '0', null, '0', '0', '444', '1', '2018-10-17 16:26:13', '2018-10-17 16:26:13', '1');

-- ----------------------------
-- Table structure for tkind
-- ----------------------------
DROP TABLE IF EXISTS `tkind`;
CREATE TABLE `tkind` (
  `id` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '分类id',
  `name` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '分类名称',
  `createdate` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `updatedate` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `createuid` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `flag` int(1) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tkind
-- ----------------------------
INSERT INTO `tkind` VALUES ('b27940e28b734a97875c8effd8864dc5', '计算机类', '2018-10-16 23:06:40', '2018-10-16 23:06:40', '111111111111', '1');
INSERT INTO `tkind` VALUES ('d6381b624f70402885664e652bcbc43e', '经济管理类', '2018-10-16 23:06:48', '2018-10-16 23:06:48', '111111111111', '1');
INSERT INTO `tkind` VALUES ('f10a0bcedf484834b9b2c971ecb8bf8e', '传媒信息类', '2018-10-16 23:06:59', '2018-10-16 23:06:59', '111111111111', '1');

-- ----------------------------
-- Table structure for tuser
-- ----------------------------
DROP TABLE IF EXISTS `tuser`;
CREATE TABLE `tuser` (
  `id` varchar(64) COLLATE utf8_bin NOT NULL,
  `name` varchar(20) COLLATE utf8_bin NOT NULL,
  `username` varchar(20) COLLATE utf8_bin NOT NULL,
  `password` varchar(20) COLLATE utf8_bin NOT NULL,
  `power` int(1) NOT NULL,
  `createdate` datetime DEFAULT NULL,
  `updatedate` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `flag` int(1) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tuser
-- ----------------------------
INSERT INTO `tuser` VALUES ('053e1857b8164ac8914a02cc41e8671e', 'save', '', '', '1', null, null, '1');
INSERT INTO `tuser` VALUES ('1', 'update', '', '', '1', '2018-10-15 14:36:59', '2018-10-15 14:57:24', '1');
INSERT INTO `tuser` VALUES ('2', 'la2', '', '', '2', null, null, '2');
INSERT INTO `tuser` VALUES ('3', 'la3', '', '', '3', null, null, '3');
INSERT INTO `tuser` VALUES ('4', 'la1', '', '', '1', null, null, '1');
INSERT INTO `tuser` VALUES ('9cd313a187584a1388ac908df1f0724a', 'save', '', '', '1', '2018-10-15 14:52:49', '2018-10-15 14:52:49', '1');
INSERT INTO `tuser` VALUES ('admin1', 'admin1', 'admin1', 'admin1', '1', '2018-10-16 14:03:39', '2018-10-16 14:03:43', '1');
INSERT INTO `tuser` VALUES ('c885ae5a77374312bfaacfe234aa1385', 'save', '', '', '1', null, null, '1');
INSERT INTO `tuser` VALUES ('f2ceb780aa7340cca005ae3b36965043', 'save', '', '', '1', '2018-10-15 14:57:24', '2018-10-15 14:57:24', '1');

-- ----------------------------
-- Table structure for tuserbook
-- ----------------------------
DROP TABLE IF EXISTS `tuserbook`;
CREATE TABLE `tuserbook` (
  `bookid` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '图书编号',
  `userid` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '用户编号',
  `likecount` int(10) DEFAULT NULL COMMENT '点赞量',
  `hatecount` int(10) DEFAULT NULL COMMENT '踩量',
  `favourite` int(1) DEFAULT NULL,
  `createdate` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `updatedate` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `flag` int(1) DEFAULT NULL COMMENT '删除标志',
  PRIMARY KEY (`bookid`,`userid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tuserbook
-- ----------------------------
SET FOREIGN_KEY_CHECKS=1;
