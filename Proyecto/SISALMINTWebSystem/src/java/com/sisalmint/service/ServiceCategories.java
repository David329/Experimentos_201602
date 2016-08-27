/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sisalmint.service;

import com.sisalmint.dao.CategoriesDAO;
import com.sisalmint.entity.Categories;
import java.util.List;

/**
 *
 * @author David
 */
public class ServiceCategories {

    public void addCategory(Categories objCategory) {
        CategoriesDAO objCategoryDAO = new CategoriesDAO();
        objCategoryDAO.addCategory(objCategory);
    }

    public void editCategory(Categories objCategory) {
        CategoriesDAO objCategoryDAO = new CategoriesDAO();
        objCategoryDAO.editCategory(objCategory);
    }

    public void deleteCategory(Categories objCategory) {
        CategoriesDAO objCategoryDAO = new CategoriesDAO();
        objCategoryDAO.deleteCategory(objCategory);
    }

    public Categories getCategoryById(String CategoryID) {
        CategoriesDAO objCategoryDAO = new CategoriesDAO();
        return objCategoryDAO.getCategoryById(CategoryID);
    }

    public List<Categories> getCategories() {
        CategoriesDAO objCategoryDAO = new CategoriesDAO();
        return objCategoryDAO.getCategories();
    }
}
