select count(distinct id) from users;

select * from users;

select count(*) from book_borrow where returned_date is null;


select bc.name, count(*) from book_borrow bb inner join books b
    on bb.book_id = b.id
inner join book_categories bc on b.book_category_id = bc.id
group by name order by 2 desc ;



select * from users;

select full_name, count(*)
from book_borrow b inner join
    users u on b.user_id = u.id
group by user_id order by 2 desc ;


select name, author,year from books where name='Chordeiles minor';


select name from book_categories;



