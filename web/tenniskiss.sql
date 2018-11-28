-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 28-11-2018 a las 23:57:29
-- Versión del servidor: 10.1.25-MariaDB
-- Versión de PHP: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
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
  `RankingIndividual` int(11) NOT NULL,
  `RankingDoble` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `jugador`
--

INSERT INTO `jugador` (`documento`, `RankingIndividual`, `RankingDoble`) VALUES
(0, 0, 0),
(123, 123, 1231),
(789, 456, 456),
(321654, 4, 5),
(789987, 4, 5),
(32165488, 4, 5),
(1012324441, 1, 1),
(1012324443, 2, 2),
(1012324444, 10, 12),
(1012324449, 1, 15);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `jugador_x_torneo`
--

CREATE TABLE `jugador_x_torneo` (
  `idJugador_torneo` bigint(20) NOT NULL,
  `torneo_idtorneo` bigint(20) NOT NULL,
  `jugador_documento` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `jugador_x_torneo`
--

INSERT INTO `jugador_x_torneo` (`idJugador_torneo`, `torneo_idtorneo`, `jugador_documento`) VALUES
(3, 7, 32165488),
(4, 9, 789987);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--

CREATE TABLE `rol` (
  `documento` bigint(20) NOT NULL,
  `rol` varchar(45) NOT NULL,
  `clave` varchar(125) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `rol`
--

INSERT INTO `rol` (`documento`, `rol`, `clave`) VALUES
(1012324447, 'Administrador', 'e10adc3949ba59abbe56e057f20f883e');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `torneo`
--

CREATE TABLE `torneo` (
  `idtorneo` bigint(20) NOT NULL,
  `Nombre` varchar(45) NOT NULL,
  `fecha_inicio` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fecha_fin` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `torneo`
--

INSERT INTO `torneo` (`idtorneo`, `Nombre`, `fecha_inicio`, `fecha_fin`) VALUES
(7, 'Prueba torneo 1', '2018-11-28 05:00:00', '2018-12-31 05:00:00'),
(9, 'prueba 2', '2018-11-28 05:00:00', '2018-11-30 05:00:00'),
(10, 'prueba 3', '2018-11-01 05:00:00', '2018-12-29 05:00:00'),
(11, 'prueba 4', '2018-11-28 05:00:00', '2019-01-31 05:00:00'),
(12, 'prueba 5', '2018-11-28 05:00:00', '2019-03-31 05:00:00'),
(13, 'prueba 6', '2018-11-28 05:00:00', '2019-04-30 05:00:00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `documento` bigint(20) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `nacionalidad` varchar(45) NOT NULL,
  `sexo` tinytext NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`documento`, `nombre`, `apellido`, `nacionalidad`, `sexo`) VALUES
(0, '', '', '', 'null'),
(123, '123', '123', 'Peruana', 'M'),
(789, '789', '789', 'Colombiano', 'M'),
(321654, '321654', '321654', 'Colombiana', 'M'),
(789987, '987789', '789987', 'Colombiana', 'M'),
(32165488, '321654', '321654', 'Colombiana', 'M'),
(1012324441, 'Pedro', 'Martinez', 'Colombiana', 'M'),
(1012324443, 'Laura', 'Saenz', 'Colombiana', 'F'),
(1012324444, 'Ximena', 'Lopez', 'Peruana', 'F'),
(1012324446, 'Larry', 'Lord', '', 'M'),
(1012324447, 'Jhon Mauricio', 'Moreno García', 'Colombiana', 'M'),
(1012324449, 'Pedro', 'Martinez', 'Colombiana', 'M');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `jugador`
--
ALTER TABLE `jugador`
  ADD PRIMARY KEY (`documento`),
  ADD KEY `fk_jugador_usuario_idx` (`documento`);

--
-- Indices de la tabla `jugador_x_torneo`
--
ALTER TABLE `jugador_x_torneo`
  ADD PRIMARY KEY (`idJugador_torneo`),
  ADD KEY `fk_torneo_has_jugador_jugador1_idx` (`jugador_documento`),
  ADD KEY `fk_torneo_has_jugador_torneo1_idx` (`torneo_idtorneo`);

--
-- Indices de la tabla `rol`
--
ALTER TABLE `rol`
  ADD PRIMARY KEY (`documento`),
  ADD KEY `fk_rol_usuario_idx` (`documento`);

--
-- Indices de la tabla `torneo`
--
ALTER TABLE `torneo`
  ADD PRIMARY KEY (`idtorneo`),
  ADD UNIQUE KEY `Nombre_UNIQUE` (`Nombre`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`documento`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `jugador_x_torneo`
--
ALTER TABLE `jugador_x_torneo`
  MODIFY `idJugador_torneo` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT de la tabla `torneo`
--
ALTER TABLE `torneo`
  MODIFY `idtorneo` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `jugador`
--
ALTER TABLE `jugador`
  ADD CONSTRAINT `fk_jugador_usuario` FOREIGN KEY (`documento`) REFERENCES `usuario` (`documento`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `jugador_x_torneo`
--
ALTER TABLE `jugador_x_torneo`
  ADD CONSTRAINT `fk_torneo_has_jugador_jugador1` FOREIGN KEY (`jugador_documento`) REFERENCES `jugador` (`documento`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_torneo_has_jugador_torneo1` FOREIGN KEY (`torneo_idtorneo`) REFERENCES `torneo` (`idtorneo`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `rol`
--
ALTER TABLE `rol`
  ADD CONSTRAINT `fk_rol_usuario` FOREIGN KEY (`documento`) REFERENCES `usuario` (`documento`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
