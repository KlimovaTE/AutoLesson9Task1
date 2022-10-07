package data;

import com.codeborne.selenide.conditions.Not;
import com.github.javafaker.Faker;
import lombok.SneakyThrows;
import lombok.Value;
import lombok.experimental.UtilityClass;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

@UtilityClass
public class DataGenerator {
    public static String generateDate(int shift) {
        // TODO: добавить логику для объявления переменной date и задания её значения, для генерации строки с датой
        // Вы можете использовать класс LocalDate и его методы для получения и форматирования даты
        String date = LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        return date;
    }

    public static String generateCity(String locale) throws IOException {
        // TODO: добавить логику для объявления переменной city и задания её значения, генерацию можно выполнить
        // с помощью Faker, либо используя массив валидных городов и класс Random
        Faker faker = new Faker(new Locale(locale));
        List<String> cities = List.of("Белгород", "Абакан", "Анадырь", "Архангельск", "Астрахань", "Барнаул", "Биробиджан", "Благовещенск", "Брянск", "Великий Новгород", "Владивкавказ", "Владивосток", "Владимир", "Волгоград", "Вологда", "Воронеж", "Горно-Алтайск", "Грозный", "Екатеринбург", "Иваново", "Ижевск", "Иркутск", "Йошкар-Ола", "Казань", "Калининград", "Калуга", "Кемерово", "Киров", "Кострома", "Краснодар", "Красноярск", "Курган", "Курск", "Кызыл", "Липецк", "Магадан", "Магас", "Майкоп", "Махачкала", "Москва", "Москва", "Мурманск", "Нальчик", "Нижний Новгород", "Новосибирск", "Омск", "Орел", "Оренбург", "Пенза", "Пермь", "Петрозаводск", "Петропавловск-Камчатский", "Псков", "Ростов", "Рязань", "Салехард", "Салехард", "Самара", "Санкт-Петербург", "Санкт-Петербург", "Саранск", "Саратов", "Смоленск", "Ставрополь", "Сыктывкар", "Тамбов", "Тверь", "Томск", "Тула", "Тюмень", "Улан-Удэ", "Ульяновск", "Уфа", "Хабаровск", "Ханты-мансийск", "Чебоксары", "Челябиннск", "Черкесск", "Чита", "Элиста", "Южно-Сахалинск", "Якутск", "Ярославль");
        String city = "faker.address().city()";
        while (!cities.contains(city)) {
            city = faker.address().city();
        }
        return city;
    }

    public static String generateName(String locale) {
        // TODO: добавить логику для объявления переменной name и задания её значения, для генерации можно
        // использовать Faker
        Faker faker = new Faker(new Locale(locale));
        String name = faker.name().fullName();
        return name;
    }

    public static String generatePhone(String locale) {
        // TODO: добавить логику для объявления переменной phone и задания её значения, для генерации можно
        // использовать Faker
        Faker faker = new Faker(new Locale(locale));
        String phone = faker.numerify("+7##########");
        return phone;
    }

    @UtilityClass
    public static class Registration {


        @SneakyThrows
        public static UserInfo generateUser(String locale) {
            // TODO: добавить логику для создания пользователя user с использованием методов generateCity(locale),
            // generateName(locale), generatePhone(locale)
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
