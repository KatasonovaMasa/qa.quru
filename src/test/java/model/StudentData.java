package model;

import java.io.File;

public class StudentData {
    private String firstName,
            lastName,
            email,
            gender,
            phone,
            birtDay,
            birtMonth,
            birtYear,
            subject,
            hobby,
            photo,
            currAddress,
            state,
            city;

    public StudentData withFirstname(String firstname){
        this.firstName = firstname;
        return this;
    }
    public StudentData withLastName(String lastName){
        this.lastName = lastName;
        return this;
    }
    public StudentData withEmail(String email){
        this.email = email;
        return this;
    }
    public StudentData withGenders(String genders){
        this.gender = genders;
        return this;
    }
    public StudentData withNumberPhone(String numberPhone){
        this.phone = numberPhone;
        return this;
    }
    public StudentData withBirtDay(String birtDay){
        this.birtDay = birtDay;
        return this;
    }
    public StudentData withBirtMonth(String birtMonth){
        this.birtMonth = birtMonth;
        return this;
    }
    public StudentData withBirtYear(String birtYear){
        this.birtYear = birtYear;
        return this;
    }
    public StudentData withSubject(String subject){
        this.subject = subject;
        return this;
    }
    public StudentData withHobby(String hobby){
        this.hobby = hobby;
        return this;
    }
    public StudentData withPhoto(String photo){
        this.photo = photo;
        return this;
    }
    public StudentData withCurrAddress(String currAddress){
        this.currAddress = currAddress;
        return this;
    }
    public StudentData withAddressState(String state){
        this.state = state;
        return this;
    }
    public StudentData withAddressCity(String city){
        this.city = city;
        return this;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getEmail(){
        return email;
    }
    public String getGender(){
        return gender;
    }
    public String getPhone(){
        return phone;
    }
    public String getBirtDay(){
        return birtDay;
    }
    public String getBirtMonth(){
        return birtMonth;
    }
    public String getBirtYear(){
        return birtYear;
    }
    public String getSubject(){
        return subject;
    }
    public String getHobby(){
        return hobby;
    }
     public String getCurrAddress(){
        return currAddress;
    }
    public String getState(){
        return state;
    }
    public String getCity(){
        return city;
    }
    public File getPhoto(){
        return photo != null ? new File(photo) : null;
    }

    @Override
    public String toString() {
        return "StudentData{" +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", birthday='" + birtDay + "." + birtMonth + "." + birtMonth + '\'' +
                ", gender='" + gender + '\'' +
                ", hobby='" + hobby + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", address='" + currAddress + '\'' +
                ", subject='" + subject + '\'' +
                '}';
    }
}
