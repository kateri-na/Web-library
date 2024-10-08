package ru.panina.springproject.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.panina.springproject.models.Book;
import ru.panina.springproject.models.Person;

import java.util.List;

@Component
public class BookDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> index(){
        return jdbcTemplate.query("select * from book", new BookMapper());
    }
    public void save(Book book){
        jdbcTemplate.update("insert into book(title, author, year) values(?, ?, ?)",
                book.getTitle(), book.getAuthor(), book.getYear());
    }
    public Book show(int id){
        return jdbcTemplate.query("select * from book where id = ?", new Object[]{id},
                        new BookMapper()).stream().findAny().orElse(null);
    }
    public void update(int id, Book book){
        jdbcTemplate.update("update book set title = ?, author = ?, year = ? where id = ?",
                book.getTitle(), book.getAuthor(), book.getYear(), id);
    }
    public void delete(int id){
        jdbcTemplate.update("delete from book where id = ?", id);
    }
    public void appoint(Person person, int id){
        jdbcTemplate.update("update book set person_id = ? where id =?", person.getId(), id);
    }
    public void free(int id){
        jdbcTemplate.update("update book set person_id = null where id = ?", id);
    }
}
