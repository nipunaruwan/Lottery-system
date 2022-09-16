package a1.controller;

import a1.dto.GovisethaDto;
import a1.service.GovisethaService;
import a1.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Govisetha")
@CrossOrigin
public class GovisethaController {
    @Autowired
    GovisethaService govisethaService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllGlottory(){ return new ResponseUtil(200,"OK",govisethaService.getAllGlottory());}

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveGlottory(@ModelAttribute GovisethaDto Glottory) {
        govisethaService.saveGlottory(Glottory);
        return new ResponseUtil(200,"Save",null);
    }

    @GetMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchGlottory(@PathVariable String id) {
        return new ResponseUtil(200,"Ok",govisethaService.searchGlottory(id));
    }
}


