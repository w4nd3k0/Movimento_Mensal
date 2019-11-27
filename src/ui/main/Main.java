package ui.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javax.swing.ImageIcon;

/**
 *
 * @author lusst
 */
public class Main extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        
        Parent root = FXMLLoader.load(getClass().getResource("Principal.fxml"));
        
        Scene scene = new Scene(root);
        
        //Icone da janela
        stage.getIcons().add(new Image("/ui/imagens/cw transparente.png"));
                
        //Abrir maximizado
        stage.setMaximized(true);
        
        stage.setTitle("Movimento Mensal");
        
        stage.setScene(scene);
        
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
