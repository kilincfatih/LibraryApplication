package com.system.LibraryApplication.api.controllers;

import com.system.LibraryApplication.business.abstracts.MembersService;
import com.system.LibraryApplication.entities.concretes.Members;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/members")
public class MembersController {
    private final MembersService membersService;

    @Autowired
    public MembersController(MembersService membersService) {
        this.membersService = membersService;
    }

    @GetMapping
    public ResponseEntity<List<Members>> getAllMembers() {
        List<Members> members = membersService.findAll();
        return new ResponseEntity<>(members, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Members> getMembersById(@PathVariable Long id) {
        Optional<Members> members = membersService.findById(id);
        return members.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Members> createMembers(@RequestBody Members member) {
        Members newMember = membersService.save(member);
        return new ResponseEntity<>(newMember, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Members> updateMembers(@PathVariable Long id, @RequestBody Members membersDetail) {
        Optional<Members> member = membersService.findById(id);
        if (member.isPresent()) {
            Members existingMember = member.get();
            existingMember.setNameSurname(membersDetail.getNameSurname());
            existingMember.setEmail(membersDetail.getEmail());
            existingMember.setStartDate(membersDetail.getStartDate());
            Members updatedMembers = membersService.save(existingMember);
            return new ResponseEntity<>(updatedMembers, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMember(@PathVariable Long id) {
        if (membersService.findById(id).isPresent()) {
            membersService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
