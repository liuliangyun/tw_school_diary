import org.springframework.cloud.contract.spec.Contract

Contract.make {
    name "should_update_a_practice_diary_groovy"
    request {
        method PUT()
        headers {
            contentType(applicationJson())
        }
        body(file("updatedPracticeDiary.json"))
        url("/practiceDiaries/2")
    }
    response {
        status(204)
    }
}