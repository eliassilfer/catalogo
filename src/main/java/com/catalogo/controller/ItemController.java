package com.catalogo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by stefanini on 26/05/17.
 */
@Controller
public class ItemController {

    @RequestMapping("/index")
    String index() {
        return "index";
    }
}
