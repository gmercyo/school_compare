DELETE FROM answers;

INSERT INTO answers (school_id, user_id, question_id, content, role, created_at)
VALUES
(3, 1, 1, 'The student-to-teacher ratio is 25:1.', 'Teacher', NOW()),
(3, 1, 1, 'We aim for a student-to-teacher ratio of 20:1 to provide personalized attention.', 'Administrator', NOW());
