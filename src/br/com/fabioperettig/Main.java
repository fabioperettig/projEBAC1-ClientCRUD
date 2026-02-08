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

        while(!validOption(option)) {
            if ("".equals(option)) {
                exit();
            }
            option = JOptionPane.showInputDialog(null,
                    "Invalid option. Enter '1' to register | '2' to view | '3' to delete | '4' to edit | '0' to exit.",
                    "Green dinner", JOptionPane.INFORMATION_MESSAGE);
        }

        while(validOption(option)) {
            if(isExit(option)) {
                exit();
            } else if (isRegister(option)) {
                String data = JOptionPane.showInputDialog(null,
                        "Enter the client's information separated by ';'",
                        "Register", JOptionPane.INFORMATION_MESSAGE);
                register(data);
            } else if (isView(option)) {
                String data = JOptionPane.showInputDialog(null,
                        "Insert ID to find user",
                        "Search",JOptionPane.INFORMATION_MESSAGE);

                view(data);
            } else if (isEdit(option)){
                String data = JOptionPane.showInputDialog(null,
                        "Insert ID to find user",
                        "Search", JOptionPane.INFORMATION_MESSAGE);
                edit(data);
            }else if (isDelete(option)){
                String data = JOptionPane.showInputDialog(null,
                        "Insert ID to delete user",
                        "Delete", JOptionPane.INFORMATION_MESSAGE);
                delete(data);
            }

            option = JOptionPane.showInputDialog(null,
                    "Enter '1' to register | '2' to view | '3' to delete | '4' to edit | '0' to exit.",
                    "Green dinner", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static void edit(String data) {
        long id = Long.parseLong(data);
        Client found = iClientDAO.view(id);
        if (found != null) {
            String newData = JOptionPane.showInputDialog(null,
                    "Client found, edit client's information separated by ';'",
                    "Edit" + found.toString(), JOptionPane.INFORMATION_MESSAGE);

            String[] split = newData.split(";");

            Client update = new Client(split[0], split[1], split[2], split[3], split[4], split[5], split[6]);

            iClientDAO.edit(update);

            JOptionPane.showMessageDialog(null, "Client successfully updated", "Success", JOptionPane.INFORMATION_MESSAGE);

        } else {
            JOptionPane.showMessageDialog(null, "Client not found.", "Sorry",JOptionPane.INFORMATION_MESSAGE);
        }

    }

    private static boolean isEdit(String option) {
        if("4".equals(option)){
            return true;
        }
        return false;
    }

    private static void view(String data) {
        //valid only by id
        Client client = iClientDAO.view(Long.parseLong(data));
        if (client != null) {
            JOptionPane.showMessageDialog(null, "Client found: " + client.toString(), "Success",JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Client not found.", "Sorry",JOptionPane.INFORMATION_MESSAGE);
        }

    }

    private static boolean isView(String option){
        if("2".equals(option)) {
            return true;
        }
        return false;
    }

    private static void register(String data) {
        String[] splitData = data.split(";");

        Client client = new Client(splitData[0], splitData[1], splitData[2], splitData[3], splitData[4], splitData[5], splitData[6]);
        Boolean isRegistered = iClientDAO.register(client);
        if (isRegistered) {
            JOptionPane.showMessageDialog(null, "Client successfully registered", "Success",JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Client is already registered", "Error",JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static boolean isRegister(String option) {
        if("1".equals(option)) {
            return true;
        }
        return false;
    }

    private static boolean isExit(String option) {
        if ("5".equals(option)) {
            return true;
        }
        return false;
    }

    private static void exit() {
        JOptionPane.showMessageDialog(null, "Good bye", "Exit",JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

    private static boolean isDelete(String option) {
        if ("3".equals(option)) {
            return true;
        }
        return false;
    }

    private static void delete(String data){
        long id = Long.parseLong(data);
        Client found = iClientDAO.view(id);

        if(found != null) {
            iClientDAO.delete(id);

            JOptionPane.showMessageDialog(null,
                    "Client successfuly removed",
                    "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null,
                    "Client not found.",
                    "Sorry", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static boolean validOption(String option) {
        if("1".equals(option) || "2".equals(option) || "3".equals(option)
        || "4".equals(option) || "5".equals(option)) {
            return true;
        }
        return false;
    }

}