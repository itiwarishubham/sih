package com.creathon.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.creathon.bean.Agency;
import com.creathon.service.AgencyService;
import com.creathon.service.CommonService;

@Controller
public class AgencyController {

	
	@Autowired
	private CommonService commonService;
	
	@Autowired
	private AgencyService agencyService;
	
	@Value("${upload.path}")
	private String path;
	
	
	@RequestMapping(value="/addAgency", method = RequestMethod.GET)
    public ModelAndView addAgency(ModelMap model){
    	ModelAndView mav = new ModelAndView("add_agency");
    	mav.addObject("agency", new Agency());
    	mav.addObject("countryList", commonService.getCountryList());
        return mav;
    }
 
	@RequestMapping(value="/saveAgency", method = RequestMethod.POST)
    public ModelAndView saveAgency(@ModelAttribute Agency agency ,HttpServletRequest request,HttpServletResponse response,ModelMap model){
		ModelAndView mav = new ModelAndView("add_agency");
		
		System.out.println(agency);
		MultipartFile logo = agency.getAgencyPhoto();
		String imagePath =  path+"/agency/"+agency.getName();
		if (!logo.isEmpty()) {
			try {
			
				byte[] bytes = logo.getBytes();	
				
				String mainPath = new File("").getAbsolutePath() + imagePath;
				File theDir =new File(mainPath);
				if (!theDir.exists()) {
					try {
						theDir.mkdirs();
					} catch (Exception se) {
						se.printStackTrace();
					}
				}
				System.out.println("main path: " + mainPath);
		        Path path = Paths.get(mainPath, logo.getOriginalFilename());
		        String dbPath = imagePath + "/"+ logo.getOriginalFilename();
		        System.out.println(path);				
				Files.write(path, bytes);
				agency.setPhoto(dbPath);
			
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}

		Boolean b= agencyService.saveandupdate(agency);
		if(b){
			
			mav.addObject("success", "Agency Added Successfully");
		}
		else{
			mav.addObject("error", "Agency Cannot Be Added");
		}
		mav.addObject("agency", new Agency());
		mav.addObject("countryList", commonService.getCountryList());
		return mav;
}
}
