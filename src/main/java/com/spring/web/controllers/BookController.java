package com.spring.web.controllers;

import com.spring.web.repository.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books")
    public String getBooks(Model model){

        // Creates a variable "books" and binds it to the value in the 2nd param
        model.addAttribute("books", bookRepository.findAll());

        return "books/list"; // "View" path
    }
}
