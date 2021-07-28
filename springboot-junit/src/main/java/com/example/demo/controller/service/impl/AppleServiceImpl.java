package com.example.demo.controller.service.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.demo.controller.service.AppleService;

/**
 * @author Rajkumar Banala 04-Mar-2021
 *
 */

@Service
public class AppleServiceImpl implements AppleService {

	private static final Logger LOG = LoggerFactory.getLogger(AppleServiceImpl.class);

	public Map<String, Object> create(Map<String, Object> value) {
		LOG.debug("create()");
		return value;
	}
	
	public String get(String id) {
		LOG.debug("get()");
		
		return id;
	}
}
