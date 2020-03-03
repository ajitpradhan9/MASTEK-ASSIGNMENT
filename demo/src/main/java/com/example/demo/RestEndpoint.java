package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@Api(value = "defaultController", description = "Fibonaccii..!!!!")
public class RestEndpoint {
	
	
	@GetMapping(value = "/fibonacci/{maxNumber}")
	@ApiOperation(value = "String Array for Fibonacci Number", response = Iterable.class, tags = "Fibonacci")
	public ResponseEntity<?> fibonacciString(@PathVariable("maxNumber") String maxNumber){
		if(maxNumber != null && !"".equals(maxNumber) && !this.isNumeric(maxNumber) ) {
			return ResponseEntity.badRequest().body("Please Provide a valid Digit");
		} 
		return ResponseEntity.ok().body(this.logic(maxNumber));
	}
	
	
	@GetMapping("/fibonacciStringConcat/{maxNumber}")
	@ApiOperation(value = "String Array for Fibonacci Number *WITH CONCAT LOGIC*", response = Iterable.class, tags = "Fibonacci_String_Concat")
	public ResponseEntity<?> fibonacciStringConcat(@PathVariable("maxNumber") String maxNumber){
		if(maxNumber != null && !"".equals(maxNumber) && !this.isNumeric(maxNumber) ) {
			return ResponseEntity.badRequest().body("Please Provide a valid Digit");
		}	
		return ResponseEntity.ok().body(this.logic2(maxNumber));
	}
	
	private List<String> logic(String maxNumber) {
		
		int count = Integer.parseInt(maxNumber), num1 = 0, num2 = 1;
		List<String> arr = new ArrayList<>();
        int i=1;
        while(i<=count){
//            System.out.print(num1+" ");
            arr.add(num1+"");
            if(num2 > count) {
            	break;
            }
            int sumOfPrevTwo = num1 + num2;
            num1 = num2;
            num2 = sumOfPrevTwo;
            i++;
        }
        return arr;
	}
	
	private List<String> logic2(String maxNumber) {
		int count = Integer.parseInt(maxNumber), num1 = 0, num2 = 1;
		List<String> arr = new ArrayList<>();
        int i=1;
        while(i<=count){
//            System.out.print(num1+" ");
            arr.add(num1+"");
            if(num2 > count) {
            	break;
            }
            arr.add(num1+""+num2);
            int sumOfPrevTwo = num1 + num2;
            num1 = num2;
            num2 = sumOfPrevTwo;
            i++;
        }
        return arr;
	}
	
	private boolean isNumeric(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
 }
