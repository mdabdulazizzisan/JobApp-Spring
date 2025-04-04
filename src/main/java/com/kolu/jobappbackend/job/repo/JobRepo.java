package com.kolu.jobappbackend.job.repo;


import com.kolu.jobappbackend.job.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepo extends JpaRepository<JobPost, Integer> {
    List<JobPost> findByPostProfileContainingOrPostDescContaining(String postProfileKeyword, String postDescKeyword);
}