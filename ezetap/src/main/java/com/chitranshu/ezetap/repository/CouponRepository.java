package com.chitranshu.ezetap.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.chitranshu.ezetap.model.Coupon;

@Repository
public interface CouponRepository extends JpaRepository<Coupon,Long> {
	
	@Query("select e from Coupon e where e.name=:name and e.amount >= :amount")
	public List<Coupon> findByNameAndAmount(String name, Long amount);
	
	public List<Coupon> findByName(String name);

}
