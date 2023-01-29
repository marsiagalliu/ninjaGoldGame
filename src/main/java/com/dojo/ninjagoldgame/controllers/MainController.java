package com.dojo.ninjagoldgame.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

@Controller
public class MainController {



    @RequestMapping( "/")
    public String coin(HttpSession session){
        if (session.getAttribute("coin")== null) {
            session.setAttribute("coin", 0);
        }
        if (session.getAttribute("logs")== null){
            session.setAttribute("logs", new ArrayList<String>());
        }
        return "index.jsp";
    }

    @RequestMapping("/farm")
    public String farm(HttpSession session){
        ArrayList<String> logs= (ArrayList<String>) session.getAttribute("logs");
        int  coin = (int) session.getAttribute("coin");
        Random r = new Random();
        int low = 10;
        int high = 20;
        int result = r.nextInt(high-low) + low;
        coin = coin + result;
        session.setAttribute("coin", coin);
        SimpleDateFormat date = new SimpleDateFormat("MMMM d yyyy hh:mm");
        logs.add("You entered a farm and earned " + result + " gold. (" +date.format(new Date()) + ")");
        session.setAttribute("logs", logs);
        return "redirect:/";
    }

    @RequestMapping("/cave")
    public String cave(HttpSession session){
        ArrayList<String> logs= (ArrayList<String>) session.getAttribute("logs");
        int coin = (int) session.getAttribute("coin");
        Random r = new Random();
        int low = 5;
        int high = 10;
        int result = r.nextInt(high-low) + low;
        coin = coin + result;
        session.setAttribute("coin", coin);
        SimpleDateFormat date = new SimpleDateFormat("MMMM d yyyy hh:mm");
        logs.add("You entered a cave and earned " + result + " gold. (" +date.format(new Date()) + ")");
        session.setAttribute("logs", logs);
        return "redirect:/";
    }

    @RequestMapping("/house")
    public String house(HttpSession session){
        ArrayList<String> logs= (ArrayList<String>) session.getAttribute("logs");
        int coin = (int) session.getAttribute("coin");
        Random r = new Random();
        int low = 2;
        int high = 5;
        int result = r.nextInt(high-low) + low;
        coin = coin + result;
        session.setAttribute("coin", coin);
        SimpleDateFormat date = new SimpleDateFormat("MMMM d yyyy hh:mm");
        logs.add("You entered a house and earned " + result + " gold. (" +date.format(new Date()) + ")");
        session.setAttribute("logs", logs);
        return "redirect:/";
    }

    @RequestMapping("/quest")
    public String quest(HttpSession session){
        ArrayList<String> logs= (ArrayList<String>) session.getAttribute("logs");
        int coin = (int) session.getAttribute("coin");
        Random r = new Random();
        int low = -50;
        int high = 50;
        int result = r.nextInt(high-low) + low;
        coin = coin + result;
        if (coin <0){
            coin = 0;
        }
        SimpleDateFormat date = new SimpleDateFormat("MMMM d yyyy hh:mm");
        if (result<0){
            logs.add("You failed a quest and lost " + (-result)  + " gold. "+ "Ouch. (" +date.format(new Date()) + ")");
        }
        else {
            logs.add("You completed a quest and earned " + result + " gold. (" +date.format(new Date()) + ")");
        }
        session.setAttribute("logs", logs);
        session.setAttribute("coin", coin);
        return "redirect:/";
    }
}
