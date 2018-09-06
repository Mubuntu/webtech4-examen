package edu.ap.spring.controller;

import edu.ap.spring.jpa.Joke;
import edu.ap.spring.jpa.JokeRepository;
import jdk.nashorn.internal.ir.RuntimeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

@Controller
@Scope("session")
public class JokeController {
    private JokeRepository repository;

    @Autowired
    public void setRepository(JokeRepository jokeRepository) {
        this.repository = jokeRepository;
    }

    public JokeController() {
    }

    @RequestMapping("/joke")
    public String joke() {

        return "joke";
    }

    //
    @PostMapping("/joke_post")
    public String joke_post(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, Model model) {
        String requestUrl = "http://api.icndb.com/jokes/random?firstName=" + firstName + "&lastName=" + lastName;

        try {
            URL url = new URL(requestUrl);
            URLConnection urlCon = url.openConnection();
            // get the metadata for the item as a json stream

            JsonReader jsonReader = Json.createReader(new InputStreamReader(urlCon.getInputStream(), "UTF-8"));
            JsonObject retrievedJson = jsonReader.readObject();
            jsonReader.close();
            System.out.println(retrievedJson);

            String punchline = "";

            JsonObject jsonJoke = retrievedJson.getJsonObject("value");


            System.out.println(jsonJoke.getString("joke"));
            punchline = jsonJoke.getString("joke");


            List<Joke> jokes = repository.findJokeByPunchline(punchline);
            Joke joke = new Joke(firstName, lastName, punchline);
            if (jokes.size() == 0) {
                repository.save(joke);
            }
            model.addAttribute("punchline", punchline);
            model.addAttribute("firstname", firstName);
            model.addAttribute("lastname", lastName);

        } catch (IOException e) {
            e.printStackTrace();
        }


        return "result";
    }

    // haal json
    @RequestMapping("/")
    public String root() {
        return "redirect:/joke";
    }
}
