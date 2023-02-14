package com.excel.data.integrateur.service;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excel.data.integrateur.helper.ExcelHelper;
import com.excel.data.integrateur.model.User;

import com.excel.data.integrateur.repository.UserRepository;

@Service
public class ExcelService {

	@Autowired
	UserRepository repository;

	public void save(File file) {
		try {
			List<User> users = ExcelHelper.excelToUsers(file);
			repository.saveAll(users);
		} catch (Exception e) {
			throw new RuntimeException("fail to store excel data: " + e.getMessage());
		}
	}

}
