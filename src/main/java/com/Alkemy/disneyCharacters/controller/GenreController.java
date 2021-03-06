package com.Alkemy.disneyCharacters.controller;

import com.Alkemy.disneyCharacters.dto.GenreDTO;
import com.Alkemy.disneyCharacters.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("genres")

public class GenreController {

    @Autowired
    private GenreService genreService;

    @PostMapping
    public ResponseEntity<GenreDTO> save(@RequestBody GenreDTO genre) {
        GenreDTO genreSaved = genreService.save(genre);
        return ResponseEntity.status(HttpStatus.CREATED).body(genreSaved);
    }

    @GetMapping
    public ResponseEntity<List<GenreDTO>> getAll() {
        List<GenreDTO> genres = genreService.getAllGenres();
        return ResponseEntity.ok().body(genres);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        genreService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenreDTO> update(@PathVariable Long id, @RequestBody GenreDTO genreDTO) {
        GenreDTO result = genreService.update(id, genreDTO);
        return ResponseEntity.ok().body(result);
    }
}
