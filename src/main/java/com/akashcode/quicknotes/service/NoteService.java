package com.akashcode.quicknotes.service;

import com.akashcode.quicknotes.model.Note;
import com.akashcode.quicknotes.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    // Create a new note
    public Note createNote(Note note) {
        if (note.getShareURL() == null) {
            note.setShareURL(UUID.randomUUID().toString()); // Generate shareURL if not provided
        }
        return noteRepository.save(note);
    }

    // Get all notes
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    // Get note by ID
    public Optional<Note> getNoteById(Long id) {
        return noteRepository.findById(id);
    }

    // Update an existing note
    public Note updateNote(Long id, Note noteDetails) {
        Optional<Note> noteOpt = noteRepository.findById(id);
        if (noteOpt.isPresent()) {
            Note note = noteOpt.get();
            note.setTitle(noteDetails.getTitle());
            note.setContent(noteDetails.getContent());
            note.setUpdatedAt(LocalDateTime.now());
            return noteRepository.save(note);
        } else {
            return null; // If note not found, return null or handle with custom exception
        }
    }

    // Delete a note by ID
    public void deleteNote(Long id) {
        noteRepository.deleteById(id);
    }

    // Get note by shareURL
    public Optional<Note> getNoteByShareURL(String shareURL) {
        return noteRepository.findByShareURL(shareURL);
    }
}
