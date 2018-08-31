create table diary (
  id bigint(20) primary key auto_increment,
  date DATE,
  text varchar(255),
  isExcellent tinyint(1)
)default charset utf8;
