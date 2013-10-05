play-scala-angular-cors-prototype
=================================

A bootstrap project with front end in angular 1.0.7 and back end in Play 2.1.1 (Scala), communicating by passing JSON using the CORS mechanism.

The main goal was to create a simple project with client and server in different domains. Without any setup, this is not possible due to same origin policy. To enable such a communication, Cross-origin resource sharing (CORS) may be used (JSONP being an other one for example). 

I share it because I could not google something similar easily.

Setup
=====

Client side created with Yeoman, from generator-angular 0.4.0.

Server side created with Play 2.1.1 in Scala.

Requirement:
* Node.js
* Play 2.1.1
* Scala 2.10
* Java 6+

To start server :
* go to ./server folder
* run <play "run 19000"> (19000 being the port at which the application listens to the requests).

To start client :
* go to ./client folder
* run <npm install>
* run <grunt server>
* 
A browser should be opened at the address http://localhost:20000. Pressing the getData button triggers a request to the back end, response should be shown below.

CORS
====

CORS was enabled :
* on the back end site by attaching Access-Control-Allow-Origin header. To avoid adding the header to every request, there is Global object with doFilter action executed for all the responses. Additionally there is an empty "options" action in the Application controller responding to the OPTIONS method that may be  (the routes file redirect all the OPTIONS request there).
* on the front end by configuring the $http provider in the app.js file:

```
$httpProvider.defaults.useXDomain = true;
delete $httpProvider.defaults.headers.common['X-Requested-With'];
```
