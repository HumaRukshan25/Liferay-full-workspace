create table ATS_CheckInOutApp (
	uuid_ VARCHAR(75) null,
	logId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	checkInTime DATE null,
	checkOutTime DATE null,
	remarks VARCHAR(75) null,
	location VARCHAR(75) null
);

create table ATS_UserProfile (
	userId LONG not null primary key,
	userName VARCHAR(75) null,
	password_ VARCHAR(75) null
);