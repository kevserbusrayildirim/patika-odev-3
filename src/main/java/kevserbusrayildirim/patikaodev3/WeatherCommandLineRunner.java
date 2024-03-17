package kevserbusrayildirim.patikaodev3;

import kevserbusrayildirim.patikaodev3.entitiy.WeatherData;
import kevserbusrayildirim.patikaodev3.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class WeatherCommandLineRunner implements CommandLineRunner {

    @Autowired
    private WeatherService weatherService;

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter country: ");
        String country = scanner.nextLine();

        System.out.print("Enter city: ");
        String city = scanner.nextLine();

        WeatherData dailyWeather = weatherService.getDailyWeather(country, city);
        WeatherData weeklyWeather = weatherService.getWeeklyWeather(country, city);

        System.out.println("Daily Weather:");
        System.out.println(dailyWeather);

        System.out.println("Weekly Weather:");
        System.out.println(weeklyWeather);
    }
}

