-- Create the database if it doesn't exist
CREATE DATABASE IF NOT EXISTS bdfilmsa24;

-- Create user with password 'ok' and allow connection from any host (%)
CREATE USER IF NOT EXISTS 'root'@'localhost' IDENTIFIED BY 'ok';

-- Grant all privileges on the database to the user
GRANT ALL PRIVILEGES ON bdfilmsa24.* TO 'root'@'%';

-- If you also want to allow local connections
CREATE USER IF NOT EXISTS 'root'@'localhost' IDENTIFIED BY 'ok';
GRANT ALL PRIVILEGES ON bdfilmsa24.* TO 'root'@'localhost';

-- Make the privilege changes take effect immediately
FLUSH PRIVILEGES;

-- Show the created user to verify
SELECT User, Host FROM mysql.user WHERE User = 'root';

-- Show the granted privileges
SHOW GRANTS FOR 'root'@'%';
