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
('Luna', 36, 'chat', 'F', 'Siamois', 'beige', 'Calme et affectueuse', 1, 1),
('Milo', 24, 'chat', 'M', 'Persan', 'blanc', 'Aime jouer avec des jouets', 1, 1),
('Felix', 60, 'chat', 'M', 'Européen', 'noir', 'Très sociable', 1, 1),
('Nala', 12, 'chat', 'F', 'Maine Coon', 'roux', 'Douce et joueuse', 0, 1),
('Oscar', 48, 'chat', 'M', 'Bengale', 'tacheté', 'Aime explorer', 1, 1),
('Lily', 24, 'chat', 'F', 'Ragdoll', 'blanc et gris', 'Parfaite pour les familles', 1, 1),
('Charlie', 72, 'chat', 'M', 'Européen', 'tigré', 'Aime dormir près des fenêtres', 1, 1),
('Simba', 36, 'chat', 'M', 'Angora', 'roux', 'Énergique et curieux', 1, 1),
('Sophie', 12, 'chat', 'F', 'Européen', 'noir et blanc', 'Très douce avec les enfants', 0, 1),
('Leo', 48, 'chat', 'M', 'Chartreux', 'gris', 'Intelligent et observateur', 1, 1),
('Mia', 24, 'chat', 'F', 'Sphynx', 'rose', 'Aime les câlins', 1, 1),
('Rex', 48, 'chien', 'M', 'Berger Allemand', 'noir et feu', 'Parfait pour la garde', 1, 1),
('Maya', 24, 'chien', 'F', 'Golden Retriever', 'doré', 'Très affectueuse', 1, 1),
('Rocky', 72, 'chien', 'M', 'Labrador', 'chocolat', 'Énergique et joueur', 1, 1),
('Bella', 12, 'chien', 'F', 'Bouledogue Français', 'fauve', 'Aime les enfants', 0, 1),
('Max', 36, 'chien', 'M', 'Husky Sibérien', 'gris et blanc', 'Athlétique et joueur', 1, 1),
('Sun', 24, 'chat', 'F', 'Burmese', 'doré', 'Aime les rayons de soleil', 1, 1),
('Cooper', 48, 'chien', 'M', 'Berger Australien', 'merle', 'Intelligent et actif', 1, 1),
('Daisy', 36, 'chien', 'F', 'Border Collie', 'noir et blanc', 'Très obéissante', 1, 1),
('Alph', 72, 'chien', 'M', 'Malinois', 'brun clair', 'Chien de garde fiable', 1, 1),
('Lucy', 12, 'chat', 'F', 'Européen', 'gris et blanc', 'Aime les câlins', 1, 1),
('Duke', 60, 'chien', 'M', 'Rottweiler', 'noir et feu', 'Protecteur et loyal', 1, 1);

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
(1, 'resources/photo_animaux/luna1.jpg'),
(1, 'resources/photo_animaux/luna2.jpg'),
(1, 'resources/photo_animaux/luna3.jpg'),
(2, 'resources/photo_animaux/milo1.jpg'),
(2, 'resources/photo_animaux/milo2.jpg'),
(2, 'resources/photo_animaux/milo3.jpg'),
(3, 'resources/photo_animaux/felix1.jpg'),
(3, 'resources/photo_animaux/felix2.jpg'),
(3, 'resources/photo_animaux/felix3.jpg'),
(4, 'resources/photo_animaux/nala1.jpg'),
(4, 'resources/photo_animaux/nala2.jpg'),
(4, 'resources/photo_animaux/nala3.jpg'),
(5, 'resources/photo_animaux/oscar1.jpg'),
(5, 'resources/photo_animaux/oscar2.jpg'),
(5, 'resources/photo_animaux/oscar3.jpg'),
(6, 'resources/photo_animaux/lily1.jpg'),
(6, 'resources/photo_animaux/lily2.jpg'),
(6, 'resources/photo_animaux/lily3.jpg'),
(7, 'resources/photo_animaux/charlie1.jpg'),
(7, 'resources/photo_animaux/charlie2.jpg'),
(7, 'resources/photo_animaux/charlie3.jpg'),
(8, 'resources/photo_animaux/simba1.jpg'),
(8, 'resources/photo_animaux/simba2.jpg'),
(8, 'resources/photo_animaux/simba3.jpg'),
(9, 'resources/photo_animaux/sophie1.jpg'),
(9, 'resources/photo_animaux/sophie2.jpg'),
(9, 'resources/photo_animaux/sophie3.jpg'),
(10, 'resources/photo_animaux/leo1.jpg'),
(10, 'resources/photo_animaux/leo2.jpg'),
(10, 'resources/photo_animaux/leo3.jpg'),
(11, 'resources/photo_animaux/mia1.jpg'),
(11, 'resources/photo_animaux/mia2.jpg'),
(11, 'resources/photo_animaux/mia3.jpg'),
(12, 'resources/photo_animaux/rex1.jpg'),
(12, 'resources/photo_animaux/rex2.jpg'),
(12, 'resources/photo_animaux/rex3.jpg'),
(13, 'resources/photo_animaux/maya1.jpg'),
(13, 'resources/photo_animaux/maya2.jpg'),
(13, 'resources/photo_animaux/maya3.jpg'),
(14, 'resources/photo_animaux/rocky1.jpg'),
(14, 'resources/photo_animaux/rocky2.jpg'),
(14, 'resources/photo_animaux/rocky3.jpg'),
(15, 'resources/photo_animaux/bella1.jpg'),
(15, 'resources/photo_animaux/bella2.jpg'),
(15, 'resources/photo_animaux/bella3.jpg'),
(16, 'resources/photo_animaux/max1.jpg'),
(16, 'resources/photo_animaux/max2.jpg'),
(16, 'resources/photo_animaux/max3.jpg'),
(17, 'resources/photo_animaux/sun1.jpg'),
(17, 'resources/photo_animaux/sun2.jpg'),
(17, 'resources/photo_animaux/sun3.jpg'),
(18, 'resources/photo_animaux/cooper1.jpg'),
(18, 'resources/photo_animaux/cooper2.jpg'),
(18, 'resources/photo_animaux/cooper3.jpg'),
(19, 'resources/photo_animaux/daisy1.jpg'),
(19, 'resources/photo_animaux/daisy2.jpg'),
(19, 'resources/photo_animaux/daisy3.jpg'),
(20, 'resources/photo_animaux/alph1.jpg'),
(20, 'resources/photo_animaux/alph2.jpg'),
(20, 'resources/photo_animaux/alph3.jpg'),
(21, 'resources/photo_animaux/lucy1.jpg'),
(21, 'resources/photo_animaux/lucy2.jpg'),
(21, 'resources/photo_animaux/lucy3.jpg'),
(22, 'resources/photo_animaux/duke1.jpg'),
(22, 'resources/photo_animaux/duke2.jpg'),
(22, 'resources/photo_animaux/duke3.jpg');

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
('Petit', 'Lucas', 'M', '1992-09-05', 'lucas.petit@refuge-animaux.com', '514-555-4567', 'Comportement Animal', 'Comportementaliste'),
('Dubois', 'Emma', 'F', '1987-12-18', 'emma.dubois@refuge-animaux.com', '514-555-5678', 'Accueil', 'Conseillère Adoption'),
('Moreau', 'Paul', 'M', '1983-04-25', 'paul.moreau@refuge-animaux.com', '514-555-6789', 'Maintenance', 'Agent d\'Entretien'),
('Robert', 'Julie', 'F', '1991-07-08', 'julie.robert@refuge-animaux.com', '514-555-7890', 'Soins Vétérinaires', 'Assistante Vétérinaire'),
('Simon', 'Antoine', 'M', '1986-02-14', 'antoine.simon@refuge-animaux.com', '514-555-8901', 'Communication', 'Responsable Communication'),
('Laurent', 'Céline', 'F', '1989-10-27', 'celine.laurent@refuge-animaux.com', '514-555-9012', 'Accueil', 'Agent d\'Accueil'),
('Michel', 'Alexandre', 'M', '1993-01-20', 'alexandre.michel@refuge-animaux.com', '514-555-0123', 'Soins Quotidiens', 'Soigneur Animalier'),
('Leroy', 'Sarah', 'F', '1994-05-12', 'sarah.leroy@refuge-animaux.com', '514-555-1234', 'Comportement Animal', 'Éducatrice Canine'),
('Garcia', 'David', 'M', '1988-08-30', 'david.garcia@refuge-animaux.com', '514-555-2345', 'Soins Quotidiens', 'Responsable Chatterie'),
('Roux', 'Clara', 'F', '1990-11-25', 'clara.roux@refuge-animaux.com', '514-555-3456', 'Communication', 'Photographe Animalier'),
('Fournier', 'Marc', 'M', '1986-07-14', 'marc.fournier@refuge-animaux.com', '514-555-4567', 'Transport', 'Chauffeur-Secouriste'),
('Bonnet', 'Lucie', 'F', '1992-03-08', 'lucie.bonnet@refuge-animaux.com', '514-555-5678', 'Soins Vétérinaires', 'Infirmière Animalière');
