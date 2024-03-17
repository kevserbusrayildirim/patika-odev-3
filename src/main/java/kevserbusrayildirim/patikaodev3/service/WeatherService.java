package kevserbusrayildirim.patikaodev3.service;

import kevserbusrayildirim.patikaodev3.entitiy.WeatherData;
import kevserbusrayildirim.patikaodev3.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${openweathermap.api.key}")
    private String apiKey;

    public WeatherData getDailyWeather(String country, String city) {
        String apiUrl = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "," + country + "&appid=" + apiKey;
        ResponseEntity<WeatherData> response = restTemplate.getForEntity(apiUrl, WeatherData.class);
        return response.getBody();
    }

    public WeatherData getWeeklyWeather(String country, String city) {
        String apiUrl = "http://api.openweathermap.org/data/2.5/forecast?q=" + city + "," + country + "&appid=" + apiKey;
        ResponseEntity<WeatherData> response = restTemplate.getForEntity(apiUrl, WeatherData.class);
        return response.getBody();
    }

    public WeatherData getMonthlyWeather(String country, String city) {
        // OpenWeatherMap API'si aylık hava durumu verisi sağlamıyor, bu nedenle başka bir API kullanılmalıdır
        return null;
    }
}
