create table Article (
	id bigint primary key auto_increment,
	title varchar(100),
	content text,
	source text,
	createTime datetime,
	deleteTime datetime,
	state int
);