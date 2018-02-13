package cn.wanghan.demo.controller;

import cn.wanghan.demo.domain.Book;
import cn.wanghan.demo.domain.Category;
import cn.wanghan.demo.service.BookService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    private static final Log logging = LogFactory.getLog(BookController.class);

    @RequestMapping(value = "/input-book")
    public String inputBook(Model model) {
        List<Category> categories = bookService.getAllCategories();
        model.addAttribute("categories", categories);
        model.addAttribute("book", new Book());
        return "/book/BookAddForm";
    }

    @RequestMapping(value = "/edit-book/{id}")
    public String editBook(Model model, @PathVariable long id) {
        List<Category> categories = bookService.getAllCategories();
        model.addAttribute("categories", categories);
        Book book = bookService.get(id);
        model.addAttribute("book", book);
        return "/book/BookEditForm";
    }

    @RequestMapping(value = "/save-book")
    public String saveBook(@ModelAttribute Book book) {
        Category category = bookService.getCategory(book.getCategory().getId());
        book.setCategory(category);
        bookService.save(book);
        return "redirect:/list-book";
    }

    @RequestMapping(value = "/update-book")
    public String updateBook(@ModelAttribute Book book) {
        Category category = bookService.getCategory(book.getCategory().getId());
        book.setCategory(category);
        bookService.update(book);
        return "redirect:/list-book";
    }

    @RequestMapping(value = "/list-book")
    public String listBook(Model model) {
        logging.info("listBooks");
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "/book/BookList";
    }
}
