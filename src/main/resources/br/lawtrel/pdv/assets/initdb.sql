CREATE TABLE IF NOT EXISTS users (
    username VARCHAR(255) PRIMARY KEY,
    password VARCHAR(255)
);

INSERT INTO users (username, password) VALUES ('admin', 'admin')
ON CONFLICT (username) DO NOTHING;
