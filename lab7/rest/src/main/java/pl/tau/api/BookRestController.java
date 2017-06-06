package pl.tau.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import pl.tau.dao.BookDAO;
import pl.tau.model.Book;


@RestController
public class BookRestController {

	
	@Autowired
	private BookDAO bookDAO;

	
	@GetMapping("/books")
	public List getBooks() {
		return bookDAO.list();
	}
	
	@GetMapping("/books/{isbn}")
	public ResponseEntity getBook(@PathVariable("isbn") String isbn) {

		Book book = bookDAO.read(isbn);
		if (book == null) {
			return new ResponseEntity("No Book found for ISBN " + isbn, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(book, HttpStatus.OK);
	}

	@PostMapping(value = "/books")
	public ResponseEntity createBook(@RequestBody Book book) {
		boolean result = bookDAO.create(book);
		
		return (result == true) ? new ResponseEntity(book, HttpStatus.OK) : new ResponseEntity("No Book created for given ISBN " + book.getIsbn(), HttpStatus.NOT_ACCEPTABLE) ;
	}

	@DeleteMapping("books/{isbn}")
	public ResponseEntity deleteBook(@PathVariable String isbn) {
		
		boolean result = bookDAO.delete(isbn);
		
		return (result == true) ? new ResponseEntity(HttpStatus.OK) : new ResponseEntity("No Book found for ISBN " + isbn, HttpStatus.NOT_ACCEPTABLE);

	}

	@PutMapping("/books")
	public ResponseEntity updateBook(@RequestBody Book book) {

		boolean result = bookDAO.update(book);

		return (result == true) ? new ResponseEntity(book, HttpStatus.OK) : new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
	}

}