package com.jp.fbcs.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.plaf.synth.SynthSeparatorUI;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jp.fbcs.entities.Complaint;
import com.jp.fbcs.exception.ComplaintException;
import com.jp.fbcs.services.ComplaintServiceImpl;


@Controller
public class FrontController {

	@Autowired
	@Qualifier("complaintservice")
	private ComplaintServiceImpl complaintService;

	private Validator validator;

	@InitBinder
	private void validaterBinder() {
		ValidatorFactory validationFactory = Validation.buildDefaultValidatorFactory();
		validator = validationFactory.getValidator();

	}

	@ModelAttribute("complaintCategory")
	public Map<String, String> getCountryList() {
		Map<String, String> categoryList = new HashMap<String, String>();
		categoryList.put("IB", "Internet Banking");
		categoryList.put("GB", "General Banking");
		categoryList.put("OT", "Others");
		return categoryList;
	}

	@ModelAttribute("priority")
	public List<String> getPriority() {
		List<String> priorityList = new ArrayList<String>();
		priorityList.add("High");
		priorityList.add("Medium");
		priorityList.add("Low");
		return priorityList;
	}

	@RequestMapping("newComplaintForm.hr")
	public String getComplaintForm(Model model) {
		Complaint complaint = new Complaint();
		model.addAttribute("complaint", complaint);
		System.out.println("Added form");
		return "ComplaintPage";
	}

	@RequestMapping("submitComplaintData.hr")
	public String submitComplaintData(@ModelAttribute("complaint") Complaint complaint, 
			BindingResult result, Model model) {
		System.out.println(complaint);

		Set<ConstraintViolation<Complaint>> violations = validator.validate(complaint);

		for (ConstraintViolation<Complaint> violation : violations) {
			String propertyPath = violation.getPropertyPath().toString();
			String message = violation.getMessage();
			FieldError error = new FieldError("complaint", propertyPath,
					"Invalid " + propertyPath + "(" + message + ")");
			result.addError(error);
		}

		if (result.hasErrors()) {
			model.addAttribute("msg", "Errors in entry. ");
			return "ComplaintPage";
		} else {
			try {
				System.out.println("Going to Save Success");
				complaint.setStatus("Open");
				String category=complaint.getCategory();
				System.out.println(category);
				switch(category){
				case "IB": {
					complaint.setPriority("HIGH");
					System.out.println("Entered into database");
					break;
				}
				
				case "GB": {
					complaint.setPriority("MEDIUM");
					System.out.println("Entered into database");
					break;
				}
				
				case "OT": {
					complaint.setPriority("LOW");
					System.out.println("Entered into database");
					break;
				}
				}
				
				Integer complaintId = complaintService.raiseNewComplaint(complaint);

				return "SaveSuccess";
			} catch (ComplaintException e) {
				model.addAttribute("msg", "Insert failed. " + e.getMessage());
				return "ComplaintPage";
			}
		}

	}

	@RequestMapping("checkStatusPage.hr") 
	public String getStatusCheckPage(Model model) {
		Complaint complaint = new Complaint();
		model.addAttribute("complaint", complaint);
		System.out.println("In Status Check Page");
		return "CheckStatus";
	}
	
	@RequestMapping("checkStatus.hr") 
	public ModelAndView checkStatus(@RequestParam("id") Integer complaintId) {
		ModelAndView mAndV = new ModelAndView();
		try {
			Complaint complaint = complaintService.checkStatus(complaintId);
			mAndV.addObject("comlDetails", complaint);

			mAndV.setViewName("CheckStatus");

		} catch (ComplaintException e) {
			e.printStackTrace();
		}
		return mAndV;
	}

	public String getCategory(@RequestParam("category") String category) {
		return category;
	}

	
	 

}
