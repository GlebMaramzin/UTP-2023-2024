package com.example.authproj.controllers;

import com.example.authproj.models.*;
import com.example.authproj.repositories.GrupaRepository;
import com.example.authproj.repositories.ProgressRepository;
import com.example.authproj.repositories.UserRepository;
import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Controller
public class GrupaController {

    @Autowired
    GrupaRepository grupaRepository;

    @Autowired
    ProgressRepository progressRepository;

    @GetMapping("timetable/{grupaAndWeekday}")
    public String grupaUsp(@PathVariable(value = "grupaAndWeekday") String grupaAndWeekday, Model model) {
        String grupaTitle = grupaAndWeekday.split(" - ")[0];
        String weekday = grupaAndWeekday.split(" - ")[1];

        List<Grupa> grupa = grupaRepository.findByTitle(grupaTitle);
        List<Student> students = grupa.get(0).getStudents();
        List<String> allDays = getDates(weekday);
        List<Progress> progresses = new ArrayList<>();

        for (Student student : students) {
            if (!student.getProgresses().isEmpty()) {
                List<Progress> local_p = student.getProgresses();
                progresses.addAll(local_p);
            }
        }

        model.addAttribute("grupaTitle", grupaTitle);
        model.addAttribute("students", students);
        model.addAttribute("allDays", allDays);
        model.addAttribute("path", grupaAndWeekday);
        return "grupausp";
    }

    @PostMapping("timetable/{grupaAndWeekday}")
    public String saveProgress(@RequestBody List<Progress> progresses) {

        System.out.println(progresses);
        for (Progress progress : progresses) {
            progressRepository.save(progress);
        }
        return "timetable";
    }

    public List<String> getDates(String dayweek) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM");

        String startDate = "2023-09-01";
        String endDate = "2024-01-01";
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        List<LocalDate> totalDates = new ArrayList<>();

        DayOfWeek currDay = null;
        switch (dayweek) {
            case "Monday":
                currDay = DayOfWeek.MONDAY;
                break;
            case "Tuesday":
                currDay = DayOfWeek.TUESDAY;
                break;
            case "Wednesday":
                currDay = DayOfWeek.WEDNESDAY;
                break;
            case "Thursday":
                currDay = DayOfWeek.THURSDAY;
                break;
            case "Friday":
                currDay = DayOfWeek.FRIDAY;
                break;
            case "Saturday":
                currDay = DayOfWeek.SATURDAY;
                break;
        }

        LocalDate nextDay = start;
        int daysToAdvance = 1;
        while (!nextDay.isAfter(end)) {
            if (nextDay.getDayOfWeek() == currDay) {
                daysToAdvance = 7;
                totalDates.add(nextDay);
            }
            nextDay = nextDay.plusDays(daysToAdvance);
        }

        List<String> totalDatesStrs = new ArrayList<>();

        for (LocalDate currDate : totalDates) {
            totalDatesStrs.add(currDate.toString().substring(5).replace('-', '.'));
        }

        return totalDatesStrs;
    }
}
