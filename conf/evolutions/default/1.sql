# File Storage Schema

# --- !Ups


create table kpiTemplate(
  id bigint unsigned not null auto_increment ,
  name varchar(255) not null,
  description mediumtext default null,
  isActive bool default false,
  primary key(id)
);

create table kpiSection (
  id bigint unsigned not null auto_increment ,
  templateId bigint unsigned not null,
  name varchar(255) not null,
  position tinyint default 1,
  primary key(id)
);


insert into kpiTemplate (id, name, description, isActive) values
(1, "Performance 2014", "Employ Performance 2014 KPI", true),
(2, "Performance 2013", "Employ Performance 2013 KPI", false);

insert into kpiSection (templateId, name, position) values
(1, "Financial", 1),
(1, "Customer", 2),
(1, "Internal Business Process", 3),
(1, "Learning and Growth", 4),
(2, "Financial", 1),
(2, "Customer", 2),
(2, "Internal Business Process", 3),
(2, "Learning and Growth", 4);



# --- !Downs

drop table kpiTemplate;
drop table kpiSection;
