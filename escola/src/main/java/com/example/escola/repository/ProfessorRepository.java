package com.example.escola.repository;

import com.example.escola.model.Aluno;
import com.example.escola.model.Professor;
import com.example.escola.util.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProfessorRepository {

    public Professor create(Professor professor) throws SQLException {

        String query = "INSERT INTO professor (nome, email, disciplina) VALUES (?,?,?)";


        try (Connection connection = Conexao.conectar();
             PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, professor.getNome());
            stmt.setString(2, professor.getEmail());
            stmt.setString(3, professor.getDisciplina());


            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();

            if (rs.next()) {
                professor.setId(rs.getInt(1));
            }

        }

        return professor;
    }

    public List<Professor> listAll() throws SQLException {
        List<Professor> professores = new ArrayList<>();

        String query = "SELECT id, nome, email,disciplina FROM professor";

        try (Connection connection = Conexao.conectar();
             PreparedStatement stmt = connection.prepareStatement(query)) {


            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                String disciplina = rs.getString("disciplina");

                Professor professor = new Professor(id, nome, email, disciplina);
                professores.add(professor);
            }
        }

        return professores;
    }

    public Professor listId(int id) throws SQLException {

        String query = "SELECT id, nome, email,disciplina FROM professor WHERE id = ?";


        List<Professor> professores = new ArrayList<>();

        try (Connection connection = Conexao.conectar();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                String disciplina = rs.getString("disciplina");

                return new Professor(id, nome, email,disciplina);
            }
        }
        return null;
    }


    public void delete(int id) throws SQLException {

        String query = "DELETE FROM professor where id = ?";

        try (Connection connection = Conexao.conectar();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        }

    }


    public Professor update(Professor professor, int id) throws SQLException {
        String query = "UPDATE professor SET nome = ?, email = ?, disciplina = ? WHERE id = ?";


        try (Connection connection = Conexao.conectar();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setString(1, professor.getNome());
            stmt.setString(2, professor.getEmail());
            stmt.setString(3, professor.getDisciplina());
            stmt.setInt(4, professor.getId());


            stmt.executeUpdate();
        }


        return professor;
    }



}
