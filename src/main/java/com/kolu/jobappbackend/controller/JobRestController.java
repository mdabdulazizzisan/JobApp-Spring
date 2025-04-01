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

    @GetMapping("/jobPost/{id}")
    public JobPost getJobPost(@PathVariable int id) {
        return jobService.getJob(id);
    }

    @GetMapping("/jobPost/keyword/{keyword}")
    public List<JobPost> searchByKeyword(@PathVariable("keyword") String keyword){
        return jobService.searchByKeyword(keyword);
    }

    @PostMapping("/addJob")
    public JobPost addJob(@RequestBody JobPost jobPost){
        jobService.addJob(jobPost);
        return jobService.getJob(jobPost.getPostId());
    }

    @PutMapping("/jobPost")
    public JobPost updateJobPost(@RequestBody JobPost jobPost){
        jobService.updateJobPost(jobPost);
        return jobService.getJob(jobPost.getPostId());
    }

    @DeleteMapping("/jobPost/{jobId}")
    public String deleteJobPost(@PathVariable int jobId){
        jobService.deleteJob(jobId);
        return "Deleted";
    }

    @GetMapping("/loadJobs")
    public String loadJobs(){
        jobService.load();
        return "Loading Successful";
    }
}
