package brussels.spfb.kensho;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import com.github.benmanes.caffeine.cache.Caffeine;

@SpringBootApplication
@EnableCaching
public class KenshoApplication {

	public static void main(String[] args) {
		SpringApplication.run(KenshoApplication.class, args);
	}

	@SuppressWarnings("rawtypes")
	@Bean
	protected Caffeine caffeine() {
		return Caffeine.newBuilder();
	}

	@SuppressWarnings({"rawtypes", "unchecked"})
	@Bean
	protected CacheManager cacheManager(Caffeine caffeine) {
		CaffeineCacheManager caffeineCacheManager = new CaffeineCacheManager();
		caffeineCacheManager.setCaffeine(caffeine);
		return caffeineCacheManager;
	}

}
