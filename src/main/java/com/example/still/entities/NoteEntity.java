package com.example.still.entities;


import com.example.still.hepler.RandomIdGenerator;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "notes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NoteEntity {

    @Id
    private String id;

    @Column(columnDefinition = "TEXT")
    private String note;
}
