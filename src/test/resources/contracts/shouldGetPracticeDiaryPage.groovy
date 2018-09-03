import org.springframework.cloud.contract.spec.Contract

Contract.make {
    name "should_get_practice_diary_page_groovy"
    request {
        method GET()
        url("/practiceDiaries")
    }
    response {
        status (200)
    }
}