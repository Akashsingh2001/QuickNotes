package com.akashcode.quicknotes.repository;

import com.akashcode.quicknotes.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface NoteRepository extends JpaRepository<Note, Long> {
    // Find a note by its unique share URL
    Optional<Note> findByShareURL(String shareURL);
}
