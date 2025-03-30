package com.kolu.jobappbackend.controller;

import com.kolu.jobappbackend.model.JobPost;
import com.kolu.jobappbackend.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobRestController {
    @Autowired
    private JobService jobService;

    @GetMapping("/jobPosts")
    public List<JobPost> getAllJobPosts() {
        return jobService.getAllJobs();
    }

    @GetMapping("/jobPosts/{id}")
    public JobPost getJobPost(@PathVariable int id) {
        return jobService.getJob(id);
    }

    @PostMapping("/addJob")
    public JobPost addJob(@RequestBody JobPost jobPost){
        jobService.addJob(jobPost);
        return jobPost;
    }
}
