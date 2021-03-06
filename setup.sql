create table Logins(
	uid int auto_increment primary key,
    uname varchar(24) unique not null,
    pHash varbinary(32) not null,
    pSalt varchar(32) not null
);

create index uname_idx on Logins(uname);

create table Categories(
	cat varchar(16) primary key);
    
insert into Categories values ('Food');
insert into Categories values ('Goods');
insert into Categories values ('Health');
insert into Categories values ('Leisure');
insert into Categories values ('Electrionics');
insert into Categories values ('Fashion');

create table Items(
	id int auto_increment primary key,
    ownedBy int not null,
    item varchar(32) not null,
    quantity int default 1,
    addedBy int not null,
    dateAdd date not null,
    category varchar(16) not null,
    foreign key(ownedBy) references Logins(uid),
    foreign key(addedBy) references Logins(uid),
    foreign key(category) references Categories(cat)
);

create table Friends(
	uid1 int not null,
    uid2 int not null,
    u1Accept bool default true,
    u2Accept bool default false,
    primary key(uid1, uid2),
    foreign key(uid1) references Logins(uid),
    foreign key(uid2) references Logins(uid)
);