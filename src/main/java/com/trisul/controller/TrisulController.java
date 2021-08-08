package com.trisul.controller;

import com.trisul.constant.WebResource;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author h3kumar
 * @since 15/05/2021
 */
@RestController
@RequestMapping(value = WebResource.CTX_PATH)
@Tag(name = "Trisul Service", description = "Trisul Service.")
public class TrisulController {}
