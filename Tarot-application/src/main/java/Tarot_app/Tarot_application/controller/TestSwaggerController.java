package Tarot_app.Tarot_application.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestSwaggerController {
    @GetMapping
    public List<String> getAllUsers() {

        return List.of("Long", "Phuong", "My");
    }

}
