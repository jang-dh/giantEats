DROP TABLE RESTAURANT;
drop table review;

--review 테이블에서 restaurant 테이블의 restaurant_no를 참조하기 위한 제약조건 추가
alter table restaurant add constraint restaurant_no_pk primary key(restaurant_no);
SELECT * FROM restaurant;

--지역으로 찾기
select * from restaurant where addr like '?';
select * from restaurant where addr like '%교동%';
--업태로 찾기
select * from restaurant where food_type like '?';
--지역 및 업태로 찾기
select * from restaurant where addr like '%?%' and food_type like '?';
--restaurant_no로 찾기
select * from restaurant where restaurant_no = ?;
--업소명으로 찾기
select * from restaurant where restaurant_name like ?; 

--commit

--review 테이블의 pk
create sequence review_no_seq;

drop sequence review_no_seq;

create table review(
    review_no number primary key,
    restaurant_no number(38) references restaurant(restaurant_no),
    writer varchar2(4000),
    score number(2) check (score between 1 and 5),
    content varchar2(4000),
    regdate varchar2(30)
);

--리뷰 등록
insert into review(review_no, restaurant_no, writer, score, content, regdate) values(review_no_seq.nextVal, 2, 'jinyuo', 4, '가성비 좋아요.', sysdate);
insert into review(review_no, restaurant_no, writer, score, content, regdate) values(review_no_seq.nextVal, ?, ?, ?, ?, sysdate);

SELECT * FROM review;
--해당 음식점의 리뷰 찾기
SELECT * FROM review where restaurnat_no = ? order by redate desc;
--리뷰 수정
update review set score = ?, content = ? where review_no = ?;
--리뷰 삭제
delete from review where review_no = ?;