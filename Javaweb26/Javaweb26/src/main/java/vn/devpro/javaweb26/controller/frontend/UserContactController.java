package vn.devpro.javaweb26.controller.frontend;


import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import vn.devpro.javaweb26.controller.BaseController;
import vn.devpro.javaweb26.dto.Contact;
import vn.devpro.javaweb26.dto.Jw26Constants;

@Controller
public class UserContactController extends BaseController implements Jw26Constants {
	
	@RequestMapping(value= "/contact", method = RequestMethod.GET)
	public String contact(final Model model,
			final HttpServletRequest request,
			final HttpServletResponse response) throws IOException{
	
	return "frontend/contact/contact";
	}
	@RequestMapping(value= "/contact-send", method = RequestMethod.POST)
	public String contactSend(final Model model,
			final HttpServletRequest request,
			final HttpServletResponse response) throws IOException{
	
		Contact contact = new Contact();
		contact.setTxtName(request.getParameter("txtName"));//lay du lieu tu form
		//luu du lieu vao Db
		System.out.println("Name = "+ contact.getTxtName());
	
		
	return "frontend/contact/contact";
	}
	@RequestMapping(value= "/contact-edit", method = RequestMethod.GET)
	public String contactEdit(final Model model,
			final HttpServletRequest request,
			final HttpServletResponse response) throws IOException{

		Contact contact = new Contact("Ngoc Nguyen","a@gmail.com","0968388381","Cau giay - Ha noi","Xin doi lai chuot quang");
		//co the lay du lieu tu DB
		model.addAttribute("contact",contact);// day du lieu sang form(views
	return "frontend/contact/contact-edit";
	}
	
	
	@RequestMapping(value = "/contact-edit-save", method = RequestMethod.POST)	
	public ResponseEntity<Map<String, Object>> contactEditNotify(final Model model, 
			final HttpServletRequest request,
			final HttpServletResponse response,
			final @RequestBody Contact contact //Lay du lieu tu ham ajax
			) throws IOException {
		
		Map<String, Object> jsonResult = new HashMap<String, Object>();
		jsonResult.put("code", 404);
		jsonResult.put("message", "Thông tin quý khách '" + contact.getTxtName() + "' đã được lưu");
		return ResponseEntity.ok(jsonResult);
	}
	

	
	@RequestMapping(value= "/contact-sf", method = RequestMethod.GET)
	public String contactsf(final Model model,
			final HttpServletRequest request,
			final HttpServletResponse response) throws IOException{

		Contact contact = new Contact();
		model.addAttribute("contact",contact);// day du lieu sang form(views
	return "frontend/contact/contact-sf";
	}
		
	@RequestMapping(value = "/contact-list", method = RequestMethod.POST)
	public String contactSfSend(final Model model,
			final HttpServletRequest request,
			final HttpServletResponse response,
			@ModelAttribute("contact") Contact contact, //Lay du lieu tu spring form
			@RequestParam("contactFile") MultipartFile contactFile//Lấy file upload từ form 
			) throws IOException {
		//Lưu file upload vào thư mục 
		if (contactFile != null && !contactFile.getOriginalFilename().isEmpty()) {//có up file 
			String path = FOLFER_UPLOAD + "ContactFiles/" +contactFile.getOriginalFilename();
			File fileUpload = new File(path);
			contactFile.transferTo(fileUpload);//Lưu file vào thư mục contactfiles
			//TOdo: Lưu đường dẫn của file vào DB
			
		}

		
		model.addAttribute("contact", contact);
		model.addAttribute("filename", contactFile.getOriginalFilename());
		return "frontend/contact/contact-list";
	}
	
	@RequestMapping(value= "/contact-sf-edit", method = RequestMethod.GET)
	public String contactSfEdit(final Model model,
			final HttpServletRequest request,
			final HttpServletResponse response) throws IOException{

		Contact contact = new Contact("Ngoc Nguyen","a@gmail.com","0968388381","Cau giay - Ha noi","Xin doi lai chuot quang");
		model.addAttribute("contact",contact);// day du lieu sang form(views
	return "frontend/contact/contact-sf-edit";
	}

	@RequestMapping(value= "/contact-list", method = RequestMethod.GET)
	public String contactList(final Model model,
			final HttpServletRequest request,
			final HttpServletResponse response) throws IOException{
	
	return "frontend/contact/contact-list";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
