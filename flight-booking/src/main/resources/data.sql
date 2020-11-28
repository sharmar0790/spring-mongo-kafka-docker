--insert into exchange_value(id,currency_from,currency_to,conversion_multiple)
--values(10001,'USD','INR',65);
--insert into exchange_value(id,currency_from,currency_to,conversion_multiple)
--values(10002,'EUR','INR',75);
--insert into exchange_value(id,currency_from,currency_to,conversion_multiple)
--values(10003,'AUD','INR',25);


DROP TABLE IF EXISTS bookings;

CREATE TABLE bookings(
  id           INT AUTO_INCREMENT  PRIMARY KEY,
  name         VARCHAR(250) NOT NULL,
  age          INT NOT NULL,
  gender       VARCHAR(250) DEFAULT NULL,
  email        VARCHAR(250) DEFAULT NULL,
  reference_id VARCHAR(250) DEFAULT NULL
);

--INSERT INTO billionaires (first_name, last_name, career) VALUES
--('Aliko', 'Dangote', 'Billionaire Industrialist'),
--('Bill', 'Gates', 'Billionaire Tech Entrepreneur'),
--('Folrunsho', 'Alakija', 'Billionaire Oil Magnate');


