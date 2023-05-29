package com.converter.csvjson.service;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.converter.csvjson.service.util.ExtractedFields;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

@Service
public class JsonToCvsvConverterServiceImp implements JsonToCvsvConverterService {
	
	@Override
	public String convertJsonToCsv(String jsonString) {
		ObjectMapper objectMapper = new ObjectMapper();
		CsvMapper csvMapper = new CsvMapper();

		try {
			// Convertir JSON a un objeto
			JsonNode jsonNode = objectMapper.readTree(jsonString);
			JsonNode revistasNode = jsonNode.get("revistas");

			// Crear una lista para contener los campos extraídos
			List<ExtractedFields> extractedFieldsList = new ArrayList<>();

			// Extraer los campos deseados de cada revista
			for (JsonNode revistaNode : revistasNode) {
				String tokenActivacion = revistaNode.get("tokenActivacion").asText();
				String nombre = revistaNode.get("nombre").asText();
				String email = revistaNode.get("email").asText();

				ExtractedFields extractedFields = new ExtractedFields(nombre, tokenActivacion, email);
				extractedFieldsList.add(extractedFields);
			}

			// Crear un CsvSchema para los campos deseados
			CsvSchema csvSchema = csvMapper.schemaFor(ExtractedFields.class).withHeader();

			// Crear un StringWriter para escribir los datos CSV
			StringWriter stringWriter = new StringWriter();

			// Escribir los campos extraídos en el StringWriter como CSV
			csvMapper.writer(csvSchema).writeValues(stringWriter).writeAll(extractedFieldsList);

			// Obtener el CSV como una cadena
			String csv = stringWriter.toString();

			return csv;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

}
