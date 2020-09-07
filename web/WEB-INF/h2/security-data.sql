insert into users (username,password,enabled) values ('user1@example.com','user1',1);
insert into users (username,password,enabled) values ('admin1@example.com','admin1',1);
insert into users (username,password,enabled) values ('user2@example.com','admin1',1);
insert into users (username,password,enabled) values ('disabled1@example.com','disabled1',0);

insert into authorities(username,authority) values ('user1@example.com','ROLE_USER');
insert into authorities(username,authority) values ('admin1@example.com','ROLE_ADMIN');
insert into authorities(username,authority) values ('admin1@example.com','ROLE_USER');
insert into authorities(username,authority) values ('user2@example.com','ROLE_USER');
insert into authorities(username,authority) values ('disabled1@example.com','ROLE_USER');
