package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

    //Handles request at path /hello
    @GetMapping("")
    @ResponseBody
    public String hello(){
        return "Hello, Spring!";
    }
    //
    //Handles request at path /goodbye
    //now lives at /hello/goodbye
    @GetMapping("goodbye")
    public String goodbye(){
        return "Goodbye, Spring!";
    }

    // lives at /hello/hello
    //handles request of the form /hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name){
        return "Hello, " + name + "!";
    }

    //Handles requests of the form /hello/LaunchCode
    @GetMapping("hello/{name}")
    public String helloWithPathParam(@PathVariable String name){
        return "Hello, " + name + "!";
    }

    //lives at /hello/form
    //Handles form with user submission of name
    @GetMapping("form")
    @ResponseBody
    public String helloForm(){
        return "<html>" +
                "<body>" +
                "<form action='hello' method='post'>" + //submit a request to /hello
                "<input type='text' name='name'>" +
                "<label for='language'>" +
                "<select name='languages' id='language'" +
                "<option value=''Please select Language</option>"+
                "<option value='English'>English</option>" +
                "<option value='French'>French</option>" +
                "<option value='Spanish'>Spanish</option>" +
                "<option value='Italian'>Italian</option>" +
                "<option value='German'>German</option>" +
                "</select>"+
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }
    @PostMapping("form")
    public static String createMessage(@RequestParam String name, @RequestParam String language){
        if(language == "French"){
            return "Bonjour, " + name + "!";
        }else if (language == "Spanish"){
            return "Hola, " + name + "!";
        }else if (language == "Italian"){
            return "Ciao, " + name + "!";
        }else if (language == "German"){
            return "Hallo, " + name + "!";
        }else{
            return "Hello, " + name + "!";
        }
    }
}
