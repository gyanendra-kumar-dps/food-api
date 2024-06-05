create table if not exists "customer" ("id" integer not null, "email" varchar(255), "name" varchar(255), "phone" varchar(255), primary key ("id"));
create table if not exists "meal" ("id" integer not null, "description" varchar(255), "image" varchar(255), "name" varchar(255), "price" varchar(255), primary key ("id"));
create table if not exists "order_meal" ("order_id" integer not null, "meal_id" integer not null);
create table if not exists "orders" ("id" integer not null, "total" float(53), primary key ("id"));
create sequence if not exists "customer_seq" start with 1 increment by 50 ;
create sequence if not exists "meal_seq" start with 1 increment by 50 ;
create sequence if not exists "order_seq" start with 1 increment by 50 ;
alter table if exists "order_meal" add constraint "FKkcx0t6f29c1ackxwatmqy582t" foreign key ("meal_id") references "meal" ;
alter table if exists "order_meal" add constraint "FKh5ugvq705pqig9e9wpog3fjb9" foreign key ("order_id") references "orders" ;