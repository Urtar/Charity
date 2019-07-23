package pl.coderslab.charity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import pl.coderslab.charity.entity.Category;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.repository.CategoryRepository;
import pl.coderslab.charity.repository.InstitutionRepository;

import java.util.List;

@Controller
public class DonationController {
    @Autowired
    public InstitutionRepository institutionRepository;
    @Autowired
    public CategoryRepository categoryRepository;

    @ModelAttribute("institutions")
    public List<Institution> institutionsList() {
        return institutionRepository.findAll();
    }

    @ModelAttribute("categories")
    public List<Category> categoriesList() {
        return categoryRepository.findAll();
    }

    @GetMapping("/donation/add")
    public String donationAdd (){
        return "form";
    }

}
