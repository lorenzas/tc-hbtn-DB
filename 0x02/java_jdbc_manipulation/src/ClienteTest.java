public class ClienteTest {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:sqlite_database_marco_2022.db";

        ClienteDAOImpl clienteDAOImpl = new ClienteDAOImpl();
        clienteDAOImpl.connect(url);

        clienteDAOImpl.createTable(url);

        Cliente cliente1 = new Cliente();
        cliente1.setNome("Cristina Volpato");
        cliente1.setIdade(37);
        cliente1.setCpf("111.111.111-11");
        cliente1.setRg("222.222.222-22");

        Cliente cliente2 = new Cliente();
        cliente2.setNome("Vanderson Silva");
        cliente2.setIdade(28);
        cliente2.setCpf("333.333.333-33");
        cliente2.setRg("444.444.444-44");

        clienteDAOImpl.insert(url, cliente1);
        clienteDAOImpl.insert(url, cliente2);

        clienteDAOImpl.selectAll(url);

        clienteDAOImpl.update(url, 1, "Cristina Conrad", 38);
        clienteDAOImpl.selectAll(url);

        clienteDAOImpl.delete(url, 2);
        clienteDAOImpl.selectAll(url);
    }
}
