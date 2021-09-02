package DTO;
/**
 * @author Artem Balakin (03.09.2021)
 * DTO для записи из бд
 */

public class PeopleDTO {

    private String name;
    private String surname;
    private String city;


    public PeopleDTO(String name, String surname, String city) {
        this.name = name;
        this.surname = surname;
        this.city = city;
    }
    public PeopleDTO(){
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

