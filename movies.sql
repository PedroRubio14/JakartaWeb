-- phpMyAdmin SQL Dump
-- version 5.2.3
-- https://www.phpmyadmin.net/
--
-- Servidor: db
-- Tiempo de generación: 16-11-2025 a las 15:18:27
-- Versión del servidor: 8.0.44
-- Versión de PHP: 8.3.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `movies`
--
CREATE DATABASE IF NOT EXISTS `movies` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
USE `movies`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comments`
--

CREATE TABLE `comments` (
  `id` bigint NOT NULL,
  `movie_id` bigint NOT NULL,
  `comment_text` text NOT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `comments`
--

INSERT INTO `comments` (`id`, `movie_id`, `comment_text`, `created_at`) VALUES
(1, 1, 'Una de mis favoritas de la infancia. La magia sigue funcionando.', '2025-11-14 18:12:04'),
(2, 1, 'Hermione y Snape se roban todas las escenas.', '2025-11-14 18:12:04'),
(3, 2, 'El Delorean es un icono del cine. Imprescindible.', '2025-11-14 18:12:04'),
(4, 2, 'La mejor película de viajes en el tiempo, sin discusión.', '2025-11-14 18:12:04'),
(5, 3, 'Mind-blowing incluso 20 años después.', '2025-11-14 18:12:04'),
(6, 3, 'Neo es el elegido, pero Morfeo es el que manda.', '2025-11-14 18:12:04'),
(7, 4, 'Cada vez que la veo entiendo algo nuevo.', '2025-11-14 18:12:04'),
(8, 4, 'Hans Zimmer se pasó con la BSO. Brutal.', '2025-11-14 18:12:04'),
(9, 5, 'El Joker de Heath Ledger es insuperable.', '2025-11-14 18:12:04'),
(10, 5, 'La mejor película de superhéroes jamás hecha.', '2025-11-14 18:12:04'),
(11, 6, 'Diálogos legendarios. Una obra maestra.', '2025-11-14 18:12:04'),
(12, 6, 'Tarantino en su mejor momento.', '2025-11-14 18:12:04');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `movies`
--

CREATE TABLE `movies` (
  `id` bigint NOT NULL,
  `title` varchar(200) NOT NULL,
  `description` text,
  `year` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `movies`
--

INSERT INTO `movies` (`id`, `title`, `description`, `year`) VALUES
(1, 'Harry Potter', 'Abada kedabraaa', 2001),
(2, 'Back To The Future', 'Delorean goes brrrr', 1987),
(3, 'The Matrix', 'What is the Matrix?', 1999),
(4, 'Inception', 'A mind-bending thriller about dreams within dreams', 2010),
(5, 'The Dark Knight', 'Batman faces off against the Joker', 2008),
(6, 'Pulp Fiction', 'Multiple interconnected stories of crime and redemption', 1994),
(7, 'The Lord of the Rings: The Fellowship of the Ring', 'A hobbit begins an epic journey to destroy a powerful ring', 2001),
(8, 'The Godfather', 'A mafia family struggles for power in New York', 1972),
(9, 'Forrest Gump', 'A man with a low IQ experiences historical events', 1994),
(10, 'Fight Club', 'A disillusioned man forms an underground fight club', 1999),
(11, 'Jurassic Park', 'Scientists clone dinosaurs with disastrous results', 1993),
(12, 'Star Wars: A New Hope', 'A young farm boy becomes a hero in a galaxy far, far away', 1977),
(13, 'Gladiator', 'A Roman general seeks revenge after being betrayed', 2000),
(14, 'Avatar', 'A paraplegic marine is sent to a moon inhabited by a native tribe', 2009),
(15, 'The Avengers', 'Earth’s mightiest heroes team up to save the planet', 2012),
(16, 'Titanic', 'A romance aboard the ill-fated ship', 1997),
(17, 'The Shawshank Redemption', 'A man wrongly imprisoned fights for his freedom', 1994),
(18, 'Interstellar', 'A team of explorers travel through a wormhole in space', 2014),
(19, 'Braveheart', 'A Scottish warrior leads a rebellion against England', 1995),
(20, 'The Lion King', 'A young lion prince flees his kingdom after the murder of his father', 1994);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `comments`
--
ALTER TABLE `comments`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_comments_movie` (`movie_id`);

--
-- Indices de la tabla `movies`
--
ALTER TABLE `movies`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `comments`
--
ALTER TABLE `comments`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `movies`
--
ALTER TABLE `movies`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=40;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `comments`
--
ALTER TABLE `comments`
  ADD CONSTRAINT `fk_comments_movie` FOREIGN KEY (`movie_id`) REFERENCES `movies` (`id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
