package com.thoughtworks.practicediary.service;

import com.thoughtworks.practicediary.entity.PracticeDiary;
import com.thoughtworks.practicediary.repository.PracticeDiaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PracticeDiaryService {

    @Autowired
    private PracticeDiaryRepository practiceDiaryRepository;

    public void addPracticeDiary(PracticeDiary practiceDiary) {
        practiceDiaryRepository.save(practiceDiary);
    }
}
