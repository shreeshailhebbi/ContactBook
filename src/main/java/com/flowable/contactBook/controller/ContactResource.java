package com.flowable.contactBook.controller;

import com.flowable.contactBook.entity.Contact;
import com.flowable.contactBook.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class ContactResource {

    @Autowired
    private ContactService contactService;

    @PostMapping("/contact")
    public String saveContact(@RequestBody Contact contact){
        return contactService.saveContact(contact);
    }

    @GetMapping("/contacts")
    public List<Contact> getAllContacts(){
        return contactService.getAllContacts();
    }

    @GetMapping("/contact/{contactId}")
    public Contact getContactById(@PathVariable int contactId){
        return contactService.getContactById(contactId);
    }

    @PutMapping("/contact")
    public String updateContact(@RequestBody Contact contact){
        return contactService.updateContact(contact);
    }

    @DeleteMapping("/contact/{contactId}")
    public String deleteContactById(@PathVariable int contactId){
        return contactService.deleteContactById(contactId);
    }
}
