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
    public NoteDto add(NoteDto dto) {
        dto.setId(1L);
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    @Override
    public NoteDto create() {
        NoteEntity entity = repository.findById(1L).orElse(null);

        if (entity == null) {
            entity = new NoteEntity();
            entity.setNote("");
            repository.save(entity);
        }

        return mapper.toDto(entity);
    }


}
