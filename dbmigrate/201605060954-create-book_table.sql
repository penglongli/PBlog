create table `book_table`(
  `id` INT PRIMARY KEY NOT NULL auto_increment,
  `bookName` varchar(50) DEFAULT NULL,
  `bookUrl` varchar(100) DEFAULT NULL,
  `bookBanner` varchar(100) DEFAULT NULL
)DEFAULT CHARSET=utf8;