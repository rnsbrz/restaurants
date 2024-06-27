package com.spring.library.controller;

import com.spring.library.model.Book;
import com.spring.library.model.Genre;
import com.spring.library.service.BookService;
import com.spring.library.service.CustomUserDetails;
import com.spring.library.service.FavoriteService;
import com.spring.library.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class BookController {

    @Autowired
    BookService bookService;

    @Autowired
    GenreService genreService;
    @Autowired
    FavoriteService favoriteService;

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        List<Book> bookList = bookService.getAll();
        model.addAttribute("bookList", bookList);
        return "dashboard";
    }

    @GetMapping("/create")
    public String create(Model model) {
        List<String> genres = genreService.findAllGenreNames();
        model.addAttribute("genres", genres);
        model.addAttribute("book", new Book());
        return "create";
    }

    @PostMapping("/create")
    public String createSubmit(@ModelAttribute Book book, @RequestParam("genre") String genreName, Model model) {
        Genre genre = genreService.findByName(genreName);
        book.setGenre(genre);
        bookService.save(book);
        return "redirect:/dashboard";
    }
    @GetMapping("/book/edit/{id}")
    public String editBook(@PathVariable("id") int id, Model model) {
        Optional<Book> book = bookService.findById(id);
        List<String> genres = genreService.findAllGenreNames();
        model.addAttribute("genres", genres);
        model.addAttribute("book", book);
        return "edit-book";
    }
    @PostMapping("/book/edit")
    public String editBookSubmit(@ModelAttribute Book book) {
        bookService.save(book);
        return "redirect:/dashboard";
    }
    @GetMapping("/book/delete/{id}")
    public String deleteBook(@PathVariable("id") int id, Model model){
        bookService.deleteById(id);
        return "redirect:/dashboard";
    }
    @GetMapping("/dashboard/search")
    public String searchBooks(@RequestParam("query") String query, Model model) {
        List<Book> filteredBooks = bookService.findBooksByTitle(query);
        model.addAttribute("bookList", filteredBooks);
        return "dashboard";
    }
    @GetMapping("/book/view/{id}")
    public String viewBook(@PathVariable("id") int id, Model model) {
        Optional<Book> bookOptional = bookService.findById(id);
        if (bookOptional.isPresent()) {
            Book book = bookOptional.get();
            Genre genre = book.getGenre();
            model.addAttribute("book", book);
            model.addAttribute("genre", genre);
            return "view-book";
        }
        return "redirect:/dashboard";
    }
}
