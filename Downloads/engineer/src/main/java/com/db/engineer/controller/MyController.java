package com.db.engineer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.ListBucketsRequest;
import com.db.engineer.model.EngineerModel;
import com.db.engineer.s3config.AWSS3Config;
import com.db.engineer.service.EngineerService;
import com.db.engineer.service.EngineerServiceImpl;




@Controller

public class MyController {
	
	@Autowired
	EngineerServiceImpl eService;
	@RequestMapping(value="/")
    public String viewHomePage(Model model) {
        model.addAttribute("listEngineers", eService.getAll());
        return "landing";
    }
	
	@RequestMapping(value="/new", method=RequestMethod.GET)
	public String newengPg( Model m){
		m.addAttribute("engobj", new EngineerModel());
		return "new_eng";
	}
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveengPg(@ModelAttribute EngineerModel engobj) {
		eService.save(engobj);
		return "redirect:/";
	}
	 @GetMapping("/showFormForUpdate/{id}")
	    public String showFormForUpdate(@PathVariable(value = "id") Long id, Model model) {

	        // get employee from the service
	        EngineerModel em = eService.getEnggById(id);

	        // set employee as a model attribute to pre-populate the form
	        model.addAttribute("engobj", em);
	        return "update_engg";
	    }
	
	@GetMapping("/deleteEngg/{id}")
	public String deleteFormUpdate(@PathVariable(value="id") Long id, Model model) {
		
		eService.deleteById(id);
		
		return "redirect:/";
	}
	
	@Autowired
	AWSS3Config s3;
	@RequestMapping(value="/getawsbuckets" ,method=RequestMethod.GET)
	public void getMyBuckets(){
		
		List<Bucket> buckets=s3.getAmazonS3Cient().listBuckets();
		for(Bucket b : buckets){
			System.out.println(b.getName());
		}
	}
	

}
