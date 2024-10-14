package com.dannotes.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dannotes.demo.model.Folder;

public interface FolderRepository extends JpaRepository<Folder, Long>{
    
}
