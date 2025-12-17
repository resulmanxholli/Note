package com.example.still.controllers;

import com.example.still.dtos.NoteDto;
import com.example.still.services.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final NoteService noteService;

    @GetMapping("/index")
    public String index(Model model){
        model.addAttribute("notes", noteService.getAll());
        return "index";
    }

    @GetMapping("/note")
    public String diqka(Model model){
        model.addAttribute("note", new NoteDto());
        return "new";
    }

    @PostMapping("/note")
    public String addNote(@ModelAttribute NoteDto noteDto){
        noteService.add(noteDto);
        return "redirect:/note";
    }
}
