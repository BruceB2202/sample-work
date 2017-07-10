/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brucebreslin.swg.vendingmachine.VendDao;

import brucebreslin.swg.vendingmachine.VendDto.Snack;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Bruce_Breslin
 */
public class VendingMachineDaoStubImpl implements VendingMachineDao {

    Snack snickers;
    Snack twix;
    List<Snack> snackList = new ArrayList<>();

    public VendingMachineDaoStubImpl() {
        snickers = new Snack("A1");
        snickers.setName("Snickers");
        snickers.setCost(new BigDecimal("1.25"));
        snickers.setAmountInStock(10);

        twix = new Snack("A2");
        twix.setName("Twix");
        twix.setCost(new BigDecimal("1.25"));
        twix.setAmountInStock(0);

        snackList.add(snickers);
        snackList.add(twix);

    }

    @Override
    public Snack vend(String location) throws VendFilePersistenceException {
        List<Snack> wantedSnackList = snackList.stream()
                .filter(s -> s.getLocationInMachine().equalsIgnoreCase(location))
                .collect(Collectors.toList());
        if (wantedSnackList.size() == 1) {
            return wantedSnackList.get(0);
        }else{
            return null;
        }
    }

    @Override
    public List<Snack> getAllSnacksInInventory() throws VendFilePersistenceException {
        return snackList;
    }

    @Override
    public Snack getSnackAtLocation(String location) throws VendFilePersistenceException {
        List<Snack> wantedSnackList = snackList.stream()
                .filter(s -> s.getLocationInMachine().equalsIgnoreCase(location))
                .collect(Collectors.toList());
        if (wantedSnackList.size() == 1) {
            return wantedSnackList.get(0);
        }else{
            return null;
        }
    }

    @Override
    public Snack addSnack(String location, Snack snack) throws VendFilePersistenceException {
        List<Snack> wantedSnackList = snackList.stream()
                .filter(s -> s.getLocationInMachine().equalsIgnoreCase(location))
                .collect(Collectors.toList());
        if (wantedSnackList.size() == 1) {
            return wantedSnackList.get(0);
        }else{
            return null;
        }
    }

    @Override
    public Snack removeSnack(String location) throws VendFilePersistenceException {
        List<Snack> wantedSnackList = snackList.stream()
                .filter(s -> s.getLocationInMachine().equalsIgnoreCase(location))
                .collect(Collectors.toList());
        if (wantedSnackList.size() == 1) {
            return wantedSnackList.get(0);
        }else{
            return null;
        }
    }

}
