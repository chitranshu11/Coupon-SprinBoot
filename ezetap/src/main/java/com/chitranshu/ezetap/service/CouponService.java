package com.chitranshu.ezetap.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chitranshu.ezetap.exception.AmountLessException;
import com.chitranshu.ezetap.exception.CouponNotFoundException;
import com.chitranshu.ezetap.model.Coupon;
import com.chitranshu.ezetap.repository.CouponRepository;

@Service
public class CouponService {
	@Autowired
	CouponRepository couponRepository;
	
	public Coupon createCoupon(Coupon coupon) {
		Coupon savedCoupon = couponRepository.save(coupon);
		return savedCoupon;
	}
	
	public Coupon getCoupon(String name, Long amount) throws CouponNotFoundException, AmountLessException {
		
		List<Coupon> coupons = couponRepository.findByNameAndAmount(name, amount);
		if(coupons.size() > 0) return coupons.get(0);
		
		coupons = couponRepository.findByName(name);
		
		if(coupons.size() == 0) {
			throw new CouponNotFoundException("Coupon doesn't exist with name: " + name);
		}
		else {
			throw new AmountLessException("Coupon doesn't exist for given amount, Multiple coupons cannot be clubbed");
		}
	
	}

}
