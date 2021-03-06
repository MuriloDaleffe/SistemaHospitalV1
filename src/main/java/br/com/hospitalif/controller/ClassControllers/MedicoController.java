package br.com.hospitalif.controller.ClassControllers;

import br.com.hospitalif.DAO2.MedicoDAO;
import br.com.hospitalif.DAO2.MedicoDAO2;
import br.com.hospitalif.connectivity.SimpleEntityManager;
import br.com.hospitalif.model.Medico;
import util.Rotas;
import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.sql.SQLException;

public class MedicoController {

    @FXML
    private Button btnReset;

    @FXML
    private Button btnSave;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtLogin;

    @FXML
    private TextField txtSenha;

    @FXML
    private TextField txtStatusUsuario;

    @FXML
    private TextField txtCPF;

    @FXML
    private TextField intIdade;

    @FXML
    private TextField txtTipoSang;

    @FXML
    private TextField cboSexo;

    @FXML
    private TextField txtStatusPessoa;

    @FXML
    private TextField txtEspecialidade;

    @FXML
    private TextField txtNumRegistro;

    @FXML
    private Button btnCancel;

    @FXML
    public void initialize() {
        txtNumRegistro = new TextField();
        txtEspecialidade = new TextField();
        txtNome = new TextField();
        txtStatusUsuario = new TextField();
        txtLogin = new TextField();
        txtSenha = new TextField();
        txtCPF = new TextField();
        intIdade = new TextField();
        txtTipoSang = new TextField();
        cboSexo = new TextField();
        txtStatusPessoa = new TextField();

    }

    @FXML
    void save(ActionEvent event) throws SQLException {

        Medico m = new Medico();

        m.setNumRegistro(txtNumRegistro.getText());
        m.setEspecialidade(txtEspecialidade.getText());
        m.setNome(txtNome.getText());
        m.setStatusDeUsuario(txtStatusUsuario.getText());
        m.setLogin(txtLogin.getText());
        m.setSenha(txtSenha.getText());
        m.setCpf(txtCPF.getText());
        m.setIdade(Integer.parseInt(intIdade.getText()));
        m.setTipoSanguineo(txtTipoSang.getText());
        m.setSexo(cboSexo.getText());
        m.setStatusDePessoa(txtStatusPessoa.getText());

        SimpleEntityManager sem = new SimpleEntityManager(Rotas.PERSISTENCEUNITNAME);
        MedicoDAO2 dao = new MedicoDAO2(sem.getEntityManager());
        dao.salvar(m);

        msgInfo();
    }

    @FXML
    void cancel(ActionEvent event) throws Exception {
        Main.openPage(Rotas.SISTEMA);
    }

    @FXML
    void reset(ActionEvent event) {
        txtNumRegistro.clear();
        txtEspecialidade.clear();
        txtNome.clear();
        txtStatusUsuario.clear();
        txtLogin.clear();
        txtSenha.clear();
        txtCPF.clear();
        intIdade.clear();
        txtTipoSang.clear();
        cboSexo.clear();
        txtStatusPessoa.clear();
    }

    public void msgInfo(){
        Alert msg = new Alert(Alert.AlertType.INFORMATION);
        msg.setContentText("Médico cadastrado com sucesso!");
        msg.setHeaderText("Cadastro de Médico!");
        msg.show();
    }

    @FXML
    public void editar(Medico m){
        initialize();
        System.out.println(m.getNome());
        txtNome.setText(m.getNome());
        txtNumRegistro.setText(m.getNumRegistro());
        txtEspecialidade.setText(m.getEspecialidade());
        txtStatusUsuario.setText(m.getStatusDeUsuario());
        txtLogin.setText(m.getLogin());
        txtSenha.setText(m.getSenha());
        txtCPF.setText(m.getCpf());
        intIdade.setText(String.valueOf(m.getIdade()));
        txtTipoSang.setText(m.getTipoSanguineo());
        cboSexo.setText(m.getSexo());
        txtStatusPessoa.setText(m.getStatusDePessoa());

    }

}

