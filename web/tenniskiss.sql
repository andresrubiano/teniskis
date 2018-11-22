-- phpMyAdmin SQL Dump
-- version 4.8.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 22-11-2018 a las 20:31:33
-- Versión del servidor: 10.1.31-MariaDB
-- Versión de PHP: 7.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `tenniskiss`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `jugador`
--

CREATE TABLE `jugador` (
  `documento` bigint(20) NOT NULL,
  `Nombre` varchar(45) COLLATE utf8_spanish2_ci NOT NULL,
  `apellido` varchar(45) COLLATE utf8_spanish2_ci NOT NULL,
  `nacionalidad` varchar(45) COLLATE utf8_spanish2_ci NOT NULL,
  `RankingIndividual` int(11) NOT NULL,
  `RankingDoble` int(11) NOT NULL,
  `Evento` tinytext COLLATE utf8_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `jugador`
--

INSERT INTO `jugador` (`documento`, `Nombre`, `apellido`, `nacionalidad`, `RankingIndividual`, `RankingDoble`, `Evento`) VALUES
(1, '1', '1', '1', 1, 1, '1'),
(1111, '111', '1', '111', 11, 11, 'D'),
(1234, 'Prueba', 'Lopera', 'Vanezolana', 300, 12, 'I'),
(80101977, 'Cristian', 'Ospina', 'Colombiana', 3, 2, 'ID'),
(123456789, 'Sofía', 'Rivera', 'Francesa', 123, 124, 'ID'),
(1012324447, 'jhon mauricio', 'moreno garcía', 'Colombiana', 123, 0, 'I'),
(1012324448, 'jhon mauricio', 'moreno garcía', 'Colombiana', 123, 0, 'I'),
(1012324449, 'Pedro', 'Marmol', 'Peruana', 25, 1, 'ID'),
(1012324450, 'Luis', 'moreno', 'Colombiana', 7, 8, 'D'),
(1012324451, 'klk', 'ihiohoi', 'ugiug', 4465, 6565, 'I'),
(1012324460, 'Sandra', 'Montañez', 'Argentina', 4, 17, 'ID');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `jugador`
--
ALTER TABLE `jugador`
  ADD PRIMARY KEY (`documento`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
