DROP DATABASE IF EXISTS hero_sightings_test;
CREATE DATABASE hero_sightings_test;
USE hero_sightings_test;

CREATE TABLE hero_villain(
	hero_villain_id INT NOT NULL auto_increment,
    hero_villain_name VARCHAR(45) NOT NULL,
    hero_villain_description VARCHAR(75) NOT NULL,
    hero_villain_superpower VARCHAR(25) NOT NULL,
    PRIMARY KEY(hero_villain_id)
    );
    
CREATE TABLE organization(
	organization_id INT NOT NULL auto_increment,
    organization_name VARCHAR(30) NOT NULL,
    organization_description VARCHAR(50) NOT NULL,
    organization_address VARCHAR(45) NOT NULL,
    organization_city VARCHAR(45) NOT NULL,
    organization_state VARCHAR(25) NOT NULL,
    organization_phone VARCHAR(15) NOT NULL,
    organization_email VARCHAR(256) NOT NULL,
    PRIMARY KEY(organization_id)
    );
    
CREATE TABLE hero_villain_organization(
	hero_villain_id INT NOT NULL,
    organization_id INT NOT NULL,
    PRIMARY KEY(hero_villain_id, organization_id)
);
ALTER TABLE hero_villain_organization
ADD CONSTRAINT fk_hvo_hvId
FOREIGN KEY (hero_villain_id)
REFERENCES hero_villain(hero_villain_id);

ALTER TABLE hero_villain_organization
ADD CONSTRAINT fk_hvo_orgId
FOREIGN KEY (organization_id)
REFERENCES organization(organization_id);

CREATE TABLE location(
	location_id INT NOT NULL auto_increment,
    location_name VARCHAR(25) NOT NULL,
    location_description VARCHAR(75) NOT NULL,
    location_address VARCHAR(75) NOT NULL,
    location_city VARCHAR(45) NOT NULL,
    location_state VARCHAR(25) NOT NULL,
    location_latitude VARCHAR(45) NOT NULL,
    location_longitude VARCHAR(45) NOT NULL,
    PRIMARY KEY(location_id)
);

CREATE TABLE sighting(
	sighting_id INT NOT NULL auto_increment,
    hero_villain_id INT NOT NULL,
    location_id INT NOT NULL,
    sighting_date DATE NOT NULL,
    PRIMARY KEY(sighting_id)
);
ALTER TABLE sighting
ADD CONSTRAINT fk_sighting_hvId
FOREIGN KEY (hero_villain_id)
REFERENCES hero_villain(hero_villain_id);

ALTER TABLE sighting
ADD CONSTRAINT fk_sighting_locationId
FOREIGN KEY (location_id)
REFERENCES location(location_id);


    
    
    
    