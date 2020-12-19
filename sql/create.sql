create table issue_record(
  id int(11) auto_increment primary key not null,
  copyid  int(11) not null,
  memberid  int(11) not null,
  issue_date date not null,
  return_duedate date not null,
  return_date date not null,
  fine_amount decimal(15,2) not null
);

create table copies (
 id int(11) auto_increment primary key not null,
 bookid varchar(10) not null,
 rack varchar(10) not null,
 status varchar(10) not null
);

create table users (
 id int(11) auto_increment primary key not null,
 name varchar(25) not null,
 email varchar(25) not null,
 phone varchar(20) not null,
 passwd varchar(15) not null,
 role varchar(15)not null
);

create table payments( 
 id int(11) unsigned auto_increment primary key not null,
 userid  int(11)  not null ,
 amount decimal(15,2) not null,
 type varchar(20) not null ,
 transaction_time datetime not null,
 nextpayment_duedate datetime not null
);

create table books(
 id int auto_increment primary key not null,
 name varchar(30) not null, 
 author varchar(15) not null, 
 subject varchar(30) not null, 
 price decimal(10,2) not null, 
 isbn varchar(50) not null 
 );