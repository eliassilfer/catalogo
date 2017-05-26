package com.catalogo;

import com.catalogo.domain.Item;
import com.catalogo.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by stefanini on 25/05/17.
 */
@SpringBootApplication
public class SampleController implements CommandLineRunner {

    @Autowired
    private ItemRepository itemRepository;

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SampleController.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        itemRepository.deleteAll();
        Item item = new Item();
        item.setNome("Teste");
        item.setPreco(2.3);
        itemRepository.save(item);

        Item item2 = new Item();
        item2.setNome("Teste2");
        item2.setPreco(5.3);
        itemRepository.save(item2);

        for (Item i : itemRepository.findAll()) {
            System.out.println(i.toString());
        }

        System.out.println(itemRepository.findByNome("Teste").getPreco());
    }
}
