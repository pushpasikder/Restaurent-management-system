-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3307
-- Generation Time: Aug 11, 2022 at 04:43 PM
-- Server version: 10.4.19-MariaDB
-- PHP Version: 8.0.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `restaurant`
--

-- --------------------------------------------------------

--
-- Table structure for table `billlist`
--

CREATE TABLE `billlist` (
  `Tableno` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `billtbl`
--

CREATE TABLE `billtbl` (
  `TableNo` int(30) NOT NULL,
  `Name` varchar(30) NOT NULL,
  `Price` int(30) NOT NULL,
  `Quantity` int(30) NOT NULL,
  `Total` int(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `billtbl`
--

INSERT INTO `billtbl` (`TableNo`, `Name`, `Price`, `Quantity`, `Total`) VALUES
(1, 'lacchi', 70, 2, 140),
(1, 'pizza', 450, 1, 450);

-- --------------------------------------------------------

--
-- Table structure for table `list`
--

CREATE TABLE `list` (
  `TableNo` int(30) NOT NULL,
  `Name` varchar(30) NOT NULL,
  `Price` int(30) NOT NULL,
  `Quantity` int(30) NOT NULL,
  `Total` int(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `list`
--

INSERT INTO `list` (`TableNo`, `Name`, `Price`, `Quantity`, `Total`) VALUES
(8, 'pizza', 450, 4, 1800),
(5, 'lacchi', 70, 4, 280),
(6, 'lacchi', 70, 5, 350),
(6, 'pasta', 180, 5, 900),
(6, 'lacchi', 70, 5, 350),
(8, 'Fuska', 50, 6, 300),
(8, 'pasta', 180, 47, 8460);

-- --------------------------------------------------------

--
-- Table structure for table `producttbl`
--

CREATE TABLE `producttbl` (
  `PNum` int(30) NOT NULL,
  `PName` varchar(30) NOT NULL,
  `Price` int(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `producttbl`
--

INSERT INTO `producttbl` (`PNum`, `PName`, `Price`) VALUES
(1, 'lacchi', 70),
(2, 'pizza', 450),
(5, 'Fuska', 50),
(6, 'Cotpoti', 40),
(7, 'tea', 15),
(8, ' chicken Biriyani', 220);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
