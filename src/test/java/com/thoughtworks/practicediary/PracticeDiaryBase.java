package com.thoughtworks.practicediary;

import com.github.database.rider.core.api.configuration.DBUnit;
import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.spring.api.DBRider;
import com.thoughtworks.practicediary.controller.PracticeDiaryController;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PracticeDiaryApplication.class, webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@DBUnit(caseSensitiveTableNames = true)
@DBRider
@ActiveProfiles("test")
@DataSet("diary.yml")
public abstract class PracticeDiaryBase {
    @Autowired
    private PracticeDiaryController practiceDiaryController;

    @Before
    public void setup() {
        StandaloneMockMvcBuilder standaloneMockMvcBuilder = MockMvcBuilders.standaloneSetup(practiceDiaryController);
        RestAssuredMockMvc.standaloneSetup(standaloneMockMvcBuilder);
    }
}