package com.example.springBootDBCRUD.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.springBootDBCRUD.model.Product;
import com.example.springBootDBCRUD.service.ProductService;

@Controller
//@RequestMapping(value = "/demo")
public class ProducttWebController {
	@Autowired
	private ProductController productController;
	@Autowired
	private ProductService productService;

	@GetMapping("/")
	public String getAllProducts(Model model) {
		List<Product> products = productController.getAllProducts();
		model.addAttribute("products", products);
		return "list_Product";

	}

	@GetMapping("/new_Product")
	public String addProducts(Model model) {
		Product products = new Product();
		model.addAttribute("products", products);
		return "new_Product";

	}

	@PostMapping(value = "/save_new")
	public String saveNewProduct(@ModelAttribute("products") Product product) {
		productController.addProduct(product);
		return "redirect:/";

	}

	@GetMapping("/update_product/{pId}")
	public String updateProduct(@PathVariable("pId") Long id, Model model) {
		// Product products = new Product();
		model.addAttribute("products", productController.getProductById(id));
		return "update_product";

	}

	@PostMapping(value = "/save_updated")
	public String updateProduct(@ModelAttribute("products") Product product) {
		productController.updateProduct(product.getId(), product);
		return "redirect:/";

	}

//	@GetMapping("/delete_product/{pId}")
//	public String deleteProduct(@PathVariable ("pId") Long id , Model model ) {
//		//Product products = new Product();
//		model.addAttribute("products", productController.getProductById(id));
//		return "delete_product";
//
//	}
//	@PostMapping(value = "/delete_product")
//	public String deleteProduct(@ModelAttribute("products") Product product ) {
//		productController.deleteProduct(product.getId());
//		return "redirect:/" ;
//
//	}
	@GetMapping("/delete_product/{pId}")
	public String deleteProduct(@PathVariable("pId") Long id) {
		// Product products = new Product();
		productService.deleteProduct(id);
		return "redirect:/";

	}
}
