package com.devsuperior.uri2611.repositories;

import com.devsuperior.uri2611.dto.MovieMinDTO;
import com.devsuperior.uri2611.entities.Movie;
import com.devsuperior.uri2611.projections.MovieMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query(nativeQuery = true, value = "SELECT movies.id, movies.name FROM MOVIES INNER JOIN GENRES ON movies.id_genres = genres.id " +
            "WHERE genres.description = :genreName")
    List<MovieMinProjection> searchAllByMovieOnGenre(String genreName);

    @Query(value = "SELECT new com.devsuperior.uri2611.dto.MovieMinDTO(m.id, m.name) FROM Movie m WHERE m.genre.description = :genreName")
    List<MovieMinDTO> searchAllByMovieOnG(String genreName);
}
