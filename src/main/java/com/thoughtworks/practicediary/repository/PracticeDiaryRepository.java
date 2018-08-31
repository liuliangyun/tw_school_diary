package com.thoughtworks.practicediary.repository;

import com.thoughtworks.practicediary.entity.PracticeDiary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PracticeDiaryRepository extends JpaRepository<PracticeDiary, Integer> {
}
