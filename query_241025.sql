select empno as "사원번호", ename as "사원명", deptno as "부서번호" From emp;

select empno from emp;

-- hint문
1. paring - 파싱 - 문법적으로 문제가 있는지 체크
2. DBMS가 실행계획을 세운다.
3. 옵티마이저에게 넘긴다.
4. open....cursor...fetch....close


select rowid rid from emp;

select ename from emp;

select ename from emp where rowid = 'AAARE8AAEAAAACTAAA';

-- 인덱스가 있는 컬럼은 orther by를 쓰지 않아도 오름차순이 디폴트다.
-- 인덱스를 만들 때, 디폴트로 asc를 넣어준다.

select * from emp order by empno asc;

select /* +index_desc(emp pk_emp) */ * from emp;

부서집합 - 4건 - 인덱스 - 순번 - 사원집합 - 인덱스 - detpno(외래키)
양쪽 테이블에 모두 존재하는 경우만 조회됩니다.


select
    d.deptno, e.ename, d.dname
from emp e, dept d
where E.DEPTNO = D.DEPTNO;

select distinct (deptno) from emp;

select deptno from emp;
