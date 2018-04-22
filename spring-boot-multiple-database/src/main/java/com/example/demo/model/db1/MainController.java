package com.example.demo.model.db1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.db2.Product;
import com.example.demo.repo.db1.CustomerRepo;
import com.example.demo.repo.db2.ProductRepo;

@RestController
//@RequestMapping("/api")
//@ComponentScan({"com.example.demo.config", "com.example.demo.model.*","com.example.demo.repo.*"})
public class MainController {
	
	@Autowired 
	private  CustomerRepo customerRepo;
	 
	@Autowired 
	private  ProductRepo productRepo;
	
	
	 /*MainController(CustomerRepo customerRepo)
	 {
		 this.customerRepo=customerRepo;
	 }*/

	/*@RequestMapping(method = RequestMethod.GET)
    List<Customer> findAll() {
      //  return service.findAll();
        
        List<Customer> todoEntries = customerRepo.findAll();
        return todoEntries;
    }*/
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Customer> getAllUsers() {
		// This returns a JSON or XML with the users
		return customerRepo.findAll();
	}
	
	@GetMapping(path="/allp")
	public @ResponseBody Iterable<Product> getAllproduct() {
		// This returns a JSON or XML with the users
		return productRepo.findAll();
		
	}
	
	@RequestMapping(path="/a")
	public String ge() 
	{
		return "mohit";
	}
	
	
	@RequestMapping(value = "/aa", method = RequestMethod.GET)
	public ResponseEntity<Customer> findCustomer() {

		List bookings = customerRepo.findAll();
		return new ResponseEntity(bookings,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/aap", method = RequestMethod.GET)
	public ResponseEntity<Product> findpr() {

		List bookings = productRepo.findAll();
		return new ResponseEntity(bookings,HttpStatus.OK);
	}
	
}
