package com.proje.FilmWatchlist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.proje.FilmWatchlist")
@EntityScan(basePackages = {"com.proje.FilmWatchlist"})
@ComponentScan(basePackages = {"com.proje.FilmWatchlist"})
@EnableJpaRepositories(basePackages = {"com.proje.FilmWatchlist"})
public class FilmWatchlistApplication {

	public static void main(String[] args) {
		SpringApplication.run(FilmWatchlistApplication.class, args);
	}

}
