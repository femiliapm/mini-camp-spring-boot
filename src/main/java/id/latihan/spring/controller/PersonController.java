package id.latihan.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.latihan.spring.model.dto.PersonDto;
import id.latihan.spring.services.PersonServiceImpl;

@RestController
@RequestMapping("/person")
public class PersonController {

  @Autowired
  private PersonServiceImpl service;

  @GetMapping
  public ResponseEntity<Object> getPersons() {
    ResponseEntity<Object> responseEntity = new ResponseEntity<>(service.read(), HttpStatus.OK);
    return responseEntity;
  }

  @PostMapping
  public ResponseEntity<Object> createPerson(@RequestBody PersonDto dtoPerson) {
    return new ResponseEntity<>(service.create(dtoPerson), HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Object> updatePerson(@PathVariable Long id, @RequestBody PersonDto dto) {
    return new ResponseEntity<>(service.update(dto, id), HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Object> deletePerson(@PathVariable Long id) {
    return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
  }
}
