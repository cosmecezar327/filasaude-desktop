package br.com.ccs.filasaude.javafx;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import br.com.ccs.filasaude.FilasaudeApplication;
import br.com.ccs.filasaude.controller.PacienteControllerFX;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

	@Override
	public void start(Stage stage) throws Exception {

	    FXMLLoader loader = new FXMLLoader(
	            getClass().getResource("/fxml/paciente_form.fxml"));

	    Scene scene = new Scene(loader.load(), 500, 300);

	    stage.setTitle("Cadastro de Paciente");
	    stage.setScene(scene);
	    stage.show();
	}

    public static void main(String[] args) {
    	ConfigurableApplicationContext context  =
    	        SpringApplication.run(
    	                FilasaudeApplication.class,
    	                args);

    	PacienteControllerFX.setApplicationContext(context);

    	launch(args);
        launch(args);
    }
}