package webservicesdemo.phase4;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexContorllerP4 {

    @GetMapping("/")
    public String getHomePage() {

        return "index.html";
    }
}
