package pl.coderslab.charity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.entity.Category;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.repository.CategoryRepository;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.repository.InstitutionRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
public class DonationController {
    @Autowired
    public InstitutionRepository institutionRepository;
    @Autowired
    public CategoryRepository categoryRepository;
    @Autowired
    public DonationRepository donationRepository;

    @ModelAttribute("institutions")
    public List<Institution> institutionsList() {
        return institutionRepository.findAll();
    }

    @ModelAttribute("categoriesList")
    public List<Category> categoriesList() {
        return categoryRepository.findAll();
    }

    @GetMapping("/donation/add")
    public String donationAdd(Model model) {

        model.addAttribute("donation", new Donation());
        return "form";
    }

    @PostMapping("/donation/add")
    public String donationAddSaveToDB(@ModelAttribute Donation donation) {
        donationRepository.save(donation);
        return "form-confirmation";
    }

}
