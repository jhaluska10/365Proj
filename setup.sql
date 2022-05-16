create table Logins(
	uid int auto_increment primary key,
    uname varchar(24) unique not null,
    pHash varbinary(32) not null,
    pSalt varchar(32) not null
);

create index uname_idx on Logins(uname);