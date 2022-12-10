package com.flowable.contactBook.service.impl;

import com.flowable.contactBook.entity.Contact;
import com.flowable.contactBook.repository.ContactRepository;
import com.flowable.contactBook.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;


    @Override
    public String saveContact(Contact contact) {
        Contact result=contactRepository.save(contact);
        if(result!=null){
            return "Contact Saved Successfully!";
        }
        return "Contact Saving Failed!";
    }

    @Override
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    @Override
    public Contact getContactById(int contactId) {
        return contactRepository.findById(contactId).orElse(null);
    }

    @Override
    public String updateContact(Contact contact) {
        Contact result=this.getContactById(contact.getContactId());
        result.setContactName(contact.getContactName());
        result.setContactEmail(contact.getContactEmail());
        result.setContactNumber(contact.getContactNumber());
        Contact response=contactRepository.save(result);
        if(response!=null){
            return "Contact updated Successfully!";
        }
        return "Contact Updating Failed!";
    }

    @Override
    public List<Contact> deleteContactById(int contactId) {
        contactRepository.deleteById(contactId);
        return this.getAllContacts();
    }
}
