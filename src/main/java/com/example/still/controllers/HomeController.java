package com.example.still.controllers;

import com.example.still.dtos.NoteDto;
import com.example.still.hepler.RandomIdGenerator;
import com.example.still.services.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final NoteService noteService;

    @GetMapping("/note/{id}")
    public String show(@PathVariable String id, Model model){

        model.addAttribute("note", noteService.getId(id));
        return "note/notepad";
    }

    @GetMapping("/note")
    public String createAndRedirect() {
        NoteDto noteDto= noteService.create();
        return "redirect:/note/" + noteDto.getId();
    }

    @PostMapping("/note/{id}")
    public String update(@PathVariable String id, @ModelAttribute NoteDto dto) {
        noteService.add(dto);
        return "redirect:/note/" + id;
    }

    @PostMapping("/note/autosave")
    @ResponseBody
    public void autosave(@RequestBody NoteDto dto) {
        noteService.update(dto.getId(),dto);
    }


}
