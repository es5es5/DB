create table feb09_nation(
	n_name varchar2(10 char) primary key,
	n_continent varchar2(10 char) not null,
	n_population number(10) not null,
	n_gold number(3) not null,
	n_silver number(3) not null,
	n_bronze number(3) not null
);


create table feb09_sports(
	s_no number(3) primary key,
	s_name varchar2(10 char) not null,
	s_detail varchar(10 char) not null
);

drop table feb09_nation cascade constraint purge;

create sequence feb09_sports_seq; 

insert into feb09_nation values('북한', '아시아', 3000, 0, 0, 0);

update feb09_nation
set n_gold=?, n_silver=?, n_bronze=?
where n_name=?;

update feb09_sports
set s_name ='컬링', s_detail = '단체전'
where s_no=1;

select * from feb09_nation;

select * from feb09_nation where n_name like '%대한민국%';

create table feb09_player(
	p_no number(3) primary key,
	p_name varchar2(10 char) not null,
	p_from varchar2(10 char) not null,
	p_gold number(3) not null,
	p_silver number(3) not null,
	p_bronze number(3) not null
);

create sequence feb09_player_seq;
select * from feb09_sports;


update FEB09_PLAYER
set p_gold=?, p_silver=?, p_bronze=?
where p_name =?;

select n_name, n_gold, n_silver, n_bronze from FEB09_NATION where where n_name like ?;


