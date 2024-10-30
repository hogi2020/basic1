-- ���°��� 3���� �Դϴ�.
-- ���̵� �������� ������ -1�� ��ȯ�ϴ� ������ �ۼ�

    select
            case when mem_id =: id then
            case when mem_pw =: pw then 1
            else 0
            end
        else -1
        end as result
    from TOMATO_MEMBER 
    where rownum = 1;
    
    
    select rownum rno, deptno, dname, loc from dept;
    
    
    select 1 from dual
    union all
    select 2 from dual
    union all
    select 3 from dual;
    
    -- �÷����� ���� �ڸ��� rownum�� ����ϸ� ������ �����.
    -- ��ü ���� ó���� �κй��� ó���� ����� ���� ����� �� �ֽ��ϴ�.
    select rownum rno from emp;
    
    -- �����ȣ�� ä���ϴ� �������� �ۼ��Ͻÿ�
    
    select
        /*+index_desc(emp pk_emp) */ empno
    from emp
    where rownum = 1;
    
    
    select
        ((select /*+index_desc(emp pk_emp) */ empno from emp where rownum = 1) + 1) as new_empno
    from dual;
    
    
    select ename from emp;
    
        
CREATE OR REPLACE procedure proc_login(p_id in varchar2, p_pw in varchar2, status out number, msg out varchar2)
IS 
BEGIN
    SELECT NVL((SELECT 1 FROM dual --���̵� �����ϸ�
                 WHERE EXISTS(SELECT mem_name FROM tomato_member WHERE mem_id = p_id)),-1)
                 into status
    FROM dual;
    
    IF status = 1 THEN -- 1�̸� ����� �˻��غ���?
        SELECT NVL ((SELECT mem_name 
                      FROM tomato_member 
                      WHERE mem_id = p_id AND mem_pw = p_pw), '��й�ȣ�� Ʋ���ϴ�.') 
                      into msg
        FROM dual;
    ELSE 
        msg:='���̵� �������� �ʽ��ϴ�.';
    END IF;
END;
