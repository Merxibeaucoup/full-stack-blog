package com.edgar.bloggy.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.edgar.bloggy.utils.ResponseResult;

@RestController
@RequestMapping("/api/upload")
public class UploadController {

	String IMAGE_FOLDER = "./src/main/resources/images/";

	@PostMapping("")
	public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile uploadfile) {

		ResponseResult rr = new ResponseResult();

		if (uploadfile.isEmpty()) {
			return ResponseEntity.ok().body("please select a file!");
		}

		try {
			String[] fileUrls = saveUploadedFiles(Arrays.asList(uploadfile));
			rr.setMessage(fileUrls[0]);
		} catch (IOException e) {
			return ResponseEntity.badRequest().build();
		}

		rr.setstatusCode(200);
		return ResponseEntity.ok(rr);
	}

	// save file
	private String[] saveUploadedFiles(List<MultipartFile> files) throws IOException {
		String[] fileUrls = new String[files.size()];
		int index = 0;
		for (MultipartFile file : files) {
			if (file.isEmpty()) {
				continue;
			}

			byte[] bytes = file.getBytes();
			String filename = file.getOriginalFilename();

			Path path = Paths.get(IMAGE_FOLDER + filename);
			Files.write(path, bytes);
			fileUrls[index] = getBaseEnvLinkURL() + "/images/" + filename;
			index++;
		}
		return fileUrls;
	}

	protected String getBaseEnvLinkURL() {
		String baseEnvLinkURL = null;
		HttpServletRequest currentRequest = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
				.getRequest();
		baseEnvLinkURL = "http://" + currentRequest.getLocalName();
		if (currentRequest.getLocalPort() != 80) { //if current pot is not defuat port 
			baseEnvLinkURL += ":" + currentRequest.getLocalPort(); // get current local port Url
		}
		if (!StringUtils.hasText(currentRequest.getContextPath())) {
			baseEnvLinkURL += currentRequest.getContextPath();
		}
		return baseEnvLinkURL; // Return the image URL for the client to access it
	}
}