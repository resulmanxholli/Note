package com.example.still.services.impls;

import com.example.still.dtos.NoteDto;
import com.example.still.entities.NoteEntity;
import com.example.still.hepler.RandomIdGenerator;
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
        if (dto.getId() == null || dto.getId().isBlank()) {
            dto.setId(RandomIdGenerator.generate());
        }
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    @Override
    public NoteDto create() {
        String id = RandomIdGenerator.generate();
        NoteEntity note = new NoteEntity();
        note.setId(id);
        note.setNote("");
        repository.save(note);
        return mapper.toDto(note);
    }

    @Override
    public NoteDto getId(String id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseGet(() -> {
                    NoteEntity note = new NoteEntity();
                    note.setId(id);
                    note.setNote("");
                    repository.save(note);
                    return mapper.toDto(note);
                });
    }

    @Override
    public NoteDto update(String id, NoteDto content) {
        var entity = mapper.toEntity(content);
        entity.setId(id);
        repository.save(entity);

        return mapper.toDto(entity);
    }


}
