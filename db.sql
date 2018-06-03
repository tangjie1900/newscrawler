--用户
CREATE TABLE `user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `telephone` char(11) NOT NULL DEFAULT '',
  `password` char(32) NOT NULL DEFAULT '',
  `register_time` datetime NOT NULL,
  `register_ip` varchar(23) DEFAULT NULL,
  `status` tinyint(1) NOT NULL,
  `name` varchar(10) DEFAULT NULL,
  `idcard_number` varchar(18) DEFAULT NULL,
  `mobile_pwd` char(6) DEFAULT NULL,
  `bank_account` varchar(19) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8


