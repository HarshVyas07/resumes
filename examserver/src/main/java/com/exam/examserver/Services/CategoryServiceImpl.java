package com.exam.examserver.Services;

import java.util.LinkedHashSet;
import java.util.Set;

import com.exam.examserver.Model.Exam.Category;
import com.exam.examserver.Repository.CategoryRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public Category addCategory(Category category) {
       return this.categoryRepo.save(category);
    }

    @Override
    public Category updCategory(Category category) {
        return this.categoryRepo.save(category);
    }

    @Override
    public Set<Category> getCategories() {
        return new LinkedHashSet<>(this.categoryRepo.findAll());
    }

    @Override
    public Category getCategory(Long cid) {
        return this.categoryRepo.findById(cid).get();
    }

    @Override
    public void deleteCategory(Long cid) {
        Category category= new Category();
        category.setCid(cid);
        this.categoryRepo.delete(category);
    }
    
}
