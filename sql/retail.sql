-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Creato il: Mag 12, 2020 alle 22:21
-- Versione del server: 10.1.19-MariaDB
-- Versione PHP: 7.0.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `retail`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `category`
--

CREATE TABLE `category` (
  `id` int(11) NOT NULL,
  `name` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `comment`
--

CREATE TABLE `comment` (
  `id` int(11) NOT NULL,
  `message` varchar(200) NOT NULL,
  `date` datetime NOT NULL,
  `user_id` int(11) NOT NULL,
  `parent_comment_id` int(11) DEFAULT NULL,
  `product_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `link`
--

CREATE TABLE `link` (
  `id` int(11) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `url_icon` varchar(200) DEFAULT NULL,
  `link` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `product`
--

CREATE TABLE `product` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `price` decimal(10,2) NOT NULL,
  `url_image` varchar(255) DEFAULT NULL,
  `description` varchar(5000) NOT NULL,
  `available` tinyint(1) DEFAULT NULL,
  `brand` varchar(150) DEFAULT NULL,
  `packing_weight` decimal(5,2) DEFAULT NULL,
  `packing_size` varchar(250) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `product_subcategory`
--

CREATE TABLE `product_subcategory` (
  `id_product` int(11) NOT NULL,
  `id_subcategory` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `section`
--

CREATE TABLE `section` (
  `id` int(11) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `url_logo` varchar(255) DEFAULT NULL,
  `id_group` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `section_group`
--

CREATE TABLE `section_group` (
  `id` int(11) NOT NULL,
  `size_column` int(11) NOT NULL,
  `name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `section_link`
--

CREATE TABLE `section_link` (
  `id_section` int(11) NOT NULL,
  `id_link` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `sub_category`
--

CREATE TABLE `sub_category` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `id_category` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  `active` tinyint(1) NOT NULL,
  `roles` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `comment`
--
ALTER TABLE `comment`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `link`
--
ALTER TABLE `link`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `product_subcategory`
--
ALTER TABLE `product_subcategory`
  ADD PRIMARY KEY (`id_product`,`id_subcategory`),
  ADD KEY `id_subcategory` (`id_subcategory`);

--
-- Indici per le tabelle `section`
--
ALTER TABLE `section`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_group` (`id_group`);

--
-- Indici per le tabelle `section_group`
--
ALTER TABLE `section_group`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `section_link`
--
ALTER TABLE `section_link`
  ADD PRIMARY KEY (`id_section`,`id_link`),
  ADD KEY `id_link` (`id_link`);

--
-- Indici per le tabelle `sub_category`
--
ALTER TABLE `sub_category`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_category` (`id_category`);

--
-- Indici per le tabelle `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id` (`id`),
  ADD KEY `id_2` (`id`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `category`
--
ALTER TABLE `category`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT per la tabella `comment`
--
ALTER TABLE `comment`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT per la tabella `link`
--
ALTER TABLE `link`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT per la tabella `product`
--
ALTER TABLE `product`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=42;
--
-- AUTO_INCREMENT per la tabella `section`
--
ALTER TABLE `section`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT per la tabella `section_group`
--
ALTER TABLE `section_group`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT per la tabella `sub_category`
--
ALTER TABLE `sub_category`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT per la tabella `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `product_subcategory`
--
ALTER TABLE `product_subcategory`
  ADD CONSTRAINT `product_subcategory_ibfk_1` FOREIGN KEY (`id_subcategory`) REFERENCES `sub_category` (`id`),
  ADD CONSTRAINT `product_subcategory_ibfk_2` FOREIGN KEY (`id_product`) REFERENCES `product` (`id`);

--
-- Limiti per la tabella `section`
--
ALTER TABLE `section`
  ADD CONSTRAINT `section_ibfk_1` FOREIGN KEY (`id_group`) REFERENCES `section_group` (`id`);

--
-- Limiti per la tabella `section_link`
--
ALTER TABLE `section_link`
  ADD CONSTRAINT `section_link_ibfk_1` FOREIGN KEY (`id_section`) REFERENCES `section` (`id`),
  ADD CONSTRAINT `section_link_ibfk_2` FOREIGN KEY (`id_link`) REFERENCES `link` (`id`);

--
-- Limiti per la tabella `sub_category`
--
ALTER TABLE `sub_category`
  ADD CONSTRAINT `sub_category_ibfk_1` FOREIGN KEY (`id_category`) REFERENCES `category` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
