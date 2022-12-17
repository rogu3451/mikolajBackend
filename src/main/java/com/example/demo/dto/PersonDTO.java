package com.example.demo.dto;


public class PersonDTO {

    private Long id;
    private String name;
    private String surname;
    private String phoneNumber;
    private String uniqueCode;
    private String letter;
    private Boolean isTakePartInDraw;
    private Boolean isSelected;

  /*  public PersonDTO toDTO(Person person)
    {
        PersonDTO personDTO = new PersonDTO();
        personDTO.setId(person.getId());
        personDTO.setName(person.getName());
        personDTO.setSurname(person.getSurname());
        personDTO.setPhoneNumber(person.getPhoneNumber());
        personDTO.setUniqueCode(person.getUniqueCode());
        personDTO.setTakePartInDraw(person.getTakePartInDraw());
        personDTO.setSelected(person.getSelected());

        return  personDTO;
    }

    public Person fromDTO(PersonDTO personDTO)
    {
        Person person = new Person();
        person.setId(personDTO.getId());
        person.setName(personDTO.getName());
        person.setSurname(personDTO.getSurname());
        person.setPhoneNumber(personDTO.getPhoneNumber());
        person.setUniqueCode(personDTO.getUniqueCode());
        person.setTakePartInDraw(personDTO.getTakePartInDraw());
        person.setSelected(personDTO.getSelected());

        return person;
    }*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUniqueCode() {
        return uniqueCode;
    }

    public void setUniqueCode(String uniqueCode) {
        this.uniqueCode = uniqueCode;
    }

    public Boolean getTakePartInDraw() {
        return isTakePartInDraw;
    }

    public void setTakePartInDraw(Boolean takePartInDraw) {
        isTakePartInDraw = takePartInDraw;
    }

    public Boolean getSelected() {
        return isSelected;
    }

    public void setSelected(Boolean selected) {
        isSelected = selected;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }
}
