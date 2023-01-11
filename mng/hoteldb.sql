-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3307
-- Generation Time: Nov 24, 2022 at 08:55 AM
-- Server version: 10.4.25-MariaDB
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hoteldb`
--

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `ID` int(50) NOT NULL,
  `full_names` varchar(255) NOT NULL,
  `user_name` varchar(23) NOT NULL,
  `password` varchar(33) NOT NULL,
  `Tel` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`ID`, `full_names`, `user_name`, `password`, `Tel`) VALUES
(1, 'regis ishimwe', 'regis', '1234', 783445333),
(2, 'adimn123', 'admin', '123', 78833662),
(3, 'Tuyizere Aimee', 'tuy123', '456', 788833833),
(4, 'regi', 'registration', '234', 947747788),
(5, 'herve', 'twubahimana', '1234', 76899766),
(6, 'alain', 'al', '123', 4786236);

-- --------------------------------------------------------

--
-- Table structure for table `room`
--

CREATE TABLE `room` (
  `rid` varchar(255) NOT NULL,
  `rtype` varchar(255) NOT NULL,
  `btype` varchar(255) NOT NULL,
  `amount` int(244) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `room`
--

INSERT INTO `room` (`rid`, `rtype`, `btype`, `amount`) VALUES
('R0001', 'VIP', 'KING SIZE', 5000),
('R0002', 'MIDLE CLASS', 'QUENN SIZE', 3000),
('R0003', 'VIP', 'SINGLE', 4000),
('R0004', 'ECONOMIC', 'DOUBLE', 1000),
('R0005', 'VIP', 'KING SIZE', 2000),
('R0006', 'VIP', 'KING SIZE', 3000),
('R0007', 'VIP', 'SINGLE', 34422);

-- --------------------------------------------------------

--
-- Table structure for table `user_creation`
--

CREATE TABLE `user_creation` (
  `Uid` time NOT NULL,
  `user_name` varchar(25) NOT NULL,
  `name` varchar(44) NOT NULL,
  `Tel` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `room`
--
ALTER TABLE `room`
  ADD PRIMARY KEY (`rid`);

--
-- Indexes for table `user_creation`
--
ALTER TABLE `user_creation`
  ADD PRIMARY KEY (`Uid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `login`
--
ALTER TABLE `login`
  MODIFY `ID` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
