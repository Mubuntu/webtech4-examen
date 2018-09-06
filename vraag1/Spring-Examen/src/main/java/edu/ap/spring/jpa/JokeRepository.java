package edu.ap.spring.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Patrick Frison
 * @version 1.0
 * Date: 06/09/2018
 * Time: 14:31
 **/
@Repository
@Transactional
public interface JokeRepository extends CrudRepository<Joke, Long> {
    List<Joke> findJokeByPunchline(String punchline);
}
