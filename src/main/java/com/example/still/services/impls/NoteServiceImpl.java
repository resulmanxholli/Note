package com.example.still.services.impls;

import com.example.still.dtos.NoteDto;
import com.example.still.entities.NoteEntity;
import com.example.still.mappers.NoteMapper;
import com.example.still.repositories.NoteRepository;
import com.example.still.services.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService {
    private final NoteRepository repository;
    private final NoteMapper mapper;


    @Override
    public NoteDto add(NoteDto note) {
        NoteEntity propertyEntity = mapper.toEntity(note);
        repository.save(propertyEntity);
        return mapper.toDto(propertyEntity);
    }

    @Override
    public List<NoteDto> getAll() {
        List<NoteEntity> properties = repository.findAll();
        return mapper.toDtoList(properties);

    }

    @Override
    public NoteDto getOneById(Long id) {
        NoteEntity property = repository.findById(id).orElse(null);

        return mapper.toDto(property);
    }


}
