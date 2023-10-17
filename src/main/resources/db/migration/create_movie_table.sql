CREATE TABLE MOVIE_TABLE (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255),
    description TEXT,
    rating DECIMAL(3, 1),
    image VARCHAR(255),
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);