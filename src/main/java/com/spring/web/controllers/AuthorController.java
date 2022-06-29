package com.spring.web.controllers;

import com.spring.web.repository.AuthorRepository;
import com.spring.web.repository.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @RequestMapping("/authors")
    public String getBooks(Model model){

        // Creates a variable "books" and binds it to the value in the 2nd param
        model.addAttribute("books", authorRepository.findAll());

        return "author/list"; // "View" path
    }
}
