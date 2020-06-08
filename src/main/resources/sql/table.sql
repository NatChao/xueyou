-- User用户表
CREATE TABLE `tb_user` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `user_name` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(50) NOT NULL COMMENT '密码',
  `head_portrait` varchar(255) DEFAULT NULL COMMENT '用户头像',
  `gender` int DEFAULT NULL COMMENT '性别(0：男性，1：女性)',
  `create_time` datetime DEFAULT NULL COMMENT '账户创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- 话题表
CREATE TABLE `tb_topic_conversation` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '话题id',
  `user_id` bigint NOT NULL COMMENT '用户id',
  `title` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标题',
  `theme_picture` varchar(255) DEFAULT NULL COMMENT '话题图片',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `views` int DEFAULT '0' COMMENT '浏览量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--上传文件表
CREATE TABLE `tb_files` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_id` bigint DEFAULT NULL COMMENT '用户id',
  `file_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '资源名称',
  `path` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '路径',
  `size` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '文件大小',
  `type` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '文件类型',
  `downcounts` int DEFAULT NULL COMMENT '倒计时\n\n',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--话题评论表
CREATE TABLE `tb_comment` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `topic_conversation_id` bigint NOT NULL COMMENT '话题id',
  `user_id` bigint NOT NULL COMMENT '用户id',
  `content` varchar(500) DEFAULT NULL COMMENT '评论内容',
  `give_like` int DEFAULT NULL COMMENT '点赞',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `state` int NOT NULL DEFAULT '1' COMMENT '状态(0：已删除  1：正常)',
  `reply_id` bigint DEFAULT NULL COMMENT '回复评论id(该字段不为null时，表示回复评论)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

