package pl.coderslab.charity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.entity.Category;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.repository.CategoryRepository;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.repository.InstitutionRepository;
import pl.coderslab.charity.services.CurrentUser;
import pl.coderslab.charity.services.UserService;

import java.util.List;

@Controller
public class DonationController {
    private InstitutionRepository institutionRepository;
    private CategoryRepository categoryRepository;
    private DonationRepository donationRepository;

    @Autowired
    public DonationController(InstitutionRepository institutionRepository, CategoryRepository categoryRepository, DonationRepository donationRepository){
        this.institutionRepository = institutionRepository;
        this.categoryRepository = categoryRepository;
        this.institutionRepository = institutionRepository;
    }


//    @Autowired
//    public InstitutionRepository institutionRepository;
//    @Autowired
//    public CategoryRepository categoryRepository;
//    @Autowired
//    public DonationRepository donationRepository;

    @ModelAttribute("institutions")
    public List<Institution> institutionsList() {
        return institutionRepository.findAll();
    }

    @ModelAttribute("categories")
    public List<Category> categoriesList() {
        return categoryRepository.findAll();
    }

    @GetMapping("/user/donation/add")
    public String donationAdd(Model model) {
        model.addAttribute("donation", new Donation());
        return "form";
    }

    @PostMapping("/user/donation/add")
    public String donationAddSaveToDB(@ModelAttribute Donation donation,@AuthenticationPrincipal CurrentUser customUser) {
        donationRepository.save(donation);
        return "form-confirmation";
    }

}
