
select * from member;
DROP TABLE MEMBER;
CREATE TABLE member (
    memberid VARCHAR2(50) PRIMARY KEY,
    name VARCHAR2(50) NOT NULL,
    password VARCHAR2(10) NOT NULL,
    regdate DATE NOT NULL,
    birth date NOT NULL
);

insert into member
(memberid, name, password, regdate, birth)
values 
('a', 'b', 'c', sysdate, to_date('2020-12-24', 'yyyy-mm-dd'));

select *from member;

SELECT COUNT(*) FROM article;





commit;