package com.example.demo.service.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.controller.service.impl.AppleServiceImpl;

/**
 * @author Rajkumar Banala 05-Mar-2021
 *
 */

@ExtendWith(MockitoExtension.class)
class AppleServiceImplTests {

	@InjectMocks
	AppleServiceImpl appleServiceImpl;

	@Test
	@DisplayName("create")
	void create() {

		// test
		Map<String, Object> data = new HashMap<>();
		Map<String, Object> value = appleServiceImpl.create(data);

		// expect
		assertThat(value).isNotNull();
	}
}
