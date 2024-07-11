package org.alfresco.demo.upload.config;

import java.io.IOException;
import java.util.Map;

import org.alfresco.service.cmr.repository.NodeRef;
import org.alfresco.service.namespace.QName;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.ImmutableMap;
import com.gradecak.alfresco.mvc.rest.annotation.AlfrescoRestResponse;
import org.springframework.web.multipart.MultipartFile;

/**
 * shows how to use the Alfresco @MVC framework
 */

@RestController
@RequestMapping("/rest")
public class AlfrescoMvcRestController {

    @GetMapping(value = "sample")
    public ResponseEntity<?> sample() throws IOException {
        return ResponseEntity.ok("Alfresco @MVC REST sample");
    }

    @PostMapping(value = "upload")
    public ResponseEntity<?> upload(@RequestPart MultipartFile file) {
        return ResponseEntity.ok("Received: " + file.getOriginalFilename());
    }

    @ExceptionHandler({ RuntimeException.class })
    public ResponseEntity<?> handleRuntimeException(RuntimeException exc) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).header("error", "internal server error").build();
    }
}