package com.trisul.core.exception.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Error {

  @JsonProperty("message")
  private String message;

  @JsonProperty("description")
  private String description;
}
