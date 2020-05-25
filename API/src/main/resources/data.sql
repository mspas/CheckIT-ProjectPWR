INSERT INTO ROLE VALUES
	(1,'STUDENT'), (2,'LECTURER');


INSERT INTO ACCOUNT VALUES
	('111111@student.pwr.wroc.pl', '$2a$10$zBV.Z8D6XtHZx0gD0w8apuGtaePCW4mt4uLd8yiiTUK9Tppkhipj6'),
	('222222@student.pwr.wroc.pl', '$2a$10$zBV.Z8D6XtHZx0gD0w8apuGtaePCW4mt4uLd8yiiTUK9Tppkhipj6'),
	('333333@student.pwr.wroc.pl', '$2a$10$zBV.Z8D6XtHZx0gD0w8apuGtaePCW4mt4uLd8yiiTUK9Tppkhipj6'),
	('karol.krawczyk@pwr.wroc.pl','$2a$10$zBV.Z8D6XtHZx0gD0w8apuGtaePCW4mt4uLd8yiiTUK9Tppkhipj6'),
	('adam.ksieniewicz@pwr.wroc.pl', '$2a$10$zBV.Z8D6XtHZx0gD0w8apuGtaePCW4mt4uLd8yiiTUK9Tppkhipj6'),
	('ivan.romanov@pwr.wroc.pl', '$2a$10$zBV.Z8D6XtHZx0gD0w8apuGtaePCW4mt4uLd8yiiTUK9Tppkhipj6'),
	('777777@student.pwr.wroc.pl', '$2a$10$zBV.Z8D6XtHZx0gD0w8apuGtaePCW4mt4uLd8yiiTUK9Tppkhipj6'),
	('888888@student.pwr.wroc.pl', '$2a$10$zBV.Z8D6XtHZx0gD0w8apuGtaePCW4mt4uLd8yiiTUK9Tppkhipj6'),
	('999999@student.pwr.wroc.pl', '$2a$10$zBV.Z8D6XtHZx0gD0w8apuGtaePCW4mt4uLd8yiiTUK9Tppkhipj6'),
	('101010@student.pwr.wroc.pl', '$2a$10$zBV.Z8D6XtHZx0gD0w8apuGtaePCW4mt4uLd8yiiTUK9Tppkhipj6'),
	('110110@student.pwr.wroc.pl', '$2a$10$zBV.Z8D6XtHZx0gD0w8apuGtaePCW4mt4uLd8yiiTUK9Tppkhipj6'),
	('220220@student.pwr.wroc.pl', '$2a$10$zBV.Z8D6XtHZx0gD0w8apuGtaePCW4mt4uLd8yiiTUK9Tppkhipj6');

INSERT INTO USER VALUES
	(1,'Kamil', 'Brzycki',false, '111111@student.pwr.wroc.pl'),
	(2,'Tomcio', 'Paluch',false, '222222@student.pwr.wroc.pl'),
	(3,'Mateusz', 'Marciniak',false, '333333@student.pwr.wroc.pl'),
	(4,'Karol', 'Krawczyk',false, 'karol.krawczyk@pwr.wroc.pl'),
	(5,'Adam', 'Ksieniewicz',false, 'adam.ksieniewicz@pwr.wroc.pl'),
	(6,'Ivan', 'Romanov',false, 'ivan.romanov@pwr.wroc.pl'),
	(7,'Erwin', 'Brzycki',false, '777777@student.pwr.wroc.pl'),
	(8,'Kazimierz', 'Wielki',false, '888888@student.pwr.wroc.pl'),
	(9,'Jadwiga', 'Nowak',false, '999999@student.pwr.wroc.pl'),
	(10,'Adam', 'Norek',false, '101010@student.pwr.wroc.pl'),
	(11,'Mariusz', 'Kaszka',false, '110110@student.pwr.wroc.pl'),
	(12,'Karolina', 'Matejko',false, '220220@student.pwr.wroc.pl');

INSERT INTO USER_ROLE VALUES
	(1,1), (1,2), (1,3),(2,4), (2,5), (2,6),(1,7),(1,8),(1,9),(1,10),(1,11),(1,12);

INSERT INTO LECTURE_HALL VALUES
	(1,'C4','s239'),
	(2,'C4','s235'),
	(3,'C16','L2.4'),
	(4,'C16','P2.1'),
	(5,'C16','P2.4'),
	(6,'C13','0.31'),
	(7,'C13','1.12'),
	(8,'C13','1.27');
	
INSERT INTO COURSE VALUES
(1,'E05-10b', 'Social Communication',4),
(2,'E08-59a', 'Computer Project Management',5),
(3,'E08-70a','Research Skills and Methodologies',4),
(4,'E08-63a', 'Information System Modeling',6),
(5,'E03-86f', 'Discrete Mathematics',6),
(6,'E08-60a', 'Elect. media in Busi.',5);	
	
INSERT INTO COURSE_STUDENT VALUES
(1,1),(1,2),(1,3),(1,4),(1,6),(1,7),(1,8),(1,9),(1,10),
(2,2),(2,1),(2,3),(2,4),(2,5),(2,6),(2,8),(2,9),(2,10),(2,12),
(3,1),(3,5),(3,6),(3,2),(3,8),(3,9),(3,10),(3,11),(3,12),
(4,2),(2,1),(2,3),(2,4),(2,5),(2,6),(2,8),(2,9),(2,10),(2,11),(2,12),
(5,2),(2,1),(2,3),(2,4),(2,5),(2,6),(2,8),(2,9),(2,10),(2,11),
(6,2),(2,1),(2,3),(2,4),(2,5),(2,6),(2,8);

INSERT INTO LECTURE VALUES
	(1, '2020-05-13 7:30:00',105,1, 1, 4),
	(2, '2020-05-20 7:30:00',105,1, 1, 4),
	(3, '2020-05-27 7:30:00',105,1, 1, 4),
	(4, '2020-06-03 7:30:00',105,1, 1, 4),
	(5, '2020-06-10 7:30:00',105,1, 1, 4),
	(6, '2020-06-17 7:30:00',105,1, 1, 4),
	(7, '2020-05-11 9:00:00' ,105,2, 1, 4),
	(8, '2020-05-18 9:00:00' ,105,2, 1, 4),
	(9, '2020-05-25 9:00:00' ,105,2, 1, 4),
	(10,'2020-06-01 9:00:00' ,105,2, 1, 4),
	(11,'2020-06-08 9:00:00' ,105,2, 1, 4),
	(12,'2020-06-15 9:00:00' ,105,2, 1, 4),
	(13, '2020-05-13 13:00:00', 165,6, 1, 4),
	(14, '2020-05-20 13:00:00' ,165,6, 1, 4),
	(15, '2020-05-27 13:00:00' ,165,6, 1, 4),
	(16,'2020-06-03 13:00:00' ,165,6, 1, 4),
	(17,'2020-06-10 13:00:00' ,165,6, 1, 4),
	(18,'2020-06-17 13:00:00' ,165,6, 1, 4),
	(19,'2020-06-24 13:00:00' ,165,6, 1, 4),
	(20,'2020-07-01 13:00:00' ,165,6, 1, 4),
	(21, '2020-05-13 9:15:00' ,105,3, 1, 4),
	(22, '2020-05-20 9:15:00' ,105,3, 1, 4),
	(23, '2020-05-27 9:15:00' ,105,3, 1, 4),
	(24,'2020-06-03 9:15:00' ,105,3, 1, 4),
	(25,'2020-06-10 9:15:00' ,105,3, 1, 4),
	(26,'2020-06-17 9:15:00' ,105,3, 1, 4),
	(27,'2020-07-24 9:15:00' ,105,3, 1, 4),
	(28, '2020-05-13 13:00:00' ,105,4, 1, 4),
	(29, '2020-05-20 13:00:00' ,105,4, 1, 4),
	(30, '2020-05-27 13:00:00' ,105,4, 1, 4),
	(31,'2020-06-03 13:00:00' ,105,4, 1, 4),
	(32,'2020-06-10 13:00:00' ,105,4, 1, 4),
	(33,'2020-06-17 13:00:00' ,105,4, 1, 4),
	(34,'2020-06-24 13:00:00' ,105,4, 1, 4),
	(35, '2020-05-08 16:00:00' ,210,5, 1, 4),
	(36, '2020-05-15 16:00:00' ,210,5, 1, 4),
	(37, '2020-05-22 16:00:00' ,210,5, 1, 4),
	(38,'2020-05-29 16:00:00' ,210,5, 1, 4),
	(39,'2020-06-05 16:00:00' ,210,5, 1, 4),
	(40,'2020-06-12 16:00:00' ,210,5, 1, 4),
	(41,'2020-06-19 16:00:00' ,210,5, 1, 4);
	
	
	
	INSERT INTO STUDENT_LECTURE VALUES
	(1,2),(1,1),(1,3),(1,10),(1,4),
	(2,9),(2,7),(2,8),(2,10),
	(3,2),(3,3),
	(13,1),(13,7),
	(14,2),(14,3),
	(15,2),(15,8),
	(21,2),(21,8),(21,7),
	(22,2),(22,7),(22,9),
	(23,2),(23,1),
	(28,3),(28,7),
	(29,1),(29,2),
	(30,1),(30,7),
	(35,1),(35,8),
	(36,2),(36,8),(36,7),
	(37,2),(37,3),(37,7),
	(38,2),(38,8);