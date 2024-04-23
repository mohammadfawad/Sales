-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jan 27, 2014 at 05:51 PM
-- Server version: 5.5.13
-- PHP Version: 5.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `sales`
--
CREATE DATABASE IF NOT EXISTS `sales` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `sales`;

-- --------------------------------------------------------

--
-- Table structure for table `cashiers`
--

CREATE TABLE IF NOT EXISTS `cashiers` (
  `ID` int(11) NOT NULL,
  `Name` varchar(45) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cashiers`
--

INSERT INTO `cashiers` (`ID`, `Name`) VALUES
(1, 'Asad'),
(2, 'Saif');

-- --------------------------------------------------------

--
-- Table structure for table `categories`
--

CREATE TABLE IF NOT EXISTS `categories` (
  `ID` int(11) NOT NULL,
  `Name` varchar(45) NOT NULL,
  `Rank` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `customers`
--

CREATE TABLE IF NOT EXISTS `customers` (
  `ID` int(11) NOT NULL,
  `Name` varchar(45) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customers`
--

INSERT INTO `customers` (`ID`, `Name`) VALUES
(1, 'Imran'),
(2, 'Ali'),
(3, 'Qasam');

-- --------------------------------------------------------

--
-- Table structure for table `items`
--

CREATE TABLE IF NOT EXISTS `items` (
  `Code` int(11) NOT NULL,
  `Name` varchar(45) NOT NULL,
  `Price` float NOT NULL,
  `Rank` int(11) DEFAULT NULL,
  `Description` varchar(150) DEFAULT NULL,
  `ImageURL` varchar(150) DEFAULT NULL,
  `CID` int(11) NOT NULL,
  PRIMARY KEY (`Code`),
  KEY `CID` (`CID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `itemssuppliers`
--

CREATE TABLE IF NOT EXISTS `itemssuppliers` (
  `ItemCode` int(11) NOT NULL,
  `SupplierID` int(11) NOT NULL,
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`ID`,`ItemCode`,`SupplierID`),
  KEY `SupplierID` (`SupplierID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `saledetails`
--

CREATE TABLE IF NOT EXISTS `saledetails` (
  `RecieptNumber` int(11) NOT NULL,
  `SNo` int(11) NOT NULL,
  `ItemCode` int(11) NOT NULL,
  `Quantity` int(11) NOT NULL,
  PRIMARY KEY (`RecieptNumber`,`SNo`),
  KEY `RecieptNumber` (`RecieptNumber`),
  KEY `ItemCode` (`ItemCode`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `sales`
--

CREATE TABLE IF NOT EXISTS `sales` (
  `RecieptNumber` int(11) NOT NULL,
  `SaleDate` datetime NOT NULL,
  `CustomerID` int(11) NOT NULL,
  `CashierID` int(11) NOT NULL,
  `SalesPersonID` int(11) NOT NULL,
  PRIMARY KEY (`RecieptNumber`),
  KEY `CashierID` (`CashierID`),
  KEY `CustomerID` (`CustomerID`),
  KEY `SalePersonID` (`SalesPersonID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `salespersons`
--

CREATE TABLE IF NOT EXISTS `salespersons` (
  `ID` int(11) NOT NULL,
  `Name` varchar(45) NOT NULL,
  `CommissionRate` float NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `salespersons`
--

INSERT INTO `salespersons` (`ID`, `Name`, `CommissionRate`) VALUES
(1, 'Adnan', 0.06),
(2, 'Imran', 0.05);

-- --------------------------------------------------------

--
-- Table structure for table `suppliers`
--

CREATE TABLE IF NOT EXISTS `suppliers` (
  `ID` int(11) NOT NULL,
  `Name` varchar(45) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `items`
--
ALTER TABLE `items`
  ADD CONSTRAINT `CID` FOREIGN KEY (`CID`) REFERENCES `categories` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `itemssuppliers`
--
ALTER TABLE `itemssuppliers`
  ADD CONSTRAINT `SupplierID` FOREIGN KEY (`SupplierID`) REFERENCES `suppliers` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `saledetails`
--
ALTER TABLE `saledetails`
  ADD CONSTRAINT `ItemCode` FOREIGN KEY (`ItemCode`) REFERENCES `items` (`Code`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `RecieptNumber` FOREIGN KEY (`RecieptNumber`) REFERENCES `sales` (`RecieptNumber`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `sales`
--
ALTER TABLE `sales`
  ADD CONSTRAINT `CashierID` FOREIGN KEY (`CashierID`) REFERENCES `cashiers` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `CustomerID` FOREIGN KEY (`CustomerID`) REFERENCES `customers` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `SalePersonID` FOREIGN KEY (`SalesPersonID`) REFERENCES `salespersons` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
