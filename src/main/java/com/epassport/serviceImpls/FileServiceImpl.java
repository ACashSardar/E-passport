package com.epassport.serviceImpls;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.epassport.entities.ApplicationForm;
import com.epassport.entities.User;
import com.epassport.services.FileService;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

@Service
public class FileServiceImpl implements FileService {

	@Override
	public String uploadFile(String path, MultipartFile file) throws IOException {
		String name=file.getOriginalFilename();
		String randomId=UUID.randomUUID().toString();
		String arr[]=name.split("[.]");
		String uniqueName=arr[0]+randomId+"."+arr[1];
		String filepath=path+File.separator+uniqueName;
		File f=new File(path);
		if(!f.exists()) {
			f.mkdir();
		}
		try {
			Files.copy(file.getInputStream(), Paths.get(filepath));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return uniqueName;
	}

	@Override
	public InputStream getResource(String path, String fileName) throws FileNotFoundException {
		String fullPath=path+File.separator+fileName;
		InputStream is=new FileInputStream(fullPath);
		return is;
	}

	@Override
	public boolean deleteFile(String path, String fileName) throws FileNotFoundException {
		String fullPath=path+File.separator+fileName;
		System.out.println(fullPath);
		try {
			 File file = new File(fullPath);
			 file.delete();
			 return true;
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void createPdf(String path, ApplicationForm applicationForm) {
		
		User user=applicationForm.getUser();
		String fullpath=path+File.separator+user.getEmailId()+"_application_form.Pdf";
		try {
			PdfWriter writer=new PdfWriter(fullpath);
			PdfDocument pdfDocument=new PdfDocument(writer);
			Document document=new Document(pdfDocument);
			Paragraph p1=new Paragraph(
					"Personal Details"+
					"\n----------------------------"+
					"\n First Name: "+applicationForm.getFirstName()+
					"\n Last Name: "+applicationForm.getLastName()+
					"\n Date of Birth: "+applicationForm.getDob()+
					"\n Place of Birth: "+applicationForm.getPlaceOfBirth()+
					"\n Gender: "+applicationForm.getGender()+
					"\n Marital Status: "+applicationForm.getMaritalStatus()+
					"\n State: "+applicationForm.getState()+
					"\n District: "+applicationForm.getDistrict()+
					"\n PAN: "+applicationForm.getPan()+
					"\n Employment Type: "+applicationForm.getEmploymentType()+
					"\n Education Qualification: "+applicationForm.getEducationQualification()+
					"\n\n Family Details"+
					"\n----------------------------"+
					"\n Father's Name: "+applicationForm.getFathersName()+
					"\n Mother's Name: "+applicationForm.getMothersName()+
					"\n\n Address Details"+
					"\n----------------------------"+
					"\n House Number: "+applicationForm.getHouseNo()+
					"\n Street Name: "+applicationForm.getStreetName()+
					"\n City: "+applicationForm.getCity()+
					"\n Pincode: "+applicationForm.getPinCode()+
					"\n Telephone Number: "+applicationForm.getTelephoneNumber()+
					"\n Email Id: "+applicationForm.getEmailId()+
					"\n\n Reference Details"+
					"\n----------------------------"+
					"\n Reference Name: "+applicationForm.getRefName()+
					"\n Reference Address: "+applicationForm.getRefAddress()+
					"\n\n Appointment Details"+
					"\n----------------------------"+
					"\n Passport Office: "+applicationForm.getPassportOffice().getOfficeName()+
					"\n Office Address: "+applicationForm.getPassportOffice().getAddress()+
					"\n Appointment Date: "+applicationForm.getAppointmentSchedule().getDate()+
					"\n Time Slot: "+applicationForm.getAppointmentSchedule().getTimeSlot()+
					"\n Status: "+applicationForm.getStatus()
			);
			document.add(p1);
			document.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
