package com.chit.enter.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.chit.enter.tess.tessService;

import net.sourceforge.tess4j.TesseractException;

@Controller
public class HomeController {
	
	
	
	@Autowired
	tessService tess;
	
	
	@RequestMapping(value="/ocrHome")
	public String home() {
		return "upload";
	}
	
	@ResponseBody
	@RequestMapping(value="/upload")
	public String upload(@RequestParam("images") MultipartFile image) throws TesseractException, IOException{
		String res=tess.TessMagic(image);
		System.out.println(res);
		return res;
	}
}
