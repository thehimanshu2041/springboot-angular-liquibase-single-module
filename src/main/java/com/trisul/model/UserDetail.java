package com.trisul.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.trisul.core.bean.validation.MobileNumberValidator;
import com.trisul.core.bean.validation.PasswordValidator;
import com.trisul.core.bean.validation.UsernameValidator;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Date;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.*;

/**
 * @author h3kumar
 * @since 16/05/2021
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@Schema(name = "UserDetail", description = "UserDetail model")
public class UserDetail {

  @NotNull(message = "Username can't be null.")
  @UsernameValidator
  @Schema(format = "string", required = true, description = "Provide username")
  @JsonProperty("username")
  private String username;

  @NotNull(message = "Email can't be null.")
  @Email
  @Schema(format = "string", required = true, description = "Provide email")
  @JsonProperty("email")
  private String email;

  @NotNull(message = "Password can't be null.")
  @PasswordValidator
  @Schema(format = "string", required = true, description = "Provide password")
  @JsonProperty("password")
  private String password;

  @NotNull(message = "Title can't be null.")
  @Size(min = 2, max = 10, message = "Title should be between 2 and 10 characters.")
  @Schema(format = "string", required = true, description = "Provide title")
  @JsonProperty("title")
  private String title;

  @NotNull(message = "First name can't be null.")
  @Size(min = 5, max = 20, message = "First name should be between 5 and 20 characters.")
  @Schema(format = "string", required = true, description = "Provide firstname")
  @JsonProperty("firstName")
  private String firstName;

  @NotNull(message = "Last name can't be null.")
  @Size(min = 2, max = 20, message = "Last name should be between 2 and 20 characters.")
  @Schema(format = "string", required = true, description = "Provide lastname")
  @JsonProperty("lastName")
  private String lastName;

  @NotNull(message = "Gender can't be null.")
  @Size(min = 1, max = 10, message = "Gender should be between 1 and 10 characters.")
  @Schema(format = "string", required = true, description = "Provide gender")
  @JsonProperty("gender")
  private String gender;

  @NotNull(message = "DOB can't be null.")
  @Schema(format = "date-time", required = true, description = "Provide dob")
  @JsonProperty("dob")
  private Date dob;

  @NotNull(message = "Mobile can't be null.")
  @MobileNumberValidator
  @Schema(format = "string", required = true, description = "Provide mobile")
  @JsonProperty("mobile")
  private String mobile;
}
