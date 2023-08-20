package org.example.dao;

import org.example.model.Client;
import org.example.model.CompteBancaire;
import org.example.model.Operation;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OperationDAO extends BaseDAO<Operation> {
    public OperationDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean save(Operation element) throws SQLException {
        request = "INSERT INTO operation (montant, id_compte_bancaire, statut) VALUES (?,?,?)";
        statement = _connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        statement.setDouble(2, element.getId());
        statement.setDouble(1, element.getMontant());
        statement.setBoolean(3, element.isStatut());

        int nbRows = statement.executeUpdate();
        resultSet = statement.getGeneratedKeys();
        if (resultSet.next()) {
            element.setId(resultSet.getInt(1));
        }
        return nbRows == 1;

    }

    @Override
    public List<Operation> getIdOperation() throws SQLException {
        return null;
    }

    @Override
    public List<Operation> getIdOperation(int id) throws SQLException {
        List<Operation> result = new ArrayList<>();
        Operation operation = null;
        request = "select * from operation where id_compte_bancaire = ?";
        statement = _connection.prepareStatement(request);
        statement.setInt(1, id);
        resultSet = statement.executeQuery();
        while (resultSet.next()) {
            operation = new Operation(resultSet.getInt("id"),
                    resultSet.getDouble("montant"),
                    resultSet.getBoolean("statut"));
            result.add(operation);
        }
        return result;
    }

    @Override
    public boolean update(CompteBancaire element) throws SQLException {
        return false;
    }

    @Override
    public CompteBancaire getIdCompte(int id) throws SQLException {
        return null;
    }

    @Override
    public List<CompteBancaire> getAllCompte(int id) throws SQLException {
        return null;
    }


    @Override
    public Client get(int id) throws SQLException {
        return null;
    }

    @Override
    public Client get(String nb_phone) throws SQLException {
        return null;
    }

    @Override
    public Client getId(int id) throws SQLException {
        return null;
    }
}
