CREATE TABLE users(
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
)
ENGINE = innoDB;

CREATE TABLE roles(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL
)
ENGINE = innoDB;

CREATE TABLE user_role(
    user_id INT NOT NULL,
    role_id INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (role_id) REFERENCES roles (id),
    UNIQUE (user_id,role_id)
)
ENGINE = innoDB;

INSERT INTO users VALUES (1,'anton','12345678');
INSERT INTO roles VALUES (1,'ROLE_USER'),(2,'ROLE_ADMIN');
INSERT INTO user_role VALUES (1,2);