package com.back.stage.Controllers;


import com.back.stage.Entities.Suivi;
import com.back.stage.Services.ISuivi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class SuiviController {

    @Autowired
    ISuivi SuiviService;



    @GetMapping("/GetAll")
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(SuiviService.getAll(), HttpStatus.OK);


    }

    @PostMapping("/addsuivi")
    @ResponseBody
    public ResponseEntity<?> Add(@RequestBody Suivi s){
        Suivi sub = SuiviService.add(s);
        return new ResponseEntity<>( " Suivi added. ",  HttpStatus.OK);

    }

    @PostMapping ("/Modify")
    @ResponseBody
    public Suivi modify(@RequestBody Suivi su){

        return SuiviService.modify(su);
    }


}
