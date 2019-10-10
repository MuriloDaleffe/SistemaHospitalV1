package br.com.hospitalif.DAO;

import br.com.hospitalif.connectivity.ConnectionClass;
import br.com.hospitalif.model.Atendente;
import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AtendenteDAO {


    public static void save(Atendente g) throws SQLException {

        ConnectionClass conn = new ConnectionClass();
        Connection conexao = conn.getConnection();

        System.out.println(conn.getStatus());

        String sqlInsere = "insert into Atendente(cargo, login, senha, statusDeUsuario, nome, cpf, idade, " +
                "tipoSanguineo, sexo, statusDePessoa) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement stmt = conexao.prepareStatement(sqlInsere);
        stmt.setString(1, g.getCargo());
        stmt.setString(2, g.getLogin());
        stmt.setString(3, g.getSenha());
        stmt.setString(4, g.getStatusDeUsuario());
        stmt.setString(5, g.getNome());
        stmt.setString(6, g.getCpf());
        stmt.setInt(7, g.getIdade());
        stmt.setString(8, g.getTipoSanguineo());
        stmt.setString(9, g.getSexo());
        stmt.setString(10, g.getStatusDePessoa());
        stmt.execute();
    }

    public static void removeByID(int id) throws SQLException {

        ConnectionClass conn = new ConnectionClass();
        Connection conexao = conn.getConnection();

        System.out.println(conn.getStatus());

        String sqlInsere = "delete from Atendente where id = (?)";

        PreparedStatement stmt = conexao.prepareStatement(sqlInsere);
        stmt.setInt(1, id);
        stmt.execute();
    }

    public static void edit(Atendente g) throws SQLException {

        ConnectionClass conn = new ConnectionClass();
        Connection conexao = conn.getConnection();

        System.out.println(conn.getStatus());

        String sqlInsere = "update Atendente set cargo= (?), login= (?), senha= (?), " +
                "statusDeUsuario= (?), nome= (?), cpf= (?), idade= (?), tipoSanguineo= (?), sexo= (?), " +
                "statusDePessoa= (?) where id = (?)";

        PreparedStatement stmt = conexao.prepareStatement(sqlInsere);
        stmt.setString(1, g.getCargo());
        stmt.setString(2, g.getLogin());
        stmt.setString(3, g.getSenha());
        stmt.setString(4, g.getStatusDeUsuario());
        stmt.setString(5, g.getNome());
        stmt.setString(6, g.getCpf());
        stmt.setInt(7, g.getIdade());
        stmt.setString(8, g.getTipoSanguineo());
        stmt.setString(9, g.getSexo());
        stmt.setString(10, g.getStatusDePessoa());
        stmt.setInt(11, g.getIdAtendente());
        stmt.execute();
    }

    public static Atendente searchByID(int id) throws SQLException {
        ConnectionClass conn = new ConnectionClass();
        Connection conexao = conn.getConnection();

        System.out.println(conn.getStatus());

        String sqlInsere = "select * from Atendente where id = ?";

        PreparedStatement stmt = conexao.prepareStatement(sqlInsere);
        stmt.setInt(1, id);
        ResultSet result = stmt.executeQuery();

        if(result != null && result.next()){
            Atendente atendente = new Atendente();
            atendente.setNome(result.getString("nome"));
            atendente.setCpf(result.getString("cpf"));
            atendente.setIdade(result.getInt("idade"));
            atendente.setTipoSanguineo(result.getString("tipoSanguineo"));
            atendente.setSexo(result.getString("sexo"));
            atendente.setStatusDePessoa(result.getString("statusDePessoa"));
            atendente.setLogin(result.getString("login"));
            atendente.setSenha(result.getString("senha"));
            atendente.setStatusDeUsuario(result.getString("statusDeUsuario"));
            atendente.setIdAtendente(result.getInt("id"));
            msgInfo(1);
            return atendente;
        }else{
            msgInfo(0);
        }

        return null;

    }

    public static List<Atendente> selectAll() throws SQLException {
        ConnectionClass conn = new ConnectionClass();
        Connection conexao = conn.getConnection();

        System.out.println(conn.getStatus());

        String sqlInsere = "select * from Atendente";
        PreparedStatement stmt = conexao.prepareStatement(sqlInsere);
        ResultSet result = stmt.executeQuery();

        List<Atendente> atendentes = new ArrayList<Atendente>();

        while(result.next()) {
            Atendente g1 = new Atendente();
            g1.setNome(result.getString("nome"));
            g1.setCpf(result.getString("cpf"));
            g1.setIdade(result.getInt("idade"));
            g1.setTipoSanguineo(result.getString("tipoSanguineo"));
            g1.setSexo(result.getString("sexo"));
            g1.setStatusDePessoa(result.getString("statusDePessoa"));
            g1.setLogin(result.getString("login"));
            g1.setSenha(result.getString("senha"));
            g1.setStatusDeUsuario(result.getString("statusDeUsuario"));
            g1.setIdAtendente(result.getInt("id"));
            atendentes.add(g1);
        }
        return atendentes;
    }

    public static void msgInfo(int num){
        Alert msg = new Alert(Alert.AlertType.INFORMATION);
        if(num==1){
            msg.setContentText("Registro encontrado!");
            msg.setHeaderText("Busca");
            msg.show();
        }else{
            msg.setContentText("Não foi possível encontrar nenhum registro!");
            msg.setHeaderText("Busca");
            msg.show();
        }
    }

}

