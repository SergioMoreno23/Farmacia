-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 08-08-2020 a las 10:40:10
-- Versión del servidor: 10.4.13-MariaDB
-- Versión de PHP: 7.4.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `farmaciajor`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `administrador`
--

CREATE TABLE `administrador` (
  `usuario_a` varchar(10) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `apellido` varchar(100) NOT NULL,
  `f_nacimiento` date NOT NULL,
  `contraseña` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `entradas`
--

CREATE TABLE `entradas` (
  `id` bigint(15) NOT NULL,
  `id_producto` bigint(15) NOT NULL,
  `fecha_registro` date NOT NULL,
  `entradas` bigint(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `historial_farmacia`
--

CREATE TABLE `historial_farmacia` (
  `numero` int(15) NOT NULL,
  `folio` int(15) NOT NULL,
  `id_producto` bigint(17) NOT NULL,
  `fecha` date NOT NULL,
  `cantidad` varchar(100) NOT NULL,
  `metodo_pago` varchar(50) NOT NULL,
  `descuento` float NOT NULL,
  `total` float NOT NULL,
  `usuario` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `historial_farmacia`
--

INSERT INTO `historial_farmacia` (`numero`, `folio`, `id_producto`, `fecha`, `cantidad`, `metodo_pago`, `descuento`, `total`, `usuario`) VALUES
(70, 0, 2, '2020-08-08', '0', 'SALDO EN CAJA', 0, 500, 'Clave'),
(71, 1, 16283784794, '2020-08-08', '1', 'Efectivo', 0, 568, 'Clave'),
(72, 1, 16283784794, '2020-08-08', '1', 'Efectivo', 0, 568, 'Clave'),
(73, 1, 16283784794, '2020-08-08', '1', 'Efectivo', 0, 568, 'Clave'),
(74, 2, 37897389738, '2020-08-08', '1', 'Efectivo', 0, 67, 'Clave'),
(75, 2, 16283784794, '2020-08-08', '1', 'Efectivo', 0, 568, 'Clave'),
(76, 2, 3932987427, '2020-08-08', '1', 'Efectivo', 0, 234, 'Clave'),
(77, 2, 2787387498, '2020-08-08', '1', 'Efectivo', 0, 500, 'Clave'),
(78, 3, 16283784794, '2020-08-08', '1', 'Efectivo', 0, 568, 'Clave'),
(79, 3, 16283784794, '2020-08-08', '1', 'Efectivo', 0, 568, 'Clave'),
(80, 3, 16283784794, '2020-08-08', '1', 'Efectivo', 0, 568, 'Clave'),
(81, 4, 37897389738, '2020-08-08', '1', 'Efectivo', 0, 67, 'Clave'),
(82, 4, 37897389738, '2020-08-08', '1', 'Efectivo', 0, 67, 'Clave'),
(83, 4, 37897389738, '2020-08-08', '1', 'Efectivo', 0, 67, 'Clave'),
(84, 4, 37897389738, '2020-08-08', '1', 'Efectivo', 0, 67, 'Clave'),
(85, 4, 37897389738, '2020-08-08', '1', 'Efectivo', 0, 67, 'Clave'),
(86, 5, 2787387498, '2020-08-08', '2', 'Efectivo', 0, 1000, 'Clave'),
(87, 5, 3932987427, '2020-08-08', '1', 'Efectivo', 0, 234, 'Clave'),
(88, 5, 16283784794, '2020-08-08', '1', 'Efectivo', 0, 568, 'Clave'),
(89, 6, 2787387498, '2020-08-08', '1', 'Efectivo', 0, 500, 'Clave'),
(90, 6, 3932987427, '2020-08-08', '1', 'Efectivo', 0, 234, 'Clave'),
(91, 6, 16283784794, '2020-08-08', '1', 'Efectivo', 0, 568, 'Clave'),
(92, 7, 3932987427, '2020-08-08', '1', 'Efectivo', 0, 234, 'Clave'),
(93, 7, 3932987427, '2020-08-08', '1', 'Efectivo', 0, 234, 'Clave'),
(94, 7, 3932987427, '2020-08-08', '1', 'Efectivo', 0, 234, 'Clave'),
(95, 7, 3932987427, '2020-08-08', '1', 'Efectivo', 0, 234, 'Clave'),
(96, 8, 37897389738, '2020-08-08', '1', 'Efectivo', 0, 67, 'Clave'),
(97, 8, 37897389738, '2020-08-08', '100', 'Efectivo', 0, 6700, 'Clave'),
(98, 9, 3932987427, '2020-08-08', '1', 'Efectivo', 0, 234, 'Clave'),
(99, 9, 3932987427, '2020-08-08', '1', 'Efectivo', 0, 234, 'Clave'),
(100, 10, 2787387498, '2020-08-08', '1', 'Efectivo', 0, 500, 'Clave'),
(101, 10, 2787387498, '2020-08-08', '1', 'Efectivo', 0, 500, 'Clave'),
(102, 11, 2787387498, '2020-08-08', '1', 'Efectivo', 0, 500, 'Clave'),
(103, 12, 3932987427, '2020-08-08', '1', 'Efectivo', 0, 234, 'Clave'),
(104, 12, 16283784794, '2020-08-08', '2', 'Efectivo', 0, 1136, 'Clave'),
(105, 13, 16283784794, '2020-08-08', '1', 'Efectivo', 0, 568, 'Clave'),
(106, 14, 3932987427, '2020-08-08', '1', 'Efectivo', 0, 234, 'Clave'),
(107, 14, 3932987427, '2020-08-08', '1', 'Efectivo', 0, 234, 'Clave'),
(108, 14, 3932987427, '2020-08-08', '1', 'Efectivo', 0, 234, 'Clave'),
(109, 15, 37897389738, '2020-08-08', '1', 'Efectivo', 0, 67, 'Clave'),
(110, 16, 2787387498, '2020-08-08', '1', 'Efectivo', 0, 500, 'Clave'),
(111, 16, 2787387498, '2020-08-08', '1', 'Efectivo', 0, 500, 'Clave'),
(112, 17, 1, '2020-08-08', '0', 'RETIRO', 0, 100, 'Clave');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `igualacion_inventario`
--

CREATE TABLE `igualacion_inventario` (
  `id_igualacion` bigint(13) NOT NULL,
  `id_producto` bigint(13) NOT NULL,
  `stock_sistema` bigint(13) NOT NULL,
  `stock_fisico` bigint(13) NOT NULL,
  `fechas` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `igualacion_inventario`
--

INSERT INTO `igualacion_inventario` (`id_igualacion`, `id_producto`, `stock_sistema`, `stock_fisico`, `fechas`) VALUES
(25, 16283784794, 0, 15, '2020-08-08'),
(26, 7501563381778, 0, 15, '2020-08-08'),
(27, 7502216796331, 0, 16, '2020-08-08');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `id_producto` bigint(15) NOT NULL,
  `descripcion` varchar(100) NOT NULL,
  `gramos` varchar(100) NOT NULL,
  `contenido` varchar(5) NOT NULL,
  `tipo` varchar(100) NOT NULL,
  `precio_proveedor` float NOT NULL,
  `precio_publico` float NOT NULL,
  `stock` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`id_producto`, `descripcion`, `gramos`, `contenido`, `tipo`, `precio_proveedor`, `precio_publico`, `stock`) VALUES
(1, 'Retiro', 'Retiro', 'Retir', 'Selecciona...', 0, 0, 0),
(2, 'Caja', 'Caja', 'Caja', 'Caja', 0, 0, 0),
(2787387498, 'Neo-Melubrina', '90mg', '20', 'Tabletas', 100, 500, -2),
(3932987427, 'Levofloxaxino', '10mg', '10', 'Tabletas', 100, 234, -3),
(16283784794, 'Nifedipino', '80mg', '8', 'tabletas', 45, 568, 3),
(37897389738, 'osvaldo es el mas puto ❤', '78', '89', 'Tabletas', 5, 67, 10),
(7501563381734, 'Nifedipino', '60mg', '15', 'Comprimidos', 45, 300, 55),
(7501563381771, 'Bioargirol-C', '1g', '30g', 'Crema', 20, 80, 8),
(7501563381778, 'Paracetamol', '600mg', '10', 'medico', 300, 800, 15),
(7502216796331, 'Nifedipino', '30mg', '30', 'Comprimidos', 50, 200, 16),
(7507824684627, 'Azitromicina', '500', '10', 'Tabletas', 50, 150, 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `prueba`
--

CREATE TABLE `prueba` (
  `id` int(10) NOT NULL,
  `id_producto` bigint(15) NOT NULL,
  `descripcion` varchar(100) NOT NULL,
  `gramos` varchar(100) NOT NULL,
  `contenido` varchar(10) NOT NULL,
  `tipo` varchar(100) NOT NULL,
  `precio_publico` float NOT NULL,
  `stock` varchar(10) NOT NULL,
  `cantidad` int(10) NOT NULL,
  `descuento` float DEFAULT NULL,
  `total` float NOT NULL,
  `usuario` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id` int(100) NOT NULL,
  `usuario` varchar(20) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(100) NOT NULL,
  `f_nacimiento` date NOT NULL,
  `telefono` bigint(20) NOT NULL,
  `contraseña` varchar(255) NOT NULL,
  `rol` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id`, `usuario`, `nombre`, `apellido`, `f_nacimiento`, `telefono`, `contraseña`, `rol`) VALUES
(1, 'Fededjpg', 'Federico de Jesus', 'Perez Gomez', '2020-07-06', 9613650067, '$2y$15$EOmuZQ.h85BSCAKAiEJFf.07CVnzguwjw1kEYTHAX1t2X/V3UNmMe', 'admin'),
(6, 'juanito', 'juan', 'pere', '2020-07-21', 98376378, '$2y$15$mT/bLFV2zYIRzgax5DRN1euFe8HiWcamPdypV1nngNqnPg8iqyAV2', 'cajero');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `entradas`
--
ALTER TABLE `entradas`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_producto` (`id_producto`);

--
-- Indices de la tabla `historial_farmacia`
--
ALTER TABLE `historial_farmacia`
  ADD PRIMARY KEY (`numero`,`folio`),
  ADD KEY `id_producto` (`id_producto`);

--
-- Indices de la tabla `igualacion_inventario`
--
ALTER TABLE `igualacion_inventario`
  ADD PRIMARY KEY (`id_igualacion`),
  ADD KEY `id_producto` (`id_producto`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`id_producto`);

--
-- Indices de la tabla `prueba`
--
ALTER TABLE `prueba`
  ADD KEY `id_producto` (`id_producto`),
  ADD KEY `id_producto_2` (`id_producto`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `usuario` (`usuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `entradas`
--
ALTER TABLE `entradas`
  MODIFY `id` bigint(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;

--
-- AUTO_INCREMENT de la tabla `historial_farmacia`
--
ALTER TABLE `historial_farmacia`
  MODIFY `numero` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=113;

--
-- AUTO_INCREMENT de la tabla `igualacion_inventario`
--
ALTER TABLE `igualacion_inventario`
  MODIFY `id_igualacion` bigint(13) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `entradas`
--
ALTER TABLE `entradas`
  ADD CONSTRAINT `entradas_ibfk_1` FOREIGN KEY (`id_producto`) REFERENCES `productos` (`id_producto`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `historial_farmacia`
--
ALTER TABLE `historial_farmacia`
  ADD CONSTRAINT `historial_farmacia_ibfk_1` FOREIGN KEY (`id_producto`) REFERENCES `productos` (`id_producto`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `igualacion_inventario`
--
ALTER TABLE `igualacion_inventario`
  ADD CONSTRAINT `igualacion_inventario_ibfk_1` FOREIGN KEY (`id_producto`) REFERENCES `productos` (`id_producto`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `prueba`
--
ALTER TABLE `prueba`
  ADD CONSTRAINT `prueba_ibfk_1` FOREIGN KEY (`id_producto`) REFERENCES `productos` (`id_producto`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
