select empno as "�����ȣ", ename as "�����", deptno as "�μ���ȣ" From emp;

select empno from emp;

-- hint��
1. paring - �Ľ� - ���������� ������ �ִ��� üũ
2. DBMS�� �����ȹ�� �����.
3. ��Ƽ���������� �ѱ��.
4. open....cursor...fetch....close


select rowid rid from emp;

select ename from emp;

select ename from emp where rowid = 'AAARE8AAEAAAACTAAA';

-- �ε����� �ִ� �÷��� orther by�� ���� �ʾƵ� ���������� ����Ʈ��.
-- �ε����� ���� ��, ����Ʈ�� asc�� �־��ش�.

select * from emp order by empno asc;

select /* +index_desc(emp pk_emp) */ * from emp;

�μ����� - 4�� - �ε��� - ���� - ������� - �ε��� - detpno(�ܷ�Ű)
���� ���̺� ��� �����ϴ� ��츸 ��ȸ�˴ϴ�.


select
    d.deptno, e.ename, d.dname
from emp e, dept d
where E.DEPTNO = D.DEPTNO;

select distinct (deptno) from emp;

select deptno from emp;
