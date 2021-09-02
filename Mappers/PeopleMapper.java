package Mappers;

import DTO.PeopleDTO;
import Entity.PeopleEntity;

/**
 * @author Artem Balakin (03.09.2021)
 * Маппер для превращения PeopleDTO в Entity и наоборот
 */
public class PeopleMapper {
    /**
     * Сущность в ДТО
     * @param peopleDTO-получаем из БД
     * @return сущность для бизнес логики
     */
    public static PeopleEntity DtoToEntity(PeopleDTO peopleDTO) {
        PeopleEntity entity = new PeopleEntity();
        entity.setCity(peopleDTO.getCity());
        entity.setName(peopleDTO.getName());
        entity.setSurname(peopleDTO.getSurname());
        return entity;
    }

    /**
     * Из сущности в ДТО
     * @param peopleEntity- сущность из программы
     * @return Объект для БД
     */
    public static PeopleDTO EntityToDto(PeopleEntity peopleEntity) {
        PeopleDTO peopleDTO = new PeopleDTO();
        peopleDTO.setCity(peopleEntity.getCity());
        peopleDTO.setName(peopleEntity.getName());
        peopleDTO.setSurname(peopleEntity.getSurname());
        return peopleDTO;
    }
}
