package sage.springcoder.jamhubservice.web.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sage.springcoder.jamhubservice.web.model.JamDto;

import java.util.UUID;

@RequestMapping("/api/v1/jam")
@RestController
public class JamController {

    @GetMapping({"/{jamId}"})
    public ResponseEntity<JamDto> getJamById(@PathVariable("jamId") UUID jamId) {
        //todo impl
        return new ResponseEntity<>(JamDto.builder().build(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveNewJam(@RequestBody JamDto jam) {
        //todo impl
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/{jamId}")
    public ResponseEntity updateJam(@PathVariable("jamId") UUID jamId, @RequestBody JamDto jam) {
        //todo impl
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{jamId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteJam(@PathVariable("jamId") UUID jamId) {
        //todo impl
    }

}
