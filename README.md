This illustrates a many to many relationship between entities using Hibernate & an inmemory DB

The following is the schema of the DB:
USER <->> USER_ADDRESS<<-> ADDRESS

USER               USER_ADDRESS                ADDRESS
USER_ID    <->>  [USER_ID, ADDRESS_ID]  <<->   ADDRESS_ID


