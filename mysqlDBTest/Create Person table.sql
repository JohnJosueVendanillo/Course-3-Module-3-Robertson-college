use norima;

create table person(
		ID int AUTO_INCREMENT primary key,
        FirstName nvarchar(50) not null ,
        Lastname nvarchar(50) not null
        );

insert into person (FirstName,Lastname) values ('Jim','Neutron'),('Jim','Saints'),('Bill','jeans');

SELECT * FROM person;