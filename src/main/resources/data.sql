insert into users (login, email, password) values
('Mike', 'mike@mail.ru', '$2a$10$hbmZLkjQ091Rs9hDSW3CdO2o3rzh.Oi85Fl8H4WrcOrbmJwGPVI3y'),
('Bob', 'bob@mail.ru', '$2a$10$hbmZLkjQ091Rs9hDSW3CdO2o3rzh.Oi85Fl8H4WrcOrbmJwGPVI3y');

insert into roles (name) values ('ADMIN'), ('USER');
insert into users_roles values (1, 1), (1, 2), (2, 2);