package com.flowable.contactBook.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "Contact")
public class Contact {

    @Id()
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "CONTACT_ID")
    private int contactId;

    @Column(name = "CONTACT_NAME")
    private String contactName;

    @Column(name = "CONTACT_EMAIL")
    private String contactEmail;

    @Column(name = "CONTACT_NO")
    private long contactNumber;

}
