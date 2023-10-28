INSERT INTO faculties (name) VALUES ('Ingeniería');
INSERT INTO faculties (name) VALUES ('Negocios');
INSERT INTO faculties (name) VALUES ('Ciencias de Salud');
INSERT INTO faculties (name) VALUES ('Comunicaciones');

INSERT INTO careers(name, faculty_id) VALUES ('Ingeniería de Software', 1);
INSERT INTO careers(name, faculty_id) VALUES ('Ingeniería de Sistemas de información', 1);

INSERT INTO students (last_name, first_name, tiu, num_documento, birth_date, level, career_id)
VALUES ('Rosales', 'Cesar Augusto', '202015698', '71829345','2000-01-15', 5, 1);
INSERT INTO students (last_name, first_name, tiu, num_documento, birth_date, level, career_id)
VALUES ('Maquera Rosas', 'Esperanza', '201921123', '76938245','1999-05-23', 6, 2);