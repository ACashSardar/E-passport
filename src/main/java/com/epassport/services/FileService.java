package com.epassport.services;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.web.multipart.MultipartFile;

import com.epassport.entities.ApplicationForm;

public interface FileService {
	String uploadFile(String path, MultipartFile file) throws IOException;
	InputStream getResource(String path, String fileName) throws FileNotFoundException;
	boolean deleteFile(String path, String fileName) throws FileNotFoundException;
	void createPdf(String path, ApplicationForm applicationFor);
}
