package com.dannotes.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dannotes.demo.model.Note;
import com.dannotes.demo.service.NoteService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "api/note")
public class NoteController {
    @Autowired
    public NoteService noteService;

    @PostMapping(value = "/add")
    public Note insertNote(@RequestBody Note note) {
        return noteService.insertNote(note);
    }

    @GetMapping(value = "/all")
    public List<Note> findAllNotes() {
        return noteService.findAllNotes();
    }

    @GetMapping(value = "/{id}")
    public Optional<Note> findNoteById(@PathVariable Long id) {
        return noteService.findNoteById(id);
    }

    @DeleteMapping(value = "delete/{id}")
    public void deleteNoteById (@PathVariable Long id) {
        noteService.deleteNoteById(id);
    }

    @PutMapping(value = "update/{id}")
    public Note updateNote(@PathVariable Long id, @RequestBody Note noteDetails) {
        return noteService.updateNote(id, noteDetails);
    }
    
}