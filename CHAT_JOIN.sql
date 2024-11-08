CREATE OR REPLACE PROCEDURE SCOTT.chat_join (
    mem_nick_in IN MEMBER.MEM_NICK%TYPE,
    mem_pw_in IN MEMBER.MEM_PW%TYPE,
    is_true OUT NUMBER
) IS
BEGIN
    -- 사용자 닉네임과 비밀번호가 일치하는 레코드가 있는지 확인하고 is_true에 설정
    SELECT CASE 
               WHEN COUNT(*) > 0 THEN 1 
               ELSE 0 
           END 
    INTO is_true
    FROM MEMBER
    WHERE MEM_NICK = mem_nick_in
      AND MEM_PW = mem_pw_in;
END;