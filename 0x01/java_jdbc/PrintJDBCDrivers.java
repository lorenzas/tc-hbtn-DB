import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;

public class PrintJDBCDrivers {
    public static void main(String[] args) {
        for (Enumeration<Driver> drivers = DriverManager.getDrivers(); drivers.hasMoreElements();) {
            Driver driver = drivers.nextElement();

            System.out.printf("Nome: %s Versão: %d\n", driver.getClass().getName(), driver.getMajorVersion());
        }
    }
}
