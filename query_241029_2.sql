select * from zipcode_1;

select zipcode, address
from zipcode_1
where dong = '������';

select zipcode, address
from zipcode_1
where dong like '����'||'%';


select zipcode, address
from zipcode_1
where dong like '����'||'%';


select '��ü' zdo from dual
union all
select zdo
from (select distinct(zdo) zdo
       from zipcode_1 
       order by zdo asc);

