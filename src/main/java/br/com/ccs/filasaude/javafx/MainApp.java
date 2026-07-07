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

    private ConfigurableApplicationContext context;

    @Override
    public void init() {
        context = SpringApplication.run(FilasaudeApplication.class);

        PacienteControllerFX.setApplicationContext(context);
    }

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/fxml/paciente_form.fxml"));

        Scene scene = new Scene(loader.load());

        stage.setTitle("Cadastro de Paciente");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop() {
        context.close();
    }

    public static void main(String[] args) {
        launch(args);
    }
}