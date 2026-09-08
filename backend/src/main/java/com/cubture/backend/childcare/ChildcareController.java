package com.cubture.backend.childcare;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/childcare")
public class ChildcareController {

    private final ChildcareService childcareService;

    public ChildcareController(ChildcareService childcareService) {
        this.childcareService = childcareService;
    }

    @GetMapping
    public List<Childcare> getChildcare(
            @RequestParam int month,
            @RequestParam int year) {

        return childcareService.getChildcare(month, year);
    }

    @GetMapping("/{id}")
    public Childcare getChildcare(@PathVariable UUID id) {

        try {
            return childcareService.getChildcare(id);
        } catch (NoSuchElementException exception) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Childcare not found",
                    exception);
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Childcare createChildcare(@RequestBody Childcare childcare) {
        return childcareService.createChildcare(childcare);
    }

    @PutMapping("/{id}")
    public Childcare updateChildcare(
            @PathVariable UUID id,
            @RequestBody Childcare updatedChildcare) {

        try {
            return childcareService.updateChildcare(id, updatedChildcare);
        } catch (NoSuchElementException exception) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Childcare not found",
                    exception);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteChildcare(@PathVariable UUID id) {

        try {
            childcareService.deleteChildcare(id);
        } catch (NoSuchElementException exception) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Childcare not found",
                    exception);
        }
    }
}