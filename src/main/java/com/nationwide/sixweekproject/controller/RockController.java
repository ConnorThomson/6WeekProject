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
import com.nationwide.sixweekproject.data.RockData;
import com.nationwide.sixweekproject.service.RockService;

//the part that decides interactions between the database and the front end. 

@RestController
@CrossOrigin("*")
public class RockController {
	@Autowired
	private RockService rock;
	
	@GetMapping("/rock/showall")
	public ArrayList<RockData> findAll(){
		return rock.findAll();
	}
	@CrossOrigin
	@PutMapping("/rock/update")
	public String Updaterecord(@RequestBody RockData rockdata) {
		return rock.Updaterecord(rockdata);
	}
	@GetMapping("/rock/findbyartist/{artist}")
	public ArrayList<RockData> findByArtist(@PathVariable String artist){
		return rock.findByArtist(artist);
	}
	
	@GetMapping("/rock/findbysong/{songtitle}")
	public ArrayList<RockData> findbySong(@PathVariable String songtitle){
		return rock.findbySong(songtitle);
	}
	
	@PostMapping("/rock/add")
	public String addRock(@RequestBody RockData ref) {
		//ref.setSongnum(null);
		return rock.addRock(ref);
	}
	
	@DeleteMapping("/rock/delete/{songnum}")
	public String deleteRock(@PathVariable Integer songnum) {
		return rock.deleteRock(songnum);
	}
}
