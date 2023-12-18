CREATE TABLE IF NOT EXISTS PRODUCTS (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    category VARCHAR(255) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    serial_number VARCHAR(20) NOT NULL,
    INDEX idx_category(category), -- Index on category for optimization
    INDEX idx_price(price) -- Index on price for optimization
);

CREATE TABLE IF NOT EXISTS CAMPAIGNS (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    start_date DATE NOT NULL,
    bid DECIMAL(10, 2) NOT NULL,
    active BOOLEAN DEFAULT TRUE, -- Defaulting active status to true
    INDEX idx_active(active), -- Index on active for optimization
    INDEX idx_start_date(start_date) -- Index on start_date for optimization
);



CREATE TABLE  IF NOT EXISTS Campaign_Products (
    campaign_id INT NOT NULL,
    product_id INT NOT NULL,
    PRIMARY KEY (campaign_id, product_id),
    FOREIGN KEY (campaign_id) REFERENCES Campaigns(id),
    FOREIGN KEY (product_id) REFERENCES Products(id)
);


INSERT INTO PRODUCTS (title, category, price, serial_number)
VALUES
    ('Premium Smartphone', 'Electronics', 799.99, 'P-00123'),
    ('Designer Watch', 'Fashion', 499.50, 'P-00234'),
    ('High-Performance Laptop', 'Electronics', 1299.99, 'P-00345'),
    ('Professional Camera', 'Electronics', 1499.75, 'P-00456'),
    ('Luxury Handbag', 'Fashion', 799.25, 'P-00567'),
    ('Gourmet Coffee Maker', 'Home & Kitchen', 399.99, 'P-00678'),
    ('Fitness Tracker', 'Health & Fitness', 159.50, 'P-00789'),
    ('Smart Home Speaker System', 'Electronics', 299.50, 'P-00890'),
    ('Stylish Sunglasses', 'Fashion', 199.25, 'P-00901'),
    ('Gaming Console', 'Electronics', 499.99, 'P-01012');






