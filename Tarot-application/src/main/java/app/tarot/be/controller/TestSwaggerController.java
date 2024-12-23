package app.tarot.be.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestSwaggerController {
    @GetMapping
    public ResponseEntity<List<String>> getAllUsers() {

        return ResponseEntity.ok(List.of("Long", "Phuong", "My"));
    }

}
