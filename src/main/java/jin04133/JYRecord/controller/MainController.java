package jin04133.JYRecord.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jy.record")
public class MainController {
    @GetMapping
    public String getMainPage() {
        return "main.html";
    }

}
