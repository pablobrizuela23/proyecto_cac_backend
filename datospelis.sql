-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 03-07-2024 a las 16:08:37
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `datospelis`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `peliculas`
--

CREATE TABLE `peliculas` (
  `id_pelicula` int(11) NOT NULL,
  `titulo` varchar(100) NOT NULL,
  `fecha_estreno` varchar(60) NOT NULL,
  `genero` varchar(15) NOT NULL,
  `duracion` varchar(15) NOT NULL,
  `director` varchar(100) NOT NULL,
  `reparto` varchar(100) NOT NULL,
  `sinopsis` text NOT NULL,
  `imagen` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

--
-- Volcado de datos para la tabla `peliculas`
--

INSERT INTO `peliculas` (`id_pelicula`, `titulo`, `fecha_estreno`, `genero`, `duracion`, `director`, `reparto`, `sinopsis`, `imagen`) VALUES
(5, 'spiderman 4', '20/08/2024', 'fantasia', '2h 30m', 'robert olivas', 'tom holand', 'Nueva entrega de spiderman', 'http://ejemplo.com/imagen2.jpg'),
(6, 'Aquaman', '18/05/2024', 'Accion Superher', '1h80m', 'James Wan', 'Jason Momoa', 'Mitad humano ,mitad atlante,Arthur Curry es un habitante del poderoso reino de la Atlantida.Arthur emprendera un viaje que lo ayudara a descubrir si es digno de cumplir con su destino: Ser rey y convertirse en Aquaman!! ', ''),
(7, 'Godzilla vs Kong', '08/08/2024', 'Fantasia', '2h 50m', 'Adam Wingard', 'Millie Bobby Br', 'Godzilla y Kong dos de las fuerzas mas poderosas, se enfrentan en un espectacular combate que sacude a la humanidad.Monarch un cientifico se embarca en una mision de alto riesgo para descubrir los origenes de estos dos titanes y salvar a estas dos bestias que parece tener las horas contadas sobre la faz de la Tierra', ''),
(8, 'Planeta de los Simios', '06/07/2024', '  Accion', '2h 50m', 'Well Ball', 'Freya Allan', 'Situada varias generaciones en el futuro tras el reinado de Cesar,en el que los simios son la especie dominante que viven en armonía y los humanos han quedado reducidos a vivir en las sombras. Un nuevo y tiránico líder simio construye su imperio, mientras un joven simio emprende un viaje que lo llevara a cuestionarse sobre todo lo que sabe y tomar decisiones que definirán el futuro de simios y humanos.', '');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `peliculas`
--
ALTER TABLE `peliculas`
  ADD PRIMARY KEY (`id_pelicula`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `peliculas`
--
ALTER TABLE `peliculas`
  MODIFY `id_pelicula` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
