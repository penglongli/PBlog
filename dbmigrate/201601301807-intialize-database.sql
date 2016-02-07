SET FOREIGN_KEY_CHECKS=0;

DROP TABLE IF EXISTS `article_info`;
CREATE TABLE `article_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(200) DEFAULT NULL,
  `content` longtext,
  `slug` bigint(20) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `lastModifyTime` datetime DEFAULT NULL,
  `categorySlug` bigint(20) DEFAULT NULL,
  `tagId` varchar(100) DEFAULT NULL,
  `thumb` int(11) DEFAULT '0',
  `enabled` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `article_read_log`;
CREATE TABLE `article_read_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `articleId` int(11) DEFAULT NULL,
  `ipAddress` varchar(200) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `author_info`;
CREATE TABLE `author_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `motto` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `github` varchar(100) DEFAULT NULL,
  `zhihu` varchar(100) DEFAULT NULL,
  `csdn` varchar(100) DEFAULT NULL,
  `headImage` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `book_info`;
CREATE TABLE `book_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(200) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `slug` bigint(20) DEFAULT NULL,
  `banner` varchar(200) DEFAULT NULL,
  `thumb` int(11) DEFAULT NULL,
  `introduction` varchar(200) DEFAULT NULL,
  `content` longtext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `book_read_log`;
CREATE TABLE `book_read_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `bookId` int(11) DEFAULT NULL,
  `ipAddress` varchar(200) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `category_info`;
CREATE TABLE `category_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createTime` datetime DEFAULT NULL,
  `title` varchar(50) DEFAULT NULL,
  `slug` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `record_info`;
CREATE TABLE `record_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(200) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `content` longtext,
  `slug` mediumtext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `record_read_log`;
CREATE TABLE `record_read_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `recordId` int(11) DEFAULT NULL,
  `ipAddress` varchar(200) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `tag_info`;
CREATE TABLE `tag_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createTime` datetime DEFAULT NULL,
  `title` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

