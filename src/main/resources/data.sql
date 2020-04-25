DROP TABLE IF EXISTS customer_lead;
 
CREATE TABLE customer_lead (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  mobile VARCHAR(250) DEFAULT NULL,
  email VARCHAR(250) DEFAULT NULL,
  location_type VARCHAR(250) DEFAULT NULL,
  location_string VARCHAR(250) DEFAULT NULL,
  status VARCHAR(250) DEFAULT NULL
  
);
 
-- INSERT INTO customer_lead (first_name, last_name, mobile,email,location_type,location_string,status) VALUES
--  ('Aliko', 'Dangote', '7871771404','krishnasep92@gmail.com','COUNTRY','IND','CREATED'),
--  ('Bill', 'Gates', '7871771404','krishnasep92@gmail.com','CITY','IND','CREATED'),
--  ('Folrunsho', 'Alakija', '7871771404','krishnasep92@gmail.com','ZIP','IND','CREATED');