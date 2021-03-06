package com.techelevator.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.dao.ProfileDAO;
import com.techelevator.exception.ProfileNotFoundException;
import com.techelevator.model.Profile;

@RestController
public class ProfileController {
	private ProfileDAO dao;

	public ProfileController(ProfileDAO dao) {
		this.dao = dao;
	}

	@RequestMapping(path="/profile/{username}", method = RequestMethod.GET)
	public int getProfileId(@PathVariable String username) {
		return dao.findIdByUsername(username);
	}
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(path="/profile", method = RequestMethod.POST)
	public int createProfile(Profile newProfile) {
		return this.dao.create(newProfile);
		
		
	}
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(path="/profile/{username}", method = RequestMethod.POST)
	public int updateProfile(Profile profile, String username) throws ProfileNotFoundException {
		return this.dao.updateProfile(profile, username);
	}
	
}