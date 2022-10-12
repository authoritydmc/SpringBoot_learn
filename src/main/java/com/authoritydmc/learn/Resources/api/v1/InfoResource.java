package com.authoritydmc.learn.Resources.api.v1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/info")
public class InfoResource {

    @Value("${developer.name}")
    private String dev_name;

    @GetMapping("")
    public String getDev_name()
    {
        return dev_name;
    }
}
