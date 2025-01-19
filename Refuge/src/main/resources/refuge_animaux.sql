-- MySQL dump 10.13  Distrib 9.0.1, for macos14.7 (x86_64)
--
-- Host: localhost    Database: refuge_animaux
-- ------------------------------------------------------


CREATE DATABASE IF NOT EXISTS bd_refuge;
USE bd_refuge;

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- Créer un utilisateur 'user_refuge'
CREATE USER 'user_refuge'@'%' IDENTIFIED BY 'fg4HGTr85h28';

-- Accorder tous les privilèges uniquement sur la base de données 'db_refuge'
GRANT ALL PRIVILEGES ON bd_refuge.* TO 'user_refuge'@'%';

-- Appliquer les changements
FLUSH PRIVILEGES;
--
-- Table structure for table `animaux`
--
DROP TABLE IF EXISTS `animaux`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `animaux` (
  `identification` int NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) NOT NULL,
  `age_mois` int NOT NULL COMMENT 'Âge de l\'animal en mois',
  `espece` enum('chat','chien') NOT NULL,
  `sexe` enum('M','F') NOT NULL,
  `race` varchar(50) NOT NULL,
  `couleur` varchar(30) NOT NULL,
  `description` varchar(300) NOT NULL,
  `sterilise` tinyint(1) NOT NULL COMMENT '1 = stérilisé, 0 = non stérilisé',
  `vaccine` tinyint(1) NOT NULL COMMENT '1 = vacciné, 0 = non vacciné',
  PRIMARY KEY (`identification`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `animaux`
--

INSERT INTO `animaux` (`nom`, `age_mois`, `espece`, `sexe`, `race`, `couleur`, `description`, `sterilise`, `vaccine`) VALUES
('Luna', 34, 'chat', 'F', 'Siamois', 'beige', 'Luna est une chatte calme et affectueuse. Elle adore observer son environnement et se reposer dans des endroits chaleureux. Elle est idéale pour une vie paisible.', 1, 1),
('Milo', 22, 'chat', 'M', 'Persan', 'blanc', 'Milo est un chat joueur qui adore les jouets interactifs. Il aime également passer du temps à explorer de nouvelles cachettes et à faire des siestes confortables.', 1, 1),
('Felix', 67, 'chat', 'M', 'Européen', 'noir', 'Felix est très sociable et s''entend bien avec les autres animaux. Il aime être au centre de l''attention et cherche toujours des câlins et des caresses.', 1, 1),
('Nala', 11, 'chat', 'F', 'Maine Coon', 'roux', 'Nala est douce et joueuse. Elle adore chasser des jouets et se détendre près de la fenêtre pour profiter de la vue extérieure. Elle est parfaite pour une famille aimante.', 0, 1),
('Oscar', 41, 'chat', 'M', 'Bengale', 'tacheté', 'Oscar est un aventurier dans l''âme. Il aime explorer son environnement et découvrir de nouveaux recoins. C''est un compagnon idéal pour ceux qui aiment les chats dynamiques.', 1, 1),
('Lily', 27, 'chat', 'F', 'Ragdoll', 'blanc et gris', 'Lily est parfaite pour les familles. Elle est douce, calme et adore se blottir sur les genoux. Elle apporte une ambiance de sérénité et de bonheur partout où elle va.', 1, 1),
('Charlie', 82, 'chat', 'M', 'Européen', 'tigré', 'Charlie aime dormir près des fenêtres et profiter de la lumière du soleil. C''est un chat tranquille qui apprécie les moments de calme et les caresses légères.', 1, 1),
('Simba', 37, 'chat', 'M', 'Angora', 'blanc', 'Simba est énergique et curieux. Il aime jouer, courir après des jouets et explorer chaque coin de son environnement. Il est parfait pour une maison active.', 1, 1),
('Sophie', 9, 'chat', 'F', 'Européen', 'noir et blanc', 'Sophie est très douce avec les enfants. Elle adore interagir avec eux et se montre très patiente et affectueuse. Elle est idéale pour une famille avec des enfants.', 0, 1),
('Leo', 52, 'chat', 'M', 'Chartreux', 'gris', 'Leo est intelligent et observateur. Il aime analyser son environnement et apprend vite. Il apprécie les moments de calme et aime également jouer avec des jouets stimulants.', 1, 1),
('Mia', 3, 'chat', 'F', 'Sphynx', 'rose', 'Mia aime les câlins et les moments chaleureux avec ses humains. Elle recherche toujours de l''attention et adore être proche des gens. C''est une compagne adorable.', 1, 1),
('Rex', 41, 'chien', 'M', 'Berger Allemand', 'noir et feu', 'Rex est parfait pour la garde. Il est attentif, loyal et très protecteur envers sa famille. Il adore également les longues promenades et les jeux en plein air.', 1, 1),
('Maya', 21, 'chien', 'F', 'Golden Retriever', 'doré', 'Maya est très affectueuse et adore passer du temps avec sa famille. Elle est gentille avec les enfants et s''entend bien avec d''autres animaux. C''est une chienne très douce.', 1, 1),
('Rocky', 97, 'chien', 'M', 'Labrador', 'chocolat', 'Rocky est énergique et joueur. Il adore courir, nager et jouer à aller chercher. Il a besoin d''une famille active qui apprécie les jeux et les aventures en plein air.', 1, 1),
('Bella', 14, 'chien', 'F', 'Bouledogue Français', 'blanc et noir', 'Bella aime les enfants et est très protectrice envers eux. Elle est également calme et apprécie les siestes dans des endroits confortables. Elle est parfaite pour un foyer aimant.', 0, 1),
('Max', 34, 'chien', 'M', 'Husky Sibérien', 'gris et blanc', 'Max est athlétique et joueur. Il adore les longues promenades, courir dans la nature et jouer avec des jouets. Il est parfait pour une famille sportive.', 1, 1),
('Sun', 24, 'chat', 'F', 'Burmese', 'doré', 'Sun aime les rayons de soleil et se prélasser près des fenêtres. Elle est douce, calme et apporte une atmosphère paisible à son foyer.', 1, 1),
('Cooper', 46, 'chien', 'M', 'Berger Australien', 'merle', 'Cooper est intelligent et actif. Il adore les activités en plein air et est toujours prêt à apprendre de nouveaux tours. Il s''adapte bien aux foyers dynamiques.', 1, 1),
('Daisy', 36, 'chien', 'F', 'Border Collie', 'noir et blanc', 'Daisy est très obéissante et intelligente. Elle aime travailler, apprendre de nouveaux tours et passer du temps avec sa famille.', 1, 1),
('Alph', 34, 'chien', 'M', 'Malinois', 'brun clair', 'Alph est un chien de garde fiable et attentif. Il est très protecteur et s''entend bien avec sa famille. Il aime également les activités stimulantes.', 1, 1),
('Lucy', 17, 'chat', 'F', 'Européen', 'gris et blanc', 'Lucy aime les câlins et les moments calmes avec ses humains. Elle est affectueuse et apprécie la compagnie de personnes aimantes.', 1, 1),
('Duke', 55, 'chien', 'M', 'Rottweiler', 'noir et feu', 'Duke est protecteur et loyal. Il veille sur sa famille avec attention et adore les moments de jeu et d''entraînement. C''est un compagnon fidèle.', 1, 1);


-- Nouvelle table : Photos des animaux
DROP TABLE IF EXISTS `photos_animaux`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `photos_animaux` (
  `photo_id` int NOT NULL AUTO_INCREMENT,
  `identification` int NOT NULL COMMENT 'Référence à l\'animal',
  `photo_chemin` varchar(255) NOT NULL COMMENT 'Chemin ou URL de la photo',
  PRIMARY KEY (`photo_id`),
  FOREIGN KEY (`identification`) REFERENCES `animaux`(`identification`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;


-- Insérer des exemples de photos pour les animaux
INSERT INTO `photos_animaux` (`identification`, `photo_chemin`) VALUES
(1, 'photo_animaux/luna1.jpg'),
(1, 'photo_animaux/luna2.jpg'),
(1, 'photo_animaux/luna3.jpg'),
(2, 'photo_animaux/milo1.jpg'),
(2, 'photo_animaux/milo2.jpg'),
(2, 'photo_animaux/milo3.jpg'),
(3, 'photo_animaux/felix1.jpg'),
(3, 'photo_animaux/felix2.jpg'),
(3, 'photo_animaux/felix3.jpg'),
(4, 'photo_animaux/nala1.jpg'),
(4, 'photo_animaux/nala2.jpg'),
(4, 'photo_animaux/nala3.jpg'),
(5, 'photo_animaux/oscar1.jpg'),
(5, 'photo_animaux/oscar2.jpg'),
(5, 'photo_animaux/oscar3.jpg'),
(6, 'photo_animaux/lily1.jpg'),
(6, 'photo_animaux/lily2.jpg'),
(6, 'photo_animaux/lily3.jpg'),
(7, 'photo_animaux/charlie1.jpg'),
(7, 'photo_animaux/charlie2.jpg'),
(7, 'photo_animaux/charlie3.jpg'),
(8, 'photo_animaux/simba1.jpg'),
(8, 'photo_animaux/simba2.jpg'),
(8, 'photo_animaux/simba3.jpg'),
(9, 'photo_animaux/sophie1.jpg'),
(9, 'photo_animaux/sophie2.jpg'),
(9, 'photo_animaux/sophie3.jpg'),
(10, 'photo_animaux/leo1.jpg'),
(10, 'photo_animaux/leo2.jpg'),
(10, 'photo_animaux/leo3.jpg'),
(11, 'photo_animaux/mia1.jpg'),
(11, 'photo_animaux/mia2.jpg'),
(11, 'photo_animaux/mia3.jpg'),
(12, 'photo_animaux/rex1.jpg'),
(12, 'photo_animaux/rex2.jpg'),
(12, 'photo_animaux/rex3.jpg'),
(13, 'photo_animaux/maya1.jpg'),
(13, 'photo_animaux/maya2.jpg'),
(13, 'photo_animaux/maya3.jpg'),
(14, 'photo_animaux/rocky1.jpg'),
(14, 'photo_animaux/rocky2.jpg'),
(14, 'photo_animaux/rocky3.jpg'),
(15, 'photo_animaux/bella1.jpg'),
(15, 'photo_animaux/bella2.jpg'),
(15, 'photo_animaux/bella3.jpg'),
(16, 'photo_animaux/max1.jpg'),
(16, 'photo_animaux/max2.jpg'),
(16, 'photo_animaux/max3.jpg'),
(17, 'photo_animaux/sun1.jpg'),
(17, 'photo_animaux/sun2.jpg'),
(17, 'photo_animaux/sun3.jpg'),
(18, 'photo_animaux/cooper1.jpg'),
(18, 'photo_animaux/cooper2.jpg'),
(18, 'photo_animaux/cooper3.jpg'),
(19, 'photo_animaux/daisy1.jpg'),
(19, 'photo_animaux/daisy2.jpg'),
(19, 'photo_animaux/daisy3.jpg'),
(20, 'photo_animaux/alph1.jpg'),
(20, 'photo_animaux/alph2.jpg'),
(20, 'photo_animaux/alph3.jpg'),
(21, 'photo_animaux/lucy1.jpg'),
(21, 'photo_animaux/lucy2.jpg'),
(21, 'photo_animaux/lucy3.jpg'),
(22, 'photo_animaux/duke1.jpg'),
(22, 'photo_animaux/duke2.jpg'),
(22, 'photo_animaux/duke3.jpg');

--
-- Table structure for table `employe`
--

DROP TABLE IF EXISTS `employe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employe` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `sexe` enum('M','F','Autre') NOT NULL,
  `date_naissance` date NOT NULL,
  `courriel` varchar(100) NOT NULL,
  `cellulaire` varchar(15) DEFAULT NULL,
  `departement` varchar(50) NOT NULL,
  `categorie` varchar(50) NOT NULL,
  `date_creation` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `date_modification` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `courriel` (`courriel`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employe`
--

INSERT INTO `employe` (`nom`, `prenom`, `sexe`, `date_naissance`, `courriel`, `cellulaire`, `departement`, `categorie`) VALUES
('Dubois', 'Marie', 'F', '1985-06-15', 'marie.dubois@refuge-animaux.com', '514-555-1234', 'Soins Vétérinaires', 'Vétérinaire Chef'),
('Martin', 'Thomas', 'M', '1990-03-22', 'thomas.martin@refuge-animaux.com', '514-555-2345', 'Soins Quotidiens', 'Soigneur Animalier'),
('Bernard', 'Sophie', 'F', '1988-11-30', 'sophie.bernard@refuge-animaux.com', '514-555-3456', 'Administration', 'Responsable Administrative'),
('Dubois', 'Emma', 'F', '1987-12-18', 'emma.dubois@refuge-animaux.com', '514-555-5678', 'Accueil', 'Conseillère Adoption'),
('Michel', 'Alexandre', 'M', '1993-01-20', 'alexandre.michel@refuge-animaux.com', '514-555-0123', 'Soins Quotidiens', 'Soigneur Animalier'),
('Garcia', 'David', 'M', '1988-08-30', 'david.garcia@refuge-animaux.com', '514-555-2345', 'Soins Quotidiens', 'Responsable Chatterie'),
('Roux', 'Clara', 'F', '1990-11-25', 'clara.roux@refuge-animaux.com', '514-555-3456', 'Communication', 'Photographe Animalier'),
('Fournier', 'Marc', 'M', '1986-07-14', 'marc.fournier@refuge-animaux.com', '514-555-4567', 'Transport', 'Chauffeur-Secouriste');

--
-- Table connexion
--

DROP TABLE IF EXISTS `connexion`;
CREATE TABLE `connexion` (
  `ide` int NOT NULL COMMENT 'Référence à l\'employé',
  `courriel` varchar(100) NOT NULL UNIQUE COMMENT 'Courriel pour la connexion',
  `mot_de_passe` varchar(255) NOT NULL COMMENT 'Mot de passe sécurisé',
  `statut` enum('A', 'I') NOT NULL DEFAULT 'A' COMMENT 'A pour Actif, I pour Inactif',
  `role` varchar(50) NOT NULL COMMENT 'Rôle de l\'employé (ex: Administrateur, Employé)',
  PRIMARY KEY (`ide`),
  FOREIGN KEY (`ide`) REFERENCES `employe`(`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `connexion`
--

INSERT INTO `connexion` (`ide`, `courriel`, `mot_de_passe`, `statut`, `role`) VALUES
(1, 'marie.dubois@refuge-animaux.com', 'hashed_password_1', 'A', 'Administrateur'),
(2, 'thomas.martin@refuge-animaux.com', 'hashed_password_2', 'A', 'Employé'),
(3, 'sophie.bernard@refuge-animaux.com', 'hashed_password_3', 'A', 'Responsable Administrative'),
(4, 'emma.dubois@refuge-animaux.com', 'hashed_password_4', 'A', 'Conseillère Adoption'),
(5, 'alexandre.michel@refuge-animaux.com', 'hashed_password_5', 'A', 'Soigneur Animalier'),
(6, 'david.garcia@refuge-animaux.com', 'hashed_password_6', 'A', 'Responsable Chatterie'),
(7, 'clara.roux@refuge-animaux.com', 'hashed_password_7', 'A', 'Photographe Animalier'),
(8, 'marc.fournier@refuge-animaux.com', 'hashed_password_8', 'A', 'Chauffeur-Secouriste');