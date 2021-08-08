package com.trisul.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Set;
import lombok.*;

/**
 * @author h3kumar
 * @since 10/04/2021
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@Schema(name = "AuthenticationDetail", description = "Authentication Detail")
public class AuthenticationDetail {

  @Schema(format = "string", required = true, description = "Provided access token")
  @JsonProperty("access_token")
  private String access_token;

  @Schema(required = true, description = "User roles")
  @JsonProperty("roles")
  private Set<String> roles;
}
