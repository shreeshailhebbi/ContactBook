package com.flowable.contactBook.service;

import com.flowable.contactBook.entity.Contact;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ContactService {

    public String saveContact(Contact contact);

    public List<Contact> getAllContacts();

    public Contact getContactById(int contactId);

    public String updateContact(Contact contact);

    public List<Contact> deleteContactById(int contactId);


}
