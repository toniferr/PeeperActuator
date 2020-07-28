/*CREATE TABLE developer (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  image VARCHAR(250) DEFAULT NULL
);*/

INSERT INTO developer (id,first_name, last_name, image) VALUES
  (1,'Toni', 'Ferreiro', 'luigi.png');
  
/*CREATE TABLE projectCategory (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL
);*/

INSERT INTO category (id,name) VALUES
  (1,'SpringBoot'),
  (2,'SpringMVC'),
  (3,'Struts 2'),
  (4,'Java'),
  (5,'Maven')
;
  
/*CREATE TABLE project (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  subtitle VARCHAR(250) NOT NULL,
  description VARCHAR(2000) NOT NULL,
  license VARCHAR(250) DEFAULT NULL,
  imageUrl VARCHAR(250) DEFAULT NULL,
  developerId INT,
  FOREIGN KEY (developerId) REFERENCES developer(id)
);*/

INSERT INTO project (id,name, subtitle, description, license, image_url, developer_id) VALUES
  (1,'EurosNovos', 'SpringBoot Application', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed
	        								do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut
	        								enim ad minim veniam, quis nostrud exercitation ullamco laboris
	        								nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in
	        								reprehenderit in voluptate velit esse cillum dolore eu fugiat
	        								nulla pariatur. Excepteur sint occaecat cupidatat non proident,
	        							    sunt in culpa qui officia deserunt mollit anim id est laborum.', 'GNU v.3', 'eurosnovos.jpg', 1),
  (2,'Cryptokit', 'Java Swing with JCA and BouncyCastle', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed
	        								do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut
	        								enim ad minim veniam, quis nostrud exercitation ullamco laboris
	        								nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in
	        								reprehenderit in voluptate velit esse cillum dolore eu fugiat
	        								nulla pariatur. Excepteur sint occaecat cupidatat non proident,
	        							    sunt in culpa qui officia deserunt mollit anim id est laborum.', 'GNU v.3', 'cryptokit.jpg', 1),
  (3,'Setup-Makeup', 'Spring MVC application (xml conf) and Tiles', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed
	        								do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut
	        								enim ad minim veniam, quis nostrud exercitation ullamco laboris
	        								nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in
	        								reprehenderit in voluptate velit esse cillum dolore eu fugiat
	        								nulla pariatur. Excepteur sint occaecat cupidatat non proident,
	        							    sunt in culpa qui officia deserunt mollit anim id est laborum.', 'GNU v.3', 'setup-makeup.jpg', 1),
  (4,'Setup-Tecnorepo', 'Struts 2 application', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed
	        								do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut
	        								enim ad minim veniam, quis nostrud exercitation ullamco laboris
	        								nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in
	        								reprehenderit in voluptate velit esse cillum dolore eu fugiat
	        								nulla pariatur. Excepteur sint occaecat cupidatat non proident,
	        							    sunt in culpa qui officia deserunt mollit anim id est laborum.', 'GNU v.3', 'setup-tecnorepo.jpg', 1),
  (5,'Peeperjava', 'Maven project with multiple Java versions', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed
	        								do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut
	        								enim ad minim veniam, quis nostrud exercitation ullamco laboris
	        								nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in
	        								reprehenderit in voluptate velit esse cillum dolore eu fugiat
	        								nulla pariatur. Excepteur sint occaecat cupidatat non proident,
	        							    sunt in culpa qui officia deserunt mollit anim id est laborum.', 'Apache', 'peeperjava.jpg', 1),
  (6,'Peepermaven', 'Maven projects with multiple elements of Maven', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed
	        								do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut
	        								enim ad minim veniam, quis nostrud exercitation ullamco laboris
	        								nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in
	        								reprehenderit in voluptate velit esse cillum dolore eu fugiat
	        								nulla pariatur. Excepteur sint occaecat cupidatat non proident,
	        							    sunt in culpa qui officia deserunt mollit anim id est laborum.', 'Apache', 'peepermaven.jpg', 1);

/*CREATE TABLE project_category (
    projectID INT NOT NULL,
    categoryID INT NOT NULL,
    FOREIGN KEY (projectID) REFERENCES project(id), 
    FOREIGN KEY (categoryID) REFERENCES category(id),
    UNIQUE (projectID, categoryID)
);*/

INSERT INTO project_category (project_id, category_id) VALUES
  (1,1),
  (1,5),
  (2,4),
  (2,5),
  (3,2),
  (3,5),
  (4,3),
  (4,5),
  (5,4),
  (6,5);
