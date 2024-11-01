select * from notice1030;

insert into notice1030 values (1, 'WhereIs', 'ABC', 'ABCMarket', '2024-10-31');

insert into notice1030 values (2, 'WhereIs', 'DDD', 'DDDMarket', '2024-10-31');

insert into notice1030 values (3, 'WhenIs', 'ZZZ', 'ZZZMarket', '2024-10-31');

-- ���̺��� Ŀ���� ���� �ٴ´�. Ŀ���� �����ϴ� �޼ҵ尡 �ʿ��ߴ�.
-- �׷��� �������̽�(����̽����� �޶� ������ �� ������ �߻�޼ҵ�� ������ ��) - ������ ����
-- ResultSet�� Ŀ���� �����̴µ� �ʿ��� next(), previous(), isFirst(), isLast() : boolean
-- �׷��� if���̳� while���̳� for�� ��ȣ�ȿ� �� �� �ִ�.

-- PreparedStatement (��������) <- �������� Statement
-- SELECT --> pstmt.exeuteQuery("SELECT ��") | ruturn Ÿ���� ResultSet(�������̽�)
-- INSERT, UPDATE, DELETE --> commit�� roolback�� ���
-- pstmt.executeUpdate("INSERT��|UPDATE��|DELETE��")|int

-- javadoc����
-- CRUD ���� (�Է�, ����, ����, ��ȸ) - Model ����(������ ó�� + ����Ͻ� ����)
-- Restful API - CRUD����


select * from dept;

select * from emp;

select * from bonus;

INSERT INTO dept(DEPTNO, DNAME, LOC) VALUES(50, '�ѹ���', '��õ');

commit;

-- executeUpdate()|result:int
UPDATE dept SET dname='���ߺ�', loc='���ֵ�' where deptno = 50;

    -- executeUpdate(update��-ó��):int -> 1row updated
    -- if (result == 1) ������ �����Ͽ����ϴ�. else ������ �����Ͽ����ϴ�. - ����
    
DELETE FROM dept WHERE deptno=:x;


-- join ����
select a.*, b.loc 
    from emp a 
    left join dept b on a.deptno = b.deptno;

-- ������
select deptno from dept
minus
select deptno from emp;

-- ������
select deptno from dept
intersect
select deptno from emp;


delete from dept where deptno=:x;

-- join
SELECT emp.ename, emp.sal, emp.HIREDATE, dept.dname
FROM emp;

-- pk -> unique index(���Ϲ�����-��������, not null)
-- �׷��� ���̺��� access ���� �ʰ�, index�� �а� ����� ����Ѵ�.
-- index - ���� ������ �ȴ�. �ε����� �����ϴ� ������ ������ �ֽ��ϴ�. - �ε��� ������ ����

-- 1) �Ľ�
-- 2) RDBMS�� �����ȹ�� �����.
-- 3) ��Ƽ�������� �����ȹ�� �޾Ƽ� ó���մϴ�. (INSERT, UPDATE, DELETE)
-- 4) OPEN... CURSOR(��ġ�� �����Ͱ� �����ϸ� true, false ��ȯ - �ñ׳�)... fetch... CLOSE

-- ������ pk�� �����մϴ�.
select ename from emp;

-- FK �ܷ�Ű, �ε����� �������� �ʽ��ϴ�.
-- ��� ������ deptno�� �μ� ���հ� 1:n ����� �߰��� �÷��ε�, �̰��� �ַ�Ű��� �մϴ�.
select count(deptno) from emp where deptno = 30;

select count(deptno) from emp where deptno = 10;

select distinct(deptno) from emp;

select ename from emp order by ename asc;

-- Hint�� -- hint���� ���ؼ� ��Ƽ���������� �������� �����ȹ�� ������ �� �ֽ��ϴ�.
-- ���� ��Ÿ�� ������ ���õ˴ϴ�.
select /*+index_desc(emp pk_emp) */ empno from emp;

