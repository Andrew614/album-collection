package com.wcci.albumcollection.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wcci.albumcollection.entities.Album;
import com.wcci.albumcollection.repositories.AlbumRepository;

@RestController
@RequestMapping("/api")
public class AlbumController {

	@Autowired
	private AlbumRepository albumRepo;

	@GetMapping("/albums")
	public Iterable<Album> findAllAlbums() {
		return albumRepo.findAll();
	}

	@GetMapping("/albums/{id}")
	public Album findOneAlbum(@PathVariable Long id) {
		return albumRepo.findById(id).get();
	}

	@PostMapping("/albums/{title}")
	public Album postOneAlbum(@PathVariable String title) {
		return albumRepo.save(new Album(title));

	}

}
