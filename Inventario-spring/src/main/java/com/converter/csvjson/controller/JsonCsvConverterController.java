package com.converter.csvjson.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.converter.csvjson.service.JsonToCvsvConverterService;

@Controller
@RestController
public class JsonCsvConverterController {
	
	@Autowired
	JsonToCvsvConverterService jsonToCvsvConverterService;

	@PostMapping("/convert")
	public ResponseEntity<String> convertJsonToCsv(@RequestBody String json) {
		try {
			String csv = jsonToCvsvConverterService.convertJsonToCsv(json);
			return ResponseEntity.ok(csv);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error converting JSON to CSV");
		}
	}

	@PostMapping("/convert-file")
	public ResponseEntity<String> convertJsonFileToCsv(@RequestParam("file") MultipartFile file) {
		try {
			String jsonString = new String(file.getBytes());
			String csv = jsonToCvsvConverterService.convertJsonToCsv(jsonString);
			return ResponseEntity.ok(csv);
		} catch (IOException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error reading JSON file");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error converting JSON to CSV");
		}
	}
}
