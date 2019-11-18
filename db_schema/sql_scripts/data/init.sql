INSERT INTO teacher_roles (id, name) VALUES
 (nextval('teacher_roles_seq'), 'TEACHER'),
 (nextval('teacher_roles_seq'), 'MANAGER'),
 (nextval('teacher_roles_seq'), 'ADMIN');

INSERT INTO teachers (id, first_name, last_name, school_id, email, phone, role_id, username, "password") VALUES
 (nextval('teachers_seq'), 'Sierhii', 'Riezvan', '1111111', 'mazyaserg@gmail.com', '0999291713',
 (select id from teacher_roles where name = 'ADMIN'), 'admin', '$2a$10$JRCqf.0YBrTkbnYDjROUS.Eba7E2b406Sdvnu5FM4lJ79/o7d9ypG');