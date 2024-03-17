package kevserbusrayildirim.patikaodev3.repository;

import kevserbusrayildirim.patikaodev3.entitiy.WeatherData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherRepository extends JpaRepository<WeatherData, Long> {
}
