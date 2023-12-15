
create database ems;
use ems;

create table employee (
  id int primary key,
  name varchar(25),
  gender varchar(10),
  phoneNum varchar(13),
  email varchar(25),
  designation varchar(20),
  salary double
);

create table admin (
  username varchar(25) primary key,
  password varchar(25)
);

insert into admin values
("admin","admin123"),
("admin2","0000");

insert into employee values
(142,"Jon Snow","Male","8454562158","jon@gmail.com","Associate",30000.0),
(127,"Robb Stark","Male","7654812345","robb@gmail.com","Manager",80000.0);

