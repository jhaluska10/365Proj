insert into Logins(uname, pHash, pSalt) values('test1',
	0x7a37b85c8918eac19a9089c0fa5a2ab4dce3f90528dcdeec108b23ddf3607b99,
    'salt');
    
SELECT * FROM Logins WHERE uname='test1';

select * from Logins;

insert into Items(ownedBy, item, quantity, addedBy, dateAdd, category)
	values(1, 'Cheese', 5, 1, '2022-05-18', 'Food');
    
select * from Items;

SELECT I.item, I.quantity, L2.uname, I.dateAdd
	FROM Logins as L1, Items as I, Logins as L2
    WHERE L1.uid=I.ownedBy and I.ownedBy=1 and I.category='Food' and L2.uid=I.addedBy;
    
select * from Friends;
SELECT L.uname, L.uid
	FROM Friends as F, Logins as L
	WHERE F.uid2=3 and L.uid=F.uid1 and F.u2Accept=false
    ORDER BY L.uname;
    
SELECT L.uname, L.uid
	FROM Friends as F, Logins as L
	WHERE (F.uid2=3 and L.uid=F.uid1) or (F.uid1=3 and L.uid=F.uid2) and F.u1Accept=true and F.u2Accept=true
    ORDER BY L.uname;
    
SELECT I.item, I.quantity, L2.uname, I.dateAdd, I.category, I.id 
	FROM Logins as L1, Items as I, Logins as L2 
	WHERE L1.uid=I.ownedBy and I.ownedBy=1 and I.item LIKE '%cheese%' and L2.uid=I.addedBy
	ORDER BY I.dateAdd desc;