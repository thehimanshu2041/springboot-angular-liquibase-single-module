package com.trisul.controller;

import com.trisul.constant.WebResource;
import com.trisul.model.AuthenticationDetail;
import com.trisul.model.LoginDetail;
import com.trisul.model.UserDetail;
import com.trisul.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author h3kumar
 * @since 15/05/2021
 */
@RestController
@RequestMapping(value = WebResource.CTX_PATH + "/user")
@Tag(name = "User Service", description = "User Service.")
@Validated
public class UserController {

  @Autowired UserService userService;

  @Operation(summary = "User login", description = "User login")
  @ApiResponses(
      value = {
        @ApiResponse(
            responseCode = "200",
            description = "Operation Successful",
            content =
                @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = AuthenticationDetail.class)))
      })
  @PostMapping(value = "login")
  public AuthenticationDetail doLogin(@Valid @RequestBody LoginDetail loginDetail) {
    return userService.doLogin(loginDetail);
  }

  @Operation(
      summary = "User Registration",
      description = "It will create a new user with user role.")
  @ApiResponses(
      value = {
        @ApiResponse(
            responseCode = "200",
            description = "Operation Successful",
            content =
                @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = Boolean.class)))
      })
  @PostMapping(value = "registration")
  public boolean doRegistration(@Valid @RequestBody UserDetail userDetail) {
    return userService.createUser(userDetail);
  }
}
