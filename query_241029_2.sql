select * from zipcode_1;

select zipcode, address
from zipcode_1
where dong = '°ø´öµ¿';

select zipcode, address
from zipcode_1
where dong like '°ø´ö'||'%';


select zipcode, address
from zipcode_1
where dong like '°¡»ê'||'%';


select 'ÀüÃ¼' zdo from dual
union all
select zdo
from (select distinct(zdo) zdo
       from zipcode_1 
       order by zdo asc);

