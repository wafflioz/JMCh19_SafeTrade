
Package  	 Class  	Tree  	Deprecated  	Index  	Help 
	
 PREV CLASS   NEXT CLASS 	FRAMES    NO FRAMES    
SUMMARY: NESTED | FIELD | CONSTR | METHOD 	DETAIL: FIELD | CONSTR | METHOD
Interface Login

All Known Implementing Classes:
    Brokerage

public interface Login

Specifies methods for registering and logging in users.

Method Summary
 int 	addUser(java.lang.String name, java.lang.String password)
          Tries to register a new user with a given screen name and password;
 int 	login(java.lang.String name, java.lang.String password)
          Tries to login a user with a given screen name and password;
 

Method Detail
addUser

int addUser(java.lang.String name,
            java.lang.String password)

    Tries to register a new user with a given screen name and password;

    Parameters:
        name - the screen name of the user.
        password - the password for the user. 
    Returns:
        0 if successful, or an error code (a negative integer) if failed:
        -1 -- invalid screen name (must be 4-10 chars)
        -2 -- invalid password (must be 2-10 chars)
        -3 -- the screen name is already taken.

login

int login(java.lang.String name,
          java.lang.String password)

    Tries to login a user with a given screen name and password;

    Parameters:
        name - the screen name of the user.
        password - the password for the user. 
    Returns:
        0 if successful, or an error code (a negative integer) if failed:
        -1 -- screen name not found
        -2 -- invalid password
        -3 -- user is already logged in.

Package  	 Class  	Tree  	Deprecated  	Index  	Help 
	
 PREV CLASS   NEXT CLASS 	FRAMES    NO FRAMES    
SUMMARY: NESTED | FIELD | CONSTR | METHOD 	DETAIL: FIELD | CONSTR | METHOD
