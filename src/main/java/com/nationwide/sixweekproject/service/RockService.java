package com.nationwide.sixweekproject.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nationwide.sixweekproject.data.RockData;
import com.nationwide.sixweekproject.repository.RockRepository;

//my methods for me to perform functions e.g. adding, updating, removing

@Service
public class RockService {
	
	@Autowired
	private RockRepository rock;

	public ArrayList<RockData> findAll(){
		return rock.findAll();
	}
	public ArrayList<RockData> findByArtist(String artist){
		return rock.findByArtist(artist);
	}
	
	public ArrayList<RockData> findbySong(String songtitle){
		return rock.findBySongtitle(songtitle);
	}
	
	public String addRock(RockData ref) {
		rock.save(ref);
		return "Record added!!!! Thanks for contributing!!!";
	}
	public String deleteRock(Integer songsum) {
		RockData local =rock.findBySongnum(songsum);
		if(local==null) {
			return "Record has not been found - want to check that again????";
		}
		rock.deleteById(songsum);
		return "Record deleted!! Thanks for helping out";
	}
	
	public String Updaterecord(RockData rdata) {
		rock.saveAndFlush(rdata);
		return "REcord Edited";
	}
}
