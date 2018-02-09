create table feb08_student(
	s_no number(3) primary key,
	s_name varchar2(10 char) not null,
	s_birthday date not null,
	s_mid number(4,1) not null,
	s_fin number(4,1) not null
);

create sequence feb08_student_seq;

insert into feb08_student values(feb08_student_seq.nextval, '이웅', to_date(19930513, 'YYYYMMDD'), 50.1,25.1);

select * from feb08_student;

select s_name, s_birthday, (s_mid+s_fin)/2 as s_avg from feb08_student order by s_avg desc;

select s_name as s
from feb08_student
order by s;

-- 번호가 1번인 학생의
-- 중간고사 점수를 50.3 기말고사 점수를 30.2로 수정
update feb08_student
set s_mid=50.3, s_fin=30.2
where s_no = 1;

-- 번호가 ?번인 학생의 이름 수정
update feb08_student
set s_name = '이번이'
where s_no = 2;

-- 번호 ? 삭제

delete from FEB08_STUDENT
where s_no = ?;

-- 번호 받아서 이름 바꾸기

update fed08_student
set s_name = ?
where s_no = ?;

select s_no, s_name, s_birthday, (s_mid + s_fin) / 2 as s_avg from feb08_student order by s_avg desc;


select * from FEB08_STUDENT;