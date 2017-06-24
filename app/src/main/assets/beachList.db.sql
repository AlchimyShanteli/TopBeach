BEGIN TRANSACTION;
CREATE TABLE "Imagesbeaches" (
	`id`	INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE,
	`beach_group`	INTEGER,
	`url`	TEXT
);
INSERT INTO `Imagesbeaches` VALUES (1,33,'https://i0.bookcdn.com/data/Photos/OriginalPhoto/125/12564/12564983/Crystal-Beach-Hotel-photos-Exterior.JPEG');
INSERT INTO `Imagesbeaches` VALUES (2,33,'https://i0.bookcdn.com/data/Photos/OriginalPhoto/125/12564/12564983/Crystal-Beach-Hotel-photos-Exterior.JPEG');
INSERT INTO `Imagesbeaches` VALUES (3,33,'https://i0.bookcdn.com/data/Photos/OriginalPhoto/125/12564/12564983/Crystal-Beach-Hotel-photos-Exterior.JPEG');
INSERT INTO `Imagesbeaches` VALUES (4,33,'https://i0.bookcdn.com/data/Photos/OriginalPhoto/125/12564/12564983/Crystal-Beach-Hotel-photos-Exterior.JPEG');
CREATE TABLE "Beaches" (
	`_id`	INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE,
	`country_name`	TEXT,
	`island_name`	TEXT,
	`city_name`	TEXT,
	`beach_name`	TEXT,
	`beach_description`	TEXT,
	`url_id`	INTEGER UNIQUE,
	FOREIGN KEY(`url_id`) REFERENCES `Imagesbeaches`(`beach_group`)
);
INSERT INTO `Beaches` VALUES (1,'Greece','Zakynthos','Anafonitria','Navagio','Amazing place','http://www.amazingplacesonearth.com/wp-content/uploads/2014/03/%CE%9D%CE%B1%CF%85%CE%AC%CE%B3%CE%B9%CE%BF.jpg');
INSERT INTO `Beaches` VALUES (2,'Philippines','Mimaropa, Palawan','Palawan','El Nido','sss','http://media.cntraveler.com/photos/569806fac58591430b12b10e/master/w_1024,c_limit/El-Nido-Palawan-cr-alamy.jpg');
INSERT INTO `Beaches` VALUES (3,'Thailand','Similian','Phang Nga','Koh Similian','rock_beach','https://www.scubadiving-phuket.com/wp-content/uploads/2014/09/Scuba-Diving-Phuket-Holidays-66.jpg');
INSERT INTO `Beaches` VALUES (4,'Bahamas','Out Islands','Andros','Kamalame Cay','I''d conveniently forgotten about the trip to get there. Not a particularly nervous flyer, but still with my little superstitious rituals on take-off, I was feeling the heat (literally) and a little stress as the captain took a handful of us up in the air for the (thankfully) very short flight','http://maniacmagazine.com/wp-content/uploads/2014/04/kamalame.jpg');
INSERT INTO `Beaches` VALUES (5,'Italy','Sicily','Lampedusa','Rabbit Beach Lampedusa','This tranquil escape is located 45 minutes from the capital city of Roseau and is set in the backdrop of the Atlantic Coast. Despite being slightly more inaccessible than other beaches on this list, it offers a view and setting that is rated one of the best in the world. It is most noted for its Boiling lake that is the second-largest volcanically heated water body in the world.','http://www.italia.it/uploads/RTEmagicC_Lampedusa_spiaggia_per_copertina_03.jpg.jpg');
COMMIT;
