package com.thoughtworks.practicediary.controller;

import com.thoughtworks.practicediary.entity.PracticeDiary;
import com.thoughtworks.practicediary.service.PracticeDiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/practiceDiaries")
public class PracticeDiaryController {

    @Autowired
    private PracticeDiaryService practiceDiaryService;

    @PostMapping
    public ResponseEntity addPracticeDiary(@RequestBody PracticeDiary practiceDiary){
        practiceDiaryService.addPracticeDiary(practiceDiary);
        return ResponseEntity.ok().build();
    }

}
