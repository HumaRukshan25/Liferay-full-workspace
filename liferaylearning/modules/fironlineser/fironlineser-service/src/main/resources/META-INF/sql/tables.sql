create table FIRFOO_FIR (
	uuid_ VARCHAR(75) null,
	firId LONG not null primary key,
	complainantName VARCHAR(75) null,
	incidentDate DATE null,
	incidentDetails VARCHAR(75) null,
	status VARCHAR(75) null,
	timeline VARCHAR(75) null,
	modificationDetails VARCHAR(75) null,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null
);

create table FIRFOO_FIRRR (
	uuid_ VARCHAR(75) null,
	firId LONG not null primary key,
	complainantName VARCHAR(75) null,
	incidentDate DATE null,
	incidentDetails VARCHAR(75) null,
	incidentLocation VARCHAR(75) null,
	status VARCHAR(75) null,
	timeline VARCHAR(75) null,
	modificationDetails VARCHAR(75) null,
	assignedInspector VARCHAR(75) null,
	proofFileName VARCHAR(75) null,
	proofFilePath VARCHAR(75) null,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null
);

create table FIRFOO_Foo (
	uuid_ VARCHAR(75) null,
	fooId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	field1 VARCHAR(75) null,
	field2 BOOLEAN,
	field3 INTEGER,
	field4 DATE null,
	field5 VARCHAR(75) null
);

create table FIRFOO_PoliceStation (
	uuid_ VARCHAR(75) null,
	stationId LONG not null primary key,
	stationName VARCHAR(75) null,
	address VARCHAR(75) null,
	jurisdictionArea VARCHAR(75) null,
	officerInCharge VARCHAR(75) null,
	contactNumber VARCHAR(75) null,
	email VARCHAR(75) null,
	status VARCHAR(75) null,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table FIRFOO_SignupUser (
	uuid_ VARCHAR(75) null,
	signupUserId LONG not null primary key,
	loginName VARCHAR(75) null,
	firstName VARCHAR(75) null,
	lastName VARCHAR(75) null,
	email VARCHAR(75) null,
	phoneNo VARCHAR(75) null,
	password_ VARCHAR(75) null,
	role_ VARCHAR(75) null,
	active_ BOOLEAN,
	activationToken VARCHAR(75) null
);