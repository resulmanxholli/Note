package com.example.still.controllers;

import com.example.still.dtos.NoteDto;
import com.example.still.services.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final NoteService noteService;

    @GetMapping("/note")
    public String diqka(Model model){
        NoteDto note;
        try {
            note = noteService.findOneById(1L);
        } catch (Exception e) {
            note = new NoteDto(1L, "");
            noteService.add(note);
        }
        model.addAttribute("note", note);
        return "new";
    }


    @PostMapping("/note/autosave")
    @ResponseBody
    public void autosave(@RequestBody NoteDto dto) {
        dto.setId(1L);
        noteService.add(dto);
    }


}
