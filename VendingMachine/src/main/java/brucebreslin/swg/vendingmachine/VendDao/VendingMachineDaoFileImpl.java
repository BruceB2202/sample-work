/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brucebreslin.swg.vendingmachine.VendDao;

import brucebreslin.swg.vendingmachine.VendDto.Snack;
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
public class VendingMachineDaoFileImpl implements VendingMachineDao{
    public static final String INVENTORY_FILE = "inventory.txt";
    public static final String DELIMITER = "::";
    
    Map<String, Snack> inventoryList = new HashMap<>();
     
    
    
    private void writeInventory() throws VendFilePersistenceException{
       
        
        PrintWriter out;
        
        try{
            out = new PrintWriter(new FileWriter(INVENTORY_FILE));
        } catch (IOException e){
            throw new VendFilePersistenceException("Could not save inventory file.", e);
        }
        
        
        List<Snack> inventory = this.getAllSnacksInInventory();
        for(Snack currentSnack: inventory){
            out.println(currentSnack.getLocationInMachine()+ DELIMITER + currentSnack.getName()+ DELIMITER + currentSnack.getCost() + DELIMITER + currentSnack.getAmountInStock());
            
            out.flush(); 
            
        }
        
        out.close();
    }  
    
    
    

        private void readInventory() throws VendFilePersistenceException{
        Scanner scanner;
        
        try{
            scanner = new Scanner(new BufferedReader(new FileReader(INVENTORY_FILE)));
        }catch(FileNotFoundException e){
            throw new VendFilePersistenceException("Inventory list could not be loaded.", e);
        }
        
        String currentLine;
        String[] currentTokens;
        
        while(scanner.hasNextLine()){
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            Snack currentSnack = new Snack(currentTokens[0]);
            currentSnack.setName(currentTokens[1]);
            currentSnack.setCost(new BigDecimal(currentTokens[2]));
            currentSnack.setAmountInStock(Integer.parseInt(currentTokens[3]));
            
            this.addSnack(currentSnack.getLocationInMachine(), currentSnack);
        }
        scanner.close();
    }
    
    
    
    

    @Override
    public Snack vend(String location) throws VendFilePersistenceException{
        Snack vendedItem = inventoryList.get(location.toUpperCase());
        vendedItem.setAmountInStock(vendedItem.getAmountInStock() - 1);
        writeInventory();
        return vendedItem;
        
    }

    @Override
    public List<Snack> getAllSnacksInInventory() throws VendFilePersistenceException{
        readInventory();
        return new ArrayList<>(inventoryList.values());
    }

    @Override
    public Snack getSnackAtLocation(String location) throws VendFilePersistenceException{
        readInventory();
        return inventoryList.get(location.toUpperCase());
        
    }

    @Override
    public Snack addSnack(String location, Snack snack) throws VendFilePersistenceException{
        Snack newSnack = inventoryList.put(location, snack);
        writeInventory();
        return newSnack;
    }

    @Override
    public Snack removeSnack(String location) throws VendFilePersistenceException {
        Snack removedSnack = inventoryList.remove(location);
        writeInventory();
        return removedSnack;
    }
    
}
