package com.nijhum.udpCodingAssignment.parent.controller;


import com.nijhum.udpCodingAssignment.common.service.CommonService;
import com.nijhum.udpCodingAssignment.parent.entity.Parent;
import com.nijhum.udpCodingAssignment.parent.service.ParentService;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parent")
public class ParentController {

    private ParentService parentService;

    public ParentController(ParentService parentService){
        this.parentService = parentService;
    }

    @GetMapping()
    public ResponseEntity<List<Parent>> get(){
        List<Parent> entities = parentService.get();
        return ResponseEntity.ok(entities);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Parent> get(@PathVariable("id") Long componentId)  {
        Parent entity = (Parent) parentService.get(componentId);
        return ResponseEntity.ok(entity);
    }


    @PostMapping()
    public ResponseEntity<Parent> save(@RequestBody Parent parent){
        Parent entity = (Parent) parentService.save(parent);
        return ResponseEntity.ok(entity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Parent> modify(@PathVariable("id") Long componentId,  @RequestBody Parent parent){
        Parent entity = (Parent) parentService.modify(componentId,parent);
        return ResponseEntity.ok(entity);
    }

    @DeleteMapping("/{id}")

    public ResponseEntity<String> delete(@PathVariable("id") Long componentId){
        parentService.delete(componentId);

        return ResponseEntity.ok(null);
    }

}
