/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brucebreslin.swg.vendingmachine.VendService;

import brucebreslin.swg.vendingmachine.VendDao.VendFilePersistenceException;
import brucebreslin.swg.vendingmachine.VendDao.VendingMachineDao;
import brucebreslin.swg.vendingmachine.VendDto.Snack;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/**
 *
 * @author Bruce_Breslin
 */
public class VendingMachineServiceImpl implements VendingMachineService {

    VendingMachineDao dao;
    Change change = new Change();

    public VendingMachineServiceImpl(VendingMachineDao dao) {
        this.dao = dao;
    }

    private String currentBalance = "0.00";

    @Override
    public Change vendService(String location) throws VendingMachineInsufficientFundsException, VendingMachineInsufficientInventoryException, VendFilePersistenceException {
        Snack wantedSnack = getSnackAtLocation(location);
        boolean inStock = false;
        
        if(wantedSnack.getAmountInStock() > 0 ){
            inStock = true;
        }else{
            throw new VendingMachineInsufficientInventoryException("Out of stock.");
        }
        
        if (inStock) {
            BigDecimal priceDifference = new BigDecimal(currentBalance).subtract(wantedSnack.getCost());
            int differenceResult = priceDifference.compareTo(BigDecimal.ZERO);

            if (differenceResult >= 0) {
                dao.vend(location);
                change.getChangeDue(priceDifference.multiply(new BigDecimal("100")).setScale(0));
                currentBalance = "0.00";
                return change;
            } else {
                throw new VendingMachineInsufficientFundsException("There are not enough funds for this purchase. You have only inserted: " + new BigDecimal(currentBalance).setScale(2, RoundingMode.HALF_UP));
            }
        } else {
            throw new VendingMachineInsufficientInventoryException("Out of stock.");
        }
    }

    @Override
    public List<Snack> getAllSnacksInInventory() throws VendFilePersistenceException {
        return dao.getAllSnacksInInventory();
    }

    @Override
    public Snack getSnackAtLocation(String location) throws VendFilePersistenceException {
        return dao.getSnackAtLocation(location);
    }

    @Override
    public String addMoney(BigDecimal moneyToAdd) {
        BigDecimal newBalance = new BigDecimal(currentBalance).add(moneyToAdd);
        currentBalance = newBalance.toString();
        return currentBalance;
    }

}
