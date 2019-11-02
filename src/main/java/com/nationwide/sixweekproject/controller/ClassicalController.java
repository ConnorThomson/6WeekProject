package com.nationwide.sixweekproject.controller;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.nationwide.sixweekproject.data.ClassicalData;
import com.nationwide.sixweekproject.service.ClassicalService;

//the part that decides interactions between the database and the front end. 

@RestController
@CrossOrigin("*")
public class ClassicalController {
	@Autowired
	private ClassicalService classical;
	
	@GetMapping("/classical/showall")
	public ArrayList<ClassicalData> findAll(){
		return classical.findAll();
	}
	@CrossOrigin
	@PutMapping("/classical/update")
	public String Updaterecord(@RequestBody ClassicalData popdata) {
		return classical.Updaterecord(popdata);
	}
	@GetMapping("/classical/findbyartist/{artist}")
	public ArrayList<ClassicalData> findByArtist(@PathVariable String artist){
		return classical.findByArtist(artist);
	}
	
	@GetMapping("/classical/findbysong/{songtitle}")
	public ArrayList<ClassicalData> findbySong(@PathVariable String songtitle){
		return classical.findbySong(songtitle);
	}
	
	@PostMapping("/classical/add")
	public String addClassical(@RequestBody ClassicalData ref) {
		//ref.setSongnum(null);
		return classical.addClassical(ref);
	}
	
	@DeleteMapping("/classical/delete/{songnum}")
	public String deletePop(@PathVariable Integer songnum) {
		return classical.deleteClassical(songnum);
	}
}