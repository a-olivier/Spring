package com.me.spring.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hello.Greeting;

@RestController
public class GrettingsController {

	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping("/greetings")
	public Greeting hello(@RequestParam(value="name", defaultValue = "World") String name){
		return new Greeting(counter.incrementAndGet(), "Bonjour " + name);
	}
	
}