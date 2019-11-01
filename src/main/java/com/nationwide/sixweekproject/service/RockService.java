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
	public String updateRockArtist(Integer songnum, String artist) {
		RockData local =rock.findBySongnum(songnum);
		ArrayList <RockData> rockArrayList = rock.findAll();
		if(local==null) {
			return "Record has not been found - want to check that again????";
		}
		for(RockData X: rockArrayList) {
			if(X.getSongnum()==songnum) {
				X.setArtist(artist);
				rock.save(X);
			}
		}
		return "Record updated - thanks for helping out";
	}
	
	public String updateRockSongTitle(Integer songnum, String songtitle) {
		RockData local =rock.findBySongnum(songnum);
		ArrayList <RockData> rockArrayList = rock.findAll();
		if(local==null) {
			return "Record has not been found - want to check that again????";
		}
		for(RockData X: rockArrayList) {
			if(X.getSongnum()==songnum) {
				X.setSongtitle(songtitle);
				rock.save(X);
			}
		}
		return "Record updated - thanks for helping out";
	}
	
	public String updateRockLink(Integer songnum, String link) {
		RockData local =rock.findBySongnum(songnum);
		ArrayList <RockData> rockArrayList = rock.findAll();		
		if(local==null) {
			return "Record has not been found - want to check that again????";
		}
		for(RockData X: rockArrayList) {
			if(X.getSongnum()==songnum) {
				X.setLink("https://"+link);
				rock.save(X);
			}
		}
		
		
		return "Record updated - thanks for helping out";
	}
	
	public String Updaterecord(RockData rdata) {
		rock.saveAndFlush(rdata);
		return "REcord Edited";
	}
}
