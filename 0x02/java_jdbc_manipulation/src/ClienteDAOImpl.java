import java.sql.*;

public class ClienteDaoImpl implements ClienteDAO {
    @Override
    public Connection connect(String urlConexao) {
        Connection connection = null;

        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(urlConexao);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return connection;
    }

    @Override
    public void createTable(String urlConexao) {
        StringBuilder sql = new StringBuilder();
        sql.append("CREATE TABLE IF NOT EXISTS CLIENTE (");
        sql.append("ID INTEGER PRIMARY KEY , ");
        sql.append("NOME TEXT NOT NULL, ");
        sql.append("IDADE INTEGER, ");
        sql.append("CPF TEXT NOT NULL, ");
        sql.append("RG TEXT ");
        sql.append(")");

        try {
            Connection connection = connect(urlConexao);
            Statement stmt = connection.createStatement();
            stmt.execute(sql.toString());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void insert(String url_conexao, Cliente cliente) {
        String sql = "INSERT INTO CLIENTE(NOME, IDADE, CPF, RG) VALUES(?,?,?,?)";

        try {
            Connection connection = connect(url_conexao);
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, cliente.getNome());
            pstmt.setInt(2, cliente.getIdade());
            pstmt.setString(3, cliente.getCpf());
            pstmt.setString(4, cliente.getRg());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void selectAll(String urlConexao) {
        String sql = "SELECT ID, NOME, IDADE, CPF, RG FROM CLIENTE";

        try {
            Connection connection = connect(urlConexao);
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);
            while (resultSet.next()) {
                System.out.printf(
                        "ID %d \t NOME %s \t  IDADE %d \t CPF %s \t RG %s \t",
                        resultSet.getInt("ID"),
                        resultSet.getString("NOME"),
                        resultSet.getInt("IDADE"),
                        resultSet.getString("CPF"),
                        resultSet.getString("RG"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(String urlConexao, int id, String name, Integer idade) {
        String sql = "UPDATE CLIENTE SET NOME = ? , + IDADE = ?    WHERE ID = ?";

        try {
            Connection connection = connect(urlConexao);
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setInt(2, idade);
            pstmt.setInt(3, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(String urlConexao, int id) {
        String sql = "DELETE FROM CLIENTE WHERE ID = ?";

        try {
            Connection connection = connect(urlConexao);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}