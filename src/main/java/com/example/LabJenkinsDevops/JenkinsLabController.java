package com.example.LabJenkinsDevops;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JenkinsLabController {
    @GetMapping("/testing")
    public String monMessage() {
        return "This Testing in Order to Deploy"
                + '\'' + "Jenkins Integration with Tomcat For Deployment"
                + '\'' + "Made it By NACIRI Abdelilah";
    }
}
