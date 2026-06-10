DROP TABLE IF EXISTS usuarios;
DROP TABLE IF EXISTS actividades;
DROP TABLE IF EXISTS reservas;
DROP TABLE IF EXISTS incidencias;


CREATE TABLE IF NOT EXISTS usuarios (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    nombre TEXT,
    email TEXT,
    telefono TEXT,
    dni TEXT,
    tipoUsuario TEXT
);

CREATE TABLE IF NOT EXISTS actividades (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    nombre TEXT,
    tipoActividad TEXT,
    duracion INTEGER,
    precio REAL,
    plazasMaximas INTEGER,
    plazasOcupadas INTEGER
);

CREATE TABLE IF NOT EXISTS reservas (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    idUsuario INTEGER,
    idActividad INTEGER,
    fecha TEXT,
    estado TEXT
);

CREATE TABLE IF NOT EXISTS incidencias (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    idUsuario INTEGER,
    asunto TEXT,
    descripcion TEXT,
    fecha TEXT,
    estado TEXT
);