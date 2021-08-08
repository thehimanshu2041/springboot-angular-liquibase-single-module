package com.trisul.core.exception.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorMessage {

  @JsonProperty("status")
  private int status;

  @JsonProperty("timestamp")
  private Date timestamp;

  @JsonProperty("error")
  private Error error;
}
