package com.example.still.services;

import com.example.still.dtos.NoteDto;

import java.util.List;

public interface NoteService {
    public NoteDto add(NoteDto content);
    public NoteDto create();
    public NoteDto getId(String id);
    public NoteDto update(String id, NoteDto content);

}
