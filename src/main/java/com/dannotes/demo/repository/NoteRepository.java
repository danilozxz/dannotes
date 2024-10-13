package com.dannotes.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dannotes.demo.model.Note;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
    
}
