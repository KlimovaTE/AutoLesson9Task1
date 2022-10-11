package data;

import com.github.javafaker.Faker;
import lombok.Value;
import lombok.experimental.UtilityClass;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Random;

@UtilityClass
public class DataGenerator {
    public static String generateDate(int shift) {
        String date = LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        return date;
    }

    public static String generateCity(String locale) {
        List<String> cities = List.of("Белгород", "Абакан", "Анадырь", "Архангельск", "Астрахань", "Барнаул", "Биробиджан", "Благовещенск", "Брянск", "Великий Новгород", "Владивкавказ", "Владивосток", "Владимир", "Волгоград", "Вологда", "Воронеж", "Горно-Алтайск", "Грозный", "Екатеринбург", "Иваново", "Ижевск", "Иркутск", "Йошкар-Ола", "Казань", "Калининград", "Калуга", "Кемерово", "Киров", "Кострома", "Краснодар", "Красноярск", "Курган", "Курск", "Кызыл", "Липецк", "Магадан", "Магас", "Майкоп", "Махачкала", "Москва", "Москва", "Мурманск", "Нальчик", "Нижний Новгород", "Новосибирск", "Омск", "Орел", "Оренбург", "Пенза", "Пермь", "Петрозаводск", "Петропавловск-Камчатский", "Псков", "Ростов", "Рязань", "Салехард", "Салехард", "Самара", "Санкт-Петербург", "Санкт-Петербург", "Саранск", "Саратов", "Смоленск", "Ставрополь", "Сыктывкар", "Тамбов", "Тверь", "Томск", "Тула", "Тюмень", "Улан-Удэ", "Ульяновск", "Уфа", "Хабаровск", "Ханты-мансийск", "Чебоксары", "Челябиннск", "Черкесск", "Чита", "Элиста", "Южно-Сахалинск", "Якутск", "Ярославль");
        int size = cities.size();
        Random r = new Random();
        int x = r.nextInt(size);
        String city = cities.get(x);
        return city;
    }

    public static String generateName(String locale) {
        Faker faker = new Faker(new Locale(locale));
        String name = faker.name().fullName();
        return name;
    }

    public static String generatePhone(String locale) {
        Faker faker = new Faker(new Locale(locale));
        String phone = faker.numerify("+7##########");
        return phone;
    }

    @UtilityClass
    public static class Registration {


        public static UserInfo generateUser(String locale) {
            String city = DataGenerator.generateCity("ru");
            String name = DataGenerator.generateName("ru");
            String phone = DataGenerator.generatePhone("ru");
            UserInfo user = new UserInfo(city, name, phone);
            return user;
        }
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}
