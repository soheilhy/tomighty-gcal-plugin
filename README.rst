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
Clone the project first. Then in the ``tomighty-gcal-plugin/src/main/resources``
folder create ``client_secrets.json`` with the following content:

::

  {
    "installed": {
      "client_id": "Google App Client ID",
      "client_secret":"Google App Client Secret",
      "redirect_uris": ["urn:ietf:wg:oauth:2.0:oob", "http://localhost"],
      "auth_uri": "https://accounts.google.com/o/oauth2/auth",
      "token_uri": "https://accounts.google.com/o/oauth2/token"
    }
  }


To fill the ``client_id`` and ``client_secret`` fields you'd need to create a
google application at https://code.google.com/apis/console.

Create a new project and provide a name that you can easily recognize later. Select the service that you want to use.
In our case we need access to the Calendar API.

1. Click on the status toggle to enable the service.
2. Click the API Access link in the top navigation on the left hand side.
3. Click the blue banner 'Create an OAuth 2.0 client ID..'.
    Provide the information for the Product name. You can omit all the other fields like Product logo and Homepage URL.
4. Click the Next Button.
5. Select the 'Installed application' option and leave the type at 'Other'.
6. Click the 'Create Client ID' button.

Now you will find the required information in the middle of the screen. Copy the ``Client ID`` and the ``Client secret`` to the
``client_secrets.json``.

Then build the project:

::

  $ mvn clean package

Finally, copy ``target/tomighty-gcal-plugin-1.0-jar-with-dependencies.jar`` to
``$HOME/.tomighty/plugins/tomighty-gcal``:

::

  $ mkdir ~/.tomighty/plugins/tomighty-gcal
  $ cp target/tomighty-gcal-plugin-0.1-jar-with-dependencies.jar ~/.tomighty/plugins/tomighty-gcal/

Launch tomighty and you're ready to go.

Known Issues:
=============
1. Oracle JDK does not pass the url to the browser. For now, OpenJDK works. You would only need OpenJDK for the first time.

