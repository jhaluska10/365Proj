insert into Logins(uname, pHash, pSalt) values('test1',
	0x7a37b85c8918eac19a9089c0fa5a2ab4dce3f90528dcdeec108b23ddf3607b99,
    'salt');
    
SELECT * FROM Logins WHERE uname='test1';

select * from Logins;

insert into Items(ownedBy, item, quantity, addedBy, dateAdd, category)
	values(1, 'Cheese', 5, 1, '2022-05-18', 'Food');