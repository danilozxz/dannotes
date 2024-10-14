package com.dannotes.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dannotes.demo.model.Folder;
import com.dannotes.demo.repository.FolderRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FolderService {
    @Autowired
    private FolderRepository folderRepository;

    public Folder insertFolder(Folder folder) {
        return folderRepository.save(folder);
    }

    public List<Folder> findAllFolders() {
        return folderRepository.findAll();
    }

    public Optional<Folder> findFolderById(Long id) {
        Optional<Folder> opFolder = folderRepository.findById(id);

        if(opFolder.isEmpty()) {
            System.out.println("Pasta não localizada");
        }

        return folderRepository.findById(id);
    }

    public void deleteFolderById(Long id) {
        Optional<Folder> opFolder = folderRepository.findById(id);

        if (opFolder.isEmpty()) {
            System.out.println("Pasta não localizada");
        }
        
        folderRepository.deleteById(id);
    }

    public Folder updateFolder (Long id, Folder folderDetails) {
        Optional<Folder> opFolder = folderRepository.findById(id);

        if (opFolder.isEmpty()) {
            System.out.println("Pasta não localizada");
        }

        Folder folder = opFolder.get();
        folder.setUser(folderDetails.getUser());
        folder.setName(folderDetails.getName());
        folder.setNotes(folderDetails.getNotes());

        return folderRepository.save(folder);
    }

}
