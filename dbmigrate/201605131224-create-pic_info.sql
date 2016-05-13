CREATE TABLE `pic_info` (
  `id` bigint(24) PRIMARY KEY not null auto_increment,
  `relativePath` VARCHAR(100) DEFAULT NULL,
  `physicalPath` VARCHAR(100) DEFAULT NULL,
   `createTime` DATE DEFAULT NULL
)
