-- Create tables
create table if not exists roles (
    role_id bigint generated always as identity,
    name varchar(20),
    description varchar(100)
);

create table if not exists users (
    user_id bigint generated always as identity,
    first_name varchar(50),
    last_name varchar(50),
    email varchar(255),
    identity_document varchar(50),
    phone varchar(20),
    address varchar(255),
    birth_date date,
    base_salary numeric(10,2),
    role_id bigint
);

-- Add primary keys constraints
alter table roles
	add constraint pk_roles primary key (role_id);

alter table users
	add constraint pk_users primary key (user_id);

-- Add not null constraints
alter table roles
    alter column name set not null,
    alter column description set not null;

alter table users
    alter column first_name set not null,
    alter column last_name set not null,
    alter column email set not null,
    -- alter column identity_document set not null,
    -- alter column phone set not null,
    -- alter column address set not null,
    -- alter column birth_date set not null,
    -- alter column role_id set not null,
    alter column base_salary set not null;

-- Add unique constraints
alter table roles
	add constraint un_roles_name unique (name);
alter table users
	add constraint un_users_email unique (email);

-- Add foreign key constraints
alter table users
	add constraint fk_users_roles
	foreign key (role_id) references roles(role_id)
	on delete restrict;

-- Add check constraints
alter table users
    add constraint chk_users_first_name_not_empty check (length(trim(first_name)) > 0);

alter table users
    add constraint chk_users_last_name_not_empty check (length(trim(last_name)) > 0);

alter table users
    add constraint chk_users_email_not_empty check (length(trim(email)) > 0);

alter table users
	add constraint chk_users_base_salary
		check (base_salary >= 0 and base_salary <= 15000000);

alter table users
	add constraint chk_users_email
		check (email ~* '^[A-Za-z0-9](\.?[A-Za-z0-9_-])*@[A-Za-z0-9-]+(\.[A-Za-z]{2,})+$')

