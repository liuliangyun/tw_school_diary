package com.thoughtworks.practicediary.service;

import com.thoughtworks.practicediary.dto.PageablePracticeDiaries;
import com.thoughtworks.practicediary.entity.PracticeDiary;
import com.thoughtworks.practicediary.exception.PracticeDiaryNotFoundException;
import com.thoughtworks.practicediary.repository.PracticeDiaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

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

    public PageablePracticeDiaries getAllPracticeDiary(int pageNum, int pageSize, int currentPage) {
        PageRequest pageRequest = PageRequest.of(pageNum, pageSize);

        Page<PracticeDiary> practiceDiaryPage = practiceDiaryRepository.findAll(pageRequest);
        return new PageablePracticeDiaries(practiceDiaryPage.getContent(),practiceDiaryPage.getTotalElements(),currentPage);
    }
}
