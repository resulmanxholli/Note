package com.example.still.repositories;

import com.example.still.entities.NoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<NoteEntity,Long> {
}
