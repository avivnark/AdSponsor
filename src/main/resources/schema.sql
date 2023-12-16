CREATE TABLE IF NOT EXISTS PRODUCTS (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255),
    category VARCHAR(255),
    price DECIMAL(10, 2),
    serial_number VARCHAR(20),
    INDEX idx_category(category), -- Index on category for optimization
    INDEX idx_price(price) -- Index on price for optimization
);

CREATE TABLE IF NOT EXISTS CAMPAIGNS (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    start_date DATE,
    bid DECIMAL(10, 2),
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
    ('Product 1', 'A', 25.00, 'P-00001'),
    ('Product 2', 'B', 15.50, 'P-00002'),
    ('Product 3', 'C', 30.75, 'P-00003'),
    ('Product 4', 'A', 18.25, 'P-00004');





