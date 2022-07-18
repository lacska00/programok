CREATE TABLE myBets (
  fullID varchar(8) NOT NULL,
  bet varchar(2) NOT NULL,
  CONSTRAINT pk_myBets PRIMARY KEY (fullID)
);
CREATE TABLE myBets2 (
  fullID varchar(8) NOT NULL,
  bet varchar(2) NOT NULL,
  CONSTRAINT pk_myBets PRIMARY KEY (fullID)
);

CREATE TABLE football (
  id int NOT NULL,
  liga varchar(30) NOT NULL,
  hazaiCsapat varchar(30) NOT NULL,
  vendegCsapat varchar(30) NOT NULL,
  hazaiOdds FLOAT(4,2) NOT NULL,
  dontetlenOdds FLOAT(4,2) NOT NULL,
  vendegOdds FLOAT(4,2) NOT NULL,
  fullID varchar(8) NOT NULL,
  CONSTRAINT pk_football PRIMARY KEY (id)
);

CREATE TABLE kosarLabda (
  id int NOT NULL,
  liga varchar(30) NOT NULL,
  hazaiCsapat varchar(30) NOT NULL,
  vendegCsapat varchar(30) NOT NULL,
  hazaiOdds FLOAT(4,2) NOT NULL,
  vendegOdds FLOAT(4,2) NOT NULL,
  fullID varchar(8) NOT NULL,
  CONSTRAINT pk_kosarLabda PRIMARY KEY (id)
);

CREATE TABLE keziLabda (
  id int NOT NULL,
  liga varchar(30) NOT NULL,
  hazaiCsapat varchar(30) NOT NULL,
  vendegCsapat varchar(30) NOT NULL,
  hazaiOdds FLOAT(4,2) NOT NULL,
  dontetlenOdds FLOAT(4,2) NOT NULL,
  vendegOdds FLOAT(4,2) NOT NULL,
  fullID varchar(8) NOT NULL,
  CONSTRAINT pk_keziLabda PRIMARY KEY (id)
);

CREATE TABLE jegKorong (
  id int NOT NULL,
  liga varchar(30) NOT NULL,
  hazaiCsapat varchar(30) NOT NULL,
  vendegCsapat varchar(30) NOT NULL,
  hazaiOdds FLOAT(4,2) NOT NULL,
  dontetlenOdds FLOAT(4,2) NOT NULL,
  vendegOdds FLOAT(4,2) NOT NULL,
  fullID varchar(8) NOT NULL,
  CONSTRAINT pk_jegKorong PRIMARY KEY (id)
);

CREATE TABLE viziLabda (
  id int NOT NULL,
  liga varchar(30) NOT NULL,
  hazaiCsapat varchar(30) NOT NULL,
  vendegCsapat varchar(30) NOT NULL,
  hazaiOdds FLOAT(4,2) NOT NULL,
  dontetlenOdds FLOAT(4,2) NOT NULL,
  vendegOdds FLOAT(4,2) NOT NULL,
  fullID varchar(8) NOT NULL,
  CONSTRAINT pk_viziLabda PRIMARY KEY (id)
);

CREATE TABLE account (
  teljesnev varchar(40) NOT NULL,
  felhnev varchar(30) NOT NULL,
  jelszo varchar(40) NOT NULL,
  CONSTRAINT pk_account PRIMARY KEY (felhnev)
);

CREATE TABLE meccsId (
  fullID varchar(8) NOT NULL,
  CONSTRAINT pk_account PRIMARY KEY (fullID)
);

CREATE TABLE aktualis (
  id int NOT NULL,
  liga varchar(30) NOT NULL,
  hazaiCsapat varchar(30) NOT NULL,
  vendegCsapat varchar(30) NOT NULL,
  hazaiOdds FLOAT(4,2) NOT NULL,
  dontetlenOdds FLOAT(4,2) NOT NULL,
  vendegOdds FLOAT(4,2) NOT NULL,
  fullID varchar(8) NOT NULL,
  CONSTRAINT pk_aktualis PRIMARY KEY (id)
);

CREATE TABLE aktualisId (
  id int NOT NULL,
  CONSTRAINT pk_aktualis PRIMARY KEY (id)
);

CREATE TABLE aktualisFelh (
  felhnev varchar(30) NOT NULL,
  CONSTRAINT pk_aktualis PRIMARY KEY (felhnev)
);


CREATE TABLE history (
  id int NOT NULL,
  felhnev varchar(30) NOT NULL,
  meccsek varchar(30) NOT NULL,
  tippek varchar(30) NOT NULL,
  tet int NOT NULL,
  odds FLOAT(4,2) NOT NULL,
  meccsSzam int NOT NULL,
  CONSTRAINT pk_aktualis PRIMARY KEY (id)
);

CREATE TABLE aktualisOdds (
  odds FLOAT(5,2) NOT NULL,
  CONSTRAINT pk_aktualis PRIMARY KEY (odds)
);






INSERT INTO football VALUES
(1, 'ANGLIA: Premier League', 'Manchester City', 'Leeds', 1.33, 5.50, 8.00, 'F1'),
(2, 'ANGLIA: Premier League', 'Liverpool', 'Aston Villa', 1.50, 4.33, 6.50, 'F2'),
(3, 'ANGLIA: Premier League', 'Crystal Palace', 'Chelsea', 7.50, 4.33, 1.44, 'F3'),
(4, 'FRANCIAORSZÁG: Ligue 1', 'Strasbourg', 'PSG', 5.00, 4.00, 1.60, 'F4'),
(5, 'FRANCIAORSZÁG: Ligue 1', 'Montpellier', 'Olympique de Marseille', 2.60, 3.40, 2.60, 'F5'),
(6, 'MAGYARORSZÁG: OTP Bank Liga', 'MTK Budapest', 'Budafok', 1.70, 3.60, 5.25, 'F6'),
(7, 'MAGYARORSZÁG: OTP Bank Liga', 'MOL Fehérvár FC', 'Újpest', 1.53, 4.00, 5.50, 'F7'),
(8, 'MAGYARORSZÁG: OTP Bank Liga', 'Ferencvárosi TC', 'Puskás Akadémia', 1.60, 4.00, 5.00, 'F8'),
(9, 'NÉMETORSZÁG: Bundesliga', 'Bayern München', 'Union Berlin', 1.60, 4.20, 5.25, 'F9'),
(10, 'NÉMETORSZÁG: Bundesliga', 'Frankfurt', 'Wolfsburg', 2.30, 3.50, 3.00, 'F10'),
(11, 'NÉMETORSZÁG: Bundesliga', 'Werder Bremen', 'RB Leipzig', 3.10, 5.00, 1.36, 'F11'),
(12, 'NÉMETORSZÁG: Bundesliga', 'VfB Stuttgart', 'Borussia Dortmund', 3.75, 4.00, 1.85, 'F12'),
(13, 'OLASZORSZÁG: Serie A', 'Spezia', 'Crotone', 1.72, 4.00, 4.33, 'F13'),
(14, 'OLASZORSZÁG: Serie A', 'Parma', 'AC Milan', 5.25, 3.90, 1.65, 'F14'),
(15, 'OLASZORSZÁG: Serie A', 'Udinese', 'Torino', 2.30, 3.30, 3.10, 'F18'),
(16, 'SPANYOLORSZÁG: LaLiga', 'Getafe', 'Cadiz', 1.85, 3.10, 5.00, 'F16'),
(17, 'SPANYOLORSZÁG: LaLiga', 'Real Madrid', 'FC Barcelona', 2.80, 3.80, 2.30, 'F17'),
(18, 'AFRIKA: CAF Bajnokok Ligája', 'Esperance Tunis (Tun)', 'MC Alger (Alg)', 2.15, 2.37, 4.75, 'F18'),
(19, 'AFRIKA: CAF Bajnokok Ligája', 'Zamalek (Egy)', 'Teungueth (Sen)', 1.18, 6.50, 11.00, 'F19');

INSERT INTO kosarLabda VALUES
(1, 'FRANCIAORSZÁG: LNB', 'Le Portel', 'Gravelines-Dunkerque', 2.70, 1.50, 'K1'),
(2, 'FRANCIAORSZÁG: LNB', 'Dijon', 'Boulazac', 1.08, 8.50, 'K2'),
(3, 'FRANCIAORSZÁG: LNB', 'Pau-Orthez', 'Strasbourg', 3.00, 1.41, 'K3'),
(4, 'OLASZORSZÁG: Lega A', 'Fortitudo Bologna', 'Pesaro', 3.00, 1.41, 'K4'),
(5, 'SPANYOLORSZÁG: ACB', 'Gipuzkoa', 'Real Betis', 2.50, 1.58, 'K5'),
(6, 'SPANYOLORSZÁG: ACB', 'Obradoiro CAB', 'Manresa', 2.35, 1.64, 'K6'),
(7, 'SPANYOLORSZÁG: ACB', 'Unicaja Malaga', 'MoraBanc Andorra', 1.29, 3.70, 'K7'),
(8, 'TÖRÖKORSZÁG: Super Ligi', 'Bahcesehir Kol.', 'Fethiye Bld.', 1.26, 3.65, 'K8'),
(9, 'TÖRÖKORSZÁG: Super Ligi', 'Pinar Karsiyaka', 'Galatasaray', 1.21, 4.25, 'K9'),
(10, 'USA: NBA', 'Orlando Magic', 'Indiana Pacers', 3.15, 1.38, 'K10'),
(11, 'USA: NBA', 'Atlanta Hawks', 'Chicago Bulls', 1.68, 2.25, 'K11'),
(12, 'USA: NBA', 'Milwaukee Bucks', 'Charlotte Hornets', 2.30, 1.66, 'K12'),
(13, 'USA: NBA', 'Los Angeles Clippers', 'Houston Rockets', 1.14, 6.00, 'K13');

INSERT INTO keziLabda VALUES
(1, 'FRANCIAORSZÁG: Lidl Starligue', 'Toulouse', 'Nantes', 4.25, 9.00, 1.40, 'H1'),
(2, 'FRANCIAORSZÁG: Lidl Starligue', 'Cesson', 'Chartres', 1.87, 8.50, 2.40, 'H2'),
(3, 'FRANCIAORSZÁG: Lidl Starligue', 'Montpellier', 'Istres', 1.08, 16.00, 10.00, 'H3'),
(4, 'FRANCIAORSZÁG: Lidl Starligue', 'Chambery Savoie', 'Creteil', 1.32, 10.50, 4.60, 'H4'),
(5, 'MAGYARORSZÁG: NB I', 'Komló', 'Dabas', 1.42, 8.00, 3.50, 'H5'),
(6, 'MAGYARORSZÁG: NB I', 'Tatabánya', 'Cegléd', 1.01, 18.00, 15.00, 'H6'),
(7, 'NÉMETORSZÁG: Bundesliga', 'Hannover-Burgdorf', 'Kiel', 8.50, 13.00, 1.16, 'H7'),
(8, 'SPANYOLORSZÁG: Liga ASOBAL', 'BM Sinfin', 'Morrazo Cangas', 1.70, 8.00, 2.90, 'H8'),
(9, 'SPANYOLORSZÁG: Liga ASOBAL', 'Cuenca', 'Huesca', 1.70, 8.00, 2.80, 'H9'),
(10, 'SPANYOLORSZÁG: Liga ASOBAL', 'Ademar', 'Puerto Sagunto', 1.12, 15.00, 10.00, 'H10'),
(11, 'AUSZTRIA: HLA - Felsőház', 'Alpla HC Hard', 'West Wien', 1.35, 8.50, 4.00, 'H11');


INSERT INTO jegKorong VALUES
(1, 'FINNORSZÁG: Liiga', 'Kärpät Oulu', 'JYP', 1.40, 5.25, 6.50, 'J1'),
(2, 'FINNORSZÁG: Liiga', 'KooKoo', 'SaiPa', 1.36, 5.25, 7.00, 'J2'),
(3, 'FINNORSZÁG: Liiga', 'Ässät Pori', 'Lukko Rauma', 3.80, 4.50, 1.71, 'J3'),
(4, 'OROSZORSZÁG: KHL - Play Off', 'CSZKA Moszkva', 'SZKA Szentpétervár', 1.83, 3.85, 3.80, 'J4'),
(5, 'USA: NHL', 'Buffalo Sabres', 'Washington Capitals', 4.50, 5.00, 1.55, 'J5'),
(6, 'USA: NHL', 'New York Islanders', 'New York Rangers', 2.10, 4.00, 3.00, 'J6'),
(7, 'USA: NHL', 'Anaheim Ducks', 'Colorado Avalanche', 2.25, 5.50, 1.44, 'J7'),
(8, 'USA: NHL', 'Dallas Stars', 'Florida Panthers', 2.40, 4.25, 2.40, 'J8'),
(9, 'EGYESÜLT KIRÁLYSÁG: Elite League', 'Sheffield', 'Nottingham', 1.95, 4.65, 2.70, 'J9'),
(10, 'FRANCIAORSZÁG: D1', 'Neuilly Sur Marne', 'Nantes', 3.00, 4.75, 1.80, 'J10'),
(11, 'FRANCIAORSZÁG: D1', 'Strasbourg', 'Chambery', 2.00, 4.15, 2.80, 'J11');


INSERT INTO viziLabda VALUES
(1, 'MAGYARORSZÁG: OB I', 'Miskolc', 'Kaposvár', 1.22, 9.00, 5.50, 'W1'),
(2, 'MAGYARORSZÁG: OB I', 'BVSC-Zugló', 'Vasas', 1.90, 6.00, 2.37, 'W2'),
(3, 'MAGYARORSZÁG: OB I', 'Szentes', 'Szeged', 1.83, 6.50, 2.60, 'W3'),
(4, 'EURÓPA: Euro Cup', 'Vouliagmeni', 'OSC Budapest', 1.40, 7.00, 1.83, 'W4'),
(5, 'EURÓPA: Euro Cup', 'Szolnok', 'Crvena zvezda', 1.01, 17.00, 17.00, 'W5'),
(6, 'GÖRÖGORSZÁG: A1', 'Panioniosz', 'Ethnikos', 1.16, 9.00, 7.50, 'W6'),
(7, 'GÖRÖGORSZÁG: A1', 'AEK Athén', 'Peristerio', 9.50, 10.00, 1.11, 'W7');


INSERT INTO account VALUES
('Pelda Janos', 'Neymi', 'qwe123'),
('Elso Peter', 'Laci', 'jelszo'),
('Teszt Elemer', 'User', '123asd'),
('Negyedik Valaki', 'aaaa', 'aaaa');