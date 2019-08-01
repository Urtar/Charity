document.addEventListener("DOMContentLoaded", function() {

  /**
   * Form Select
   */
  class FormSelect {
    constructor($el) {
      this.$el = $el;
      this.options = [...$el.children];
      this.init();
    }

    init() {
      this.createElements();
      this.addEvents();
      this.$el.parentElement.removeChild(this.$el);
    }

    createElements() {
      // Input for value
      this.valueInput = document.createElement("input");
      this.valueInput.type = "text";
      this.valueInput.name = this.$el.name;

      // Dropdown container
      this.dropdown = document.createElement("div");
      this.dropdown.classList.add("dropdown");

      // List container
      this.ul = document.createElement("ul");

      // All list options
      this.options.forEach((el, i) => {
        const li = document.createElement("li");
        li.dataset.value = el.value;
        li.innerText = el.innerText;

        if (i === 0) {
          // First clickable option
          this.current = document.createElement("div");
          this.current.innerText = el.innerText;
          this.dropdown.appendChild(this.current);
          this.valueInput.value = el.value;
          li.classList.add("selected");
        }

        this.ul.appendChild(li);
        // $(function() {
        //   var streetValue = $('.street').attr('value');
        // });
      });

      this.dropdown.appendChild(this.ul);
      this.dropdown.appendChild(this.valueInput);
      this.$el.parentElement.appendChild(this.dropdown);
    }

    addEvents() {
      this.dropdown.addEventListener("click", e => {
        const target = e.target;
        this.dropdown.classList.toggle("selecting");

        // Save new value only when clicked on li
        if (target.tagName === "LI") {
          this.valueInput.value = target.dataset.value;
          this.current.innerText = target.innerText;
        }
      });
    }
  }
  document.querySelectorAll(".form-group--dropdown select").forEach(el => {
    new FormSelect(el);
  });

  /**
   * Hide elements when clicked on document
   */
  document.addEventListener("click", function(e) {
    const target = e.target;
    const tagName = target.tagName;

    if (target.classList.contains("dropdown")) return false;

    if (tagName === "LI" && target.parentElement.parentElement.classList.contains("dropdown")) {
      return false;
    }

    if (tagName === "DIV" && target.parentElement.classList.contains("dropdown")) {
      return false;
    }

    document.querySelectorAll(".form-group--dropdown .dropdown").forEach(el => {
      el.classList.remove("selecting");
    });
  });

  /**
   * Switching between form steps
   */
  class FormSteps {
    constructor(form) {
      this.$form = form;
      this.$next = form.querySelectorAll(".next-step");
      this.$prev = form.querySelectorAll(".prev-step");
      this.$step = form.querySelector(".form--steps-counter span");
      this.currentStep = 1;

      this.$stepInstructions = form.querySelectorAll(".form--steps-instructions p");
      const $stepForms = form.querySelectorAll("form > div");
      this.slides = [...this.$stepInstructions, ...$stepForms];

      this.init();


    }

    /**
     * Init all methods
     */
    init() {
      this.events();
      this.updateForm();
    }

    /**
     * All events that are happening in form
     */
    events() {
      // Next step
      this.$next.forEach(btn => {
        btn.addEventListener("click", e => {
          e.preventDefault();
          this.currentStep++;
          this.updateForm();
        });
      });

      // Previous step
      this.$prev.forEach(btn => {
        btn.addEventListener("click", e => {
          e.preventDefault();
          this.currentStep--;
          this.updateForm();
        });
      });

      // Form submit
      this.$form.querySelector("form").addEventListener("submit", e => this.submit(e));
    }

    /**
     * Update form front-end
     * Show next or previous section etc.
     */
    updateForm() {
      this.$step.innerText = this.currentStep;

      // TODO: Validation

      this.slides.forEach(slide => {
        slide.classList.remove("active");

        if (slide.dataset.step == this.currentStep) {
          slide.classList.add("active");
        }
      });

      this.$stepInstructions[0].parentElement.parentElement.hidden = this.currentStep >= 5;
      this.$step.parentElement.hidden = this.currentStep >= 5;

      // TODO: get data from inputs and show them in summary
      // var categories = document.querySelector('span[name="category"]').valueOf().innerHTML;
      // document.querySelector('p[data-categories=""]').innerText = categories;

      nameOfCategoryChecked();

      var quantity = document.querySelector('input[name="quantity"]').valueOf().value;
      document.querySelector('p[data-quantity=""]').innerText = quantity;

      nameOfInstitutionChecked();

      // var institution = document.querySelector('div[name="institution"]').valueOf().innerHTML;
      // document.querySelector('p[data-institution=""]').innerText = institution;

      // var institutionDescription = document.querySelector('div[name="institutionDescription"]').valueOf().innerHTML;
      // document.querySelector('li[data-institutionDescription=""]').innerText = institutionDescription;


      var streetValue = document.querySelector('input[name="street"]').valueOf().value;
      document.querySelector('p[data-street=""]').innerText = streetValue;

      var city = document.querySelector('input[name="city"]').valueOf().value;
      document.querySelector('p[data-city=""]').innerText = city;

      var zipCode = document.querySelector('input[name="zipCode"]').valueOf().value;
      document.querySelector('p[data-zipCode=""]').innerText = zipCode;

      var phone = document.querySelector('input[name="phone"]').valueOf().value;
      document.querySelector('p[data-phone=""]').innerText = phone;

      var pickUpDate = document.querySelector('input[name="pickUpDate"]').valueOf().value;
      document.querySelector('p[data-pickUpDate=""]').innerText = pickUpDate;

      var pickUpTime = document.querySelector('input[name="pickUpTime"]').valueOf().value;
      document.querySelector('p[data-pickUpTime=""]').innerText = pickUpTime;

      var pickUpComment = document.querySelector('textarea[name="pickUpComment"]').valueOf().value;
      document.querySelector('p[data-pickUpComment=""]').innerText = pickUpComment;
    }

  }
  const form = document.querySelector(".form--steps");
  if (form !== null) {
    new FormSteps(form);
  }


  function nameOfInstitutionChecked()
  {
    var institutions = Array.prototype.slice.call(document.getElementsByClassName("institution"));
    for(var i=0;i<institutions.length;i++)
    {
      if (institutions[i].checked) {
        var institution = institutions[i].name;
        document.querySelector('p[data-institution=""]').innerText = institution;
      }
    }
  }

  function nameOfCategoryChecked()
  {
    var categories = Array.prototype.slice.call(document.getElementsByClassName("categories"));
    var chosenCategories = new Array();
    for(var j=0;j<categories.length;j++)
    {
   if(categories[j].checked){

     chosenCategories.push(categories[j].name);
   }
      document.querySelector('p[data-categories=""]').innerText = chosenCategories.toString();
      // if (categories[j].checked) {
      //   var category = categories[j].name;
      //   document.querySelector('p[data-categories=""]').innerText = category;
      // }
    }
  }

 });
