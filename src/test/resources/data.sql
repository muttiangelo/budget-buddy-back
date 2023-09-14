create table users
(
    id        uuid         not null
        primary key,
    email     varchar(255) not null
        constraint UNIQUE_EMAIL unique,
    password  varchar(255) not null,
    user_role smallint
        constraint users_user_role_check
            check ((user_role >= 0) AND (user_role <= 1)),
    username  varchar(255) not null
        constraint UNIQUE_USERNAME unique
);

insert into users (id, email, password, user_role, username) VALUES ('4c8b9610-50f0-11ee-be56-0242ac120002', 'email@email.com', '123456', 0, 'user.name');