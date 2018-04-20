DROP TABLE IF EXISTS assassin.admins;
DROP TABLE IF EXISTS assassin.members;
DROP TABLE IF EXISTS assassin.hits;

CREATE TABLE IF NOT EXISTS assassin.admins (
  id INT(70) NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  surname VARCHAR(45) NOT NULL,
  email VARCHAR(45) UNIQUE NOT NULL,
  password VARCHAR(45) NOT NULL,
  PRIMARY KEY (id)
);


CREATE TABLE IF NOT EXISTS assassin.members (
  id INT(70) NOT NULL AUTO_INCREMENT,
  name INT(70) NOT NULL,
  surname VARCHAR(45) NOT NULL,
  email VARCHAR(45) UNIQUE NOT NULL,
  gender VARCHAR(45) NULL,
  userType VARCHAR(45) NULL,
  registrationDate DATE NULL,
  PRIMARY KEY (id)
);


CREATE TABLE IF NOT EXISTS assassin.hits (
  id INT(70) NOT NULL AUTO_INCREMENT,
  codename VARCHAR(70) UNIQUE NOT NULL,
  address VARCHAR(75) NOT NULL,
  status VARCHAR(45) NOT NULL,
  amount DOUBLE,
  registrationDate DATE NULL,
  PRIMARY KEY (id),
  CONSTRAINT users_id FOREIGN KEY (id) REFERENCES users(id),
  CONSTRAINT admin_id FOREIGN KEY (id) REFERENCES admins(id)
);
