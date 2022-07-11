package hm.offer.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class FrontController {

    @GetMapping("/indexp")
    public String index(){

        return "/index.html";
    }
}