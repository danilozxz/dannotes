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

import com.dannotes.demo.model.Folder;
import com.dannotes.demo.service.FolderService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "api/folder")
public class FolderController {
    @Autowired
    public FolderService folderService;

    @PostMapping(value = "/add")
    public Folder insertFolder(@RequestBody Folder folder) {
        return folderService.insertFolder(folder);
    }

    @GetMapping(value = "/all")
    public List<Folder> findAllFolders () {
        return folderService.findAllFolders();
    }

    @GetMapping(value = "/{id}")
    public Optional<Folder> findFolderById (@PathVariable Long id) {
        return folderService.findFolderById(id);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteFolderById (@PathVariable Long id) {
        folderService.deleteFolderById(id);
    }

    @PutMapping(value = "/update/{id}")
    public Folder updateFolder(@PathVariable Long id, @RequestBody Folder folderDetails) {
        return folderService.updateFolder(id, folderDetails);
    }
}

