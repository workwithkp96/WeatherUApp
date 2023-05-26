# WeatherUApp
A weather forecasting application which updates it users about the weather of different location based on their preferred locations.

The Name of the application is - WeatherUApp
It is a web application which provides the weather data for different locations.
Technology stack used for building this application is JAVA , Spring Boot, Spring Security, Hibernate/JPA, MySQL WorkBench (Database).
The project contains the backend coding, integration and REST API calls as per choices.

WorkAround:
User can create his/her account in the application.
User can add his/her preferred locations for which they want weather update
User can get current weather status of a particular location.
User can see the forecast of the location for the next 5 days by deafult on a hourly basis interval.
User can also set the range for the number of days for a particular location, for which they need the forecast.
When user is created an automatic user id is generated in database and accesstoken is created by the ADMIN and saved in Database ->
User preferred locations are also stored in database against the userid
The ADMIN can save, delete an useraccount, update the accesstoken of the user account.
All EMPLOYEEs can get the user account details based on the user_id, name.
ADMIN and EMPLOYEE details are stored in database with there appropriate role - > userid, {bycyrpt}password,roles
WeatherStack (open source) weather information application has been used for receiving the data.
The data is received by hitting the correct API and based on the choices and preferences.
All the useraccounts receives a current weather update based on their preferred location details received from them.
