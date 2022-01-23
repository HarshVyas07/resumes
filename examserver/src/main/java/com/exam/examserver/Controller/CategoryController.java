package com.exam.examserver.Controller;

import com.exam.examserver.Model.Exam.Category;
import com.exam.examserver.Services.CategoryServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {
    @Autowired
    private CategoryServiceImpl categoryServiceImpl;

    //add
    @PostMapping("/")
    public ResponseEntity<?> addCategory(@RequestBody Category category){
        Category category1= this.categoryServiceImpl.addCategory(category);
        return ResponseEntity.ok(category1);
    }
    //get category
    @GetMapping("/{categoryId}")
    public Category getCategory(@PathVariable("categoryId") Long categoryId){
        return this.categoryServiceImpl.getCategory(categoryId);
    }
    //get all category
    @GetMapping("/")
    public ResponseEntity<?> getAllCategory(){
        return ResponseEntity.ok(this.categoryServiceImpl.getCategories());
    }
    //update
    @PutMapping("/")
    public Category uCategory(@RequestBody Category category){
        return this.categoryServiceImpl.updCategory(category);
    }

    // Delete 
    @DeleteMapping("/{categoryId}")
    public void deleteCategory(@PathVariable("categoryId") Long categoryId){
        this.categoryServiceImpl.deleteCategory(categoryId);
    }
}
