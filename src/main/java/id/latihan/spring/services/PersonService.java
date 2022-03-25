package id.latihan.spring.services;

import id.latihan.spring.model.dto.PersonDto;

public interface PersonService {
  public Object create(PersonDto dto);

  public Object read();

  public Object update(PersonDto dto, Long id);

  public Object delete(Long id);
}
