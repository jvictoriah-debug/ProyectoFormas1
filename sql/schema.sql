-- Base de datos del ProyectoFormas
-- (El programa tambien crea las tablas solo si no existen)

CREATE DATABASE IF NOT EXISTS proyecto_formas;
USE proyecto_formas;

CREATE TABLE IF NOT EXISTS figuras (
    id INT AUTO_INCREMENT PRIMARY KEY,
    tipo VARCHAR(20),
    medida1 DOUBLE,
    medida2 DOUBLE,
    medida3 DOUBLE
);

CREATE TABLE IF NOT EXISTS cuerpos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    tipo VARCHAR(20),
    medida1 DOUBLE,
    medida2 DOUBLE
);
