package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {
//
//    //Handles request at path /hello
//    @GetMapping("")
//    @ResponseBody
//    public String hello(){
//        return "Hello, Spring!";
//    }
//    //
//    //Handles request at path /goodbye
//    //now lives at /hello/goodbye
//    @GetMapping("goodbye")
//    public String goodbye(){
//        return "Goodbye, Spring!";
//    }
//
//    // lives at /hello/hello
//    //handles request of the form /hello?name=LaunchCode
//    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
//    public String helloWithQueryParam(@RequestParam String name){
//        return "Hello, " + name + "!";
//    }
//
//    //Handles requests of the form /hello/LaunchCode
//    @GetMapping("hello/{name}")
//    public String helloWithPathParam(@PathVariable String name){
//        return "Hello, " + name + "!";
//    }

    //lives at /hello/form
    //Handles form with user submission of name
    @RequestMapping(method = RequestMethod.GET)
    public String helloForm(){
        return "<form method='post'>" +
                "<input type='text' name='name'>" +
                "<label for='language'>" +
                "<select name='language'>" +
                "<option value='English'>English</option>" +
                "<option value='French'>French</option>" +
                "<option value='Spanish'>Spanish</option>" +
                "<option value='Italian'>Italian</option>" +
                "<option value='German'>German</option>" +
                "</select>"+
                "<input type='submit' value='Greet me!'>" +
                "</form>";
    }
    @RequestMapping(method = RequestMethod.POST)
    public static String createMessage(@RequestParam String name, @RequestParam String language){
        if (name == null){
            name = "World";
        }
        String greeting = "";
        if(language.equals("English")){
            greeting = "Hello, ";
        } else if(language.equals( "French")){
            greeting = "Bonjour, ";
        }else if (language.equals( "Spanish")){
            greeting = "Hola, ";
        }else if (language.equals("Italian")){
            greeting = "Ciao, ";
        }else if (language.equals("German")){
            greeting = "Halo, ";
        }
        return "<p style='color: green; text-align: center'>" + greeting + name + "</p>";
    }
}
