package com.excel.service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.excel.UserRepository;
import com.excel.model.User;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	public void readExcel(MultipartFile file) throws Exception {
		InputStream inputStream = file.getInputStream();
		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet sheet = workbook.getSheetAt(0);
		List<User> userList = new ArrayList<>();
		User user = new User();
		for(Row row : sheet) {
			if(row.getRowNum()==0) { continue; }
			user.setId((long) row.getCell(0).getNumericCellValue());
			user.setName(row.getCell(1).getStringCellValue());
			user.setEmail(row.getCell(2).getStringCellValue());
			user.setAge((int) row.getCell(0).getNumericCellValue());
            System.out.println("User: ID=" + user.getId() + ", Email=" + user.getEmail() + ", Name=" + user.getName() + ", Age=" + user.getAge());
            userList.add(user);
		}
		userRepo.saveAll(userList);
		workbook.close();
		inputStream.close();
	}
}
