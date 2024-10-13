package com.dannotes.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dannotes.demo.model.Note;
import com.dannotes.demo.repository.NoteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService {
    @Autowired
    private NoteRepository noteRepository;

    public Note insertNote(Note note) {
        return noteRepository.save(note);
    }

    public List<Note> findAllNotes() {
        return noteRepository.findAll();
    }

    public Optional<Note> findNoteById(Long id) {
        Optional<Note> opNote = noteRepository.findById(id);

        if (opNote.isEmpty()) {
            System.out.println("Anotação não encontrada");
        }

        return noteRepository.findById(id);
    }

    public void deleteNoteById(Long id) {
        Optional<Note> opNote = findNoteById(id);

        if (opNote.isEmpty()) {
            System.out.println("Anotação não encontrada");
        }

        noteRepository.deleteById(id);
    }

    public Note updateNote (Long id, Note noteDetails) {
        Optional<Note> opNote = findNoteById(id);

        if(opNote.isEmpty()) {
            System.out.println("Anotação não encontrada");
        }

        Note note = opNote.get();
        note.setTitle(noteDetails.getTitle());
        note.setContent(noteDetails.getContent());
        note.setUser(noteDetails.getUser());

        return noteRepository.save(note);
    }
}
