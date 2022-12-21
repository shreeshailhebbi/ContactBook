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
        if(contactRepository.existsById(contact.getContactId())){
            contactRepository.save(contact);
            return "Contact updated Successfully!";
        }
        return "Contact Updating Failed!";
    }

    @Override
    public String deleteContactById(int contactId) {
        contactRepository.deleteById(contactId);
        if(contactRepository.existsById(contactId)){
            return "Deleted Successfully!";
        }
        return "Unable to delete Contact by Id";
    }
}
