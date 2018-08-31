import org.springframework.cloud.contract.spec.Contract

Contract.make {
    name "should_add_a_practice_diary_groovy"
    request {
        method POST()
        headers {
            contentType(applicationJson())
        }
        body(file("addedPracticeDiary.json"))
        url("/practiceDiaries")

    }
    response {
        status(201)
    }
}