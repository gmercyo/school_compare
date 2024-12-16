
CREATE TABLE REVIEWS (
id BIGSERIAL PRIMARY KEY,
school_id BIGINT,
user_id BIGINT,
role VARCHAR(255),
content VARCHAR(500),
created_at TIMESTAMP DEFAULT NOW(),
FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
FOREIGN KEY (school_id) REFERENCES schools(id) ON DELETE CASCADE
);

CREATE TABLE REVIEW_UPVOTES(
review_id BIGINT,
user_id BIGINT,
FOREIGN KEY (review_id) REFERENCES reviews(id) ON DELETE CASCADE,
FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);