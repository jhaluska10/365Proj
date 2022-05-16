create table Logins(
	uid int auto_increment primary key,
    uname varchar(24) unique not null,
    pHash varbinary(32) not null,
    pSalt varchar(64) not null
);

insert into Logins(uname, pHash, pSalt) values('test1',
	0x7a37b85c8918eac19a9089c0fa5a2ab4dce3f90528dcdeec108b23ddf3607b99,
    'salt');
    
SELECT pHash, pSalt FROM Logins WHERE uname='test1';