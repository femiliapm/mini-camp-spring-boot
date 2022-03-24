package id.latihan.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/testing")
public class TestController {
  @GetMapping("/hello")
  public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
    return String.format("Hello %s! dijalankan dari package controller", name);
  }

  @PostMapping("/hello")
  public String postHello(@RequestParam(value = "name", defaultValue = "Dijalankan dari Method POST") String name) {
    return "Hello post " + name + "! dijalankan dari package controller";
  }

  @PutMapping("/hello")
  public String putHello(@RequestParam(value = "name", defaultValue = "Dijalankan dari Method PUT") String name) {
    return "Hello put " + name + "!";
  }

  @DeleteMapping("/hello")
  public String deleteHello(@RequestParam(value = "name", defaultValue = "Dijalankan dari Method DELETE") String name) {
    return "Hello delete " + name + "!";
  }
}
