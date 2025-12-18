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
    public String show(Model model){
        model.addAttribute("note", noteService.create());
        return "notepad";
    }


    @PostMapping("/note/autosave")
    @ResponseBody
    public void autosave(@RequestBody NoteDto dto) {
        dto.setId(1L);
        noteService.add(dto);
    }


//    @GetMapping("/note")
//    public String show(Model model){
//        model.addAttribute("note", new NoteDto());
//        return "notepad";
//    }
//
//    @PostMapping("/note/autosave")
//    @ResponseBody
//    public void addNote(@RequestBody NoteDto noteDto){
//        noteDto.setId(1L);
//        noteService.add(noteDto);
//    }


}
