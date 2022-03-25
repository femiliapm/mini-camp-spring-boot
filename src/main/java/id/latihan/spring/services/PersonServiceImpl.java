package id.latihan.spring.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import id.latihan.spring.model.Person;
import id.latihan.spring.model.dto.PersonDto;
import id.latihan.spring.model.dto.Response;
import id.latihan.spring.repository.PersonRepository;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {
  @Autowired
  private PersonRepository personRepository;

  @Override
  public Object create(PersonDto dto) {
    // TODO Auto-generated method stub
    // Object Person Model
    Person person = new Person();
    person.setFirstName(dto.getNamaDepan());
    person.setLastName(dto.getNamaBelakang());
    person.setEmail(dto.getEmail());

    // Save to DB
    personRepository.save(person);

    // Response body
    Response<Object> response = new Response<>();
    response.setStatus(201);
    response.setMessage("Person successfully added.");

    return response;
  }

  @Override
  public Object read() {
    // TODO Auto-generated method stub
    // Find all person
    List<Person> person = personRepository.findAll();

    // Response body
    Response<Object> response = new Response<>();
    response.setStatus(200);
    response.setMessage("Data person");
    response.setData(person);

    return response;
  }

  @Override
  public Object update(PersonDto dto, Long id) {
    // TODO Auto-generated method stub
    // Response Body
    Map<String, Object> responseBody = new HashMap<>();
    // Find user
    Optional<Person> findPerson = personRepository.findById(id);

    // check person ada atau tidak
    if (findPerson.isEmpty()) {
      responseBody.put("message", "Data person tidak ditemukan");
      responseBody.put("status", 404);
      return new ResponseEntity<>(responseBody, HttpStatus.NOT_FOUND);
    }

    Person person = findPerson.get();
    if (dto.getNamaDepan() != null) {
      person.setFirstName(dto.getNamaDepan());
    }
    if (dto.getNamaBelakang() != null) {
      person.setLastName(dto.getNamaBelakang());
    }
    if (dto.getEmail() != null) {
      person.setEmail(dto.getEmail());
    }

    personRepository.save(person);

    Map<String, Object> data = new HashMap<>();
    data.put("firstName", person.getFirstName());
    data.put("lastName", person.getLastName());

    responseBody.put("message", "Data person telah diperbarui");
    responseBody.put("status", 200);
    responseBody.put("data", data);

    return responseBody;
  }

  @Override
  public Object delete(Long id) {
    // TODO Auto-generated method stub
    // Response Body
    Map<String, Object> responseBody = new HashMap<>();
    // Find user
    Optional<Person> findPerson = personRepository.findById(id);

    // check person ada atau tidak
    if (findPerson.isEmpty()) {
      responseBody.put("message", "Data person tidak ditemukan");
      responseBody.put("status", 404);
      return new ResponseEntity<>(responseBody, HttpStatus.NOT_FOUND);
    }

    Person person = findPerson.get();
    // Delete from DB
    personRepository.delete(person);

    responseBody.put("message", "Person berhasil dihapus");
    responseBody.put("status", 200);

    return responseBody;
  }

}
