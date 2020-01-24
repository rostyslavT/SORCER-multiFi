package src.main.interfaces;

import src.main.dto.ReceptDTO;
import src.main.dto.IngreedientDTO;

import java.util.List;

import java.rmi.RemoteException;

public class ReceptMakking {

    public ReceptDTO createNewRecept(List<IngreedientDTO> ingreedientList) throws RemoteException;

    public boolean testNewRecept(ReceptDTO recept) throws RemoteException;

    public ReceptDTO modifyRecept(ReceptDTO recept, List<IngreedientDTO> ingreedientList) throws RemoteException;

    public void deleteRecept(ReceptDTO recept) throws RemoteException;

}