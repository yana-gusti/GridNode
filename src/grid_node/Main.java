/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package grid_node;

import Pages.LoginPage;

import java.io.*;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Дом
 */
public class Main {
    public static LoginPage loginPage;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

         loginPage = new LoginPage();
         loginPage.setVisible(true);

    }
    
}
