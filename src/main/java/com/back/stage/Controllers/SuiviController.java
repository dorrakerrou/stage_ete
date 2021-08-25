package com.back.stage.Controllers;


import com.back.stage.Entities.Suivi;
import com.back.stage.Services.ISuivi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Suivi")
public class SuiviController {

    @Autowired
    ISuivi SuiviService;



    @GetMapping("/GetAll")
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(SuiviService.getAll(), HttpStatus.OK);


    }

    @PostMapping("/addsuiviEt/{idEt}")
    @ResponseBody
    public ResponseEntity<?> Add(@RequestBody Suivi s ,@PathVariable long idEt){
        Suivi sub = SuiviService.addEt(s.getTaches(),s.getNom_equipe(),idEt);
        return new ResponseEntity<>( " Suivi added by etudiant. ",  HttpStatus.OK);

    }

    @PostMapping ("/Modify")
    @ResponseBody
    public Suivi modify(@RequestBody Suivi su){

        return SuiviService.modify(su);
    }


    @PostMapping("/another/{idEn}")
    @ResponseBody
    public ResponseEntity<?>  AddEnAnotherOne(@RequestBody Suivi s, @PathVariable long idEn){
        Suivi su =  SuiviService.AnotherOne(s.getIDs(),s.getRemarque(),s.isValider(), idEn);
        return new ResponseEntity<>( " Suivi added by enseignant. again ",  HttpStatus.OK);
    }

    @PostMapping("/addsuiviEn/{idEn}")
@ResponseBody
    public ResponseEntity<?> AddEn(@RequestBody  Suivi s, @PathVariable long idEn){
        Suivi su = SuiviService.AddEn(s.getRemarque(),s.isValider(),idEn);
        return new ResponseEntity<>( " Suivi added by enseignant. ",  HttpStatus.OK);
    }

    @GetMapping("/getSuiviforEn/{id}")
    public ResponseEntity<?> getSuiviEn(@PathVariable  long id){

        return new ResponseEntity<>( SuiviService.getSuivForEn(id), HttpStatus.OK);
    }

}
