package menu;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public interface MenuInterface {


    default void addToMenu(Dish dish) throws IOException {}
    default String readMenu() throws FileNotFoundException {return "";}
    default void deleteFromMenu(int number) throws IOException {}
    default void changeAvailable(int number) throws IOException{}
    default ArrayList<Dish> readMoreMenu() throws IOException {
        return null;
    }


}
