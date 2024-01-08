package com.example.authproj.controllers;

import com.example.authproj.models.Timetable;
import com.example.authproj.models.User;
import com.example.authproj.repositories.UserRepository;
import com.example.authproj.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class TimetableController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/timetable")
    public String timetable(Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        User teacher = userRepository.findByUsername(currentPrincipalName);
        List<Timetable> timetables = teacher.getTimetables();
        HashMap<String, List<String>> data = new HashMap<>();

        for (Timetable timetable : timetables) {
            String discipline = timetable.getDiscipline().getTitle();
            String grupa = timetable.getGrupa().getTitle();
            String weekday = timetable.getWeekday();

            if (!data.containsKey(discipline)) {
                List<String> grups = new ArrayList<>();
                grups.add(grupa + " - " + weekday);
                data.put(discipline, grups);
            } else {
                data.get(discipline).add(grupa + " - " + weekday);
            }
        }

        model.addAttribute("data", data);
        return "timetable";
    }
}
