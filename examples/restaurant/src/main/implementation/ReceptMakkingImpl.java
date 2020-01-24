package src.main.implementation;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

import src.main.dto.ReceptDTO;
import src.main.dto.IngreedientDTO;
import src.main.interfaces.ReceptMakking;

import java.rmi.RemoteException;

public class RececptMakkingImpl implements ReceptMakking {

    public Recept createNewRecept(List<IngreedientDTO> ingreedientList) throws RemoteException {
        Random rand = new Random();

        if(!rand.nextBoolean()) {
            System.err.println("Unfortunately, this recept is not ok :(");
            return ;
        }

        int amountOfDishes = rand.nextInt(ingreedientList.size());

        double futureDishPrice = ingreedientList.stream
                .map(Ingreedients::getPrice)
                .reduce(0, Integer::sum);
        futureDishPrice = futureDishPrice*amountOfDishes + rand.nextInt(13);

        double calories = amountOfDishes + rand.nextInt(666);

        ReceptDTO receptDTO = new ReceptDTO(ingreedientList, amountOfDishes, futureDishPrice, calories);

        return receptDTO;
    }

    public boolean testNewRecept(Recept recept) throws RemoteException {
        double ingrPrice = recept.getIngreedients().stream()
                .map(Ingreedients::getPrice)
                .reduce(0, Integer::sum);

        double difference = recept.getPrice() - ingrPrice;

        if(difference < 5 || difference > 5000)
            return false;

        if(recept.getCalories() > 99999)
            return false;

        Random rand = new Random();

        if(rand.nextInt(5) < 1 && recept.getIngreedients().size() > 10)
            return false;

        return true;

    }

    public Recept modifyRecept(Recept recept, List<IngreedientDTO> ingreedientList) throws RemoteException {
        if(ingreedientList != null && !ingreedientList.isEmpty()) {
            recept.setIngreedients(ingreedientList);
        }

        return recept;
    }

    public void deleteRecept(Recept recept) throws RemoteException {
        ReceptDTO.getReceptDTOList().remove(recept);
    }

}