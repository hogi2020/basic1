select * from notice1030;

insert into notice1030 values (1, 'WhereIs', 'ABC', 'ABCMarket', '2024-10-31');

insert into notice1030 values (2, 'WhereIs', 'DDD', 'DDDMarket', '2024-10-31');

insert into notice1030 values (3, 'WhenIs', 'ZZZ', 'ZZZMarket', '2024-10-31');

-- 테이블에는 커서가 따라 붙는다. 커서를 조작하는 메소드가 필요했다.
-- 그러면 인터페이스(디바이스마다 달라서 결정할 수 없으면 추상메소드로 정의할 것) - 다형성 실현
-- ResultSet은 커서를 움직이는데 필요한 next(), previous(), isFirst(), isLast() : boolean
-- 그래서 if문이나 while문이나 for문 괄호안에 쓸 수 있다.

-- PreparedStatement (동적쿼리) <- 정적쿼리 Statement
-- SELECT --> pstmt.exeuteQuery("SELECT 문") | ruturn 타입이 ResultSet(인터페이스)
-- INSERT, UPDATE, DELETE --> commit과 roolback의 대상
-- pstmt.executeUpdate("INSERT문|UPDATE문|DELETE문")|int

-- javadoc문법
-- CRUD 수업 (입력, 수정, 삭제, 조회) - Model 계층(데이터 처리 + 비즈니스 로직)
-- Restful API - CRUD수업


select * from dept;

select * from emp;

select * from bonus;

INSERT INTO dept(DEPTNO, DNAME, LOC) VALUES(50, '총무부', '인천');

commit;

-- executeUpdate()|result:int
UPDATE dept SET dname='개발부', loc='제주도' where deptno = 50;

    -- executeUpdate(update문-처리):int -> 1row updated
    -- if (result == 1) 수정에 성공하였습니다. else 수정에 실패하였습니다. - 응답
    
DELETE FROM dept WHERE deptno=:x;


-- join 구문
select a.*, b.loc 
    from emp a 
    left join dept b on a.deptno = b.deptno;

-- 차집합
select deptno from dept
minus
select deptno from emp;

-- 교집합
select deptno from dept
intersect
select deptno from emp;


delete from dept where deptno=:x;

-- join
SELECT emp.ename, emp.sal, emp.HIREDATE, dept.dname
FROM emp;

-- pk -> unique index(유일무이한-제약조건, not null)
-- 그래서 테이블을 access 하지 않고, index만 읽고서 결과를 출력한다.
-- index - 따로 관리가 된다. 인덱스를 관리하는 별도의 공간이 있습니다. - 인덱스 전략을 수립

-- 1) 파싱
-- 2) RDBMS가 실행계획을 세운다.
-- 3) 옵티마이저가 실행계획을 받아서 처리합니다. (INSERT, UPDATE, DELETE)
-- 4) OPEN... CURSOR(위치에 데이터가 존재하면 true, false 반환 - 시그널)... fetch... CLOSE

-- 정렬은 pk만 제공합니다.
select ename from emp;

-- FK 외래키, 인덱스가 제공되지 않습니다.
-- 사원 집합의 deptno는 부서 집합과 1:n 관계로 추가된 컬럼인데, 이것을 왜래키라고 합니다.
select count(deptno) from emp where deptno = 30;

select count(deptno) from emp where deptno = 10;

select distinct(deptno) from emp;

select ename from emp order by ename asc;

-- Hint문 -- hint문을 통해서 옵티마이저에게 개발자의 실행계획을 전달할 수 있습니다.
-- 만약 오타가 있으면 무시됩니다.
select /*+index_desc(emp pk_emp) */ empno from emp;

