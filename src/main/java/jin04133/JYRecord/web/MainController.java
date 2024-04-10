package jin04133.JYRecord.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jy.record")
public class MainController {
    @GetMapping
    public String getMainPage() {
        return "main";
    }
    @GetMapping("/category/edit")
    public String getCategoryEditOnMainPage() {
        return "main_category";
    }
    @GetMapping("/content")
    public String getContentPage() {
        return "content";
    }
    @GetMapping("/content/edit")
    public String getContentEditForm() {
        return "content_form";
    }
    @PostMapping("/content/edit")
    public String saveContentEditForm() {
        return "redirect:/jy.record/content";
    }
}
