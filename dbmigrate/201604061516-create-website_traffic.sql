create table `website_traffic`(
  `id` bigint(24) PRIMARY KEY NOT NULL auto_increment,
  `ipAddress` varchar(20) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `operateSystem` varchar(20) DEFAULT NULL,
  `browser` varchar(20) DEFAULT NULL
)