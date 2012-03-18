===============================
Tomighty Google Calendar Plugin
===============================
:Author: Soheil Hassas Yeganeh <soheil@cs.toronto.edu>

Introduction
============
Tomighty Google Calendar plugin logs your pomodoro activities on Google
Calendar; enables better time tracking.

How To Install
==============
Clone the project first. Then in the `tomighty-gcal-plugin/src/main/resources`
folder create `client_secrets.json` with the following content:

`{
  "installed": {
    "client_id": "Google App Client ID",
    "client_secret":"Google App Client Secret",
    "redirect_uris": ["urn:ietf:wg:oauth:2.0:oob", "http://localhost"],
    "auth_uri": "https://accounts.google.com/o/oauth2/auth",
    "token_uri": "https://accounts.google.com/o/oauth2/token"
  }
}`

To fill the `client_id` and `client_secret` fields you'd need to create a
google application at https://code.google.com/apis/console.

Then build the project:

`mvn clean package`

Finally, copy `target/tomighty-gcal-plugin-1.0-jar-with-dependencies.jar` to
`$HOME/.tomighty/plugins/tomighty-gcal`:

`mkdir ~/.tomighty/plugins/tomighty-gcal`
`target/tomighty-gcal-plugin-1.0-jar-with-dependencies.jar ~/.tomighty/plugins/tomighty-gcal/tomighty-gcal-plugin-1.0.jar`

Launch tomighty and you're ready to go.

Known Issues:
=============
1. Oracle JDK does not pass the url to the browser. For now, OpenJDK works. You would only need OpenJDK for the first time.

