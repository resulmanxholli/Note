package com.example.still.mappers;

import com.example.still.dtos.NoteDto;
import com.example.still.entities.NoteEntity;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface NoteMapper extends BaseMapper<NoteDto, NoteEntity>{
}
