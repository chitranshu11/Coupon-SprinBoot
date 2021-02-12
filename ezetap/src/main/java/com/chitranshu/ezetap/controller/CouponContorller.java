package com.chitranshu.ezetap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chitranshu.ezetap.json.CouponRequest;
import com.chitranshu.ezetap.json.CouponResponse;
import com.chitranshu.ezetap.model.Coupon;
import com.chitranshu.ezetap.service.CouponService;

@RestController
@RequestMapping("api")
public class CouponContorller {
	
	@Autowired
	CouponService couponService;
	
	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json") 
	public ResponseEntity<CouponResponse> addCoupon(@RequestBody Coupon coupon) {
		
		CouponResponse response = new CouponResponse();
		try {
			Coupon tempCoupon = couponService.createCoupon(coupon);
			response.setMessage("Coupon created successfully");
			response.setCoupon(tempCoupon);
			
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		catch (Exception e) {
			response.setMessage("Something went wrong");
			response.setResponseDescription(e.getLocalizedMessage());
			
			return new ResponseEntity<> (response, HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@RequestMapping(value ="/redeem", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<CouponResponse> redeemCoupon(@RequestBody CouponRequest request) {
		
		CouponResponse response = new CouponResponse();
		try {
			Coupon tempCoupon = couponService.getCoupon(request.getName(), request.getAmount());
			response.setMessage("Coupon fetched successfully");
			response.setCoupon(tempCoupon);
			
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		catch (Exception e) {
			response.setMessage(e.getMessage());
			//response.setResponseDescription(e.getLocalizedMessage());
			return new ResponseEntity<> (response, HttpStatus.BAD_REQUEST);
		}
	}

}
