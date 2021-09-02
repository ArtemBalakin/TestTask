package Database;
import DTO.PeopleDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author  Artem Balakin (03.09.2021)
 * Класс для работы с БД
 */
public class PostgreDatabase {


    private static final String DB_URL = "jdbc:postgresql://127.0.0.1:5432/Peoples";
    private static final String USER = "postgres";
    private static final String PASS = "22446688";
    private PreparedStatement pr;
    private Connection connection;

    /**
     * Для прогрузки драйвера БД
     * @return true- если все хорошо
     *         false- если драйвер не найден
     */
    private boolean runDriver() {
        try {
            Class.forName("org.postgresql.Driver");
            return true;
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver is not found. Include it in your library path ");
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Осуществляет попытку подключения к БД
     */
    public void connectionToDatabase() {

        System.out.println("Testing connection to PostgreSQL JDBC");

        if (!runDriver()) {
            System.out.println("PostgreSQL JDBC Driver not found! Connection error!");
            return;
        }
        System.out.println("PostgreSQL JDBC Driver successfully connected");
        try {
            connection = DriverManager
                    .getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
            return;
        }
        if (connection != null) {
            System.out.println("You successfully connected to database now");
        } else {
            System.out.println("Failed to make connection to database");
        }
    }

    /**
     * SELECT по всем данным из БД
     * @return Лист с ДТО из БД
     */
    public List<PeopleDTO> getAllData() {
        try {
            pr = connection.prepareStatement("SELECT * FROM employers");
            ResultSet set = pr.executeQuery();
            return resultSetToList(set);
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return null;
    }

    /**
     * Превращает ResultSet в Лист с ДТО
     * @param set- получаемый из БД список
     * @return- лист с ДТО
     * @throws SQLException
     */
    private List<PeopleDTO> resultSetToList(ResultSet set) throws SQLException {
        List<PeopleDTO> list = new ArrayList<>();
        String name;
        String surname;
        String city;
        System.out.println(set.getRow());
       while (set.next()){
            name = set.getString(1);
            surname = set.getString(2);
            city = set.getString(3);
            list.add(new PeopleDTO(name, surname, city));
        }
        return list;
    }
}