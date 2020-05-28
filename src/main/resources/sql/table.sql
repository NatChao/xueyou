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

