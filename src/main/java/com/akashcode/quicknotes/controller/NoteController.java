package com.akashcode.quicknotes.controller;

import com.akashcode.quicknotes.model.Note;
import com.akashcode.quicknotes.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/notes")
@CrossOrigin(origins = "*") // Allow CORS for all origins (can be restricted later)
public class NoteController {

    @Autowired
    private NoteService noteService;

    // Create a new note
    @PostMapping
    public Note createNote(@RequestBody Note note) {
        return noteService.createNote(note);
    }

    // Get all notes
    @GetMapping
    public List<Note> getAllNotes() {
        return noteService.getAllNotes();
    }

    // Get note by ID
    @GetMapping("/{id}")
    public Optional<Note> getNoteById(@PathVariable Long id) {
        return noteService.getNoteById(id);
    }

    // Update an existing note
    @PutMapping("/{id}")
    public Note updateNote(@PathVariable Long id, @RequestBody Note noteDetails) {
        return noteService.updateNote(id, noteDetails);
    }

    // Delete a note by ID
    @DeleteMapping("/{id}")
    public void deleteNote(@PathVariable Long id) {
        noteService.deleteNote(id);
    }

    // Get note by shareURL
    @GetMapping("/share/{shareURL}")
    public Optional<Note> getNoteByShareURL(@PathVariable String shareURL) {
        return noteService.getNoteByShareURL(shareURL);
    }
}
