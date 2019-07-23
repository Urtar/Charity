package pl.coderslab.charity.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull
    private int quantity;
    @NotEmpty
    @ManyToMany
    private List<Category> categories;
    @OneToOne
    private Institution institution;
    @NotEmpty
    private String street;
    @NotEmpty
    private String city;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate pickUpDate;
    @NotEmpty
    @DateTimeFormat(pattern = "hh-MM")
    private LocalTime pickUpTime;
    @NotEmpty
    private String pickUpComment;

    public Donation() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public Institution getInstitution() {
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


}
