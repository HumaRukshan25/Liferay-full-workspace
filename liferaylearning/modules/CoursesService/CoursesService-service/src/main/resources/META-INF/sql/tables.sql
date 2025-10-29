create table ATS_Courses (
	uuid_ VARCHAR(75) null,
	coursesId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	Courses_img TEXT null,
	Courses_name VARCHAR(75) null,
	Courses_des VARCHAR(75) null,
	Courses_type VARCHAR(75) null,
	Courses_rating VARCHAR(75) null,
	status INTEGER
);