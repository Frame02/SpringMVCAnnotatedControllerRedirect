package com.srikar.springmvc.controller;

import com.srikar.springmvc.domain.Product;
import com.srikar.springmvc.form.ProductForm;
import com.srikar.springmvc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Created by vedantas on 2/4/2018.
 */
@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value="/product_input", method={RequestMethod.GET})
    public String getProuctForm(){
        return "inputRroduct";
    }

    @RequestMapping(value="/save_product", method={RequestMethod.POST})
    public String saveProductDetails(ProductForm productForm, Model model, RedirectAttributes redirectAttributes){
        Product product = new Product();
        product.setName(productForm.getName());
        product.setDescription(productForm.getDescription());
        try{
            product.setPrice(Float.parseFloat(productForm.getPrice()));
        }
        catch(NumberFormatException ex){
            return "inputProduct";
        }

        productService.saveProduct(product);
        redirectAttributes.addFlashAttribute("message", "The product has been successfully saved!");
        return "redirect:/product_saved/" + product.getId();
    }

    @RequestMapping(value="/product_saved/{id}", method={RequestMethod.GET})
    public String getSavedProduct(@PathVariable Long id, Model model){
        Product product = productService.getProduct(id);
        model.addAttribute("product", product);
        return "savedProduct";
    }

}
