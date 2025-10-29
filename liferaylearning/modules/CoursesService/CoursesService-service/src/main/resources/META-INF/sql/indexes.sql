create index IX_3CB4F465 on ATS_Courses (Courses_name[$COLUMN_LENGTH:75$]);
create index IX_48459954 on ATS_Courses (Courses_type[$COLUMN_LENGTH:75$]);
create unique index IX_AB4F69D5 on ATS_Courses (uuid_[$COLUMN_LENGTH:75$], groupId);