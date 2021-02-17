drop table if exists users cascade;
create table users
(
    id bigserial primary key,
    firstname varchar(30),
    lastname varchar(30),
    nickname varchar(20) not null unique,
    email varchar(255) not null unique ,
    password varchar(255) not null,
    active boolean default true,
    registration_date date not null
);

drop table if exists roles cascade;
create table roles
(
    id smallserial primary key,
    name varchar(255) not null
);

drop table if exists users_roles cascade;
create table users_roles
(
    user_id bigint not null,
    role_id smallint not null,
    primary key (user_id, role_id),
    foreign key (user_id) references users(id),
    foreign key (role_id) references roles(id)
);

drop table if exists posts cascade;
create table posts
(
    id bigserial primary key,
    title varchar(255) not null,
    description varchar(1000),
    location varchar(255),
    likes integer,
    created date not null,
    author bigint,
    foreign key(author) references users(id)
);

drop table if exists likes_posts cascade;
create table likes_posts
(
    user_id bigint not null,
    post_id bigint not null,
    primary key (user_id, post_id),
    foreign key (user_id) references users(id),
    foreign key (post_id) references posts(id)
);

drop table if exists comments cascade;
create table comments
(
    id smallserial primary key,
    text varchar(600) not null,
    post bigint not null,
    author bigint not null,
    created date not null,
    foreign key (post) references posts(id),
    foreign key (author) references users(id)
);
