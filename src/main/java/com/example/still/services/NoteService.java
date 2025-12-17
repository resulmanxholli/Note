package com.example.still.services;

import com.example.still.dtos.NoteDto;

import java.util.List;

public interface NoteService {
    public NoteDto add(NoteDto note);
    public List<NoteDto> getAll();
    public NoteDto getOneById(Long id);

}
