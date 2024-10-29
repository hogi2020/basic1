-- 상태값이 3가지 입니다.
-- 아이디가 존재하지 않으면 -1을 반환하는 쿼리문 작성

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
    
    -- 컬럼명이 오는 자리에 rownum을 사용하면 순번이 생긴다.
    -- 전체 범위 처리를 부분범위 처리로 계산할 때도 사용할 수 있습니다.
    select rownum rno from emp;
    
    -- 사원번호를 채번하는 퀴리문을 작성하시오
    
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
    SELECT NVL((SELECT 1 FROM dual --아이디가 존재하면
                 WHERE EXISTS(SELECT mem_name FROM tomato_member WHERE mem_id = p_id)),-1)
                 into status
    FROM dual;
    
    IF status = 1 THEN -- 1이면 비번도 검사해볼까?
        SELECT NVL ((SELECT mem_name 
                      FROM tomato_member 
                      WHERE mem_id = p_id AND mem_pw = p_pw), '비밀번호가 틀립니다.') 
                      into msg
        FROM dual;
    ELSE 
        msg:='아이디가 존재하지 않습니다.';
    END IF;
END;
