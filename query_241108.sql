SELECT
    b_no, b_name, b_author, b_publish
FROM book152
WHERE b_name LIKE '%'||'��'||'%';

-- �˻������ ���� �� NullPointerException �����ϱ�


SELECT
    b_no, b_name, b_author, b_publish
FROM book152
WHERE b_name LIKE '%'||:keyword||'%';