package id.latihan.spring.model.dto;

import lombok.Data;

@Data
public class Response<T> {
  private Integer status;
  private String message;
  private T data;
}
