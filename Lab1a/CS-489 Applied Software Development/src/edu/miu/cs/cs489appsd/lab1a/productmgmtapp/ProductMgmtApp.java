package edu.miu.cs.cs489appsd.lab1a.productmgmtapp;

import edu.miu.cs.cs489appsd.lab1a.productmgmtapp.model.Product;

import java.util.*;

public class ProductMgmtApp {

    private static void printJSONFormat(List<Product> products){

        System.out.println("Printed in JSON Format");
        System.out.println("[");
        for (Product product : products) {
            System.out.println("{ \"productId\":"+product.getProductId()+", \"name\":"+product.getName()+", \"dateSupplied\":"+product.getDateSupplied()+", \"quantityInStock\":"+product.getQuantityInStock()+", \"unitPrice\":"+product.getUnitPrice()+"  },");
        }
        System.out.println("]");
    }

    private static void printXMLFormat(List<Product> products){
        System.out.println("Print XML Format");
        System.out.println("<?xml version=\"1.0\"");
        System.out.println("<products>");
        for (Product product : products) {
            System.out.println("<product productId=\""+product.getProductId()+"\" name=\""+product.getName()+"\" dateSupplied=\""+product.getDateSupplied()+"\" quantityInStock=\""+product.getQuantityInStock()+"\" unitPrice=\""+product.getUnitPrice()+"\"/>");
        }
        System.out.println("</products>");
    }

    private static void printCSVFormat(List<Product> products){
        System.out.println("Print Comma-Seperated Value - CSV Format");
        for (Product product : products) {
            System.out.println(product.getProductId()+", "+product.getName()+", "+product.getDateSupplied()+", "+product.getQuantityInStock()+", "+product.getUnitPrice());
        }
    }
    public static void main(String args[]){
        List<Product> products = new ArrayList<Product>();
        products.add(new Product(3128874119L, "Banana", "2023-01-24", 124, 0.55 ));
        products.add(new Product(2927458265L, "Apple", "2023-12-09", 18, 1.09 ));
        products.add(new Product(9189927460L, "Carrot", "2023-03-31", 89, 2.99 ));

        Collections.sort(products, new Comparator<Product>(){
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        printJSONFormat(products);
        System.out.println("------------------------------------");
        printXMLFormat(products);
        System.out.println("------------------------------------");
        printCSVFormat(products);
    }

}
