package Entity;
/**
 * @author Artem Balakin (03.09.2021)
 * Сущность для хранения и работы в программе
 */
public class PeopleEntity {
    private String name;
    private String surname;
    private String city;

    public PeopleEntity(String name, String surname, String city) {
        this.name = name;
        this.surname = surname;
        this.city = city;
    }
    public PeopleEntity(){
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}

