CREATE TABLE product (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    price DECIMAL(19,2) NOT NULL,
    quantity INT NOT NULL,
    category VARCHAR(100),
    image_url VARCHAR(512)
);

INSERT INTO product (name, description, price, quantity, category, image_url) VALUES
('Apple iPhone 15', 'Latest model smartphone', 999.99, 10, 'Electronics', 'https://example.com/iphone15.jpg'),
('Samsung Galaxy S23', 'Flagship Android phone', 899.99, 15, 'Electronics', 'https://example.com/galaxys23.jpg'),
('Sony WH-1000XM5', 'Noise cancelling headphones', 349.99, 25, 'Audio', 'https://example.com/sonywh1000xm5.jpg'),
('Dell XPS 13', 'Ultrabook laptop', 1299.99, 5, 'Computers', 'https://example.com/dellxps13.jpg'),
('Nike Air Max', 'Popular running shoes', 149.99, 30, 'Footwear', 'https://example.com/nikeairmax.jpg');