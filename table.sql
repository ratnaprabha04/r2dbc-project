create database reactivedb;

use reactivedb;

CREATE TABLE `product` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(50) default NULL,
  `price` decimal(10,0) default NULL,
  `qoh` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB;


insert into product(name,price,qoh) values('one',123.0,1000);
insert into product(name,price,qoh) values('two',124.0,10200);
