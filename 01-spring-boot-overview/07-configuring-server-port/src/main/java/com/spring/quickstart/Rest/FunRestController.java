package com.spring.quickstart.Rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    //Inject properties for coach.name,team.name, okay.song

    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teameName;

    @Value("${okay.song}")
    private String okaySong;

    //Expose new endpoint for teaminfo
    @GetMapping("/teaminfo")
    public String GetTeamInfo() {
        return "Coach Name: " + coachName + ", Team Name: " + teameName + ", Favourite Song: " + okaySong;
    }

    // Rest controller
    @GetMapping(path = "/hello")
    public String HelloWorld() {
        return "Hello World!";
    }

    // expose new endpoint for "workout"
    @GetMapping("/workout")
    public String getDailyWorkout() {
        return "Run a hard 5k!";
    }

    // Expose a new endpoint for "fortune"
    @GetMapping("/fortune")
    public String getDailyFortune() {
        return "Today is your lucky day!";
    }
}
