package com.back.stage.Controllers;


import com.back.stage.Entities.Validation;
import com.back.stage.Services.IValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Val")
public class ValidationController {

    @Autowired
    IValidation ValService;


    @GetMapping("/getValforEn/{id}")
    public ResponseEntity<?> getValEn(@PathVariable long id){

        return new ResponseEntity<>( ValService.getValforEn((int) id), HttpStatus.OK);
    }

    @PostMapping("/addValEt/{idEt}")
    @ResponseBody
    public ResponseEntity<?> AddEt(@RequestBody Validation vali ,  @PathVariable long idEt){
        Validation val = ValService.AddValforEt(idEt, vali.getPresentation(), vali.getRapport(),vali.getTravail());
        return new ResponseEntity<>( " validation docs added by etudiant. ",  HttpStatus.OK);

    }

    @PostMapping("/addValEn/{idEn}")
    @ResponseBody
    public ResponseEntity<?> AddEn(@RequestBody  Validation valid, @PathVariable long idEn){
       Validation val = ValService.AddValforEn(idEn,valid.getNote(),valid.isValiderF());
        return new ResponseEntity<>( " Suivi added by enseignant. ",  HttpStatus.OK);
    }

    @PostMapping("/ValAnother/{idEn}")
    @ResponseBody
    public ResponseEntity<?>  AddEnAnother(@RequestBody Validation s, @PathVariable long idEn){
        Validation su =  ValService.AddEnAnother(s.getIDv(),idEn,s.getNote(),s.isValiderF());
        return new ResponseEntity<>( " validation added by enseignant. again ",  HttpStatus.OK);
    }
}
