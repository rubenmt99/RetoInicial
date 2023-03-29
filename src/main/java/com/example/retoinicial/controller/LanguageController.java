package com.example.retoinicial;

import com.example.retoinicial.entity.Language;
import com.example.retoinicial.service.ILanguageService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@RestController
@RequestMapping("/languages")
public class LanguageController {

    @Autowired
    ILanguageService languageService;

    @GetMapping("/list")
    public ResponseEntity<List<Language>> listLanguages(){
        return ResponseEntity.ok(languageService.listLanguages());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Language> getLanguage(@PathVariable("id") Integer id){
        Language language1 = languageService.getLanguage(id);
        if (language1 == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(language1);
    }


    @PostMapping()
    public ResponseEntity<Language> createLanguage(@Valid @RequestBody Language language, BindingResult result){
        if (result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Language language1 = languageService.crearLanguage(language);
        return ResponseEntity.ok(language1);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Language> updateLanguage(@Valid @RequestBody Language language, BindingResult result, @PathVariable("id") Integer id){
        language.setId(id);
        if (result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Language language1 = languageService.updateLanguage(language);
        if (language1 == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(language1);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Language> deleteLanguage(@PathVariable("id") Integer id){
        Language language = languageService.getLanguage(id);
        if (language == null){
            return ResponseEntity.notFound().build();
        }
        languageService.deleteLanguage(id);
        return ResponseEntity.ok(language);
    }


}
