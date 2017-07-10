USE MovieCatalogue;

CREATE TABLE Genre(
	GenreID INT NOT NULL auto_increment,
    GenreName VARCHAR(30) NOT NULL,
    PRIMARY KEY (GenreID)
);

CREATE TABLE Director(
	DirectorID INT NOT NULL auto_increment,
    DirectorFirstName VARCHAR(30) NOT NULL,
    DirectorLastName VARCHAR(30) NOT NULL,
    DirectoryBirthDate DATE NULL,
    PRIMARY KEY(DirectorID)
);

CREATE TABLE Rating(
	RatingID INT NOT NULL auto_increment,
    RatingName CHAR(5) NOT NULL,
    PRIMARY KEY(RatingID)
);

CREATE TABLE Actor(
	ActorID INT NOT NULL auto_increment,
    ActorFirstName VARCHAR(30) NOT NULL,
    ActorLastName VARCHAR(30) NOT NULL,
    ActorBirthDate DATE NULL,
    PRIMARY KEY(ActorID)
);

CREATE TABLE Movie(
	MovieID INT NOT NULL auto_increment,
    GenreID INT NOT NULL,
    DirectorID INT NOT NULL,
    RatingID INT NOT NULL,
    Title VARCHAR(128) NOT NULL,
    ReleaseDate DATE NULL,
    PRIMARY KEY(MovieID)
);

ALTER TABLE Movie
ADD CONSTRAINT fk_Movie_Genre
FOREIGN KEY (GenreID)
REFERENCES Genre(GenreID);

ALTER TABLE Movie
ADD CONSTRAINT fk_Movie_Director
FOREIGN KEY (DirectorID)
REFERENCES Director(DirectorID);

ALTER TABLE Movie
ADD CONSTRAINT fk_Movie_Rating
FOREIGN KEY (RatingID)
REFERENCES Rating(RatingID);

CREATE TABLE CastMember(
	CastMemberID INT NOT NULL auto_increment,
    ActorID INT NOT NULL,
    MovieID INT NOT NULL,
    Role VARCHAR(50) NOT NULL,
    PRIMARY KEY (CastMemberID)
);

ALTER TABLE CastMember
ADD CONSTRAINT fk_CastMember_Actor
FOREIGN KEY (ActorId)
REFERENCES Actor(ActorID);

ALTER TABLE CastMember
ADD CONSTRAINT fk_CastMember_Movie
FOREIGN KEY (MovieID)
REFERENCES Movie(MovieID);
