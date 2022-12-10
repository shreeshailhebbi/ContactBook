package com.flowable.contactBook.controller;

import com.flowable.contactBook.entity.Contact;
import com.flowable.contactBook.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/contact")
public class ContactResource {

    @Autowired
    private ContactService contactService;

    @PostMapping("/")
    public String saveContact(@RequestBody Contact contact){
        return contactService.saveContact(contact);
    }

    @GetMapping("/")
    public List<Contact> getAllContacts(){
        return contactService.getAllContacts();
    }

    @GetMapping("/{contactId}")
    public Contact getContactById(@PathVariable int contactId){
        return contactService.getContactById(contactId);
    }

    @PutMapping("/")
    public String updateContact(@RequestBody Contact contact){
        return contactService.updateContact(contact);
    }

    @DeleteMapping("/{contactId}")
    public List<Contact> deleteContactById(@PathVariable int contactId){
        return contactService.deleteContactById(contactId);
    }
}
