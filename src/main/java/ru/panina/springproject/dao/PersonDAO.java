package ru.panina.springproject.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.panina.springproject.models.Book;
import ru.panina.springproject.models.Person;

import java.util.List;

@Component
public class PersonDAO {

    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> index(){
        return jdbcTemplate.query("select * from person", new BeanPropertyRowMapper<Person>(Person.class));
    }
    public void save(Person person){
        jdbcTemplate.update("insert into person(name, year) values(?, ?)",
                person.getName(), person.getYear());
    }
    public Person show(int id){
        return jdbcTemplate.query("select * from person where id = ?", new Object[]{id},
                new BeanPropertyRowMapper<Person>(Person.class)).stream().findAny().orElse(null);
    }
    public void update(int id, Person person){
        jdbcTemplate.update("update person set name = ?, year = ? where id = ?",
                person.getName(), person.getYear(), id);
    }
    public void delete(int id){
        jdbcTemplate.update("delete from person where id = ?", id);
    }
    public List<Book> findAllBooks(int id){
        return jdbcTemplate.query("select b.id, b.person_id, b.title, b.author, b.year from person join book b on person.id = b.person_id where person.id = ?", new Object[]{id}, new BookMapper());
    }
}
