package com.example.still.repositories;

import com.example.still.entities.NoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NoteRepository extends JpaRepository<NoteEntity,String> {
    Optional<NoteEntity> findById(String id);
}
