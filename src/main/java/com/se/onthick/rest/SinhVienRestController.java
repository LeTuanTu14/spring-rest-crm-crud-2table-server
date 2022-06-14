package com.se.onthick.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.se.onthick.entity.SinhVien;
import com.se.onthick.service.SinhVienService;

@RestController
@RequestMapping("api")
public class SinhVienRestController {
	
	@Autowired
	private SinhVienService svService;
	
	@GetMapping("/sinhvienlop/{id}")
	public List<SinhVien> getSVByLop(@PathVariable String id){
		return svService.getSVByLop(id);
	}
	
	@GetMapping("/sinhvien/{id}")
	public SinhVien getSVById(@PathVariable int id) {
		return svService.getSVById(id);
	}
	
	@PostMapping("/sinhvien/{id}")
	public SinhVien addSV(@RequestBody SinhVien sv,@PathVariable int id) {
		sv.setId(0);
		svService.addSinhVien(sv,id);
		return sv;
	}
	
	@PutMapping("/sinhvien/{id}")
	public SinhVien updateSV(@RequestBody SinhVien sv,@PathVariable int id) {
		svService.addSinhVien(sv,id);
		return sv;
	}
	
	@DeleteMapping("sinhvien/{id}")
	public String deleteSV(@PathVariable int id) {
		SinhVien sv= svService.getSVById(id);
		if(sv == null) {
			return "Khong tim thay sinh vien";
		}
		svService.deleteSV(id);
		return "Xoa thanh cong sinh vien id="+id;
	}
}
