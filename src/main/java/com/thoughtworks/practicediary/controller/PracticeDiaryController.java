package com.thoughtworks.practicediary.controller;

import com.thoughtworks.practicediary.entity.PracticeDiary;
import com.thoughtworks.practicediary.exception.PracticeDiaryNotFoundException;
import com.thoughtworks.practicediary.service.PracticeDiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping(value = "/practiceDiaries")
public class PracticeDiaryController {

    @Autowired
    private PracticeDiaryService practiceDiaryService;

    @PostMapping
    public ResponseEntity addPracticeDiary(@RequestBody PracticeDiary practiceDiary) {
        PracticeDiary returnedPracticeDiary = practiceDiaryService.addPracticeDiary(practiceDiary);
        String uri = String.format("/practiceDiaries/%s", returnedPracticeDiary.getId());
        return ResponseEntity.created(URI.create(uri)).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deletePracticeDiary(@PathVariable int id) {
        practiceDiaryService.deletePracticeDiary(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity updatePracticeDiary(@PathVariable int id, @RequestBody PracticeDiary practiceDiary) {
        practiceDiaryService.updatePracticeDiary(id, practiceDiary);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<Page> getAllPracticeDiary(
            @RequestParam(defaultValue = "0") int pageNum,
            @RequestParam(defaultValue = "3") int pageSize) {
        Page practiceDiaryPage = practiceDiaryService.getAllPracticeDiary(pageNum, pageSize);
        return ResponseEntity.ok(practiceDiaryPage);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private void praticeDiaryNotFoundException(PracticeDiaryNotFoundException ex) {

    }
}
