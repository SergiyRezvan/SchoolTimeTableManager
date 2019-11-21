DROP TABLE IF EXISTS lessons;
DROP TABLE IF EXISTS subjects;
DROP TABLE IF EXISTS classes;
DROP TABLE if EXISTS activities;
DROP TABLE IF EXISTS schedules;
DROP TABLE IF EXISTS teachers;
DROP TABLE IF EXISTS teachers_role;
DROP TABLE IF EXISTS schools;

CREATE TABLE schools (
	id bigint NOT NULL,
	"name" varchar(100) NULL,
	description text NULL,
	phone varchar(20) NULL,
	address varchar(100) NULL,
	email varchar(50) NULL,
	director varchar(100) NULL,
	website varchar(150) NULL,
	CONSTRAINT schools_pk PRIMARY KEY (id)
);

DROP SEQUENCE IF EXISTS schools_seq;
CREATE SEQUENCE schools_seq
    START 1
    INCREMENT 1
    NO MAXVALUE
    CACHE 1;

CREATE TABLE schedules (
	id bigint NOT NULL,
	school_id bigint NOT NULL,
	actual_from date NULL,
	actual_to date NULL,
	is_exceptional bool default FALSE,
	CONSTRAINT schedules_pk PRIMARY KEY (id)
);

DROP SEQUENCE IF EXISTS schedules_seq;
CREATE SEQUENCE schedules_seq
    START 1
    INCREMENT 1
    NO MAXVALUE
    CACHE 1;

CREATE TABLE teacher_roles (
	id bigint NOT NULL,
	"name" varchar(20) NULL,
	CONSTRAINT teacher_roles_pk PRIMARY KEY (id)
);

DROP SEQUENCE IF EXISTS teacher_roles_seq;
CREATE SEQUENCE teacher_roles_seq
    START 1
    INCREMENT 1
    NO MAXVALUE
    CACHE 1;

CREATE TABLE teachers (
	id bigint NOT NULL,
	first_name varchar(20) NULL,
	last_name varchar(20) NULL,
	school_id bigint NOT NULL,
	email varchar(50) NULL,
	phone varchar(20) NULL,
	role_id bigint NOT NULL,
	username varchar(20) NULL,
	"password" varchar(100) NULL,
	is_deleted bool default FALSE,
	CONSTRAINT teachers_pk PRIMARY KEY (id),
	CONSTRAINT teachers_fk FOREIGN KEY (role_id) REFERENCES teacher_roles(id)
);

DROP SEQUENCE IF EXISTS teachers_seq;
CREATE SEQUENCE teachers_seq
    START 1
    INCREMENT 1
    NO MAXVALUE
    CACHE 1;

CREATE TABLE activities (
	id bigint NOT NULL,
	school_id bigint NOT NULL,
	start_from time NULL,
	end_at time NULL,
	"name" varchar(50) NULL,
	CONSTRAINT activities_pk PRIMARY KEY (id)
);

DROP SEQUENCE IF EXISTS activities_seq;
CREATE SEQUENCE activities_seq
    START 1
    INCREMENT 1
    NO MAXVALUE
    CACHE 1;

CREATE TABLE classes (
	id bigint NOT NULL,
	"name" varchar(50) NULL,
	school_id bigint NOT NULL,
	CONSTRAINT classes_pk PRIMARY KEY (id)
);

DROP SEQUENCE IF EXISTS classes_seq;
CREATE SEQUENCE classes_seq
    START 1
    INCREMENT 1
    NO MAXVALUE
    CACHE 1;

CREATE TABLE subjects (
	id bigint NOT NULL,
	school_id bigint NOT NULL,
	teacher_id bigint NOT NULL,
	class_id bigint NOT NULL,
	hours_per_week int4 NULL,
	CONSTRAINT subjects_pk PRIMARY KEY (id),
	CONSTRAINT subjects_fk_1 FOREIGN KEY (teacher_id) REFERENCES teachers(id),
	CONSTRAINT subjects_fk_2 FOREIGN KEY (class_id) REFERENCES classes(id)
);

DROP SEQUENCE IF EXISTS subjects_seq;
CREATE SEQUENCE subjects_seq
    START 1
    INCREMENT 1
    NO MAXVALUE
    CACHE 1;

CREATE TABLE lessons (
	id bigint NOT NULL,
	school_id bigint NOT NULL,
	short_description varchar(50) NULL,
	"day" varchar(20) NULL,
	activity_id bigint NOT NULL,
	subject_id bigint NOT NULL,
	class_id bigint NOT NULL,
	schedule_id bigint NOT NULL,
	CONSTRAINT lessons_pk PRIMARY KEY (id),
	CONSTRAINT lessons_fk_1 FOREIGN KEY (class_id) REFERENCES classes(id),
	CONSTRAINT lessons_fk_2 FOREIGN KEY (subject_id) REFERENCES subjects(id),
	CONSTRAINT lessons_fk_3 FOREIGN KEY (schedule_id) REFERENCES schedules(id),
	CONSTRAINT lessons_fk_4 FOREIGN KEY (activity_id) REFERENCES activities(id)
);

DROP SEQUENCE IF EXISTS lessons_seq;
CREATE SEQUENCE lessons_seq
    START 1
    INCREMENT 1
    NO MAXVALUE
    CACHE 1;
