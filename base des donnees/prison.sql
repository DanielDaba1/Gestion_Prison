-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : mer. 04 oct. 2023 à 09:25
-- Version du serveur : 8.0.31
-- Version de PHP : 8.0.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `prison`
--

-- --------------------------------------------------------

--
-- Structure de la table `agentpenitentiaire`
--

DROP TABLE IF EXISTS `agentpenitentiaire`;
CREATE TABLE IF NOT EXISTS `agentpenitentiaire` (
  `ID_AgentPenitentiaire` int NOT NULL AUTO_INCREMENT,
  `Nom` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Prenom` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Grade` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Matricule` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`ID_AgentPenitentiaire`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `agentpenitentiaire`
--

INSERT INTO `agentpenitentiaire` (`ID_AgentPenitentiaire`, `Nom`, `Prenom`, `Grade`, `Matricule`) VALUES
(1, 'KIBAMBE', 'NATHAN', 'COLONEL', 'COL1234'),
(2, 'DANIEL', 'DIEUMERCIE', 'COMMANDANT', 'COM1234'),
(3, 'MUSURURU', 'DAVID', 'COLONEL', 'COL1245'),
(5, 'MARTIN', 'SHABANI', 'GENERAL', 'GEN2023');

-- --------------------------------------------------------

--
-- Structure de la table `batiment`
--

DROP TABLE IF EXISTS `batiment`;
CREATE TABLE IF NOT EXISTS `batiment` (
  `ID_Batiment` int NOT NULL AUTO_INCREMENT,
  `Designation` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `NombreCellule` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Date_de_construction` date DEFAULT NULL,
  PRIMARY KEY (`ID_Batiment`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `batiment`
--

INSERT INTO `batiment` (`ID_Batiment`, `Designation`, `NombreCellule`, `Date_de_construction`) VALUES
(1, 'Bloc Nath', '5 Cellules', '2023-09-24'),
(2, 'Bloc Daniel', '10 Cellules', '2023-09-24'),
(3, 'Bloc David', '6 Cellules', '2023-09-24'),
(4, 'Bloc Josa', '4 Cellules', '2023-09-25'),
(5, 'locRomeo', '10 Cellules', '2023-09-26');

-- --------------------------------------------------------

--
-- Structure de la table `cellule`
--

DROP TABLE IF EXISTS `cellule`;
CREATE TABLE IF NOT EXISTS `cellule` (
  `ID_Cellule` int NOT NULL AUTO_INCREMENT,
  `Designation` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `CapaciteMaximale` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `ID_Batiment` int DEFAULT NULL,
  PRIMARY KEY (`ID_Cellule`),
  KEY `cellule_ibfk_1` (`ID_Batiment`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `cellule`
--

INSERT INTO `cellule` (`ID_Cellule`, `Designation`, `CapaciteMaximale`, `ID_Batiment`) VALUES
(1, 'NATH A', '20 personnes', 1),
(2, 'DANA', '50 personnes', 2),
(4, 'DAN B', '10 Personnes', 2),
(5, 'NATH C', '10 PERSONNES', 1);

-- --------------------------------------------------------

--
-- Structure de la table `condamnation`
--

DROP TABLE IF EXISTS `condamnation`;
CREATE TABLE IF NOT EXISTS `condamnation` (
  `ID_Condamnation` int NOT NULL AUTO_INCREMENT,
  `Infraction` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `CategorieInfraction` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `SanctionAssociee` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `ID_Prisonnier` int DEFAULT NULL,
  PRIMARY KEY (`ID_Condamnation`),
  KEY `ID_Prisonnier` (`ID_Prisonnier`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `prisonnier`
--

DROP TABLE IF EXISTS `prisonnier`;
CREATE TABLE IF NOT EXISTS `prisonnier` (
  `ID_Prisonnier` int NOT NULL AUTO_INCREMENT,
  `RE` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Nom` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Prenom` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `DateNaissance` date DEFAULT NULL,
  `LieuNaissance` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `DateEntreePrison` date DEFAULT NULL,
  `DateSortiePrevue` date DEFAULT NULL,
  `MotifIncarceration` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Etat` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Profession` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `ID_Cellule` int DEFAULT NULL,
  `ID_AgentPenitentiaire` int DEFAULT NULL,
  `genre` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `origine` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`ID_Prisonnier`),
  KEY `ID_Cellule` (`ID_Cellule`),
  KEY `ID_AgentPenitentiaire` (`ID_AgentPenitentiaire`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `prisonnier`
--

INSERT INTO `prisonnier` (`ID_Prisonnier`, `RE`, `Nom`, `Prenom`, `DateNaissance`, `LieuNaissance`, `DateEntreePrison`, `DateSortiePrevue`, `MotifIncarceration`, `Etat`, `Profession`, `ID_Cellule`, `ID_AgentPenitentiaire`, `genre`, `origine`) VALUES
(1, 'RE/01/023', 'KATEMBO', 'Enock', '2000-06-17', 'Lubumbashi', '2023-09-23', '2030-07-23', NULL, 'Celibataire', 'Etudiant', 1, 1, 'Masculin', 'Katanga'),
(2, 'RE', 'ROGER', 'KYUAYANGA', '2005-09-03', '', '2023-09-27', '2027-09-09', 'VOLE', 'Celibataire', 'ETUDIANT', 2, 2, 'M', 'MANIEMA'),
(3, 'RE', 'NATHAN', 'KIBAMBE', '2000-09-21', 'KISANGANI', '2023-09-27', '2028-09-12', 'VOLE', 'Divorce', 'EDUTIANT', 4, 2, 'M', 'LOMAMI'),
(4, 'RE', 'KALY', 'LINSI', '1991-09-01', 'BIA', '2023-09-27', '2038-09-05', 'FRAUDE', 'Marie', 'COMMERCANT', 1, 3, 'F', 'RWANDA'),
(5, 'RE', 'KAMBALE', 'MBALASA', '1996-09-13', 'BENI', '2023-09-28', '2041-09-18', 'PIRATAGE', 'Veuve', 'ETUDIANT', 5, 3, 'M', 'BENI'),
(6, 'RE', 'DAN', 'DAN', '1996-09-07', 'BIA', '2023-09-28', '2023-09-30', 'VOL', 'Marie', 'ETUDIANT', 1, 1, 'M', 'BIA'),
(7, 'RE', 'JOSA', 'MBUMB', '2001-09-14', 'KIS', '2023-09-28', '2023-09-30', 'VOL', 'Celibataire', 'ETUDIANT', 1, 1, 'M', 'KIS'),
(8, 'RE', 'TRESOR', 'YUMA', '1997-09-12', 'GOMA', '2023-09-28', '2024-09-08', 'VOLE', 'CELEBATAIRE', 'ELEVE', 2, 2, 'M', 'NORD-KIVU'),
(9, 'RE', 'MILKA', 'KIAKIMWA', '2000-10-08', 'BENI', '2023-10-03', '2028-10-01', 'VOLE', 'CELEBATAIRE', 'ETUDIANTE', 1, 1, 'F', 'CONGOLAISE'),
(10, 'RE', 'AHADI', 'RONSARD', '1998-07-07', 'BUKAVU', '2023-10-04', '2023-10-28', 'ESCROQUERIE', 'CELEBATAIRE', 'ETUDIANT', 4, 3, 'M', 'BUKAVU'),
(11, 'RE', 'KAVIRA', 'VIRERE', '2003-10-10', 'BUTEMBO', '2023-10-04', '2034-10-12', 'VOLE', 'CELEBATAIRE', 'COMMERCANTE', 5, 3, 'F', 'CONGOLAISE');

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `fonction` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`id`, `nom`, `password`, `fonction`) VALUES
(1, 'NATHAN', '1234', 'COLONEL'),
(2, 'DANIEL', 'Daniel1234', 'Inspecteur'),
(3, 'DOCILE', 'Docile1234', 'colonel');

-- --------------------------------------------------------

--
-- Structure de la table `visiteur`
--

DROP TABLE IF EXISTS `visiteur`;
CREATE TABLE IF NOT EXISTS `visiteur` (
  `ID_Visiteur` int NOT NULL AUTO_INCREMENT,
  `Nom` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Prenom` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `RelationPrisonnier` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `DateVisite` date DEFAULT NULL,
  `DureeVisite` time DEFAULT NULL,
  `NumeroTel` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Adresse` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `ID_Prisonnier` int DEFAULT NULL,
  PRIMARY KEY (`ID_Visiteur`),
  KEY `ID_Prisonnier` (`ID_Prisonnier`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `visiteur`
--

INSERT INTO `visiteur` (`ID_Visiteur`, `Nom`, `Prenom`, `RelationPrisonnier`, `DateVisite`, `DureeVisite`, `NumeroTel`, `Adresse`, `ID_Prisonnier`) VALUES
(1, 'KITENGE', 'ALAIN', 'Oncle paternel', '2023-09-25', '00:00:02', '0812200333', 'Q.lumuba, AV.Boulevard02, n°04', 1),
(2, 'dan', 'dan', 'frere', '2023-09-26', '00:36:00', '7757575757', 'gfgfgfgf', 1),
(3, 'DANIEL', 'DABA', 'ONCLE', '2023-09-27', '00:00:01', '+243996787654', 'virunga', 2),
(4, 'DABA', 'DANIEL', 'CONLEGUE', '2023-09-28', '00:01:00', '+243825239225', 'Office2', 7),
(5, 'DOCILE', 'WAKOMYA', 'SOEUR', '2023-10-04', '00:01:20', '080000000', 'office', 11);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `cellule`
--
ALTER TABLE `cellule`
  ADD CONSTRAINT `cellule_ibfk_1` FOREIGN KEY (`ID_Batiment`) REFERENCES `batiment` (`ID_Batiment`);

--
-- Contraintes pour la table `condamnation`
--
ALTER TABLE `condamnation`
  ADD CONSTRAINT `condamnation_ibfk_1` FOREIGN KEY (`ID_Prisonnier`) REFERENCES `prisonnier` (`ID_Prisonnier`);

--
-- Contraintes pour la table `prisonnier`
--
ALTER TABLE `prisonnier`
  ADD CONSTRAINT `prisonnier_ibfk_1` FOREIGN KEY (`ID_Cellule`) REFERENCES `cellule` (`ID_Cellule`),
  ADD CONSTRAINT `prisonnier_ibfk_2` FOREIGN KEY (`ID_AgentPenitentiaire`) REFERENCES `agentpenitentiaire` (`ID_AgentPenitentiaire`);

--
-- Contraintes pour la table `visiteur`
--
ALTER TABLE `visiteur`
  ADD CONSTRAINT `visiteur_ibfk_1` FOREIGN KEY (`ID_Prisonnier`) REFERENCES `prisonnier` (`ID_Prisonnier`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
