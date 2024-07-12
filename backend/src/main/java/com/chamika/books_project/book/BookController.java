package com.chamika.books_project.book;

import com.chamika.books_project.shared.PageResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addBook(
            @Valid @RequestBody BookSaveRequestBody bookSaveRequest,
            Authentication auth
    ) {
        bookService.addBook(bookSaveRequest, auth);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BookResponseBody getBook(@PathVariable Integer id) {
        return bookService.getBookById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public PageResponse<BookResponseBody> getBooks(
            @RequestParam(name = "page", defaultValue = "0", required = false) Integer page,
            @RequestParam(name = "size", defaultValue = "8", required = false) Integer size,
            Authentication auth
    ) {
        return bookService.getAllBooksPaginated(page, size, auth);
    }

    @GetMapping("/owner")
    @ResponseStatus(HttpStatus.OK)
    public PageResponse<BookResponseBody> getAllBooksOfAOwner(
            @RequestParam(name = "page", defaultValue = "0", required = false) Integer page,
            @RequestParam(name = "size", defaultValue = "8", required = false) Integer size,
            Authentication auth

    ) {
        return bookService.getBooksByOwner(page, size, auth);
    }

    @GetMapping("/borrowed")
    @ResponseStatus(HttpStatus.OK)
    public PageResponse<BorrowedBookResponseBody> getAllBorrowedBooksOfUser(
            @RequestParam(name = "page", defaultValue = "0", required = false) Integer page,
            @RequestParam(name = "size", defaultValue = "8", required = false) Integer size,
            Authentication auth

    ) {
        return bookService.getAllBorrowedBooksOfUser(page, size, auth);
    }


    // TODO:- Check this controller
    @GetMapping("/returned")
    @ResponseStatus(HttpStatus.OK)
    public PageResponse<BorrowedBookResponseBody> getAllReturnedBooksOfUser(
            @RequestParam(name = "page", defaultValue = "0", required = false) Integer page,
            @RequestParam(name = "size", defaultValue = "8", required = false) Integer size,
            Authentication auth

    ) {
        return bookService.getAllReturnedBooksOfUser(page, size, auth);
    }


}
