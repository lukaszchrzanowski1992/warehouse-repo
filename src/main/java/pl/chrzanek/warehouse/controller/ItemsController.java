package pl.chrzanek.warehouse.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.chrzanek.warehouse.model.Items;
import pl.chrzanek.warehouse.service.ItemsService;
import java.util.List;


@Controller
@RequiredArgsConstructor
@RequestMapping

public class ItemsController {

    @Autowired
    private ItemsService service;

    public ItemsController(ItemsService service) {
        this.service = service;
    }


    @GetMapping("/")
    public String index() {
        return "index";
    }
    @GetMapping("/mainPage")
    public String mainPage() {
        return "mainPage";
    }
    @GetMapping("/products")
    public String products(Model model) {
        List<Items> listItems = service.getItems();
        model.addAttribute("listItems", listItems);
        return "products";
    }
    @GetMapping("id/{id}")
    public String getSingleItem(@PathVariable(value="id") Integer id, Model model){
        Items items = service.getSingleItem(id);
        model.addAttribute("items", items);
        return "update_items";

    }

    @PostMapping("/save")
    public String save(@ModelAttribute("items") Items items){
        service.save(items);
        return "redirect:/products";
    }
    @GetMapping("new")
    public String newItems(Model model){
        Items items=new Items();
        model.addAttribute((items));
        return "new_items";
    }
    @GetMapping("/services")
    public String services() {
        return "services";}

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }





}





