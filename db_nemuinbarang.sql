-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 11, 2020 at 11:01 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.3.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_gunung`
--

-- --------------------------------------------------------

--
-- Table structure for table `tb_jalur`
--

CREATE TABLE `tb_jalur` (
  `id` int(11) NOT NULL,
  `nama` varchar(30) CHARACTER SET latin1 DEFAULT NULL,
  `jarak` varchar(20) CHARACTER SET latin1 DEFAULT NULL,
  `wilayah` varchar(50) CHARACTER SET latin1 DEFAULT NULL,
  `image` varchar(300) CHARACTER SET latin1 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_jalur`
--

INSERT INTO `tb_jalur` (`id`, `nama`, `jarak`, `wilayah`, `image`) VALUES
(1, 'amsal', '12', 'Boyolali', 'http://192.168.1.10/aplikasigunung/uploads/image1594389931300.jpeg'),
(3, 'Wekas', '15 Km', 'Kebumen', 'http://192.168.1.10/aplikasigunung/uploads/image1594454501805.jpeg'),
(4, 'ams', '12', 'mwdan', ''),
(5, 'amsl', '12', 'mdn', ''),
(7, 'gogo', '12', 'mdn', ''),
(8, 'hdhd', 'bnd', 'vdjd', 'http://192.168.1.10/aplikasigunung/uploads/image1594456838691.jpeg'),
(9, 'yuy', '12', 'mnd', 'http://192.168.1.10/aplikasigunung/uploads/image1594457618097.jpeg');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_jalur`
--
ALTER TABLE `tb_jalur`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tb_jalur`
--
ALTER TABLE `tb_jalur`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
