package com.kolu.jobappbackend.repo;


import com.kolu.jobappbackend.model.JobPost;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class JobRepo {
    public List<JobPost> jobPosts = new ArrayList<JobPost>(List.of(
            new JobPost(1, "Software Engineer", "Develop and maintain software applications", 3, List.of("Java", "Spring Boot", "SQL")),
            new JobPost(2, "Data Scientist", "Analyze and interpret complex data", 2, List.of("Python", "Machine Learning", "Data Analysis")),
            new JobPost(3, "DevOps Engineer", "Manage and automate infrastructure", 4, List.of("Docker", "Kubernetes", "CI/CD")),
            new JobPost(4, "Frontend Developer", "Build and maintain user interfaces", 2, List.of("JavaScript", "React", "CSS")),
            new JobPost(5, "Backend Developer", "Develop server-side logic", 3, List.of("Java", "Spring", "Hibernate")),
            new JobPost(6, "Mobile Developer", "Create mobile applications", 2, List.of("Kotlin", "Android", "iOS")),
            new JobPost(7, "System Administrator", "Maintain IT systems and networks", 5, List.of("Linux", "Networking", "Security")),
            new JobPost(8, "Product Manager", "Oversee product development", 4, List.of("Agile", "Scrum", "Project Management")),
            new JobPost(9, "QA Engineer", "Test and ensure software quality", 3, List.of("Selenium", "JUnit", "TestNG")),
            new JobPost(10, "UX Designer", "Design user experiences", 2, List.of("Sketch", "Figma", "User Research"))
    ));

    public List<JobPost> getAllJobs() {
        return jobPosts;
    }

    public void addJob(JobPost jobPost) {
        jobPosts.add(jobPost);
    }

    public JobPost getJob(int id) {
        for (JobPost jobPost : jobPosts) {
            if (jobPost.getPostId() == id) {
                return jobPost;
            }
        }
        return null;
    }
}
