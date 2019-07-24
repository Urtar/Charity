package pl.coderslab.charity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.entity.Category;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.repository.CategoryRepository;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.repository.InstitutionRepository;

import java.util.List;


@Controller
public class HomeController {

    @Autowired
    public InstitutionRepository institutionRepository;
    @Autowired
    public DonationRepository donationRepository;

    @ModelAttribute("donations")
    public List<Donation> donationsList() {
        return donationRepository.findAll();
    }

    @Autowired
    public CategoryRepository categoryRepository;

    @ModelAttribute("donatedBagsQuantity")
    public int donatedBagsQuantity() {
        int sum=0;
        for (Donation d:donationRepository.findAll()
             ) {
            sum = sum+d.getQuantity();
        }
        return sum;
    }

    @ModelAttribute("institutions")
    public List<Institution> institutionsList() {
        return institutionRepository.findAll();
    }

//    @ModelAttribute("categories")
//    public List<Category> categoriesList() {
//        return categoryRepository.findAll();
//    }

    @RequestMapping("/")
    public String homeAction(Model model) {
        return "index";
    }
}
