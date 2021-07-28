package com.example.demo.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controller.service.AppleService;

/**
 * @author Rajkumar Banala 15-Feb-2021
 *
 */

@RestController
@RequestMapping("/api/apple")
@Validated
public class AppleController {

	private static final Logger LOG = LoggerFactory.getLogger(AppleController.class);

	@Autowired
	private AppleService appleService;

	@PostMapping()
	public Map<String, Object> create(@RequestBody Map<String, Object> payload) {
		LOG.debug("create()");

		return appleService.create(payload);
	}
	
	@GetMapping("/{id}")
	public String get(@PathVariable String id) {
		LOG.debug("get()");

		return appleService.get(id);
	}
}
