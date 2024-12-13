CREATE TABLE users (
  id bigserial PRIMARY KEY,
  username varchar(63) NOT NULL,
  auth0_username varchar(63)
);
