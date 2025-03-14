package hello.hello_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "hello");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name", required=false) String name, Model model){
        model.addAttribute("name",name);
        return "hello-template";
    }

    // 잘 안씀
    @GetMapping("hello-string")
    @ResponseBody // http 바디에 통으로 넣겠다 -> view 이런거 안 거치고 문자가 그대로 내려감
    public String helloString(@RequestParam(value = "name", required = false) String name){
        return "hello " + name; // hello spring
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam(name="name",required = false) String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello; //객체반환은 기본으로 JSON으로 가진다
    }

    // 잘 씀 -> 데이터 요청
    static class Hello{
        private String name;

        public String getName(){
            return name;
        }

        public void setName(String name){
            this.name = name;
        }
    }


}
