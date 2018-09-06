package edu.ap.spring.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Patrick Frison
 * @version 1.0
 * Date: 06/09/2018
 * Time: 14:07
 **/
@Entity
public class Joke {
    @Id
    @GeneratedValue
    private Long id;
    @Column

    private String firstName;
    @Column

    private String lastName;
    @Column
    private String punchline;

    public Joke() {
    }

    public Joke(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Joke(String firstName, String lastName, String punchline) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.punchline = punchline;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setpunchline(String punchline) {
        this.punchline = punchline;
    }

    @Override
    public String toString() {
        return this.punchline;
    }
}
