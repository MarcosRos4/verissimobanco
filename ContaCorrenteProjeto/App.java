package ContaCorrenteProjeto;

import java.awt.EventQueue;

import ContaCorrenteProjeto.view.LoginView;

public class App {
    
    public static void main(String[] args) {
        
        EventQueue.invokeLater(new Runnable() {
            public void run(){
                try {
                    LoginView loginView = new LoginView();
                    
                } catch (Exception e) {
                    
                    e.printStackTrace();
                }
            }
        });
    }
}
