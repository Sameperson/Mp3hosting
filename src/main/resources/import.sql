-- Roles

insert into role (name) values ('ROLE_USER');
insert into role (name) values ('ROLE_ADMIN');

-- Temporary user details, password is "password"

insert into user (enabled, username,password,role_id) values (true, 'user','$2a$08$wgwoMKfYl5AUE9QtP4OjheNkkSDoqDmFGjjPE2XTPLDe9xso/hy7u',1);
insert into user (enabled, username,password,role_id) values (true, 'user2','$2a$08$wgwoMKfYl5AUE9QtP4OjheNkkSDoqDmFGjjPE2XTPLDe9xso/hy7u',1);
insert into user (enabled, username,password,role_id) values (true, 'admin','$2a$08$wgwoMKfYl5AUE9QtP4OjheNkkSDoqDmFGjjPE2XTPLDe9xso/hy7u',1);

-- Mp3

-- insert into mp3 (name) values ('Rameses B - Visionary');
