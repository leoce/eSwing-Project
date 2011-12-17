drop table es_ESClub;
drop table es_ESPlayerClub;
create table es_ESClub (
	clubId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	clubName VARCHAR(75) null,
	clubDesc VARCHAR(75) null,
	loft INTEGER,
	nomSr INTEGER,
	nomSpeed INTEGER,
	launchAngle INTEGER,
	coR DOUBLE,
	weight INTEGER,
	model VARCHAR(75) null,
	active_ BOOLEAN,
	createDate DATE null,
	modifiedDate DATE null
);

create table es_ESPlayerClub (
	playerClubId LONG not null primary key,
	clubId LONG,
	playerId LONG,
	companyId LONG,
	groupId LONG,
	userId LONG,
	clubDesc VARCHAR(75) null,
	loft INTEGER,
	nomSr INTEGER,
	nomSpeed INTEGER,
	coR DOUBLE,
	weight INTEGER,
	model VARCHAR(75) null,
	active_ BOOLEAN,
	createDate DATE null,
	modifiedDate DATE null
);

create table es_ESPlayerShotData (
	shotDataId LONG not null primary key,
	playerId LONG,
	playerClubId LONG,
	productSerialNo INTEGER,
	launchMonitor BOOLEAN,
	simulate BOOLEAN,
	active_ BOOLEAN,
	clubLoft INTEGER,
	clubSpeed INTEGER,
	faceAngle INTEGER,
	swingPath INTEGER,
	spinAxisAngle INTEGER,
	launchAngle INTEGER,
	ballSpeed INTEGER,
	ballSpinRate INTEGER,
	ballAngleOfAttack DOUBLE,
	ballCompression DOUBLE,
	stepTimeIncrement DOUBLE,
	windSpeed INTEGER,
	windDirection INTEGER,
	ambientTemp INTEGER,
	barPressureAlt INTEGER,
	relativeHumid INTEGER,
	fairwayFirmness DOUBLE,
	createDate DATE null,
	modifiedDate DATE null
);

create table es_ESShotDataSharing (
	shotDataSharingId LONG not null primary key,
	shotDataId LONG,
	playerId LONG,
	userId LONG,
	companyId LONG,
	groupId LONG,
	active_ BOOLEAN,
	createDate DATE null,
	modifyDate DATE null
);