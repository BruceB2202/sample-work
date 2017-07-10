/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brucebreslin.swg.flooringmastery.Dao;

import brucebreslin.swg.flooringmastery.Model.Product;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Bruce_Breslin
 */
public class FlooringMasteryProductDaoFileImpl implements FlooringMasteryProductDao {

    public static final String ROSTER_FILE = "products.txt";
    public static final String DELIMITER = "::";

    Map<Integer, Product> productsCarried = new HashMap<>();

    @Override
    public Product addProduct(Product product) {
        Product newProduct = productsCarried.put(product.getProductId(), product);
        return newProduct;
    }

    @Override
    public Product getProduct(int productId) {
        return productsCarried.get(productId);
    }

    @Override
    public List<Product> getAllProducts() {
        return new ArrayList<Product>(productsCarried.values());
    }

    @Override
    public Product editProduct(Product modifiedProduct) {
        Product editedProduct = productsCarried.put(modifiedProduct.getProductId(), modifiedProduct);
        return editedProduct;
    }

    @Override
    public Product removeProduct(int productId) {
        Product removedProduct = productsCarried.remove(productId);
        return removedProduct;
    }

    @Override
    public void saveProducts(List<Product> productList) throws FlooringMasteryDataPersistenceException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(ROSTER_FILE));
        } catch (IOException ex) {
            throw new FlooringMasteryDataPersistenceException("Product data could not be saved to file.");
        }
        for (Product product : productList) {

            out.println(product.getProductId() + DELIMITER + product.getProductName() + DELIMITER + product.getMaterialCostPerSqFt() + DELIMITER + product.getLaborCostPerSqFt());
            out.flush();

        }
        out.close();

    }

    
    @Override
    public void loadProducts() throws FlooringMasteryDataPersistenceException {
        Scanner scanner;

        try {
            scanner = new Scanner(new BufferedReader(new FileReader(ROSTER_FILE)));

        }catch(FileNotFoundException e){
            throw new FlooringMasteryDataPersistenceException("Could not load product data.");
        }
        
        
        String currentLine;
        String[] currentTokens;
        while(scanner.hasNextLine()){
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            Product currentProduct = new Product(Integer.parseInt(currentTokens[0]));
            currentProduct.setProductName(currentTokens[1]);
            currentProduct.setMaterialCostPerSqFt(new BigDecimal(currentTokens[2]));
            currentProduct.setLaborCostPerSqFt(new BigDecimal(currentTokens[3]));
            productsCarried.put(currentProduct.getProductId(), currentProduct);
        }
        
        scanner.close();

    }

}
