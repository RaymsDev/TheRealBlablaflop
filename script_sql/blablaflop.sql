-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: db
-- Generation Time: Apr 05, 2018 at 02:52 PM
-- Server version: 5.7.21
-- PHP Version: 7.2.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `blablaflop`
--
CREATE DATABASE IF NOT EXISTS `blablaflop` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `blablaflop`;

-- --------------------------------------------------------

--
-- Table structure for table `passenger`
--

DROP TABLE IF EXISTS `passenger`;
CREATE TABLE `passenger` (
  `id_ride` int(11) NOT NULL,
  `id_user` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `ride`
--

DROP TABLE IF EXISTS `ride`;
CREATE TABLE `ride` (
  `id` int(11) NOT NULL,
  `id_driver` int(11) NOT NULL,
  `google_ride` longtext NOT NULL,
  `isSmokerAllowed` int(1) NOT NULL DEFAULT '0',
  `isMusicAllowed` int(1) NOT NULL DEFAULT '0',
  `isChildsAllowed` int(1) NOT NULL DEFAULT '0',
  `conversationLevel` int(11) NOT NULL,
  `startDate` date NOT NULL,
  `startTime` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `ride`
--

INSERT INTO `ride` (`id`, `id_driver`, `google_ride`, `isSmokerAllowed`, `isMusicAllowed`, `isChildsAllowed`, `conversationLevel`, `startDate`, `startTime`) VALUES
(1, 1, '', 0, 0, 0, 2, '2018-04-05', '01:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `firstname` varchar(50) CHARACTER SET latin1 NOT NULL,
  `lastname` varchar(50) CHARACTER SET latin1 NOT NULL,
  `address` varchar(200) CHARACTER SET latin1 NOT NULL,
  `mail` varchar(100) CHARACTER SET latin1 NOT NULL,
  `password` varchar(100) CHARACTER SET latin1 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `firstname`, `lastname`, `address`, `mail`, `password`) VALUES
(1, 'plop', 'plop', 'Toulouse', 'plop@mail.com', 'plop');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `passenger`
--
ALTER TABLE `passenger`
  ADD PRIMARY KEY (`id_ride`,`id_user`),
  ADD KEY `fk_idUser_from_user` (`id_user`);

--
-- Indexes for table `ride`
--
ALTER TABLE `ride`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_idDriver_from_user` (`id_driver`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `ride`
--
ALTER TABLE `ride`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `passenger`
--
ALTER TABLE `passenger`
  ADD CONSTRAINT `fk_idRide_from_ride` FOREIGN KEY (`id_ride`) REFERENCES `ride` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_idUser_from_user` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `ride`
--
ALTER TABLE `ride`
  ADD CONSTRAINT `fk_idDriver_from_user` FOREIGN KEY (`id_driver`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
