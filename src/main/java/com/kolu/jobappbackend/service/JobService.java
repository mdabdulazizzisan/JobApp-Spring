package com.kolu.jobappbackend.service;


import com.kolu.jobappbackend.model.JobPost;
import com.kolu.jobappbackend.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepo jobRepo;

    public List<JobPost> getAllJobs() {
        return jobRepo.getAllJobs();
    }

    public void addJob(JobPost jobPost) {
        jobRepo.addJob(jobPost);
    }

    public JobPost getJob(int id) {
        return jobRepo.getJob(id);
    }

    public void updateJobPost(JobPost jobPost) {
        jobRepo.updateJobPost(jobPost);
    }

    public void deleteJob(int jobId) {
        jobRepo.deleteJob(jobId);
    }
}
