import org.springframework.cloud.contract.spec.Contract

Contract.make {
    name "should_delete_a_practice_diary_groovy"
    request {
        method DELETE()
        url("/practiceDiaries/3")
    }
    response {
        status(204)
    }
}