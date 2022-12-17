package com.example.demo.service;

import com.example.demo.dto.PersonDTO;
import com.example.demo.dto.ResultDTO;
import com.example.demo.exception.PersonError;
import com.example.demo.exception.PersonException;
import com.example.demo.model.Draw;
import com.example.demo.model.Person;
import com.example.demo.repository.DrawRepository;
import com.example.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DrawService
{

    @Autowired
    PersonRepository personRepository;

    @Autowired
    DrawRepository drawRepository;

    public ResultDTO drawPerson(PersonDTO personDTO)
    {
        ResultDTO resultDTO = new ResultDTO();
        checkPersonValidity(personDTO);
        Draw draw = drawRepository.findAllByDrawedNameAndDrawedSurname(personDTO.getName(),personDTO.getSurname());
        if(draw != null)
        {
            resultDTO.setName(draw.getSelectedName());
            resultDTO.setSurname(draw.getSelectedSurname());
            Person person = personRepository.findAllByName(draw.getSelectedName());
            resultDTO.setLetter(person.getLetter());
        }
        else
        {
            List<Person> availablePeople = personRepository.findAllByIsSelectedFalse();
            Person foundPerson = findRandomPerson(availablePeople, personDTO);
            resultDTO = getResponse(foundPerson, personDTO);
        }


        return resultDTO;
    }

    private Person findRandomPerson(List<Person> availablePeople, PersonDTO personDTO)
    {
        Random rand = new Random();

        List<Long> availableKeys = availablePeople.stream().map(p->p.getId()).collect(Collectors.toList());

        Map<Integer,Long> randomArea = new HashMap<>();

        for(int i=0; i<availableKeys.size(); i++)
        {
            randomArea.put(i+1,availableKeys.get(i));
        }

        Integer randValue = rand.nextInt(availableKeys.size())+1;
        Long drawedPersonId = randomArea.get(randValue);

        // MARIA & PIOTR FIX
        if(personDTO.getName().equals("Maria") || personDTO.getName().equals("maria")){
            drawedPersonId =  6L;
        }

        if(personDTO.getName().equals("Piotr") || personDTO.getName().equals("piotr")){
            drawedPersonId =  9L;
        }
        // MARIA FIX

        Optional<Person> drawedPerson = personRepository.findById(drawedPersonId);

        Person personFromRequest = personRepository.findAllByName(personDTO.getName());

        if(drawedPerson.get().getId()!=personFromRequest.getId())
        {
            drawedPerson.get().setSelected(true);
            personRepository.save(drawedPerson.get());

            personFromRequest.setTakePartInDraw(true);
            personRepository.save(personFromRequest);

            Draw draw = new Draw();
            draw.setDrawedName(personDTO.getName());
            draw.setDrawedSurname(personDTO.getSurname());
            draw.setSelectedName(drawedPerson.get().getName());
            draw.setSelectedSurname(drawedPerson.get().getSurname());
            drawRepository.save(draw);
        }
        else
        {
            throw new PersonException(PersonError.INCORRECT_DRAW);
        }

        personFromRequest.setLetter(personDTO.getLetter());
        personRepository.save(personFromRequest);

        return drawedPerson.get();
    }


    private void checkPersonValidity(PersonDTO personDTO) {
        String name = personDTO.getName();
        String surname = personDTO.getSurname();
        String uniqueCode = personDTO.getUniqueCode();

        Person person = personRepository.findAllByNameAndUniqueCode(name,uniqueCode);

        if(person == null){
            throw new PersonException(PersonError.INCORRECT_DATA);
        }

        if(person.getTakePartInDraw()==false && (personDTO.getLetter() == null || personDTO.getLetter().isEmpty() || personDTO.getLetter().isBlank()))
        {
            throw new PersonException(PersonError.LETTER_REQUIRED);
        }

    }

    private ResultDTO getResponse(Person foundPerson, PersonDTO personDTO) {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setName(foundPerson.getName());
        resultDTO.setSurname(foundPerson.getSurname());
        Person person = personRepository.findAllByName(foundPerson.getName());
        resultDTO.setLetter(person.getLetter());
        return resultDTO;
    }

    public List<Person> getList() {
        return personRepository.findAll();
    }

    public void fix() {
        Person person = personRepository.findAllByName("Maria");
        person.setLetter("Święty Mikołaju ja bym chciała dostać ciśnieniomierz  któryby pokazywał też arytmie. Żebyś nie wpadł w długi cenę dopłacę.");
        personRepository.save(person);
    }
}
