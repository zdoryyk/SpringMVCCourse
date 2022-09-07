package SpringCourse.DAO;

import SpringCourse.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> index() {
        return jdbcTemplate.query("SELECT * FROM Person", new BeanPropertyRowMapper<>(Person.class));
    }

    public Person show(int id) {
        return jdbcTemplate.query("SELECT * FROM Person WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Person.class))
                .stream().findAny().orElse(null);
    }

    public void save(Person person) {
        jdbcTemplate.update("INSERT INTO Person(name,age) VALUES(?,?)", person.getName(), person.getAge());
    }

    public void update(int id, Person updatedPerson) {
        jdbcTemplate.update("UPDATE Person SET name=?, age=? WHERE id=?", updatedPerson.getName(),
                updatedPerson.getAge(),id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM Person WHERE id=?", id);
    }

    ///ТЕСТ БД ЗАПРОСОВ


//    public void testMultipleUpdate() {
//        List<Person> people = create1000people();
//
//        long start = System.currentTimeMillis();
//
//        for (Person person : Objects.requireNonNull(people)) {
//            jdbcTemplate.update("INSERT INTO Person VALUES (?,?,?,?)", person.getId(),
//                    person.getName(), person.getAge(), person.getEmail());
//        }
//
//
//       long end = System.currentTimeMillis();
//        System.out.println("TIME:" + (end-start));
//
//    }
//
//    public void testBatchUpdate(){
//
//        List<Person> people = create1000people();
//
//        long start = System.currentTimeMillis();
//
//        jdbcTemplate.batchUpdate("INSERT INTO Person VALUES(?,?,?,?)",
//                new BatchPreparedStatementSetter() {
//                    @Override
//                    public void setValues(PreparedStatement ps, int i) throws SQLException {
//                        ps.setInt(1,people.get(i).getId());
//                        ps.setString(2,people.get(i).getName());
//                        ps.setInt(3,people.get(i).getAge());
//                        ps.setString(4,people.get(i).getEmail());
//
//                    }
//
//                    @Override
//                    public int getBatchSize() {
//                        return Objects.requireNonNull(people).size();
//                    }
//                });
//
//            long end = System.currentTimeMillis();
//            System.out.println("TIME:" + (end-start));
//
//    }
//
//    private List<Person> create1000people() {
//
//        List<Person> people = new ArrayList<>();
//
//        for(int i = 0; i < 1000; i++){
//            people.add(new Person(i,"name" + i,30,"test" + i +"@mail.com","hello@mail.com"));
//        }
//
//        return people;
//    }

}