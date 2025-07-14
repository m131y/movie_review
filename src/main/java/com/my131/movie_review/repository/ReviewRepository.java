package com.my131.movie_review.repository;

import com.my131.movie_review.model.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    // Page<T> : 실제 조회된 페이지 데이터와 총 페이지 수, 현재 페이지 번호 등의 메타 정보 포함
    // Pageable : 요청받은 페이지 번호, 크기, 정렬 방식을 담는 인터페이스
    Page<Review> findByMovieId(Long movieId, Pageable pageable);

}
