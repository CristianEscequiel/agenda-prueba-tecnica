INSERT INTO personas (nombre, apellido, email, telefono, ciudad)
VALUES ('Juan', 'Perez', 'juan.perez@gmail.com', 1123456789, 'Buenos Aires')
    ON CONFLICT (email) DO NOTHING;

INSERT INTO personas (nombre, apellido, email, telefono, ciudad)
VALUES ('Maria', 'Gomez', 'maria.gomez@gmail.com', 1134567890, 'Cordoba')
    ON CONFLICT (email) DO NOTHING;

INSERT INTO personas (nombre, apellido, email, telefono, ciudad)
VALUES ('Carlos', 'Lopez', 'carlos.lopez@gmail.com', 1145678901, 'Rosario')
    ON CONFLICT (email) DO NOTHING;

INSERT INTO personas (nombre, apellido, email, telefono, ciudad)
VALUES ('Ana', 'Martinez', 'ana.martinez@gmail.com', 1156789012, 'Mendoza')
    ON CONFLICT (email) DO NOTHING;

INSERT INTO personas (nombre, apellido, email, telefono, ciudad)
VALUES ('Lucas', 'Fernandez', 'lucas.fernandez@gmail.com', 1167890123, 'Buenos Aires')
    ON CONFLICT (email) DO NOTHING;

INSERT INTO personas (nombre, apellido, email, telefono, ciudad)
VALUES ('Sofia', 'Rodriguez', 'sofia.rodriguez@gmail.com', 1178901234, 'Cordoba')
    ON CONFLICT (email) DO NOTHING;

INSERT INTO personas (nombre, apellido, email, telefono, ciudad)
VALUES ('Diego', 'Sanchez', 'diego.sanchez@gmail.com', 1189012345, 'La Plata')
    ON CONFLICT (email) DO NOTHING;

INSERT INTO personas (nombre, apellido, email, telefono, ciudad)
VALUES ('Valentina', 'Diaz', 'valentina.diaz@gmail.com', 1190123456, 'Mar del Plata')
    ON CONFLICT (email) DO NOTHING;

INSERT INTO personas (nombre, apellido, email, telefono, ciudad)
VALUES ('Juan', 'Gonzalez', 'juan.gonzalez@gmail.com', 1122223333, 'Cordoba')
    ON CONFLICT (email) DO NOTHING;

INSERT INTO personas (nombre, apellido, email, telefono, ciudad)
VALUES ('Camila', 'Torres', 'camila.torres@gmail.com', 1133334444, 'Buenos Aires')
    ON CONFLICT (email) DO NOTHING;

INSERT INTO empresas (nombre, cuit, ciudad)
VALUES ('Tech Solutions', '30-71234567-1', 'Buenos Aires')
    ON CONFLICT (cuit) DO NOTHING;

INSERT INTO empresas (nombre, cuit, ciudad)
VALUES ('Industrias Metalurgicas SA', '30-69874521-4', 'Cordoba')
    ON CONFLICT (cuit) DO NOTHING;

INSERT INTO empresas (nombre, cuit, ciudad)
VALUES ('Logistica del Sur', '30-74589632-7', 'Rosario')
    ON CONFLICT (cuit) DO NOTHING;

INSERT INTO empresas (nombre, cuit, ciudad)
VALUES ('Distribuidora Central', '30-78965412-0', 'Mendoza')
    ON CONFLICT (cuit) DO NOTHING;

INSERT INTO empresas (nombre, cuit, ciudad)
VALUES ('Servicios Informaticos SRL', '30-70112233-5', 'La Plata')
    ON CONFLICT (cuit) DO NOTHING;