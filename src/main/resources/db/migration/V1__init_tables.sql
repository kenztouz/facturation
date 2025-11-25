CREATE TABLE invoice (
                         id BIGINT PRIMARY KEY AUTO_INCREMENT,
                         order_id BIGINT NOT NULL,
                         amount DECIMAL(10,2) NOT NULL,
                         status VARCHAR(20) NOT NULL
);

CREATE TABLE payment (
                         id BIGINT PRIMARY KEY AUTO_INCREMENT,
                         invoice_id BIGINT NOT NULL,
                         amount DECIMAL(10,2) NOT NULL,
                         status VARCHAR(20),
                         method VARCHAR(50)
);
