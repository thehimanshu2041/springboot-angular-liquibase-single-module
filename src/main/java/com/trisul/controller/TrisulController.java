package com.trisul.controller;

import com.trisul.constant.WebResource;
import com.trisul.model.MenuDetail;
import com.trisul.service.MenuService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @author h3kumar
 * @since 15/05/2021
 */
@RestController
@RequestMapping(value = WebResource.CTX_PATH)
@Tag(name = "Trisul Service", description = "Trisul Service.")
public class TrisulController {

  @Autowired MenuService menuService;

  @Operation(summary = "Menu List", description = "It will give you list of configured menu.")
  @ApiResponses(
      value = {
        @ApiResponse(
            responseCode = "200",
            description = "Operation Successful",
            content =
                @Content(array = @ArraySchema(schema = @Schema(implementation = MenuDetail.class))))
      })
  @GetMapping(value = "menu-list")
  public List<MenuDetail> getMenuList() {
    return menuService.getMenuList();
  }

  @Operation(summary = "Menu Detail", description = "It will create a new menu item.")
  @ApiResponses(
      value = {
        @ApiResponse(
            responseCode = "200",
            description = "Operation Successful",
            content =
                @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = MenuDetail.class)))
      })
  @PostMapping(value = "create-menu")
  public boolean createMenu(@Valid @RequestBody MenuDetail menuDetail) {
    return menuService.createMenuDetail(menuDetail);
  }
}
