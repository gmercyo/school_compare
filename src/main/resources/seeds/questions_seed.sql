-- Another brief seed, literally one entry in the DB just for testing but can expand later when needed --
DELETE FROM questions;

INSERT INTO questions (school_id, user_id, content, created_at)
VALUES (
    1,
    1,
    'This is an example question',
    NOW()
);