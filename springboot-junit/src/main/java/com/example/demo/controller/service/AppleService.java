package com.example.demo.controller.service;

import java.util.Map;

/**
 * @author Rajkumar Banala 04-Mar-2021
 *
 */

public interface AppleService {
	
	public Map<String, Object> create(Map<String, Object> value);
	
	public String get(String id);
}
