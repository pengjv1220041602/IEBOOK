/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50723
Source Host           : localhost:3306
Source Database       : iebook

Target Server Type    : MYSQL
Target Server Version : 50723
File Encoding         : 65001

Date: 2018-10-23 17:11:27
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
  `createdate` datetime DEFAULT NULL,
  `updatedate` datetime DEFAULT NULL,
  `flag` int(1) NOT NULL COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tbook
-- ----------------------------
INSERT INTO `tbook` VALUES ('099b02c0f09b4f9a839235b2b2d2a3d4', 'lalla', 'b27940e28b734a97875c8effd8864dc5', null, '\\b27940e28b734a97875c8effd8864dc5\\2018922\\2d8ed0d119834d1794766a093bc5e472.pdf', '\\b27940e28b734a97875c8effd8864dc5\\2018922\\89b660a246084a63bc497a71128044f4.png', 'eeee', '1', 'f0c4ac4d6a724be39c317e346ff6ff70', '7', '7', 'AA', null, '2018-10-22 14:24:29', '2018-10-22 14:24:29', '1');
INSERT INTO `tbook` VALUES ('2cff0f27a7494767b5d7a9e5ecba5c39', '333', 'd6381b624f70402885664e652bcbc43e', null, '\\d6381b624f70402885664e652bcbc43e\\2018923\\507ad657aa974711a711511b5d9062e7.pdf', '\\d6381b624f70402885664e652bcbc43e\\2018923\\b2f56ea15e0248a69f220285a6d0ae58.png', '55', '1', 'f0c4ac4d6a724be39c317e346ff6ff70', '5', '4', '444', 'f0c4ac4d6a724be39c317e346ff6ff70', '2018-10-22 14:24:29', '2018-10-22 14:24:29', '1');
INSERT INTO `tbook` VALUES ('5217ef792c3b401d8263ce234f632457', '333', 'd6381b624f70402885664e652bcbc43e', null, '\\d6381b624f70402885664e652bcbc43e\\2018923\\5b7228d20cc344ad94f6b13e52527de3.pdf', '\\d6381b624f70402885664e652bcbc43e\\2018923\\7c4f61515bc74ba589a0ab9945001ccd.png', '44', '0', 'f0c4ac4d6a724be39c317e346ff6ff70', '0', '1', '444', 'f0c4ac4d6a724be39c317e346ff6ff70', '2018-10-22 14:24:29', '2018-10-22 14:24:29', '1');
INSERT INTO `tbook` VALUES ('73e1d575cbc44cf8a1f4a90db275f38b', 'Book1', 'd6381b624f70402885664e652bcbc43e', null, '\\d6381b624f70402885664e652bcbc43e\\2018922\\aa41f192963448a5b6729ed66889a092.pdf', '\\d6381b624f70402885664e652bcbc43e\\2018922\\01a80801e57144dd9107a6832b6762f8.png', 'IEBOOK1', '1', 'f0c4ac4d6a724be39c317e346ff6ff70', '2', '10', 'IE1', 'f0c4ac4d6a724be39c317e346ff6ff70', '2018-10-22 14:24:29', '2018-10-22 14:24:29', '1');
INSERT INTO `tbook` VALUES ('801de68299bb41c7a25f928a3bc70bb4', '哈哈', 'b27940e28b734a97875c8effd8864dc5', null, '\\b27940e28b734a97875c8effd8864dc5\\2018918\\a86ba88b2b9248e59c9ecc22b6707409.pdf', '\\b27940e28b734a97875c8effd8864dc5\\2018918\\91a6436cf5bf4c6aabf4e6f93a2ee91e.jpg', '啊啊啊啊啊啊啊啊啊啊啊啊啊啊', '1', 'f0c4ac4d6a724be39c317e346ff6ff70', '14', '15', '三十', 'f0c4ac4d6a724be39c317e346ff6ff70', '2018-10-23 14:25:56', '2018-10-23 14:58:29', '0');
INSERT INTO `tbook` VALUES ('bf336d77f9a44522aa9d1454e45deb5e', '呵呵', 'b27940e28b734a97875c8effd8864dc5', null, '\\b27940e28b734a97875c8effd8864dc5\\2018918\\89b34f6995b6490e9abd91d579902e3c.pdf', '\\b27940e28b734a97875c8effd8864dc5\\2018918\\219889cf2e044501b8b2dbc45826b8ba.jpg', '饿烦烦烦烦烦烦烦烦烦', '1', 'f0c4ac4d6a724be39c317e346ff6ff70', '14', '6', '拉拉', 'f0c4ac4d6a724be39c317e346ff6ff70', '2018-10-22 14:24:29', '2018-10-22 14:24:29', '1');

-- ----------------------------
-- Table structure for tkind
-- ----------------------------
DROP TABLE IF EXISTS `tkind`;
CREATE TABLE `tkind` (
  `id` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '分类id',
  `name` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '分类名称',
  `createdate` datetime DEFAULT NULL,
  `updatedate` datetime DEFAULT NULL,
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
-- Table structure for tlog
-- ----------------------------
DROP TABLE IF EXISTS `tlog`;
CREATE TABLE `tlog` (
  `id` varchar(64) COLLATE utf8_bin NOT NULL,
  `bookid` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `lineordown` int(1) DEFAULT NULL,
  `flag` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `createdate` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tlog
-- ----------------------------
INSERT INTO `tlog` VALUES ('017571002f0444c2a9d55fcb84618297', '099b02c0f09b4f9a839235b2b2d2a3d4', '1', '1', '2018-10-22 17:59:08');
INSERT INTO `tlog` VALUES ('063ef34a4fd54e4b8d70e7149df78d04', '801de68299bb41c7a25f928a3bc70bb4', '1', '1', '2018-10-23 14:27:43');
INSERT INTO `tlog` VALUES ('0ad13118cb324334983eac8e7a150f4f', '801de68299bb41c7a25f928a3bc70bb4', '1', '1', '2018-10-23 14:27:37');
INSERT INTO `tlog` VALUES ('103cf6b6928e480c95f5991a70ef303e', '099b02c0f09b4f9a839235b2b2d2a3d4', '2', '1', '2018-10-23 17:00:49');
INSERT INTO `tlog` VALUES ('14ab415b6a8e4e269316a698c10a92f9', '801de68299bb41c7a25f928a3bc70bb4', '2', '1', '2018-10-23 00:00:00');
INSERT INTO `tlog` VALUES ('1db9cef7e73c4035addc49ef568d9245', '2cff0f27a7494767b5d7a9e5ecba5c39', '2', '1', '2018-10-23 14:20:10');
INSERT INTO `tlog` VALUES ('1ec73c23bcb641e6bb9fd6b049895016', '801de68299bb41c7a25f928a3bc70bb4', '1', '1', '2018-10-23 00:00:00');
INSERT INTO `tlog` VALUES ('1f02304c09e044248365895709d67243', 'bf336d77f9a44522aa9d1454e45deb5e', '1', '1', '2018-10-23 00:00:00');
INSERT INTO `tlog` VALUES ('1f699f57c00d469089f3b1530219c3b6', '73e1d575cbc44cf8a1f4a90db275f38b', '1', '1', '2018-10-22 18:00:14');
INSERT INTO `tlog` VALUES ('2019d85134ba43568a6d53920f168a2e', '801de68299bb41c7a25f928a3bc70bb4', '1', '1', '2018-10-26 21:41:04');
INSERT INTO `tlog` VALUES ('2222', '801de68299bb41c7a25f928a3bc70bb4', '1', '1', '2018-10-18 22:05:49');
INSERT INTO `tlog` VALUES ('2299cc4f3176460ea51910a2088dc2b4', '099b02c0f09b4f9a839235b2b2d2a3d4', '2', '1', '2018-10-23 10:45:38');
INSERT INTO `tlog` VALUES ('2572979d33814ec8a544214277e5abd2', '099b02c0f09b4f9a839235b2b2d2a3d4', '2', '1', '2018-10-23 14:19:59');
INSERT INTO `tlog` VALUES ('277d0b02c9d8421ba82daeef41987c40', 'bf336d77f9a44522aa9d1454e45deb5e', '2', '1', '2018-10-23 00:00:00');
INSERT INTO `tlog` VALUES ('27d74cf84a674a13b19e61dedf4222aa', '801de68299bb41c7a25f928a3bc70bb4', '1', '1', '2018-10-23 00:00:00');
INSERT INTO `tlog` VALUES ('295406f0ff644ef1998512acf46d3ff1', '801de68299bb41c7a25f928a3bc70bb4', '2', '1', '2018-10-26 21:41:04');
INSERT INTO `tlog` VALUES ('2c75ca71fe19410fa48f08f454a8e395', '73e1d575cbc44cf8a1f4a90db275f38b', '1', '1', '2018-10-23 10:45:39');
INSERT INTO `tlog` VALUES ('2eb210d8b171445b8f72b7554d05455b', '73e1d575cbc44cf8a1f4a90db275f38b', '2', '1', '2018-10-22 18:00:26');
INSERT INTO `tlog` VALUES ('2f0eddb4d3544d758794349161d37f65', 'bf336d77f9a44522aa9d1454e45deb5e', '2', '1', '2018-10-23 00:00:00');
INSERT INTO `tlog` VALUES ('338c88ce546644e79e18f3fea285274a', '801de68299bb41c7a25f928a3bc70bb4', '1', '1', '2018-10-23 00:00:00');
INSERT INTO `tlog` VALUES ('3690b84c9e204ffb8df2cef3b22bb543', '801de68299bb41c7a25f928a3bc70bb4', '2', '1', '2018-10-18 22:06:38');
INSERT INTO `tlog` VALUES ('3b38cc1a39aa4cb099bb96679400536a', 'bf336d77f9a44522aa9d1454e45deb5e', '2', '1', '2018-10-24 22:36:26');
INSERT INTO `tlog` VALUES ('3bd0e50d531b4207bd8fc86121bba3ce', 'bf336d77f9a44522aa9d1454e45deb5e', '1', '1', '2018-10-18 22:50:38');
INSERT INTO `tlog` VALUES ('4052f7eb60be483ca27616996a99fe0f', 'bf336d77f9a44522aa9d1454e45deb5e', '1', '1', '2018-10-23 14:27:34');
INSERT INTO `tlog` VALUES ('445d4a58cf71485ba19ebbdf7654b58f', '801de68299bb41c7a25f928a3bc70bb4', '2', '1', '2018-10-24 22:36:26');
INSERT INTO `tlog` VALUES ('466f182386194aefa0b4a72fa17e023b', '801de68299bb41c7a25f928a3bc70bb4', '1', '1', '2018-10-23 14:22:23');
INSERT INTO `tlog` VALUES ('4c480bcca2664417832a434a8aab3831', '2cff0f27a7494767b5d7a9e5ecba5c39', '2', '1', '2018-10-23 14:22:05');
INSERT INTO `tlog` VALUES ('4ed948ceb19d4b009e38fb7783447d7d', '099b02c0f09b4f9a839235b2b2d2a3d4', '1', '1', '2018-10-23 14:18:44');
INSERT INTO `tlog` VALUES ('4f6860dc96444756899bba2d73cdb400', '73e1d575cbc44cf8a1f4a90db275f38b', '1', '1', '2018-10-23 14:27:57');
INSERT INTO `tlog` VALUES ('55e48046129f4a2bbb8e7c079de50684', '801de68299bb41c7a25f928a3bc70bb4', '1', '1', '2018-10-23 14:27:48');
INSERT INTO `tlog` VALUES ('567fbda59ed242e7ac1984e60543f6ba', '099b02c0f09b4f9a839235b2b2d2a3d4', '2', '1', '2018-10-23 14:28:16');
INSERT INTO `tlog` VALUES ('5d180b514503471d83474707a99b4fd8', 'bf336d77f9a44522aa9d1454e45deb5e', '2', '1', '2018-10-26 21:41:04');
INSERT INTO `tlog` VALUES ('6caf7189dcc649ecb947a6cd00c9f557', '801de68299bb41c7a25f928a3bc70bb4', '2', '1', '2018-10-18 22:31:34');
INSERT INTO `tlog` VALUES ('6fc18a0b956540adb11b2dd714597673', '801de68299bb41c7a25f928a3bc70bb4', '2', '1', '2018-10-24 22:36:26');
INSERT INTO `tlog` VALUES ('70023b8bc082413c834b815aa2022ae1', '099b02c0f09b4f9a839235b2b2d2a3d4', '1', '1', '2018-10-23 14:27:46');
INSERT INTO `tlog` VALUES ('7063db9265584871b4e95a9bd359660f', '801de68299bb41c7a25f928a3bc70bb4', '1', '1', '2018-10-23 13:42:13');
INSERT INTO `tlog` VALUES ('733d7ab579764c658b49523adafa880a', 'bf336d77f9a44522aa9d1454e45deb5e', '1', '1', '2018-10-18 22:05:56');
INSERT INTO `tlog` VALUES ('74cf7d079a864eacb1a014c794e42923', '73e1d575cbc44cf8a1f4a90db275f38b', '1', '1', '2018-10-22 18:00:23');
INSERT INTO `tlog` VALUES ('7a3ffee55c90450b8f26ad299493df12', '2cff0f27a7494767b5d7a9e5ecba5c39', '1', '1', '2018-10-23 17:00:57');
INSERT INTO `tlog` VALUES ('7cfccaa561724a1cb109bd330af8e53a', 'bf336d77f9a44522aa9d1454e45deb5e', '1', '1', '2018-10-18 21:39:56');
INSERT INTO `tlog` VALUES ('81b361607dbf4ceba6b1aa80bc2c6d98', '801de68299bb41c7a25f928a3bc70bb4', '2', '1', '2018-10-25 17:56:46');
INSERT INTO `tlog` VALUES ('8b604665a32d4ba7a834255235d223dd', '099b02c0f09b4f9a839235b2b2d2a3d4', '1', '1', '2018-10-23 14:27:45');
INSERT INTO `tlog` VALUES ('8c367d1e0c454845b95b0df6d24e3b26', '2cff0f27a7494767b5d7a9e5ecba5c39', '1', '1', '2018-10-23 13:38:10');
INSERT INTO `tlog` VALUES ('8e0133a457dd42d693e5f9907c31cb46', 'bf336d77f9a44522aa9d1454e45deb5e', '2', '1', '2018-10-25 17:56:46');
INSERT INTO `tlog` VALUES ('90d561361e8140258ec855009e1d5eac', '801de68299bb41c7a25f928a3bc70bb4', '2', '1', '2018-10-23 14:45:09');
INSERT INTO `tlog` VALUES ('9342fa36dc984bb3a410ae4b8dad2bcf', '099b02c0f09b4f9a839235b2b2d2a3d4', '1', '1', '2018-10-23 14:24:29');
INSERT INTO `tlog` VALUES ('97c7cb4009884e1a893ec52c4850cfd2', 'bf336d77f9a44522aa9d1454e45deb5e', '2', '1', '2018-10-18 22:31:13');
INSERT INTO `tlog` VALUES ('9876ef4f53c240dcba9b4b1c0fc716bc', '099b02c0f09b4f9a839235b2b2d2a3d4', '1', '1', '2018-10-23 13:40:21');
INSERT INTO `tlog` VALUES ('9b5ee1e8916d4d8484f809cc83f1b043', '801de68299bb41c7a25f928a3bc70bb4', '2', '1', '2018-10-18 22:15:47');
INSERT INTO `tlog` VALUES ('9d42ae0650fc40b097b1eb8191254794', '099b02c0f09b4f9a839235b2b2d2a3d4', '2', '1', '2018-10-23 14:18:48');
INSERT INTO `tlog` VALUES ('9db74adca87c43d4aef5ea8388bfbe0c', '2cff0f27a7494767b5d7a9e5ecba5c39', '2', '1', '2018-10-23 14:20:05');
INSERT INTO `tlog` VALUES ('9f56beddc4484b9685f1d799b5311ce2', 'bf336d77f9a44522aa9d1454e45deb5e', '2', '1', '2018-10-18 22:30:05');
INSERT INTO `tlog` VALUES ('a0ab122df6a44a6790a85f7fffcfb21e', '801de68299bb41c7a25f928a3bc70bb4', '2', '1', '2018-10-25 17:56:46');
INSERT INTO `tlog` VALUES ('a1641f0487bf4076b1d66c977e48487b', 'bf336d77f9a44522aa9d1454e45deb5e', '2', '1', '2018-10-18 22:50:28');
INSERT INTO `tlog` VALUES ('a20b0e871c6a4f5dbf24625785bc6e3b', '2cff0f27a7494767b5d7a9e5ecba5c39', '1', '1', '2018-10-23 13:37:40');
INSERT INTO `tlog` VALUES ('a621a5ed95324ccda6b7b6ae3ba8228b', '73e1d575cbc44cf8a1f4a90db275f38b', '1', '1', '2018-10-23 13:37:23');
INSERT INTO `tlog` VALUES ('a9ece2cf66c44fd59dba5b3737741807', '801de68299bb41c7a25f928a3bc70bb4', '1', '1', '2018-10-18 21:02:05');
INSERT INTO `tlog` VALUES ('b023b3fe1a904fcdaaa7585208af152b', 'bf336d77f9a44522aa9d1454e45deb5e', '2', '1', '2018-10-26 21:41:04');
INSERT INTO `tlog` VALUES ('b17ae4184e3b4ff6b2ac36f7defe1fc6', '73e1d575cbc44cf8a1f4a90db275f38b', '1', '1', '2018-10-23 14:28:01');
INSERT INTO `tlog` VALUES ('b32825ce000f491abecf0fec91ef9508', '73e1d575cbc44cf8a1f4a90db275f38b', '2', '1', '2018-10-23 14:20:21');
INSERT INTO `tlog` VALUES ('b885f9883672426aa723be04494f4534', '2cff0f27a7494767b5d7a9e5ecba5c39', '1', '1', '2018-10-23 13:41:42');
INSERT INTO `tlog` VALUES ('bb6fdd5c2fff46289961b82fbe83347a', '2cff0f27a7494767b5d7a9e5ecba5c39', '2', '1', '2018-10-23 14:20:17');
INSERT INTO `tlog` VALUES ('bcba0f0b8dcd44e2823620674e80ecd7', '801de68299bb41c7a25f928a3bc70bb4', '2', '1', '2018-10-25 17:56:46');
INSERT INTO `tlog` VALUES ('c16d69c68ce64ad0977b1b25f540a99c', '801de68299bb41c7a25f928a3bc70bb4', '1', '1', '2018-10-18 20:57:02');
INSERT INTO `tlog` VALUES ('c41d05ce01f74256a019da35f5b2c130', '099b02c0f09b4f9a839235b2b2d2a3d4', '1', '1', '2018-10-23 14:18:36');
INSERT INTO `tlog` VALUES ('c4f9397053f5438f89cf889835edabac', '73e1d575cbc44cf8a1f4a90db275f38b', '1', '1', '2018-10-23 13:33:40');
INSERT INTO `tlog` VALUES ('ca914e9a56e94097bb529c5d482ff770', 'bf336d77f9a44522aa9d1454e45deb5e', '2', '1', '2018-10-18 22:36:16');
INSERT INTO `tlog` VALUES ('cad3a87f323b4675a9939a12095afcef', '801de68299bb41c7a25f928a3bc70bb4', '2', '1', '2018-10-18 22:36:06');
INSERT INTO `tlog` VALUES ('cbcfaf41598e4980b7c516c5c146c15f', '801de68299bb41c7a25f928a3bc70bb4', '1', '1', '2018-10-22 17:56:45');
INSERT INTO `tlog` VALUES ('d1af43009ba54eb8934fe716bab8c6e3', '2cff0f27a7494767b5d7a9e5ecba5c39', '2', '1', '2018-10-23 14:20:14');
INSERT INTO `tlog` VALUES ('d3ff80b327844de189c071b7cb31915b', '801de68299bb41c7a25f928a3bc70bb4', '2', '1', '2018-10-18 22:36:07');
INSERT INTO `tlog` VALUES ('d7552fba995544e6ae08530f8ca037cf', '5217ef792c3b401d8263ce234f632457', '1', '1', '2018-10-23 13:33:31');
INSERT INTO `tlog` VALUES ('d7899e84aee64f7d8cd2c98156108dfc', '73e1d575cbc44cf8a1f4a90db275f38b', '1', '1', '2018-10-23 14:42:12');
INSERT INTO `tlog` VALUES ('dddacf2df2e44a0fadb28ba284462f2a', 'bf336d77f9a44522aa9d1454e45deb5e', '2', '1', '2018-10-18 22:08:02');
INSERT INTO `tlog` VALUES ('e327d06ae5c14ad88475200e67188fdb', '73e1d575cbc44cf8a1f4a90db275f38b', '1', '1', '2018-10-23 13:41:53');
INSERT INTO `tlog` VALUES ('e486237a3b9d4a9686d52a646f511dfd', '801de68299bb41c7a25f928a3bc70bb4', '2', '1', '2018-10-18 22:03:30');
INSERT INTO `tlog` VALUES ('e4a366ed7d8d407cbfd81948ffa9620f', 'bf336d77f9a44522aa9d1454e45deb5e', '2', '1', '2018-10-18 21:40:03');
INSERT INTO `tlog` VALUES ('e5125b278f1c49e399d4c9a69dd89cc8', '099b02c0f09b4f9a839235b2b2d2a3d4', '2', '1', '2018-10-23 14:19:55');
INSERT INTO `tlog` VALUES ('e68d50b02a244d49abd451be2d8ae163', '099b02c0f09b4f9a839235b2b2d2a3d4', '2', '1', '2018-10-22 17:59:07');
INSERT INTO `tlog` VALUES ('e879179d6cdf4a1697c01005f884eb5e', '73e1d575cbc44cf8a1f4a90db275f38b', '1', '1', '2018-10-23 14:24:41');
INSERT INTO `tlog` VALUES ('f308f527aa674c058d9c06ce364c4734', '801de68299bb41c7a25f928a3bc70bb4', '1', '1', '2018-10-23 14:27:13');
INSERT INTO `tlog` VALUES ('f3a8d63aa6ff450887930e2416d44aa9', 'bf336d77f9a44522aa9d1454e45deb5e', '2', '1', '2018-10-18 21:55:39');
INSERT INTO `tlog` VALUES ('f81515ba4c1141bca6efd50fa34f6a14', 'bf336d77f9a44522aa9d1454e45deb5e', '2', '1', '2018-10-18 22:29:42');
INSERT INTO `tlog` VALUES ('fa366fdf70674c9c9d848284f9e55f28', '801de68299bb41c7a25f928a3bc70bb4', '1', '1', '2018-10-18 22:05:49');
INSERT INTO `tlog` VALUES ('fdb25510d7374b5f8ed1c0c89d12f294', '801de68299bb41c7a25f928a3bc70bb4', '1', '1', '2018-10-23 14:25:57');
INSERT INTO `tlog` VALUES ('fedc23c10d71496bac0111023f4143a5', 'bf336d77f9a44522aa9d1454e45deb5e', '1', '1', '2018-10-23 13:55:58');

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
INSERT INTO `tuser` VALUES ('f0c4ac4d6a724be39c317e346ff6ff70', 'admin', 'admin', 'admin', '1', '2018-10-18 22:52:01', '2018-10-18 22:52:17', '1');

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
INSERT INTO `tuserbook` VALUES ('099b02c0f09b4f9a839235b2b2d2a3d4', 'f0c4ac4d6a724be39c317e346ff6ff70', null, null, '0', '2018-10-23 17:06:37', '2018-10-23 17:06:37', '1');
INSERT INTO `tuserbook` VALUES ('2cff0f27a7494767b5d7a9e5ecba5c39', 'f0c4ac4d6a724be39c317e346ff6ff70', null, null, '1', '2018-10-23 17:08:35', '2018-10-23 17:08:35', '1');
INSERT INTO `tuserbook` VALUES ('73e1d575cbc44cf8a1f4a90db275f38b', 'f0c4ac4d6a724be39c317e346ff6ff70', null, null, '1', '2018-10-23 17:08:36', '2018-10-23 17:08:36', '1');
INSERT INTO `tuserbook` VALUES ('bf336d77f9a44522aa9d1454e45deb5e', 'f0c4ac4d6a724be39c317e346ff6ff70', null, null, '0', '2018-10-23 17:08:30', '2018-10-23 17:08:30', '1');
SET FOREIGN_KEY_CHECKS=1;
