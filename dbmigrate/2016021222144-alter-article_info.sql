alter table article_info add `description` longtext DEFAULT NULL;
alter table article_info change `tagId` `tag` varchar(200);