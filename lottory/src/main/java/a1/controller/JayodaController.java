package a1.controller;

import a1.dto.JayodaDto;
import a1.service.JayodaService;
import a1.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("jayoda")
@CrossOrigin
public class JayodaController {
    @Autowired
    JayodaService jayodaService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllJLottory() {
        return new ResponseUtil(200, "OK", jayodaService.getAllJLottory());
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveJLottory(@ModelAttribute JayodaDto Jlottory) {
        jayodaService.saveJLottory(Jlottory);
        return new ResponseUtil(200, "Save", null);
    }

    @GetMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchJlottory(@PathVariable String id) {
        return new ResponseUtil(200,"Ok",jayodaService.searchJlottory(id));
    }
}