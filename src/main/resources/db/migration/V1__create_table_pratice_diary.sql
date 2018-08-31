create table diary (
  id bigint(20) primary key auto_increment,
  date DATE,
  text varchar(255),
  is_excellent boolean default false
)default charset utf8;
