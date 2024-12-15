package database;

import enumgenre.Genre;
import models.Actor;
import models.Movie;
import models.Producer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DataBase {
  public   static List<Actor> actorsR = new ArrayList<>(List.of(
            new Actor("Джони Деп","Турист"),
            new Actor("Тоби Магуайер","Ботаник"),
            new Actor("Брюс ли","Мастер"),
            new Actor("Джеки Чан","Полицейский"),
            new Actor("Уилл Смит","Повар"),
            new Actor("Арон Пол","Наркоман"),
            new Actor("Киллиан Мерфи","Ученый"),
            new Actor("Ван Дам","Гимнаст"),
            new Actor("Бред Пит","Продовец")
    ));

   public static  List<Movie> movies = new ArrayList<>(List.of(
                                               new Movie("Крутой Коп", LocalDate.of(2024,5,3), Genre.ACTION,new Producer("Девид","Джонс"), new ArrayList<>()),
                                               new Movie("Будний вечер",LocalDate.of(2004,7,4),Genre.COMEDY,new Producer("Адам","Сильва"),new ArrayList<>()),
                                               new Movie("Затеряный память",LocalDate.of(2010,9,2),Genre.BIOGRAPHY,new Producer("Стив","Эткинсон"),new ArrayList<>()),
                                               new Movie("Интервью с бобам",LocalDate.of(2015,10,1),Genre.DRAMA,new Producer("Хосе","Альдо"),new ArrayList<>()),
                                               new Movie("Молодая кровь",LocalDate.of(1999,8,6),Genre.HORROR,new Producer("Девид","Джонс"),new ArrayList<>())
                                               ));
}
