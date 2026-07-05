package br.com.ccs.filasaude.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import br.com.ccs.filasaude.model.Paciente;
import br.com.ccs.filasaude.repository.PacienteRepository;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class PacienteControllerFX {
	@FXML private TextField txtNome;
	@FXML private TextField txtCpf;
	@FXML private TextField txtIdade;

	
	@FXML private CheckBox cbDiabetes;
	@FXML private CheckBox cbHipertensao;
	@FXML private CheckBox cbCardiaco;
	@FXML private CheckBox cbAtivo;
	
	@FXML
	private RadioButton rbMasculino;

	@FXML
	private RadioButton rbFeminino;
	
	@FXML
	private PacienteRepository repository;
	
	 private static ApplicationContext context;
    
	public static void setApplicationContext(ApplicationContext applicationContext) {
        context = applicationContext;
    }

	@FXML
	public void initialize() {

		repository = context.getBean(PacienteRepository.class);
	    ToggleGroup grupoSexo = new ToggleGroup();

	    rbMasculino.setToggleGroup(grupoSexo);
	    rbFeminino.setToggleGroup(grupoSexo);

	    cbAtivo.setSelected(true);
	}
	
	@FXML
	public void salvar() {

	    Paciente paciente = new Paciente();

	    paciente.setNome(txtNome.getText());
	    paciente.setCpf(txtCpf.getText());

	    if (!txtIdade.getText().isEmpty()) {
	        paciente.setIdade(Integer.parseInt(txtIdade.getText()));
	    }

	    if (rbMasculino.isSelected()) {
	        paciente.setSexo("Masculino");
	    } else if (rbFeminino.isSelected()) {
	        paciente.setSexo("Feminino");
	    }

	    paciente.setAtivo(cbAtivo.isSelected());

	    List<String> habilidades = new ArrayList<>();

	    if (cbDiabetes.isSelected()) {
	        habilidades.add("Diabetes");
	    }

	    if (cbHipertensao.isSelected()) {
	        habilidades.add("Hipertensão");
	    }

	    if (cbCardiaco.isSelected()) {
	        habilidades.add("Cardíaco");
	    }

	    paciente.setHabilidades(habilidades);

	    System.out.println(repository);
	    
	    repository.save(paciente);

	    System.out.println("Paciente salvo!");
	}
	
	@FXML
	public void limpar() {
	    txtNome.clear();
	    txtCpf.clear();
	    txtIdade.clear();

	    rbMasculino.setSelected(false);
	    rbFeminino.setSelected(false);

	    cbDiabetes.setSelected(false);
	    cbHipertensao.setSelected(false);
	    cbCardiaco.setSelected(false);

	    cbAtivo.setSelected(true);
	}
}