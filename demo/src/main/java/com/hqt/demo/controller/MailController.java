package com.hqt.demo.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hqt.demo.service.MailService;

@Controller
public class MailController {

	@Autowired
	MailService mailService;
	
	private static String UPLOADED_FOLDER = "D:\\System_Team\\workspaces\\java-web-template\\JAVAWEB\\src\\main\\resources\\static\\mail\\";

	@PostMapping("/upload")
	public String singleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes)
			throws MessagingException {

		if (file.isEmpty()) {
			redirectAttributes.addFlashAttribute("messager", "Please select a file to upload");
			return "redirect:/home";
		}

		try {

			byte[] bytes = file.getBytes();
			Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());

			if (Files.isReadable(path)) {
				redirectAttributes.addFlashAttribute("messager", "Da ton tai, vui long chon ten file khac");
				return "redirect:/home";
			} else {
				Files.write(path, bytes);
				mailService.addMail(UPLOADED_FOLDER + file.getOriginalFilename());
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return "redirect:/home";
	}
}
