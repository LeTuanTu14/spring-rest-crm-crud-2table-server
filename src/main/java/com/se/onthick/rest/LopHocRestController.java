package com.se.onthick.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.se.onthick.entity.LopHoc;
import com.se.onthick.service.LopService;

@RestController
@RequestMapping("api")
public class LopHocRestController {
	
	@Autowired
	private LopService lopService;
	
	@GetMapping("/lop")
	public List<LopHoc> getLopAll(){
		return lopService.getLop();
	}

}
