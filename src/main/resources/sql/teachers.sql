USE hiber7pro2db;

INSERT INTO `teachers` (id, firstname, lastname, is_active, region_id, teacher_more_info_id) VALUES
    (1,'Αθανάσιος','Ανδρούτσος',true, 1,NULL),
	(2,'Μάκης','Καπέτης', true, 2,NULL),
	(3,'Μάρκος','Καραμπάτσης',true, 5,NULL),
	(4,'Παναγιώτης','Μόσχος', true, 4,NULL),
	(5,'Σοφοκλής','Στουραϊτης', true, 8,NULL);

ALTER TABLE teachers AUTO_INCREMENT = 6;