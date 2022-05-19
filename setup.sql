create table Logins(
	uid int auto_increment primary key,
    uname varchar(24) unique not null,
    pHash varbinary(32) not null,
    pSalt varchar(32) not null
);

create index uname_idx on Logins(uname);

create table Items(
	id int auto_increment primary key,
    ownedBy int not null,
    item varchar(32) not null,
    quantity int default 1,
    addedBy int not null,
    dateAdd date not null,
    category enum('Food', 'Goods', 'Health', 'Leisure', 'Electronics', 'Fashion') not null,
    foreign key(ownedBy) references Logins(uid),
    foreign key(addedBy) references Logins(uid)
);

select * from Items;

SELECT I.item, I.quantity, L2.uname, I.dateAdd
	FROM Logins as L1, Items as I, Logins as L2
    WHERE L1.uid=I.ownedBy and I.ownedBy=1 and I.category='Food' and L2.uid=I.addedBy;