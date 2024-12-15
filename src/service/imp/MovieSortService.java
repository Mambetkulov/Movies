package service.imp;

import database.DataBase;





public class MovieSortService implements service.MovieSortService {
    @Override
    public void sortMovieByName(String ascOrDesc) {
        if(ascOrDesc.equalsIgnoreCase("a")){
            DataBase.movies.sort((o1, o2) -> String.valueOf(o1.getName()).compareTo(o2.getName()));
        }else if (ascOrDesc.equalsIgnoreCase("d")){
            DataBase.movies.sort((o1, o2) -> String.valueOf(o2.getName()).compareTo(o1.getName()));
        }else{
            System.out.println("Invalid command");
        }
    }

    @Override
    public void sortByYear(String ascOrDesc) {

            if (ascOrDesc.equalsIgnoreCase("a")) {
                DataBase.movies.sort((o1, o2) -> Integer.valueOf(o1.getYear().getYear()).compareTo(o2.getYear().getYear()));
            } else if (ascOrDesc.equalsIgnoreCase("d")) {
                DataBase.movies.sort((o1, o2) -> Integer.valueOf(o2.getYear().getYear()).compareTo(o1.getYear().getYear()));
            }else {
                System.out.println("Invalid command");
            }

    }

    @Override
    public void sortByProducer(String nameOrlastName) {
        if(nameOrlastName.equalsIgnoreCase("F")){
            DataBase.movies.sort((o1, o2) -> String.valueOf(o1.getProducer().getFirstName()).compareTo(o2.getProducer().getFirstName()));
        }else if (nameOrlastName.equalsIgnoreCase("L")){
            DataBase.movies.sort((o1, o2) -> String.valueOf(o2.getProducer().getLastName()).compareTo(o1.getProducer().getLastName()));
        }else {
            System.out.println("Invalid Command");
        }
    }
}
