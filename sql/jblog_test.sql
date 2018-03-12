# 조회
select * from user;
select * from blog;
select * from category;
select * from comment;
select * from post;

# 삭제
delete from comment;
delete from post;
delete from blog;
delete from user;
delete from category;

# 자동증가 초기화
alter table comment auto_increment=1;
alter table post auto_increment=1;
alter table blog auto_increment=1;
alter table user auto_increment=1;
alter table category auto_increment=1;