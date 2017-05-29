package com.catalogo.controller;

import com.catalogo.domain.Item;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by stefanini on 26/05/17.
 */
@Controller
public class ItemController {

    @RequestMapping("/index")
    public String index(@ModelAttribute Item item) {
        return "index";
    }
}
