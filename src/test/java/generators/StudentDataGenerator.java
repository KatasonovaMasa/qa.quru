package generators;

import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.Faker;
import model.StudentData;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class StudentDataGenerator {

    public static StudentData getRandomStudent() {
        Faker data = new Faker();

        File photo = new File("src/test/resources/pictures/QA.gif");
        String[] genders = new String[]{"Male", "Female", "Other"},
                hobbies = new String[]{"Sports", "Reading", "Music"},
                subjects = new String[]{"Accounting", "Maths", "Arts", "English", "Physics", "Chemistry", "Computer Science", "Economics", "Social Studies", "History", "Civics", "Commerce", "Hindi", "Biology"},
                citys = new String[]{"Delhi", "Gurgaon", "Noida"};

        String firstName = data.name().firstName(),
                lastName = data.name().lastName(),
                email = firstName + '.' + lastName + "@guru.ru",
                phone = data.phoneNumber().subscriberNumber(10),
                currAddress = data.address().streetAddress(),
                state = "NCR",
                gender = getRndValueArr(genders),
                hobby = getRndValueArr(hobbies),
                subject = getRndValueArr(subjects),
                city = getRndValueArr(citys);

        LocalDate birthday = data.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        String month = StringUtils.capitalize(birthday.getMonth().name().toLowerCase());
        String year = Integer.toString(birthday.getYear());
        String day = birthday.format(DateTimeFormatter.ofPattern("dd"));

        return new StudentData()
                .withFirstname(firstName)
                .withLastName(lastName)
                .withBirtDay(day)
                .withBirtMonth(month)
                .withBirtYear(year)
                .withEmail(email)
                .withNumberPhone(phone)
                .withGenders(gender)
                .withHobby(hobby)
                .withCurrAddress(currAddress)
                .withPhoto(String.valueOf(photo))
                .withSubject(subject)
                .withAddressState(state)
                .withAddressCity(city);
    }
        public static String getRndValueArr (String[]arr){
            int rnd = new Random().nextInt(arr.length);
            return arr[rnd];
    }
}
