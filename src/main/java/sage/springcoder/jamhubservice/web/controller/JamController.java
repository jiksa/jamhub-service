package sage.springcoder.jamhubservice.web.controller;

import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import sage.springcoder.jamhubservice.web.model.JamDto;
import sage.springcoder.jamhubservice.web.model.JamFlavorEnum;
import sage.springcoder.jamhubservice.web.model.JamPagedList;
import sage.springcoder.jamhubservice.web.service.JamService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@RequestMapping("/api/v1/jam")
@RestController
@RequiredArgsConstructor
public class JamController {

    private final JamService jamService;

    private static final Integer DEFAULT_PAGE_NUMBER = 0;
    private static final Integer DEFAULT_PAGE_SIZE = 25;

    @GetMapping({"/{jamId}"})
    public ResponseEntity<JamDto> getJamById(@NotNull  @PathVariable("jamId") UUID jamId,
                                             @RequestParam(value = "showInventoryOnHand", required = false) Boolean showInventoryOnHand) {
        if(showInventoryOnHand == null){
            showInventoryOnHand = false;
        }
        return new ResponseEntity<>(jamService.getJamById(jamId,showInventoryOnHand), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveNewJam(@Validated @RequestBody JamDto jam) {
        return new ResponseEntity(jamService.saveNewJam(jam),HttpStatus.CREATED);
    }

    @PutMapping("/{jamId}")
    public ResponseEntity updateJam(@PathVariable("jamId") UUID jamId, @Validated @RequestBody JamDto jam) {
        //todo impl
        return new ResponseEntity(jamService.updateJam(jamId,jam),HttpStatus.NO_CONTENT);
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

    @GetMapping(produces = { "application/json" }, path = "jamList")
    public ResponseEntity<JamPagedList> listJams(@RequestParam(value = "pageNumber", required = false) Integer pageNumber,
                                                  @RequestParam(value = "pageSize", required = false) Integer pageSize,
                                                  @RequestParam(value = "jamName", required = false) String jamName,
                                                  @RequestParam(value = "jamFlavor", required = false) String jamFlavor,
                                                  @RequestParam(value = "showInventoryOnHand", required = false) Boolean showInventoryOnHand){

        if (showInventoryOnHand == null) {
            showInventoryOnHand = false;
        }

        if (pageNumber == null || pageNumber < 0){
            pageNumber = DEFAULT_PAGE_NUMBER;
        }

        if (pageSize == null || pageSize < 1) {
            pageSize = DEFAULT_PAGE_SIZE;
        }

        JamPagedList jamList = jamService.listJams(jamName, jamFlavor, PageRequest.of(pageNumber, pageSize), showInventoryOnHand);

        return new ResponseEntity<>(jamList, HttpStatus.OK);
    }



}
