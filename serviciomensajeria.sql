-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 02-05-2024 a las 10:42:35
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `serviciomensajeria`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--
CREATE DATABASE serviciomensajeria;
USE serviciomensajeria;

CREATE TABLE `cliente` (
  `idCliente` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `telefono` varchar(10) NOT NULL,
  `email` varchar(50) NOT NULL,
  `contraseña` varchar(30) NOT NULL,
  `fecha_modificacion` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`idCliente`, `nombre`, `direccion`, `telefono`, `email`, `contraseña`, `fecha_modificacion`) VALUES
(1, 'Maria Larios', 'Alfredo M. Terrazas 220, De Tequisquiapan, 78250 San Luis Potosí, S.L.P.', '4448494241', 'marialarios@hotmail.com', 'MariaLarios', '2024-04-30 21:42:20'),
(2, 'Juan Antonio', 'Jacarandas 295, Jardín, 78270 San Luis Potosí, S.L.P.', '4447484143', 'juanantonio@hotmail.com', 'JuanAntonio', '2024-04-30 21:44:28');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

CREATE TABLE `empleado` (
  `idEmpleado` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `telefono` varchar(10) NOT NULL,
  `email` varchar(50) NOT NULL,
  `contraseña` varchar(30) NOT NULL,
  `rolRegistra` tinyint(1) NOT NULL,
  `rolEntrega` tinyint(1) NOT NULL,
  `admin` tinyint(1) NOT NULL,
  `fecha_modificacion` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `empleado`
--

INSERT INTO `empleado` (`idEmpleado`, `nombre`, `direccion`, `telefono`, `email`, `contraseña`, `rolRegistra`, `rolEntrega`, `admin`, `fecha_modificacion`) VALUES
(1, 'Jordan Medina Ortiz', 'Calle Sta. Rosa de Lima, Santa Mónica, Franci', '4447258759', '179913@upslp.edu.mx', 'Jordan179913', 0, 0, 1, '2024-04-28 09:14:48'),
(2, 'Juan Rosas', 'C. Urbano Villalón 500, La Ladrillera', '4447859558', 'juanrosas@hotmail.com', 'JuanRosas', 0, 1, 0, '2024-04-27 21:16:32'),
(3, 'Maria Duarte', 'Valle de Tangamanga 109, Hogares Ferrocarrileros 2', '4448494744', 'mariaduarte@hotmail.com', 'MariaDuarte', 1, 1, 0, '2024-04-28 08:53:45'),
(4, 'Juan Perez', 'Del Buen Consejo 314, Garita de Jalisco', '4445424346', 'juanperez@hotmail.com', 'JuanPerez', 1, 0, 0, '2024-04-29 06:20:37');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `entrega`
--

CREATE TABLE `entrega` (
  `idEntrega` int(11) NOT NULL,
  `estado` varchar(20) NOT NULL,
  `idPaquete` int(15) NOT NULL,
  `idEmpleado` int(11) NOT NULL,
  `fecha_modificacion` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `entrega`
--

INSERT INTO `entrega` (`idEntrega`, `estado`, `idPaquete`, `idEmpleado`, `fecha_modificacion`) VALUES
(1, 'Activo', 1, 2, '2024-05-02 08:41:57'),
(2, 'En proceso', 2, 3, '2024-05-02 08:34:26');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paquete`
--

CREATE TABLE `paquete` (
  `idPaquete` int(15) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `palabraClave` varchar(15) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `idCliente` int(11) NOT NULL,
  `fecha_modificacion` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `paquete`
--

INSERT INTO `paquete` (`idPaquete`, `direccion`, `palabraClave`, `nombre`, `idCliente`, `fecha_modificacion`) VALUES
(1, 'Alfredo M. Terrazas 220, De Tequisquiapan, 78250 San Luis Potosí, S.L.P.', 'Laptop', 'Maria Larios', 1, '2024-04-30 22:13:37'),
(2, 'Jacarandas 295, Jardín, 78270 San Luis Potosí, S.L.P.', 'Mouse', 'Juan Antonio', 2, '2024-04-30 22:13:43');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`idCliente`);

--
-- Indices de la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD PRIMARY KEY (`idEmpleado`);

--
-- Indices de la tabla `entrega`
--
ALTER TABLE `entrega`
  ADD PRIMARY KEY (`idEntrega`);

--
-- Indices de la tabla `paquete`
--
ALTER TABLE `paquete`
  ADD PRIMARY KEY (`idPaquete`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `idCliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `empleado`
--
ALTER TABLE `empleado`
  MODIFY `idEmpleado` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `entrega`
--
ALTER TABLE `entrega`
  MODIFY `idEntrega` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `paquete`
--
ALTER TABLE `paquete`
  MODIFY `idPaquete` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
