package com.catalogo.controller;

import com.catalogo.domain.Item;
import com.catalogo.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by stefanini on 26/05/17.
 */
@Controller
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("item", new Item());
        model.addAttribute("itens", itemRepository.findAll());
        return "index";
    }

    @RequestMapping("/cadastro")
    public String cadastrar(Model model) {
        model.addAttribute("item", new Item());
        return "cadastrar";
    }

    @RequestMapping("/cadastrar")
    public String cadastrar(@ModelAttribute Item item, Model model) {
        itemRepository.save(item);
        model.addAttribute("itens", itemRepository.findAll());
        return "index";
    }

    @RequestMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") String id, Model model) {
        itemRepository.delete(id);
        model.addAttribute("item", new Item());
        model.addAttribute("itens", itemRepository.findAll());
        return "index";
    }
}
