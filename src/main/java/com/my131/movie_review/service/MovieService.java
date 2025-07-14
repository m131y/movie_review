package com.my131.movie_review.service;

import com.my131.movie_review.model.Movie;
import com.my131.movie_review.repository.MovieRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Transactional  //하나의 작업 단위를 트랜잭션으로 묶어주는 애너테이션, 작업 도중 예외가 발생하면 전체 작업을 자동으로 롤백(rollback)
public class MovieService {
    private final MovieRepository movieRepository;

    public Page<Movie> getAll(Pageable pageable) {
        return movieRepository.findAll(pageable);
    }

    public Movie getById(Long id){
        return movieRepository.findById(id)
                .orElseThrow(()-> new NoSuchElementException("영화가 없습니다: "));
    }

    public Movie create(Movie movie) {
       return movieRepository.save(movie);
    }

    public Movie update(Long id, Movie movie) {
        Movie existMovie = getById(id);
        existMovie.setTitle(movie.getTitle());
        existMovie.setReleaseYear(movie.getReleaseYear());

        return movieRepository.save(existMovie);
    }

    public void delete(Long id) {
        movieRepository.deleteById(id);
    }
}
