package kevserbusrayildirim.patikaodev3.controller;

import kevserbusrayildirim.patikaodev3.service.WeatherService;
import kevserbusrayildirim.patikaodev3.entitiy.WeatherData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/weather")
@Validated
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    // Günlük hava durumu raporu için endpoint
    @GetMapping("/daily")
    public ResponseEntity<WeatherData> getDailyWeather(
            @RequestParam @NotEmpty(message = "Country cannot be empty") String country,
            @RequestParam @NotEmpty(message = "City cannot be empty") String city) {
        WeatherData weatherData = weatherService.getDailyWeather(country, city);
        return ResponseEntity.ok(weatherData);
    }

    // Haftalık hava durumu raporu için endpoint
    @GetMapping("/weekly")
    public ResponseEntity<WeatherData> getWeeklyWeather(
            @RequestParam @NotEmpty(message = "Country cannot be empty") String country,
            @RequestParam @NotEmpty(message = "City cannot be empty") String city) {
        WeatherData weatherData = weatherService.getWeeklyWeather(country, city);
        return ResponseEntity.ok(weatherData);
    }

    // Aylık hava durumu raporu için endpoint
    @GetMapping("/monthly")
    public ResponseEntity<String> getMonthlyWeather(
            @RequestParam @NotNull(message = "Country cannot be null") String country,
            @RequestParam @NotNull(message = "City cannot be null") String city) {
        // Aylık rapor OpenWeatherMap API'si tarafından sağlanmıyor, başka bir API kullanılmalı
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body("Monthly weather report is not available.");
    }
}
