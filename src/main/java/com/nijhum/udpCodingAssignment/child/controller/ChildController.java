package com.nijhum.udpCodingAssignment.child.controller;

import com.nijhum.udpCodingAssignment.child.model.Child;
import com.nijhum.udpCodingAssignment.child.service.ChildService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/child")
public class ChildController {

    private ChildService childService;

    public ChildController(ChildService childService){
        this.childService = childService;
    }

    @GetMapping()
    public ResponseEntity<List<Child>> get(){
        List<Child> entities = childService.get();
        return ResponseEntity.ok(entities);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Child> get(@PathVariable("id") Long componentId)  {
        Child entity = (Child) childService.get(componentId);
        return ResponseEntity.ok(entity);
    }


    @PostMapping()
    public ResponseEntity<Child> save(@RequestBody Child child){
        Child entity = (Child) childService.save(child);
        return ResponseEntity.ok(entity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Child> modify(@PathVariable("id") Long componentId,  @RequestBody Child child){
        Child entity = (Child) childService.modify(componentId,child);
        return ResponseEntity.ok(entity);
    }

    @DeleteMapping("/{id}")

    public ResponseEntity<String> delete(@PathVariable("id") Long componentId){
        childService.delete(componentId);

        return ResponseEntity.ok(null);
    }

}
