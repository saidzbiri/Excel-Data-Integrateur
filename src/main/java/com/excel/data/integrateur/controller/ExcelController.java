package com.excel.data.integrateur.controller;

import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.excel.data.integrateur.helper.ExcelHelper;
import com.excel.data.integrateur.message.ResponseMessage;
import com.excel.data.integrateur.service.ExcelService;

@RestController
@RequestMapping("/api/excel")
public class ExcelController {

	@Autowired
	ExcelService fileService;

	@PostMapping("/upload")
	public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") String filePath) {
		String message = "";
		File file = new File(filePath);

		if (ExcelHelper.hasExcelFormat(file)) {
			try {
				fileService.save(file);

				message = "Uploaded the file successfully: " + file.getName();
				return ResponseEntity.ok(new ResponseMessage(message));
			} catch (Exception e) {
				System.out.println(e);
				message = "Could not upload the file: " + file.getName() + "!";
				return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
			}
		}

		message = "Please upload an excel file!";
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
	}

}
