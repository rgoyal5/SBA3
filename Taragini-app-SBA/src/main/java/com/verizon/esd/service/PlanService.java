package com.verizon.esd.service;

import java.util.List;

import com.verizon.esd.model.Plan;

public interface PlanService {
	public boolean exists(String pTitle);
	public Plan getPlan(String pTitle);
	public List<Plan> getAllPlans();
	public List<Plan> getPlansBySpeed(int speed);
	public List<Plan> getPlansByUsage(int maxUsage);	
}