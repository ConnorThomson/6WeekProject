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
import com.nationwide.sixweekproject.data.PopData;
import com.nationwide.sixweekproject.service.PopService;

//the part that decides interactions between the database and the front end. 

@RestController
@CrossOrigin("*")
public class PopController {
	@Autowired
	private PopService pop;
	
	@GetMapping("/pop/showall")
	public ArrayList<PopData> findAll(){
		return pop.findAll();
	}
	@CrossOrigin
	@PutMapping("/pop/update")
	public String Updaterecord(@RequestBody PopData popdata) {
		return pop.Updaterecord(popdata);
	}
	@GetMapping("/pop/findbyartist/{artist}")
	public ArrayList<PopData> findByArtist(@PathVariable String artist){
		return pop.findByArtist(artist);
	}
	
	@GetMapping("/pop/findbysong/{songtitle}")
	public ArrayList<PopData> findbySong(@PathVariable String songtitle){
		return pop.findbySong(songtitle);
	}
	
	@PostMapping("/pop/add")
	public String addPop(@RequestBody PopData ref) {
		//ref.setSongnum(null);
		return pop.addPop(ref);
	}
	
	@DeleteMapping("/pop/delete/{songnum}")
	public String deletePop(@PathVariable Integer songnum) {
		return pop.deletePop(songnum);
	}
}