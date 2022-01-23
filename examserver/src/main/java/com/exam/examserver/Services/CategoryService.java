package com.exam.examserver.Services;

import java.util.Set;

import com.exam.examserver.Model.Exam.Category;

public interface CategoryService {
    public Category addCategory(Category category);
    public Category updCategory(Category category);
    public Set<Category> getCategories();
    public Category getCategory(Long cid);
    public void deleteCategory(Long cid);   
}
