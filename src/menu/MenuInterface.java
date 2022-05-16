package menu;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface MenuInterface {


    default void createDish() throws IOException{}
    default String readMenu() throws FileNotFoundException {return "";}
    default void deleteFromMenu() throws IOException {}
    default void changeAvailable() throws IOException{}


}
