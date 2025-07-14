package com.my131.movie_review.repository;

import com.my131.movie_review.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
 //<Repository에서 쓸 모델, 모델의 기본키 타입>
public interface MovieRepository extends JpaRepository<Movie, Long> {

}
