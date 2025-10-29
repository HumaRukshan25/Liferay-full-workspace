create index IX_E7C01B47 on FIRFOO_FIR (userId);
create index IX_4D265107 on FIRFOO_FIR (uuid_[$COLUMN_LENGTH:75$]);

create index IX_3D841FC7 on FIRFOO_FIRRR (userId);
create index IX_E48FBC87 on FIRFOO_FIRRR (uuid_[$COLUMN_LENGTH:75$]);

create index IX_C28DF2F0 on FIRFOO_Foo (field2);
create unique index IX_593F407A on FIRFOO_Foo (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_10CABA96 on FIRFOO_PoliceStation (jurisdictionArea[$COLUMN_LENGTH:75$]);
create index IX_1E862C5B on FIRFOO_PoliceStation (stationName[$COLUMN_LENGTH:75$]);
create index IX_469E94C0 on FIRFOO_PoliceStation (uuid_[$COLUMN_LENGTH:75$]);

create index IX_D7955602 on FIRFOO_SignupUser (activationToken[$COLUMN_LENGTH:75$]);
create index IX_B18A351B on FIRFOO_SignupUser (email[$COLUMN_LENGTH:75$]);
create index IX_E02F383 on FIRFOO_SignupUser (uuid_[$COLUMN_LENGTH:75$]);