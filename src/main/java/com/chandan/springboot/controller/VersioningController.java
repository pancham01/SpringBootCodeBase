package com.chandan.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chandan.springboot.entity.Name;
import com.chandan.springboot.entity.UserV1;
import com.chandan.springboot.entity.UserV2;

@RestController
public class VersioningController {

	@GetMapping("/v1/getUser")
	public UserV1 getUserV1()
	{
		System.out.println("VersioningController.getUserV1()");
		return new UserV1("Mukesh Singh");
	}
	
	@GetMapping("/v2/getUser")
	public UserV2 getUserV2()
	{
		System.out.println("VersioningController.getUserV2()");
		return new UserV2(new Name("Mukesh","Kumar"));
	}
}
