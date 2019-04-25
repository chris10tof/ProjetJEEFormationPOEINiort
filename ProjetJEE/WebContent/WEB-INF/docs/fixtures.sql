-- -------------------------------------------------------- --
-- -------------------------------------------------------- --
--                                                          --
--               Database: `RECETTE_GOURMANDES`          	--
--                                                          --
-- -------------------------------------------------------- --
-- -------------------------------------------------------- --

-- ---------------------------------------- --
-- Suppression contenu de toutes les tables --
DELETE FROM [AssociationCommentaire];
DELETE FROM [Commande];
DELETE FROM [Plat];
DELETE FROM [Categorie];
DELETE FROM [Commentaire];
DELETE FROM [Inscription];
DELETE FROM [Personne];
DELETE FROM [Role];
DELETE FROM [Reservation];
DELETE FROM [Table];
DELETE FROM [Etat];
DELETE FROM [Restaurant];

-- ----------------------------- --
-- Réaffectation des PRIMARY KEY --
DBCC CHECKIDENT ('AssociationCommentaire', RESEED, 0);
DBCC CHECKIDENT ('Categorie', RESEED, 0);
DBCC CHECKIDENT ('Commande', RESEED, 0);
DBCC CHECKIDENT ('Commentaire', RESEED, 0);
DBCC CHECKIDENT ('Etat', RESEED, 0);
DBCC CHECKIDENT ('Inscription', RESEED, 0);
DBCC CHECKIDENT ('Personne', RESEED, 0);
DBCC CHECKIDENT ('Plat', RESEED, 0);
DBCC CHECKIDENT ('Reservation', RESEED, 0);
DBCC CHECKIDENT ('Restaurant', RESEED, 0);
DBCC CHECKIDENT ('Role', RESEED, 0);
DBCC CHECKIDENT ('Table', RESEED, 0);

-- -------------------------------- --
-- Insertion des données des tables --

-- Restaurant --
INSERT INTO [Restaurant] VALUES ('Rennes',15,'/img/Image_restaurant_Rennes.jpg',111,111);
INSERT INTO [Restaurant] VALUES ('Nantes',10,'/img/Image_restaurant_Nantes.jpg',111,111);
INSERT INTO [Restaurant] VALUES ('Brest',10,'/img/Image_restaurant_Brest.jpg',111,111);

-- Etat --
INSERT INTO [Etat] VALUES ('Verte','Libre');
INSERT INTO [Etat] VALUES ('Grise','Reservee');
INSERT INTO [Etat] VALUES ('Rouge','NoOrder');
INSERT INTO [Etat] VALUES ('Orange','YesOrder');

-- Table --
INSERT INTO [Table] (etat_id, restaurant_id) VALUES (1,1);
insert into [Table] (etat_id, restaurant_id) values (1,1);
insert into [Table] (etat_id, restaurant_id) values (1,1);
insert into [Table] (etat_id, restaurant_id) values (1,1);
insert into [Table] (etat_id, restaurant_id) values (1,1);
insert into [Table] (etat_id, restaurant_id) values (1,1);
insert into [Table] (etat_id, restaurant_id) values (1,1);
insert into [Table] (etat_id, restaurant_id) values (1,1);
insert into [Table] (etat_id, restaurant_id) values (1,1);
insert into [Table] (etat_id, restaurant_id) values (1,1);
insert into [Table] (etat_id, restaurant_id) values (1,1);
insert into [Table] (etat_id, restaurant_id) values (1,1);
insert into [Table] (etat_id, restaurant_id) values (1,1);
insert into [Table] (etat_id, restaurant_id) values (1,1);
insert into [Table] (etat_id, restaurant_id) values (1,1);

insert into [Table] (etat_id, restaurant_id) values (1,2);
insert into [Table] (etat_id, restaurant_id) values (1,2);
insert into [Table] (etat_id, restaurant_id) values (1,2);
insert into [Table] (etat_id, restaurant_id) values (1,2);
insert into [Table] (etat_id, restaurant_id) values (1,2);
insert into [Table] (etat_id, restaurant_id) values (1,2);
insert into [Table] (etat_id, restaurant_id) values (1,2);
insert into [Table] (etat_id, restaurant_id) values (1,2);
insert into [Table] (etat_id, restaurant_id) values (1,2);
insert into [Table] (etat_id, restaurant_id) values (1,2);

-- Reservation --
INSERT INTO [Reservation] (table_id, nom, tel, nbre_personnes) VALUES (1, 'Chris', '0645851264', 2);
INSERT INTO [Reservation] (table_id, nom, tel, nbre_personnes) VALUES (2, 'Robert', '0641258564', 5);
INSERT INTO [Reservation] (table_id, nom, tel, nbre_personnes) VALUES (8, 'Nico', '0645698264', 4);
INSERT INTO [Reservation] (table_id, nom, tel, nbre_personnes) VALUES (6, 'José', '0648512564', 6);

-- Role --
INSERT INTO [Role] VALUES ('Admin');
INSERT INTO [Role] VALUES ('Employe');
INSERT INTO [Role] VALUES ('Client');

-- Personne --
INSERT INTO [Personne] VALUES ('GARCIA','Christophe','christophe@gmail.com','admin','avatar',1);
INSERT INTO [Personne] VALUES ('MOREAU','Robin','moreau.robin16@gmail.com','admin','avatar',1);

-- Inscription --
INSERT INTO [Inscription] VALUES ('Bouche à oreille',1,1);
INSERT INTO [Inscription] VALUES ('Je suis passé devant',1,2);
INSERT INTO [Inscription] VALUES ('Beau frère',1,1);
INSERT INTO [Inscription] VALUES ('Annuaire',1,2);


-- Commentaire --
-- (String contenu, Date date, double note) --
INSERT INTO [Commentaire] VALUES ('Bof', DATEADD(SECOND, ABS(CHECKSUM(NEWID()) % 24 * 32 * 364 * 100 * 10 * RAND() ), '2011-01-01'), 3);
INSERT INTO [Commentaire] VALUES ('Bof', DAY(FLOOR( RAND() * 366 * 100)), 3);
INSERT INTO [Commentaire] VALUES ('Bien', DAY(FLOOR( RAND() * 366 * 100)), 6);
INSERT INTO [Commentaire] VALUES ('Excellent', DAY(FLOOR( RAND() * 366 * 100)), 9);
INSERT INTO [Commentaire] VALUES ('Super', DAY(FLOOR( RAND() * 366 * 100)), 7);
INSERT INTO [Commentaire] VALUES ('Mouais Bof', DAY(FLOOR( RAND() * 366 * 100)), 3);
INSERT INTO [Commentaire] VALUES ('OMG ...', DAY(FLOOR( RAND() * 366 * 100)), 3);
INSERT INTO [Commentaire] VALUES ('Sublime', DAY(FLOOR( RAND() * 366 * 100)), 3);
INSERT INTO [Commentaire] VALUES ('Trop bon', DAY(FLOOR( RAND() * 366 * 100)), 10);
INSERT INTO [Commentaire] VALUES ('Plus que bof', DAY(FLOOR( RAND() * 366 * 100)), 3);
INSERT INTO [Commentaire] VALUES ('Miam miam', DAY(FLOOR( RAND() * 366 * 100)), 3);
INSERT INTO [Commentaire] VALUES ('Bof', DAY(FLOOR( RAND() * 366 * 100)), 3);
INSERT INTO [Commentaire] VALUES ('Bof', DAY(FLOOR( RAND() * 366 * 100)), 3);
INSERT INTO [Commentaire] VALUES ('Bof', DAY(FLOOR( RAND() * 366 * 100)), 3);
INSERT INTO [Commentaire] VALUES ('Bof', DAY(FLOOR( RAND() * 366 * 100)), 3);
INSERT INTO [Commentaire] VALUES ('Bof', DAY(FLOOR( RAND() * 366 * 100)), 3);
INSERT INTO [Commentaire] VALUES ('Bof', DAY(FLOOR( RAND() * 366 * 100)), 3);
INSERT INTO [Commentaire] VALUES ('Bof', DAY(FLOOR( RAND() * 366 * 100)), 3);
INSERT INTO [Commentaire] VALUES ('Bof', DAY(FLOOR( RAND() * 366 * 100)), 3);
INSERT INTO [Commentaire] VALUES ('Bof', DAY(FLOOR( RAND() * 366 * 100)), 3);
INSERT INTO [Commentaire] VALUES ('Bof', DAY(FLOOR( RAND() * 366 * 100)), 3);
INSERT INTO [Commentaire] VALUES ('Bof', DAY(FLOOR( RAND() * 366 * 100)), 3);
INSERT INTO [Commentaire] VALUES ('Bof', DAY(FLOOR( RAND() * 366 * 100)), 3);
INSERT INTO [Commentaire] VALUES ('Bof', DAY(FLOOR( RAND() * 366 * 100)), 3);
INSERT INTO [Commentaire] VALUES ('Bof', DAY(FLOOR( RAND() * 366 * 100)), 3);
INSERT INTO [Commentaire] VALUES ('Bof', DAY(FLOOR( RAND() * 366 * 100)), 3);
INSERT INTO [Commentaire] VALUES ('Bof', DAY(FLOOR( RAND() * 366 * 100)), 3);
INSERT INTO [Commentaire] VALUES ('Bof', DAY(FLOOR( RAND() * 366 * 100)), 3);
INSERT INTO [Commentaire] VALUES ('Bof', DAY(FLOOR( RAND() * 366 * 100)), 3);
INSERT INTO [Commentaire] VALUES ('Bof', DAY(FLOOR( RAND() * 366 * 100)), 3);
INSERT INTO [Commentaire] VALUES ('Bof', DAY(FLOOR( RAND() * 366 * 100)), 3);
INSERT INTO [Commentaire] VALUES ('Bof', DAY(FLOOR( RAND() * 366 * 100)), 3);
INSERT INTO [Commentaire] VALUES ('Bof', DAY(FLOOR( RAND() * 366 * 100)), 3);
INSERT INTO [Commentaire] VALUES ('Bof', DAY(FLOOR( RAND() * 366 * 100)), 3);
INSERT INTO [Commentaire] VALUES ('Bof', DAY(FLOOR( RAND() * 366 * 100)), 3);
INSERT INTO [Commentaire] VALUES ('Bof', DAY(FLOOR( RAND() * 366 * 100)), 3);
INSERT INTO [Commentaire] VALUES ('Bof', DAY(FLOOR( RAND() * 366 * 100)), 3);
INSERT INTO [Commentaire] VALUES ('Bof', DAY(FLOOR( RAND() * 366 * 100)), 3);
INSERT INTO [Commentaire] VALUES ('Bof', DAY(FLOOR( RAND() * 366 * 100)), 3);
INSERT INTO [Commentaire] VALUES ('Bof', DAY(FLOOR( RAND() * 366 * 100)), 3);
INSERT INTO [Commentaire] VALUES ('Bof', DAY(FLOOR( RAND() * 366 * 100)), 3);
INSERT INTO [Commentaire] VALUES ('Bof', DAY(FLOOR( RAND() * 366 * 100)), 3);
INSERT INTO [Commentaire] VALUES ('Bof', DAY(FLOOR( RAND() * 366 * 100)), 3);

-- Categorie --
INSERT INTO [Categorie] VALUES ('Entrée');
INSERT INTO [Categorie] VALUES ('Plats de résistence');
INSERT INTO [Categorie] VALUES ('Dessert');

-- Plat --
INSERT INTO [Plat] VALUES ('Taboulé Libanais', 'La recette du vrai taboulé Libanais.#Niveau Facile et bon marché. Pour 4 personnes.', 8, '4 tomates fermes#1 botte d oignon#2 bottes de persil PLAT#1 botte de menthe fraîche#1 petite poignée de boulgour brun moyen (blé concassé)#1 citron#3 cuillières d Huile d olive#2 pincées de Sel', '/img/taboule_libanais.jpg', 1, 15);
INSERT INTO [Plat] VALUES ('Salade d''automne aux champignons sautés', 'Une salade pour toute les saisons, mais particulièrement appréciable en Automne.#Niveau moyen et cout moyen. Pour 4 personnes.', 9, '2 tasses de champignon des prés#ou à défaut des pleurotes#1 salade frisée triée et lavée#2 oignons émincés fin#2 gousses d''ail écrasées#1 tasse de tomate concassée#1 demi de bouillon de viande#1 thym#1 feuille de laurier fraîche#1 cuillère à soupe de persil plat haché#1 huile#30 g de beurre#2 cuillères de crème fraîche#1 vinaigre de cidre#Sel#Poivre', '/img/salade_automne_champignons_sautes.jpg', 1, 10);
INSERT INTO [Plat] VALUES ('Salade de Chèvre Chaud', 'L''incontournable salade de Chèvre Chaud dans sa version du terroir !#Niveau Facile et bon marché. Pour 2 personnes.', 12, '4 tranches de pain de campagne#2 pélardons (fromage de chèvre AOC)#100 g de lardons nature#1 salade verte (batavia#laitue#romaine selon les goûts)#2 tomates#1 poivron rouge#1 gousse d''ail#1 Huile d''olive#1 basilic', '/img/salade_chevre_chaud.jpg', 2, 20);
INSERT INTO [Plat] VALUES ('Chiktaye de morue Guadeloupe', 'Un plat pour voyager dans les îles ...#Niveau Facile et bon marché. Pour 4 personnes.', 13, '800 g de morue (de préférence un morceau bien épais)#1 oignon#1 piment rouge#1 piment vert#1 citron vert#1 botte de persil#2 feuilles de basilic#2 cuillères à soupe d''huile', '/img/chiktaye_morue_guadeloupe.jpg', 2, 10);
INSERT INTO [Plat] VALUES ('Burger avocat bacon', 'Le burger revisité rien que pour vous.#Niveau Facile et bon marché. Pour 4 personnes.', 13, '4 pains à hamburger#4 steaks hachés#2 tomates#1 oignon rouge#10 g de mayonnaise#1 avocat#0.5 citron vert#Poivre#Sel', '/img/burger_avocat_bacon.jpg', 1, 5);
INSERT INTO [Plat] VALUES ('Cake à la banane et pépites de chocolat', 'Un dessert à vous faire fondre.#Niveau Facile et bon marché. Pour 6 personnes.', 6, '110 g de sucre#2 oeufs#120 g de beurre#100 g de fromage blanc#150 g de farine#3 bananes#1 sachet de chocolat#1 sachet de levure', '/img/cake_banane_chocolat.jpg', 2, 3);
INSERT INTO [Plat] VALUES ('Tarte tatin poires - chocolat', 'Un classique, pour les plus gourmands !#Niveau Facile et bon marché. Pour 6 personnes.', 6, '80 g de beurre doux#100 g de sucre blanc#50 g de sucre cassonade#1 vanille liquide#100 g chocolat#1 cannelle en poudre#4 poires (4 ou 5 selon la grosseur)#1 pâte feuilletée toute prête', '/img/tarte_tatin.jpg', 1, 3);

-- Commande --
INSERT INTO [Commande] VALUES (1,1,2);
INSERT INTO [Commande] VALUES (1,1,3);
INSERT INTO [Commande] VALUES (3,2,2);
INSERT INTO [Commande] VALUES (4,2,3);
INSERT INTO [Commande] VALUES (1,3,2);
INSERT INTO [Commande] VALUES (4,3,3);
INSERT INTO [Commande] VALUES (1,4,2);
INSERT INTO [Commande] VALUES (4,4,3);

-- AssociationCommentaire --
-- (int idAssociation, Personne personneId, Plat platId, Restaurant restaurantId, Commentaire commentaireId) --
INSERT INTO [AssociationCommentaire] VALUES (1, 1, 1, 1);
INSERT INTO [AssociationCommentaire] VALUES (1, 2, 1, 2);
INSERT INTO [AssociationCommentaire] VALUES (1, 3, 1, 3);
INSERT INTO [AssociationCommentaire] VALUES (1, 4, 1, 4);
INSERT INTO [AssociationCommentaire] VALUES (1, 5, 1, 5);
INSERT INTO [AssociationCommentaire] VALUES (1, 6, 1, 6);
INSERT INTO [AssociationCommentaire] VALUES (1, 7, 1, 7);
INSERT INTO [AssociationCommentaire] VALUES (1, 1, 2, 8);
INSERT INTO [AssociationCommentaire] VALUES (1, 2, 2, 9);
INSERT INTO [AssociationCommentaire] VALUES (1, 3, 2, 10);
INSERT INTO [AssociationCommentaire] VALUES (1, 4, 2, 11);
INSERT INTO [AssociationCommentaire] VALUES (1, 5, 2, 12);
INSERT INTO [AssociationCommentaire] VALUES (1, 6, 2, 13);
INSERT INTO [AssociationCommentaire] VALUES (1, 7, 2, 14);
INSERT INTO [AssociationCommentaire] VALUES (1, 1, 3, 15);
INSERT INTO [AssociationCommentaire] VALUES (1, 2, 3, 16);
INSERT INTO [AssociationCommentaire] VALUES (1, 3, 3, 17);
INSERT INTO [AssociationCommentaire] VALUES (1, 4, 3, 18);
INSERT INTO [AssociationCommentaire] VALUES (1, 5, 3, 19);
INSERT INTO [AssociationCommentaire] VALUES (1, 6, 3, 20);
INSERT INTO [AssociationCommentaire] VALUES (1, 7, 3, 21);
INSERT INTO [AssociationCommentaire] VALUES (2, 1, 1, 22);
INSERT INTO [AssociationCommentaire] VALUES (2, 2, 1, 23);
INSERT INTO [AssociationCommentaire] VALUES (2, 3, 1, 24);
INSERT INTO [AssociationCommentaire] VALUES (2, 4, 1, 25);
INSERT INTO [AssociationCommentaire] VALUES (2, 5, 1, 26);
INSERT INTO [AssociationCommentaire] VALUES (2, 6, 1, 27);
INSERT INTO [AssociationCommentaire] VALUES (2, 7, 1, 28);
INSERT INTO [AssociationCommentaire] VALUES (2, 1, 2, 29);
INSERT INTO [AssociationCommentaire] VALUES (2, 2, 2, 30);
INSERT INTO [AssociationCommentaire] VALUES (2, 3, 2, 31);
INSERT INTO [AssociationCommentaire] VALUES (2, 4, 2, 32);
INSERT INTO [AssociationCommentaire] VALUES (2, 5, 2, 33);
INSERT INTO [AssociationCommentaire] VALUES (2, 6, 2, 34);
INSERT INTO [AssociationCommentaire] VALUES (2, 7, 2, 35);
INSERT INTO [AssociationCommentaire] VALUES (2, 1, 3, 36);
INSERT INTO [AssociationCommentaire] VALUES (2, 2, 3, 37);
INSERT INTO [AssociationCommentaire] VALUES (2, 3, 3, 38);
INSERT INTO [AssociationCommentaire] VALUES (2, 4, 3, 39);
INSERT INTO [AssociationCommentaire] VALUES (2, 5, 3, 40);
INSERT INTO [AssociationCommentaire] VALUES (2, 6, 3, 41);
INSERT INTO [AssociationCommentaire] VALUES (2, 7, 3, 42);