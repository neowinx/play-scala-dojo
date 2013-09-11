# --- First database schema

# --- !Ups

create table persona (
  id                     integer not null primary key,
  nombre                 varchar(255) not null,
  ci                     varchar(255) not null
);

# --- !Downs

drop table if exists persona;
