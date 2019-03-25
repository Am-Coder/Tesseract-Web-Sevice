package com.chit.enter.tess;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.TesseractException;


@Component
public class tessService {
	@Autowired
	ITesseract tess ;
	
	public String TessMagic(MultipartFile img) throws TesseractException, IOException {
		byte[] bytes = img.getBytes();
		tess.setDatapath("src/main/resources/tesseract/");
		ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
		BufferedImage bi = ImageIO.read(bis);
//		String result=tess.doOCR(new File("E:/java/tesseract/images.jpg"));
		String result=tess.doOCR(bi);
		return result;
	}
}
