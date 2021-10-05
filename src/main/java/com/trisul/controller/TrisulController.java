package com.trisul.controller;

import com.trisul.constant.WebResource;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = WebResource.CTX_PATH)
@Tag(name = "Trisul Service", description = "Trisul Service.")
public class TrisulController {}
