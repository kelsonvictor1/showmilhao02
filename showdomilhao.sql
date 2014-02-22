-- phpMyAdmin SQL Dump
-- version 3.4.10.1deb1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tempo de Geração: 22/02/2014 às 11h08min
-- Versão do Servidor: 5.5.35
-- Versão do PHP: 5.3.10-1ubuntu3.9

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Banco de Dados: `showdomilhao`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `perguntas`
--

CREATE TABLE IF NOT EXISTS `perguntas` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(1000) DEFAULT NULL,
  `alternativa1` varchar(1000) DEFAULT NULL,
  `alternativa2` varchar(1000) DEFAULT NULL,
  `alternativa3` varchar(1000) DEFAULT NULL,
  `alternativa4` varchar(1000) DEFAULT NULL,
  `alternativa5` varchar(1000) DEFAULT NULL,
  `alternativa_correta` varchar(200) DEFAULT NULL,
  `pontuacao` int(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Extraindo dados da tabela `perguntas`
--

INSERT INTO `perguntas` (`id`, `titulo`, `alternativa1`, `alternativa2`, `alternativa3`, `alternativa4`, `alternativa5`, `alternativa_correta`, `pontuacao`) VALUES
(1, 'dsas', '31', 'dada', NULL, NULL, NULL, NULL, 0),
(2, 't', 'a1', 'a2', 'a3', 'a4', 'a5', 'a6', 35),
(3, 't3', 'po', 'po', 'po', 'po', 'po', 'po', 12),
(4, '332', '32edd', 'daad', 'ad', 'da', 'ad', 'ad', 32);

-- --------------------------------------------------------

--
-- Estrutura da tabela `tblUser`
--

CREATE TABLE IF NOT EXISTS `tblUser` (
  `userid` int(11) DEFAULT NULL,
  `firstname` varchar(50) DEFAULT NULL,
  `lastname` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `tblUser`
--

INSERT INTO `tblUser` (`userid`, `firstname`, `lastname`, `email`) VALUES
(2, 'e', 'rll', 'je@ss.s');

-- --------------------------------------------------------

--
-- Estrutura da tabela `teste`
--

CREATE TABLE IF NOT EXISTS `teste` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `senha` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user` varchar(100) NOT NULL,
  `senha` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
