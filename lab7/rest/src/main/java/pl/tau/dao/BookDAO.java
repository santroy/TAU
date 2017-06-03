package pl.tau.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import pl.tau.model.Book;
import pl.tau.util.ConnectionProvider;

@Component
public class BookDAO {
 
    private final static String CREATE = "INSERT INTO book(isbn, title, description) VALUES(:isbn, :title, :description);";
    private final static String READ = "SELECT isbn, title, description FROM book WHERE isbn = :isbn;";
    private final static String UPDATE = "UPDATE book SET isbn=:isbn, title=:title, description=:description WHERE isbn = :isbn;";
    private final static String DELETE = "DELETE FROM book WHERE isbn=:isbn;";
    private final static String READ_LIST = "SELECT * FROM book;";
 
    private NamedParameterJdbcTemplate template;
    private static List<Book> books;
 
    public BookDAO() {
        template = new NamedParameterJdbcTemplate(ConnectionProvider.getDSInstance());
    }
 
    public boolean create(Book book) {
        BeanPropertySqlParameterSource beanParamSource = new BeanPropertySqlParameterSource(book);
        int rowsAffected = template.update(CREATE, beanParamSource);
        boolean result = false;
        if (rowsAffected > 0) {
            result = true;
        }
        return result;
    }
    
    public List<Book> list() {
    	return template.query(READ_LIST, BeanPropertyRowMapper.newInstance(Book.class));
    }
 
    public Book read(String isbn) {
        SqlParameterSource namedParameters = new MapSqlParameterSource("isbn", isbn);
        List<Book> bookList = template.query(READ, namedParameters, BeanPropertyRowMapper.newInstance(Book.class));
        return (!bookList.isEmpty()) ? bookList.get(0) : null;
    }
 
    public boolean update(Book book) {
        BeanPropertySqlParameterSource beanParamSource = new BeanPropertySqlParameterSource(book);
        int rowsAffected = template.update(UPDATE, beanParamSource);
        boolean result = false;
        if (rowsAffected > 0) {
            result = true;
        }
        return result;
    }
 
    public boolean delete(Book book) {
        SqlParameterSource namedParameter = new MapSqlParameterSource("isbn", book.getIsbn());
        int rowsAffected = template.update(DELETE, namedParameter);
        boolean result = false;
        if (rowsAffected > 0) {
            result = true;
        }
        return result;
    }
    
    public boolean delete(String isbn) {
        SqlParameterSource namedParameter = new MapSqlParameterSource("isbn", isbn);
        int rowsAffected = template.update(DELETE, namedParameter);
        boolean result = false;
        if (rowsAffected > 0) {
            result = true;
        }
        return result;
    }
}