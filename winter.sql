create user tobi identified by 1234;

GRANT CREATE SESSION TO tobi;
GRANT CREATE TABLE TO tobi;
GRANT DROP ANY TABLE TO tobi;
grant create session, create table, create view,resource to tobi;
commit;

create table users(
    id nvarchar2(100),
    name nvarchar2(100),
    password nvarchar2(100)
     );


create table board(
    bno  number(10) ,
    writer nvarchar2(100),
    title nvarchar2(100),
    content varchar(100),
    write_date date,
    read_cnt number(10),
    like_cnt number(10),
    CONSTRAINT board_pk_bno PRIMARY KEY(bno)
);
create sequence board_sequence;
select board_sequence.nextval from dual;
select board_sequence.currval from dual;
drop table board;

create table authorities(
    id nvarchar2(100),
    authority nvarchar2(100)
);

insert into users(id, name, password) values('id','irum','password');
update users set id='updatedid' where id='id';
select * from users where id='updatedid';
delete users where id='id';
select * from users;
commit;

insert into board(bno, writer, title, content, write_date, read_cnt, like_cnt)
    values(3,'writer', 'title', 'content', sysdate, 3, 3);
update board set title='updatedtitle', content='content' where bno=3;
select * from board;
delete board where bno=3;
commit;
insert into board(bno, writer, title, content, write_date, read_cnt, like_cnt) values(3, 'writer', 
'title', 'content', sysdate, 4, 5);


insert into board values(board_sequence.nextval, 'title1' ,'content1', 'writer', sysdate,52,14);
insert into board values(board_sequence.nextval, 'title2' ,'content2', 'writer', sysdate,12,89);
insert into board values(board_sequence.nextval, 'title3' ,'content3', 'writer', sysdate,17,28);
insert into board values(board_sequence.nextval, 'title4' ,'content4', 'writer', sysdate,1,15);
insert into board values(board_sequence.nextval, 'title5' ,'content5', 'writer', sysdate,42,17);
insert into board values(board_sequence.nextval, 'title6' ,'content6', 'writer', sysdate,39,72);
insert into board values(board_sequence.nextval, 'title7' ,'content7', 'writer', sysdate,20,53);
insert into board values(board_sequence.nextval, 'title8' ,'content8', 'writer', sysdate,91,98);
insert into board values(board_sequence.nextval, 'title9' ,'content9', 'writer', sysdate,61,6);
insert into board values(board_sequence.nextval, 'title10' ,'content10', 'writer', sysdate,64,35);
insert into board values(board_sequence.nextval, 'title11' ,'content11', 'writer', sysdate,94,10);
insert into board values(board_sequence.nextval, 'title12' ,'content12', 'writer', sysdate,41,94);
insert into board values(board_sequence.nextval, 'title13' ,'content13', 'writer', sysdate,55,62);
insert into board values(board_sequence.nextval, 'title14' ,'content14', 'writer', sysdate,88,82);
insert into board values(board_sequence.nextval, 'title15' ,'content15', 'writer', sysdate,87,98);
insert into board values(board_sequence.nextval, 'title16' ,'content16', 'writer', sysdate,22,83);
insert into board values(board_sequence.nextval, 'title17' ,'content17', 'writer', sysdate,40,86);
insert into board values(board_sequence.nextval, 'title18' ,'content18', 'writer', sysdate,88,32);
insert into board values(board_sequence.nextval, 'title19' ,'content19', 'writer', sysdate,28,5);
insert into board values(board_sequence.nextval, 'title20' ,'content20', 'writer', sysdate,7,78);
commit;
select * from board;
select bno, writer, title, content, write_date writeDate, read_cnt readCnt, like_cnt likeCnt 
from board where bno=3 and rownum=1;


insert into users(id, name, password) values('id','irum','password');
insert into users(id, name, password) values('id1','irum1','password1');
insert into users(id, name, password) values('id2','irum2','password2');
insert into users(id, name, password) values('id3','irum3','password3');
commit;
select * from users;






SELECT * FROM ALL_CONSTRAINTS WHERE TABLE_NAME = 'board';


select * from (select rownum rnum, b.* from (select /*+ index_desc(board board_pk_bno)*/ bno,title,write_date 
writeDate,read_cnt readCnt from board ) b where rownum <= 1 ) where rnum >=1 ;
