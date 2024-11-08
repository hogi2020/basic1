CREATE OR REPLACE PROCEDURE SCOTT.chat_join (
    mem_nick_in IN MEMBER.MEM_NICK%TYPE,
    mem_pw_in IN MEMBER.MEM_PW%TYPE,
    is_true OUT NUMBER
) IS
BEGIN
    -- ����� �г��Ӱ� ��й�ȣ�� ��ġ�ϴ� ���ڵ尡 �ִ��� Ȯ���ϰ� is_true�� ����
    SELECT CASE 
               WHEN COUNT(*) > 0 THEN 1 
               ELSE 0 
           END 
    INTO is_true
    FROM MEMBER
    WHERE MEM_NICK = mem_nick_in
      AND MEM_PW = mem_pw_in;
END;