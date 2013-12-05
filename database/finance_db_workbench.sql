select count(*) from finance.stock;
select * from finance.stock limit 10000;
select * from finance.sector;
select * from finance.industry;
select * from finance.stock where symbol like 'F';
select * from finance.asset where stock_id=3940;
select count(*) from finance.stock;
select * from finance.asset where stock_id in (select id from finance.stock where symbol like '%AEL%');

