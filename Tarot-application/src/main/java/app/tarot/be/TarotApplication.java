package app.tarot.be;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.TimeZone;
@Slf4j
@SpringBootApplication
@EnableScheduling
@EnableAsync
public class TarotApplication {

	public static void main(String[] args) {
		SpringApplication.run(TarotApplication.class, args);
	}
	@PostConstruct
	public void init(){
		// Setting Spring Boot SetTimeZone
		TimeZone.setDefault(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
		ZoneId zone = ZoneId.of("Asia/Ho_Chi_Minh");
		ZonedDateTime nowAtZone = ZonedDateTime.now(zone);
        log.info("ZonedDateTime - Now at Zone Asia/Ho_Chi_Minh : {}", nowAtZone);
	}
}
