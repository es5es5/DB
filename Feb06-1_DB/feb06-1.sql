-- 주석
-- 테이블/CRUD 관련된 SQL만, 오라클 명령어 안됨(desc FEB05_KWON_LOC;)
-- alt + s : 커서가 있는 그 줄 실행
-- alt + x : 블록 지정된거 실행

-- drop table 테이블명 cascade constraint purge;

create table feb06_kwon_student(
	s_no number(3) primary key,
	s_name varchar2(10 char) not null,
	s_gender char(1 char) not null,
	s_birthday date not null,
	s_addr varchar2(10 char) not null,
	s_c_no number(2) not null
);

create sequence feb06_kwon_student_seq;

insert into feb06_kwon_student values(
	feb06_kwon_student_seq.nextval, 
	'최길동','여',
	to_date('1999-03-11','YYYY-MM-DD'),
	'포천',	1
);
	
create table feb06_kwon_class(
	c_no number(2) primary key,
	c_title varchar2(10 char) not null,
	c_size number(3) not null
);

insert into feb06_kwon_class values(4, '하이브리드웹앱', 18);

select * from feb06_kwon_student;
select * from feb06_kwon_class;

commit

-- 학생 전체 정보
select *
from feb06_kwon_student;

-- 서울에 사는 학생은 몇 명
select count(s_no)
from feb06_kwon_student
where s_addr = '서울';

-- 강의장 평균 사이즈
select avg(c_size) from feb06_kwon_class;






-- 제일 어린 학생은 무슨 수업 듣고 있나
select c_title 
from feb06_kwon_class 
where c_no = ( 
	select s_c_no
	from feb06_kwon_student
	where s_birthday = (
		select max(s_birthday)
		from feb06_kwon_student
	)
);

select c_title
from feb06_kwon_student, feb06_kwon_class
where s_c_no = c_no and s_birthday = (
	select max(s_birthday)
	from feb06_kwon_student
);

-- 제일 작은 강의장에서 수업듣는 학생 이름, 과목명
select s_name, c_title
from feb06_kwon_student, feb06_kwon_class
where s_c_no = c_no and c_size = (
	select min(c_size)
	from feb06_kwon_class
);




-- 메뉴 테이블(이름, 가격)
create table f06_menu (
	m_name varchar2(10 char) primary key,
	m_price number(5) not null
);

-- 원산지(재료, 원산지)
create table f06_from (
	f_name varchar2(10 char) primary key, -- 재료명
	f_where varchar2(10 char) not null -- 원산지
);

-- 무슨 메뉴에 무슨 재료 들어 있는지 정보가 들어간 테이블(메뉴명, 재료명)
create table f06_include(
	i_no number(3) primary key,
	m_name varchar2(10 char) not null, -- 메뉴명
	j_name varchar2(10 char) not null -- 재료명
);

create sequence f06_include_seq;

insert into f06_menu values('제육볶음', 5000);
insert into f06_menu values('제육덮밥', 6000);
insert into f06_menu values('불고기덮밥', 7000);
insert into f06_menu values('소고기김밥', 5000);
insert into f06_menu values('야채김밥', 3000);
insert into f06_menu values('제육김밥', 4000);

insert into f06_from values('돼지고기', '미국산');
insert into f06_from values('소고기', '호주산');
insert into f06_from values('쌀', '국내산');

insert into f06_include values(f06_include_seq.nextval, '제육볶음', '돼지고기');
insert into f06_include values(f06_include_seq.nextval, '제육덮밥', '돼지고기');
insert into f06_include values(f06_include_seq.nextval, '제육덮밥', '쌀');
insert into f06_include values(f06_include_seq.nextval, '불고기덮밥', '소고기');
insert into f06_include values(f06_include_seq.nextval, '불고기덮밥', '쌀');
insert into f06_include values(f06_include_seq.nextval, '야채김밥', '쌀');
insert into f06_include values(f06_include_seq.nextval, '제육김밥', '돼지고기');
insert into f06_include values(f06_include_seq.nextval, '제육김밥', '쌀');
insert into f06_include values(f06_include_seq.nextval, '소고기김밥', '쌀');
insert into f06_include values(f06_include_seq.nextval, '소고기김밥', '소고기');

select * from f06_menu;
select * from f06_from;
select * from f06_include;


-- 제육덮밥의 재료 출력
select j_name from f06_include where m_name = '제육덮밥';

-- 한국산 재료 들어간 메뉴명
select m_name from f06_from, f06_include where j_name = f_name and f_where = '국내산';

-- 제일 비싼 메뉴의 재료 출력
select j_name from f06_include

-- 제육덮밥의 재료, 원산지 출력


-- 제일 싼 메뉴의 재료, 원산지 출력
select f_name, f_where
from f06_menu, f06_include, f06_from
where f06_menu.m_name = f06_include.m_name
	and j_name = f_name
	and m_price = (select min(m_price) from f06_menu
	);

-- 미국산 재료 들어간 메뉴, 가격
select f06_menu.m_name, m_price
from f06_menu, f06_include, f06_from
where f06_menu.m_name = f06_include.m_name
	and j_name = f_name
	and f_where = '미국';

-- 1. 필요한 재료들이 어떤 테이블에 있나
-- 2. 최종 출력이 뭔지 따져서 sub/join
-- 3. subquery는 결과로 여러개 나오면 안됨 => join으로 하셈..

-- 7000원짜리 메뉴의 재료명 by subquery
select j_name
from f06_include
where m_name = (
	select m_name
	from f06_menu
	where m_price = 7000
);

-- 7000원짜리 메뉴의 재료명, 메뉴명, 가격 by Join
select f06_menu.m_name, m_price, j_name
from f06_menu, f06_include
where f06_menu.m_name = f06_include.m_name and m_price = 7000;

-- 5000원 이상인 메뉴의 재료명 subquery
-- 하지만 괄호 속에 여러개가 나오면 subquery로 불가능

select j_name
from f06_include
where m_name = (
	select m_name
	from f06_menu
	where m_price >= 5000
);

-- join 으로 ㄱ
select f06_menu.m_name, j_name
from f06_menu, f06_include
where f06_menu.m_name = f06_include.m_name
and m_price >=5000;
