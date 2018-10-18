/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50723
 Source Host           : localhost:3306
 Source Schema         : iebook

 Target Server Type    : MySQL
 Target Server Version : 50723
 File Encoding         : 65001

 Date: 18/10/2018 23:53:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for aa
-- ----------------------------
DROP TABLE IF EXISTS `aa`;
CREATE TABLE `aa`  (
  `id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of aa
-- ----------------------------
INSERT INTO `aa` VALUES (2);

-- ----------------------------
-- Table structure for tbook
-- ----------------------------
DROP TABLE IF EXISTS `tbook`;
CREATE TABLE `tbook`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '用户编号',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '图书名称',
  `kindid` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `isbn` varchar(40) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '图书的ISBN码',
  `path` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT 'pdf图书路径',
  `picpath` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '展示图书的图片',
  `detail` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '图书的简述',
  `examine` int(1) NOT NULL COMMENT '审核状态',
  `examineuid` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '审核人id',
  `downcount` int(10) DEFAULT 0 COMMENT '下载量',
  `onlinecount` int(10) DEFAULT 0 COMMENT '在线预览量',
  `author` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '上传者',
  `updateuid` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `createdate` datetime(0) DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `updatedate` datetime(0) DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `flag` int(1) NOT NULL COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbook
-- ----------------------------
INSERT INTO `tbook` VALUES ('801de68299bb41c7a25f928a3bc70bb4', '哈哈', 'b27940e28b734a97875c8effd8864dc5', NULL, '\\b27940e28b734a97875c8effd8864dc5\\2018918\\a86ba88b2b9248e59c9ecc22b6707409.pdf', '\\b27940e28b734a97875c8effd8864dc5\\2018918\\91a6436cf5bf4c6aabf4e6f93a2ee91e.jpg', '啊啊啊啊啊啊啊啊啊啊啊啊啊啊', 1, NULL, 12, 7, '三十', '1111111111111111111', '2018-10-18 22:50:28', '2018-10-18 22:50:29', 1);
INSERT INTO `tbook` VALUES ('bf336d77f9a44522aa9d1454e45deb5e', '呵呵', 'b27940e28b734a97875c8effd8864dc5', NULL, '\\b27940e28b734a97875c8effd8864dc5\\2018918\\89b34f6995b6490e9abd91d579902e3c.pdf', '\\b27940e28b734a97875c8effd8864dc5\\2018918\\219889cf2e044501b8b2dbc45826b8ba.jpg', '饿烦烦烦烦烦烦烦烦烦', 1, NULL, 14, 4, '拉拉', '1111111111111111111', '2018-10-18 22:50:39', '2018-10-18 22:50:39', 1);

-- ----------------------------
-- Table structure for tkind
-- ----------------------------
DROP TABLE IF EXISTS `tkind`;
CREATE TABLE `tkind`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '分类id',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '分类名称',
  `createdate` datetime(0) DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `updatedate` datetime(0) DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `createuid` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `flag` int(1) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tkind
-- ----------------------------
INSERT INTO `tkind` VALUES ('b27940e28b734a97875c8effd8864dc5', '计算机类', '2018-10-16 23:06:40', '2018-10-16 23:06:40', '111111111111', 1);
INSERT INTO `tkind` VALUES ('d6381b624f70402885664e652bcbc43e', '经济管理类', '2018-10-16 23:06:48', '2018-10-16 23:06:48', '111111111111', 1);
INSERT INTO `tkind` VALUES ('f10a0bcedf484834b9b2c971ecb8bf8e', '传媒信息类', '2018-10-16 23:06:59', '2018-10-16 23:06:59', '111111111111', 1);

-- ----------------------------
-- Table structure for tlog
-- ----------------------------
DROP TABLE IF EXISTS `tlog`;
CREATE TABLE `tlog`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `bookid` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `lineordown` int(1) DEFAULT NULL,
  `flag` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `createdate` datetime(0) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tlog
-- ----------------------------
INSERT INTO `tlog` VALUES ('14ab415b6a8e4e269316a698c10a92f9', '801de68299bb41c7a25f928a3bc70bb4', 2, '1', '2018-10-18 21:54:41');
INSERT INTO `tlog` VALUES ('1ec73c23bcb641e6bb9fd6b049895016', '801de68299bb41c7a25f928a3bc70bb4', 1, '1', '2018-10-18 20:59:36');
INSERT INTO `tlog` VALUES ('1f02304c09e044248365895709d67243', 'bf336d77f9a44522aa9d1454e45deb5e', 1, '1', '2018-10-18 21:32:45');
INSERT INTO `tlog` VALUES ('2019d85134ba43568a6d53920f168a2e', '801de68299bb41c7a25f928a3bc70bb4', 1, '1', '2018-10-18 20:58:56');
INSERT INTO `tlog` VALUES ('277d0b02c9d8421ba82daeef41987c40', 'bf336d77f9a44522aa9d1454e45deb5e', 2, '1', '2018-10-18 22:04:29');
INSERT INTO `tlog` VALUES ('27d74cf84a674a13b19e61dedf4222aa', '801de68299bb41c7a25f928a3bc70bb4', 1, '1', '2018-10-18 20:57:51');
INSERT INTO `tlog` VALUES ('295406f0ff644ef1998512acf46d3ff1', '801de68299bb41c7a25f928a3bc70bb4', 2, '1', '2018-10-18 22:50:29');
INSERT INTO `tlog` VALUES ('2f0eddb4d3544d758794349161d37f65', 'bf336d77f9a44522aa9d1454e45deb5e', 2, '1', '2018-10-18 21:54:36');
INSERT INTO `tlog` VALUES ('338c88ce546644e79e18f3fea285274a', '801de68299bb41c7a25f928a3bc70bb4', 1, '1', '2018-10-18 22:05:59');
INSERT INTO `tlog` VALUES ('3690b84c9e204ffb8df2cef3b22bb543', '801de68299bb41c7a25f928a3bc70bb4', 2, '1', '2018-10-18 22:06:38');
INSERT INTO `tlog` VALUES ('3b38cc1a39aa4cb099bb96679400536a', 'bf336d77f9a44522aa9d1454e45deb5e', 2, '1', '2018-10-18 22:36:26');
INSERT INTO `tlog` VALUES ('3bd0e50d531b4207bd8fc86121bba3ce', 'bf336d77f9a44522aa9d1454e45deb5e', 1, '1', '2018-10-18 22:50:38');
INSERT INTO `tlog` VALUES ('445d4a58cf71485ba19ebbdf7654b58f', '801de68299bb41c7a25f928a3bc70bb4', 2, '1', '2018-10-18 22:29:54');
INSERT INTO `tlog` VALUES ('5d180b514503471d83474707a99b4fd8', 'bf336d77f9a44522aa9d1454e45deb5e', 2, '1', '2018-10-18 22:36:28');
INSERT INTO `tlog` VALUES ('6caf7189dcc649ecb947a6cd00c9f557', '801de68299bb41c7a25f928a3bc70bb4', 2, '1', '2018-10-18 22:31:34');
INSERT INTO `tlog` VALUES ('6fc18a0b956540adb11b2dd714597673', '801de68299bb41c7a25f928a3bc70bb4', 2, '1', '2018-10-18 22:09:43');
INSERT INTO `tlog` VALUES ('733d7ab579764c658b49523adafa880a', 'bf336d77f9a44522aa9d1454e45deb5e', 1, '1', '2018-10-18 22:05:56');
INSERT INTO `tlog` VALUES ('7cfccaa561724a1cb109bd330af8e53a', 'bf336d77f9a44522aa9d1454e45deb5e', 1, '1', '2018-10-18 21:39:56');
INSERT INTO `tlog` VALUES ('8e0133a457dd42d693e5f9907c31cb46', 'bf336d77f9a44522aa9d1454e45deb5e', 2, '1', '2018-10-18 22:07:08');
INSERT INTO `tlog` VALUES ('97c7cb4009884e1a893ec52c4850cfd2', 'bf336d77f9a44522aa9d1454e45deb5e', 2, '1', '2018-10-18 22:31:13');
INSERT INTO `tlog` VALUES ('9b5ee1e8916d4d8484f809cc83f1b043', '801de68299bb41c7a25f928a3bc70bb4', 2, '1', '2018-10-18 22:15:47');
INSERT INTO `tlog` VALUES ('9f56beddc4484b9685f1d799b5311ce2', 'bf336d77f9a44522aa9d1454e45deb5e', 2, '1', '2018-10-18 22:30:05');
INSERT INTO `tlog` VALUES ('a0ab122df6a44a6790a85f7fffcfb21e', '801de68299bb41c7a25f928a3bc70bb4', 2, '1', '2018-10-18 22:26:31');
INSERT INTO `tlog` VALUES ('a1641f0487bf4076b1d66c977e48487b', 'bf336d77f9a44522aa9d1454e45deb5e', 2, '1', '2018-10-18 22:50:28');
INSERT INTO `tlog` VALUES ('a9ece2cf66c44fd59dba5b3737741807', '801de68299bb41c7a25f928a3bc70bb4', 1, '1', '2018-10-18 21:02:05');
INSERT INTO `tlog` VALUES ('b023b3fe1a904fcdaaa7585208af152b', 'bf336d77f9a44522aa9d1454e45deb5e', 2, '1', '2018-10-18 21:41:04');
INSERT INTO `tlog` VALUES ('bcba0f0b8dcd44e2823620674e80ecd7', '801de68299bb41c7a25f928a3bc70bb4', 2, '1', '2018-10-18 22:36:05');
INSERT INTO `tlog` VALUES ('c16d69c68ce64ad0977b1b25f540a99c', '801de68299bb41c7a25f928a3bc70bb4', 1, '1', '2018-10-18 20:57:02');
INSERT INTO `tlog` VALUES ('ca914e9a56e94097bb529c5d482ff770', 'bf336d77f9a44522aa9d1454e45deb5e', 2, '1', '2018-10-18 22:36:16');
INSERT INTO `tlog` VALUES ('cad3a87f323b4675a9939a12095afcef', '801de68299bb41c7a25f928a3bc70bb4', 2, '1', '2018-10-18 22:36:06');
INSERT INTO `tlog` VALUES ('d3ff80b327844de189c071b7cb31915b', '801de68299bb41c7a25f928a3bc70bb4', 2, '1', '2018-10-18 22:36:07');
INSERT INTO `tlog` VALUES ('dddacf2df2e44a0fadb28ba284462f2a', 'bf336d77f9a44522aa9d1454e45deb5e', 2, '1', '2018-10-18 22:08:02');
INSERT INTO `tlog` VALUES ('e486237a3b9d4a9686d52a646f511dfd', '801de68299bb41c7a25f928a3bc70bb4', 2, '1', '2018-10-18 22:03:30');
INSERT INTO `tlog` VALUES ('e4a366ed7d8d407cbfd81948ffa9620f', 'bf336d77f9a44522aa9d1454e45deb5e', 2, '1', '2018-10-18 21:40:03');
INSERT INTO `tlog` VALUES ('f3a8d63aa6ff450887930e2416d44aa9', 'bf336d77f9a44522aa9d1454e45deb5e', 2, '1', '2018-10-18 21:55:39');
INSERT INTO `tlog` VALUES ('f81515ba4c1141bca6efd50fa34f6a14', 'bf336d77f9a44522aa9d1454e45deb5e', 2, '1', '2018-10-18 22:29:42');
INSERT INTO `tlog` VALUES ('fa366fdf70674c9c9d848284f9e55f28', '801de68299bb41c7a25f928a3bc70bb4', 1, '1', '2018-10-18 22:05:49');

-- ----------------------------
-- Table structure for tuser
-- ----------------------------
DROP TABLE IF EXISTS `tuser`;
CREATE TABLE `tuser`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `power` int(1) NOT NULL,
  `createdate` datetime(0) DEFAULT NULL,
  `updatedate` datetime(0) DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `flag` int(1) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tuser
-- ----------------------------
INSERT INTO `tuser` VALUES ('f0c4ac4d6a724be39c317e346ff6ff70', 'admin', 'admin', 'admin', 1, '2018-10-18 22:52:01', '2018-10-18 22:52:17', 1);

-- ----------------------------
-- Table structure for tuserbook
-- ----------------------------
DROP TABLE IF EXISTS `tuserbook`;
CREATE TABLE `tuserbook`  (
  `bookid` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '图书编号',
  `userid` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '用户编号',
  `likecount` int(10) DEFAULT NULL COMMENT '点赞量',
  `hatecount` int(10) DEFAULT NULL COMMENT '踩量',
  `favourite` int(1) DEFAULT NULL,
  `createdate` datetime(0) DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `updatedate` datetime(0) DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `flag` int(1) DEFAULT NULL COMMENT '删除标志',
  PRIMARY KEY (`bookid`, `userid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
