SELECT
    b_no, b_name, b_author, b_publish
FROM book152
WHERE b_name LIKE '%'||'박'||'%';

-- 검색결과가 없을 때 NullPointerException 조심하기


SELECT
    b_no, b_name, b_author, b_publish
FROM book152
WHERE b_name LIKE '%'||:keyword||'%';