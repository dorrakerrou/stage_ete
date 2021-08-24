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
    public ResponseEntity<?> Add(@RequestParam(value = "taches",  required = false)  String taches,@RequestParam(value = "nom_equipe",  required = false)  String nom_equipe ,@PathVariable long idEt){
        Suivi sub = SuiviService.addEt(taches,nom_equipe,idEt);
        return new ResponseEntity<>( " Suivi added by etudiant. ",  HttpStatus.OK);

    }

    @PostMapping ("/Modify")
    @ResponseBody
    public Suivi modify(@RequestBody Suivi su){

        return SuiviService.modify(su);
    }

    @PostMapping("/addsuiviEn/{idEn}")
@ResponseBody
    public ResponseEntity<?> AddEn(@RequestParam(value = "Remarque",  required = false)  String Remarque,@RequestParam (value="valider", required = false) boolean valider, @PathVariable long idEn){
        Suivi sub = SuiviService.AddEn(Remarque,valider,idEn);
        return new ResponseEntity<>( " Suivi added by enseignant. ",  HttpStatus.OK);
    }

    @GetMapping("/getSuiviforEn/{id}")
    public ResponseEntity<?> getSuiviEn(@PathVariable  long id){

        return new ResponseEntity<>( SuiviService.getSuivForEn(id), HttpStatus.OK);
    }

}
