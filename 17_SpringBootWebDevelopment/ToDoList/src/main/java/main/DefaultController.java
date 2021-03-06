package main;

import main.dao.DaoDef;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class DefaultController {

    @Autowired
    DaoDef daoDef;

    @RequestMapping("/")
    public String index(Model model) {
        return daoDef.index(model);
    }



}
