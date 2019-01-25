/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 80013
 Source Host           : localhost:3306
 Source Schema         : gas

 Target Server Type    : MySQL
 Target Server Version : 80013
 File Encoding         : 65001

 Date: 25/01/2019 13:41:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_operating_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_operating_log`;
CREATE TABLE `sys_operating_log`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `method` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `operation` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `params` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `role_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `valid` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_operating_log
-- ----------------------------
INSERT INTO `sys_operating_log` VALUES (1, '2019-01-25 03:31:07', '2019-01-25 03:31:07', NULL, '0:0:0:0:0:0:0:1', 'com.jdy.modules.sys.role.service.SysUserService.deleteSysUser', '删除系统用户', '[1]', '管理员', '管理员', 1);
INSERT INTO `sys_operating_log` VALUES (2, '2019-01-25 03:58:02', '2019-01-25 03:58:02', NULL, '0:0:0:0:0:0:0:1', 'com.jdy.modules.sys.role.service.SysUserService.deleteSysUser', '删除系统用户', '[1]', '管理员', '管理员', 1);
INSERT INTO `sys_operating_log` VALUES (3, '2019-01-25 03:58:38', '2019-01-25 03:58:38', NULL, '0:0:0:0:0:0:0:1', 'com.jdy.modules.sys.role.service.SysUserService.getUserList', '获取系统用户列表', '[]', '管理员', '管理员', 1);
INSERT INTO `sys_operating_log` VALUES (4, '2019-01-25 04:02:03', '2019-01-25 04:02:03', NULL, '0:0:0:0:0:0:0:1', 'com.jdy.modules.sys.log.service.SysOperatingLogService.getLogList', '查看系统操作日志', '[]', '管理员', '管理员', 1);
INSERT INTO `sys_operating_log` VALUES (5, '2019-01-25 04:02:10', '2019-01-25 04:02:10', NULL, '0:0:0:0:0:0:0:1', 'com.jdy.modules.sys.log.service.SysOperatingLogService.getLogList', '查看系统操作日志', '[]', '管理员', '管理员', 1);
INSERT INTO `sys_operating_log` VALUES (6, '2019-01-25 04:12:52', '2019-01-25 04:12:52', NULL, '0:0:0:0:0:0:0:1', 'com.jdy.modules.sys.log.service.SysOperatingLogService.getLogList', '查看系统操作日志', '[{\"valid\":1,\"total\":1,\"size\":10,\"count\":5,\"page\":1}]', '管理员', '管理员', 1);
INSERT INTO `sys_operating_log` VALUES (7, '2019-01-25 05:40:24', '2019-01-25 05:40:24', NULL, '0:0:0:0:0:0:0:1', 'com.jdy.modules.sys.log.service.SysOperatingLogService.getLogList', '查看系统操作日志', '[{\"valid\":1,\"total\":1,\"size\":10,\"count\":6,\"page\":1}]', '管理员', '管理员', 1);

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission`  (
  `p_id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `parent_id` int(11) NULL DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `valid` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`p_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES (1, NULL, NULL, '\r\n新增系统用户', 0, 'sysUser/list', 1);
INSERT INTO `sys_permission` VALUES (2, NULL, NULL, '系统用户列表', 0, 'sysUser/add', 1);
INSERT INTO `sys_permission` VALUES (3, NULL, NULL, '删除系统用户', 0, 'sysUser/delete', 1);
INSERT INTO `sys_permission` VALUES (4, NULL, NULL, '查看系统操作日志', 0, 'sys/log', 1);

-- ----------------------------
-- Table structure for sys_region
-- ----------------------------
DROP TABLE IF EXISTS `sys_region`;
CREATE TABLE `sys_region`  (
  `region_id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `valid` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`region_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `department_id` int(11) NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `role` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `valid` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, NULL, NULL, NULL, '超级管理员', 'admin', NULL);
INSERT INTO `sys_role` VALUES (2, NULL, NULL, NULL, '管理员', '管理员', NULL);
INSERT INTO `sys_role` VALUES (3, NULL, NULL, NULL, '客服', '客服', NULL);

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission`  (
  `role_id` int(11) NOT NULL,
  `p_id` int(11) NULL DEFAULT NULL,
  `valid` int(11) NULL DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
INSERT INTO `sys_role_permission` VALUES (1, 1, NULL, 1);
INSERT INTO `sys_role_permission` VALUES (1, 2, NULL, 2);
INSERT INTO `sys_role_permission` VALUES (2, 1, NULL, 3);
INSERT INTO `sys_role_permission` VALUES (2, 4, NULL, 8);
INSERT INTO `sys_role_permission` VALUES (2, 2, NULL, 5);
INSERT INTO `sys_role_permission` VALUES (1, 3, NULL, 6);
INSERT INTO `sys_role_permission` VALUES (2, 3, NULL, 7);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `admin_id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `login_num` int(11) NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `region_id` int(11) NULL DEFAULT NULL,
  `salt` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `state` int(11) NULL DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `valid` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`admin_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, NULL, NULL, 0, '闵渭凯', '60904e0dc5183f5516b72252b7f3737f', NULL, '8d78869f470951332959580424d4bf4f', 0, 'admin', 1);
INSERT INTO `sys_user` VALUES (3, '2019-01-22 08:51:35', '2019-01-22 08:51:35', 0, NULL, 'baa176905e5323119d6224b1feba94ec', NULL, '20fb0343908f4128997fe0bc44d46533', 1, '管理员', NULL);
INSERT INTO `sys_user` VALUES (4, '2019-01-22 10:02:02', '2019-01-22 10:02:02', 0, NULL, '324719fc8b81d91042ad1f1258680f3a', NULL, '00cc537eb6ee460c8e8e5adec36e4738', 1, '客服', NULL);

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `admin_id` int(11) NOT NULL,
  `role_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`admin_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (1, 1);
INSERT INTO `sys_user_role` VALUES (4, 3);
INSERT INTO `sys_user_role` VALUES (3, 2);

SET FOREIGN_KEY_CHECKS = 1;
