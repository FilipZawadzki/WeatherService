# WeatherService
Quick project which uses API from WeatherBit 
to get the best surfing weather from already embedded cities base.

### To configure:

Open application.properties file in .\resources folder  
Edit apiKey property and pass your API key  
App is available at ("*SERVER*/weather/cities/surfing/best{date}")  
Date parameter should be in (yyyy-MM-dd) format.  
DONE.

### Technicals:
In dbdata folder there's init data class with these cities:  
Jastarnia (Poland),
Fortaleza (Brazil),
Bridgetown (Barbados),
Pissouri (Cyprus),
Le Morne (Mauritius)

App connects to WeatherbitAPI, chooses best city to surf if city's temperature is between 5 Celsius and 35 Celsius
and it's wind speed is between 5m/s and 18m/s. Any conflict is resolved by higher return value from formula 'windspd * 3 + temp'.


Returned value is in string format "*City* (*Country*) *tmp* Celsius *windspd* m/s"  

##### Used stack: Java 17, Spring/JPA, H2

##### by FZ
