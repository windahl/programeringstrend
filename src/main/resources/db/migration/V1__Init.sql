CREATE TABLE LANGUAGE (
  ID INT NOT NULL AUTO_INCREMENT,
  NAME VARCHAR(255) NOT NULL ,
  PRIMARY KEY(ID)
);

CREATE TABLE REGION (
  ID INT NOT NULL AUTO_INCREMENT,
  NAME VARCHAR(255) NOT NULL,
  PRIMARY KEY (ID)
);

CREATE TABLE TREND (
  ID INT NOT NULL AUTO_INCREMENT,
  LANGUAGE_ID INT NOT NULL,
  REGION_ID INT NOT NULL,
  DATE DATE NOT NULL,
  NO_OF_JOBS INT NOT NULL,
  PRIMARY KEY (ID),
  FOREIGN KEY (LANGUAGE_ID) REFERENCES LANGUAGE(ID),
  FOREIGN KEY (REGION_ID) REFERENCES REGION(ID)
);

INSERT INTO LANGUAGE (NAME) VALUES ('Java');
INSERT INTO LANGUAGE (NAME) VALUES ('C#');
INSERT INTO LANGUAGE (NAME) VALUES ('Javascript');
INSERT INTO LANGUAGE (NAME) VALUES ('Ruby');
INSERT INTO LANGUAGE (NAME) VALUES ('Python');
INSERT INTO LANGUAGE (NAME) VALUES ('Scala');
INSERT INTO LANGUAGE (NAME) VALUES ('Clojure');
INSERT INTO LANGUAGE (NAME) VALUES ('Groovy');
INSERT INTO LANGUAGE (NAME) VALUES ('PHP');
INSERT INTO LANGUAGE (NAME) VALUES ('Cobol');
INSERT INTO LANGUAGE (NAME) VALUES ('C++');
INSERT INTO LANGUAGE (NAME) VALUES ('c');
INSERT INTO LANGUAGE (NAME) VALUES ('Objective-c');
INSERT INTO LANGUAGE (NAME) VALUES ('Swift');

INSERT INTO REGION (NAME) VALUES ('Stockholm');
INSERT INTO REGION (NAME) VALUES ('Göteborg');
INSERT INTO REGION (NAME) VALUES ('Malmö');

