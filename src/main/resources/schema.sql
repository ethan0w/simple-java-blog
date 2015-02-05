
create table sj_blog_article (
	id int primary key AUTO_INCREMENT,
	userId int,
	title varchar(100),
	content text,
	source text,
	summary varchar(500),
	category varchar(50),
	tags varchar(100),
	createTime datetime,
	deleteTime datetime,
	updateTime timestamp default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
	type tinyint,
	state tinyint
);

create index userId_key on sj_blog_article (`userId`);
create index title_key on sj_blog_article(`title`);
create index category_key on sj_blog_article(`category`);
create index createTime_key on sj_blog_article(`createTime`);


create table sj_blog_tag (
	userId int,
	name varchar(50),
	num int,
	unique tag_name (`name`)
); 
create index user_cat on sj_blog_tag (`userId`, `name`);

 
create table sj_blog_category (
	userId int,
	name varchar(50),
	num int,
	unique cat_name (`name`)
); 
create index user_cat on sj_blog_category (`userId`, `name`);
