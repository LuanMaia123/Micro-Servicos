package com.base.a.controller;

import com.base.a.model.Debt;
import com.base.a.repository.DebtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/debt")
public class DebtController {

    @Autowired
    private DebtRepository debtRepository;

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/all")
    public ResponseEntity<List<Debt>> getDebts() {
        List<Debt> debts = debtRepository.findAll();
        return new ResponseEntity<List<Debt>>(debts, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping(value = "/{id}")
    public ResponseEntity<Debt> read(@PathVariable long id) {
        Debt debt = debtRepository.findOne(id);
        return new ResponseEntity<Debt>(debt, HttpStatus.OK);
    }
}
