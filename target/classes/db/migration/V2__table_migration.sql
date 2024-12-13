DROP TABLE IF EXISTS schools;

CREATE TABLE schools (
id bigserial PRIMARY KEY,
name varchar(255),
address varchar(255),
latitude NUMERIC(8,6),
longitude NUMERIC(8,6),
catchment_radius JSONB,
ofsted_rating int,
ofsted_url varchar(255),
type varchar(255),
gender varchar(255),
sen_availability varchar(255),
religious_affiliation varchar(255),
website varchar(255)
);

DROP TABLE IF EXISTS users;

CREATE TABLE users (
id bigserial PRIMARY KEY,
username varchar(255),
auth0_id varchar(255)
);

DROP TABLE IF EXISTS questions;

CREATE TABLE questions (
id bigserial PRIMARY KEY,
school_id bigint,
user_id bigint,
content varchar(500),
created_at TIMESTAMP DEFAULT NOW(),
FOREIGN KEY (school_id) REFERENCES schools(id) ON DELETE CASCADE,
FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

DROP TABLE IF EXISTS answers;

CREATE TABLE answers (
id bigserial PRIMARY KEY,
school_id bigint,
user_id bigint,
question_id bigint,
content varchar(500),
created_at TIMESTAMP DEFAULT NOW(),
FOREIGN KEY (question_id) REFERENCES questions(id) ON DELETE CASCADE,
FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
FOREIGN KEY (school_id) REFERENCES schools(id) ON DELETE CASCADE
);

DROP TABLE IF EXISTS answer_upvotes;

CREATE TABLE answer_upvotes(
answer_id bigint,
user_id bigint,
FOREIGN KEY (answer_id) REFERENCES answers(id) ON DELETE CASCADE,
FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

DROP TABLE IF EXISTS question_likes;

CREATE TABLE question_likes(
question_id bigint,
user_id bigint,
FOREIGN KEY (question_id) REFERENCES questions(id),
FOREIGN KEY (user_id) REFERENCES users(id)
);

DROP TABLE IF EXISTS school_likes;

CREATE TABLE school_likes(
school_id bigint,
user_id bigint,
FOREIGN KEY (school_id) REFERENCES schools(id),
FOREIGN KEY (user_id) REFERENCES users(id)
);