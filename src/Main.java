import database.DataBase;
import enumgenre.Genre;
import models.Actor;
import models.Movie;
import service.imp.MovieServiceImp;
import service.imp.MovieSortService;

import java.time.LocalDate;
import java.util.*;

public class Main {
   static Random ran = new Random();


    public static void main(String[] args) {
        Genre[] genres = {Genre.ACTION,Genre.BIOGRAPHY,Genre.COMEDY,Genre.DRAMA,Genre.HORROR};
        Scanner scan = new Scanner(System.in);
        Scanner scanN = new Scanner(System.in);
        MovieServiceImp movieServiceImp = new MovieServiceImp();
        MovieSortService movieSortService = new MovieSortService();
        int choice = 0;



     randomCast();

     boolean isTrue = true;
     while (isTrue){
         System.out.println("""
                 \n
                 press 1 to get all movies
                 press 2 to get movie by name
                 press 3 to get movie by actor name
                 press 4 to get movie by year
                 press 5 to get movie by producer
                 press 6 to get movie by genre
                 press 7 to get movie by role
                 press 8 to sort movies by name
                 press 9 to sort movies by year
                 press 10 to sort movies by producer
                 press 11 to exit
                 \n
                 """);
         try{
              choice = new Scanner(System.in).nextInt();
         }catch(InputMismatchException e){
             System.out.println("only numbers");
         }

         switch(choice){
             case 1 : {

                 System.out.println(movieServiceImp.getAllMovies());
                 break;
             }
             case 2 : {
                 System.out.println("enter movie name");
                 String name = scan.nextLine();
                 System.out.println( movieServiceImp.findMovieByFullNameOrPartName(name) == null ?
                                    "Movie with this name not found" : movieServiceImp.findMovieByFullNameOrPartName(name) );

                 break;
             }
             case 3 : {
                 System.out.println("enter actor full name");
                 String name = scan.nextLine();
                 System.out.println(movieServiceImp.findMovieByActorName(name).isEmpty() ?
                                   "Movies with this actor not found" : movieServiceImp.findMovieByActorName(name));

                 break;
             }
             case 4 : {
                 System.out.println("enter year");
                 int year = scanN.nextInt();
                 System.out.println("enter month");
                 int month = scanN.nextInt();
                 System.out.println("enter day");
                 int day = scanN.nextInt();

                 LocalDate data = LocalDate.of(year,month,day);
                 System.out.println( movieServiceImp.findMovieByYear(data) == null ?
                                    "Movies of this year not found" : movieServiceImp.findMovieByYear(data));

                 break;
             }
             case 5 : {
                 System.out.println("enter producer full name");
                 String name = scan.nextLine();
                 System.out.println(movieServiceImp.findMovieByProducer(name).isEmpty() ?
                                   "Movie with this producer not found" :  movieServiceImp.findMovieByProducer(name));

                 break;
             }
             case 6 : {
                 int count = 0;
                 for(Genre i : genres){
                     System.out.println(count + ")" + i + "\n");
                     count ++;
                 }
                 int index = 0;
                 try {
                      index = scanN.nextInt();
                 }catch (InputMismatchException s){
                     System.out.println("only numbers");
                 }
                 if(index < genres.length) {
                     System.out.println(movieServiceImp.findMovieByGenre(genres[index]) == null ?
                             "Movie with this genre not found" : movieServiceImp.findMovieByGenre(genres[index]));
                 }else{
                     System.out.println("Invalid command");
                 }
                 break;
             }
             case 7 : {
                 System.out.println("Enter role");
                 String role = scan.nextLine();
                 System.out.println( movieServiceImp.findMovieByRole(role) == null ?
                                    "Movie with this role not found" : movieServiceImp.findMovieByRole(role));
                 break;


             }
             case 8 : {

                 System.out.println("""
                         enter A to sort A-Z
                         enter D to sort Z-A
                         
                         """);
                 movieSortService.sortMovieByName(scan.nextLine());
                 break;
             }
             case 9 : {
                 System.out.println("""
                         enter A to sort by old year
                         enter D to sort by new year
                         
                         """);
                 movieSortService.sortByYear(scan.nextLine());
                 break;
             }
             case 10 : {
                 System.out.println("""
                         enter A to sort by name
                         enter D to sort by surname
                         
                         """);
                 movieSortService.sortByProducer(scan.nextLine());
                 break;

             }
             case 11 : {
                 isTrue = false;
                 break;
             }
             default:{
                 System.out.println("Invalid Command");
             }
         }

     }





    }

    public static void randomCast (){
        String copy = "";
        String copy2;

        for(Movie i : DataBase.movies){
            boolean isTrue = true;
            List<Actor> actor = new ArrayList<>();
            while (isTrue){
                int num = ran.nextInt(0,9);
                copy2 = ""+ num;

                if(!copy.contains(copy2)){
                    actor.add(DataBase.actorsR.get(num));
                }
                copy += "" + num;
                if(actor.size() == 3){
                   isTrue = false;
                }
            }
            copy = "";
            i.setActors(actor);
        }
    }
}