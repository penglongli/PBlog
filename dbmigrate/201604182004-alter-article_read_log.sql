alter table `article_read_log` change `articleId` `articleSlug` bigint(20) default null;
create INDEX idx_artSlug on `article_read_log` (articleSlug);