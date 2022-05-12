
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for attendance
-- ----------------------------
DROP TABLE IF EXISTS `attendance`;
CREATE TABLE `attendance`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '公告号，主键',
  `uid` int(0) NULL DEFAULT NULL COMMENT '用户号',
  `signDay` date NULL DEFAULT NULL COMMENT '打卡日期',
  `signTime` datetime(0) NULL DEFAULT NULL COMMENT '打卡准确时间',
  `signStatus` int(0) NULL DEFAULT NULL COMMENT '签到状态，0迟到，1正常打卡',
  `logStatus` int(0) NULL DEFAULT NULL COMMENT '签退状态，0早退，1正常签退',
  `logTime` datetime(0) NULL DEFAULT NULL COMMENT '签退具体时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 33 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of attendance
-- ----------------------------
INSERT INTO `attendance` VALUES (24, 1, '2022-04-06', '2022-04-06 16:38:22', 0, 1, '2022-04-06 16:38:28');
INSERT INTO `attendance` VALUES (25, 27, '2022-04-06', '2022-04-06 17:05:26', 0, 1, '2022-04-06 17:05:29');
INSERT INTO `attendance` VALUES (26, 1, '2022-04-08', '2022-04-08 10:41:46', 0, 1, '2022-04-08 10:41:59');
INSERT INTO `attendance` VALUES (27, 2, '2022-04-08', '2022-04-08 13:33:36', 0, 1, '2022-04-08 13:33:40');
INSERT INTO `attendance` VALUES (28, 1, '2022-04-09', '2022-04-09 23:45:59', 0, 0, '2022-04-09 23:46:13');
INSERT INTO `attendance` VALUES (29, 37, '2022-04-09', '2022-04-09 23:49:57', 0, 0, '2022-04-09 23:50:01');
INSERT INTO `attendance` VALUES (30, 1, '2022-04-10', '2022-04-10 00:03:13', 1, 1, '2022-04-10 00:03:19');
INSERT INTO `attendance` VALUES (31, 40, '2022-04-10', '2022-04-10 00:07:42', 1, 1, '2022-04-10 00:07:46');
INSERT INTO `attendance` VALUES (32, 41, '2022-04-10', '2022-04-10 14:46:39', 0, 1, '2022-04-10 14:46:42');

-- ----------------------------
-- Table structure for auth
-- ----------------------------
DROP TABLE IF EXISTS `auth`;
CREATE TABLE `auth`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `permsName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of auth
-- ----------------------------
INSERT INTO `auth` VALUES (1, 'user:admin', '最高权限');
INSERT INTO `auth` VALUES (2, 'user:agency', '代理权限');
INSERT INTO `auth` VALUES (3, 'user:staff', '员工权限');
INSERT INTO `auth` VALUES (4, 'user:freeze', '游客权限(账号冻结)');

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '部门号，主键\r\n',
  `department_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '部门名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES (1, '市场部');
INSERT INTO `department` VALUES (2, '技术部');
INSERT INTO `department` VALUES (3, '销售部');
INSERT INTO `department` VALUES (4, '客服部');
INSERT INTO `department` VALUES (5, '公关部');

-- ----------------------------
-- Table structure for document
-- ----------------------------
DROP TABLE IF EXISTS `document`;
CREATE TABLE `document`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `staff_no` int(0) NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `records` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of document
-- ----------------------------
INSERT INTO `document` VALUES (1, 1, 'admin', '公关部->技术部');
INSERT INTO `document` VALUES (2, 2, '刘伟', '销售部->客服部');
INSERT INTO `document` VALUES (3, 3, '元歌', '市场部->公关部');
INSERT INTO `document` VALUES (9, 36, '李斯', '公关部->销售部');
INSERT INTO `document` VALUES (12, 39, '李四', '销售部->市场部');
INSERT INTO `document` VALUES (13, 40, 'test', '销售部->技术部');
INSERT INTO `document` VALUES (14, 41, '王强', '客服部->技术部');

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '员工号，主键',
  `employee_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '员工姓名',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '员工邮箱',
  `gender` int(0) NOT NULL COMMENT '员工性别',
  `department_id` int(0) NOT NULL COMMENT '部门编号，外键',
  `date` date NOT NULL COMMENT '入职日期',
  `laterCount` int(0) NULL DEFAULT 0 COMMENT '迟到次数',
  `emp_status` int(11) UNSIGNED ZEROFILL NULL DEFAULT 00000000000 COMMENT '员工是否被选为优秀员工',
  `signCount` int(0) NULL DEFAULT 0 COMMENT '打卡次数',
  `marriage_status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `political_status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `culture_status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `major` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 42 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES (1, 'admin', '123@123', 0, 2, '2022-03-03', 4, 00000000000, 1, '未婚', '党员', '高中', '计算机', 0);
INSERT INTO `employee` VALUES (2, '刘伟', '163@163.com', 1, 4, '2022-04-05', 2, 00000000000, 0, '已婚', '群众', '本科', '信息', 0);
INSERT INTO `employee` VALUES (3, '元歌', '158@163.com', 0, 5, '2022-04-04', 0, 00000000000, 0, '未婚', '党员', '高中', '信息', 0);
INSERT INTO `employee` VALUES (36, '李斯', '192@163.com', 1, 3, '2022-04-02', 0, 00000000000, 0, '已婚', '团员', '大专', '计算机', 0);
INSERT INTO `employee` VALUES (39, '李四', '123@123.com', 1, 1, '2022-04-02', 0, 00000000000, 0, '已婚', '团员', '大专', '化学', 0);
INSERT INTO `employee` VALUES (40, 'test', '162@163.com', 0, 2, '2022-04-04', 0, 00000000000, 1, '已婚', '团员', '本科', '信息', 0);
INSERT INTO `employee` VALUES (41, '王强', '145@163.com', 1, 2, '2022-04-04', 1, 00000000000, 0, '已婚', '群众', '本科', '信息', 0);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '用户号，主键',
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `perms` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '权限名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 42 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', '123456', 'user:admin');
INSERT INTO `user` VALUES (2, 'liuwei', '123123', 'user:staff');
INSERT INTO `user` VALUES (3, 'yuange', '123123', 'user:staff');
INSERT INTO `user` VALUES (40, 'test', '123123', 'user:staff');
INSERT INTO `user` VALUES (41, 'wang', '123123', 'user:staff');

-- ----------------------------
-- Table structure for userleave
-- ----------------------------
DROP TABLE IF EXISTS `userleave`;
CREATE TABLE `userleave`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '请假单号，主键',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `reason` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '理由',
  `leave_status` int(0) NULL DEFAULT NULL COMMENT '请假状态',
  `department_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门名称',
  `employeeId` int(0) NULL DEFAULT NULL COMMENT '员工序号',
  `startDate` date NULL DEFAULT NULL COMMENT '开始时间',
  `endDate` date NULL DEFAULT NULL COMMENT '结束时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of userleave
-- ----------------------------
INSERT INTO `userleave` VALUES (21, 'admin', '生病', 1, '销售部', 1, '2022-04-03', '2022-04-04');
INSERT INTO `userleave` VALUES (23, '刘伟', '申请探亲', 1, '市场部', 2, '2022-04-01', '2022-04-04');
INSERT INTO `userleave` VALUES (24, 'admin', '生病吃药', 1, '公关部', 1, '2022-04-04', '2022-04-06');
INSERT INTO `userleave` VALUES (26, 'admin', '申请探亲', 2, '公关部', 1, '2022-04-04', '2022-04-06');
INSERT INTO `userleave` VALUES (27, 'admin', '探亲回家', 1, '公关部', 1, '2022-04-04', '2022-04-05');
INSERT INTO `userleave` VALUES (28, 'test', '生病', 1, '公关部', 40, '2022-04-05', '2022-04-06');
INSERT INTO `userleave` VALUES (29, 'admin', '申请探亲', 1, '公关部', 1, '2022-04-04', '2022-04-06');
INSERT INTO `userleave` VALUES (30, '王强', '生病', 1, '公关部', 41, '2022-04-04', '2022-04-14');

-- ----------------------------
-- Table structure for wage
-- ----------------------------
DROP TABLE IF EXISTS `wage`;
CREATE TABLE `wage`  (
  `id` int(0) NOT NULL,
  `salary` double(10, 2) NULL DEFAULT NULL COMMENT '工资',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of wage
-- ----------------------------
INSERT INTO `wage` VALUES (1, 20000.00);
INSERT INTO `wage` VALUES (2, 10000.00);
INSERT INTO `wage` VALUES (3, 12000.00);
INSERT INTO `wage` VALUES (36, 20000.00);
INSERT INTO `wage` VALUES (39, 5000.00);
INSERT INTO `wage` VALUES (40, 1000.00);
INSERT INTO `wage` VALUES (41, 1000.00);

SET FOREIGN_KEY_CHECKS = 1;
