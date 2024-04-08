# FLIGHT TRACKING WEBHOOK 

## Overview
This Spring Boot project implements a flight tracking and notification system. It allows users to subscribe to flight tracking updates via webhooks and receive notifications when there are changes in the status of tracked flights.

## Setup
### Prerequisites
- An IDE ( [Visual Studio Code](https://code.visualstudio.com/download) or [intellij IDEA](https://www.jetbrains.com/idea/download/?source=google&medium=cpc&campaign=APAC_en_AU_IDEA_Branded&term=intellij+idea&content=602143185772&gclid=EAIaIQobChMI-f3uuYnegwMVwqRmAh0_ewXKEAAYASABEgImY_D_BwE&section=windows) )
- [Postman API](https://www.postman.com/downloads/)
- [Java](https://www.oracle.com/java/technologies/downloads/) 17 at minimum installed on your local machine.
- An account with https://pipedream.com/requestbin

### Clone the Repository
- Open a terminal or command prompt (Powershell on Windows and Terminal or linux or macOs)
- Navigate to the directory you want to clone the project. e.g. `cd path/to/your/directory`
- Run `git clone git@github.com:msackey-IW/flight-webhook.git`
- Run cd `flight-webhook`
- Run `mvn clean spring-boot:run`. This will create and run the flight-webhook springboot application.

### Testing with Postman
- Create an account with https://pipedream.com/requestbin to allow you to generate a webhook url.
- Open and run POSTMAN API
- In the main repository directory, navigate to `postman`.
- This folder contains 4 JSON files. Each file must be uploaded to POSTMAN API via `settings -> data -> import Data -> Import Data file`.
- The collection now give you access to all the endpoints available in the application. Requests may now be sent and received.
- Open the webhook collection and navigate to the `Register Webhook` endpoint.
- Under `body -> raw` in the json body, replace the url with the one you created above.
- Send the request which should return a `200 status code`.
- Open the `Add Flight ` endpoint.
- Send a request to the server to add a flight the database.
- This will add the flight to the database and notify the subscribed webhook urls.
- You should see the flight information posted to `https://pipedream.com/requestbin`.