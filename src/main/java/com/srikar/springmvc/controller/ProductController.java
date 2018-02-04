package com.srikar.springmvc.controller;

import com.srikar.springmvc.domain.Product;
import com.srikar.springmvc.form.ProductForm;
import com.srikar.springmvc.service.ProductService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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

    private static final Log logger = LogFactory.getLog(ProductController.class);

    @Autowired
    private ProductService productService;

    @RequestMapping(value="/product_input", method={RequestMethod.GET})
    public String getProductForm(){
        logger.info("Retrieving product input form...");
        return "inputProduct";
    }

    @RequestMapping(value= "/product_save", method={RequestMethod.POST})
    public String saveProductDetails(ProductForm productForm, Model model, RedirectAttributes redirectAttributes){
        logger.info("Saving product details...");
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
        redirectAttributes.addFlashAttribute("message", "The product has been successfully added!");
        return "redirect:/product_view/" + product.getId();
    }

    @RequestMapping(value="/product_view/{id}", method={RequestMethod.GET})
    public String getSavedProduct(@PathVariable Long id, Model model){
        logger.info("Viewing product details for product id: " + id);
        Product product = productService.getProduct(id);
        model.addAttribute("product", product);
        return "productView";
    }

}
