package com.learning.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.learning.model.RequestModel;
import com.learning.model.ResponseModel;



@RestController
public class MainController {

	@RequestMapping(value="/getDeliveryStatus", method=RequestMethod.POST, produces="Application/json")
	@CrossOrigin()
	public ResponseModel getEmployeeData(@RequestBody RequestModel requestModel){
		ResponseModel responseModel = new ResponseModel();
		String pincode = requestModel.getPincode();
		String paymentMode = requestModel.getPaymentMode();
		if (pincode.charAt(0)!='4' && paymentMode.equals("cod")) {
			responseModel.setMessage("Sorry Cash on Delivery to this pincode is not possible.");
		} else {
			responseModel.setMessage("Your order has been successfully placed.");
		}
		
		return responseModel;
	}
}
