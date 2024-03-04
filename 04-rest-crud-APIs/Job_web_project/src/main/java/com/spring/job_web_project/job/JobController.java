package com.spring.job_web_project.job;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class JobController {
    private List<Job> jobs = new ArrayList<>();

    @GetMapping ("/jobs")
    public List<Job> findAll() {
        return jobs;
    }

    @PostMapping ("/jobs")
    public String createJob(@RequestBody Job theJob) {
        jobs.add(theJob);
        return "Job added successfully!";
    }
}
