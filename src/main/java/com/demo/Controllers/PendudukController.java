package com.demo.Controllers;

import javax.validation.Valid;

import com.demo.DTO.ResponseData;
import com.demo.models.Penduduk;
import com.demo.models.services.PendudukService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/penduduk")
public class PendudukController {
    
    @Autowired
    private PendudukService pendudukService;

    @GetMapping
    public Iterable<Penduduk> findAll(){
        return pendudukService.findAll();
    }

    @GetMapping("/{id}")
    public Penduduk findOne(@PathVariable("id") long id){
        return pendudukService.findOne(id);
    }

    @PostMapping
    public ResponseEntity<ResponseData<Penduduk>> create(@Valid @RequestBody Penduduk penduduk, Errors errors){
        ResponseData<Penduduk> responseData = new ResponseData<>();
        if(errors.hasErrors()){
            for(ObjectError error : errors.getAllErrors()){
                responseData.getMessage().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        responseData.setStatus(true);
        responseData.setPayload(pendudukService.save(penduduk));
        return ResponseEntity.ok(responseData);
    }

    @PutMapping
    public ResponseEntity<ResponseData<Penduduk>> update(@Valid @RequestBody Penduduk penduduk, Errors errors){
        ResponseData<Penduduk> responseData = new ResponseData<>();
        if(errors.hasErrors()){
            for(ObjectError error : errors.getAllErrors()){
                responseData.getMessage().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        responseData.setStatus(true  );
        responseData.setPayload(pendudukService.save(penduduk));
        return ResponseEntity.ok(responseData);
        
    }

    @DeleteMapping("/{id}")
    public void removeOne(@PathVariable("id") Long id){
        pendudukService.removeOne(id);
    }

    

    
}
