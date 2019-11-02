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
import com.nationwide.sixweekproject.data.DanceData;
import com.nationwide.sixweekproject.service.DanceService;

//the part that decides interactions between the database and the front end. 

@RestController
@CrossOrigin("*")
public class DanceController {
	@Autowired
	private DanceService dance;
	
	@GetMapping("/dance/showall")
	public ArrayList<DanceData> findAll(){
		return dance.findAll();
	}
	@CrossOrigin
	@PutMapping("/dance/update")
	public String Updaterecord(@RequestBody DanceData popdata) {
		return dance.Updaterecord(popdata);
	}
	@GetMapping("/dance/findbyartist/{artist}")
	public ArrayList<DanceData> findByArtist(@PathVariable String artist){
		return dance.findByArtist(artist);
	}
	
	@GetMapping("/dance/findbysong/{songtitle}")
	public ArrayList<DanceData> findbySong(@PathVariable String songtitle){
		return dance.findbySong(songtitle);
	}
	
	@PostMapping("/dance/add")
	public String addDance(@RequestBody DanceData ref) {
		//ref.setSongnum(null);
		return dance.addDance(ref);
	}
	
	@DeleteMapping("/dance/delete/{songnum}")
	public String deleteDance(@PathVariable Integer songnum) {
		return dance.deleteDance(songnum);
	}
}