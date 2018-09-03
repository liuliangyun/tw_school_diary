package com.thoughtworks.practicediary.service;

import com.thoughtworks.practicediary.entity.PracticeDiary;
import com.thoughtworks.practicediary.exception.PracticeDiaryNotFoundException;
import com.thoughtworks.practicediary.repository.PracticeDiaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class PracticeDiaryService {

    @Autowired
    private PracticeDiaryRepository practiceDiaryRepository;

    public PracticeDiary addPracticeDiary(PracticeDiary practiceDiary) {
        return practiceDiaryRepository.save(practiceDiary);
    }

    public void deletePracticeDiary(int id) throws PracticeDiaryNotFoundException{
        practiceDiaryRepository.findById(id).orElseThrow(PracticeDiaryNotFoundException::new);
        practiceDiaryRepository.deleteById(id);
    }

    public void updatePracticeDiary (int id, PracticeDiary practiceDiary) throws PracticeDiaryNotFoundException {
        PracticeDiary selectedPracticeDiary = practiceDiaryRepository.findById(id).orElseThrow(PracticeDiaryNotFoundException::new);
        selectedPracticeDiary.setDate(practiceDiary.getDate());
        selectedPracticeDiary.setText(practiceDiary.getText());
        practiceDiaryRepository.save(selectedPracticeDiary);
    }

    public Page getAllPracticeDiary(int pageNum, int pageSize, Sort sort) {
        PageRequest pageRequest = PageRequest.of(pageNum, pageSize, sort);
        return practiceDiaryRepository.findAll(pageRequest);
    }
}
