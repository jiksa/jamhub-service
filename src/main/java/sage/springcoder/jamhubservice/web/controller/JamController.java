package sage.springcoder.jamhubservice.web.controller;

import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import sage.springcoder.jamhubservice.web.model.JamDto;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequestMapping("/api/v1/jam")
@RestController
public class JamController {

    @GetMapping({"/{jamId}"})
    public ResponseEntity<JamDto> getJamById(@NotNull  @PathVariable("jamId") UUID jamId) {
        //todo impl
        return new ResponseEntity<>(JamDto.builder().build(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveNewJam(@Validated @RequestBody JamDto jam) {
        //todo impl
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/{jamId}")
    public ResponseEntity updateJam(@PathVariable("jamId") UUID jamId, @Validated @RequestBody JamDto jam) {
        //todo impl
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{jamId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteJam(@PathVariable("jamId") UUID jamId) {
        //todo impl
    }

//    @ExceptionHandler(ConstraintViolationException.class)
//    public ResponseEntity<List> validationErrorHandler(ConstraintViolationException ex) {
//        List<String> errors = new ArrayList<>(ex.getConstraintViolations().size());
//        ex.getConstraintViolations().forEach(constraintViolation -> {
//            errors.add(constraintViolation.getPropertyPath()+" "+constraintViolation.getMessage());
//        });
//        return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
//    }

}
