package com.devsuperior.uri2611;

import com.devsuperior.uri2611.dto.MovieMinDTO;
import com.devsuperior.uri2611.projections.MovieMinProjection;
import com.devsuperior.uri2611.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Uri2611Application implements CommandLineRunner {
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2611Application.class, args);
	}

	@Autowired
	private MovieRepository movieRepository;
	@Override
	public void run(String... args) throws Exception {
		List<MovieMinProjection> movie = movieRepository.searchAllByMovieOnGenre("Action");
		movie.stream().map(x -> x.getName()).forEach(System.out::println);

		System.out.println("\n\n\n");
		System.out.println("CONSULTA 2");
		List<MovieMinDTO> movies = movieRepository.searchAllByMovieOnGenre("Action")
				.stream().map(x -> new MovieMinDTO(x)).collect(Collectors.toList());
		movies.stream().forEach(y -> System.out.println(y.getName()));

		System.out.println("\n\n\n");
		System.out.println("CONSULTA 3 JPQL");
		movieRepository.searchAllByMovieOnG("Action").forEach(y -> System.out.println(y));
	}
}
