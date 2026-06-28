DROP DATABASE IF EXISTS db_tienda_videojuegos;

-- 1. Crear la base de datos
CREATE DATABASE db_tienda_videojuegos;
USE db_tienda_videojuegos;

-- 2. Crear la tabla de categorías (Se queda idéntica a la tuya)
CREATE TABLE tbl_categoria (
    id_categoria INT AUTO_INCREMENT PRIMARY KEY,
    nombre_categoria VARCHAR(50) NOT NULL
);

-- 3. Crear la tabla de juegos (Se queda idéntica a la tuya)
CREATE TABLE tbl_juego (
    id_juego INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    precio DECIMAL(10, 2) NOT NULL,
    id_categoria INT,
    FOREIGN KEY (id_categoria) REFERENCES tbl_categoria(id_categoria)
);

-- 4. Crear la tabla de compras 
CREATE TABLE tbl_compra (
    id_compra INT AUTO_INCREMENT PRIMARY KEY,
    fecha_compra DATETIME DEFAULT CURRENT_TIMESTAMP,
    id_juego INT,
    cantidad INT NOT NULL,
    total DECIMAL(10, 2),
    FOREIGN KEY (id_juego) REFERENCES tbl_juego(id_juego)
);

-- 5. Crear la tabla de usuarios
CREATE TABLE tbl_usuario (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    usuario VARCHAR(50) NOT NULL,
    clave VARCHAR(50) NOT NULL
);

-- Insertar tu usuario original
INSERT INTO tbl_usuario(usuario, clave)
VALUES ('Admin', '1234');


INSERT INTO tbl_categoria (nombre_categoria) VALUES 
('Acción / Shooters'),         -- ID 1
('Rol (RPG)'),                 -- ID 2
('Estrategia (RTS)'),          -- ID 3
('Aventura / Mundo Abierto'),  -- ID 4
('Simulación y Deportes');     -- ID 5

CREATE TABLE tbl_boleta (
    id_boleta INT AUTO_INCREMENT PRIMARY KEY,
    fecha_boleta DATETIME,
    total_boleta DECIMAL(10,2)
);

CREATE TABLE tbl_detalle_boleta (
    id_detalle INT AUTO_INCREMENT PRIMARY KEY,
    id_boleta INT NOT NULL,
    id_juego INT NOT NULL,
    cantidad INT,
    precio_unitario DECIMAL(10,2),
    subtotal DECIMAL(10,2),
    FOREIGN KEY (id_boleta) REFERENCES tbl_boleta(id_boleta),
    FOREIGN KEY (id_juego) REFERENCES tbl_juego(id_juego)
);


INSERT INTO tbl_juego (titulo, precio, id_categoria) VALUES
-- Categoría 1: Acción / Shooters
('Call of Duty', 69.99, 1),
('Fortnite', 0.00, 1),
('Doom Eternal', 39.99, 1),
('Overwatch 2', 0.00, 1),
('Halo Infinite', 59.99, 1),

-- Categoría 2: Rol (RPG)
('Final Fantasy', 69.99, 2),
('The Witcher', 39.99, 2),
('Cyberpunk 2077', 59.99, 2),
('Elden Ring', 59.99, 2),
('Diablo IV', 69.99, 2),

-- Categoría 3: Estrategia (RTS)
('Age of Empires', 29.99, 3),
('StarCraft II', 0.00, 3),
('Civilization VI', 19.99, 3),
('Total War: Warhammer III', 59.99, 3),

-- Categoría 4: Aventura / Mundo Abierto
('The Legend of Zelda', 59.99, 4),
('Minecraft', 29.99, 4),
('Grand Theft Auto V', 29.99, 4),
('God of War Ragnarök', 59.99, 4),
('Red Dead Redemption 2', 39.99, 4),

-- Categoría 5: Simulación y Deportes
('EA Sports FC', 69.99, 5),
('Microsoft Flight Simulator', 59.99, 5),
('NBA 2K26', 59.99, 5),
('Forza Horizon 5', 49.99, 5),
('The Sims 4', 0.00, 5);