package com.spring.crud.Contoller;

import java.util.List;

import javax.validation.Valid;

import com.spring.crud.Model.Employee;
import com.spring.crud.Service.EmpService;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmpController {

    @Autowired
    private EmpService empService;

    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Home Page");
        List<Employee> emplist= this.empService.getAllEmployee();
        model.addAttribute("list", emplist);
        return "home";
    }

    @GetMapping("/add")
    public String addEmployee(Model model) {
        model.addAttribute("title", "Registration Form");
        model.addAttribute("employee", new Employee());
        return "addform";
    }

    @PostMapping("/register")
    public String registerEmployee(@Valid @ModelAttribute("emp") Employee emp, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("employee", emp);
            return "addform";
        }
        this.empService.save(emp);
        model.addAttribute("employee", new Employee());
        return "Sucess";
    }

    @PostMapping("/update/{id}")
    public String updateEmployee(@PathVariable("id") Integer id, Model model){
        model.addAttribute("title", "Update Form");
        Employee employee= this.empService.findContact(id);
        model.addAttribute("employee", employee);
        return "update";
    }

    @PostMapping("/updatecontact")
    public String processUpdate(@Valid @ModelAttribute Employee emp, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("employee", emp);
            return "addform";
        }

        // System.out.println(emp.getId());
        emp.setId(emp.getId());
        this.empService.save(emp);
        model.addAttribute("employee", new Employee());
        return "redirect:/";
    }

    @PostMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id, Model model){
        this.empService.deleteEmployee(id);
        return "redirect:/";
    }


}
