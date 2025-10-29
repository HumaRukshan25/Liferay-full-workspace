create index IX_7F3F503D on BOOKKK_Author (liferayUserId);

create index IX_5848C940 on BOOKKK_BookCategory (categoryName[$COLUMN_LENGTH:75$]);
create unique index IX_546B3199 on BOOKKK_BookCategory (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_E2FEC3D9 on BOOKKK_Books (author[$COLUMN_LENGTH:75$]);
create unique index IX_B7F7F110 on BOOKKK_Books (uuid_[$COLUMN_LENGTH:75$], groupId);

create unique index IX_647A6EAC on BOOKKK_Foo (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_8096860 on BOOK_BookCategory (categoryName[$COLUMN_LENGTH:75$]);
create unique index IX_168088B9 on BOOK_BookCategory (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_D70A10B9 on BOOK_Books (author[$COLUMN_LENGTH:75$]);
create unique index IX_7DD85DF0 on BOOK_Books (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_EC247802 on BOOK_Foo (field2);
create unique index IX_8750938C on BOOK_Foo (uuid_[$COLUMN_LENGTH:75$], groupId);