-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Aug 31, 2014 at 06:58 AM
-- Server version: 5.5.36
-- PHP Version: 5.4.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `DistributedLibrary`
--
CREATE DATABASE `DistributedLibrary`;

USE `DistributedLibrary`;
-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE IF NOT EXISTS `account` (
  `userName` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(80) COLLATE utf8_unicode_ci NOT NULL,
  `userType` int(11) DEFAULT NULL,
  `patron_Id` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`userName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`userName`, `password`, `userType`, `patron_Id`) VALUES
('dbu001', 'dbu001', 1, 'dbu001'),
('dbu005', 'dbu005', 0, 'dbu005'),
('java', 'rmi', 0, 'ad00');

-- --------------------------------------------------------

--
-- Table structure for table `biblio_record`
--

CREATE TABLE IF NOT EXISTS `biblio_record` (
  `biblio_isbn` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `biblio_title` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `biblio_author` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `biblio_Date` int(11) DEFAULT NULL,
  `biblio_edition` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `biblio_publisher` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `biblio_Place` varchar(80) COLLATE utf8_unicode_ci DEFAULT NULL,
  `biblio_Quantity` int(11) DEFAULT NULL,
  `biblio_UnitPrice` double DEFAULT NULL,
  `biblio_catagory` varchar(85) COLLATE utf8_unicode_ci DEFAULT NULL,
  `library_id` int(11) NOT NULL,
  PRIMARY KEY (`biblio_isbn`),
  UNIQUE KEY `biblio_isbn_UNIQUE` (`biblio_isbn`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `biblio_record`
--

INSERT INTO `biblio_record` (`biblio_isbn`, `biblio_title`, `biblio_author`, `biblio_Date`, `biblio_edition`, `biblio_publisher`, `biblio_Place`, `biblio_Quantity`, `biblio_UnitPrice`, `biblio_catagory`, `library_id`) VALUES
('1001', 'C# programming', 'press', 2013, '5', 'MsPress', 'USA', 10, 456, 'Books', 1),
('1002', 'Fikir Eske Mekabr', 'Haddis Alemayehu', 1980, '1', 'Mankussa Pr Plc', 'Addis Ababa', 11, 45, 'Books', 1),
('1003', 'Oromay', 'Bealu Girma', 1980, '1', 'mankusa', 'Addis Ababa', 4, 50, 'Books', 1),
('1004', 'Java programming', 'Mallos', 2014, '5', 'Manll plc', 'New Delhi', 7, 100, 'Books', 1),
('1005', 'Cisco Networking ', 'Cisco', 2013, '5', 'Cisco plc', 'USA', 6, 200, 'Books', 1),
('1010', 'Egna Na Abiwotu', 'Fikresilassie Wegderess', 2013, '1', 'Tsehay publishers', 'Addis Ababa', 1, 200, 'Books', 1);

-- --------------------------------------------------------

--
-- Table structure for table `check_out`
--

CREATE TABLE IF NOT EXISTS `check_out` (
  `check_out_id` int(11) NOT NULL AUTO_INCREMENT,
  `accession_number` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `check_out_date` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `check_in_date` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `check_status` int(11) DEFAULT NULL,
  `patron_card_number` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `rule_id` int(11) DEFAULT NULL,
  `check_returned_date` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`check_out_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=12 ;

--
-- Dumping data for table `check_out`
--

INSERT INTO `check_out` (`check_out_id`, `accession_number`, `check_out_date`, `check_in_date`, `check_status`, `patron_card_number`, `rule_id`, `check_returned_date`) VALUES
(1, '1/1001/1', '28-07-2014', '05-08-2014', 1, '1004', 1, NULL),
(2, '1/1002/1', '28-07-2014', '05-08-2014', 0, '1002', 1, '03-08-2014'),
(3, '1/1004/1', '28-07-2014', '05-08-2014', 1, '1002', 1, NULL),
(4, '1/1004/6', '28-07-2014', '05-08-2014', 0, '1005', 1, '03-08-2014'),
(5, '1/1005/3', '03-08-2014', '11-08-2014', 1, '1002', 1, NULL),
(6, '1/1005/4', '03-08-2014', '11-08-2014', 1, '1004', 1, NULL),
(7, '1/1004/2', '03-08-2014', '03-08-2014', 0, '1005', 1, '25-08-2014'),
(8, '1/1001/6', '03-08-2014', '11-08-2014', 0, '1003', 1, '03-08-2014'),
(9, '1/1001/5', '03-08-2014', '11-08-2014', 1, '1003', 1, NULL),
(10, '1/1005/5', '10-08-2014', '18-08-2014', 1, '1002', 1, NULL),
(11, '1/1001/10', '25-08-2014', '02-09-2014', 1, '1001', 1, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `item`
--

CREATE TABLE IF NOT EXISTS `item` (
  `accession_number` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `biblio_isbn` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `shelf_id` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `item_status` int(11) NOT NULL,
  PRIMARY KEY (`accession_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `item`
--

INSERT INTO `item` (`accession_number`, `biblio_isbn`, `shelf_id`, `item_status`) VALUES
('1/1001/1', '1001', 'Comp002', 1),
('1/1001/10', '1001', 'Comp002', 1),
('1/1001/2', '1001', 'Comp002', 0),
('1/1001/3', '1001', 'Comp002', 0),
('1/1001/4', '1001', 'Comp002', 0),
('1/1001/5', '1001', 'Comp002', 1),
('1/1001/6', '1001', 'Comp002', 0),
('1/1001/7', '1001', 'Comp002', 0),
('1/1001/8', '1001', 'Comp002', 0),
('1/1001/9', '1001', 'Comp002', 0),
('1/1002/1', '1002', 'fic001', 0),
('1/1002/10', '1002', 'fic001', 0),
('1/1002/11', '1002', 'fic001', 0),
('1/1002/2', '1002', 'fic001', 0),
('1/1002/3', '1002', 'fic001', 0),
('1/1002/4', '1002', 'fic001', 0),
('1/1002/5', '1002', 'fic001', 0),
('1/1002/6', '1002', 'fic001', 0),
('1/1002/7', '1002', 'fic001', 0),
('1/1002/8', '1002', 'fic001', 0),
('1/1002/9', '1002', 'fic001', 0),
('1/1003/1', '1003', 'fic001', 0),
('1/1003/2', '1003', 'fic001', 0),
('1/1003/3', '1003', 'fic001', 0),
('1/1003/4', '1003', 'fic001', 0),
('1/1004/1', '1004', 'Comp002', 1),
('1/1004/2', '1004', 'Comp002', 0),
('1/1004/3', '1004', 'Comp002', 0),
('1/1004/4', '1004', 'Comp002', 0),
('1/1004/5', '1004', 'Comp002', 0),
('1/1004/6', '1004', 'Comp002', 0),
('1/1004/7', '1004', 'Comp002', 0),
('1/1005/1', '1005', 'Comp002', 0),
('1/1005/2', '1005', 'Comp002', 0),
('1/1005/3', '1005', 'comp001', 1),
('1/1005/4', '1005', 'comp001', 1),
('1/1005/5', '1005', 'comp001', 1),
('1/1005/6', '1005', 'comp001', 0),
('1/1010/1', '1010', 'fic001', 0);

-- --------------------------------------------------------

--
-- Table structure for table `library`
--

CREATE TABLE IF NOT EXISTS `library` (
  `Library_Id` int(11) NOT NULL AUTO_INCREMENT,
  `Library_Name` varchar(80) COLLATE utf8_unicode_ci NOT NULL,
  `Library_Address` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Library_Phone` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Library_Fax` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Library_Email` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Library_Site` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Library_Note` tinytext COLLATE utf8_unicode_ci,
  PRIMARY KEY (`Library_Id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=2 ;

--
-- Dumping data for table `library`
--

INSERT INTO `library` (`Library_Id`, `Library_Name`, `Library_Address`, `Library_Phone`, `Library_Fax`, `Library_Email`, `Library_Site`, `Library_Note`) VALUES
(1, 'Natural Science', 'DBU', '116812856', '', '', 'www.dbu.edu.et', 'DBU Natural Science Library');

-- --------------------------------------------------------

--
-- Table structure for table `patron`
--

CREATE TABLE IF NOT EXISTS `patron` (
  `patron_id` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `patron_name` varchar(80) COLLATE utf8_unicode_ci NOT NULL,
  `patron_father_name` varchar(80) COLLATE utf8_unicode_ci DEFAULT NULL,
  `patron_gandfather_name` varchar(80) COLLATE utf8_unicode_ci DEFAULT NULL,
  `patron_gender` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `patron_catagory` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `patron_faculty` varchar(80) COLLATE utf8_unicode_ci DEFAULT NULL,
  `patron_department` varchar(80) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Patron_year` varchar(5) COLLATE utf8_unicode_ci DEFAULT NULL,
  `patron_phone` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `patron_email` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `patron_card_number` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `patron_registration_date` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `library_Id` int(11) NOT NULL,
  PRIMARY KEY (`patron_id`),
  UNIQUE KEY `patron_card_number_UNIQUE` (`patron_card_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `patron`
--

INSERT INTO `patron` (`patron_id`, `patron_name`, `patron_father_name`, `patron_gandfather_name`, `patron_gender`, `patron_catagory`, `patron_faculty`, `patron_department`, `Patron_year`, `patron_phone`, `patron_email`, `patron_card_number`, `patron_registration_date`, `library_Id`) VALUES
('1001', 'Abebe', 'Kebede', 'Lemma', 'Male', 'Librarian', 'Computing Science', 'Computer Science', 'null', '', '', '1001', 'Jul 28, 2014', 1),
('1002', 'Fatuma', 'Kebede', '', 'Female', 'Student', 'Computing Science', 'Computer Science', 'II', '', '', '1002', 'Jul 28, 2014', 1),
('1003', 'Ahmed', 'Mamo', 'Kebede', 'Male', 'Student', 'Computing Science', 'Computer Science', 'II', '', '', '1003', 'Jul 28, 2014', 1),
('1004', 'Lemma', 'Kebede', '', 'Male', 'Student', 'Computing Science', 'Computer Science', 'II', '', '', '1004', 'Jul 28, 2014', 1),
('1005', 'Abesselom', 'Lemma', '', 'Male', 'Librarian', 'Computing Science', 'Computer Science', 'null', '', '', '1005', 'Jul 28, 2014', 1),
('1006', 'Teklay', 'G/mikael', '', 'Male', 'Student', 'Computing Science', 'Computer Science', 'III', '', '', '1006', 'Jul 28, 2014', 1);

-- --------------------------------------------------------

--
-- Table structure for table `rule`
--

CREATE TABLE IF NOT EXISTS `rule` (
  `rule_id` int(11) NOT NULL AUTO_INCREMENT,
  `Library_id` int(11) DEFAULT NULL,
  `patron_catagory` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `item_type` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Check_out_allowed` int(11) DEFAULT NULL,
  `loan_period` int(11) DEFAULT NULL,
  `renewal_allowed` int(11) DEFAULT NULL,
  `fine_amount` decimal(10,2) DEFAULT NULL,
  `fine_charge_interval` int(11) DEFAULT NULL,
  PRIMARY KEY (`rule_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=2 ;

--
-- Dumping data for table `rule`
--

INSERT INTO `rule` (`rule_id`, `Library_id`, `patron_catagory`, `item_type`, `Check_out_allowed`, `loan_period`, `renewal_allowed`, `fine_amount`, `fine_charge_interval`) VALUES
(1, 1, 'All', 'All', 10, 8, 2, '0.25', 1);

-- --------------------------------------------------------

--
-- Table structure for table `shelf`
--

CREATE TABLE IF NOT EXISTS `shelf` (
  `shelf_id` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `shelf_Name` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `library_id` int(11) NOT NULL,
  PRIMARY KEY (`shelf_id`),
  UNIQUE KEY `shelf_id_UNIQUE` (`shelf_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `shelf`
--

INSERT INTO `shelf` (`shelf_id`, `shelf_Name`, `library_id`) VALUES
('Bio001', 'Bilogy One', 1),
('comp001', 'Computer Network', 1),
('Comp002', 'Computder Programming', 1),
('fic001', 'Fiction One', 1);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
