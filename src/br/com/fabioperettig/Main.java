package br.com.fabioperettig;

import br.com.fabioperettig.dao.IClientDAO;
import br.com.fabioperettig.dao.ClientMapDAO;
import br.com.fabioperettig.domain.Client;

import javax.swing.*;

public class Main {

    private static IClientDAO iClientDAO;

    public static void main(String[] args) {

        iClientDAO = new ClientMapDAO();

        String option = JOptionPane.showInputDialog(null,
                "Enter '1' to register | '2' to view | '3' to delete | '4' to edit | '0' to exit.",
                "Register", JOptionPane.INFORMATION_MESSAGE);

        while(!validOption(option)){
            option = JOptionPane.showInputDialog(null,
                    "Invalid option, enter '1' to register | '2' to view | '3' to delete | '4' to edit | '0' to exit.",
                    "Register", JOptionPane.INFORMATION_MESSAGE);
        }

        while(validOption(option)){
            switch (option){

                case "1": String data = JOptionPane.showInputDialog(null,
                        "Enter the client's information separated by ';' as the example: Name: Id; Phone; Address; House number; City; State",
                        "Register", JOptionPane.INFORMATION_MESSAGE);
                        register(data);

                case "0":exit();
            }
        }

    }

    private static void register(String data) {
        String[] splitData = data.split(";");

        Client client = new Client(
                splitData[0],splitData[1],
                splitData[2],splitData[3],
                splitData[4],splitData[5],
                splitData[6]
        );

        boolean alreadyRegistered = iClientDAO.register(client);

        if(alreadyRegistered) {
            JOptionPane.showMessageDialog(null,
                    "Client successfully registered!",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null,
                    "A client with this ID already exists!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private static boolean validOption(String option) {
        if("1".equals(option) || "2".equals(option) || "3".equals(option) ||
                "4".equals(option) || "0".equals(option)) {
            return true;
        }
        return false;
    }

    private static void exit(){
        JOptionPane.showMessageDialog(null, "Until next time!", "Exit", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

}