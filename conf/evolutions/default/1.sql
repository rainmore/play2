# File Storage Schema

# --- !Ups

create table files (
  id bigint not null auto_increment ,
  name varchar(255) not null,
  module tinyint not null,
  contentType varchar(255),
  created datetime not null,
  transferred datetime default null,
  primary key (id)
);

# --- !Downs

drop table files;
