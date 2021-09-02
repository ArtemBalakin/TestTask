package com.company;

import DTO.PeopleDTO;
import Database.PostgreDatabase;
import Entity.PeopleEntity;
import Fonts.FontNames;
import Mappers.PeopleMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Artem Balakin (03.09.2021)
 * Программа для экспорта данных из Java в документ .xls
 */
public class Main {
    public static void main(String[] args) {
        PostgreDatabase database = new PostgreDatabase();
        database.connectionToDatabase();
        List<PeopleDTO> peopleDTOS = database.getAllData();
        List<PeopleEntity> peopleEntities = new ArrayList<>();
        for (PeopleDTO peopleDTO : peopleDTOS) {
            peopleEntities.add(PeopleMapper.DtoToEntity(peopleDTO));
        }
        XlsDocument document = new XlsDocument("ExportResult.xls", peopleEntities, new String[]{"Name", "Surname", "City"});
        document.decorateHeader(FontNames.TIMES_NEW_ROMAN);
    }


}

