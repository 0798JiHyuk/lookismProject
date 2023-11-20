create user c##lookism identified by lookism;
grant connect, resource to c##lookism;
grant create view to c##lookism;
alter user c##lookism Quota 1024M on users;