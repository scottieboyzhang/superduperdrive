package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.services.*;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StorageController {
    private FileService fileService;
    private CredentialService credentialService;
    private NoteService noteService;
    private UserService userService;
    private EncryptionService encryptionService;


    public StorageController(FileService fileService, CredentialService credentialService,
                            NoteService noteService, UserService userService,
                             EncryptionService encryptionService){
        this.fileService = fileService;
        this.credentialService = credentialService;
        this.noteService = noteService;
        this.userService = userService;
        this.encryptionService = encryptionService;
    }

}
