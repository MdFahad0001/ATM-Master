This project can perform some basic functionality of an Automated Teller Machine (ATM). It is a very simple and beginner level basic project so don't expect too much 🙂

It also have some bugs to be fixed but i'm not interested anymore 🥀
Before run this program in your machine follow these steps - 
1. Start your local server (XAMPP in my case) and browse phpMyAdmin dashboard
2. Create new database named by atm
3. Under this atm database run following sql codes. These sql codes will create required tables and also insert some demo data for initial use.
-----------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------

-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 03, 2022 at 04:45 PM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `atm`
--

-- --------------------------------------------------------

--
-- Table structure for table `ledger`
--

CREATE TABLE `ledger` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `amount` int(11) NOT NULL,
  `type` int(1) NOT NULL COMMENT 'type 1 for cash in 2 for cash out',
  `created_at` text DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `ledger`
--

INSERT INTO `ledger` (`id`, `user_id`, `amount`, `type`, `created_at`) VALUES
(2, 2, 5000, 1, NULL),
(3, 2, 5000, 1, NULL),
(4, 2, 50000, 1, NULL),
(5, 2, 50000, 1, NULL),
(6, 1, 10000, 1, NULL),
(7, 2, 8000, 1, NULL),
(8, 2, 1500, 1, NULL),
(9, 2, 500, 1, '2022-11-30 20:48:46'),
(10, 2, 2500, 1, '2022-12-01 21:57:12'),
(11, 2, 50000, 2, '2022-12-01 22:17:33'),
(12, 2, 50000, 2, '2022-12-01 22:24:00'),
(13, 2, 500, 2, '2022-12-01 22:24:12'),
(14, 2, 20000, 2, '2022-12-01 22:24:43'),
(15, 1, 500, 2, '2022-12-01 23:27:08'),
(16, 2, 200, 2, '2022-12-03 20:49:25');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `card_number` text DEFAULT NULL,
  `password` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `card_number`, `password`) VALUES
(1, '1410970047', 'check'),
(2, '123456', '445566'),
(3, 'hasan', 'osama');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `ledger`
--
ALTER TABLE `ledger`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `ledger`
--
ALTER TABLE `ledger`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;


-----------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------
4. Open project in NetBeans IDE and click run.

Thank you!!!
Regards,

*Mehedi Hasan Nayem*
