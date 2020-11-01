package meemo.campaigns.adapter

import meemo.service.api.model.ErrorModel
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.lang.IllegalArgumentException

@RestControllerAdvice
class CampaignRestErrorHandler {

    @ExceptionHandler(IllegalArgumentException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun campaignNotFound(): ResponseEntity<ErrorModel> {
        return ResponseEntity.status(400).body(ErrorModel(
                "400100",
                "Wrong parameter"
        ))
    }

}
