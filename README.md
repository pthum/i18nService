# i18nService

A simple language translation service made with NinjaFramework.

## Run 

To run it locally, execute "mvn ninja:run" in your folder in this directory. It will open up a server at port 8080.


## Usage
```bash
curl "http://localhost:8080/api/message/{messageKey}?params={param1}&params={param2}&params={param3}&params...."
```
for example: 
```bash
curl "http://localhost:8080/api/message/login.loginSuccessful"
```

or with parameters:
```bash
curl "http://localhost:8080/api/message/test.param?params=firstParam&params=secondParam"
```

You can change the specified language by adding the following argument to the curl command.
```bash
-H"Accept-Language:de-DE"
```
Use the language you want (e.g. en-US). 
Or you call the url in your browser (and change the language with a plugin like 'Quick Language Switcher' for Chrome). 

# Extend the available messages and languages
Currently there are message-files for the languages "de" and "en" (the default) available. You find them in the src/main/java/conf folder. 
Read more about these files at the documentation for the ninjaframework: http://www.ninjaframework.org/documentation/internationalization.html
