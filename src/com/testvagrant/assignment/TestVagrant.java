package com.testvagrant.assignment;


import java.util.ArrayList;
import java.util.List;

class Products {
    String productName;
    int Price;
    int gst;
    int quantity;
    
    public Products(String productName, int Price, int gst, int quantity) {
        this.productName = productName;
        this.Price = Price;
        this.gst = gst;
        this.quantity = quantity;
    }
}

public class TestVagrant {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

        Products p1 = new Products("Leather wallet", 1100, 18, 1);
        Products p2 = new Products("Umbrella", 900, 12, 4);
        Products p3 = new Products("Cigarette", 200, 28, 3);
        Products p4 = new Products("Honey", 100, 0, 2);
        
        // Add products to basket
        List<Products> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);

        // Find product with maximum GST amount
        Products maxGstProduct = null;
        int maxGstAmount = 0;
        for (Products p : list) {
            int gstAmount = p.Price * p.gst * p.quantity / 100;
            if (gstAmount > maxGstAmount) {
                maxGstAmount = gstAmount;
                maxGstProduct = p;
            }
        }
        System.out.println("The product with the maximum GST amount is: " + maxGstProduct.productName);

     // Calculate total amount to be paid
        double totalAmount = 0;
        for (Products product : list) {
            double discountedPrice = product.Price;
            if (product.Price >= 500) {
                discountedPrice = product.Price * 0.95; 
            }
            double gstAmount = (discountedPrice * product.gst) / 100;
            double totalPrice = discountedPrice + gstAmount;
            totalAmount = totalAmount + totalPrice * product.quantity;
        }
        System.out.println("Total amount to be paid: Rs. " + totalAmount);
	}
}
