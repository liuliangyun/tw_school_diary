package com.thoughtworks.practicediary.dto;

import com.thoughtworks.practicediary.entity.PracticeDiary;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageablePracticeDiaries {

    private List<PracticeDiary> practiceDiaries;
    private long totalElements;
    private int currentPage;

}
