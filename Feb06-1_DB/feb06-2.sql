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

-- 메뉴(이름, 가격)
create table feb06_kwon_menu(
	m_name varchar2(10 char) primary key,
	m_price number(5) not null
);

-- 원산지(재료, 원산지)
create table feb06_kwon_from(
	f_name varchar2(10 char) primary key,
	f_where varchar2(10 char) not null
);

-- 무슨 메뉴에 무슨 재료 들어있는지
create table feb06_kwon_include(
	i_no number(3) primary key,
	m_name varchar2(10 char) not null,   -- 메뉴명
	j_name varchar2(10 char) not null    -- 재료명
);

create sequence feb06_kwon_include_seq;

insert into feb06_kwon_include values(feb06_kwon_include_seq.nextval, '제육밥', '쌀');
select * from feb06_kwon_from;

-- 소고기의 원산지
select f_where
from feb06_kwon_from
where f_name = '소고기';

-- 1. 필요한 재료들이 어떤 테이블에 있나
-- 2. 최종 출력이 뭔지 따져서 subquery/join
-- 3. subquery는 결과로 여러개 나오면 안됨 => join

-- 7000원짜리 메뉴의 재료명 : subquery
select j_name
from feb06_kwon_include
where m_name = (
	select m_name
	from feb06_kwon_menu
	where m_price = 7000
);

-- 3000원 이상인 메뉴의 재료명 : subquery => join
--select j_name from feb06_kwon_include
--where m_name = (
--	select m_name
--	from feb06_kwon_menu
--	where m_price >= 3000
--);
select j_name
from feb06_kwon_menu, feb06_kwon_include
where feb06_kwon_menu.m_name = feb06_kwon_include.m_name
	and m_price >= 3000;

-- 7000원짜리 메뉴의 재료명, 메뉴명, 가격 : join
select feb06_kwon_menu.m_name, m_price, j_name
from feb06_kwon_menu, feb06_kwon_include
where feb06_kwon_menu.m_name = feb06_kwon_include.m_name
	and m_price = 7000;
	
select m_name from feb06_kwon_include
where j_name = (
	select f_name
	from feb06_kwon_from
	where f_where = '한국'
);
	
-- 제육덮밥의 재료 출력
select j_name from feb06_kwon_include where m_name = '제육덮밥';

-- 한국산 재료 들어간 메뉴명(subquery => join)
select m_name from feb06_kwon_include, feb06_kwon_from
where j_name = f_name
	and f_where = '한국';

-- 제일 비싼 메뉴의 재료 출력(subquery => join)
select j_name from feb06_kwon_menu, feb06_kwon_include
where feb06_kwon_menu.m_name = feb06_kwon_include.m_name
	and m_price = (
		select max(m_price)
		from feb06_kwon_menu
);
-- 제육덮밥의 재료, 원산지 출력(subquery => join)
select f_name, f_where from feb06_kwon_from, feb06_kwon_include
where f_name = j_name and m_name = '제육덮밥';

-- 제일 싼 메뉴의 재료, 원산지 출력
select f_name, f_where
from feb06_kwon_menu, feb06_kwon_from, feb06_kwon_include
where feb06_kwon_menu.m_name = feb06_kwon_include.m_name 
	and f_name = j_name
	and m_price = (
		select min(m_price)
		from feb06_kwon_menu
);

-- 미국산 재료 들어간 메뉴명, 가격 출력(subquery => join)
select feb06_kwon_menu.m_name, m_price
from feb06_kwon_menu, feb06_kwon_include, feb06_kwon_from
where feb06_kwon_menu.m_name = feb06_kwon_include.m_name 
	and j_name = f_name
	and f_where = '미국';

--------------------------------------------------------------------

create table feb06_product(
	p_no number(3) primary key,
	p_name varchar2(10 char) not null,
	p_price number(7) not null
);
create sequence feb06_product_seq;

create table feb06_shop(
	s_no number(3) primary key,
	s_floor number(3) not null,
	s_name varchar2(10 char) not null,
	s_size number(3) not null
);
create sequence feb06_shop_seq;

create table feb06_where(
	w_no number(3) primary key,
	w_p_no number(3) not null,
	w_s_no number(3) not null
);
create sequence feb06_where_seq;

-- 상품의 총 갯수
select count(p_no) from feb06_product;

-- 상품 평균가
select avg(p_price) from feb06_product;

-- 제일 비싼 상품 이름
select p_name
from feb06_product
where p_price = (
	select max(p_price)
	from feb06_product
);

-- 10000원짜리 폰케이스 사려면 몇층으로 가야하나
select s_floor
from feb06_product, feb06_where, feb06_shop
where p_no = w_p_no and w_s_no = s_no 
	and p_price = 10000 and p_name = '폰케이스';

-- 제일 싼 상품은 무슨 매장에서 파나
select s_name
from feb06_product, feb06_where, feb06_shop
where p_no = w_p_no and w_s_no = s_no
	and p_price = (
		select min(p_price)	from feb06_product
);

-- 제일 큰 매장에서 파는 상품의 평균가는
select avg(p_price)
from feb06_product, feb06_where, feb06_shop
where p_no = w_p_no and w_s_no = s_no
	and s_size = (
		select max(s_size) from feb06_shop	
);

-- 가전매장에서 파는 상품명, 가격을 가격순으로 정렬
select p_name, p_price
from feb06_product, feb06_where, feb06_shop
where p_no = w_p_no and w_s_no = s_no
	and s_name='가전'
order by p_price;
	
-- 전체 상품명, 가격을 이름 오름차순으로 정렬
select p_name, p_price
from feb06_product
order by p_name;

-- 전체 상품명, 가격을 이름 내림차순으로 정렬
select p_name, p_price
from feb06_product
order by p_name desc;

-- 전체 상품명, 가격을 이름 오름차순으로 정렬, 이름이 같으면 가격 내림차순
select p_name, p_price
from feb06_product
order by p_name, p_price desc;

-- 볼펜을 150원으로 수정하기
update feb06_product
set p_price = 150
where p_name = '볼펜';
-- p_price *= 1.3은 안됨
-- 폰케이스 가격 30% 인상
update feb06_product
set p_price = p_price * 1.3			
where p_name = '폰케이스';

-- 제일 비싼거 20% 인하
update feb06_product
set p_price = p_price * 0.8
where p_price = (
	select max(p_price)
	from feb06_product
);

-- 이름에 '폰'들어가는거 1000원 추가
update feb06_product
set p_price = p_price + 1000
where p_name like '%폰%';

-- 전부 다 10% 인하
update feb06_product
set p_price = p_price * 0.9;

-- 평창패딩 지우기
delete from feb06_product
where p_name = '평창패딩';

-- 볼펜 지우기
delete from feb06_where
where w_p_no = (
	select p_no
	from feb06_product
	where p_name = '볼펜'
);

delete from feb06_product
where p_name = '볼펜';

select * from feb06_product;

