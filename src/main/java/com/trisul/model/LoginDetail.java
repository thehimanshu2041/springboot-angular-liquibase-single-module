package com.trisul.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.trisul.core.bean.validation.PasswordValidator;
import com.trisul.core.bean.validation.UsernameValidator;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.NotNull;
import lombok.*;

/**
 * @author h3kumar
 * @since 28/03/2021
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@Schema(name = "LoginDetail", description = "Login detail")
public class LoginDetail {

  @NotNull(message = "Username can't be null.")
  @UsernameValidator
  @Schema(format = "string", required = true, description = "Provide username")
  @JsonProperty("username")
  private String username;

  @NotNull(message = "Password can't be null.")
  @PasswordValidator
  @Schema(format = "string", required = true, description = "Provide password")
  @JsonProperty("password")
  private String password;
}
