# Android-KeyGenerator

Fork from [secure-preferences](https://github.com/ophio/secure-preferences)


## Usage

- Generate a key using KeyGenerator:

```java
String password001 = KeyStoreKeyGenerator.get(getApplication(),"alias_my_Password_001")
						.loadOrGenerateKeys(); 

String password002 = KeyStoreKeyGenerator.get(getApplication(),"alias_my_Password_002")
						.loadOrGenerateKeys();                          
```


- use key for [SecurePreferences](https://github.com/Guang1234567/secure-preferences#user-password---recommended)

```java
SharedPreferences prefs = new SecurePreferences(context, password001, "my_user_prefs.xml");                       
```


- use key for [android-database-sqlcipher](https://github.com/sqlcipher/android-database-sqlcipher#details-for-developers)

```java
SQLiteDatabase.loadLibs(this); //first init the db libraries with the context
SQLiteOpenHelper.getWritableDatabase(password002):                     
```

- use key for other library...


## Storing Keys

Once you've generated a random key, you naturally might want to store it. This
may work for some use cases, but please be aware that if you store the key in
the same place that you store the encrypted data, your solution is not
cryptographically sound since the attacker can just get both the key and the
encrypted text. Instead, you should use either the [Keystore
infrastructure](http://developer.android.com/training/articles/keystore.html)
or consider generating the key from a passphrase and using that to encrypt the
user data.

If despite the above you still want to store the key, you can convert the keys
to a string using the included functions and store them in preferences or
SQLite.
